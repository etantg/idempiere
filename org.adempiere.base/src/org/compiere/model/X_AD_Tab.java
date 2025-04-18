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

/** Generated Model for AD_Tab
 *  @author iDempiere (generated)
 *  @version Release 12 - $Id$ */
@org.adempiere.base.Model(table="AD_Tab")
public class X_AD_Tab extends PO implements I_AD_Tab, I_Persistent
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20241222L;

    /** Standard Constructor */
    public X_AD_Tab (Properties ctx, int AD_Tab_ID, String trxName)
    {
      super (ctx, AD_Tab_ID, trxName);
      /** if (AD_Tab_ID == 0)
        {
			setAD_Tab_ID (0);
			setAD_Table_ID (0);
			setAD_Window_ID (0);
			setEntityType (null);
// @SQL=SELECT CASE WHEN '@P|AdempiereSys:N@'='Y' THEN 'D' ELSE get_sysconfig('DEFAULT_ENTITYTYPE','U',0,0) END FROM Dual
			setHasTree (false);
			setIsAdvancedTab (false);
// N
			setIsInsertRecord (true);
// Y
			setIsReadOnly (false);
			setIsSingleRow (true);
// Y
			setIsSortTab (false);
// N
			setIsTranslationTab (false);
			setName (null);
			setSeqNo (0);
// @SQL=SELECT COALESCE(MAX(SeqNo),0)+10 AS DefaultValue FROM AD_Tab WHERE AD_Window_ID=@AD_Window_ID@
			setTabLevel (0);
			setTreeDisplayedOn (null);
// B
        } */
    }

    /** Standard Constructor */
    public X_AD_Tab (Properties ctx, int AD_Tab_ID, String trxName, String ... virtualColumns)
    {
      super (ctx, AD_Tab_ID, trxName, virtualColumns);
      /** if (AD_Tab_ID == 0)
        {
			setAD_Tab_ID (0);
			setAD_Table_ID (0);
			setAD_Window_ID (0);
			setEntityType (null);
// @SQL=SELECT CASE WHEN '@P|AdempiereSys:N@'='Y' THEN 'D' ELSE get_sysconfig('DEFAULT_ENTITYTYPE','U',0,0) END FROM Dual
			setHasTree (false);
			setIsAdvancedTab (false);
// N
			setIsInsertRecord (true);
// Y
			setIsReadOnly (false);
			setIsSingleRow (true);
// Y
			setIsSortTab (false);
// N
			setIsTranslationTab (false);
			setName (null);
			setSeqNo (0);
// @SQL=SELECT COALESCE(MAX(SeqNo),0)+10 AS DefaultValue FROM AD_Tab WHERE AD_Window_ID=@AD_Window_ID@
			setTabLevel (0);
			setTreeDisplayedOn (null);
// B
        } */
    }

    /** Standard Constructor */
    public X_AD_Tab (Properties ctx, String AD_Tab_UU, String trxName)
    {
      super (ctx, AD_Tab_UU, trxName);
      /** if (AD_Tab_UU == null)
        {
			setAD_Tab_ID (0);
			setAD_Table_ID (0);
			setAD_Window_ID (0);
			setEntityType (null);
// @SQL=SELECT CASE WHEN '@P|AdempiereSys:N@'='Y' THEN 'D' ELSE get_sysconfig('DEFAULT_ENTITYTYPE','U',0,0) END FROM Dual
			setHasTree (false);
			setIsAdvancedTab (false);
// N
			setIsInsertRecord (true);
// Y
			setIsReadOnly (false);
			setIsSingleRow (true);
// Y
			setIsSortTab (false);
// N
			setIsTranslationTab (false);
			setName (null);
			setSeqNo (0);
// @SQL=SELECT COALESCE(MAX(SeqNo),0)+10 AS DefaultValue FROM AD_Tab WHERE AD_Window_ID=@AD_Window_ID@
			setTabLevel (0);
			setTreeDisplayedOn (null);
// B
        } */
    }

    /** Standard Constructor */
    public X_AD_Tab (Properties ctx, String AD_Tab_UU, String trxName, String ... virtualColumns)
    {
      super (ctx, AD_Tab_UU, trxName, virtualColumns);
      /** if (AD_Tab_UU == null)
        {
			setAD_Tab_ID (0);
			setAD_Table_ID (0);
			setAD_Window_ID (0);
			setEntityType (null);
// @SQL=SELECT CASE WHEN '@P|AdempiereSys:N@'='Y' THEN 'D' ELSE get_sysconfig('DEFAULT_ENTITYTYPE','U',0,0) END FROM Dual
			setHasTree (false);
			setIsAdvancedTab (false);
// N
			setIsInsertRecord (true);
// Y
			setIsReadOnly (false);
			setIsSingleRow (true);
// Y
			setIsSortTab (false);
// N
			setIsTranslationTab (false);
			setName (null);
			setSeqNo (0);
// @SQL=SELECT COALESCE(MAX(SeqNo),0)+10 AS DefaultValue FROM AD_Tab WHERE AD_Window_ID=@AD_Window_ID@
			setTabLevel (0);
			setTreeDisplayedOn (null);
// B
        } */
    }

    /** Load Constructor */
    public X_AD_Tab (Properties ctx, ResultSet rs, String trxName)
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
      StringBuilder sb = new StringBuilder ("X_AD_Tab[")
        .append(get_ID()).append(",Name=").append(getName()).append("]");
      return sb.toString();
    }

	public org.compiere.model.I_AD_Column getAD_ColumnSortOrder() throws RuntimeException
	{
		return (org.compiere.model.I_AD_Column)MTable.get(getCtx(), org.compiere.model.I_AD_Column.Table_ID)
			.getPO(getAD_ColumnSortOrder_ID(), get_TrxName());
	}

	/** Set Order Column.
		@param AD_ColumnSortOrder_ID Column determining the order
	*/
	public void setAD_ColumnSortOrder_ID (int AD_ColumnSortOrder_ID)
	{
		if (AD_ColumnSortOrder_ID < 1)
			set_Value (COLUMNNAME_AD_ColumnSortOrder_ID, null);
		else
			set_Value (COLUMNNAME_AD_ColumnSortOrder_ID, Integer.valueOf(AD_ColumnSortOrder_ID));
	}

	/** Get Order Column.
		@return Column determining the order
	  */
	public int getAD_ColumnSortOrder_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_AD_ColumnSortOrder_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_AD_Column getAD_ColumnSortYesNo() throws RuntimeException
	{
		return (org.compiere.model.I_AD_Column)MTable.get(getCtx(), org.compiere.model.I_AD_Column.Table_ID)
			.getPO(getAD_ColumnSortYesNo_ID(), get_TrxName());
	}

	/** Set Included Column.
		@param AD_ColumnSortYesNo_ID Column determining if a Table Column is included in Ordering
	*/
	public void setAD_ColumnSortYesNo_ID (int AD_ColumnSortYesNo_ID)
	{
		if (AD_ColumnSortYesNo_ID < 1)
			set_Value (COLUMNNAME_AD_ColumnSortYesNo_ID, null);
		else
			set_Value (COLUMNNAME_AD_ColumnSortYesNo_ID, Integer.valueOf(AD_ColumnSortYesNo_ID));
	}

	/** Get Included Column.
		@return Column determining if a Table Column is included in Ordering
	  */
	public int getAD_ColumnSortYesNo_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_AD_ColumnSortYesNo_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
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

	public org.compiere.model.I_AD_CtxHelp getAD_CtxHelp() throws RuntimeException
	{
		return (org.compiere.model.I_AD_CtxHelp)MTable.get(getCtx(), org.compiere.model.I_AD_CtxHelp.Table_ID)
			.getPO(getAD_CtxHelp_ID(), get_TrxName());
	}

	/** Set Context Help.
		@param AD_CtxHelp_ID Context Help
	*/
	public void setAD_CtxHelp_ID (int AD_CtxHelp_ID)
	{
		if (AD_CtxHelp_ID < 1)
			set_Value (COLUMNNAME_AD_CtxHelp_ID, null);
		else
			set_Value (COLUMNNAME_AD_CtxHelp_ID, Integer.valueOf(AD_CtxHelp_ID));
	}

	/** Get Context Help.
		@return Context Help	  */
	public int getAD_CtxHelp_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_AD_CtxHelp_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_AD_Image getAD_Image() throws RuntimeException
	{
		return (org.compiere.model.I_AD_Image)MTable.get(getCtx(), org.compiere.model.I_AD_Image.Table_ID)
			.getPO(getAD_Image_ID(), get_TrxName());
	}

	/** Set Image.
		@param AD_Image_ID Image or Icon
	*/
	public void setAD_Image_ID (int AD_Image_ID)
	{
		if (AD_Image_ID < 1)
			set_Value (COLUMNNAME_AD_Image_ID, null);
		else
			set_Value (COLUMNNAME_AD_Image_ID, Integer.valueOf(AD_Image_ID));
	}

	/** Get Image.
		@return Image or Icon
	  */
	public int getAD_Image_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_AD_Image_ID);
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

	/** AD_TabType AD_Reference_ID=200117 */
	public static final int AD_TABTYPE_AD_Reference_ID=200117;
	/** Form = FORM */
	public static final String AD_TABTYPE_Form = "FORM";
	/** Sort = SORT */
	public static final String AD_TABTYPE_Sort = "SORT";
	/** Set Tab Type.
		@param AD_TabType Defines Tab Type
	*/
	public void setAD_TabType (String AD_TabType)
	{

		set_Value (COLUMNNAME_AD_TabType, AD_TabType);
	}

	/** Get Tab Type.
		@return Defines Tab Type
	  */
	public String getAD_TabType()
	{
		return (String)get_Value(COLUMNNAME_AD_TabType);
	}

	/** Set Tab.
		@param AD_Tab_ID Tab within a Window
	*/
	public void setAD_Tab_ID (int AD_Tab_ID)
	{
		if (AD_Tab_ID < 1)
			set_ValueNoCheck (COLUMNNAME_AD_Tab_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_AD_Tab_ID, Integer.valueOf(AD_Tab_ID));
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

	/** Set AD_Tab_UU.
		@param AD_Tab_UU AD_Tab_UU
	*/
	public void setAD_Tab_UU (String AD_Tab_UU)
	{
		set_Value (COLUMNNAME_AD_Tab_UU, AD_Tab_UU);
	}

	/** Get AD_Tab_UU.
		@return AD_Tab_UU	  */
	public String getAD_Tab_UU()
	{
		return (String)get_Value(COLUMNNAME_AD_Tab_UU);
	}

	public org.compiere.model.I_AD_Table getAD_Table() throws RuntimeException
	{
		return (org.compiere.model.I_AD_Table)MTable.get(getCtx(), org.compiere.model.I_AD_Table.Table_ID)
			.getPO(getAD_Table_ID(), get_TrxName());
	}

	/** Set Table.
		@param AD_Table_ID Database Table information
	*/
	public void setAD_Table_ID (int AD_Table_ID)
	{
		if (AD_Table_ID < 1)
			set_Value (COLUMNNAME_AD_Table_ID, null);
		else
			set_Value (COLUMNNAME_AD_Table_ID, Integer.valueOf(AD_Table_ID));
	}

	/** Get Table.
		@return Database Table information
	  */
	public int getAD_Table_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_AD_Table_ID);
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
			set_ValueNoCheck (COLUMNNAME_AD_Window_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_AD_Window_ID, Integer.valueOf(AD_Window_ID));
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

	/** Set Commit Warning.
		@param CommitWarning Warning displayed when saving
	*/
	public void setCommitWarning (String CommitWarning)
	{
		set_Value (COLUMNNAME_CommitWarning, CommitWarning);
	}

	/** Get Commit Warning.
		@return Warning displayed when saving
	  */
	public String getCommitWarning()
	{
		return (String)get_Value(COLUMNNAME_CommitWarning);
	}

	/** Set Delete Confirmation Logic.
		@param DeleteConfirmationLogic Delete Confirmation Logic
	*/
	public void setDeleteConfirmationLogic (String DeleteConfirmationLogic)
	{
		set_Value (COLUMNNAME_DeleteConfirmationLogic, DeleteConfirmationLogic);
	}

	/** Get Delete Confirmation Logic.
		@return Delete Confirmation Logic	  */
	public String getDeleteConfirmationLogic()
	{
		return (String)get_Value(COLUMNNAME_DeleteConfirmationLogic);
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

	/** Set Display Logic.
		@param DisplayLogic If the Field is displayed, the result determines if the field is actually displayed
	*/
	public void setDisplayLogic (String DisplayLogic)
	{
		set_Value (COLUMNNAME_DisplayLogic, DisplayLogic);
	}

	/** Get Display Logic.
		@return If the Field is displayed, the result determines if the field is actually displayed
	  */
	public String getDisplayLogic()
	{
		return (String)get_Value(COLUMNNAME_DisplayLogic);
	}

	/** EntityType AD_Reference_ID=389 */
	public static final int ENTITYTYPE_AD_Reference_ID=389;
	/** Set Entity Type.
		@param EntityType Dictionary Entity Type; Determines ownership and synchronization
	*/
	public void setEntityType (String EntityType)
	{

		set_Value (COLUMNNAME_EntityType, EntityType);
	}

	/** Get Entity Type.
		@return Dictionary Entity Type; Determines ownership and synchronization
	  */
	public String getEntityType()
	{
		return (String)get_Value(COLUMNNAME_EntityType);
	}

	/** Set Has Tree.
		@param HasTree Window has Tree Graph
	*/
	public void setHasTree (boolean HasTree)
	{
		set_Value (COLUMNNAME_HasTree, Boolean.valueOf(HasTree));
	}

	/** Get Has Tree.
		@return Window has Tree Graph
	  */
	public boolean isHasTree()
	{
		Object oo = get_Value(COLUMNNAME_HasTree);
		if (oo != null)
		{
			 if (oo instanceof Boolean)
				 return ((Boolean)oo).booleanValue();
			return "Y".equals(oo);
		}
		return false;
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

	/** Set Import Fields.
		@param ImportFields Create Fields from Table Columns
	*/
	public void setImportFields (String ImportFields)
	{
		set_Value (COLUMNNAME_ImportFields, ImportFields);
	}

	/** Get Import Fields.
		@return Create Fields from Table Columns
	  */
	public String getImportFields()
	{
		return (String)get_Value(COLUMNNAME_ImportFields);
	}

	public org.compiere.model.I_AD_Tab getIncluded_Tab() throws RuntimeException
	{
		return (org.compiere.model.I_AD_Tab)MTable.get(getCtx(), org.compiere.model.I_AD_Tab.Table_ID)
			.getPO(getIncluded_Tab_ID(), get_TrxName());
	}

	/** Set Included Tab.
		@param Included_Tab_ID Included Tab in this Tab (Master Detail)
	*/
	public void setIncluded_Tab_ID (int Included_Tab_ID)
	{
		if (Included_Tab_ID < 1)
			set_Value (COLUMNNAME_Included_Tab_ID, null);
		else
			set_Value (COLUMNNAME_Included_Tab_ID, Integer.valueOf(Included_Tab_ID));
	}

	/** Get Included Tab.
		@return Included Tab in this Tab (Master Detail)
	  */
	public int getIncluded_Tab_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Included_Tab_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Advanced Tab.
		@param IsAdvancedTab This Tab contains advanced Functionality
	*/
	public void setIsAdvancedTab (boolean IsAdvancedTab)
	{
		set_Value (COLUMNNAME_IsAdvancedTab, Boolean.valueOf(IsAdvancedTab));
	}

	/** Get Advanced Tab.
		@return This Tab contains advanced Functionality
	  */
	public boolean isAdvancedTab()
	{
		Object oo = get_Value(COLUMNNAME_IsAdvancedTab);
		if (oo != null)
		{
			 if (oo instanceof Boolean)
				 return ((Boolean)oo).booleanValue();
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Allow Advanced Lookup.
		@param IsAllowAdvancedLookup Allow Advanced Lookup
	*/
	public void setIsAllowAdvancedLookup (boolean IsAllowAdvancedLookup)
	{
		set_Value (COLUMNNAME_IsAllowAdvancedLookup, Boolean.valueOf(IsAllowAdvancedLookup));
	}

	/** Get Allow Advanced Lookup.
		@return Allow Advanced Lookup	  */
	public boolean isAllowAdvancedLookup()
	{
		Object oo = get_Value(COLUMNNAME_IsAllowAdvancedLookup);
		if (oo != null)
		{
			 if (oo instanceof Boolean)
				 return ((Boolean)oo).booleanValue();
			return "Y".equals(oo);
		}
		return false;
	}

	/** IsHighVolume AD_Reference_ID=319 */
	public static final int ISHIGHVOLUME_AD_Reference_ID=319;
	/** No = N */
	public static final String ISHIGHVOLUME_No = "N";
	/** Yes = Y */
	public static final String ISHIGHVOLUME_Yes = "Y";
	/** Set High Volume.
		@param IsHighVolume Use Search instead of Pick list
	*/
	public void setIsHighVolume (String IsHighVolume)
	{

		set_Value (COLUMNNAME_IsHighVolume, IsHighVolume);
	}

	/** Get High Volume.
		@return Use Search instead of Pick list
	  */
	public String getIsHighVolume()
	{
		return (String)get_Value(COLUMNNAME_IsHighVolume);
	}

	/** Set Accounting Tab.
		@param IsInfoTab This Tab contains accounting information
	*/
	public void setIsInfoTab (boolean IsInfoTab)
	{
		set_Value (COLUMNNAME_IsInfoTab, Boolean.valueOf(IsInfoTab));
	}

	/** Get Accounting Tab.
		@return This Tab contains accounting information
	  */
	public boolean isInfoTab()
	{
		Object oo = get_Value(COLUMNNAME_IsInfoTab);
		if (oo != null)
		{
			 if (oo instanceof Boolean)
				 return ((Boolean)oo).booleanValue();
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Insert Record.
		@param IsInsertRecord The user can insert a new Record
	*/
	public void setIsInsertRecord (boolean IsInsertRecord)
	{
		set_Value (COLUMNNAME_IsInsertRecord, Boolean.valueOf(IsInsertRecord));
	}

	/** Get Insert Record.
		@return The user can insert a new Record
	  */
	public boolean isInsertRecord()
	{
		Object oo = get_Value(COLUMNNAME_IsInsertRecord);
		if (oo != null)
		{
			 if (oo instanceof Boolean)
				 return ((Boolean)oo).booleanValue();
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Lookup Only Selection Columns.
		@param IsLookupOnlySelection When defined to true Lookup panel will display only selection columns. Default to false.
	*/
	public void setIsLookupOnlySelection (boolean IsLookupOnlySelection)
	{
		set_Value (COLUMNNAME_IsLookupOnlySelection, Boolean.valueOf(IsLookupOnlySelection));
	}

	/** Get Lookup Only Selection Columns.
		@return When defined to true Lookup panel will display only selection columns. Default to false.
	  */
	public boolean isLookupOnlySelection()
	{
		Object oo = get_Value(COLUMNNAME_IsLookupOnlySelection);
		if (oo != null)
		{
			 if (oo instanceof Boolean)
				 return ((Boolean)oo).booleanValue();
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Read Only.
		@param IsReadOnly Field is read only
	*/
	public void setIsReadOnly (boolean IsReadOnly)
	{
		set_Value (COLUMNNAME_IsReadOnly, Boolean.valueOf(IsReadOnly));
	}

	/** Get Read Only.
		@return Field is read only
	  */
	public boolean isReadOnly()
	{
		Object oo = get_Value(COLUMNNAME_IsReadOnly);
		if (oo != null)
		{
			 if (oo instanceof Boolean)
				 return ((Boolean)oo).booleanValue();
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Single Row Layout.
		@param IsSingleRow Default for toggle between Single- and Multi-Row (Grid) Layout
	*/
	public void setIsSingleRow (boolean IsSingleRow)
	{
		set_Value (COLUMNNAME_IsSingleRow, Boolean.valueOf(IsSingleRow));
	}

	/** Get Single Row Layout.
		@return Default for toggle between Single- and Multi-Row (Grid) Layout
	  */
	public boolean isSingleRow()
	{
		Object oo = get_Value(COLUMNNAME_IsSingleRow);
		if (oo != null)
		{
			 if (oo instanceof Boolean)
				 return ((Boolean)oo).booleanValue();
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Order Tab.
		@param IsSortTab The Tab determines the Order
	*/
	public void setIsSortTab (boolean IsSortTab)
	{
		set_Value (COLUMNNAME_IsSortTab, Boolean.valueOf(IsSortTab));
	}

	/** Get Order Tab.
		@return The Tab determines the Order
	  */
	public boolean isSortTab()
	{
		Object oo = get_Value(COLUMNNAME_IsSortTab);
		if (oo != null)
		{
			 if (oo instanceof Boolean)
				 return ((Boolean)oo).booleanValue();
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Translation Tab.
		@param IsTranslationTab This Tab contains translation information
	*/
	public void setIsTranslationTab (boolean IsTranslationTab)
	{
		set_Value (COLUMNNAME_IsTranslationTab, Boolean.valueOf(IsTranslationTab));
	}

	/** Get Translation Tab.
		@return This Tab contains translation information
	  */
	public boolean isTranslationTab()
	{
		Object oo = get_Value(COLUMNNAME_IsTranslationTab);
		if (oo != null)
		{
			 if (oo instanceof Boolean)
				 return ((Boolean)oo).booleanValue();
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Max Query Records.
		@param MaxQueryRecords If defined, you cannot query more records as defined - the query criteria needs to be changed to query less records
	*/
	public void setMaxQueryRecords (int MaxQueryRecords)
	{
		set_Value (COLUMNNAME_MaxQueryRecords, Integer.valueOf(MaxQueryRecords));
	}

	/** Get Max Query Records.
		@return If defined, you cannot query more records as defined - the query criteria needs to be changed to query less records
	  */
	public int getMaxQueryRecords()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_MaxQueryRecords);
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

	/** Set Sql ORDER BY.
		@param OrderByClause Fully qualified ORDER BY clause
	*/
	public void setOrderByClause (String OrderByClause)
	{
		set_Value (COLUMNNAME_OrderByClause, OrderByClause);
	}

	/** Get Sql ORDER BY.
		@return Fully qualified ORDER BY clause
	  */
	public String getOrderByClause()
	{
		return (String)get_Value(COLUMNNAME_OrderByClause);
	}

	public org.compiere.model.I_AD_Column getParent_Column() throws RuntimeException
	{
		return (org.compiere.model.I_AD_Column)MTable.get(getCtx(), org.compiere.model.I_AD_Column.Table_ID)
			.getPO(getParent_Column_ID(), get_TrxName());
	}

	/** Set Parent Column.
		@param Parent_Column_ID The link column on the parent tab.
	*/
	public void setParent_Column_ID (int Parent_Column_ID)
	{
		if (Parent_Column_ID < 1)
			set_Value (COLUMNNAME_Parent_Column_ID, null);
		else
			set_Value (COLUMNNAME_Parent_Column_ID, Integer.valueOf(Parent_Column_ID));
	}

	/** Get Parent Column.
		@return The link column on the parent tab.
	  */
	public int getParent_Column_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Parent_Column_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
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

	/** Set Read Only Logic.
		@param ReadOnlyLogic Logic to determine if field is read only (applies only when field is read-write)
	*/
	public void setReadOnlyLogic (String ReadOnlyLogic)
	{
		set_Value (COLUMNNAME_ReadOnlyLogic, ReadOnlyLogic);
	}

	/** Get Read Only Logic.
		@return Logic to determine if field is read only (applies only when field is read-write)
	  */
	public String getReadOnlyLogic()
	{
		return (String)get_Value(COLUMNNAME_ReadOnlyLogic);
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

	/** Set Tab Level.
		@param TabLevel Hierarchical Tab Level (0 = top)
	*/
	public void setTabLevel (int TabLevel)
	{
		set_Value (COLUMNNAME_TabLevel, Integer.valueOf(TabLevel));
	}

	/** Get Tab Level.
		@return Hierarchical Tab Level (0 = top)
	  */
	public int getTabLevel()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TabLevel);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** TreeDisplayedOn AD_Reference_ID=200074 */
	public static final int TREEDISPLAYEDON_AD_Reference_ID=200074;
	/** Both = B */
	public static final String TREEDISPLAYEDON_Both = "B";
	/** Detail Tab = D */
	public static final String TREEDISPLAYEDON_DetailTab = "D";
	/** Master Tab = M */
	public static final String TREEDISPLAYEDON_MasterTab = "M";
	/** Set Tree displayed.
		@param TreeDisplayedOn The tree can be displayed on master tab, detail tab or both
	*/
	public void setTreeDisplayedOn (String TreeDisplayedOn)
	{

		set_Value (COLUMNNAME_TreeDisplayedOn, TreeDisplayedOn);
	}

	/** Get Tree displayed.
		@return The tree can be displayed on master tab, detail tab or both
	  */
	public String getTreeDisplayedOn()
	{
		return (String)get_Value(COLUMNNAME_TreeDisplayedOn);
	}

	/** Set Sql WHERE.
		@param WhereClause Fully qualified SQL WHERE clause
	*/
	public void setWhereClause (String WhereClause)
	{
		set_Value (COLUMNNAME_WhereClause, WhereClause);
	}

	/** Get Sql WHERE.
		@return Fully qualified SQL WHERE clause
	  */
	public String getWhereClause()
	{
		return (String)get_Value(COLUMNNAME_WhereClause);
	}
}