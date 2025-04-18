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
package org.idempiere.webservices.model;

import java.sql.ResultSet;
import java.util.Properties;
import org.compiere.model.*;
import org.compiere.util.KeyNamePair;

/** Generated Model for WS_WebServiceFieldOutput
 *  @author iDempiere (generated)
 *  @version Release 12 - $Id$ */
@org.adempiere.base.Model(table="WS_WebServiceFieldOutput")
public class X_WS_WebServiceFieldOutput extends PO implements I_WS_WebServiceFieldOutput, I_Persistent
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20241222L;

    /** Standard Constructor */
    public X_WS_WebServiceFieldOutput (Properties ctx, int WS_WebServiceFieldOutput_ID, String trxName)
    {
      super (ctx, WS_WebServiceFieldOutput_ID, trxName);
      /** if (WS_WebServiceFieldOutput_ID == 0)
        {
			setWS_WebServiceFieldOutput_ID (0);
			setWS_WebServiceType_ID (0);
        } */
    }

    /** Standard Constructor */
    public X_WS_WebServiceFieldOutput (Properties ctx, int WS_WebServiceFieldOutput_ID, String trxName, String ... virtualColumns)
    {
      super (ctx, WS_WebServiceFieldOutput_ID, trxName, virtualColumns);
      /** if (WS_WebServiceFieldOutput_ID == 0)
        {
			setWS_WebServiceFieldOutput_ID (0);
			setWS_WebServiceType_ID (0);
        } */
    }

    /** Standard Constructor */
    public X_WS_WebServiceFieldOutput (Properties ctx, String WS_WebServiceFieldOutput_UU, String trxName)
    {
      super (ctx, WS_WebServiceFieldOutput_UU, trxName);
      /** if (WS_WebServiceFieldOutput_UU == null)
        {
			setWS_WebServiceFieldOutput_ID (0);
			setWS_WebServiceType_ID (0);
        } */
    }

    /** Standard Constructor */
    public X_WS_WebServiceFieldOutput (Properties ctx, String WS_WebServiceFieldOutput_UU, String trxName, String ... virtualColumns)
    {
      super (ctx, WS_WebServiceFieldOutput_UU, trxName, virtualColumns);
      /** if (WS_WebServiceFieldOutput_UU == null)
        {
			setWS_WebServiceFieldOutput_ID (0);
			setWS_WebServiceType_ID (0);
        } */
    }

    /** Load Constructor */
    public X_WS_WebServiceFieldOutput (Properties ctx, ResultSet rs, String trxName)
    {
      super (ctx, rs, trxName);
    }

    /** AccessLevel
      * @return 6 - System - Client
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
      StringBuilder sb = new StringBuilder ("X_WS_WebServiceFieldOutput[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	public org.compiere.model.I_AD_Column getAD_Column() throws RuntimeException
	{
		return (org.compiere.model.I_AD_Column)MTable.get(getCtx(), org.compiere.model.I_AD_Column.Table_ID)
			.getPO(getAD_Column_ID(), get_TrxName());
	}

	/** Set Column.
		@param AD_Column_ID Column in the table
	*/
	public void setAD_Column_ID (int AD_Column_ID)
	{
		if (AD_Column_ID < 1)
			set_Value (COLUMNNAME_AD_Column_ID, null);
		else
			set_Value (COLUMNNAME_AD_Column_ID, Integer.valueOf(AD_Column_ID));
	}

	/** Get Column.
		@return Column in the table
	  */
	public int getAD_Column_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_AD_Column_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Web Service Field Output.
		@param WS_WebServiceFieldOutput_ID Web Service Field Output
	*/
	public void setWS_WebServiceFieldOutput_ID (int WS_WebServiceFieldOutput_ID)
	{
		if (WS_WebServiceFieldOutput_ID < 1)
			set_ValueNoCheck (COLUMNNAME_WS_WebServiceFieldOutput_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_WS_WebServiceFieldOutput_ID, Integer.valueOf(WS_WebServiceFieldOutput_ID));
	}

	/** Get Web Service Field Output.
		@return Web Service Field Output	  */
	public int getWS_WebServiceFieldOutput_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_WS_WebServiceFieldOutput_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

    /** Get Record ID/ColumnName
        @return ID/ColumnName pair
      */
    public KeyNamePair getKeyNamePair()
    {
        return new KeyNamePair(get_ID(), String.valueOf(getWS_WebServiceFieldOutput_ID()));
    }

	/** Set WS_WebServiceFieldOutput_UU.
		@param WS_WebServiceFieldOutput_UU WS_WebServiceFieldOutput_UU
	*/
	public void setWS_WebServiceFieldOutput_UU (String WS_WebServiceFieldOutput_UU)
	{
		set_Value (COLUMNNAME_WS_WebServiceFieldOutput_UU, WS_WebServiceFieldOutput_UU);
	}

	/** Get WS_WebServiceFieldOutput_UU.
		@return WS_WebServiceFieldOutput_UU	  */
	public String getWS_WebServiceFieldOutput_UU()
	{
		return (String)get_Value(COLUMNNAME_WS_WebServiceFieldOutput_UU);
	}

	public I_WS_WebServiceType getWS_WebServiceType() throws RuntimeException
	{
		return (I_WS_WebServiceType)MTable.get(getCtx(), I_WS_WebServiceType.Table_ID)
			.getPO(getWS_WebServiceType_ID(), get_TrxName());
	}

	/** Set Web Service Type.
		@param WS_WebServiceType_ID Web Service Type
	*/
	public void setWS_WebServiceType_ID (int WS_WebServiceType_ID)
	{
		if (WS_WebServiceType_ID < 1)
			set_Value (COLUMNNAME_WS_WebServiceType_ID, null);
		else
			set_Value (COLUMNNAME_WS_WebServiceType_ID, Integer.valueOf(WS_WebServiceType_ID));
	}

	/** Get Web Service Type.
		@return Web Service Type	  */
	public int getWS_WebServiceType_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_WS_WebServiceType_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}
}