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
import org.compiere.util.KeyNamePair;

/** Generated Model for ASP_Module
 *  @author iDempiere (generated)
 *  @version Release 12 - $Id$ */
@org.adempiere.base.Model(table="ASP_Module")
public class X_ASP_Module extends PO implements I_ASP_Module, I_Persistent
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20241222L;

    /** Standard Constructor */
    public X_ASP_Module (Properties ctx, int ASP_Module_ID, String trxName)
    {
      super (ctx, ASP_Module_ID, trxName);
      /** if (ASP_Module_ID == 0)
        {
			setASP_Module_ID (0);
			setName (null);
			setValue (null);
        } */
    }

    /** Standard Constructor */
    public X_ASP_Module (Properties ctx, int ASP_Module_ID, String trxName, String ... virtualColumns)
    {
      super (ctx, ASP_Module_ID, trxName, virtualColumns);
      /** if (ASP_Module_ID == 0)
        {
			setASP_Module_ID (0);
			setName (null);
			setValue (null);
        } */
    }

    /** Standard Constructor */
    public X_ASP_Module (Properties ctx, String ASP_Module_UU, String trxName)
    {
      super (ctx, ASP_Module_UU, trxName);
      /** if (ASP_Module_UU == null)
        {
			setASP_Module_ID (0);
			setName (null);
			setValue (null);
        } */
    }

    /** Standard Constructor */
    public X_ASP_Module (Properties ctx, String ASP_Module_UU, String trxName, String ... virtualColumns)
    {
      super (ctx, ASP_Module_UU, trxName, virtualColumns);
      /** if (ASP_Module_UU == null)
        {
			setASP_Module_ID (0);
			setName (null);
			setValue (null);
        } */
    }

    /** Load Constructor */
    public X_ASP_Module (Properties ctx, ResultSet rs, String trxName)
    {
      super (ctx, rs, trxName);
    }

    /** AccessLevel
      * @return 4 - System
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
      StringBuilder sb = new StringBuilder ("X_ASP_Module[")
        .append(get_ID()).append(",Name=").append(getName()).append("]");
      return sb.toString();
    }

	/** Set ASP Module.
		@param ASP_Module_ID ASP Module
	*/
	public void setASP_Module_ID (int ASP_Module_ID)
	{
		if (ASP_Module_ID < 1)
			set_ValueNoCheck (COLUMNNAME_ASP_Module_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_ASP_Module_ID, Integer.valueOf(ASP_Module_ID));
	}

	/** Get ASP Module.
		@return ASP Module	  */
	public int getASP_Module_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_ASP_Module_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set ASP_Module_UU.
		@param ASP_Module_UU ASP_Module_UU
	*/
	public void setASP_Module_UU (String ASP_Module_UU)
	{
		set_Value (COLUMNNAME_ASP_Module_UU, ASP_Module_UU);
	}

	/** Get ASP_Module_UU.
		@return ASP_Module_UU	  */
	public String getASP_Module_UU()
	{
		return (String)get_Value(COLUMNNAME_ASP_Module_UU);
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

	/** Set Search Key.
		@param Value Search key for the record in the format required - must be unique
	*/
	public void setValue (String Value)
	{
		set_Value (COLUMNNAME_Value, Value);
	}

	/** Get Search Key.
		@return Search key for the record in the format required - must be unique
	  */
	public String getValue()
	{
		return (String)get_Value(COLUMNNAME_Value);
	}
}