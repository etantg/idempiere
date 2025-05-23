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
package org.compiere.process;

import java.io.File;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;

import org.adempiere.base.event.EventManager;
import org.adempiere.base.event.EventProperty;
import org.adempiere.base.event.IEventTopics;
import org.adempiere.exceptions.AdempiereException;
import org.compiere.acct.Doc;
import org.compiere.model.MAcctSchema;
import org.compiere.model.MAllocationHdr;
import org.compiere.model.MBankStatement;
import org.compiere.model.MBankTransfer;
import org.compiere.model.MCash;
import org.compiere.model.MClient;
import org.compiere.model.MColumn;
import org.compiere.model.MInOut;
import org.compiere.model.MInventory;
import org.compiere.model.MInvoice;
import org.compiere.model.MJournal;
import org.compiere.model.MJournalBatch;
import org.compiere.model.MMovement;
import org.compiere.model.MOrder;
import org.compiere.model.MPayment;
import org.compiere.model.MProduction;
import org.compiere.model.MRMA;
import org.compiere.model.MRole;
import org.compiere.model.MTable;
import org.compiere.model.PO;
import org.compiere.model.SystemIDs;
import org.compiere.util.CLogger;
import org.compiere.util.DB;
import org.compiere.util.Env;
import org.compiere.util.Msg;
import org.compiere.util.Util;
import org.eevolution.model.I_DD_Order;
import org.eevolution.model.I_HR_Process;
import org.eevolution.model.I_PP_Cost_Collector;
import org.eevolution.model.I_PP_Order;
import org.osgi.service.event.Event;
import org.compiere.model.MDepositBatch;
import org.compiere.model.MDocType;

/**
 *	Document Action Engine
 *
 *  @author Jorg Janke
 *  @author Karsten Thiemann FR [ 1782412 ]
 *  @author victor.perez@e-evolution.com www.e-evolution.com FR [ 1866214 ]  https://sourceforge.net/p/adempiere/feature-requests/298/
 *  @version $Id: DocumentEngine.java,v 1.2 2006/07/30 00:54:44 jjanke Exp $
 */
public class DocumentEngine implements DocAction
{
	/**
	 * When client accounting is immediate, set this PO attribute to override the default of immediate posting after complete of document
	 */
	public static final String DOCUMENT_POST_IMMEDIATE_AFTER_COMPLETE = "Document.PostImmediateAfterComplete";

	/**
	 * 	Doc Engine (Drafted)
	 * 	@param po document
	 */
	public DocumentEngine (DocAction po)
	{
		this (po, STATUS_Drafted);
	}	//	DocActionEngine

	/**
	 * 	Doc Engine
	 * 	@param po document
	 * 	@param docStatus initial document status
	 */
	public DocumentEngine (DocAction po, String docStatus)
	{
		m_document = po;
		if (docStatus != null)
			m_status = docStatus;
	}	//	DocActionEngine

	/** Persistent Document 	*/
	private DocAction	m_document;
	/** Document Status			*/
	private String		m_status = STATUS_Drafted;
	/**	Process Message 		*/
	private String		m_message = null;
	/** Actual Doc Action		*/
	private String		m_action = null;

	/**	Logger			*/
	private static CLogger log = CLogger.getCLogger(DocumentEngine.class);

	/**
	 * 	Get Doc Status
	 *	@return document status
	 */
	@Override
	public String getDocStatus()
	{
		return m_status;
	}	//	getDocStatus

	/**
	 * 	Set Doc Status - Ignored
	 *	@param ignored Status is not set directly
	 *  @see org.compiere.process.DocAction#setDocStatus(String)
	 */
	@Override
	public void setDocStatus(String ignored)
	{
	}	//	setDocStatus

	/**
	 * 	Is current Document Status is Drafted
	 *	@return true if current status is drafted
	 */
	public boolean isDrafted()
	{
		return STATUS_Drafted.equals(m_status);
	}	//	isDrafted

	/**
	 * 	Is current Document Status is Invalid
	 *	@return true if current status is Invalid
	 */
	public boolean isInvalid()
	{
		return STATUS_Invalid.equals(m_status);
	}	//	isInvalid

	/**
	 * 	Is current Document Status is In Progress
	 *	@return true if current status is In Progress
	 */
	public boolean isInProgress()
	{
		return STATUS_InProgress.equals(m_status);
	}	//	isInProgress

	/**
	 * 	Is current Document Status is Approved
	 *	@return true if current status is Approved
	 */
	public boolean isApproved()
	{
		return STATUS_Approved.equals(m_status);
	}	//	isApproved

	/**
	 * 	Is current Document Status is Not Approved
	 *	@return true if current status is Not Approved
	 */
	public boolean isNotApproved()
	{
		return STATUS_NotApproved.equals(m_status);
	}	//	isNotApproved

	/**
	 * 	Is current Document Status is Waiting Payment or Confirmation
	 *	@return true if current status is Waiting Payment
	 */
	public boolean isWaiting()
	{
		return STATUS_WaitingPayment.equals(m_status)
			|| STATUS_WaitingConfirmation.equals(m_status);
	}	//	isWaitingPayment

	/**
	 * 	Is current Document Status is Completed
	 *	@return true if current status is Completed
	 */
	public boolean isCompleted()
	{
		return STATUS_Completed.equals(m_status);
	}	//	isCompleted

	/**
	 * 	Is current Document Status is Reversed
	 *	@return true if current status is Reversed
	 */
	public boolean isReversed()
	{
		return STATUS_Reversed.equals(m_status);
	}	//	isReversed

	/**
	 * 	Is current Document Status is Closed
	 *	@return true if current status is Closed
	 */
	public boolean isClosed()
	{
		return STATUS_Closed.equals(m_status);
	}	//	isClosed

	/**
	 * 	Is current Document Status is Voided
	 *	@return true if current status is Voided
	 */
	public boolean isVoided()
	{
		return STATUS_Voided.equals(m_status);
	}	//	isVoided

	/**
	 * 	Is current Document Status is Unknown
	 *	@return true if current status is unknown
	 */
	public boolean isUnknown()
	{
		return STATUS_Unknown.equals(m_status) ||
			!(isDrafted() || isInvalid() || isInProgress() || isNotApproved()
				|| isApproved() || isWaiting() || isCompleted()
				|| isReversed() || isClosed() || isVoided() );
	}	//	isUnknown

	/**
	 * 	Process document action.<br/>
	 * 	Checks if user (document) action is valid and then process action.<br/>
	 * 	Calls the individual actions which call the document action.
	 *	@param processAction document action value from workflow
	 *	@param docAction document action value from document (PO)
	 *	@return true if performed
	 */
	public boolean processIt (String processAction, String docAction)
	{
		//ensure doc status not change by other session
		if (m_document instanceof PO) {
			PO docPO = (PO) m_document;
			if (docPO.get_ID() > 0 && docPO.get_TrxName() != null && docPO.get_ValueOld("DocStatus") != null) {
				DB.getDatabase().forUpdate(docPO, 30);
				String docStatusOriginal = (String) docPO.get_ValueOld("DocStatus");
				String statusSql = "SELECT DocStatus FROM " + docPO.get_TableName() + " WHERE " + docPO.get_KeyColumns()[0] + " = ? ";
				String currentStatus = DB.getSQLValueString((String)null, statusSql, docPO.get_ID());
				if (!docStatusOriginal.equals(currentStatus) && currentStatus != null) {
					currentStatus = DB.getSQLValueString(docPO.get_TrxName(), statusSql, docPO.get_ID());
					if (!docStatusOriginal.equals(currentStatus)) {
						throw new IllegalStateException(Msg.getMsg(docPO.getCtx(), "DocStatusChanged") + " " + docPO.toString());
					}
				}
			}
		}
				
		m_message = null;
		m_action = null;
		//	Std User Workflows - see MWFNodeNext.isValidFor

		if (isValidAction(processAction))	//	WF Selection first
			m_action = processAction;
		//
		else if (isValidAction(docAction))	//	User Selection second
			m_action = docAction;
		//	Nothing to do
		else if (processAction.equals(ACTION_None)
			|| docAction.equals(ACTION_None))
		{
			if (m_document != null)
				m_document.get_Logger().info ("**** No Action (Prc=" + processAction + "/Doc=" + docAction + ") " + m_document);
			return true;
		}
		else
		{
			throw new IllegalStateException("Status=" + getDocStatus()
				+ " - Invalid Actions: Process="  + processAction + ", Doc=" + docAction);
		}
		if (m_document != null && m_document.get_Logger().isLoggable(Level.INFO))
				m_document.get_Logger().info ("**** Action=" + m_action + " (Prc=" + processAction + "/Doc=" + docAction + ") " + m_document);
		boolean success = processIt (m_action);
		if (m_document != null && m_document.get_Logger().isLoggable(Level.FINE))
			m_document.get_Logger().fine("**** Action=" + m_action + " - Success=" + success);
		return success;
	}	//	process

	/**
	 * 	Process document action - internal API, do not call directly.<br/>
	 * 	Calls the individual actions which call the document action.
	 *	@param action document action
	 *	@return true if performed
	 */
	@Override
	public boolean processIt (String action)
	{
		m_message = null;
		m_action = action;
		//
		if (ACTION_Unlock.equals(m_action))
			return unlockIt();
		if (ACTION_Invalidate.equals(m_action))
			return invalidateIt();
		if (ACTION_Prepare.equals(m_action))
			return STATUS_InProgress.equals(prepareIt());
		if (ACTION_Approve.equals(m_action))
			return approveIt();
		if (ACTION_Reject.equals(m_action))
			return rejectIt();
		if (ACTION_Complete.equals(m_action) || ACTION_WaitComplete.equals(m_action))
		{
			String status = null;
			if (isDrafted() || isInvalid())		//	prepare if not prepared yet
			{
				status = prepareIt();
				if (!STATUS_InProgress.equals(status))
					return false;
			}
			status = completeIt();
			boolean ok =   STATUS_Completed.equals(status)
						|| STATUS_InProgress.equals(status)
						|| STATUS_WaitingPayment.equals(status)
						|| STATUS_WaitingConfirmation.equals(status);
			if (m_document != null && ok)
			{
				// PostProcess documents when invoice or inout (this is to postprocess the generated MatchPO and MatchInv if any)
				List<PO> docsPostProcess = new ArrayList<PO>();
				if (m_document instanceof IDocsPostProcess) {
					docsPostProcess = ((IDocsPostProcess) m_document).getDocsPostProcess(); 
				}
				if (m_document instanceof PO && docsPostProcess.size() > 0) {
					// Process (this is to update the ProcessedOn flag with a timestamp after the original document)
					for (PO docafter : docsPostProcess) {
						docafter.setProcessedOn("Processed", true, false);
						docafter.saveEx();
					}
				}

				if (STATUS_Completed.equals(status) && MClient.isClientAccountingImmediate())
				{
					boolean postNow = true;
					if (m_document instanceof PO)
					{
						Object attribute = ((PO) m_document).get_Attribute(DOCUMENT_POST_IMMEDIATE_AFTER_COMPLETE);
						if (attribute != null && attribute instanceof Boolean)
						{
							postNow = (boolean) attribute;
						}
					}
					
					if (postNow)
					{
						m_document.saveEx();
						postIt();
	
						if (m_document instanceof PO && docsPostProcess.size() > 0) {
							for (PO docafter : docsPostProcess) {								
								if (docafter.get_ValueAsBoolean("Posted"))
									continue;
								String ignoreError = DocumentEngine.postImmediate(docafter.getCtx(), docafter.getAD_Client_ID(), docafter.get_Table_ID(), docafter.get_ID(), true, docafter.get_TrxName());
								if (!Util.isEmpty(ignoreError, true)) {
									log.warning("Error posting " + docafter + ". Error="+ignoreError);
								} else {
									docafter.load(docafter.get_TrxName());
								}
							}
						}
					}
				}

			}
			return ok;
		}
		if (ACTION_ReActivate.equals(m_action))
			return reActivateIt();
		if (ACTION_Reverse_Accrual.equals(m_action) || ACTION_Reverse_Correct.equals(m_action))
		{
			boolean ok = false;
			if (ACTION_Reverse_Accrual.equals(m_action))
				ok = reverseAccrualIt();
			else if (ACTION_Reverse_Correct.equals(m_action))
				ok = reverseCorrectIt();
			
			if (m_document != null && ok)
			{
				if (MClient.isClientAccountingImmediate() && m_document instanceof IDocsPostProcess && m_document instanceof PO)
				{
					List<PO> docsPostProcess = ((IDocsPostProcess) m_document).getDocsPostProcess(); 
					if (docsPostProcess.size() > 0) {
						if (((PO) m_document).get_ValueAsBoolean("Posted")) {
							for (PO docafter : docsPostProcess) {								
								if (docafter.get_ValueAsBoolean("Posted"))
									continue;
								String ignoreError = DocumentEngine.postImmediate(docafter.getCtx(), docafter.getAD_Client_ID(), docafter.get_Table_ID(), docafter.get_ID(), true, docafter.get_TrxName());
								if (!Util.isEmpty(ignoreError, true)) {
									log.warning("Error posting " + docafter + ". Error="+ignoreError);
								} else {
									docafter.load(docafter.get_TrxName());
								}
							}
						}
					}				
				}
			}
			
			return ok;
		}
		if (ACTION_Close.equals(m_action))
			return closeIt();
		if (ACTION_Void.equals(m_action))
			return voidIt();
		if (ACTION_Post.equals(m_action))
			return postIt();
		//
		return false;
	}	//	processDocument

	/**
	 * 	Unlock Document.<br/>
	 * 	Status: Drafted.
	 * 	@return true if success
	 * 	@see org.compiere.process.DocAction#unlockIt()
	 */
	@Override
	public boolean unlockIt()
	{
		if (!isValidAction(ACTION_Unlock))
			return false;
		if (m_document != null)
		{
			if (m_document.unlockIt())
			{
				m_status = STATUS_Drafted;
				m_document.setDocStatus(m_status);
				return true;
			}
			return false;
		}
		m_status = STATUS_Drafted;
		return true;
	}	//	unlockIt

	/**
	 * 	Invalidate Document.<br/>
	 * 	Status: Invalid.
	 * 	@return true if success
	 * 	@see org.compiere.process.DocAction#invalidateIt()
	 */
	@Override
	public boolean invalidateIt()
	{
		if (!isValidAction(ACTION_Invalidate))
			return false;
		if (m_document != null)
		{
			if (m_document.invalidateIt())
			{
				m_status = STATUS_Invalid;
				m_document.setDocStatus(m_status);
				return true;
			}
			return false;
		}
		m_status = STATUS_Invalid;
		return true;
	}	//	invalidateIt

	/**
	 *	Prepare Document.<br/>
	 * 	Status is set by document action method.
	 * 	@return new status (In Progress or Invalid)
	 * 	@see org.compiere.process.DocAction#prepareIt()
	 */
	@Override
	public String prepareIt()
	{
		if (!isValidAction(ACTION_Prepare))
			return m_status;
		if (m_document != null)
		{
			m_status = m_document.prepareIt();
			m_document.setDocStatus(m_status);
		}
		return m_status;
	}	//	processIt

	/**
	 * 	Approve Document.<br/>
	 * 	Status: Approved.
	 * 	@return true if success
	 * 	@see org.compiere.process.DocAction#approveIt()
	 */
	@Override
	public boolean  approveIt()
	{
		if (!isValidAction(ACTION_Approve))
			return false;
		if (m_document != null)
		{
			if (m_document.approveIt())
			{
				m_status = STATUS_Approved;
				m_document.setDocStatus(m_status);
				return true;
			}
			return false;
		}
		m_status = STATUS_Approved;
		return true;
	}	//	approveIt

	/**
	 * 	Reject Approval.<br/>
	 * 	Status: Not Approved.
	 * 	@return true if success
	 * 	@see org.compiere.process.DocAction#rejectIt()
	 */
	@Override
	public boolean rejectIt()
	{
		if (!isValidAction(ACTION_Reject))
			return false;
		if (m_document != null)
		{
			if (m_document.rejectIt())
			{
				m_status = STATUS_NotApproved;
				m_document.setDocStatus(m_status);
				return true;
			}
			return false;
		}
		m_status = STATUS_NotApproved;
		return true;
	}	//	rejectIt

	/**
	 * 	Complete Document.<br/>
	 * 	Status is set by document action method.
	 * 	@return new document status (Complete, In Progress, Invalid, Waiting ..)
	 * 	@see org.compiere.process.DocAction#completeIt()
	 */
	@Override
	public String completeIt()
	{
		if (!isValidAction(ACTION_Complete))
			return m_status;
		if (m_document != null)
		{
			m_status = m_document.completeIt();
			m_document.setDocStatus(m_status);
		}
		return m_status;
	}	//	completeIt

	/**
	 * 	Post Document.<br/>
	 * 	Does not change status.
	 * 	@return true if success
	 */
	public boolean postIt()
	{
		if (!isValidAction(ACTION_Post)
			|| m_document == null)
			return false;

		String error = DocumentEngine.postImmediate(Env.getCtx(), m_document.getAD_Client_ID(), m_document.get_Table_ID(), m_document.get_ID(), true, m_document.get_TrxName());
		if (ACTION_Post.equals(m_action)) {
			// forced post via process - throw exception to inform the caller about the error
			if (! Util.isEmpty(error)) {
				throw new AdempiereException(error);
			}
		}
		return (error == null);
	}	//	postIt

	/**
	 * 	Void Document.<br/>
	 * 	Status: Voided.
	 * 	@return true if success
	 * 	@see org.compiere.process.DocAction#voidIt()
	 */
	@Override
	public boolean voidIt()
	{
		if (!isValidAction(ACTION_Void))
			return false;
		if (m_document != null)
		{
			if (m_document.voidIt())
			{
				m_status = STATUS_Voided;
				if (!m_document.getDocStatus().equals(STATUS_Reversed))
					m_document.setDocStatus(m_status);
				return true;
			}
			return false;
		}
		m_status = STATUS_Voided;
		return true;
	}	//	voidIt

	/**
	 * 	Close Document.<br/>
	 * 	Status: Closed.
	 * 	@return true if success
	 * 	@see org.compiere.process.DocAction#closeIt()
	 */
	@Override
	public boolean closeIt()
	{
		if (m_document != null 	//	orders can be closed any time
			&& m_document.get_Table_ID() == MOrder.Table_ID)
			;
		else if (!isValidAction(ACTION_Close))
			return false;
		if (m_document != null)
		{
			if (m_document.closeIt())
			{
				m_status = STATUS_Closed;
				m_document.setDocStatus(m_status);
				return true;
			}
			return false;
		}
		m_status = STATUS_Closed;
		return true;
	}	//	closeIt

	/**
	 * 	Reverse Correct Document.<br/>
	 * 	Status: Reversed.
	 * 	@return true if success
	 * 	@see org.compiere.process.DocAction#reverseCorrectIt()
	 */
	@Override
	public boolean reverseCorrectIt()
	{
		if (!isValidAction(ACTION_Reverse_Correct))
			return false;
		if (m_document != null)
		{
			if (m_document.reverseCorrectIt())
			{
				m_status = STATUS_Reversed;
				m_document.setDocStatus(m_status);
				return true;
			}
			return false;
		}
		m_status = STATUS_Reversed;
		return true;
	}	//	reverseCorrectIt

	/**
	 * 	Reverse Accrual Document.<br/>
	 * 	Status: Reversed.
	 * 	@return true if success
	 * 	@see org.compiere.process.DocAction#reverseAccrualIt()
	 */
	@Override
	public boolean reverseAccrualIt()
	{
		if (!isValidAction(ACTION_Reverse_Accrual))
			return false;
		if (m_document != null)
		{
			if (m_document.reverseAccrualIt())
			{
				m_status = STATUS_Reversed;
				m_document.setDocStatus(m_status);
				return true;
			}
			return false;
		}
		m_status = STATUS_Reversed;
		return true;
	}	//	reverseAccrualIt

	/**
	 * 	Re-activate Document.<br/>
	 * 	Status: In Progress.
	 * 	@return true if success
	 * 	@see org.compiere.process.DocAction#reActivateIt()
	 */
	@Override
	public boolean reActivateIt()
	{
		if (!isValidAction(ACTION_ReActivate))
			return false;
		if (m_document != null)
		{
			if (m_document.reActivateIt())
			{
				m_status = STATUS_InProgress;
				m_document.setDocStatus(m_status);
				return true;
			}
			return false;
		}
		m_status = STATUS_InProgress;
		return true;
	}	//	reActivateIt


	/**
	 * 	Set Document Status to new Status
	 *	@param newStatus new status
	 */
	protected void setStatus (String newStatus)
	{
		m_status = newStatus;
	}	//	setStatus

	/**
	 * 	Get available Document Actions based on current Document Status.
	 *	@return array of actions
	 */
	public String[] getActionOptions()
	{
		if (isInvalid())
			return new String[] {ACTION_Prepare, ACTION_Invalidate,
				ACTION_Unlock, ACTION_Void};

		if (isDrafted())
			return new String[] {ACTION_Prepare, ACTION_Invalidate, ACTION_Complete,
				ACTION_Unlock, ACTION_Void};

		if (isInProgress() || isApproved())
			return new String[] {ACTION_Complete, ACTION_WaitComplete,
				ACTION_Approve, ACTION_Reject,
				ACTION_Unlock, ACTION_Void, ACTION_Prepare};

		if (isNotApproved())
			return new String[] {ACTION_Reject, ACTION_Prepare,
				ACTION_Unlock, ACTION_Void};

		if (isWaiting())
			return new String[] {ACTION_Complete, ACTION_WaitComplete,
				ACTION_ReActivate, ACTION_Void, ACTION_Close};

		if (isCompleted())
			return new String[] {ACTION_Close, ACTION_ReActivate,
				ACTION_Reverse_Accrual, ACTION_Reverse_Correct,
				ACTION_Post, ACTION_Void};

		if (isClosed())
			return new String[] {ACTION_Post, ACTION_ReActivate};

		if (isReversed() || isVoided())
			return new String[] {ACTION_Post};

		return new String[] {};
	}	//	getActionOptions

	/**
	 * 	Is The Action Valid based on current document status.
	 *	@param action action
	 *	@return true if valid
	 */
	public boolean isValidAction (String action)
	{
		String[] options = getActionOptions();
		for (int i = 0; i < options.length; i++)
		{
			if (options[i].equals(action))
				return true;
		}
		return false;
	}	//	isValidAction

	/**
	 * 	Get Process Message
	 *	@return clear text error message
	 */
	@Override
	public String getProcessMsg ()
	{
		return m_message;
	}	//	getProcessMsg

	/**
	 * 	Set Process Message
	 *	@param msg clear text error message
	 */
	public void setProcessMsg (String msg)
	{
		m_message = msg;
	}	//	setProcessMsg

	/**	Document Exception Message		*/
	private static String EXCEPTION_MSG = "Document Engine is no Document";

	/**
	 *	Not applicable, throw exception
	 */
	@Override
	public String getSummary()
	{
		throw new IllegalStateException(EXCEPTION_MSG);
	}

	/**
	 * 	Not applicable, throw exception
	 */
	@Override
	public String getDocumentNo()
	{
		throw new IllegalStateException(EXCEPTION_MSG);
	}

	/**
	 * 	Not applicable, throw exception
	 */
	@Override
	public String getDocumentInfo()
	{
		throw new IllegalStateException(EXCEPTION_MSG);
	}

	/**
	 * 	Not applicable, throw exception
	 */
	@Override
	public int getDoc_User_ID()
	{
		throw new IllegalStateException(EXCEPTION_MSG);
	}

	/**
	 * 	Not applicable, throw exception
	 */
	@Override
	public int getC_Currency_ID()
	{
		throw new IllegalStateException(EXCEPTION_MSG);
	}

	/**
	 * 	Not applicable, throw exception
	 */
	@Override
	public BigDecimal getApprovalAmt()
	{
		throw new IllegalStateException(EXCEPTION_MSG);
	}

	/**
	 * 	Not applicable, throw exception
	 */
	@Override
	public int getAD_Client_ID()
	{
		throw new IllegalStateException(EXCEPTION_MSG);
	}

	/**
	 * 	Not applicable, throw exception
	 */
	@Override
	public int getAD_Org_ID()
	{
		throw new IllegalStateException(EXCEPTION_MSG);
	}

	/**
	 * 	Get Doc Action
	 *	@return Document Action
	 */
	@Override
	public String getDocAction()
	{
		return m_action;
	}

	/**
	 * 	Not applicable, throw exception
	 */
	@Override
	public boolean save()
	{
		throw new IllegalStateException(EXCEPTION_MSG);
	}

	/**
	 * 	Not applicable, throw exception
	 */
	@Override
	public void saveEx() throws AdempiereException
	{
		throw new IllegalStateException(EXCEPTION_MSG);
	}
	
	/**
	 * 	Get Context
	 *	@return context
	 */
	@Override
	public Properties getCtx()
	{
		if (m_document != null)
			return m_document.getCtx();
		throw new IllegalStateException(EXCEPTION_MSG);
	}	//	getCtx

	/**
	 * 	Get ID of record
	 *	@return ID
	 */
	@Override
	public int get_ID()
	{
		if (m_document != null)
			return m_document.get_ID();
		throw new IllegalStateException(EXCEPTION_MSG);
	}	//	get_ID

	/**
	 * 	Get AD_Table_ID
	 *	@return AD_Table_ID
	 */
	@Override
	public int get_Table_ID()
	{
		if (m_document != null)
			return m_document.get_Table_ID();
		throw new IllegalStateException(EXCEPTION_MSG);
	}	//	get_Table_ID

	/**
	 * 	Get Logger
	 *	@return logger
	 */
	@Override
	public CLogger get_Logger()
	{
		if (m_document != null)
			return m_document.get_Logger();
		throw new IllegalStateException(EXCEPTION_MSG);
	}	//	get_Logger

	/**
	 * 	Get Transaction
	 *	@return trx name
	 */
	@Override
	public String get_TrxName()
	{
		return null;
	}	//	get_TrxName

	/**
	 * 	CreatePDF
	 *	@return null
	 */
	@Override
	public File createPDF ()
	{
		return null;
	}

	/**
	 * Get list of valid document action into the options array parameter.<br/>
	 * Set default document action into the docAction array parameter.
	 * @param docStatus
	 * @param processing
	 * @param orderType
	 * @param isSOTrx
	 * @param AD_Table_ID
	 * @param docAction
	 * @param options
	 * @param periodOpen - flag indicating if the period is Open - to avoid including Void and ReverseCorrect options in the list
	 * @param po
	 * @return End index of valid options[] (exclusive)
	 */
	public static int getValidActions(String docStatus, Object processing,
			String orderType, String isSOTrx, int AD_Table_ID, String[] docAction, String[] options, boolean periodOpen, PO po)
	{
		return getValidActions(docStatus, processing, orderType, isSOTrx, AD_Table_ID, docAction, options, periodOpen, true, po);
	}
	
	/**
	 * Get list of valid document action into the options array parameter.<br/>
	 * Set default document action into the docAction array parameter.
	 * @param docStatus
	 * @param processing
	 * @param orderType
	 * @param isSOTrx
	 * @param AD_Table_ID
	 * @param docAction
	 * @param options
	 * @param periodOpen - flag indicating if the period is Open - to avoid including Void and ReverseCorrect options in the list
	 * @param isBackDateTrxAllowed - flag indicating if back-date transaction is allowed
	 * @param po
	 * @return End index of valid options[] (exclusive)
	 */
	public static int getValidActions(String docStatus, Object processing,
			String orderType, String isSOTrx, int AD_Table_ID, String[] docAction, String[] options, boolean periodOpen, boolean isBackDateTrxAllowed, PO po)
	{
		if (options == null)
			throw new IllegalArgumentException("Option array parameter is null");
		if (docAction == null)
			throw new IllegalArgumentException("Doc action array parameter is null");

		int index = 0;

		//	Locked
		if (processing != null)
		{
			boolean locked = "Y".equals(processing);
			if (!locked && processing instanceof Boolean)
				locked = ((Boolean)processing).booleanValue();
			if (locked)
				options[index++] = DocumentEngine.ACTION_Unlock;
		}

		//	Approval required           ..  NA
		if (docStatus.equals(DocumentEngine.STATUS_NotApproved))
		{
			options[index++] = DocumentEngine.ACTION_Prepare;
			options[index++] = DocumentEngine.ACTION_Void;
		}
		//	Draft/In Process/Invalid	..  DR/IP/IN
		else if (docStatus.equals(DocumentEngine.STATUS_Drafted)
			|| docStatus.equals(DocumentEngine.STATUS_InProgress)
			|| docStatus.equals(DocumentEngine.STATUS_Invalid))
		{
			options[index++] = DocumentEngine.ACTION_Complete;
			options[index++] = DocumentEngine.ACTION_Prepare;
			options[index++] = DocumentEngine.ACTION_Void;
		}
		//	Approved                  ..  AP
		else if (docStatus.equals(DocumentEngine.STATUS_Approved))
		{
			options[index++] = DocumentEngine.ACTION_Complete;
			options[index++] = DocumentEngine.ACTION_Void;
		}
		//	Complete                    ..  CO
		else if (docStatus.equals(DocumentEngine.STATUS_Completed))
		{
			options[index++] = DocumentEngine.ACTION_Close;
		}
		//	Waiting Payment
		else if (docStatus.equals(DocumentEngine.STATUS_WaitingPayment)
			|| docStatus.equals(DocumentEngine.STATUS_WaitingConfirmation))
		{
			options[index++] = DocumentEngine.ACTION_Void;
			options[index++] = DocumentEngine.ACTION_Prepare;
		}

		/********************
		 *  Order
		 */
		if (AD_Table_ID == MOrder.Table_ID)
		{
			//	Draft                       ..  DR/IP/IN
			if (docStatus.equals(DocumentEngine.STATUS_Drafted)
				|| docStatus.equals(DocumentEngine.STATUS_InProgress)
				|| docStatus.equals(DocumentEngine.STATUS_Invalid))
			{
				//	Draft Sales Order Quote/Proposal - Process
				if ("Y".equals(isSOTrx)
					&& ("OB".equals(orderType) || "ON".equals(orderType)))
					docAction[0] = DocumentEngine.ACTION_Prepare;
			}
			//	Complete                    ..  CO
			else if (docStatus.equals(DocumentEngine.STATUS_Completed))
			{
				options[index++] = DocumentEngine.ACTION_Void;

				if (canReactivateThisDocType(po.get_ValueAsInt("C_DocType_ID")))
					options[index++] = DocumentEngine.ACTION_ReActivate;
			}
			else if (docStatus.equals(DocumentEngine.STATUS_WaitingPayment))
			{
				options[index++] = DocumentEngine.ACTION_ReActivate;
				options[index++] = DocumentEngine.ACTION_Close;
			}
		}
		/********************
		 *  Shipment
		 */
		else if (AD_Table_ID == MInOut.Table_ID)
		{
			//	Complete                    ..  CO
			if (docStatus.equals(DocumentEngine.STATUS_Completed))
			{
				if (periodOpen && isBackDateTrxAllowed) {
					options[index++] = DocumentEngine.ACTION_Reverse_Correct;
				}
				options[index++] = DocumentEngine.ACTION_Reverse_Accrual;
			}
		}
		/********************
		 *  Invoice
		 */
		else if (AD_Table_ID == MInvoice.Table_ID)
		{
			//	Complete                    ..  CO
			if (docStatus.equals(DocumentEngine.STATUS_Completed))
			{
				if (periodOpen ) {
					if (canReactivateThisDocType(po.get_ValueAsInt("C_DocType_ID")))
						options[index++] = DocumentEngine.ACTION_ReActivate;

					if (isBackDateTrxAllowed)
						options[index++] = DocumentEngine.ACTION_Reverse_Correct;	
				}

				options[index++] = DocumentEngine.ACTION_Reverse_Accrual;
			}
		}
		/********************
		 *  Payment
		 */
		else if (AD_Table_ID == MPayment.Table_ID)
		{
			//	Complete                    ..  CO
			if (docStatus.equals(DocumentEngine.STATUS_Completed))
			{
				if (periodOpen) {
					options[index++] = DocumentEngine.ACTION_Reverse_Correct;
					if (canReactivateThisDocType(po.get_ValueAsInt("C_DocType_ID")))
						options[index++] = DocumentEngine.ACTION_ReActivate;
				}
				options[index++] = DocumentEngine.ACTION_Reverse_Accrual;
			}
		}
		/********************
		 *  GL Journal
		 */
		else if (AD_Table_ID == MJournal.Table_ID || AD_Table_ID == MJournalBatch.Table_ID)
		{
			//	Complete                    ..  CO
			if (docStatus.equals(DocumentEngine.STATUS_Completed))
			{
				if (periodOpen) {
					options[index++] = DocumentEngine.ACTION_Reverse_Correct;
					if (canReactivateThisDocType(po.get_ValueAsInt("C_DocType_ID")))
						options[index++] = DocumentEngine.ACTION_ReActivate;
				}
				options[index++] = DocumentEngine.ACTION_Reverse_Accrual;
			}
		}
		/********************
		 *  Allocation
		 */
		else if (AD_Table_ID == MAllocationHdr.Table_ID)
		{
			//	Complete                    ..  CO
			if (docStatus.equals(DocumentEngine.STATUS_Completed))
			{
				if (periodOpen) {
					options[index++] = DocumentEngine.ACTION_Reverse_Correct;
				}
				options[index++] = DocumentEngine.ACTION_Reverse_Accrual;
			}
		}
		//[ 1782412 ]
		/********************
		 *  Cash
		 */
		else if (AD_Table_ID == MCash.Table_ID)
		{
			//	Complete                    ..  CO
			if (docStatus.equals(DocumentEngine.STATUS_Completed))
			{
				options[index++] = DocumentEngine.ACTION_Void;
			}
		}
		/********************
		 *  Bank Statement
		 */
		else if (AD_Table_ID == MBankStatement.Table_ID)
		{
			//	Complete                    ..  CO
			if (docStatus.equals(DocumentEngine.STATUS_Completed))
			{
				if (periodOpen) {
					if (canReactivateThisDocType(po.get_ValueAsInt("C_DocType_ID")))
						options[index++] = DocumentEngine.ACTION_ReActivate;
					options[index++] = DocumentEngine.ACTION_Void;
				}
			}
		}
		/********************
		 *  Inventory Movement, Physical Inventory
		 */
		else if (AD_Table_ID == MMovement.Table_ID
			|| AD_Table_ID == MInventory.Table_ID)
		{
			//	Complete                    ..  CO
			if (docStatus.equals(DocumentEngine.STATUS_Completed))
			{
				if (periodOpen && isBackDateTrxAllowed) {
					options[index++] = DocumentEngine.ACTION_Reverse_Correct;
				}
				options[index++] = DocumentEngine.ACTION_Reverse_Accrual;
			}
		}
		/********************
		 *  Manufacturing Order
		 */
		else if (AD_Table_ID == I_PP_Order.Table_ID)
		{
			if (docStatus.equals(DocumentEngine.STATUS_Drafted)
					|| docStatus.equals(DocumentEngine.STATUS_InProgress)
					|| docStatus.equals(DocumentEngine.STATUS_Invalid))
				{
					options[index++] = DocumentEngine.ACTION_Close;
				}
				//	Complete                    ..  CO
				else if (docStatus.equals(DocumentEngine.STATUS_Completed))
				{
					options[index++] = DocumentEngine.ACTION_Void;
					options[index++] = DocumentEngine.ACTION_ReActivate;
				}
		}
		/********************
		 *  Production
		 */
		else if (AD_Table_ID == MProduction.Table_ID)
		{
			//	Complete                    ..  CO
			if (docStatus.equals(DocumentEngine.STATUS_Completed))
			{
				if (periodOpen && isBackDateTrxAllowed) {
					options[index++] = DocumentEngine.ACTION_Reverse_Correct;
				}
				options[index++] = DocumentEngine.ACTION_Reverse_Accrual;
			}

		}
		/********************
		 *  Manufacturing Cost Collector
		 */
		else if (AD_Table_ID == I_PP_Cost_Collector.Table_ID)
		{
			if (docStatus.equals(DocumentEngine.STATUS_Drafted)
					|| docStatus.equals(DocumentEngine.STATUS_InProgress)
					|| docStatus.equals(DocumentEngine.STATUS_Invalid))
				{
					options[index++] = DocumentEngine.ACTION_Close;
				}
				//	Complete                    ..  CO
				else if (docStatus.equals(DocumentEngine.STATUS_Completed))
				{
					options[index++] = DocumentEngine.ACTION_Void;
					options[index++] = DocumentEngine.ACTION_Reverse_Correct;
				}
		}
		/********************
		 *  Distribution Order
		 */
		else if (AD_Table_ID == I_DD_Order.Table_ID)
		{
			if (docStatus.equals(DocumentEngine.STATUS_Drafted)
					|| docStatus.equals(DocumentEngine.STATUS_InProgress)
					|| docStatus.equals(DocumentEngine.STATUS_Invalid))
				{
					options[index++] = DocumentEngine.ACTION_Close;
				}
				//	Complete                    ..  CO
				else if (docStatus.equals(DocumentEngine.STATUS_Completed))
				{
					options[index++] = DocumentEngine.ACTION_Void;
					options[index++] = DocumentEngine.ACTION_ReActivate;
				}
		}
		/********************
		 *  Payroll Process
		 */
		else if (AD_Table_ID == I_HR_Process.Table_ID)
		{
			if (docStatus.equals(DocumentEngine.STATUS_Drafted)
					|| docStatus.equals(DocumentEngine.STATUS_InProgress)
					|| docStatus.equals(DocumentEngine.STATUS_Invalid))
				{
					options[index++] = DocumentEngine.ACTION_Close;
				}
				//	Complete                    ..  CO
				else if (docStatus.equals(DocumentEngine.STATUS_Completed))
				{
					options[index++] = DocumentEngine.ACTION_Void;
					options[index++] = DocumentEngine.ACTION_ReActivate;
				}
		}
		/********************
		 *  RMA Process
		 */
		else if (AD_Table_ID == MRMA.Table_ID)
		{
			if(docStatus.equals(DocumentEngine.STATUS_Completed))
			{
				// IDEMPIERE-98 - Implement void for completed RMAs - Diego Ruiz - globalqss
				options[index++] = DocumentEngine.ACTION_Void;
			}
		}
		/********************
		 *  Bank Transfer Process
		 */
		else if (AD_Table_ID == MBankTransfer.Table_ID)
		{
			if(docStatus.equals(DocumentEngine.STATUS_Completed))
			{
				options[index++] = DocumentEngine.ACTION_Void;
			}
		}
		/********************
		 *  Deposit Batch
		 */
		else if (AD_Table_ID == MDepositBatch.Table_ID)
		{
			//	Complete
			if (docStatus.equals(DocumentEngine.STATUS_Completed)) 
			{
				options[index++] = DocumentEngine.ACTION_Void;
				options[index++] = DocumentEngine.ACTION_ReActivate;
			}
		}

		if (po instanceof DocOptions)
			index = ((DocOptions) po).customizeValidActions(docStatus, processing, orderType, isSOTrx,
					AD_Table_ID, docAction, options, index);

		AtomicInteger indexObj = new AtomicInteger(index);
		ArrayList<String> docActionsArray = new ArrayList<String>(Arrays.asList(docAction));
		ArrayList<String> optionsArray = new ArrayList<String>(Arrays.asList(options));
		DocActionEventData eventData = new DocActionEventData(docStatus, processing, orderType, isSOTrx, AD_Table_ID, docActionsArray, optionsArray, indexObj, po);
		Event event = EventManager.newEvent(IEventTopics.DOCACTION,
				new EventProperty(EventManager.EVENT_DATA, eventData),
				new EventProperty(EventManager.TABLE_NAME_PROPERTY, po.get_TableName()));
		EventManager.getInstance().sendEvent(event);
		index = indexObj.get();
		for (int i = 0; i < optionsArray.size(); i++)
			options[i] = optionsArray.get(i);
		for (int i = 0; i < docActionsArray.size(); i++)
			docAction[i] = docActionsArray.get(i);

		return index;
	}

	/**
	 * Fill lists with DocAction Ref_List(135) values
	 * @param v_value
	 * @param v_name
	 * @param v_description
	 */
	public static void readReferenceList(ArrayList<String> v_value, ArrayList<String> v_name,
			ArrayList<String> v_description)
	{
		if (v_value == null)
			throw new IllegalArgumentException("v_value parameter is null");
		if (v_name == null)
			throw new IllegalArgumentException("v_name parameter is null");
		if (v_description == null)
			throw new IllegalArgumentException("v_description parameter is null");

		String sql;
		if (Env.isBaseLanguage(Env.getCtx(), "AD_Ref_List"))
			sql = "SELECT Value, Name, Description FROM AD_Ref_List "
				+ "WHERE AD_Reference_ID=? ORDER BY Name";
		else
			sql = "SELECT l.Value, t.Name, t.Description "
				+ "FROM AD_Ref_List l, AD_Ref_List_Trl t "
				+ "WHERE l.AD_Ref_List_ID=t.AD_Ref_List_ID"
				+ " AND t.AD_Language='" + Env.getAD_Language(Env.getCtx()) + "'"
				+ " AND l.AD_Reference_ID=? ORDER BY t.Name";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try
		{
			pstmt = DB.prepareStatement(sql, null);
			pstmt.setInt(1, DocAction.AD_REFERENCE_ID);
			rs = pstmt.executeQuery();
			while (rs.next())
			{
				String value = rs.getString(1);
				String name = rs.getString(2);
				String description = rs.getString(3);
				if (description == null)
					description = "";
				//
				v_value.add(value);
				v_name.add(name);
				v_description.add(description);
			}
		}
		catch (SQLException e)
		{
			log.log(Level.SEVERE, sql, e);
		}
		finally
		{
			DB.close(rs, pstmt);
			rs = null;
			pstmt = null;
		}
	}

	/**
	 * Checks the access rights of the given role/client for the given document actions.
	 * @param clientId
	 * @param roleId
	 * @param docTypeId
	 * @param options
	 * @param maxIndex
	 * @return End index of valid options[] (exclusive)
	 */
	public static int checkActionAccess(int clientId, int roleId, int docTypeId, String[] options, int maxIndex) {
		return MRole.get(Env.getCtx(), roleId).checkActionAccess(clientId, docTypeId, options, maxIndex);
	}

	/**
	 *  Perform immediate posting of document
	 *
	 *	@param	ctx Client Context
	 *  @param  AD_Client_ID    Client ID of Document
	 *  @param  AD_Table_ID     Table ID of Document
	 *  @param  Record_ID       Record ID of this document
	 *  @param  force           force posting
	 *  @param  trxName			ignore, retained for backward compatibility
	 *  @return null, if success or error message
	 */
	public static String postImmediate (Properties ctx,
		int AD_Client_ID, int AD_Table_ID, int Record_ID, boolean force, String trxName)
	{
		// Ensure the table has Posted column / i.e. GL_JournalBatch can be completed but not posted
		if (MColumn.getColumn_ID(MTable.getTableName(ctx, AD_Table_ID), "Posted") <= 0)
			return null;

		String error = null;
		if (log.isLoggable(Level.INFO)) log.info ("Table=" + AD_Table_ID + ", Record=" + Record_ID);
		MAcctSchema[] ass = MAcctSchema.getClientAcctSchema(ctx, AD_Client_ID);
		error = Doc.postImmediate(ass, AD_Table_ID, Record_ID, force, trxName);
		return error;
	}	//	postImmediate

	/**
	 * Process document action.  This replaces DocAction.processIt().
	 * @param doc
	 * @param processAction 
	 * @return true if performed
	 */
	public static boolean processIt(DocAction doc, String processAction) {
		boolean success = false;
		
		DocumentEngine engine = new DocumentEngine(doc, doc.getDocStatus());
		success = engine.processIt(processAction, doc.getDocAction());

		return success;
	}
	
	/**
	 * Fill lists with DocAction Ref_List(131) values
	 * @param v_value
	 * @param v_name
	 * @param v_description
	 */
	public static void readStatusReferenceList(ArrayList<String> v_value, ArrayList<String> v_name,
			ArrayList<String> v_description)
	{
		if (v_value == null)
			throw new IllegalArgumentException("v_value parameter is null");
		if (v_name == null)
			throw new IllegalArgumentException("v_name parameter is null");
		if (v_description == null)
			throw new IllegalArgumentException("v_description parameter is null");

		String sql;
		if (Env.isBaseLanguage(Env.getCtx(), "AD_Ref_List"))
			sql = "SELECT Value, Name, Description FROM AD_Ref_List "
				+ "WHERE AD_Reference_ID=? ORDER BY Name";
		else
			sql = "SELECT l.Value, t.Name, t.Description "
				+ "FROM AD_Ref_List l, AD_Ref_List_Trl t "
				+ "WHERE l.AD_Ref_List_ID=t.AD_Ref_List_ID"
				+ " AND t.AD_Language='" + Env.getAD_Language(Env.getCtx()) + "'"
				+ " AND l.AD_Reference_ID=? ORDER BY t.Name";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try
		{
			pstmt = DB.prepareStatement(sql, null);
			pstmt.setInt(1, SystemIDs.REFERENCE_DOCUMENTSTATUS);
			rs = pstmt.executeQuery();
			while (rs.next())
			{
				String value = rs.getString(1);
				String name = rs.getString(2);
				String description = rs.getString(3);
				if (description == null)
					description = "";
				//
				v_value.add(value);
				v_name.add(name);
				v_description.add(description);
			}
		}
		catch (SQLException e)
		{
			log.log(Level.SEVERE, sql, e);
		}
		finally
		{
			DB.close(rs, pstmt);
			rs = null;
			pstmt = null;
		}
	}

	public static boolean canReactivateThisDocType(int docTypeID) {
		return docTypeID > 0 && MDocType.get(docTypeID).isCanBeReactivated();
	}
}	//	DocumentEnine
