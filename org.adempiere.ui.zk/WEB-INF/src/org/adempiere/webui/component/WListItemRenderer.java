/******************************************************************************
 * Product: Posterita Ajax UI 												  *
 * Copyright (C) 2007 Posterita Ltd.  All Rights Reserved.                    *
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
 * Posterita Ltd., 3, Draper Avenue, Quatre Bornes, Mauritius                 *
 * or via info@posterita.org or http://www.posterita.org/                     *
 *****************************************************************************/

package org.adempiere.webui.component;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.adempiere.webui.AdempiereWebUI;
import org.adempiere.webui.ClientInfo;
import org.adempiere.webui.apps.AEnv;
import org.adempiere.webui.editor.WEditor;
import org.adempiere.webui.event.TableValueChangeEvent;
import org.adempiere.webui.event.TableValueChangeListener;
import org.adempiere.webui.event.ValueChangeEvent;
import org.adempiere.webui.util.ZKUpdateUtil;
import org.compiere.minigrid.IDColumn;
import org.compiere.minigrid.SelectableIDColumn;
import org.compiere.minigrid.UUIDColumn;
import org.compiere.model.MImage;
import org.compiere.util.DisplayType;
import org.compiere.util.Env;
import org.compiere.util.Language;
import org.compiere.util.MSort;
import org.compiere.util.Msg;
import org.compiere.util.Util;
import org.compiere.util.ValueNamePair;
import org.zkoss.image.AImage;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Decimalbox;
import org.zkoss.zul.Html;
import org.zkoss.zul.Image;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;
import org.zkoss.zul.ListitemRendererExt;
import org.zkoss.zul.impl.InputElement;

/**
 * Renderer for {@link org.adempiere.webui.component.ListItem}
 * for {@link org.adempiere.webui.component.Listbox}.
 *
 * @author Andrew Kimball
 *
 */
public class WListItemRenderer implements ListitemRenderer<Object>, EventListener<Event>, ListitemRendererExt
{
	/** Array of listeners for changes in the table components. */
	protected ArrayList<TableValueChangeListener> m_listeners =
            new ArrayList<TableValueChangeListener>();

	/** A list containing the indices of the currently selected ListItems. */
	private Set<ListItem> m_selectedItems = new HashSet<ListItem>();
	/**	Array of table columns. */
	private ArrayList<WTableColumn> m_tableColumns = new ArrayList<WTableColumn>();
	/** Array of {@link ListHeader}s for list box column headers. */
    private ArrayList<ListHeader> m_headers = new ArrayList<ListHeader>();

    private Listbox listBox;

	private EventListener<Event> cellListener;

	/**
	 * Default constructor.
	 */
	public WListItemRenderer()
	{
		super();
	}

	/**
	 * Constructor specifying the column headers.
	 *
	 * @param columnNames	List of column headers.
	 */
	public WListItemRenderer(List< ? extends String> columnNames)
	{
		super();
		WTableColumn tableColumn;

		for (String columnName : columnNames)
		{
			tableColumn = new WTableColumn();
			ValueNamePair msgTipPair = Msg.splitToMsgTip(columnName);
			tableColumn.setHeaderValue(Util.cleanAmp(msgTipPair.getValue()));
			tableColumn.setTooltipText(Util.cleanAmp(msgTipPair.getName()));
			m_tableColumns.add(tableColumn);
		}
	}

	/**
	 * Get column details of specified <code>column</code>.
	 *
	 * @param columnIndex	The index of the column for which details are to be retrieved.
	 * @return	The details of the column at the specified index.
	 */
	public WTableColumn getColumn(int columnIndex)
	{
		try
		{
			return m_tableColumns.get(columnIndex);
		}
		catch (IndexOutOfBoundsException exception)
		{
			throw new IllegalArgumentException("There is no WTableColumn at column "
                    + columnIndex);
		}
	}


	/* (non-Javadoc)
	 * @see org.zkoss.zul.ListitemRenderer#render(org.zkoss.zul.Listitem, java.lang.Object)
	 */
	@Override
	public void render(Listitem item, Object data, int index) throws Exception
	{
		render((ListItem)item, data, index);
	}

	/**
	 * Renders the <code>data</code> to the specified <code>Listitem</code>.
	 *
	 * @param item 	the listitem to render the result.
	 * 				Note: when this method is called, the listitem has no child
	 * 				at all.
	 * @param data 	that is returned from {@link ListModel#getElementAt}
	 * @throws Exception
	 * @see {@link #render(Listitem, Object)}
	 */
	private void render(ListItem item, Object data, int index)
	{
		Listcell listcell = null;
		int colIndex = 0;
		int rowIndex = item.getIndex();
		WListbox table = null;

		if (item.getListbox() instanceof WListbox)
		{
			table = (WListbox)item.getListbox();
		}

		if (!(data instanceof List))
		{
			throw new IllegalArgumentException("A model element was not a list");
		}

		if (listBox == null || listBox != item.getListbox())
		{
			listBox = item.getListbox();
		}
		if (cellListener == null)
		{
			cellListener = new CellListener();
		}

		for (Object field : (List<?>)data)
		{
			listcell = getCellComponent(table, field, rowIndex, colIndex);
			listcell.setParent(item);
			listcell.addEventListener(Events.ON_DOUBLE_CLICK, cellListener);
			colIndex++;
			// just render column in list m_tableColumns
			if (m_tableColumns != null && m_tableColumns.size() == colIndex)
				break;
		}
	}

	/**
	 * Create cell for the given <code>value</code>.
	 *
	 * @param table 	The table into which the cell will be placed.
	 * @param value		Value for which the cell is to be created.
	 * @param rowIndex	The row in which the cell is to be placed.
	 * @param columnIndex	The column in which the cell is to be placed.
	 * @return	The list cell component.
	 */
	protected Listcell getCellComponent(WListbox table, Object value,
									  int rowIndex, int columnIndex)
	{
		ListCell listcell = new ListCell();
		WTableColumn column = null;
		if (m_tableColumns.size() > columnIndex) {
			column = getColumn(columnIndex);
			if (column != null && column.getHeaderValue() != null) {
				listcell.setClientAttribute(AdempiereWebUI.WIDGET_INSTANCE_NAME, column.getHeaderValue().toString());
			}
		}
		boolean isCellEditable = table != null ? table.isCellEditable(rowIndex, columnIndex) : false;

		//use custom editor configure through WTableColumn (if any)
		if (column != null && column.getEditorProvider() != null) 
		{
        	WEditor editor = column.getEditorProvider().apply(new WTableColumn.EditorProviderParameters(table, rowIndex, columnIndex, value));
        	if (editor != null) 
        	{
        		editor.setValue(value);
        		if (isCellEditable) 
        		{
	        		editor.setReadWrite(true);
	        		editor.setTableEditor(true);	        		
	        		editor.addValueChangeListener(evt -> onValueChange(evt));
	        		listcell.appendChild(editor.getComponent());	        		        		
        		} 
        		else 
        		{    
        			editor.setReadWrite(false);
        			Component displayComponent = editor.getDisplayComponent();
        			if (displayComponent != null && displayComponent instanceof Html) 
        			{
        				String text = editor.getDisplayTextForGridView(value);
        				((Html)displayComponent).setContent(text);
        				listcell.appendChild(displayComponent);
        			} 
        			else if (displayComponent != null && displayComponent instanceof Label)
        			{
        				String text = editor.getDisplay();
        				((Label)displayComponent).setValue(text);
        				listcell.appendChild(displayComponent);
        			}
        			else if (displayComponent != null && displayComponent instanceof InputElement)
        			{
        				String text = editor.getDisplay();
        				((InputElement)displayComponent).setText(text);
        				((InputElement)displayComponent).setReadonly(true);
        				listcell.appendChild(displayComponent);
        			}
        			else 
        			{        				
    	        		listcell.appendChild(editor.getComponent());    	        		
        			}
        		}
        		return listcell;
        	}
        }
		
		if (value != null)
		{
			if (value instanceof Boolean)
			{
				listcell.setValue(Boolean.valueOf(value.toString()));

				if (table != null && columnIndex == 0)
					table.setCheckmark(false);
				Checkbox checkbox = new Checkbox();
				checkbox.setChecked(Boolean.valueOf(value.toString()));

				if (isCellEditable)
				{
					checkbox.setEnabled(true);
					checkbox.addEventListener(Events.ON_CHECK, this);
				}
				else
				{
					checkbox.setEnabled(false);
				}

				listcell.appendChild(checkbox);
				ZkCssHelper.appendStyle(listcell, "text-align:center");
			}
			else if (value instanceof Number)
			{
				if (m_tableColumns != null && columnIndex < m_tableColumns.size()
						&& m_tableColumns.get(columnIndex).getColumnClass() != null
						&& m_tableColumns.get(columnIndex).getColumnClass().getName().equals(MImage.class.getName()) 
						&& value instanceof Integer)
				{
					MImage mImage = MImage.get(Env.getCtx(), (Integer) value);
					AImage img = null;
					byte[] data = mImage.getData();
					if (data != null && data.length > 0) {
						try {
							img = new AImage(null, data);
						} catch (Exception e) {
							throw new RuntimeException(e);
						}
					}
					Image image = new Image();
					image.setContent(img);
					image.setStyle("width: 48px; height: 48px;");
					listcell.appendChild(image);
					listcell.setStyle("text-align: center;");
				}
				else
				{
					Language lang = AEnv.getLanguage(Env.getCtx());
					int displayType = (value instanceof BigDecimal || value instanceof Double || value instanceof Float)
							? DisplayType.Amount
						    : DisplayType.Integer;
					DecimalFormat format = DisplayType.getNumberFormat(displayType, lang);

					// set cell value to allow sorting
					listcell.setValue(value.toString());

					if (isCellEditable)
					{
						NumberBox numberbox = new NumberBox(false);
						numberbox.getDecimalbox().setFormat(format.toPattern());
						numberbox.getDecimalbox().setLocale(lang.getLocale());
						numberbox.setFormat(format);
						numberbox.setValue(value);
						numberbox.setEnabled(true);
						numberbox.setStyle("text-align:right; width: 96%;"
										+ listcell.getStyle());
						numberbox.addEventListener(Events.ON_CHANGE, this);						
						listcell.appendChild(numberbox);
						if (ClientInfo.isMobile())
							numberbox.getButton().setVisible(false);
					}
					else
					{
						listcell.setLabel(format.format(value));
						ZkCssHelper.appendStyle(listcell, "text-align: right");
					}
				}
			}
			else if (value instanceof Timestamp)
			{
				int refId = 0;
				if (m_tableColumns != null && columnIndex < m_tableColumns.size()) {
					refId = m_tableColumns.get(columnIndex).getAD_Reference_ID();
				}

				if (refId == 0)
					refId = DisplayType.Date;
				SimpleDateFormat dateFormat = DisplayType.getDateFormat(refId, AEnv.getLanguage(Env.getCtx()));
				listcell.setValue(dateFormat.format((Timestamp)value));
				if (isCellEditable)
				{
					Datebox datebox = new Datebox();
					datebox.setValue(new Date(((Timestamp)value).getTime()));
					datebox.addEventListener(Events.ON_CHANGE, this);
					listcell.appendChild(datebox);
				}
				else
				{
					listcell.setLabel(dateFormat.format((Timestamp)value));
					ZkCssHelper.appendStyle(listcell, "margin: auto");
				}
			}
			else if (value instanceof String)
			{
				if (m_tableColumns != null && columnIndex < m_tableColumns.size()
						&& m_tableColumns.get(columnIndex).getColumnClass() != null
						&& m_tableColumns.get(columnIndex).getColumnClass().getName().equals(MImage.class.getName()))
				{
					try {
						URL url = new URL(value.toString());
						AImage aImage = new AImage(url);
						Image image = new Image();
						image.setContent(aImage);
						image.setStyle("width: 16px; height: 16px; display: block;");
						listcell.appendChild(image);
						listcell.setStyle("text-align: center;");
					} catch (MalformedURLException e) {
						throw new RuntimeException(e);
					} catch (IOException e) {
						throw new RuntimeException(e);
					}
				}
				else
				{
					listcell.setValue(value.toString());
					if (isCellEditable)
					{
						Textbox textbox = new Textbox();
						textbox.setValue(value.toString());
						textbox.addEventListener(Events.ON_CHANGE, this);
						ZkCssHelper.appendStyle(textbox, "width: 96%;");
						listcell.appendChild(textbox);
					}
					else
					{
						listcell.setLabel(value.toString());
					}
				}
			}
			// if ID or UUID column make it invisible
			else if (value instanceof IDColumn || value instanceof UUIDColumn)
			{
				if (value instanceof IDColumn)
					listcell.setValue(((IDColumn) value).getRecord_ID());
				else
					listcell.setValue(((UUIDColumn) value).getRecord_UU());
				if (!table.isCheckmark()) {
					table.setCheckmark(true);
					table.removeEventListener(Events.ON_SELECT, this);
					table.addEventListener(Events.ON_SELECT, this);
				}
			}
			else
			{
				listcell.setLabel(value.toString());
				listcell.setValue(value.toString());
			}
		}
		else
		{
			listcell.setLabel("");
			listcell.setValue("");
		}

		return listcell;
	}

	/**
	 * Handle value change from custom editor created by {@link WTableColumn#getEditorProvider()}.
	 * @param evt
	 */
	private void  onValueChange(ValueChangeEvent evt) {
		WEditor editor = (WEditor) evt.getSource();
		Component component = editor.getComponent();
		int row = getRowPosition(component);
		int col = getColumnPosition(component);
		
		WTableColumn tableColumn = getColumn(col);
		TableValueChangeEvent vcEvent = new TableValueChangeEvent(component,
				tableColumn.getHeaderValue().toString(),
				row, col,
				evt.getOldValue(), evt.getNewValue());

		fireTableValueChange(vcEvent);
	}

	/**
	 *  Update header of a Column.
	 *
	 *  @param index	The index of the column to update
	 *  @param header 	The header text for the column
	 */
	public void updateColumn(int index, String header)
	{
		WTableColumn tableColumn;

		tableColumn = getColumn(index);
		tableColumn.setHeaderValue(Util.cleanAmp(header));
	}   //  updateColumn

	/**
	 * Add column
	 * @param header
	 */
	public void addColumn(String header)
	{
		addColumn(header, null);
	}
	
	/**
	 * Add column
	 * @param header
	 * @param description
	 */
	public void addColumn(String header, String description)
	{
		addColumn(header, description, 0);
	}
	
	/**
	 *  Add Table Column.
	 *  @param header The header text for the column
	 *  @param description
	 *  @param AD_Reference_ID
	 */
	public void addColumn(String header, String description, int AD_Reference_ID)
	{
		WTableColumn tableColumn;

		tableColumn = new WTableColumn();
		tableColumn.setHeaderValue(Util.cleanAmp(header));
		tableColumn.setTooltipText(description);
		tableColumn.setAD_Reference_ID(AD_Reference_ID);
		m_tableColumns.add(tableColumn);
	}   //  addColumn

	/**
	 * Get the number of columns.
	 * @return the number of columns
	 */
	public int getNoColumns()
	{
		return m_tableColumns.size();
	}

	/**
	 * This is unused.
	 * The readonly property of a column should be set in
	 * the parent table.
	 *
	 * @param colIndex
	 * @param readOnly
	 * @deprecated
	 */
	@Deprecated(forRemoval = true, since = "11")
	public void setRO(int colIndex, Boolean readOnly)
	{
		return;
	}

	/**
	 * Create a ListHeader using the given <code>headerValue</code> to
	 * generate the header text.<br/>
	 * The <code>toString</code> method of the <code>headerValue</code>
	 * is used to set the header text.
	 *
	 * @param headerValue	The object to use for generating the header text.
	 * @param tooltipText
     * @param headerIndex   The column index of the header
	 * @param classType Type of column. min-width is set base on type of column.
	 * @return The generated ListHeader component
	 * @see #renderListHead(ListHead)
	 */
	private Component getListHeaderComponent(Object headerValue, String tooltipText, int headerIndex, Class<?> classType)
	{
        ListHeader header = null;

        String headerText = headerValue.toString();
        if (m_headers.size() <= headerIndex || m_headers.get(headerIndex) == null)
        {
        	if (classType != null && (classType.isAssignableFrom(IDColumn.class) || classType.isAssignableFrom(UUIDColumn.class)))
        	{
        		header = new ListHeader("");
        		ZKUpdateUtil.setWidth(header, "30px");
        		header.setAlign("center");
        		header.setValign("middle");
        	}
        	else
        	{
	            Comparator<Object> ascComparator =  getColumnComparator(true, headerIndex);
	            Comparator<Object> dscComparator =  getColumnComparator(false, headerIndex);

	            header = new ListHeader(headerText);
	            if (!Util.isEmpty(tooltipText))
	            {
	            	header.setTooltiptext(tooltipText);
	            }

	            header.setSort("auto");
	            header.setSortAscending(ascComparator);
	            header.setSortDescending(dscComparator);

	            int width = headerText.trim().length() * 9;
	            if (width > 300)
	            	width = 300;
	            else if (classType != null)
	            {
	            	if (classType.equals(String.class))
	            	{
	            		if (width > 0 && width < 180)
	            			width = 180;
	            	}
	            	else if (classType.equals(IDColumn.class) || classType.equals(UUIDColumn.class))
	            	{
	            		header.setSort("none");
	            		if (width < 30)
	            			width = 30;
	            	}
	            	else if (classType.isAssignableFrom(Boolean.class))
	            	{
	            		if (width > 0 && width < 30)
	            			width = 30;
	            	}
		            else if (width > 0 && width < 100)
	            		width = 100;
	            }
	            else if (width > 0 && width < 100)
	            	width = 100;

	            header.setStyle("min-width: " + width + "px");
        	}
            ZKUpdateUtil.setHflex(header, "min");
            m_headers.add(header);
        }
        else
        {
            header = m_headers.get(headerIndex);

            if (!header.getLabel().equals(headerText))
            {
                header.setLabel(headerText);
            }
        }

		return header;
	}

	/**
	 * set custom list header
	 * @param index index of column
	 * @param header ListHeader
	 */
	public void setListHeader(int index, ListHeader header) {
		int size = m_headers.size();
		if (size <= index) {
			while (size <= index) {
				if (size == index)
					m_headers.add(header);
				else
					m_headers.add(null);
				size++;
			}

		} else
			m_headers.set(index, header);
	}
	
	/**
	 * get list header
	 * @param index index of column
	 * @return ListHeader
	 */
	public ListHeader getListHeader(int index) {
		if (m_headers.size() <= index)
			return null;
		return m_headers.get(index);
	}

    /**
     * Create comparator for a given column.
     *
     * @param ascending     whether the comparator will sort ascending
     * @param columnIndex   the index of column
     * @return comparator for the given column for the given sort direction
     */
    protected Comparator<Object> getColumnComparator(boolean ascending, final int columnIndex)
    {
    	return new ColumnComparator(ascending, columnIndex);
    }

    /**
     * Column Comparator implementation
     */
    public static class ColumnComparator implements Comparator<Object>
    {
    	private int columnIndex;
		private MSort sort;

		public ColumnComparator(boolean ascending, int columnIndex)
    	{
    		this.columnIndex = columnIndex;
    		sort = new MSort(0, null);
        	sort.setSortAsc(ascending);
    	}

        public int compare(Object o1, Object o2)
        {
                Object item1 = ((List<?>)o1).get(columnIndex);
                Object item2 = ((List<?>)o2).get(columnIndex);
                return sort.compare(item1, item2);
        }

		public int getColumnIndex()
		{
			return columnIndex;
		}
    }

	/**
	 * Render column headers
	 *
	 * @param head The ListHead component to render.
	 * @see #addColumn(String)
	 * @see #WListItemRenderer(List)
	 */
	public void renderListHead(ListHead head)
	{
		Component header;
        WTableColumn column;

		for (int columnIndex = 0; columnIndex < m_tableColumns.size(); columnIndex++)
        {
            column = m_tableColumns.get(columnIndex);
			header = getListHeaderComponent(column.getHeaderValue(), column.getTooltipText(), columnIndex, column.getColumnClass());
            head.appendChild(header);
		}
		head.setSizable(true);
	}

	/* (non-Javadoc)
	 * @see org.zkoss.zk.ui.event.EventListener#onEvent(org.zkoss.zk.ui.event.Event)
	 */
	@Override
	public void onEvent(Event event) throws Exception
	{
		int col = -1;
		int row = -1;
		Object value = null;
		TableValueChangeEvent vcEvent = null;
		WTableColumn tableColumn;

		Component source = event.getTarget();

		if (isWithinListCell(source))
		{
			row = getRowPosition(source);
			col = getColumnPosition(source);

			tableColumn = m_tableColumns.get(col);

			if (source instanceof Checkbox)
			{
				value = Boolean.valueOf(((Checkbox)source).isChecked());
			}
			else if (source instanceof Decimalbox)
			{
				value = ((Decimalbox)source).getValue();
			}
			else if (source instanceof Datebox)
			{
				if (((Datebox)source).getValue() != null)
					value = new Timestamp(((Datebox)source).getValue().getTime());
			}
			else if (source instanceof Textbox)
			{
				value = ((Textbox)source).getValue();
			}

			if(value != null)
			{
				vcEvent = new TableValueChangeEvent(source,
						tableColumn.getHeaderValue().toString(),
						row, col,
						value, value);

				fireTableValueChange(vcEvent);
			}
		}
		else if (event.getTarget() instanceof WListbox && Events.ON_SELECT.equals(event.getName()))
		{
			WListbox table = (WListbox) event.getTarget();
			if (table.isCheckmark()) {
				int cnt = table.getRowCount();
				if (cnt == 0 || !(table.getValueAt(0, 0) instanceof IDColumn || table.getValueAt(0, 0) instanceof UUIDColumn))
					return;

				//update IDColumn
				tableColumn = m_tableColumns.get(0);
				for (int i = 0; i < cnt; i++) {
					SelectableIDColumn idcolumn = (SelectableIDColumn) table.getValueAt(i, 0);
					Listitem item = table.getItemAtIndex(i);

					value = item.isSelected();
					Boolean old = idcolumn.isSelected();

					if (!old.equals(value)) {
						vcEvent = new TableValueChangeEvent(source,
								tableColumn.getHeaderValue().toString(),
								i, 0,
								old, value);

						fireTableValueChange(vcEvent);
					}
				}
			}
		}
	}

	/**
	 * @param source Component
	 * @return true if source is own by Listcell (direct or indirect)
	 */
	private boolean isWithinListCell(Component source) {
		if (source instanceof Listcell)
			return true;
		Component c = source.getParent();
		while(c != null) {
			if (c instanceof Listcell)
				return true;
			c = c.getParent();
		}
		return false;
	}

	/**
	 * Get the row index of the given <code>source</code> component.
	 *
	 * @param source	The component for which the row index is to be found.
	 * @return The row index of the given component or -1 if not found.
	 */
	protected int getRowPosition(Component source)
	{
		Listcell cell;
		ListItem item;
		int row = -1;

		cell = findListcell(source);
		item = (ListItem)cell.getParent();

		row = item.getIndex();

		return row;
	}

	/**
	 * Find Listcell that own a Component.
	 * @param source Component
	 * @return Listcell that own source (direct or indirect) or null if not found
	 */
	private Listcell findListcell(Component source) {
		if (source instanceof Listcell)
			return (Listcell) source;
		Component c = source.getParent();
		while(c != null) {
			if (c instanceof Listcell)
				return (Listcell) c;
			c = c.getParent();
		}
		return null;
	}

	/**
	 * Get the column index of the given <code>source</code> component.
	 *
	 * @param source The component for which the column index is to be found.
	 * @return The column index of the given component.
	 */
	protected int getColumnPosition(Component source)
	{
		Listcell cell;
		int col = -1;

		cell = findListcell(source);
		col = cell.getColumnIndex();

		return col;
	}

	/**
	 * Reset the renderer.<br/>
	 * This should be called if the table using this renderer is cleared.
	 */
	public void clearColumns()
	{
		m_tableColumns.clear();
	}

	/**
	 * Clear selections
	 */
	public void clearSelection()
	{
		m_selectedItems.clear();
	}

	/**
	 * Add a listener for changes in the table's component values.
	 *
	 * @param listener	The listener to add.
	 */
	public void addTableValueChangeListener(TableValueChangeListener listener)
	{
	    if (listener == null)
	    {
	    	return;
	    }

	    m_listeners.add(listener);
	}

	/**
	 * Remove listener
	 * @param listener
	 */
	public void removeTableValueChangeListener(TableValueChangeListener listener)
	{
		if (listener == null)
	    {
	    	return;
		}

	    m_listeners.remove(listener);
	}

	/**
	 * Fire the given table value change <code>event</code>.
	 *
	 * @param event	The event to pass to the listeners
	 */
	private void fireTableValueChange(TableValueChangeEvent event)
	{
	    for (TableValueChangeListener listener : m_listeners)
	    {
	       listener.tableValueChange(event);
	    }
	}

	/* (non-Javadoc)
	 * @see org.zkoss.zul.ListitemRendererExt#getControls()
	 */
	@Override
	public int getControls()
	{
		return DETACH_ON_RENDER;
	}

	/* (non-Javadoc)
	 * @see org.zkoss.zul.ListitemRendererExt#newListcell(org.zkoss.zul.Listitem)
	 */
	@Override
	public Listcell newListcell(Listitem item)
	{
		ListCell cell = new ListCell();
		cell.applyProperties();
		return cell;
	}

	/* (non-Javadoc)
	 * @see org.zkoss.zul.ListitemRendererExt#newListitem(org.zkoss.zul.Listbox)
	 */
	@Override
	public Listitem newListitem(Listbox listbox)
	{
		ListItem item = new ListItem();
		item.applyProperties();

		return item;
	}

	/**
	 * Set column header text
	 * @param index
	 * @param header
	 */
	public void setColumnHeader(int index, String header)
	{
		if (index >= 0 && index < m_tableColumns.size())
		{
			m_tableColumns.get(index).setHeaderValue(Util.cleanAmp(header));
		}

	}

	/**
	 * Set column type
	 * @param index index of column
	 * @param classType Class Type of column
	 */
	public void setColumnClass(int index, Class<?> classType) {
		if (index >= 0 && index < m_tableColumns.size())
		{
			m_tableColumns.get(index).setColumnClass(classType);
		}
	}
	
	/**
	 * @return Unmodifiable list of {@link WTableColumn}
	 */
	public List<WTableColumn> getTableColumns() {
		return Collections.unmodifiableList(m_tableColumns);
	}

	/**
	 * Listen to onDoubleClick event from Listcell and send onDoubleClick event to list box. 
	 */
	class CellListener implements EventListener<Event> {

		public CellListener() {
		}

		public void onEvent(Event event) throws Exception {
			if (listBox != null && Events.ON_DOUBLE_CLICK.equals(event.getName())) {
				Event evt = new Event(Events.ON_DOUBLE_CLICK, listBox);
				Events.sendEvent(listBox, evt);
				Clients.evalJavaScript("jq('img.fullsize-image').remove();");
			}
		}

	}
}


