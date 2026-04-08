<%@ taglib uri="http://www.zkoss.org/dsp/web/core" prefix="c" %>

<%-- menu item link --%>
.menu-href {
	font-size: var(--zk-font-size-sm);
	font-weight: var(--zk-font-weight-normal);
	color: var(--zk-text-color-default) !important;
	text-decoration: none !important;
	padding-right: var(--zk-space-md);
}
.menu-href:hover, .menu-href:active {
	text-decoration: none !important;
	background: var(--zk-color-primary-lighter);
	color: var(--zk-text-color-hover);
}
.menu-href img {
	padding: var(--zk-space-xs);
	padding-right: var(--zk-space-md);
	width: var(--zk-dimension-icon-md);
	height: var(--zk-dimension-icon-md);
}
.menu-href-newbtn {
	height: 17px;
	line-height: 10px;
	padding: var(--zk-space-2xs) var(--zk-space-2xs);
	padding-bottom: var(--zk-space-xs);
	padding-left: var(--zk-space-xs);
	margin-bottom: var(--zk-space-xs);
}
.menu-href-newbtn img {
	width: var(--zk-dimension-icon-xs);
	height: var(--zk-dimension-icon-xs);
}
.menu-href-newbtn .z-toolbarbutton-content {
	height: var(--zk-dimension-icon-xs);
	width: var(--zk-dimension-icon-xs);
	display: inline-block;
	line-height: 10px;
}
.menu-href [class^="z-icon-"] {
	font-size: larger;
	color: var(--zk-text-color-default);	
	padding-right: var(--zk-space-md);
	text-align: center;
}
.menu-href [class^="z-icon-"]:before {
	width: 14px;
}
.menu-href-newbtn.z-toolbarbutton [class^="z-icon-"] {
	font-size: smaller;
	color: var(--zk-text-color-default);
}
.menu-href-newbtn.z-toolbarbutton,
.menu-href-newbtn.z-toolbarbutton .z-toolbarbutton-content {
	justify-content: center;
	align-items: center;
	display: inline-flex;
}
.link {
	cursor:pointer;
	padding: var(--zk-space-xs) var(--zk-space-xs) var(--zk-space-md) var(--zk-space-md);
	border: none !important;
}

<%-- combo search box for tree --%>
.tree-search-combo .z-comboitem-img img {
	width: var(--zk-dimension-icon-md);
	height: var(--zk-dimension-icon-md);
}

<%-- search panel for menu tree (deprecated) --%>
.menu-search-panel .z-comboitem-image { 
	padding-bottom:var(--zk-space-md); 
}
.menu-search-panel-container .z-panel-body {
	background-color: transparent;
}
.menu-search-panel-container .z-panel-top .z-toolbar.z-toolbar-panel {
	padding-bottom: 0px;
	padding-top: var(--zk-space-xl);
}
.menu-search-toggle-box {
	display: inline-block;
	border: 1px solid var(--zk-color-border-control);			
}
.menu-search-toggle-box .z-toolbarbutton-hover {
	border: none;
}
.menu-search-toggle-off {
	margin:0px; 
	padding: var(--zk-space-2xs) var(--zk-space-md) var(--zk-space-2xs) var(--zk-space-md);
	border-radius: 0px;
}
.menu-search-toggle-on {
	margin:0px !important;
	padding: var(--zk-space-2xs) var(--zk-space-md) var(--zk-space-2xs) var(--zk-space-md) !important;
	border-radius: 0px;
}
.menu-search-toggle-on img, .menu-search-toggle-off img {
	height: var(--zk-dimension-icon-md);
	width: var(--zk-dimension-icon-md);
}

<%-- panel for menu tree --%>
.menu-panel .z-toolbar-panel {
	padding-right: 0;
}
.menu-panel {
	width: 100% !important;
	height: 100% !important;
	position: relative !important;
}
.menu-panel .z-tree {
	border: none !important;
	width: 100%;
}

<%-- global search (document and application menu) --%>
<%-- current selected document link --%>
.document-search-current-link {
	background-image:url(${c:encodeThemeURL('~./zul/img/tree/item-sel.gif')});
}
.global-search-box.z-bandbox > .z-bandbox-button {
	width: var(--zk-dimension-control-md);
}
.global-search-tabpanel {
	width: var(--zk-dimension-dialog-md);
}
@media screen and (max-width: 649px) {
	.global-search-box.z-bandbox-popup {
		width: 90% !important;
	}
	.global-search-tabpanel {
		width: 100%;
	}
}
.global-search-box.z-bandbox {
	width: 180px;
}
.global-search-box.z-bandbox > input.z-bandbox-input {
	width: 180px;
}
@media screen and (min-width: 500px) {
	.global-search-box.z-bandbox {
		width: var(--zk-dimension-panel-md);
	}
	.global-search-box.z-bandbox > input.z-bandbox-input {
		width: var(--zk-dimension-panel-md);
	}
}
@media screen and (min-width: 768px) {
	.global-search-box.z-bandbox {
		width: 250px;
	}
	.global-search-box.z-bandbox > input.z-bandbox-input {
		width: 250px;
	}
}
@media screen and (min-width: 1024px) {
	.global-search-box.z-bandbox {
		width: var(--zk-dimension-panel-lg);
	}
	.global-search-box.z-bandbox > input.z-bandbox-input {
		width: var(--zk-dimension-panel-lg);
	}
}
.global-search-tabpanel .window-name.z-label {
	padding: var(--zk-space-sm); 
	font-weight: var(--zk-font-weight-bold); 
	display: inline-block;
}
.global-search-tabpanel .search-result.z-a {
	padding-left: var(--zk-space-sm); 
	display: inline-block;
}
.global-search-tabpanel .highlight {
	background-color: var(--zk-color-status-pending);
}
<%-- application menu search result list item --%>
.menu-search-list-toolbar-cell.z-listcell > div.z-listcell-content {
	display: inline-flex; 
	align-items: center;
	justify-content: center;
}
.menu-search-list-toolbar-cell.z-listcell .fav-new-btn.z-toolbarbutton [class^="z-icon-"] {
	font-size: larger;
}
.menu-search-list-toolbar-cell .fav-new-btn {
	padding: 0px;
    border-left: 0px;
    border-right: 0px;
}

<%-- dropdown menu item --%>
.z-menu-noimage.z-menupopup .z-menu-content > img.z-menu-image {
	display: none;
}
.z-menu-noimage.z-menupopup .z-menuitem-content > img.z-menuitem-image {
	display: none;
}
.z-menu-noimage.z-menupopup > .z-menupopup-separator {
	display: none;
}
.z-menuitem.selected .z-menuitem-text {
	font-weight: var(--zk-font-weight-bold);
}
