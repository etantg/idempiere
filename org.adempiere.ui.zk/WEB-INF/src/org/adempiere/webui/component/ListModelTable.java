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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import org.adempiere.webui.event.WTableModelEvent;
import org.adempiere.webui.event.WTableModelListener;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.event.ListDataEvent;
import org.zkoss.zul.ext.Sortable;

/**
 * ListModel<Object> for Listbox and provide support for the Sortable interface.<br/>
 * The model allows for a table structure to be created with columns, 
 * in addition to the functionalities provided by {@link org.zkoss.zul.ListModelList}.
 *
 * @author Andrew Kimball
 *
 */
public class ListModelTable extends ListModelList<Object> implements Sortable<Object>
{
	/**
	 * generated serial id
	 */
	private static final long serialVersionUID = 1891313647781142789L;
	/** Array of listeners to changes in the table model. */
	protected ArrayList<WTableModelListener> m_listeners = new ArrayList<WTableModelListener>();
	/** The number of columns in the table. */
	private int m_noColumns;

	private Sortable<Object> sorter = null;

	/**
	 * Default constructor.
	 *
	 */
	public ListModelTable()
	{
		super();
	}

	/**
	 * Construct the ListModel<Object> with a collection of objects.<br/>
	 * A copy is made of the collection.<br/>
	 * The element in collection should be vector of objects.
	 *
	 * @param collection	The collection of objects with which to initialise the list
	 */
	@SuppressWarnings("unchecked")
	public ListModelTable(Collection<?> collection)
	{
		super(collection);

		m_noColumns = 0;

		for (Object row : getInnerList())
		{
			if (row instanceof List)
			{
				m_noColumns = Math.max(m_noColumns, ((List<Object>)row).size());
			}
			else
			{
				throw new IllegalArgumentException("The collection must contain list of objects");
			}
		}
	}

	/**
	 * Get the number of columns in the table.
	 *
	 * @return the number of columns in the table. 0 if uninitialised.
	 */
	public int getNoColumns()
	{
		return m_noColumns;
	}

	/**
	 * Add a column to the model.
	 *
	 */
	public void addColumn()
	{
		m_noColumns++;

		ensureRowSize();

		return;
	}

	/**
	 * Ensure that each element of every row contains the correct number of element/column (i.e == m_noColumns).<br/>
	 * Please note that the table cannot be shrunk.
	 */
    private void ensureRowSize()
	{
		@SuppressWarnings("unchecked")
		Iterator<List<Object>> rowIterator = (Iterator<List<Object>>)(Object)this.getInnerList().iterator();

        while (rowIterator.hasNext())
		{
        	List<Object> list = rowIterator.next();
        	if (list instanceof Vector)
        		((Vector<Object>)list).setSize(m_noColumns);
        	else 
        	{
        		if (m_noColumns > list.size()) 
        		{
        		    for(int i = list.size(); i < m_noColumns; i++) 
        		    {
        		    	list.add(null);
        		    }
        		} 
        		else if (m_noColumns < list.size()) 
        		{
        		    for (int i = list.size(); i > m_noColumns; i--) 
        		    {
        		    	list.remove(i - 1);
        		    }
        		}
        	}
		}
	}

	/**
	 * Set the number of columns that the table is to contain.
	 * @param columns	The number of columns.
	 */
	public void setNoColumns(int columns)
	{
		m_noColumns = columns;

		ensureRowSize();
	}

	/**
	 * Get the number of rows in the table.
	 * @return the number of rows in the table
	 */
	public int getNoRows()
	{
		return this.getSize();
	}

	/**
     * Returns the cell value at <code>rowIndex</code> and <code>columnIndex</code>.
     *
     * @param   rowIndex    the index of the row whose value is to be queried
     * @param   columnIndex	the index of the column whose value is to be queried
     * @return The object stored at the specified position
     */
	@SuppressWarnings("unchecked")
	public Object getDataAt(int rowIndex, int columnIndex)
	{
		List<Object> modelRow;
		Object dataObject;

		try
		{
			modelRow = (List<Object>)getElementAt(rowIndex);

			dataObject = modelRow.get(columnIndex);
		}
		catch (Exception exception)
		{
			throw new IllegalArgumentException("Attempted to access "
					+ "nonexistent ListModelTable field at "
					+ rowIndex + ", " + columnIndex);
		}
		
		return dataObject;
	}

	/**
	 * Set the cell value at <code>row</code> and <code>column</code>.
	 *
	 * @param aValue	The value to set
     * @param row    	the index of the row whose value is to be set
     * @param col		the index of the column whose value is to be set
	 */
	@SuppressWarnings("unchecked")
	public void setDataAt(Object aValue, int row, int col)
	{
		List<Object> vector;
		WTableModelEvent tcEvent;

		try
		{
			if (getElementAt(row) instanceof List)
			{
				vector = (List<Object>)getElementAt(row);

				try
				{
					vector.set(col, aValue);

					// create a new event and fire the event
					tcEvent = new WTableModelEvent(this, row, col);
					fireTableChange(tcEvent);
				}
				catch (ArrayIndexOutOfBoundsException exception)
				{
					throw new IllegalArgumentException("Attempted to access "
							+ "nonexistent ListModelTable column at index "
							+ col);
				}
			}
			else
			{
				throw new IllegalArgumentException("The ListModelTable cannot contain "
						+ "anything other than object vectors as its row elements");
			}
		}
		catch (IndexOutOfBoundsException exception)
		{
			throw new IllegalArgumentException("Attempted to access "
					+ "nonexistent ListModelTable row at index " + row);
		}

		return;
	}

	/**
	 * Set the number of rows in the table and initialise new rows (if necessary).<br/>
	 * For each new row, an empty collection of the size specified by
	 * {@link #setNoColumns(int)} is created.
	 * @param rowCount	The number of rows to be contained in the table
	 */
	public void setNoRows(int rowCount)
	{
		List<Object> newRow = null;
		
		int currentSize = getSize();
		if (rowCount >= currentSize)
		{
			boolean vector = (getInnerList() instanceof Vector) ? true : false;
			while (getSize() < rowCount)
			{
				if (vector)
				{
					newRow = new Vector<Object>(getNoColumns());
					((Vector<Object>)newRow).setSize(getNoColumns());
					add(newRow);
				}
				else
				{
					newRow = new ArrayList<Object>(getNoColumns());
					for(int i = 0; i < getNoColumns(); i++) 
					{
						newRow.add(null);
					}
					add(newRow);
				}
			}
		}
		else
		{
			if (rowCount == 0)
				clearSelection();
			removeRange(rowCount, currentSize);
		}
	}

	/**
	 * Add a listener for events from the data model.
     * <p>
     * The listener will only be added if it doesn't already exist.
	 *
	 * @param listener	A listener for changes in the table mode
	 */
	public void addTableModelListener(WTableModelListener listener)
	{
	    if (listener == null)
	    {
	    	return;
	    }

        if (!m_listeners.contains(listener))
        {
            m_listeners.add(listener);
        }

	    return;
	}

	/**
	 * Remove WTableModelListener listener
	 * @param listener
	 */
    public void removeTableModelListener(WTableModelListener listener)
    {
        m_listeners.remove(listener);
    }
    
	/**
	 * Fire table changed event to WTableModelListener in {@link #m_listeners}.
	 * 
	 * @param event	The event tofire
	 */
	private void fireTableChange(WTableModelEvent event)
	{
	    for (WTableModelListener listener : m_listeners)
	    {
	       listener.tableChanged(event);
	    }
	}

    /*
     * (non-Javadoc)
     * @see org.zkoss.zul.ListModelList#sort(java.util.Comparator, boolean)
     */
	@Override
    public void sort(Comparator<Object> cmpr, boolean ascending)
    {
    	if (sorter != null)
    		sorter.sort(cmpr, ascending);
    	else
        	Collections.sort(this.getInnerList(), cmpr);

        WTableModelEvent event = new WTableModelEvent(this,
                WTableModelEvent.ALL_ROWS,
                WTableModelEvent.ALL_COLUMNS);

        fireTableChange(event);
    }

    /**
     * Alias for getDataAt, to ease porting of swing form
     * @param rowIndex
     * @param columnIndex
     * @return column value
     */
	public Object getValueAt(int rowIndex, int columnIndex) {
		return getDataAt(rowIndex, columnIndex);
	}

	/**
	 * Alias for setDataAt, to ease porting of swing form
	 * @param value
	 * @param row
	 * @param col
	 */
	public void setValueAt(Object value, int row, int col) {
		setDataAt(value, row, col);
	}

	/**
	 * Alias for getSize, to ease porting of swing form
	 * @return size
	 */
	public int getRowCount() {
		return getSize();
	}
	
	/**
	 * Request components that attached to this model to re-render a row.
	 * @param row
	 */
	public void updateComponent(int row) {
		updateComponent(row, row);
	}
	
	/**
	 * Request components that attached to this model to re-render a range of row.
	 * @param fromRow
	 * @param toRow
	 */
	public void updateComponent(int fromRow, int toRow) {
		//must run from the UI thread
		if (Executions.getCurrent() != null) {
			fireEvent(ListDataEvent.CONTENTS_CHANGED, fromRow, toRow);
		}
	}

	/**
	 * Set custom sorter for model
	 * @param lme Custom Sortable implementation
	 */
	public void setSorter(Sortable<Object> lme)
	{
		sorter = lme;
	}
}
