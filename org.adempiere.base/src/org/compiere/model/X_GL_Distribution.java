/******************************************************************************
 * Product: iDempiere ERP & CRM Smart Business Solution                       *
 * Copyright (C) 1999-2012 ComPiere, Inc. All Rights Reserved.                *
 * This program is free software, you can redistribute it and/or modify it    *
 * under the terms version 2 of the GNU General Public License as published   *
 * by the Free Software Foundation. This program is distributed in the hope   *
 * that it will be useful, but WITHOUT ANY WARRANTY, without even the implied *
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.           *
 * See the GNU General Public License for more details.                       *
 * You should have received a copy of the GNU General Public License along    *
 * with this program, if not, write to the Free Software Foundation, Inc.,    *
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA.                     *
 * For the text or an alternative of this public license, you may reach us    *
 * ComPiere, Inc., 2620 Augustine Dr. #245, Santa Clara, CA 95054, USA        *
 * or via info@compiere.org or http://www.compiere.org/license.html           *
 *****************************************************************************/
/** Generated Model - DO NOT CHANGE */
package org.compiere.model;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Properties;
import org.compiere.util.Env;
import org.compiere.util.KeyNamePair;

/** Generated Model for GL_Distribution
 *  @author iDempiere (generated)
 *  @version Release 13 - $Id$ */
@org.adempiere.base.Model(table="GL_Distribution")
public class X_GL_Distribution extends PO implements I_GL_Distribution, I_Persistent
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20250307L;

    /** Standard Constructor */
    public X_GL_Distribution (Properties ctx, int GL_Distribution_ID, String trxName)
    {
      super (ctx, GL_Distribution_ID, trxName);
      /** if (GL_Distribution_ID == 0)
        {
			setAnyAcct (true);
// Y
			setAnyActivity (true);
// Y
			setAnyAsset (true);
// Y
			setAnyAttributeSetInstance (true);
// Y
			setAnyBPartner (true);
// Y
			setAnyCampaign (true);
// Y
			setAnyCharge (true);
// Y
			setAnyCostCenter (true);
// Y
			setAnyDepartment (true);
// Y
			setAnyEmployee (true);
// Y
			setAnyLocFrom (true);
// Y
			setAnyLocTo (true);
// Y
			setAnyOrg (true);
// Y
			setAnyOrgTrx (true);
// Y
			setAnyProduct (true);
// Y
			setAnyProject (true);
// Y
			setAnySalesRegion (true);
// Y
			setAnyUser1 (true);
// Y
			setAnyUser2 (true);
// Y
			setAnyWarehouse (true);
// Y
			setC_AcctSchema_ID (0);
			setGL_Distribution_ID (0);
			setIsCreateReversal (true);
// Y
			setIsValid (false);
// N
			setName (null);
			setPercentTotal (Env.ZERO);
			setSeqNo (0);
// 0
        } */
    }

    /** Standard Constructor */
    public X_GL_Distribution (Properties ctx, int GL_Distribution_ID, String trxName, String ... virtualColumns)
    {
      super (ctx, GL_Distribution_ID, trxName, virtualColumns);
      /** if (GL_Distribution_ID == 0)
        {
			setAnyAcct (true);
// Y
			setAnyActivity (true);
// Y
			setAnyAsset (true);
// Y
			setAnyAttributeSetInstance (true);
// Y
			setAnyBPartner (true);
// Y
			setAnyCampaign (true);
// Y
			setAnyCharge (true);
// Y
			setAnyCostCenter (true);
// Y
			setAnyDepartment (true);
// Y
			setAnyEmployee (true);
// Y
			setAnyLocFrom (true);
// Y
			setAnyLocTo (true);
// Y
			setAnyOrg (true);
// Y
			setAnyOrgTrx (true);
// Y
			setAnyProduct (true);
// Y
			setAnyProject (true);
// Y
			setAnySalesRegion (true);
// Y
			setAnyUser1 (true);
// Y
			setAnyUser2 (true);
// Y
			setAnyWarehouse (true);
// Y
			setC_AcctSchema_ID (0);
			setGL_Distribution_ID (0);
			setIsCreateReversal (true);
// Y
			setIsValid (false);
// N
			setName (null);
			setPercentTotal (Env.ZERO);
			setSeqNo (0);
// 0
        } */
    }

    /** Standard Constructor */
    public X_GL_Distribution (Properties ctx, String GL_Distribution_UU, String trxName)
    {
      super (ctx, GL_Distribution_UU, trxName);
      /** if (GL_Distribution_UU == null)
        {
			setAnyAcct (true);
// Y
			setAnyActivity (true);
// Y
			setAnyAsset (true);
// Y
			setAnyAttributeSetInstance (true);
// Y
			setAnyBPartner (true);
// Y
			setAnyCampaign (true);
// Y
			setAnyCharge (true);
// Y
			setAnyCostCenter (true);
// Y
			setAnyDepartment (true);
// Y
			setAnyEmployee (true);
// Y
			setAnyLocFrom (true);
// Y
			setAnyLocTo (true);
// Y
			setAnyOrg (true);
// Y
			setAnyOrgTrx (true);
// Y
			setAnyProduct (true);
// Y
			setAnyProject (true);
// Y
			setAnySalesRegion (true);
// Y
			setAnyUser1 (true);
// Y
			setAnyUser2 (true);
// Y
			setAnyWarehouse (true);
// Y
			setC_AcctSchema_ID (0);
			setGL_Distribution_ID (0);
			setIsCreateReversal (true);
// Y
			setIsValid (false);
// N
			setName (null);
			setPercentTotal (Env.ZERO);
			setSeqNo (0);
// 0
        } */
    }

    /** Standard Constructor */
    public X_GL_Distribution (Properties ctx, String GL_Distribution_UU, String trxName, String ... virtualColumns)
    {
      super (ctx, GL_Distribution_UU, trxName, virtualColumns);
      /** if (GL_Distribution_UU == null)
        {
			setAnyAcct (true);
// Y
			setAnyActivity (true);
// Y
			setAnyAsset (true);
// Y
			setAnyAttributeSetInstance (true);
// Y
			setAnyBPartner (true);
// Y
			setAnyCampaign (true);
// Y
			setAnyCharge (true);
// Y
			setAnyCostCenter (true);
// Y
			setAnyDepartment (true);
// Y
			setAnyEmployee (true);
// Y
			setAnyLocFrom (true);
// Y
			setAnyLocTo (true);
// Y
			setAnyOrg (true);
// Y
			setAnyOrgTrx (true);
// Y
			setAnyProduct (true);
// Y
			setAnyProject (true);
// Y
			setAnySalesRegion (true);
// Y
			setAnyUser1 (true);
// Y
			setAnyUser2 (true);
// Y
			setAnyWarehouse (true);
// Y
			setC_AcctSchema_ID (0);
			setGL_Distribution_ID (0);
			setIsCreateReversal (true);
// Y
			setIsValid (false);
// N
			setName (null);
			setPercentTotal (Env.ZERO);
			setSeqNo (0);
// 0
        } */
    }

    /** Load Constructor */
    public X_GL_Distribution (Properties ctx, ResultSet rs, String trxName)
    {
      super (ctx, rs, trxName);
    }

    /** AccessLevel
      * @return 2 - Client
      */
    protected int get_AccessLevel()
    {
      return accessLevel.intValue();
    }

    /** Load Meta Data */
    protected POInfo initPO (Properties ctx)
    {
      POInfo poi = POInfo.getPOInfo (ctx, Table_ID, get_TrxName());
      return poi;
    }

    public String toString()
    {
      StringBuilder sb = new StringBuilder ("X_GL_Distribution[")
        .append(get_ID()).append(",Name=").append(getName()).append("]");
      return sb.toString();
    }

	/** Set Trx Organization.
		@param AD_OrgTrx_ID Performing or initiating organization
	*/
	public void setAD_OrgTrx_ID (int AD_OrgTrx_ID)
	{
		if (AD_OrgTrx_ID < 1)
			set_Value (COLUMNNAME_AD_OrgTrx_ID, null);
		else
			set_Value (COLUMNNAME_AD_OrgTrx_ID, Integer.valueOf(AD_OrgTrx_ID));
	}

	/** Get Trx Organization.
		@return Performing or initiating organization
	  */
	public int getAD_OrgTrx_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_AD_OrgTrx_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_A_Asset getA_Asset() throws RuntimeException
	{
		return (org.compiere.model.I_A_Asset)MTable.get(getCtx(), org.compiere.model.I_A_Asset.Table_ID)
			.getPO(getA_Asset_ID(), get_TrxName());
	}

	/** Set Asset.
		@param A_Asset_ID Asset used internally or by customers
	*/
	public void setA_Asset_ID (int A_Asset_ID)
	{
		if (A_Asset_ID < 1)
			set_Value (COLUMNNAME_A_Asset_ID, null);
		else
			set_Value (COLUMNNAME_A_Asset_ID, Integer.valueOf(A_Asset_ID));
	}

	/** Get Asset.
		@return Asset used internally or by customers
	  */
	public int getA_Asset_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_A_Asset_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_ElementValue getAccount() throws RuntimeException
	{
		return (org.compiere.model.I_C_ElementValue)MTable.get(getCtx(), org.compiere.model.I_C_ElementValue.Table_ID)
			.getPO(getAccount_ID(), get_TrxName());
	}

	/** Set Account.
		@param Account_ID Account used
	*/
	public void setAccount_ID (int Account_ID)
	{
		if (Account_ID < 1)
			set_Value (COLUMNNAME_Account_ID, null);
		else
			set_Value (COLUMNNAME_Account_ID, Integer.valueOf(Account_ID));
	}

	/** Get Account.
		@return Account used
	  */
	public int getAccount_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Account_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Any Account.
		@param AnyAcct Match any value of the Account segment
	*/
	public void setAnyAcct (boolean AnyAcct)
	{
		set_Value (COLUMNNAME_AnyAcct, Boolean.valueOf(AnyAcct));
	}

	/** Get Any Account.
		@return Match any value of the Account segment
	  */
	public boolean isAnyAcct()
	{
		Object oo = get_Value(COLUMNNAME_AnyAcct);
		if (oo != null)
		{
			 if (oo instanceof Boolean)
				 return ((Boolean)oo).booleanValue();
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Any Activity.
		@param AnyActivity Match any value of the Activity segment
	*/
	public void setAnyActivity (boolean AnyActivity)
	{
		set_Value (COLUMNNAME_AnyActivity, Boolean.valueOf(AnyActivity));
	}

	/** Get Any Activity.
		@return Match any value of the Activity segment
	  */
	public boolean isAnyActivity()
	{
		Object oo = get_Value(COLUMNNAME_AnyActivity);
		if (oo != null)
		{
			 if (oo instanceof Boolean)
				 return ((Boolean)oo).booleanValue();
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Any Asset.
		@param AnyAsset Match any value of the Asset segment
	*/
	public void setAnyAsset (boolean AnyAsset)
	{
		set_Value (COLUMNNAME_AnyAsset, Boolean.valueOf(AnyAsset));
	}

	/** Get Any Asset.
		@return Match any value of the Asset segment
	  */
	public boolean isAnyAsset()
	{
		Object oo = get_Value(COLUMNNAME_AnyAsset);
		if (oo != null)
		{
			 if (oo instanceof Boolean)
				 return ((Boolean)oo).booleanValue();
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Any Attribute Set Instance.
		@param AnyAttributeSetInstance Match any value of the Employee segment
	*/
	public void setAnyAttributeSetInstance (boolean AnyAttributeSetInstance)
	{
		set_Value (COLUMNNAME_AnyAttributeSetInstance, Boolean.valueOf(AnyAttributeSetInstance));
	}

	/** Get Any Attribute Set Instance.
		@return Match any value of the Employee segment
	  */
	public boolean isAnyAttributeSetInstance()
	{
		Object oo = get_Value(COLUMNNAME_AnyAttributeSetInstance);
		if (oo != null)
		{
			 if (oo instanceof Boolean)
				 return ((Boolean)oo).booleanValue();
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Any Bus.Partner.
		@param AnyBPartner Match any value of the Business Partner segment
	*/
	public void setAnyBPartner (boolean AnyBPartner)
	{
		set_Value (COLUMNNAME_AnyBPartner, Boolean.valueOf(AnyBPartner));
	}

	/** Get Any Bus.Partner.
		@return Match any value of the Business Partner segment
	  */
	public boolean isAnyBPartner()
	{
		Object oo = get_Value(COLUMNNAME_AnyBPartner);
		if (oo != null)
		{
			 if (oo instanceof Boolean)
				 return ((Boolean)oo).booleanValue();
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Any Campaign.
		@param AnyCampaign Match any value of the Campaign segment
	*/
	public void setAnyCampaign (boolean AnyCampaign)
	{
		set_Value (COLUMNNAME_AnyCampaign, Boolean.valueOf(AnyCampaign));
	}

	/** Get Any Campaign.
		@return Match any value of the Campaign segment
	  */
	public boolean isAnyCampaign()
	{
		Object oo = get_Value(COLUMNNAME_AnyCampaign);
		if (oo != null)
		{
			 if (oo instanceof Boolean)
				 return ((Boolean)oo).booleanValue();
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Any Charge.
		@param AnyCharge Match any value of the Charge segment
	*/
	public void setAnyCharge (boolean AnyCharge)
	{
		set_Value (COLUMNNAME_AnyCharge, Boolean.valueOf(AnyCharge));
	}

	/** Get Any Charge.
		@return Match any value of the Charge segment
	  */
	public boolean isAnyCharge()
	{
		Object oo = get_Value(COLUMNNAME_AnyCharge);
		if (oo != null)
		{
			 if (oo instanceof Boolean)
				 return ((Boolean)oo).booleanValue();
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Any Cost Center.
		@param AnyCostCenter Match any value of the Cost Center segment
	*/
	public void setAnyCostCenter (boolean AnyCostCenter)
	{
		set_Value (COLUMNNAME_AnyCostCenter, Boolean.valueOf(AnyCostCenter));
	}

	/** Get Any Cost Center.
		@return Match any value of the Cost Center segment
	  */
	public boolean isAnyCostCenter()
	{
		Object oo = get_Value(COLUMNNAME_AnyCostCenter);
		if (oo != null)
		{
			 if (oo instanceof Boolean)
				 return ((Boolean)oo).booleanValue();
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Any Department.
		@param AnyDepartment Match any value of the Department segment
	*/
	public void setAnyDepartment (boolean AnyDepartment)
	{
		set_Value (COLUMNNAME_AnyDepartment, Boolean.valueOf(AnyDepartment));
	}

	/** Get Any Department.
		@return Match any value of the Department segment
	  */
	public boolean isAnyDepartment()
	{
		Object oo = get_Value(COLUMNNAME_AnyDepartment);
		if (oo != null)
		{
			 if (oo instanceof Boolean)
				 return ((Boolean)oo).booleanValue();
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Any Employee.
		@param AnyEmployee Match any value of the Employee segment
	*/
	public void setAnyEmployee (boolean AnyEmployee)
	{
		set_Value (COLUMNNAME_AnyEmployee, Boolean.valueOf(AnyEmployee));
	}

	/** Get Any Employee.
		@return Match any value of the Employee segment
	  */
	public boolean isAnyEmployee()
	{
		Object oo = get_Value(COLUMNNAME_AnyEmployee);
		if (oo != null)
		{
			 if (oo instanceof Boolean)
				 return ((Boolean)oo).booleanValue();
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Any Location From.
		@param AnyLocFrom Match any value of the Location From segment
	*/
	public void setAnyLocFrom (boolean AnyLocFrom)
	{
		set_Value (COLUMNNAME_AnyLocFrom, Boolean.valueOf(AnyLocFrom));
	}

	/** Get Any Location From.
		@return Match any value of the Location From segment
	  */
	public boolean isAnyLocFrom()
	{
		Object oo = get_Value(COLUMNNAME_AnyLocFrom);
		if (oo != null)
		{
			 if (oo instanceof Boolean)
				 return ((Boolean)oo).booleanValue();
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Any Location To.
		@param AnyLocTo Match any value of the Location To segment
	*/
	public void setAnyLocTo (boolean AnyLocTo)
	{
		set_Value (COLUMNNAME_AnyLocTo, Boolean.valueOf(AnyLocTo));
	}

	/** Get Any Location To.
		@return Match any value of the Location To segment
	  */
	public boolean isAnyLocTo()
	{
		Object oo = get_Value(COLUMNNAME_AnyLocTo);
		if (oo != null)
		{
			 if (oo instanceof Boolean)
				 return ((Boolean)oo).booleanValue();
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Any Organization.
		@param AnyOrg Match any value of the Organization segment
	*/
	public void setAnyOrg (boolean AnyOrg)
	{
		set_Value (COLUMNNAME_AnyOrg, Boolean.valueOf(AnyOrg));
	}

	/** Get Any Organization.
		@return Match any value of the Organization segment
	  */
	public boolean isAnyOrg()
	{
		Object oo = get_Value(COLUMNNAME_AnyOrg);
		if (oo != null)
		{
			 if (oo instanceof Boolean)
				 return ((Boolean)oo).booleanValue();
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Any Trx Organization.
		@param AnyOrgTrx Match any value of the Transaction Organization segment
	*/
	public void setAnyOrgTrx (boolean AnyOrgTrx)
	{
		set_Value (COLUMNNAME_AnyOrgTrx, Boolean.valueOf(AnyOrgTrx));
	}

	/** Get Any Trx Organization.
		@return Match any value of the Transaction Organization segment
	  */
	public boolean isAnyOrgTrx()
	{
		Object oo = get_Value(COLUMNNAME_AnyOrgTrx);
		if (oo != null)
		{
			 if (oo instanceof Boolean)
				 return ((Boolean)oo).booleanValue();
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Any Product.
		@param AnyProduct Match any value of the Product segment
	*/
	public void setAnyProduct (boolean AnyProduct)
	{
		set_Value (COLUMNNAME_AnyProduct, Boolean.valueOf(AnyProduct));
	}

	/** Get Any Product.
		@return Match any value of the Product segment
	  */
	public boolean isAnyProduct()
	{
		Object oo = get_Value(COLUMNNAME_AnyProduct);
		if (oo != null)
		{
			 if (oo instanceof Boolean)
				 return ((Boolean)oo).booleanValue();
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Any Project.
		@param AnyProject Match any value of the Project segment
	*/
	public void setAnyProject (boolean AnyProject)
	{
		set_Value (COLUMNNAME_AnyProject, Boolean.valueOf(AnyProject));
	}

	/** Get Any Project.
		@return Match any value of the Project segment
	  */
	public boolean isAnyProject()
	{
		Object oo = get_Value(COLUMNNAME_AnyProject);
		if (oo != null)
		{
			 if (oo instanceof Boolean)
				 return ((Boolean)oo).booleanValue();
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Any Sales Region.
		@param AnySalesRegion Match any value of the Sales Region segment
	*/
	public void setAnySalesRegion (boolean AnySalesRegion)
	{
		set_Value (COLUMNNAME_AnySalesRegion, Boolean.valueOf(AnySalesRegion));
	}

	/** Get Any Sales Region.
		@return Match any value of the Sales Region segment
	  */
	public boolean isAnySalesRegion()
	{
		Object oo = get_Value(COLUMNNAME_AnySalesRegion);
		if (oo != null)
		{
			 if (oo instanceof Boolean)
				 return ((Boolean)oo).booleanValue();
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Any User 1.
		@param AnyUser1 Match any value of the User 1 segment
	*/
	public void setAnyUser1 (boolean AnyUser1)
	{
		set_Value (COLUMNNAME_AnyUser1, Boolean.valueOf(AnyUser1));
	}

	/** Get Any User 1.
		@return Match any value of the User 1 segment
	  */
	public boolean isAnyUser1()
	{
		Object oo = get_Value(COLUMNNAME_AnyUser1);
		if (oo != null)
		{
			 if (oo instanceof Boolean)
				 return ((Boolean)oo).booleanValue();
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Any User 2.
		@param AnyUser2 Match any value of the User 2 segment
	*/
	public void setAnyUser2 (boolean AnyUser2)
	{
		set_Value (COLUMNNAME_AnyUser2, Boolean.valueOf(AnyUser2));
	}

	/** Get Any User 2.
		@return Match any value of the User 2 segment
	  */
	public boolean isAnyUser2()
	{
		Object oo = get_Value(COLUMNNAME_AnyUser2);
		if (oo != null)
		{
			 if (oo instanceof Boolean)
				 return ((Boolean)oo).booleanValue();
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Any Warehouse.
		@param AnyWarehouse Match any value of the Warehouse segment
	*/
	public void setAnyWarehouse (boolean AnyWarehouse)
	{
		set_Value (COLUMNNAME_AnyWarehouse, Boolean.valueOf(AnyWarehouse));
	}

	/** Get Any Warehouse.
		@return Match any value of the Warehouse segment
	  */
	public boolean isAnyWarehouse()
	{
		Object oo = get_Value(COLUMNNAME_AnyWarehouse);
		if (oo != null)
		{
			 if (oo instanceof Boolean)
				 return ((Boolean)oo).booleanValue();
			return "Y".equals(oo);
		}
		return false;
	}

	public org.compiere.model.I_C_AcctSchema getC_AcctSchema() throws RuntimeException
	{
		return (org.compiere.model.I_C_AcctSchema)MTable.get(getCtx(), org.compiere.model.I_C_AcctSchema.Table_ID)
			.getPO(getC_AcctSchema_ID(), get_TrxName());
	}

	/** Set Accounting Schema.
		@param C_AcctSchema_ID Rules for accounting
	*/
	public void setC_AcctSchema_ID (int C_AcctSchema_ID)
	{
		if (C_AcctSchema_ID < 1)
			set_ValueNoCheck (COLUMNNAME_C_AcctSchema_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_C_AcctSchema_ID, Integer.valueOf(C_AcctSchema_ID));
	}

	/** Get Accounting Schema.
		@return Rules for accounting
	  */
	public int getC_AcctSchema_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_AcctSchema_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_Activity getC_Activity() throws RuntimeException
	{
		return (org.compiere.model.I_C_Activity)MTable.get(getCtx(), org.compiere.model.I_C_Activity.Table_ID)
			.getPO(getC_Activity_ID(), get_TrxName());
	}

	/** Set Activity.
		@param C_Activity_ID Business Activity
	*/
	public void setC_Activity_ID (int C_Activity_ID)
	{
		if (C_Activity_ID < 1)
			set_Value (COLUMNNAME_C_Activity_ID, null);
		else
			set_Value (COLUMNNAME_C_Activity_ID, Integer.valueOf(C_Activity_ID));
	}

	/** Get Activity.
		@return Business Activity
	  */
	public int getC_Activity_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Activity_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_BPartner getC_BPartner() throws RuntimeException
	{
		return (org.compiere.model.I_C_BPartner)MTable.get(getCtx(), org.compiere.model.I_C_BPartner.Table_ID)
			.getPO(getC_BPartner_ID(), get_TrxName());
	}

	/** Set Business Partner.
		@param C_BPartner_ID Identifies a Business Partner
	*/
	public void setC_BPartner_ID (int C_BPartner_ID)
	{
		if (C_BPartner_ID < 1)
			set_Value (COLUMNNAME_C_BPartner_ID, null);
		else
			set_Value (COLUMNNAME_C_BPartner_ID, Integer.valueOf(C_BPartner_ID));
	}

	/** Get Business Partner.
		@return Identifies a Business Partner
	  */
	public int getC_BPartner_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_BPartner_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_Campaign getC_Campaign() throws RuntimeException
	{
		return (org.compiere.model.I_C_Campaign)MTable.get(getCtx(), org.compiere.model.I_C_Campaign.Table_ID)
			.getPO(getC_Campaign_ID(), get_TrxName());
	}

	/** Set Campaign.
		@param C_Campaign_ID Marketing Campaign
	*/
	public void setC_Campaign_ID (int C_Campaign_ID)
	{
		if (C_Campaign_ID < 1)
			set_Value (COLUMNNAME_C_Campaign_ID, null);
		else
			set_Value (COLUMNNAME_C_Campaign_ID, Integer.valueOf(C_Campaign_ID));
	}

	/** Get Campaign.
		@return Marketing Campaign
	  */
	public int getC_Campaign_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Campaign_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_Charge getC_Charge() throws RuntimeException
	{
		return (org.compiere.model.I_C_Charge)MTable.get(getCtx(), org.compiere.model.I_C_Charge.Table_ID)
			.getPO(getC_Charge_ID(), get_TrxName());
	}

	/** Set Charge.
		@param C_Charge_ID Additional document charges
	*/
	public void setC_Charge_ID (int C_Charge_ID)
	{
		if (C_Charge_ID < 1)
			set_Value (COLUMNNAME_C_Charge_ID, null);
		else
			set_Value (COLUMNNAME_C_Charge_ID, Integer.valueOf(C_Charge_ID));
	}

	/** Get Charge.
		@return Additional document charges
	  */
	public int getC_Charge_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Charge_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_CostCenter getC_CostCenter() throws RuntimeException
	{
		return (org.compiere.model.I_C_CostCenter)MTable.get(getCtx(), org.compiere.model.I_C_CostCenter.Table_ID)
			.getPO(getC_CostCenter_ID(), get_TrxName());
	}

	/** Set Cost Center.
		@param C_CostCenter_ID Cost Center
	*/
	public void setC_CostCenter_ID (int C_CostCenter_ID)
	{
		if (C_CostCenter_ID < 1)
			set_Value (COLUMNNAME_C_CostCenter_ID, null);
		else
			set_Value (COLUMNNAME_C_CostCenter_ID, Integer.valueOf(C_CostCenter_ID));
	}

	/** Get Cost Center.
		@return Cost Center	  */
	public int getC_CostCenter_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_CostCenter_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_Department getC_Department() throws RuntimeException
	{
		return (org.compiere.model.I_C_Department)MTable.get(getCtx(), org.compiere.model.I_C_Department.Table_ID)
			.getPO(getC_Department_ID(), get_TrxName());
	}

	/** Set Department.
		@param C_Department_ID Department
	*/
	public void setC_Department_ID (int C_Department_ID)
	{
		if (C_Department_ID < 1)
			set_Value (COLUMNNAME_C_Department_ID, null);
		else
			set_Value (COLUMNNAME_C_Department_ID, Integer.valueOf(C_Department_ID));
	}

	/** Get Department.
		@return Department	  */
	public int getC_Department_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Department_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_DocType getC_DocType() throws RuntimeException
	{
		return (org.compiere.model.I_C_DocType)MTable.get(getCtx(), org.compiere.model.I_C_DocType.Table_ID)
			.getPO(getC_DocType_ID(), get_TrxName());
	}

	/** Set Document Type.
		@param C_DocType_ID Document type or rules
	*/
	public void setC_DocType_ID (int C_DocType_ID)
	{
		if (C_DocType_ID < 0)
			set_Value (COLUMNNAME_C_DocType_ID, null);
		else
			set_Value (COLUMNNAME_C_DocType_ID, Integer.valueOf(C_DocType_ID));
	}

	/** Get Document Type.
		@return Document type or rules
	  */
	public int getC_DocType_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_DocType_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_BPartner getC_Employee() throws RuntimeException
	{
		return (org.compiere.model.I_C_BPartner)MTable.get(getCtx(), org.compiere.model.I_C_BPartner.Table_ID)
			.getPO(getC_Employee_ID(), get_TrxName());
	}

	/** Set Employee.
		@param C_Employee_ID Identifies a Business Partner
	*/
	public void setC_Employee_ID (int C_Employee_ID)
	{
		if (C_Employee_ID < 1)
			set_Value (COLUMNNAME_C_Employee_ID, null);
		else
			set_Value (COLUMNNAME_C_Employee_ID, Integer.valueOf(C_Employee_ID));
	}

	/** Get Employee.
		@return Identifies a Business Partner
	  */
	public int getC_Employee_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Employee_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_Location getC_LocFrom() throws RuntimeException
	{
		return (org.compiere.model.I_C_Location)MTable.get(getCtx(), org.compiere.model.I_C_Location.Table_ID)
			.getPO(getC_LocFrom_ID(), get_TrxName());
	}

	/** Set Location From.
		@param C_LocFrom_ID Location that inventory was moved from
	*/
	public void setC_LocFrom_ID (int C_LocFrom_ID)
	{
		if (C_LocFrom_ID < 1)
			set_Value (COLUMNNAME_C_LocFrom_ID, null);
		else
			set_Value (COLUMNNAME_C_LocFrom_ID, Integer.valueOf(C_LocFrom_ID));
	}

	/** Get Location From.
		@return Location that inventory was moved from
	  */
	public int getC_LocFrom_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_LocFrom_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_Location getC_LocTo() throws RuntimeException
	{
		return (org.compiere.model.I_C_Location)MTable.get(getCtx(), org.compiere.model.I_C_Location.Table_ID)
			.getPO(getC_LocTo_ID(), get_TrxName());
	}

	/** Set Location To.
		@param C_LocTo_ID Location that inventory was moved to
	*/
	public void setC_LocTo_ID (int C_LocTo_ID)
	{
		if (C_LocTo_ID < 1)
			set_Value (COLUMNNAME_C_LocTo_ID, null);
		else
			set_Value (COLUMNNAME_C_LocTo_ID, Integer.valueOf(C_LocTo_ID));
	}

	/** Get Location To.
		@return Location that inventory was moved to
	  */
	public int getC_LocTo_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_LocTo_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_Project getC_Project() throws RuntimeException
	{
		return (org.compiere.model.I_C_Project)MTable.get(getCtx(), org.compiere.model.I_C_Project.Table_ID)
			.getPO(getC_Project_ID(), get_TrxName());
	}

	/** Set Project.
		@param C_Project_ID Financial Project
	*/
	public void setC_Project_ID (int C_Project_ID)
	{
		if (C_Project_ID < 1)
			set_Value (COLUMNNAME_C_Project_ID, null);
		else
			set_Value (COLUMNNAME_C_Project_ID, Integer.valueOf(C_Project_ID));
	}

	/** Get Project.
		@return Financial Project
	  */
	public int getC_Project_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Project_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_SalesRegion getC_SalesRegion() throws RuntimeException
	{
		return (org.compiere.model.I_C_SalesRegion)MTable.get(getCtx(), org.compiere.model.I_C_SalesRegion.Table_ID)
			.getPO(getC_SalesRegion_ID(), get_TrxName());
	}

	/** Set Sales Region.
		@param C_SalesRegion_ID Sales coverage region
	*/
	public void setC_SalesRegion_ID (int C_SalesRegion_ID)
	{
		if (C_SalesRegion_ID < 1)
			set_Value (COLUMNNAME_C_SalesRegion_ID, null);
		else
			set_Value (COLUMNNAME_C_SalesRegion_ID, Integer.valueOf(C_SalesRegion_ID));
	}

	/** Get Sales Region.
		@return Sales coverage region
	  */
	public int getC_SalesRegion_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_SalesRegion_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Description.
		@param Description Optional short description of the record
	*/
	public void setDescription (String Description)
	{
		set_Value (COLUMNNAME_Description, Description);
	}

	/** Get Description.
		@return Optional short description of the record
	  */
	public String getDescription()
	{
		return (String)get_Value(COLUMNNAME_Description);
	}

	/** Set GL Distribution.
		@param GL_Distribution_ID General Ledger Distribution
	*/
	public void setGL_Distribution_ID (int GL_Distribution_ID)
	{
		if (GL_Distribution_ID < 1)
			set_ValueNoCheck (COLUMNNAME_GL_Distribution_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_GL_Distribution_ID, Integer.valueOf(GL_Distribution_ID));
	}

	/** Get GL Distribution.
		@return General Ledger Distribution
	  */
	public int getGL_Distribution_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_GL_Distribution_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set GL_Distribution_UU.
		@param GL_Distribution_UU GL_Distribution_UU
	*/
	public void setGL_Distribution_UU (String GL_Distribution_UU)
	{
		set_Value (COLUMNNAME_GL_Distribution_UU, GL_Distribution_UU);
	}

	/** Get GL_Distribution_UU.
		@return GL_Distribution_UU	  */
	public String getGL_Distribution_UU()
	{
		return (String)get_Value(COLUMNNAME_GL_Distribution_UU);
	}

	/** Set Comment/Help.
		@param Help Comment or Hint
	*/
	public void setHelp (String Help)
	{
		set_Value (COLUMNNAME_Help, Help);
	}

	/** Get Comment/Help.
		@return Comment or Hint
	  */
	public String getHelp()
	{
		return (String)get_Value(COLUMNNAME_Help);
	}

	/** Set Create Reversal.
		@param IsCreateReversal Indicates that reversal movement will be created, if disabled the original movement will be deleted.
	*/
	public void setIsCreateReversal (boolean IsCreateReversal)
	{
		set_Value (COLUMNNAME_IsCreateReversal, Boolean.valueOf(IsCreateReversal));
	}

	/** Get Create Reversal.
		@return Indicates that reversal movement will be created, if disabled the original movement will be deleted.
	  */
	public boolean isCreateReversal()
	{
		Object oo = get_Value(COLUMNNAME_IsCreateReversal);
		if (oo != null)
		{
			 if (oo instanceof Boolean)
				 return ((Boolean)oo).booleanValue();
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Valid.
		@param IsValid Element is valid
	*/
	public void setIsValid (boolean IsValid)
	{
		set_Value (COLUMNNAME_IsValid, Boolean.valueOf(IsValid));
	}

	/** Get Valid.
		@return Element is valid
	  */
	public boolean isValid()
	{
		Object oo = get_Value(COLUMNNAME_IsValid);
		if (oo != null)
		{
			 if (oo instanceof Boolean)
				 return ((Boolean)oo).booleanValue();
			return "Y".equals(oo);
		}
		return false;
	}

	public org.compiere.model.I_M_AttributeSetInstance getM_AttributeSetInstance() throws RuntimeException
	{
		return (org.compiere.model.I_M_AttributeSetInstance)MTable.get(getCtx(), org.compiere.model.I_M_AttributeSetInstance.Table_ID)
			.getPO(getM_AttributeSetInstance_ID(), get_TrxName());
	}

	/** Set Attribute Set Instance.
		@param M_AttributeSetInstance_ID Product Attribute Set Instance
	*/
	public void setM_AttributeSetInstance_ID (int M_AttributeSetInstance_ID)
	{
		if (M_AttributeSetInstance_ID < 0)
			set_Value (COLUMNNAME_M_AttributeSetInstance_ID, null);
		else
			set_Value (COLUMNNAME_M_AttributeSetInstance_ID, Integer.valueOf(M_AttributeSetInstance_ID));
	}

	/** Get Attribute Set Instance.
		@return Product Attribute Set Instance
	  */
	public int getM_AttributeSetInstance_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_M_AttributeSetInstance_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_M_Product getM_Product() throws RuntimeException
	{
		return (org.compiere.model.I_M_Product)MTable.get(getCtx(), org.compiere.model.I_M_Product.Table_ID)
			.getPO(getM_Product_ID(), get_TrxName());
	}

	/** Set Product.
		@param M_Product_ID Product, Service, Item
	*/
	public void setM_Product_ID (int M_Product_ID)
	{
		if (M_Product_ID < 1)
			set_Value (COLUMNNAME_M_Product_ID, null);
		else
			set_Value (COLUMNNAME_M_Product_ID, Integer.valueOf(M_Product_ID));
	}

	/** Get Product.
		@return Product, Service, Item
	  */
	public int getM_Product_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_M_Product_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_M_Warehouse getM_Warehouse() throws RuntimeException
	{
		return (org.compiere.model.I_M_Warehouse)MTable.get(getCtx(), org.compiere.model.I_M_Warehouse.Table_ID)
			.getPO(getM_Warehouse_ID(), get_TrxName());
	}

	/** Set Warehouse.
		@param M_Warehouse_ID Storage Warehouse and Service Point
	*/
	public void setM_Warehouse_ID (int M_Warehouse_ID)
	{
		if (M_Warehouse_ID < 1)
			set_Value (COLUMNNAME_M_Warehouse_ID, null);
		else
			set_Value (COLUMNNAME_M_Warehouse_ID, Integer.valueOf(M_Warehouse_ID));
	}

	/** Get Warehouse.
		@return Storage Warehouse and Service Point
	  */
	public int getM_Warehouse_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_M_Warehouse_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Name.
		@param Name Alphanumeric identifier of the entity
	*/
	public void setName (String Name)
	{
		set_Value (COLUMNNAME_Name, Name);
	}

	/** Get Name.
		@return Alphanumeric identifier of the entity
	  */
	public String getName()
	{
		return (String)get_Value(COLUMNNAME_Name);
	}

    /** Get Record ID/ColumnName
        @return ID/ColumnName pair
      */
    public KeyNamePair getKeyNamePair()
    {
        return new KeyNamePair(get_ID(), getName());
    }

	/** Set Organization.
		@param Org_ID Organizational entity within tenant
	*/
	public void setOrg_ID (int Org_ID)
	{
		if (Org_ID < 1)
			set_Value (COLUMNNAME_Org_ID, null);
		else
			set_Value (COLUMNNAME_Org_ID, Integer.valueOf(Org_ID));
	}

	/** Get Organization.
		@return Organizational entity within tenant
	  */
	public int getOrg_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Org_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Total Percent.
		@param PercentTotal Sum of the Percent details 
	*/
	public void setPercentTotal (BigDecimal PercentTotal)
	{
		set_Value (COLUMNNAME_PercentTotal, PercentTotal);
	}

	/** Get Total Percent.
		@return Sum of the Percent details 
	  */
	public BigDecimal getPercentTotal()
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_PercentTotal);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** PostingType AD_Reference_ID=125 */
	public static final int POSTINGTYPE_AD_Reference_ID=125;
	/** Actual = A */
	public static final String POSTINGTYPE_Actual = "A";
	/** Budget = B */
	public static final String POSTINGTYPE_Budget = "B";
	/** Commitment = E */
	public static final String POSTINGTYPE_Commitment = "E";
	/** Reservation = R */
	public static final String POSTINGTYPE_Reservation = "R";
	/** Statistical = S */
	public static final String POSTINGTYPE_Statistical = "S";
	/** Set Posting Type.
		@param PostingType The type of posted amount for the transaction
	*/
	public void setPostingType (String PostingType)
	{

		set_Value (COLUMNNAME_PostingType, PostingType);
	}

	/** Get Posting Type.
		@return The type of posted amount for the transaction
	  */
	public String getPostingType()
	{
		return (String)get_Value(COLUMNNAME_PostingType);
	}

	/** Set Process Now.
		@param Processing Process Now
	*/
	public void setProcessing (boolean Processing)
	{
		set_Value (COLUMNNAME_Processing, Boolean.valueOf(Processing));
	}

	/** Get Process Now.
		@return Process Now	  */
	public boolean isProcessing()
	{
		Object oo = get_Value(COLUMNNAME_Processing);
		if (oo != null)
		{
			 if (oo instanceof Boolean)
				 return ((Boolean)oo).booleanValue();
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Sequence.
		@param SeqNo Method of ordering records; lowest number comes first
	*/
	public void setSeqNo (int SeqNo)
	{
		set_Value (COLUMNNAME_SeqNo, Integer.valueOf(SeqNo));
	}

	/** Get Sequence.
		@return Method of ordering records; lowest number comes first
	  */
	public int getSeqNo()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_SeqNo);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_ElementValue getUser1() throws RuntimeException
	{
		return (org.compiere.model.I_C_ElementValue)MTable.get(getCtx(), org.compiere.model.I_C_ElementValue.Table_ID)
			.getPO(getUser1_ID(), get_TrxName());
	}

	/** Set User Element List 1.
		@param User1_ID User defined list element #1
	*/
	public void setUser1_ID (int User1_ID)
	{
		if (User1_ID < 1)
			set_Value (COLUMNNAME_User1_ID, null);
		else
			set_Value (COLUMNNAME_User1_ID, Integer.valueOf(User1_ID));
	}

	/** Get User Element List 1.
		@return User defined list element #1
	  */
	public int getUser1_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_User1_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_ElementValue getUser2() throws RuntimeException
	{
		return (org.compiere.model.I_C_ElementValue)MTable.get(getCtx(), org.compiere.model.I_C_ElementValue.Table_ID)
			.getPO(getUser2_ID(), get_TrxName());
	}

	/** Set User Element List 2.
		@param User2_ID User defined list element #2
	*/
	public void setUser2_ID (int User2_ID)
	{
		if (User2_ID < 1)
			set_Value (COLUMNNAME_User2_ID, null);
		else
			set_Value (COLUMNNAME_User2_ID, Integer.valueOf(User2_ID));
	}

	/** Get User Element List 2.
		@return User defined list element #2
	  */
	public int getUser2_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_User2_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Valid from.
		@param ValidFrom Valid from including this date (first day)
	*/
	public void setValidFrom (Timestamp ValidFrom)
	{
		set_Value (COLUMNNAME_ValidFrom, ValidFrom);
	}

	/** Get Valid from.
		@return Valid from including this date (first day)
	  */
	public Timestamp getValidFrom()
	{
		return (Timestamp)get_Value(COLUMNNAME_ValidFrom);
	}

	/** Set Valid to.
		@param ValidTo Valid to including this date (last day)
	*/
	public void setValidTo (Timestamp ValidTo)
	{
		set_Value (COLUMNNAME_ValidTo, ValidTo);
	}

	/** Get Valid to.
		@return Valid to including this date (last day)
	  */
	public Timestamp getValidTo()
	{
		return (Timestamp)get_Value(COLUMNNAME_ValidTo);
	}
}