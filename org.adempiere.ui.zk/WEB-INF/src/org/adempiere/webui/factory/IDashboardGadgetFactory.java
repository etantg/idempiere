/******************************************************************************
 * Copyright (C) 2013 Antonio Cañaveral                                       *
 * Copyright (C) 2013 Trek Global                 							  *
 * This program is free software; you can redistribute it and/or modify it    *
 * under the terms version 2 of the GNU General Public License as published   *
 * by the Free Software Foundation. This program is distributed in the hope   *
 * that it will be useful, but WITHOUT ANY WARRANTY; without even the implied *
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.           *
 * See the GNU General Public License for more details.                       *
 * You should have received a copy of the GNU General Public License along    *
 * with this program; if not, write to the Free Software Foundation, Inc.,    *
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA.                     *
 *****************************************************************************/
package org.adempiere.webui.factory;

import org.compiere.model.MDashboardContent;
import org.zkoss.zk.ui.Component;

/**
 * Factory interface for dashboard gadget
 * @author Antonio Cañaveral
 * @author hengsin
 */
public interface IDashboardGadgetFactory {
	
	/**
     * Create dashboard gadget from URI
     * @param uri zul url
     * @param parent Component
     * @return new DashboardPanel component instance or null
     */
    public Component getGadget(String uri, Component parent);

	/**
	 * Create dashboard gadget from URL or MDashboardContent 
	 * @param url zul url
	 * @param parent Component
	 * @param dc MDashboardContent
     * @return new DashboardPanel component instance or null
	 */
    default public Component getGadget(String url, Component parent, MDashboardContent dc) {
    	return getGadget(url, parent); // ignore the third method by default (backward compatibility)
    }

}
