<%@ taglib uri="http://www.zkoss.org/dsp/web/core" prefix="c" %>

:root {
	--zk-menu-link-font-size: var(--zk-font-size-sm);
	--zk-menu-link-font-weight: var(--zk-font-weight-normal);
	--zk-menu-link-color: var(--zk-text-color-default);
	--zk-menu-link-hover-color: var(--zk-text-color-hover);
	--zk-menu-link-hover-bg: var(--zk-color-primary-lighter);
	--zk-menu-link-text-decoration: var(--zk-text-decoration-none);
	--zk-menu-link-padding-inline-end: var(--zk-space-md);
	--zk-menu-link-image-padding: var(--zk-space-xs);
	--zk-menu-link-image-padding-inline-end: var(--zk-space-md);
	--zk-menu-link-image-width: var(--zk-dimension-icon-md);
	--zk-menu-link-image-height: var(--zk-dimension-icon-md);
	--zk-menu-link-icon-font-size: var(--zk-font-size-larger);
	--zk-menu-link-icon-width: var(--zk-size-14);
	--zk-menu-new-link-icon-font-size: var(--zk-font-size-smaller);
	--zk-menu-new-button-height: var(--zk-size-17);
	--zk-menu-new-button-line-height: var(--zk-size-10);
	--zk-menu-new-button-padding: var(--zk-space-2xs) var(--zk-space-2xs);
	--zk-menu-new-button-padding-block-end: var(--zk-space-xs);
	--zk-menu-new-button-padding-inline-start: var(--zk-space-xs);
	--zk-menu-new-button-margin-block-end: var(--zk-space-xs);
	--zk-menu-new-button-image-width: var(--zk-dimension-icon-xs);
	--zk-menu-new-button-image-height: var(--zk-dimension-icon-xs);
	--zk-menu-new-button-content-width: var(--zk-dimension-icon-xs);
	--zk-menu-new-button-content-height: var(--zk-dimension-icon-xs);
	--zk-menu-tree-search-image-width: var(--zk-dimension-icon-md);
	--zk-menu-tree-search-image-height: var(--zk-dimension-icon-md);
	--zk-menu-action-link-padding: var(--zk-space-xs) var(--zk-space-xs) var(--zk-space-md) var(--zk-space-md);
	--zk-menu-action-link-border: var(--zk-border-none);
	--zk-menu-search-panel-bg: var(--zk-color-transparent);
	--zk-menu-search-panel-padding-block-end: var(--zk-space-md);
	--zk-menu-search-panel-toolbar-padding-block-end: var(--zk-space-0);
	--zk-menu-search-panel-toolbar-padding-block-start: var(--zk-space-xl);
	--zk-menu-search-toggle-border: var(--zk-size-1) solid var(--zk-color-border-control);
	--zk-menu-search-toggle-hover-border: var(--zk-border-none);
	--zk-menu-search-toggle-margin: var(--zk-space-0);
	--zk-menu-search-toggle-padding: var(--zk-space-2xs) var(--zk-space-md) var(--zk-space-2xs) var(--zk-space-md);
	--zk-menu-search-toggle-radius: var(--zk-radius-none);
	--zk-menu-search-toggle-icon-width: var(--zk-dimension-icon-md);
	--zk-menu-search-toggle-icon-height: var(--zk-dimension-icon-md);
	--zk-menu-panel-toolbar-padding-inline-end: var(--zk-space-0);
	--zk-menu-panel-tree-border: var(--zk-border-none);
	--zk-menu-search-window-name-padding: var(--zk-space-sm);
	--zk-menu-search-window-name-font-weight: var(--zk-font-weight-bold);
	--zk-menu-search-result-padding-inline-start: var(--zk-space-sm);
	--zk-menu-search-highlight-bg: var(--zk-color-status-pending);
	--zk-menu-panel-width: var(--zk-size-full);
	--zk-menu-panel-height: var(--zk-size-full);
	--zk-menu-panel-tree-width: var(--zk-size-full);
	--zk-menu-global-search-button-width: var(--zk-dimension-control-md);
	--zk-menu-global-search-tabpanel-width: var(--zk-dimension-dialog-md);
	--zk-menu-global-search-box-width: var(--zk-size-180);
	--zk-menu-global-search-box-input-width: var(--zk-size-180);
	--zk-menu-global-search-box-width-sm: var(--zk-dimension-panel-md);
	--zk-menu-global-search-box-input-width-sm: var(--zk-dimension-panel-md);
	--zk-menu-global-search-box-width-md: var(--zk-size-250);
	--zk-menu-global-search-box-input-width-md: var(--zk-size-250);
	--zk-menu-global-search-box-width-lg: var(--zk-dimension-panel-lg);
	--zk-menu-global-search-box-input-width-lg: var(--zk-dimension-panel-lg);
	--zk-menu-search-popup-width-mobile: var(--zk-size-90pct);
	--zk-menu-search-tabpanel-width-mobile: var(--zk-size-full);
	--zk-menu-search-list-icon-font-size: var(--zk-font-size-larger);
	--zk-menu-search-list-button-padding: var(--zk-space-0);
	--zk-menu-search-list-button-border-inline-start: var(--zk-size-0);
	--zk-menu-search-list-button-border-inline-end: var(--zk-size-0);
	--zk-menu-selected-item-font-weight: var(--zk-font-weight-bold);
}

<%-- menu item link --%>
.menu-href {
	font-size: var(--zk-menu-link-font-size);
	font-weight: var(--zk-menu-link-font-weight);
	color: var(--zk-menu-link-color) !important;
	text-decoration: var(--zk-menu-link-text-decoration) !important;
	padding-right: var(--zk-menu-link-padding-inline-end);
}
.menu-href:hover, .menu-href:active {
	text-decoration: var(--zk-menu-link-text-decoration) !important;
	background: var(--zk-menu-link-hover-bg);
	color: var(--zk-menu-link-hover-color);
}
.menu-href img {
	padding: var(--zk-menu-link-image-padding);
	padding-right: var(--zk-menu-link-image-padding-inline-end);
	width: var(--zk-menu-link-image-width);
	height: var(--zk-menu-link-image-height);
}
.menu-href-newbtn {
	height: var(--zk-menu-new-button-height);
	line-height: var(--zk-menu-new-button-line-height);
	padding: var(--zk-menu-new-button-padding);
	padding-bottom: var(--zk-menu-new-button-padding-block-end);
	padding-left: var(--zk-menu-new-button-padding-inline-start);
	margin-bottom: var(--zk-menu-new-button-margin-block-end);
}
.menu-href-newbtn img {
	width: var(--zk-menu-new-button-image-width);
	height: var(--zk-menu-new-button-image-height);
}
.menu-href-newbtn .z-toolbarbutton-content {
	height: var(--zk-menu-new-button-content-height);
	width: var(--zk-menu-new-button-content-width);
	display: inline-block;
	line-height: var(--zk-menu-new-button-line-height);
}
.menu-href [class^="z-icon-"] {
	font-size: var(--zk-menu-link-icon-font-size);
	color: var(--zk-menu-link-color);	
	padding-right: var(--zk-menu-link-padding-inline-end);
	text-align: center;
}
.menu-href [class^="z-icon-"]:before {
	width: var(--zk-menu-link-icon-width);
}
.menu-href-newbtn.z-toolbarbutton [class^="z-icon-"] {
	font-size: var(--zk-menu-new-link-icon-font-size);
	color: var(--zk-menu-link-color);
}
.menu-href-newbtn.z-toolbarbutton,
.menu-href-newbtn.z-toolbarbutton .z-toolbarbutton-content {
	justify-content: center;
	align-items: center;
	display: inline-flex;
}
.link {
	cursor:pointer;
	padding: var(--zk-menu-action-link-padding);
	border: var(--zk-menu-action-link-border) !important;
}

<%-- combo search box for tree --%>
.tree-search-combo .z-comboitem-img img {
	width: var(--zk-menu-tree-search-image-width);
	height: var(--zk-menu-tree-search-image-height);
}

<%-- search panel for menu tree (deprecated) --%>
.menu-search-panel .z-comboitem-image { 
	padding-bottom:var(--zk-menu-search-panel-padding-block-end); 
}
.menu-search-panel-container .z-panel-body {
	background-color: var(--zk-menu-search-panel-bg);
}
.menu-search-panel-container .z-panel-top .z-toolbar.z-toolbar-panel {
	padding-bottom: var(--zk-menu-search-panel-toolbar-padding-block-end);
	padding-top: var(--zk-menu-search-panel-toolbar-padding-block-start);
}
.menu-search-toggle-box {
	display: inline-block;
	border: var(--zk-menu-search-toggle-border);			
}
.menu-search-toggle-box .z-toolbarbutton-hover {
	border: var(--zk-menu-search-toggle-hover-border);
}
.menu-search-toggle-off {
	margin:var(--zk-menu-search-toggle-margin); 
	padding: var(--zk-menu-search-toggle-padding);
	border-radius: var(--zk-menu-search-toggle-radius);
}
.menu-search-toggle-on {
	margin:var(--zk-menu-search-toggle-margin) !important;
	padding: var(--zk-menu-search-toggle-padding) !important;
	border-radius: var(--zk-menu-search-toggle-radius);
}
.menu-search-toggle-on img, .menu-search-toggle-off img {
	height: var(--zk-menu-search-toggle-icon-height);
	width: var(--zk-menu-search-toggle-icon-width);
}

<%-- panel for menu tree --%>
.menu-panel .z-toolbar-panel {
	padding-right: var(--zk-menu-panel-toolbar-padding-inline-end);
}
.menu-panel {
	width: var(--zk-menu-panel-width) !important;
	height: var(--zk-menu-panel-height) !important;
	position: relative !important;
}
.menu-panel .z-tree {
	border: var(--zk-menu-panel-tree-border) !important;
	width: var(--zk-menu-panel-tree-width);
}

<%-- global search (document and application menu) --%>
<%-- current selected document link --%>
.document-search-current-link {
	background-image:url(${c:encodeThemeURL('~./zul/img/tree/item-sel.gif')});
}
.global-search-box.z-bandbox > .z-bandbox-button {
	width: var(--zk-menu-global-search-button-width);
}
.global-search-tabpanel {
	width: var(--zk-menu-global-search-tabpanel-width);
}
@media screen and (max-width: 649px) {
	.global-search-box.z-bandbox-popup {
		width: var(--zk-menu-search-popup-width-mobile) !important;
	}
	.global-search-tabpanel {
		width: var(--zk-menu-search-tabpanel-width-mobile);
	}
}
.global-search-box.z-bandbox {
	width: var(--zk-menu-global-search-box-width);
}
.global-search-box.z-bandbox > input.z-bandbox-input {
	width: var(--zk-menu-global-search-box-input-width);
}
@media screen and (min-width: 500px) {
	.global-search-box.z-bandbox {
		width: var(--zk-menu-global-search-box-width-sm);
	}
	.global-search-box.z-bandbox > input.z-bandbox-input {
		width: var(--zk-menu-global-search-box-input-width-sm);
	}
}
@media screen and (min-width: 768px) {
	.global-search-box.z-bandbox {
		width: var(--zk-menu-global-search-box-width-md);
	}
	.global-search-box.z-bandbox > input.z-bandbox-input {
		width: var(--zk-menu-global-search-box-input-width-md);
	}
}
@media screen and (min-width: 1024px) {
	.global-search-box.z-bandbox {
		width: var(--zk-menu-global-search-box-width-lg);
	}
	.global-search-box.z-bandbox > input.z-bandbox-input {
		width: var(--zk-menu-global-search-box-input-width-lg);
	}
}
.global-search-tabpanel .window-name.z-label {
	padding: var(--zk-menu-search-window-name-padding); 
	font-weight: var(--zk-menu-search-window-name-font-weight); 
	display: inline-block;
}
.global-search-tabpanel .search-result.z-a {
	padding-left: var(--zk-menu-search-result-padding-inline-start); 
	display: inline-block;
}
.global-search-tabpanel .highlight {
	background-color: var(--zk-menu-search-highlight-bg);
}
<%-- application menu search result list item --%>
.menu-search-list-toolbar-cell.z-listcell > div.z-listcell-content {
	display: inline-flex; 
	align-items: center;
	justify-content: center;
}
.menu-search-list-toolbar-cell.z-listcell .fav-new-btn.z-toolbarbutton [class^="z-icon-"] {
	font-size: var(--zk-menu-search-list-icon-font-size);
}
.menu-search-list-toolbar-cell .fav-new-btn {
	padding: var(--zk-menu-search-list-button-padding);
	border-left: var(--zk-menu-search-list-button-border-inline-start);
	border-right: var(--zk-menu-search-list-button-border-inline-end);
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
	font-weight: var(--zk-menu-selected-item-font-weight);
}
