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

/** Generated Model for M_SerNoCtl
 *  @author iDempiere (generated)
 *  @version Release 12 - $Id$ */
@org.adempiere.base.Model(table="M_SerNoCtl")
public class X_M_SerNoCtl extends PO implements I_M_SerNoCtl, I_Persistent
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20241222L;

    /** Standard Constructor */
    public X_M_SerNoCtl (Properties ctx, int M_SerNoCtl_ID, String trxName)
    {
      super (ctx, M_SerNoCtl_ID, trxName);
      /** if (M_SerNoCtl_ID == 0)
        {
			setCurrentNext (0);
// 100
			setIncrementNo (0);
// 1
			setM_SerNoCtl_ID (0);
			setName (null);
			setStartNo (0);
// 100
        } */
    }

    /** Standard Constructor */
    public X_M_SerNoCtl (Properties ctx, int M_SerNoCtl_ID, String trxName, String ... virtualColumns)
    {
      super (ctx, M_SerNoCtl_ID, trxName, virtualColumns);
      /** if (M_SerNoCtl_ID == 0)
        {
			setCurrentNext (0);
// 100
			setIncrementNo (0);
// 1
			setM_SerNoCtl_ID (0);
			setName (null);
			setStartNo (0);
// 100
        } */
    }

    /** Standard Constructor */
    public X_M_SerNoCtl (Properties ctx, String M_SerNoCtl_UU, String trxName)
    {
      super (ctx, M_SerNoCtl_UU, trxName);
      /** if (M_SerNoCtl_UU == null)
        {
			setCurrentNext (0);
// 100
			setIncrementNo (0);
// 1
			setM_SerNoCtl_ID (0);
			setName (null);
			setStartNo (0);
// 100
        } */
    }

    /** Standard Constructor */
    public X_M_SerNoCtl (Properties ctx, String M_SerNoCtl_UU, String trxName, String ... virtualColumns)
    {
      super (ctx, M_SerNoCtl_UU, trxName, virtualColumns);
      /** if (M_SerNoCtl_UU == null)
        {
			setCurrentNext (0);
// 100
			setIncrementNo (0);
// 1
			setM_SerNoCtl_ID (0);
			setName (null);
			setStartNo (0);
// 100
        } */
    }

    /** Load Constructor */
    public X_M_SerNoCtl (Properties ctx, ResultSet rs, String trxName)
    {
      super (ctx, rs, trxName);
    }

    /** AccessLevel
      * @return 3 - Client - Org
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
      StringBuilder sb = new StringBuilder ("X_M_SerNoCtl[")
        .append(get_ID()).append(",Name=").append(getName()).append("]");
      return sb.toString();
    }

	/** Set Current Next.
		@param CurrentNext The next number to be used
	*/
	public void setCurrentNext (int CurrentNext)
	{
		set_Value (COLUMNNAME_CurrentNext, Integer.valueOf(CurrentNext));
	}

	/** Get Current Next.
		@return The next number to be used
	  */
	public int getCurrentNext()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_CurrentNext);
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

	/** Set Increment.
		@param IncrementNo The number to increment the last document number by
	*/
	public void setIncrementNo (int IncrementNo)
	{
		set_Value (COLUMNNAME_IncrementNo, Integer.valueOf(IncrementNo));
	}

	/** Get Increment.
		@return The number to increment the last document number by
	  */
	public int getIncrementNo()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_IncrementNo);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Serial No Control.
		@param M_SerNoCtl_ID Product Serial Number Control
	*/
	public void setM_SerNoCtl_ID (int M_SerNoCtl_ID)
	{
		if (M_SerNoCtl_ID < 1)
			set_ValueNoCheck (COLUMNNAME_M_SerNoCtl_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_M_SerNoCtl_ID, Integer.valueOf(M_SerNoCtl_ID));
	}

	/** Get Serial No Control.
		@return Product Serial Number Control
	  */
	public int getM_SerNoCtl_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_M_SerNoCtl_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set M_SerNoCtl_UU.
		@param M_SerNoCtl_UU M_SerNoCtl_UU
	*/
	public void setM_SerNoCtl_UU (String M_SerNoCtl_UU)
	{
		set_Value (COLUMNNAME_M_SerNoCtl_UU, M_SerNoCtl_UU);
	}

	/** Get M_SerNoCtl_UU.
		@return M_SerNoCtl_UU	  */
	public String getM_SerNoCtl_UU()
	{
		return (String)get_Value(COLUMNNAME_M_SerNoCtl_UU);
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

	/** Set Prefix.
		@param Prefix Prefix before the sequence number
	*/
	public void setPrefix (String Prefix)
	{
		set_Value (COLUMNNAME_Prefix, Prefix);
	}

	/** Get Prefix.
		@return Prefix before the sequence number
	  */
	public String getPrefix()
	{
		return (String)get_Value(COLUMNNAME_Prefix);
	}

	/** Set Start No.
		@param StartNo Starting number/position
	*/
	public void setStartNo (int StartNo)
	{
		set_Value (COLUMNNAME_StartNo, Integer.valueOf(StartNo));
	}

	/** Get Start No.
		@return Starting number/position
	  */
	public int getStartNo()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_StartNo);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Suffix.
		@param Suffix Suffix after the number
	*/
	public void setSuffix (String Suffix)
	{
		set_Value (COLUMNNAME_Suffix, Suffix);
	}

	/** Get Suffix.
		@return Suffix after the number
	  */
	public String getSuffix()
	{
		return (String)get_Value(COLUMNNAME_Suffix);
	}
}