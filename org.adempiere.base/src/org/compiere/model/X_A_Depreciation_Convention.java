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

/** Generated Model for A_Depreciation_Convention
 *  @author iDempiere (generated)
 *  @version Release 12 - $Id$ */
@org.adempiere.base.Model(table="A_Depreciation_Convention")
public class X_A_Depreciation_Convention extends PO implements I_A_Depreciation_Convention, I_Persistent
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20241222L;

    /** Standard Constructor */
    public X_A_Depreciation_Convention (Properties ctx, int A_Depreciation_Convention_ID, String trxName)
    {
      super (ctx, A_Depreciation_Convention_ID, trxName);
      /** if (A_Depreciation_Convention_ID == 0)
        {
			setA_Depreciation_Convention_ID (0);
			setProcessed (false);
// N
        } */
    }

    /** Standard Constructor */
    public X_A_Depreciation_Convention (Properties ctx, int A_Depreciation_Convention_ID, String trxName, String ... virtualColumns)
    {
      super (ctx, A_Depreciation_Convention_ID, trxName, virtualColumns);
      /** if (A_Depreciation_Convention_ID == 0)
        {
			setA_Depreciation_Convention_ID (0);
			setProcessed (false);
// N
        } */
    }

    /** Standard Constructor */
    public X_A_Depreciation_Convention (Properties ctx, String A_Depreciation_Convention_UU, String trxName)
    {
      super (ctx, A_Depreciation_Convention_UU, trxName);
      /** if (A_Depreciation_Convention_UU == null)
        {
			setA_Depreciation_Convention_ID (0);
			setProcessed (false);
// N
        } */
    }

    /** Standard Constructor */
    public X_A_Depreciation_Convention (Properties ctx, String A_Depreciation_Convention_UU, String trxName, String ... virtualColumns)
    {
      super (ctx, A_Depreciation_Convention_UU, trxName, virtualColumns);
      /** if (A_Depreciation_Convention_UU == null)
        {
			setA_Depreciation_Convention_ID (0);
			setProcessed (false);
// N
        } */
    }

    /** Load Constructor */
    public X_A_Depreciation_Convention (Properties ctx, ResultSet rs, String trxName)
    {
      super (ctx, rs, trxName);
    }

    /** AccessLevel
      * @return 7 - System - Client - Org
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
      StringBuilder sb = new StringBuilder ("X_A_Depreciation_Convention[")
        .append(get_ID()).append(",Name=").append(getName()).append("]");
      return sb.toString();
    }

	/** Set Depreciation Convention.
		@param A_Depreciation_Convention_ID Depreciation Convention
	*/
	public void setA_Depreciation_Convention_ID (int A_Depreciation_Convention_ID)
	{
		if (A_Depreciation_Convention_ID < 1)
			set_ValueNoCheck (COLUMNNAME_A_Depreciation_Convention_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_A_Depreciation_Convention_ID, Integer.valueOf(A_Depreciation_Convention_ID));
	}

	/** Get Depreciation Convention.
		@return Depreciation Convention	  */
	public int getA_Depreciation_Convention_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_A_Depreciation_Convention_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set A_Depreciation_Convention_UU.
		@param A_Depreciation_Convention_UU A_Depreciation_Convention_UU
	*/
	public void setA_Depreciation_Convention_UU (String A_Depreciation_Convention_UU)
	{
		set_Value (COLUMNNAME_A_Depreciation_Convention_UU, A_Depreciation_Convention_UU);
	}

	/** Get A_Depreciation_Convention_UU.
		@return A_Depreciation_Convention_UU	  */
	public String getA_Depreciation_Convention_UU()
	{
		return (String)get_Value(COLUMNNAME_A_Depreciation_Convention_UU);
	}

	/** Set Convention Type.
		@param ConventionType Convention Type
	*/
	public void setConventionType (String ConventionType)
	{
		set_Value (COLUMNNAME_ConventionType, ConventionType);
	}

	/** Get Convention Type.
		@return Convention Type	  */
	public String getConventionType()
	{
		return (String)get_Value(COLUMNNAME_ConventionType);
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

	/** Set Processed.
		@param Processed The document has been processed
	*/
	public void setProcessed (boolean Processed)
	{
		set_Value (COLUMNNAME_Processed, Boolean.valueOf(Processed));
	}

	/** Get Processed.
		@return The document has been processed
	  */
	public boolean isProcessed()
	{
		Object oo = get_Value(COLUMNNAME_Processed);
		if (oo != null)
		{
			 if (oo instanceof Boolean)
				 return ((Boolean)oo).booleanValue();
			return "Y".equals(oo);
		}
		return false;
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

	/** Set Text Message.
		@param TextMsg Text Message
	*/
	public void setTextMsg (String TextMsg)
	{
		set_Value (COLUMNNAME_TextMsg, TextMsg);
	}

	/** Get Text Message.
		@return Text Message
	  */
	public String getTextMsg()
	{
		return (String)get_Value(COLUMNNAME_TextMsg);
	}
}