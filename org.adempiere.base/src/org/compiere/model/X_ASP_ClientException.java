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

import java.sql.ResultSet;
import java.util.Properties;

/** Generated Model for ASP_ClientException
 *  @author iDempiere (generated)
 *  @version Release 12 - $Id$ */
@org.adempiere.base.Model(table="ASP_ClientException")
public class X_ASP_ClientException extends PO implements I_ASP_ClientException, I_Persistent
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20241222L;

    /** Standard Constructor */
    public X_ASP_ClientException (Properties ctx, int ASP_ClientException_ID, String trxName)
    {
      super (ctx, ASP_ClientException_ID, trxName);
      /** if (ASP_ClientException_ID == 0)
        {
			setASP_ClientException_ID (0);
			setASP_Status (null);
// S
        } */
    }

    /** Standard Constructor */
    public X_ASP_ClientException (Properties ctx, int ASP_ClientException_ID, String trxName, String ... virtualColumns)
    {
      super (ctx, ASP_ClientException_ID, trxName, virtualColumns);
      /** if (ASP_ClientException_ID == 0)
        {
			setASP_ClientException_ID (0);
			setASP_Status (null);
// S
        } */
    }

    /** Standard Constructor */
    public X_ASP_ClientException (Properties ctx, String ASP_ClientException_UU, String trxName)
    {
      super (ctx, ASP_ClientException_UU, trxName);
      /** if (ASP_ClientException_UU == null)
        {
			setASP_ClientException_ID (0);
			setASP_Status (null);
// S
        } */
    }

    /** Standard Constructor */
    public X_ASP_ClientException (Properties ctx, String ASP_ClientException_UU, String trxName, String ... virtualColumns)
    {
      super (ctx, ASP_ClientException_UU, trxName, virtualColumns);
      /** if (ASP_ClientException_UU == null)
        {
			setASP_ClientException_ID (0);
			setASP_Status (null);
// S
        } */
    }

    /** Load Constructor */
    public X_ASP_ClientException (Properties ctx, ResultSet rs, String trxName)
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
      StringBuilder sb = new StringBuilder ("X_ASP_ClientException[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	public org.compiere.model.I_AD_Field getAD_Field() throws RuntimeException
	{
		return (org.compiere.model.I_AD_Field)MTable.get(getCtx(), org.compiere.model.I_AD_Field.Table_ID)
			.getPO(getAD_Field_ID(), get_TrxName());
	}

	/** Set Field.
		@param AD_Field_ID Field on a database table
	*/
	public void setAD_Field_ID (int AD_Field_ID)
	{
		if (AD_Field_ID < 1)
			set_Value (COLUMNNAME_AD_Field_ID, null);
		else
			set_Value (COLUMNNAME_AD_Field_ID, Integer.valueOf(AD_Field_ID));
	}

	/** Get Field.
		@return Field on a database table
	  */
	public int getAD_Field_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_AD_Field_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_AD_Form getAD_Form() throws RuntimeException
	{
		return (org.compiere.model.I_AD_Form)MTable.get(getCtx(), org.compiere.model.I_AD_Form.Table_ID)
			.getPO(getAD_Form_ID(), get_TrxName());
	}

	/** Set Special Form.
		@param AD_Form_ID Special Form
	*/
	public void setAD_Form_ID (int AD_Form_ID)
	{
		if (AD_Form_ID < 1)
			set_Value (COLUMNNAME_AD_Form_ID, null);
		else
			set_Value (COLUMNNAME_AD_Form_ID, Integer.valueOf(AD_Form_ID));
	}

	/** Get Special Form.
		@return Special Form
	  */
	public int getAD_Form_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_AD_Form_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_AD_Process getAD_Process() throws RuntimeException
	{
		return (org.compiere.model.I_AD_Process)MTable.get(getCtx(), org.compiere.model.I_AD_Process.Table_ID)
			.getPO(getAD_Process_ID(), get_TrxName());
	}

	/** Set Process.
		@param AD_Process_ID Process or Report
	*/
	public void setAD_Process_ID (int AD_Process_ID)
	{
		if (AD_Process_ID < 1)
			set_Value (COLUMNNAME_AD_Process_ID, null);
		else
			set_Value (COLUMNNAME_AD_Process_ID, Integer.valueOf(AD_Process_ID));
	}

	/** Get Process.
		@return Process or Report
	  */
	public int getAD_Process_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_AD_Process_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_AD_Process_Para getAD_Process_Para() throws RuntimeException
	{
		return (org.compiere.model.I_AD_Process_Para)MTable.get(getCtx(), org.compiere.model.I_AD_Process_Para.Table_ID)
			.getPO(getAD_Process_Para_ID(), get_TrxName());
	}

	/** Set Process Parameter.
		@param AD_Process_Para_ID Process Parameter
	*/
	public void setAD_Process_Para_ID (int AD_Process_Para_ID)
	{
		if (AD_Process_Para_ID < 1)
			set_Value (COLUMNNAME_AD_Process_Para_ID, null);
		else
			set_Value (COLUMNNAME_AD_Process_Para_ID, Integer.valueOf(AD_Process_Para_ID));
	}

	/** Get Process Parameter.
		@return Process Parameter	  */
	public int getAD_Process_Para_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_AD_Process_Para_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_AD_Tab getAD_Tab() throws RuntimeException
	{
		return (org.compiere.model.I_AD_Tab)MTable.get(getCtx(), org.compiere.model.I_AD_Tab.Table_ID)
			.getPO(getAD_Tab_ID(), get_TrxName());
	}

	/** Set Tab.
		@param AD_Tab_ID Tab within a Window
	*/
	public void setAD_Tab_ID (int AD_Tab_ID)
	{
		if (AD_Tab_ID < 1)
			set_Value (COLUMNNAME_AD_Tab_ID, null);
		else
			set_Value (COLUMNNAME_AD_Tab_ID, Integer.valueOf(AD_Tab_ID));
	}

	/** Get Tab.
		@return Tab within a Window
	  */
	public int getAD_Tab_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_AD_Tab_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_AD_Task getAD_Task() throws RuntimeException
	{
		return (org.compiere.model.I_AD_Task)MTable.get(getCtx(), org.compiere.model.I_AD_Task.Table_ID)
			.getPO(getAD_Task_ID(), get_TrxName());
	}

	/** Set OS Task.
		@param AD_Task_ID Operation System Task
	*/
	public void setAD_Task_ID (int AD_Task_ID)
	{
		if (AD_Task_ID < 1)
			set_Value (COLUMNNAME_AD_Task_ID, null);
		else
			set_Value (COLUMNNAME_AD_Task_ID, Integer.valueOf(AD_Task_ID));
	}

	/** Get OS Task.
		@return Operation System Task
	  */
	public int getAD_Task_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_AD_Task_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_AD_WF_Node getAD_WF_Node() throws RuntimeException
	{
		return (org.compiere.model.I_AD_WF_Node)MTable.get(getCtx(), org.compiere.model.I_AD_WF_Node.Table_ID)
			.getPO(getAD_WF_Node_ID(), get_TrxName());
	}

	/** Set Node.
		@param AD_WF_Node_ID Workflow Node (activity), step or process
	*/
	public void setAD_WF_Node_ID (int AD_WF_Node_ID)
	{
		if (AD_WF_Node_ID < 1)
			set_Value (COLUMNNAME_AD_WF_Node_ID, null);
		else
			set_Value (COLUMNNAME_AD_WF_Node_ID, Integer.valueOf(AD_WF_Node_ID));
	}

	/** Get Node.
		@return Workflow Node (activity), step or process
	  */
	public int getAD_WF_Node_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_AD_WF_Node_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_AD_Window getAD_Window() throws RuntimeException
	{
		return (org.compiere.model.I_AD_Window)MTable.get(getCtx(), org.compiere.model.I_AD_Window.Table_ID)
			.getPO(getAD_Window_ID(), get_TrxName());
	}

	/** Set Window.
		@param AD_Window_ID Data entry or display window
	*/
	public void setAD_Window_ID (int AD_Window_ID)
	{
		if (AD_Window_ID < 1)
			set_Value (COLUMNNAME_AD_Window_ID, null);
		else
			set_Value (COLUMNNAME_AD_Window_ID, Integer.valueOf(AD_Window_ID));
	}

	/** Get Window.
		@return Data entry or display window
	  */
	public int getAD_Window_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_AD_Window_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_AD_Workflow getAD_Workflow() throws RuntimeException
	{
		return (org.compiere.model.I_AD_Workflow)MTable.get(getCtx(), org.compiere.model.I_AD_Workflow.Table_ID)
			.getPO(getAD_Workflow_ID(), get_TrxName());
	}

	/** Set Workflow.
		@param AD_Workflow_ID Workflow or combination of tasks
	*/
	public void setAD_Workflow_ID (int AD_Workflow_ID)
	{
		if (AD_Workflow_ID < 1)
			set_Value (COLUMNNAME_AD_Workflow_ID, null);
		else
			set_Value (COLUMNNAME_AD_Workflow_ID, Integer.valueOf(AD_Workflow_ID));
	}

	/** Get Workflow.
		@return Workflow or combination of tasks
	  */
	public int getAD_Workflow_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_AD_Workflow_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Tenant Exception.
		@param ASP_ClientException_ID Tenant Exception
	*/
	public void setASP_ClientException_ID (int ASP_ClientException_ID)
	{
		if (ASP_ClientException_ID < 1)
			set_ValueNoCheck (COLUMNNAME_ASP_ClientException_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_ASP_ClientException_ID, Integer.valueOf(ASP_ClientException_ID));
	}

	/** Get Tenant Exception.
		@return Tenant Exception	  */
	public int getASP_ClientException_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_ASP_ClientException_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set ASP_ClientException_UU.
		@param ASP_ClientException_UU ASP_ClientException_UU
	*/
	public void setASP_ClientException_UU (String ASP_ClientException_UU)
	{
		set_Value (COLUMNNAME_ASP_ClientException_UU, ASP_ClientException_UU);
	}

	/** Get ASP_ClientException_UU.
		@return ASP_ClientException_UU	  */
	public String getASP_ClientException_UU()
	{
		return (String)get_Value(COLUMNNAME_ASP_ClientException_UU);
	}

	/** ASP_Status AD_Reference_ID=53234 */
	public static final int ASP_STATUS_AD_Reference_ID=53234;
	/** Hide = H */
	public static final String ASP_STATUS_Hide = "H";
	/** Show = S */
	public static final String ASP_STATUS_Show = "S";
	/** Undefined = U */
	public static final String ASP_STATUS_Undefined = "U";
	/** Set ASP Status.
		@param ASP_Status ASP Status
	*/
	public void setASP_Status (String ASP_Status)
	{

		set_Value (COLUMNNAME_ASP_Status, ASP_Status);
	}

	/** Get ASP Status.
		@return ASP Status	  */
	public String getASP_Status()
	{
		return (String)get_Value(COLUMNNAME_ASP_Status);
	}
}