/******************************************************************************
 * Product: Adempiere ERP & CRM Smart Business Solution                       *
 * Copyright (C) 1999-2006 ComPiere, Inc. All Rights Reserved.                *
 * This program is free software; you can redistribute it and/or modify it    *
 * under the terms version 2 of the GNU General Public License as published   *
 * by the Free Software Foundation. This program is distributed in the hope   *
 * that it will be useful, but WITHOUT ANY WARRANTY; without even the implied *
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.           *
 * See the GNU General Public License for more details.                       *
 * You should have received a copy of the GNU General Public License along    *
 * with this program; if not, write to the Free Software Foundation, Inc.,    *
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA.                     *
 * For the text or an alternative of this public license, you may reach us    *
 * ComPiere, Inc., 2620 Augustine Dr. #245, Santa Clara, CA 95054, USA        *
 * or via info@compiere.org or http://www.compiere.org/license.html           *
 *****************************************************************************/
package org.compiere.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.StringTokenizer;
import java.util.logging.Level;

import javax.script.ScriptEngine;

import org.adempiere.base.Core;
import org.adempiere.base.event.EventManager;
import org.adempiere.base.event.EventProperty;
import org.adempiere.base.event.FactsEventData;
import org.adempiere.base.event.IEventManager;
import org.adempiere.base.event.IEventTopics;
import org.adempiere.base.event.ImportEventData;
import org.adempiere.base.event.LoginEventData;
import org.adempiere.exceptions.AdempiereException;
import org.adempiere.model.ImportValidator;
import org.adempiere.process.ImportProcess;
import org.compiere.acct.Fact;
import org.compiere.util.CLogger;
import org.compiere.util.Env;
import org.compiere.util.KeyNamePair;
import org.compiere.util.Util;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.launch.Framework;
import org.osgi.service.event.Event;

/**
 *	Model Validation Engine
 *
 *  @author Jorg Janke
 *  @version $Id: ModelValidationEngine.java,v 1.2 2006/07/30 00:58:38 jjanke Exp $
 *
 *  @author Teo Sarca, SC ARHIPAC SERVICE SRL
 * 				<li>FR [ 1670025 ] ModelValidator.afterLoadPreferences will be useful
 * 				<li>BF [ 1679692 ] fireDocValidate doesn't treat exceptions as errors
 * 				<li>FR [ 1724662 ] Support Email should contain model validators info
 * 				<li>FR [ 2788276 ] Data Import Validator
 * 					https://sourceforge.net/p/adempiere/feature-requests/712/
 * 				<li>BF [ 2804135 ] Global FactsValidator are not invoked
 * 					https://sourceforge.net/p/adempiere/bugs/1936/
 * 				<li>BF [ 2819617 ] NPE if script validator rule returns null
 * 					https://sourceforge.net/p/adempiere/bugs/1976/
 *  @author victor.perez@e-evolution.com, www.e-evolution.com
 * 				<li>BF [ 2947607 ] Model Validator Engine duplicate listeners
 */
public class ModelValidationEngine
{
	/**
	 * 	Get Singleton instance
	 *	@return singleton engine instance
	 */
	public synchronized static ModelValidationEngine get()
	{
		if (s_engine == null)
			s_engine = new ModelValidationEngine();
		return s_engine;
	}	//	get

	/** Engine Singleton				*/
	private static ModelValidationEngine s_engine = null;
	/** flag to indicate a missing model validation class */
	private String missingModelValidationMessage = "";

	/**
	 * 	Private Constructor.
	 * 	Use {@link #get()} to get the singleton instance.
	 */
	private ModelValidationEngine ()
	{
		super ();
		// Load global validators

		MTable table = MTable.get(Env.getCtx(), X_AD_ModelValidator.Table_ID);
		Query query = table.createQuery("IsActive='Y'", null);
		query.setOrderBy("SeqNo");
		try {
			List<X_AD_ModelValidator> entityTypes = query.list();
			for (X_AD_ModelValidator entityType : entityTypes)
			{
				String className = entityType.getModelValidationClass();
				if (className == null || className.length() == 0)
					continue;
				loadValidatorClass(null, className);
			}
		} catch (Exception e)
		{
			//logging to db will try to init ModelValidationEngine again!
			e.printStackTrace();
			missingModelValidationMessage = missingModelValidationMessage + e.toString() + " global" + '\n';
		}

		// Go through all Clients and start Validators
		MClient[] clients = MClient.getAll(Env.getCtx());
		for (int i = 0; i < clients.length; i++)
		{
			String classNames = clients[i].getModelValidationClasses();
			if (classNames == null || classNames.length() == 0)
				continue;
			loadValidatorClasses(clients[i], classNames);
		}
		if (    MSystem.get(Env.getCtx()).isFailOnMissingModelValidator()
			&& !Util.isEmpty(missingModelValidationMessage)) {
			// do not use severe, logging to db will try to init ModelValidationEngine again!
			System.out.println(missingModelValidationMessage);
			System.out.println("Terminating");
	        try {
	            BundleContext context = FrameworkUtil.getBundle(this.getClass()).getBundleContext();
	            context.getBundle(0).stop();
				if (context.getBundle(0) instanceof Framework framework)
					framework.waitForStop(60000);
			} catch (Exception e) {
			} finally {
				System.exit(1);
			}
		}

	}	//	ModelValidatorEngine

	/**
	 * Load validation instances
	 * @param client
	 * @param classNames Java class name list separated by semicolon
	 */
	private void loadValidatorClasses(MClient client, String classNames)
	{
		StringTokenizer st = new StringTokenizer(classNames, ";");
		while (st.hasMoreTokens())
		{
			String className = null;
			try
			{
				className = st.nextToken();
				if (className == null)
					continue;
				className = className.trim();
				if (className.length() == 0)
					continue;
				//
				loadValidatorClass(client, className);
			}
			catch (Exception e)
			{
				//logging to db will try to init ModelValidationEngine again!
				e.printStackTrace();
				missingModelValidationMessage = missingModelValidationMessage + e.toString() + " on tenant " + client.getName() + '\n';
			}
		}
	}

	/**
	 * Load validator instance
	 * @param client
	 * @param className
	 */
	private void loadValidatorClass(MClient client, String className) {
		try
		{
			//
			ModelValidator validator = null;
			validator = Core.getModelValidator(className);

			if (validator == null)
			{
				missingModelValidationMessage = missingModelValidationMessage + " Missing class " + className +
						 (client != null ? (" on tenant " + client.getName()) : " global") + '\n';
			}
			else
			{
				initialize(validator, client);
			}
		}
		catch (Exception e)
		{
			//logging to db will try to init ModelValidationEngine again!
			e.printStackTrace();
			missingModelValidationMessage = missingModelValidationMessage + e.toString() +
					 (client != null ? (" on tenant " + client.getName()) : " global") + '\n';
		}
	}

	/**	Logger					*/
	private static CLogger log = CLogger.getCLogger(ModelValidationEngine.class);

	/**	Validators						*/
	private ArrayList<ModelValidator>	m_validators = new ArrayList<ModelValidator>();
	/**	Model Change Listeners			*/
	private Hashtable<String,ArrayList<ModelValidator>>	m_modelChangeListeners = new Hashtable<String,ArrayList<ModelValidator>>();
	/**	Document Validation Listeners			*/
	private Hashtable<String,ArrayList<ModelValidator>>	m_docValidateListeners = new Hashtable<String,ArrayList<ModelValidator>>();
	/** Accounting Facts Validation Listeners   */
	private Hashtable<String,ArrayList<FactsValidator>>m_factsValidateListeners = new Hashtable<String,ArrayList<FactsValidator>>();
	/** Data Import Validation Listeners   */
	private Hashtable<String,ArrayList<ImportValidator>>m_impValidateListeners = new Hashtable<String,ArrayList<ImportValidator>>();

	private ArrayList<ModelValidator> m_globalValidators = new ArrayList<ModelValidator>();

	/**
	 * 	Initialize and add validator to global or client validator list.
	 *	@param validator
	 *	@param client null for global validator, not null for client specific validator
	 */
	private void initialize(ModelValidator validator, MClient client)
	{
		if (client == null)
			m_globalValidators.add(validator);
		m_validators.add(validator);
		validator.initialize(this, client);

	}	//	initialize

	/**
	 * 	Called when login is complete.<br/>
	 *  - Call {@link ModelValidator#login(int, int, int)} on register validators.
	 *  - Call script validator (AD_Table_ScriptValidator) <br/>
	 *  - Fire {@link IEventTopics#AFTER_LOGIN} OSGi event.
	 * 	@param AD_Client_ID client
	 *	@param AD_Org_ID org
	 *	@param AD_Role_ID role
	 *	@param AD_User_ID user
	 *	@return error message or null
	 */
	public String loginComplete (int AD_Client_ID, int AD_Org_ID, int AD_Role_ID, int AD_User_ID)
	{
		for (int i = 0; i < m_validators.size(); i++)
		{
			ModelValidator validator = m_validators.get(i);
			if (AD_Client_ID == validator.getAD_Client_ID()
				|| m_globalValidators.contains(validator))
			{
				String error = validator.login(AD_Org_ID, AD_Role_ID, AD_User_ID);
				if (error != null && error.length() > 0)
					return error;
			}
		}

		// now process the script model validator for login
		List<MRule> loginRules = MRule.getModelValidatorLoginRules (Env.getCtx());
		if (loginRules != null) {
			for (MRule loginRule : loginRules) {
				// currently just JSR 223 supported
				if (   loginRule.getRuleType().equals(MRule.RULETYPE_JSR223ScriptingAPIs)
					&& loginRule.getEventType().equals(MRule.EVENTTYPE_ModelValidatorLoginEvent)) {
					String error;
					try {
						ScriptEngine engine = loginRule.getScriptEngine();
						if (engine == null) {
							throw new AdempiereException("Engine not found: " + loginRule.getEngineName());
						}

						MRule.setContext(engine, Env.getCtx(), 0);  // no window
						// now add the method arguments to the engine
						engine.put(MRule.ARGUMENTS_PREFIX + "Ctx", Env.getCtx());
						engine.put(MRule.ARGUMENTS_PREFIX + "AD_Client_ID", AD_Client_ID);
						engine.put(MRule.ARGUMENTS_PREFIX + "AD_Org_ID", AD_Org_ID);
						engine.put(MRule.ARGUMENTS_PREFIX + "AD_Role_ID", AD_Role_ID);
						engine.put(MRule.ARGUMENTS_PREFIX + "AD_User_ID", AD_User_ID);

						Object retval = engine.eval(loginRule.getScript());
						error = (retval == null ? "" : retval.toString());
					} catch (Exception e) {
						e.printStackTrace();
						error = e.toString();
					}
					if (error != null && error.length() > 0)
						return error;
				}
			}
		}

		//now process osgi event handler
		LoginEventData eventData = new LoginEventData(AD_Client_ID, AD_Org_ID, AD_Role_ID, AD_User_ID);
		Event event = EventManager.newEvent(IEventTopics.AFTER_LOGIN, eventData);
		EventManager.getInstance().sendEvent(event);
		@SuppressWarnings("unchecked")
		List<String> errors = (List<String>) event.getProperty(IEventManager.EVENT_ERROR_MESSAGES);
		if (errors != null && !errors.isEmpty()) {
			Collections.reverse(errors);
			StringBuilder eventErrors = new StringBuilder("");
			for (String error : errors) {
				eventErrors.append(error).append("<br>");
			}
			return eventErrors.toString();
		}

		if (   !Util.isEmpty(missingModelValidationMessage)
			&& ! (   AD_Role_ID == SystemIDs.ROLE_SYSTEM
				  && (AD_User_ID == SystemIDs.USER_SYSTEM || AD_User_ID == SystemIDs.USER_SUPERUSER)))
			return missingModelValidationMessage;
		return null;
	}	//	loginComplete

	/**
	 * 	Add Model Change Listener for a table
	 *	@param tableName table name
	 *	@param listener listener (global or tenant specific)
	 */
	public void addModelChange (String tableName, ModelValidator listener)
	{
		if (tableName == null || listener == null)
			return;
		//
		String propertyName =
			m_globalValidators.contains(listener)
				? tableName + "*"
				: tableName + listener.getAD_Client_ID();
		ArrayList<ModelValidator> list = m_modelChangeListeners.get(propertyName);
		if (list == null)
		{
			list = new ArrayList<ModelValidator>();
			list.add(listener);
			m_modelChangeListeners.put(propertyName, list);
		}
		else
			list.add(listener);
	}	//	addModelValidator

	/**
	 * 	Remove Model Change Listener for a table
	 *	@param tableName table name
	 *	@param listener listener (global or tenant specific)
	 */
	public void removeModelChange (String tableName, ModelValidator listener)
	{
		if (tableName == null || listener == null)
			return;
		String propertyName =
			m_globalValidators.contains(listener)
				? tableName + "*"
				: tableName + listener.getAD_Client_ID();
		ArrayList<ModelValidator> list = m_modelChangeListeners.get(propertyName);
		if (list == null)
			return;
		list.remove(listener);
		if (list.size() == 0)
			m_modelChangeListeners.remove(propertyName);
	}	//	removeModelValidator

	/**
	 * 	Fire Model Change event of a table.
	 * 	- Call {@link ModelValidator#modelChange(PO, int)} on register validators.<br/>
	 *  - Call script validator (AD_Table_ScriptValidator) <br/>
	 *  - Fire IEventTopics.PO_* OSGi event.
	 *	@param po PO instance for the event
	 *	@param changeType ModelValidator.TYPE_*
	 *	@return error message or NULL for no veto
	 */
	public String fireModelChange (PO po, int changeType)
	{
		if (po == null )
			return null;

		String propertyName = po.get_TableName() + "*";
		ArrayList<ModelValidator> list = m_modelChangeListeners.get(propertyName);
		if (list != null)
		{
			//ad_entitytype.modelvalidationclasses
			String error = fireModelChange(po, changeType, list);
			if (error != null && error.length() > 0)
				return error;
		}

		propertyName = po.get_TableName() + po.getAD_Client_ID();
		list = m_modelChangeListeners.get(propertyName);
		if (list != null)
		{
			//ad_client.modelvalidationclasses
			String error = fireModelChange(po, changeType, list);
			if (error != null && error.length() > 0)
				return error;
		}

		// now process the script model validator for this event
		List<MTableScriptValidator> scriptValidators =
			MTableScriptValidator.getModelValidatorRules(
					po.getCtx(),
					po.get_Table_ID(),
					ModelValidator.tableEventValidators[changeType]);
		if (scriptValidators != null) {
			for (MTableScriptValidator scriptValidator : scriptValidators) {
				MRule rule = MRule.get(po.getCtx(), scriptValidator.getAD_Rule_ID());
				// currently just JSR 223 supported
				if (   rule != null
					&& rule.isActive()
					&& rule.getRuleType().equals(MRule.RULETYPE_JSR223ScriptingAPIs)
					&& rule.getEventType().equals(MRule.EVENTTYPE_ModelValidatorTableEvent)) {
					String error;
					try {
						ScriptEngine engine = rule.getScriptEngine();
						if (engine == null) {
							throw new AdempiereException("Engine not found: " + rule.getEngineName());
						}

						MRule.setContext(engine, po.getCtx(), 0);  // no window
						// now add the method arguments to the engine
						engine.put(MRule.ARGUMENTS_PREFIX + "Ctx", po.getCtx());
						engine.put(MRule.ARGUMENTS_PREFIX + "PO", po);
						engine.put(MRule.ARGUMENTS_PREFIX + "Type", changeType);
						engine.put(MRule.ARGUMENTS_PREFIX + "Event", ModelValidator.tableEventValidators[changeType]);

						Object retval = engine.eval(rule.getScript());
						error = (retval == null ? "" : retval.toString());
					} catch (Exception e) {
						e.printStackTrace();
						error = e.toString();
					}
					if (error != null && error.length() > 0)
						return error;
				}
			}
		}

		//now process osgi event handlers
		Event event = EventManager.newEvent(ModelValidator.tableEventTopics[changeType],
				new EventProperty(EventManager.EVENT_DATA, po), new EventProperty(EventManager.TABLE_NAME_PROPERTY, po.get_TableName()));
		EventManager.getInstance().sendEvent(event);
		@SuppressWarnings("unchecked")
		List<String> errors = (List<String>) event.getProperty(IEventManager.EVENT_ERROR_MESSAGES);
		if (errors != null && !errors.isEmpty()) {
			Collections.reverse(errors);
			StringBuilder eventErrors = new StringBuilder("");
			for (String error : errors) {
				eventErrors.append(error).append("<br>");
			}
			return eventErrors.toString();
		}

		return null;
	}	//	fireModelChange

	/**
	 * Fire model change event of a table.<br/>
	 * - Call {@link ModelValidator#modelChange(PO, int)} on register validators.
	 * @param po PO instance for the event
	 * @param changeType ModelValidator.TYPE_*
	 * @param list register validators
	 * @return error message or null
	 */
	private String fireModelChange(PO po, int changeType, ArrayList<ModelValidator> list)
	{
		for (int i = 0; i < list.size(); i++)
		{
			try
			{
				ModelValidator validator = list.get(i);
				if (validator.getAD_Client_ID() == po.getAD_Client_ID()
					|| m_globalValidators.contains(validator))
				{
					String error = validator.modelChange(po, changeType);
					if (error != null && error.length() > 0)
					{
						if (log.isLoggable(Level.FINE))
						{
							log.log(Level.FINE, "po="+po+" validator="+validator+" changeType="+changeType);
						}
						return error;
					}
				}
			}
			catch (Exception e)
			{
				//log the exception
				log.log(Level.SEVERE, e.getLocalizedMessage(), e);
				String error = e.getLocalizedMessage();
				if (error == null)
					error = e.toString();
				return error;
			}
		}
		return null;
	}

	/**
	 * 	Add Document Validation Listener for a table
	 *	@param tableName table name
	 *	@param listener listener (global or tenant specific)
	 */
	public void addDocValidate (String tableName, ModelValidator listener)
	{
		if (tableName == null || listener == null)
			return;
		//
		String propertyName =
			m_globalValidators.contains(listener)
				? tableName + "*"
				: tableName + listener.getAD_Client_ID();
		ArrayList<ModelValidator> list = m_docValidateListeners.get(propertyName);
		if (list == null)
		{
			list = new ArrayList<ModelValidator>();
			list.add(listener);
			m_docValidateListeners.put(propertyName, list);
		}
		else if (!list.contains(listener))
		{
		    list.add(listener);
		}
	}	//	addDocValidate

	/**
	 * 	Remove Document Validation Listener of a table
	 *	@param tableName table name
	 *	@param listener listener (global or tenant specific)
	 */
	public void removeDocValidate (String tableName, ModelValidator listener)
	{
		if (tableName == null || listener == null)
			return;
		String propertyName =
			m_globalValidators.contains(listener)
				? tableName + "*"
				: tableName + listener.getAD_Client_ID();
		ArrayList<ModelValidator> list = m_docValidateListeners.get(propertyName);
		if (list == null)
			return;
		list.remove(listener);
		if (list.size() == 0)
			m_docValidateListeners.remove(propertyName);
	}	//	removeDocValidate

	/**
	 * 	Fire Document Validation event of a table.<br/>
	 * 	- Call {@link ModelValidator#docValidate(PO, int)} on register validators.<br/>
	 *  - Call script validator (AD_Table_ScriptValidator) <br/>
	 *  - Fire IEventTopics.DOC_* OSGi event.
	 *	@param po PO instance for the event
	 *	@param docTiming see ModelValidator.TIMING_ constants
     *	@return error message or null
	 */
	public String fireDocValidate (PO po, int docTiming)
	{
		if (po == null)
			return null;

		String propertyName = po.get_TableName() + "*";
		ArrayList<ModelValidator> list = m_docValidateListeners.get(propertyName);
		if (list != null)
		{
			//ad_entitytype.modelvalidationclasses
			String error = fireDocValidate(po, docTiming, list);
			if (error != null && error.length() > 0)
				return error;
		}

		propertyName = po.get_TableName() + po.getAD_Client_ID();
		list = m_docValidateListeners.get(propertyName);
		if (list != null)
		{
			//ad_client.modelvalidationclasses
			String error = fireDocValidate(po, docTiming, list);
			if (error != null && error.length() > 0)
				return error;
		}

		// now process the script model validator for this event
		List<MTableScriptValidator> scriptValidators =
			MTableScriptValidator.getModelValidatorRules(
					po.getCtx(),
					po.get_Table_ID(),
					ModelValidator.documentEventValidators[docTiming]);
		if (scriptValidators != null) {
			for (MTableScriptValidator scriptValidator : scriptValidators) {
				MRule rule = MRule.get(po.getCtx(), scriptValidator.getAD_Rule_ID());
				// currently just JSR 223 supported
				if (   rule != null
					&& rule.isActive()
					&& rule.getRuleType().equals(MRule.RULETYPE_JSR223ScriptingAPIs)
					&& rule.getEventType().equals(MRule.EVENTTYPE_ModelValidatorDocumentEvent)) {
					String error;
					try {
						ScriptEngine engine = rule.getScriptEngine();
						if (engine == null) {
							throw new AdempiereException("Engine not found: " + rule.getEngineName());
						}

						MRule.setContext(engine, po.getCtx(), 0);  // no window
						// now add the method arguments to the engine
						engine.put(MRule.ARGUMENTS_PREFIX + "Ctx", po.getCtx());
						engine.put(MRule.ARGUMENTS_PREFIX + "PO", po);
						engine.put(MRule.ARGUMENTS_PREFIX + "Type", docTiming);
						engine.put(MRule.ARGUMENTS_PREFIX + "Event", ModelValidator.documentEventValidators[docTiming]);

						Object retval = engine.eval(rule.getScript());
						error = (retval == null ? "" : retval.toString());
					} catch (Exception e) {
						e.printStackTrace();
						error = e.toString();
					}
					if (error != null && error.length() > 0)
						return error;
				}
			}
		}

		//now process osgi event handlers
		Event event = EventManager.newEvent(ModelValidator.documentEventTopics[docTiming],
				new EventProperty(EventManager.EVENT_DATA, po), new EventProperty(EventManager.TABLE_NAME_PROPERTY, po.get_TableName()));
		EventManager.getInstance().sendEvent(event);
		@SuppressWarnings("unchecked")
		List<String> errors = (List<String>) event.getProperty(IEventManager.EVENT_ERROR_MESSAGES);
		if (errors != null && !errors.isEmpty()) {
			Collections.reverse(errors);
			StringBuilder eventErrors = new StringBuilder("");
			for (String error : errors) {
				eventErrors.append(error).append("<br>");
			}
			return eventErrors.toString();
		}
		return null;
	}	//	fireDocValidate

	/**
	 * Fire Document Validation event of a table.<br/>
	 * - Call {@link ModelValidator#docValidate(PO, int)} on register validators.
	 * @param po
	 * @param docTiming
	 * @param list register validators
	 * @return error message or null
	 */
	private String fireDocValidate(PO po, int docTiming, ArrayList<ModelValidator> list)
	{
		for (int i = 0; i < list.size(); i++)
		{
			ModelValidator validator = null;
			try
			{
				validator = list.get(i);
				if (validator.getAD_Client_ID() == po.getAD_Client_ID()
					|| m_globalValidators.contains(validator))
				{
					String error = validator.docValidate(po, docTiming);
					if (error != null && error.length() > 0)
					{
						if (log.isLoggable(Level.FINE))
						{
							log.log(Level.FINE, "po="+po+" validator="+validator+" timing="+docTiming);
						}
						return error;
					}
				}
			}
			catch (Exception e)
			{
				//log the stack trace
				log.log(Level.SEVERE, e.getLocalizedMessage(), e);
				// Exceptions are errors and should stop the document processing - teo_sarca [ 1679692 ]
				String error = e.getLocalizedMessage();
				if (error == null)
					error = e.toString();
				return error;
			}
		}
		return null;
	}

	/**
	 * 	Add Accounting Facts Validation Listener
	 *	@param tableName table name
	 *	@param listener listener (global or tenant specific)
	 */
	public void addFactsValidate (String tableName, FactsValidator listener)
	{
		if (tableName == null || listener == null)
			return;
		//
		String propertyName =
			(listener instanceof ModelValidator && m_globalValidators.contains((ModelValidator)listener))
				? tableName + "*"
				: tableName + listener.getAD_Client_ID();
		ArrayList<FactsValidator> list = m_factsValidateListeners.get(propertyName);
		if (list == null)
		{
			list = new ArrayList<FactsValidator>();
			list.add(listener);
			m_factsValidateListeners.put(propertyName, list);
		}
		else
			list.add(listener);
	}	//	addFactsValidate

	/**
	 * 	Add Import Validation Listener of an import table
	 *	@param importTableName table name
	 *	@param listener listener
	 */
	public void addImportValidate (String importTableName, ImportValidator listener)
	{
		String propertyName = importTableName + "*";
		ArrayList<ImportValidator> list = m_impValidateListeners.get(propertyName);
		if (list == null)
		{
			list = new ArrayList<ImportValidator>();
			list.add(listener);
			m_impValidateListeners.put(propertyName, list);
		}
		else
		{
			list.add(listener);
		}
	}

	/**
	 * 	Remove Accounting Facts Validation Listener of a table
	 *	@param tableName table name
	 *	@param listener listener
	 */
	public void removeFactsValidate (String tableName, FactsValidator listener)
	{
		if (tableName == null || listener == null)
			return;
		String propertyName =
			(listener instanceof ModelValidator && m_globalValidators.contains((ModelValidator)listener))
				? tableName + "*"
				: tableName + listener.getAD_Client_ID();
		ArrayList<FactsValidator> list = m_factsValidateListeners.get(propertyName);
		if (list == null)
			return;
		list.remove(listener);
		if (list.size() == 0)
			m_factsValidateListeners.remove(propertyName);
	}	//	removeFactsValidate

	/**
	 * Fire Accounting Facts Validation event of a table.<br/>
	 * - Call {@link FactsValidator#factsValidate(MAcctSchema, List, PO)} on register validators.<br/>
	 * - Fire {@link IEventTopics#ACCT_FACTS_VALIDATE} OSGi event.
	 * @param schema
	 * @param facts
	 * @param po PO instance of event
	 * @return error message or null
	 */
	public String fireFactsValidate (MAcctSchema schema, List<Fact> facts, PO po)
	{
		if (schema == null || facts == null || po == null)
			return null;

		String propertyName = po.get_TableName() + "*";
		ArrayList<FactsValidator> list = m_factsValidateListeners.get(propertyName);
		if (list != null)
		{
			//ad_entitytype.modelvalidationclasses
			String error = fireFactsValidate(schema, facts, po, list);
			if (error != null && error.length() > 0)
				return error;
		}

		propertyName = po.get_TableName() + po.getAD_Client_ID();
		list = m_factsValidateListeners.get(propertyName);
		if (list != null)
		{
			//ad_client.modelvalidationclasses
			String error = fireFactsValidate(schema, facts, po, list);
			if (error != null && error.length() > 0)
				return error;
		}

		//process osgi event handlers
		FactsEventData eventData = new FactsEventData(schema, facts, po);
		Event event = EventManager.newEvent(IEventTopics.ACCT_FACTS_VALIDATE,
				new EventProperty(EventManager.EVENT_DATA, eventData), new EventProperty(EventManager.TABLE_NAME_PROPERTY, po.get_TableName()));
		EventManager.getInstance().sendEvent(event);
		@SuppressWarnings("unchecked")
		List<String> errors = (List<String>) event.getProperty(IEventManager.EVENT_ERROR_MESSAGES);
		if (errors != null && !errors.isEmpty()) {
			Collections.reverse(errors);
			StringBuilder eventErrors = new StringBuilder("");
			for (String error : errors) {
				eventErrors.append(error).append("<br>");
			}
			return eventErrors.toString();
		}

		return null;
	}	//	fireFactsValidate

	/**
	 * Fire Accounting Facts Validation event of a table.<br/>
	 * - Call {@link FactsValidator#factsValidate(MAcctSchema, List, PO)} on register validators.
	 * @param schema
	 * @param facts
	 * @param po PO instance of event
	 * @param list register validators
	 * @return error message or null
	 */
	private String fireFactsValidate(MAcctSchema schema, List<Fact> facts, PO po,  ArrayList<FactsValidator> list)
	{
		for (int i = 0; i < list.size(); i++)
		{
			FactsValidator validator = null;
			try
			{
				validator = list.get(i);
				if (validator.getAD_Client_ID() == po.getAD_Client_ID()
						|| (validator instanceof ModelValidator && m_globalValidators.contains((ModelValidator)validator)))
				{
					String error = validator.factsValidate(schema, facts, po);
					if (error != null && error.length() > 0)
					{
						if (log.isLoggable(Level.FINE))
						{
							log.log(Level.FINE, "po="+po+" schema="+schema+" validator="+validator);
						}
						return error;
					}
				}
			}
			catch (Exception e)
			{
				//log the stack trace
				log.log(Level.SEVERE, e.getLocalizedMessage(), e);
				// Exceptions are errors and should stop the document processing - teo_sarca [ 1679692 ]
				String error = e.getLocalizedMessage();
				if (error == null)
					error = e.toString();
				return error;
			}
		}
		return null;
	}

	/**
	 * Fire Import Validation event.<br/>
	 * - Call {@link ImportValidator#validate(ImportProcess, Object, Object, int)} on registered validators.<br/>
	 * - Fire IEventTopics.IMPORT_* OSGi event.
	 * @param process import process
	 * @param importModel import record (e.g. X_I_BPartner)
	 * @param targetModel target model (e.g. MBPartner, MBPartnerLocation, MUser)
	 * @param timing see ImportValidator.TIMING_* constants
	 */
	public void fireImportValidate (ImportProcess process, PO importModel, PO targetModel, int timing)
	{

		String propertyName = process.getImportTableName() + "*";
		ArrayList<ImportValidator> list = m_impValidateListeners.get(propertyName);
		if (list != null)
		{
			for (ImportValidator validator : list)
			{
				validator.validate(process, importModel, targetModel, timing);
			}
		}

		//osgi event handler
		ImportEventData eventData = new ImportEventData(process, importModel, targetModel);
		String topic = null;
		if (timing == ImportValidator.TIMING_AFTER_IMPORT)
			topic = IEventTopics.IMPORT_AFTER_IMPORT;
		else if (timing == ImportValidator.TIMING_AFTER_VALIDATE)
			topic = IEventTopics.IMPORT_AFTER_VALIDATE;
		else if (timing == ImportValidator.TIMING_BEFORE_IMPORT)
			topic = IEventTopics.IMPORT_BEFORE_IMPORT;
		else if (timing == ImportValidator.TIMING_BEFORE_VALIDATE)
			topic = IEventTopics.IMPORT_BEFORE_VALIDATE;
		Event event = EventManager.newEvent(topic, new EventProperty(EventManager.EVENT_DATA, eventData), 
				new EventProperty(EventManager.IMPORT_TABLE_NAME_PROPERTY, process.getImportTableName()));
		EventManager.getInstance().sendEvent(event);
	}

	/**
	 * 	String Representation
	 *	@return info
	 */
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder("ModelValidationEngine[");
		sb.append("Validators=#").append(m_validators.size())
			.append(", ModelChange=#").append(m_modelChangeListeners.size())
			.append(", DocValidate=#").append(m_docValidateListeners.size())
			.append("]");
		return sb.toString();
	}	//	toString

	/**
	 *  Get Model Validation Engine Info
	 *  @param sb optional string buffer
	 *  @param ctx context
	 *  @return Model Validation Engine Info
	 *
	 *  author Teo Sarca, FR [ 1724662 ]
	 */
	public StringBuffer getInfoDetail(StringBuffer sb, Properties ctx) {
		if (sb == null)
			sb = new StringBuffer();
		sb.append("=== ModelValidationEngine ===").append(Env.NL);
		sb.append("Validators #").append(m_validators.size()).append(Env.NL);
		for (ModelValidator mv : m_validators) {
			sb.append(mv.toString()).append(Env.NL);
		}
		sb.append(Env.NL).append(Env.NL);
		//
		sb.append("ModelChange #").append(m_modelChangeListeners.size()).append(Env.NL);
		Iterator<String> it = m_modelChangeListeners.keySet().iterator();
		while(it.hasNext()) {
			String key = it.next();
			ArrayList<ModelValidator> list = m_modelChangeListeners.get(key);
			for (ModelValidator mv : list) {
				sb.append(key).append(": ").append(mv.toString()).append(Env.NL);
			}
		}
		sb.append(Env.NL).append(Env.NL);
		//
		sb.append("DocValidate #").append(m_docValidateListeners.size()).append(Env.NL);
		it = m_docValidateListeners.keySet().iterator();
		while(it.hasNext()) {
			String key = it.next();
			ArrayList<ModelValidator> list = m_docValidateListeners.get(key);
			for (ModelValidator mv : list) {
				sb.append(key).append(": ").append(mv.toString()).append(Env.NL);
			}
		}
		sb.append(Env.NL).append(Env.NL);
		//
		return sb;
	}

	/**
	 * After Load Preferences into Context for selected client. <br/>
	 * Fire afterLoadPreferences model validator event and {@link IEventTopics#PREF_AFTER_LOAD} OSGi event.
	 * @param ctx context
	 * @see org.compiere.util.Login#loadPreferences(KeyNamePair, KeyNamePair, java.sql.Timestamp, String)
	 * author Teo Sarca - FR [ 1670025 ] - https://sourceforge.net/p/adempiere/feature-requests/78/
	 */
	public void afterLoadPreferences (Properties ctx)
	{
		int AD_Client_ID = Env.getAD_Client_ID(ctx);
		for (int i = 0; i < m_validators.size(); i++)
		{
			ModelValidator validator = m_validators.get(i);
			if (AD_Client_ID == validator.getAD_Client_ID()
				|| m_globalValidators.contains(validator))
			{
				java.lang.reflect.Method m = null;
				try {
					m = validator.getClass().getMethod("afterLoadPreferences", new Class[]{Properties.class});
				}
				catch(NoSuchMethodException e) {
					// ignore
				}
				try {
					if (m != null)
						m.invoke(validator, ctx);
				}
				catch (Exception e) {
					log.warning("" + validator + ": " + e.getLocalizedMessage());
				}
			}
		}

		//osgi event handlers
		Event event = new Event(IEventTopics.PREF_AFTER_LOAD, (Map<String, ?>)null);
		EventManager.getInstance().sendEvent(event);
	}

	/**
	 * Before Save Properties for selected client.
	 * @deprecated for deprecated swing client only
	 */
	@Deprecated
	public void beforeSaveProperties ()
	{
		int AD_Client_ID = Env.getAD_Client_ID(Env.getCtx());
		for (int i = 0; i < m_validators.size(); i++)
		{
			ModelValidator validator = m_validators.get(i);
			if (AD_Client_ID == validator.getAD_Client_ID()
				|| m_globalValidators.contains(validator))
			{
				java.lang.reflect.Method m = null;
				try {
					m = validator.getClass().getMethod("beforeSaveProperties");
				}
				catch(NoSuchMethodException e) {
					// ignore
				}
				try {
					if (m != null)
						m.invoke(validator);
				}
				catch (Exception e) {
					log.warning("" + validator + ": " + e.getLocalizedMessage());
				}
			}
		}
	}
}	//	ModelValidatorEngine
