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

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Properties;

import org.compiere.util.DB;
import org.compiere.util.Env;
import org.compiere.util.Msg;
import org.compiere.util.Util;

/**
 *  GL Journal Line Model
 *
 *	@author Jorg Janke
 *	@author Cristina Ghita
 *  	<li>BF [ 2855807 ] AD_Org_ID from account 
 *  		https://sourceforge.net/p/adempiere/bugs/2084/
 *	@version $Id: MJournalLine.java,v 1.3 2006/07/30 00:51:05 jjanke Exp $
 */
public class MJournalLine extends X_GL_JournalLine
{
	/**
	 * generated serial id
	 */
	private static final long serialVersionUID = 253571209449736797L;

    /**
     * UUID based Constructor
     * @param ctx  Context
     * @param GL_JournalLine_UU  UUID key
     * @param trxName Transaction
     */
    public MJournalLine(Properties ctx, String GL_JournalLine_UU, String trxName) {
        super(ctx, GL_JournalLine_UU, trxName);
		if (Util.isEmpty(GL_JournalLine_UU))
			setInitialDefaults();
    }

	/**
	 * 	Standard Constructor
	 *	@param ctx context
	 *	@param GL_JournalLine_ID id
	 *	@param trxName transaction
	 */
	public MJournalLine (Properties ctx, int GL_JournalLine_ID, String trxName)
	{
		super (ctx, GL_JournalLine_ID, trxName);
		if (GL_JournalLine_ID == 0)
			setInitialDefaults();
	}	//	MJournalLine

	/**
	 * Set the initial defaults for a new record
	 */
	private void setInitialDefaults() {
		setLine (0);
		setAmtAcctCr (Env.ZERO);
		setAmtAcctDr (Env.ZERO);
		setAmtSourceCr (Env.ZERO);
		setAmtSourceDr (Env.ZERO);
		setCurrencyRate (Env.ONE);
		setDateAcct (new Timestamp(System.currentTimeMillis()));
		setIsGenerated (true);
	}

	/**
	 * 	Load Constructor
	 *	@param ctx context
	 *	@param rs result set
	 *	@param trxName transaction
	 */
	public MJournalLine (Properties ctx, ResultSet rs, String trxName)
	{
		super(ctx, rs, trxName);
	}	//	MJournalLine

	/**
	 * 	Parent Constructor
	 *	@param parent journal
	 */
	public MJournalLine (MJournal parent)
	{
		this (parent.getCtx(), 0, parent.get_TrxName());
		setClientOrg(parent);
		setGL_Journal_ID(parent.getGL_Journal_ID());
		setC_Currency_ID(parent.getC_Currency_ID());
		setC_ConversionType_ID(parent.getC_ConversionType_ID());
		setDateAcct(parent.getDateAcct());
		
	}	//	MJournalLine

	/** Parent					*/
	protected MJournal	m_parent = null;
	
	/**
	 * 	Get Parent
	 *	@return parent
	 */
	public MJournal getParent()
	{
		if (m_parent == null)
			m_parent = new MJournal (getCtx(), getGL_Journal_ID(), get_TrxName());
		return m_parent;
	}	//	getParent
	
	/**	Currency Precision		*/
	protected int				m_precision = 2;
	/**	Account Combination		*/
	protected MAccount		 	m_account = null;
	/** Account Element			*/
	protected MElementValue		m_accountElement = null;
	
	/**
	 * 	Set Currency Info
	 *	@param C_Currency_ID currency
	 *	@param C_ConversionType_ID type
	 *	@param CurrencyRate rate
	 */
	public void setCurrency (int C_Currency_ID, int C_ConversionType_ID, BigDecimal CurrencyRate)
	{
		setC_Currency_ID(C_Currency_ID);
		if (C_ConversionType_ID != 0)
			setC_ConversionType_ID(C_ConversionType_ID);
		if (CurrencyRate != null && CurrencyRate.signum() == 0)
			setCurrencyRate(CurrencyRate);
	}	//	setCurrency

	/**
	 * 	Set C_Currency_ID and precision
	 *	@param C_Currency_ID currency
	 */
	public void setC_Currency_ID (int C_Currency_ID)
	{
		if (C_Currency_ID == 0)
			return;
		super.setC_Currency_ID (C_Currency_ID);
		m_precision = MCurrency.getStdPrecision(getCtx(), C_Currency_ID);
	}	//	setC_Currency_ID
	
	/**
	 * 	Get Currency Precision
	 *	@return precision
	 */
	public int getPrecision()
	{
		return m_precision;
	}	//	getPrecision
	
	/**
	 * 	Set Currency Rate
	 *	@param CurrencyRate check for null or negative value (-&gt;one)
	 */
	@Override
	public void setCurrencyRate (BigDecimal CurrencyRate)
	{
		if (CurrencyRate == null)
		{
			log.warning("was NULL - set to 1");
			super.setCurrencyRate (Env.ONE);
		}
		else if (CurrencyRate.signum() < 0)
		{
			log.warning("negative - " + CurrencyRate + " - set to 1");
			super.setCurrencyRate (Env.ONE);
		}
		else
			super.setCurrencyRate (CurrencyRate);
	}	//	setCurrencyRate
	
	/**
	 * 	Set Accounted Amounts only if not 0.
	 * 	Amounts overwritten in beforeSave - set conversion rate.
	 *	@param AmtAcctDr Dr
	 *	@param AmtAcctCr Cr
	 */
	public void setAmtAcct (BigDecimal AmtAcctDr, BigDecimal AmtAcctCr)
	{
		//	setConversion
		double rateDR = 0;
		if (AmtAcctDr != null && AmtAcctDr.signum() != 0)
		{
			rateDR = AmtAcctDr.doubleValue() / getAmtSourceDr().doubleValue();
			super.setAmtAcctDr(AmtAcctDr);
		}
		double rateCR = 0;
		if (AmtAcctCr != null && AmtAcctCr.signum() != 0)
		{
			rateCR = AmtAcctCr.doubleValue() / getAmtSourceCr().doubleValue();
			super.setAmtAcctCr(AmtAcctCr);
		}
		if (rateDR != 0 && rateCR != 0 && rateDR != rateCR)
		{
			log.warning("Rates Different DR=" + rateDR + "(used) <> CR=" + rateCR + "(ignored)");
			rateCR = 0;
		}
		if (rateDR < 0 || Double.isInfinite(rateDR) || Double.isNaN(rateDR))
		{
			log.warning("DR Rate ignored - " + rateDR);
			return;
		}
		if (rateCR < 0 || Double.isInfinite(rateCR) || Double.isNaN(rateCR))
		{
			log.warning("CR Rate ignored - " + rateCR);
			return;
		}
		
		if (rateDR != 0)
			setCurrencyRate(BigDecimal.valueOf(rateDR));
		if (rateCR != 0)
			setCurrencyRate(BigDecimal.valueOf(rateCR));
	}	//	setAmtAcct

	
	/**
	 * 	Set C_ValidCombination_ID
	 *	@param C_ValidCombination_ID id
	 */
	public void setC_ValidCombination_ID (int C_ValidCombination_ID)
	{
		super.setC_ValidCombination_ID (C_ValidCombination_ID);
		m_account = null;
		m_accountElement = null;
	}	//	setC_ValidCombination_ID
	
	/**
	 * 	Set C_ValidCombination_ID
	 *	@param acct account
	 */
	public void setC_ValidCombination_ID (MAccount acct)
	{
		if (acct == null)
			throw new IllegalArgumentException("Account is null");
		super.setC_ValidCombination_ID (acct.getC_ValidCombination_ID());
		m_account = acct;
		m_accountElement = null;
	}	//	setC_ValidCombination_ID

	/**
	 * 	Get Account (Valid Combination)
	 *	@return combination or null
	 */
	public MAccount getAccount_Combi()
	{
		if (m_account == null && getC_ValidCombination_ID() != 0)
			m_account = new MAccount (getCtx(), getC_ValidCombination_ID(), get_TrxName());
		return m_account;
	}	//	getValidCombination
	
	/**
	 * 	Get Natural Account Element Value
	 *	@return account
	 */
	public MElementValue getAccountElementValue()
	{
		if (m_accountElement == null)
		{
			MAccount vc = getAccount_Combi();
			if (vc != null && vc.getAccount_ID() != 0)
				m_accountElement = new MElementValue (getCtx(), vc.getAccount_ID(), get_TrxName()); 
		}
		return m_accountElement;
	}	//	getAccountElement
	
	/**
	 * 	Is it posting to a Control Acct
	 *	@return true if control acct
	 */
	public boolean isDocControlled()
	{
		MElementValue acct = getAccountElementValue();
		if (acct == null)
		{
			log.warning ("Account not found for C_ValidCombination_ID=" + getC_ValidCombination_ID());
			return false;
		}
		return acct.isDocControlled();
	}	//	isDocControlled
		
	@Override
	protected boolean beforeSave (boolean newRecord)
	{
		if (newRecord && getParent().isProcessed()) {
			log.saveError("ParentComplete", Msg.translate(getCtx(), "GL_Journal_ID"));
			return false;
		}

		if (getAD_Org_ID() <= 0) //	Set Line Org to Doc Org if still not set 
			setAD_Org_ID(getParent().getAD_Org_ID()); 
		// Set Line
		if (getLine() == 0)
			setLine(DB.getSQLValueEx(get_TrxName(), "SELECT COALESCE(MAX(Line), 0) + 10 FROM GL_JournalLine WHERE GL_Journal_ID = ?", getGL_Journal_ID()));
		// Set currency and conversion type from parent
		if (getC_Currency_ID() == 0)
			setC_Currency_ID(getParent().getC_Currency_ID());
		if (getC_ConversionType_ID() == 0)
			setC_ConversionType_ID(getParent().getC_ConversionType_ID());

		if (!getOrCreateCombination())
			return false;
		if (getC_ValidCombination_ID() <= 0)
		{
			log.saveError("SaveError", Msg.parseTranslation(getCtx(), "@FillMandatory@" + "@C_ValidCombination_ID@"));
			return false;
		}
		fillDimensionsFromCombination();

		//	Set Acct Amts from Source Amts
		BigDecimal rate = getCurrencyRate();
		BigDecimal amt = rate.multiply(getAmtSourceDr());
		if (amt.scale() > getPrecision())
			amt = amt.setScale(getPrecision(), RoundingMode.HALF_UP);
		setAmtAcctDr(amt);
		amt = rate.multiply(getAmtSourceCr());
		if (amt.scale() > getPrecision())
			amt = amt.setScale(getPrecision(), RoundingMode.HALF_UP);
		setAmtAcctCr(amt);
 
		return true;
	}	//	beforeSave
	
	@Override
	protected boolean afterSave (boolean newRecord, boolean success)
	{
		if (!success)
			return success;
		return updateJournalTotal();
	}	//	afterSave
	
	@Override
	protected boolean afterDelete (boolean success)
	{
		if (!success)
			return success;
		return updateJournalTotal();
	}	//	afterDelete

	
	/**
	 * 	Update Journal and Journal Batch Total
	 *	@return true if success
	 */
	protected boolean updateJournalTotal()
	{
		//	Update Journal Total
		StringBuilder sql = new StringBuilder("UPDATE GL_Journal j")
			.append(" SET (TotalDr, TotalCr) = (SELECT COALESCE(SUM(AmtAcctDr),0), COALESCE(SUM(AmtAcctCr),0)") // croo Bug# 1789935
				.append(" FROM GL_JournalLine jl WHERE jl.IsActive='Y' AND j.GL_Journal_ID=jl.GL_Journal_ID) ")
			.append("WHERE GL_Journal_ID=").append(getGL_Journal_ID());
		int no = DB.executeUpdate(sql.toString(), get_TrxName());
		if (no != 1)
			log.warning("afterSave - Update Journal #" + no);
		
		//	Update Batch Total
		int GL_JournalBatch_ID=DB.getSQLValue(get_TrxName(), "SELECT GL_JournalBatch_ID FROM GL_Journal WHERE GL_Journal_ID=?", getGL_Journal_ID());
		if (GL_JournalBatch_ID!=0) {	// idempiere 344 - nmicoud
			sql = new StringBuilder("UPDATE GL_JournalBatch jb")
					.append(" SET (TotalDr, TotalCr) = (SELECT COALESCE(SUM(TotalDr),0), COALESCE(SUM(TotalCr),0)")
					.append(" FROM GL_Journal j WHERE jb.GL_JournalBatch_ID=j.GL_JournalBatch_ID) ")
					.append("WHERE GL_JournalBatch_ID=")
					.append("(SELECT DISTINCT GL_JournalBatch_ID FROM GL_Journal WHERE GL_Journal_ID=") 
					.append(getGL_Journal_ID()).append(")");
			no = DB.executeUpdate(sql.toString(), get_TrxName());
			if (no != 1)
				log.warning("Update Batch #" + no);
		}
		return no == 1;
	}	//	updateJournalTotal

	/** 
	 * Get or create new valid combination record. Set C_ValidCombination_ID.
	 */
	protected boolean getOrCreateCombination()
	{
		if (getC_ValidCombination_ID() == 0
				|| (!is_new() && (is_ValueChanged("Account_ID")
						|| is_ValueChanged("C_SubAcct_ID")
						|| is_ValueChanged("M_Product_ID")
						|| is_ValueChanged("C_BPartner_ID")
						|| is_ValueChanged("AD_OrgTrx_ID")
						|| is_ValueChanged("AD_Org_ID")
						|| is_ValueChanged("C_LocFrom_ID")
						|| is_ValueChanged("C_LocTo_ID")
						|| is_ValueChanged("C_SalesRegion_ID")
						|| is_ValueChanged("C_Project_ID")
						|| is_ValueChanged("C_Campaign_ID")
						|| is_ValueChanged("C_Activity_ID")
						|| is_ValueChanged("User1_ID")
						|| is_ValueChanged("User2_ID"))))
		{
			MJournal gl = new MJournal(getCtx(), getGL_Journal_ID(), get_TrxName());

			// Validate all mandatory combinations are set
			MAcctSchema as = (MAcctSchema) getParent().getC_AcctSchema();
			String errorFields = "";
			for (MAcctSchemaElement elem : MAcctSchemaElement.getAcctSchemaElements(as)) {
				if (! elem.isMandatory())
					continue;
				String et = elem.getElementType();
				if (MAcctSchemaElement.ELEMENTTYPE_Account.equals(et) && getAccount_ID() == 0)
					errorFields += "@" + COLUMNNAME_Account_ID + "@, ";
				if (MAcctSchemaElement.ELEMENTTYPE_Activity.equals(et) && getC_Activity_ID() == 0)
					errorFields += "@" + COLUMNNAME_C_Activity_ID + "@, ";
				if (MAcctSchemaElement.ELEMENTTYPE_BPartner.equals(et) && getC_BPartner_ID() == 0)
					errorFields += "@" + COLUMNNAME_C_BPartner_ID + "@, ";
				if (MAcctSchemaElement.ELEMENTTYPE_Campaign.equals(et) && getC_Campaign_ID() == 0)
					errorFields += "@" + COLUMNNAME_C_Campaign_ID + "@, ";
				if (MAcctSchemaElement.ELEMENTTYPE_Organization.equals(et) && getAD_Org_ID() == 0)
					errorFields += "@" + COLUMNNAME_AD_Org_ID + "@, ";
				if (MAcctSchemaElement.ELEMENTTYPE_OrgTrx.equals(et) && getAD_OrgTrx_ID() == 0)
					errorFields += "@" + COLUMNNAME_AD_OrgTrx_ID + "@, ";
				if (MAcctSchemaElement.ELEMENTTYPE_Product.equals(et) && getM_Product_ID() == 0)
					errorFields += "@" + COLUMNNAME_M_Product_ID + "@, ";
				if (MAcctSchemaElement.ELEMENTTYPE_Project.equals(et) && getC_Project_ID() == 0)
					errorFields += "@" + COLUMNNAME_C_Project_ID + "@, ";
				if (MAcctSchemaElement.ELEMENTTYPE_SalesRegion.equals(et) && getC_SalesRegion_ID() == 0)
					errorFields += "@" + COLUMNNAME_C_SalesRegion_ID + "@, ";
				if (MAcctSchemaElement.ELEMENTTYPE_UserElementList1.equals(et) && getUser1_ID() == 0)
					errorFields += "@" + COLUMNNAME_User1_ID + "@, ";
				if (MAcctSchemaElement.ELEMENTTYPE_UserElementList2.equals(et) && getUser2_ID() == 0)
					errorFields += "@" + COLUMNNAME_User2_ID + "@, ";
				if (MAcctSchemaElement.ELEMENTTYPE_Department.equals(et) && getC_Department_ID() == 0)
					errorFields += "@" + COLUMNNAME_C_Department_ID + "@, ";
				if (MAcctSchemaElement.ELEMENTTYPE_CostCenter.equals(et) && getC_CostCenter_ID() == 0)
					errorFields += "@" + COLUMNNAME_C_CostCenter_ID + "@, ";
				if (MAcctSchemaElement.ELEMENTTYPE_Employee.equals(et) && getC_Employee_ID() == 0)
					errorFields += "@" + COLUMNNAME_C_Employee_ID + "@, ";
				if (MAcctSchemaElement.ELEMENTTYPE_Warehouse.equals(et) && getM_Warehouse_ID() == 0)
					errorFields += "@" + COLUMNNAME_M_Warehouse_ID + "@, ";
				if (MAcctSchemaElement.ELEMENTTYPE_Charge.equals(et) && getC_Charge_ID() == 0)
					errorFields += "@" + COLUMNNAME_C_Charge_ID + "@, ";
				if (MAcctSchemaElement.ELEMENTTYPE_AttributeSetInstance.equals(et) && getM_AttributeSetInstance_ID() == 0)
					errorFields += "@" + COLUMNNAME_M_AttributeSetInstance_ID + "@, ";
			}
			if (errorFields.length() > 0)
			{
				log.saveError("Error", Msg.parseTranslation(getCtx(), "@IsMandatory@: " + errorFields.substring(0, errorFields.length() - 2)));
				return false;
			}
			
			MAccount acct = MAccount.get(getCtx(), getAD_Client_ID(), getAD_Org_ID(), gl.getC_AcctSchema_ID(), getAccount_ID(),
					getC_SubAcct_ID(), getM_Product_ID(), getC_BPartner_ID(), getAD_OrgTrx_ID(), getC_LocFrom_ID(),
					getC_LocTo_ID(), getC_SalesRegion_ID(), getC_Project_ID(), getC_Campaign_ID(), 
					getC_Activity_ID(), getUser1_ID(), getUser2_ID(), 0, 0,
					get_TrxName());

			if (acct != null)
			{
				acct.saveEx(get_TrxName());	// get ID from transaction
				setC_ValidCombination_ID(acct.get_ID());
				if (acct.getAlias() != null && acct.getAlias().length() > 0)
					setAlias_ValidCombination_ID(acct.get_ID());
				else
					setAlias_ValidCombination_ID(0);
			}
		}
		return true;
	}	//	getOrCreateCombination

	/** 
	 * Fill Accounting Dimensions from valid combination. 
	 */
	protected void fillDimensionsFromCombination()
	{
		if (getC_ValidCombination_ID() > 0)
		{
			MAccount combi = new MAccount(getCtx(), getC_ValidCombination_ID(), get_TrxName());
			setAccount_ID(combi.getAccount_ID() > 0 ? combi.getAccount_ID() : 0);
			setC_SubAcct_ID(combi.getC_SubAcct_ID() > 0 ? combi.getC_SubAcct_ID() : 0);
			setM_Product_ID(combi.getM_Product_ID() > 0 ? combi.getM_Product_ID() : 0);
			setC_BPartner_ID(combi.getC_BPartner_ID() > 0 ? combi.getC_BPartner_ID() : 0);
			setAD_OrgTrx_ID(combi.getAD_OrgTrx_ID() > 0 ? combi.getAD_OrgTrx_ID() : 0);
			if (combi.getAD_Org_ID() > 0)
				setAD_Org_ID(combi.getAD_Org_ID());
			setC_LocFrom_ID(combi.getC_LocFrom_ID() > 0 ? combi.getC_LocFrom_ID() : 0);
			setC_LocTo_ID(combi.getC_LocTo_ID() > 0 ? combi.getC_LocTo_ID() : 0);
			setC_SalesRegion_ID(combi.getC_SalesRegion_ID() > 0 ? combi.getC_SalesRegion_ID() : 0);
			setC_Project_ID(combi.getC_Project_ID() > 0 ? combi.getC_Project_ID() : 0);
			setC_Campaign_ID(combi.getC_Campaign_ID() > 0 ? combi.getC_Campaign_ID() : 0);
			setC_Activity_ID(combi.getC_Activity_ID() > 0 ? combi.getC_Activity_ID() : 0);
			setUser1_ID(combi.getUser1_ID() > 0 ? combi.getUser1_ID() : 0);
			setUser2_ID(combi.getUser2_ID() > 0 ? combi.getUser2_ID() : 0);
		}		
	}	// fillDimensionsFromCombination
	
}	//	MJournalLine
