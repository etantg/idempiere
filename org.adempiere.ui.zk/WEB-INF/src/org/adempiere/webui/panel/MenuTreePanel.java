/******************************************************************************
 * Copyright (C) 2012 Elaine Tan                                              *
 * Copyright (C) 2012 Trek Global
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

package org.adempiere.webui.panel;

import org.adempiere.webui.component.ToolBarButton;
import org.adempiere.webui.theme.ThemeManager;
import org.adempiere.webui.util.Icon;
import org.adempiere.webui.util.TreeUtils;
import org.compiere.model.MSysConfig;
import org.compiere.model.MUser;
import org.compiere.util.Env;
import org.compiere.util.Msg;
import org.compiere.util.Util;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Page;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.EventQueues;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Panelchildren;
import org.zkoss.zul.Toolbar;
import org.zkoss.zul.Toolbarbutton;

/**
 * Menu tree panel. <br/>
 * Composite component of Tree, expand toggle and {@link MenuTreeFilterPanel}.
 * @author Elaine
 * @date July 31, 2012
 */
public class MenuTreePanel extends AbstractMenuPanel
{
    /**
	 * generated serial id
	 */
	private static final long serialVersionUID = -911113870835089567L;
	private static final String ON_EXPAND_MENU_EVENT = "onExpandMenu";
	
	private ToolBarButton expandToggle;
	private MenuTreeFilterPanel filterPanel;
	private Toolbarbutton filterBtn;
	private EventListener<Event> listener;
    
	/**
	 * 
	 * @param parent
	 */
    public MenuTreePanel(Component parent)
    {
    	super(parent);
    }

    @Override
    protected void init() 
    {
		super.init();

        // Auto Expand Tree - nmicoud IDEMPIERE 195
     	if (MUser.get(getCtx()).isMenuAutoExpand())
     		expandAll();
     	
     	listener = new EventListener<Event>() {
			public void onEvent(Event event) throws Exception {
				if (getMenuTree() == null || getMenuTree().getPage() == null)
					return;
				if (event.getName() == Events.ON_CHECK)
				{
					Checkbox chk = (Checkbox) event.getData();
					if (chk != null)
					{
						if ("flatView".equals(chk.getId()))
							MenuTreeFilterPanel.toggleFlatView(getMenuTree(), chk);
						else
							MenuTreeFilterPanel.toggle(getMenuTree(), chk);
						getMenuTree().invalidate();
					}
				}
			}
		};
		EventQueues.lookup(MenuTreeFilterPanel.MENU_TREE_FILTER_CHECKED_QUEUE, EventQueues.DESKTOP, true).subscribe(listener);
		
		if (MSysConfig.getBooleanValue(MSysConfig.ZK_FLAT_VIEW_MENU_TREE, false, Env.getAD_Client_ID(Env.getCtx())))
        	filterPanel.switchToFlatView();
    }
    
    @Override
    protected void initComponents()
    {
    	super.initComponents();
    	
        Panelchildren pc = new Panelchildren();
        this.appendChild(pc);
        pc.appendChild(getMenuTree());
        
        Toolbar toolbar = new Toolbar();
        toolbar.setSclass("desktop-menu-toolbar");
        this.appendChild(toolbar);
        
        expandToggle = new ToolBarButton();
        expandToggle.setLabel(Util.cleanAmp(Msg.getMsg(Env.getCtx(), "ExpandTree")));
        expandToggle.setMode("toggle");
        expandToggle.addEventListener(Events.ON_CHECK, this);
        toolbar.appendChild(expandToggle);
        toolbar.setMold("panel");
        this.addEventListener(ON_EXPAND_MENU_EVENT, this);
        
        filterPanel = new MenuTreeFilterPanel(getMenuTree(), null);
        pc.appendChild(filterPanel);

        filterBtn = new Toolbarbutton();
        if (ThemeManager.isUseFontIconForImage())
        	filterBtn.setIconSclass(Icon.getIconSclass(Icon.PREFERENCE));
        else
        	filterBtn.setImage(ThemeManager.getThemeResource("images/Preference16.png"));
        filterBtn.addEventListener(Events.ON_CLICK, this);
        toolbar.appendChild(filterBtn);        
    }
    
    @Override
    public void onEvent(Event event)
    {
    	super.onEvent(event);
    	
        String eventName = event.getName();
        if (eventName.equals(Events.ON_CHECK) && event.getTarget() == expandToggle)
        {
        	Clients.showBusy(null);
        	Events.echoEvent(ON_EXPAND_MENU_EVENT, this, null);        	
        }
        else if (eventName.equals(ON_EXPAND_MENU_EVENT)) 
        {
        	expandOnCheck();
        	Clients.clearBusy();
        }
        //
        else if (event.getName().equals(Events.ON_CLICK) && event.getTarget() == filterBtn)
        	filterPanel.open(filterBtn, "before_start");
    }
	
	/**
	 * expand all node
	 */
	public void expandAll()
	{
		if (!expandToggle.isChecked())
			expandToggle.setChecked(true);
	
		TreeUtils.expandAll(getMenuTree());
	}
	
	/**
	 * collapse all node
	 */
	public void collapseAll()
	{
		if (expandToggle.isChecked())
			expandToggle.setChecked(false);
	
		TreeUtils.collapseAll(getMenuTree());
	}
	
	/**
	 * On check event for the expand checkbox
	 */
	private void expandOnCheck()
	{
		if (expandToggle.isChecked())
			expandAll();
		else
			collapseAll();
	}

	@Override
	public void onPageDetached(Page page) {
		super.onPageDetached(page);
		if (listener != null) {
			EventQueues.lookup(MenuTreeFilterPanel.MENU_TREE_FILTER_CHECKED_QUEUE, EventQueues.DESKTOP, true).unsubscribe(listener);
			listener = null;
		}
	}		
	//
}
