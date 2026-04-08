<%@ taglib uri="http://www.idempiere.org/dsp/web/util" prefix="u" %>
<%-- header --%>
.desktop-north {
	background-color: var(--zk-color-primary-light);
	border-bottom: 1px solid var(--zk-color-header-border) !important;
}
<%-- left panel for logo and global search --%>
.desktop-header-left {
	margin: 0;
	margin-left: var(--zk-space-2xs);
	margin-top: var(--zk-space-2xs);
	background-color: transparent !important; 
	border: none !important;
}

.desktop-header {
	background-color: ${u:sysConfig("ZK_DESKTOP_HEADER_BACKGROUND_COLOR", "var(--zk-color-primary-light)")}; <%-- SysConfig with default to var(--zk-color-primary-light) --%>
	width: 100%;
	height: 46px;
	padding-left: var(--zk-space-md);
}

.desktop-header.mobile {
	height: 36px;
	padding: var(--zk-space-md) var(--zk-space-md);
}
.desktop-header.mobile .systemStatus {
	display:none;
}

<%-- user name and links --%>
.desktop-header-font {
	font-size: var(--zk-font-size-xs);
}

<%-- popup container for collapsed desktop header --%>
.desktop-header-popup {
	width: 800px;
	border-radius: var(--zk-radius-sm);
	border: none;
	right: var(--zk-space-2xs);
}
.desktop-header-popup, .desktop-header-popup > .z-window-content {
	background-color: var(--zk-color-primary-light);
}

.desktop-header-popup .desktop-header {
	border: none;
	height: 100% !important;
}

<%-- right panel for user name and links --%>
.desktop-user-panel {
	float: right;
	height: 45px;
	padding-right: var(--zk-space-lg);
}
.desktop-user-panel tr {
	vertical-align: middle;
}
.desktop-user-panel.mobile .desktop-header-font.desktop-header-username {
	font-weight: var(--zk-font-weight-semibold);
    white-space: nowrap;
}
.desktop-user-panel.mobile {
    height: auto;
}
.desktop-user-panel .z-toolbarbutton:hover {
	background: var(--zk-color-primary-lighter);
	color: var(--zk-text-color-hover);
}
.desktop-header-username {
	padding: 0px var(--zk-space-md);
}
.desktop-header-username:hover {
	background: var(--zk-color-primary-lighter);
	color: var(--zk-text-color-hover);
}

<%-- user panel popup for mobile client --%>
.user-panel-popup .z-popup-content {
	padding-left: 0px;
	padding-right: 0px;
}
.user-panel-popup .z-popup-content > .z-vlayout {
	overflow-x: auto;
	padding: var(--zk-space-xl);
}

<%-- main desktop layout (border layout) --%>
.desktop-layout {
	position: absolute; 
	border: none;
}
.desktop-north, .desktop-center {
	border: none;
}
.desktop-center {
	padding-top: var(--zk-space-2xs);
}
.desktop-center > .z-center-body {
	padding: 0px;
}

<%-- tabbox for application windows --%>
.desktop-tabbox {
	padding-top: 0px; 
	border: none;
}
@media screen and (max-width: 360px) {
	.desktop-tabbox .z-tab {
		max-width: 190px;
	}
}
.desktop-tabbox .z-tab .z-tab-text {
	padding-top: 0px;
	padding-bottom: 0px;
}
.desktop-tabbox > .z-tabpanels {
	flex-grow: 1 1 0;
}
.desktop-tabbox .z-tabs .z-toolbar-tabs-body {
	padding: 0px !important;
	margin: 0px !important;
}
.desktop-tabbox .z-tabs .z-toolbar-tabs-body .z-toolbarbutton {
	padding: 0px !important;
	border: 1px solid transparent !important;
	margin: 0px !important;
}
.desktop-tabbox .z-tabs .z-toolbar-tabs .z-toolbarbutton-hover {
	border: none !important;
	padding: 0px !important;
	margin: 0px !important;
}
.desktop-tabbox .z-tabs .z-toolbar-tabs .z-toolbarbutton-hover .z-toolbarbutton-content {
	background-image: none !important;
	background-color: var(--zk-color-neutral-350) !important;
	padding: 0px !important;
	margin: 0px !important;
	-webkit-box-shadow:inset 0px 0px 3px var(--zk-color-border-soft);
	-moz-box-shadow:inset 0px 0px 3px var(--zk-color-border-soft);	
	-o-box-shadow:inset 0px 0px 3px var(--zk-color-border-soft);	
	-ms-box-shadow:inset 0px 0px 3px var(--zk-color-border-soft);	
	box-shadow:inset 0px 0px 3px var(--zk-color-border-soft);
}
.desktop-tabbox.z-tabbox > .z-tabbox-icon.z-tabbox-left-scroll,
.desktop-tabbox.z-tabbox > .z-tabbox-icon.z-tabbox-right-scroll {
	line-height: var(--zk-line-height-xl);
}
.desktop-tabbox.z-tabbox  > .z-tabs > .z-tabs-content .z-tab-image {
	width: var(--zk-dimension-icon-md);
	height: var(--zk-dimension-icon-md);
}

.desktop-tabpanel {
	margin: 0;
	padding: 0;
	border: 0;
	position: relative !important;
}
.desktop-tabpanel > .z-window-embedded {
	border: none;
}
<%-- the home tab panel --%>
.desktop-home-tabpanel {
	width: 100% !important;
}
.desktop-home-tabpanel .z-hlayout-inner {
	padding: var(--zk-space-lg) !important;
}

<%-- left panel for side gadgets --%>
.desktop-left-column {
	width: var(--zk-dimension-panel-md);
	border: none;
	border-right: 1px solid var(--zk-color-border-strong);
	background-color: var(--zk-color-subtle-bg);
	padding-top: var(--zk-space-xs); 
}
.desktop-left-column + .z-west-splitter,  .desktop-left-column.z-west {
	border-top: none; 
	border-right: 1px solid transparent;
}
.desktop-left-column .z-west-body {
	border-right: none;
}

<%-- right panel for side gadgets --%>
.desktop-right-column {
	width: var(--zk-dimension-panel-md);
	border: none;
	border-left: 1px solid var(--zk-color-border-strong);
	background-color: var(--zk-color-subtle-bg);
	padding-top: var(--zk-space-xs); 
}
.desktop-right-column + .z-east-splitter,  .desktop-right-column.z-east {
	border-top: none; 
	border-left: 1px solid transparent;
}
.desktop-right-column .z-east-body {
	border-left: none;
}
.desktop-layout > div > .z-west-collapsed, .desktop-layout > div > .z-east-collapsed {
	border-top: none;
}
.desktop-left-column .z-anchorlayout, .desktop-right-column .z-anchorlayout {
	overflow-x: hidden;
}

<%-- dashboard layout --%>
.z-anchorlayout { overflow:auto }
.z-anchorchildren { overflow:visible }
.z-anchorchildren .z-hlayout {
	white-space: normal;
}

<%-- popup for application menu tree --%>
.desktop-menu-popup {
	z-index: 9999;
}
<%-- bottom toolbar of application menu tree popup --%>
.desktop-menu-toolbar {
	verticle-align: middle; 
	padding: var(--zk-space-xs);
	border-top: 1px solid var(--zk-color-border-strong);
}

<%-- desktop window container --%>
.window-container-toolbar-btn.z-toolbarbutton {
	width: 28px;
}
.window-container-toolbar-btn.z-toolbarbutton .z-toolbarbutton-content img {
	width: 22px;
	height: 22px;
	padding: var(--zk-space-sm) 3px;
}
.window-container-toolbar-btn.z-toolbarbutton .z-toolbarbutton-content [class^="z-icon"] {
	padding: var(--zk-space-sm) 3px;
	font-size: var(--zk-font-size-lg);
	color: var(--zk-color-icon-muted);
}
.window-container-toolbar > .z-toolbar-content,
.window-container-toolbar-btn.z-toolbarbutton, 
.window-container-toolbar-btn.z-toolbarbutton .z-toolbarbutton-content,
.window-container-toolbar-btn.z-toolbarbutton .z-toolbarbutton-content [class^="z-icon"] {
	display:inline-flex;
	align-items: center;
	justify-content: center;
	border-bottom: 0px; 
}
.window-container-toolbar-btn.tab-list.z-toolbarbutton {
	width: auto;	
	padding: var(--zk-space-xs) var(--zk-space-sm);
}
.window-container-toolbar-btn.tab-list.z-toolbarbutton > .z-toolbarbutton-content {
	font-size: var(--zk-font-size-base);
	padding-right: var(--zk-space-lg-plus);
}
.window-container-toolbar-btn.tab-list.z-toolbarbutton > .z-toolbarbutton-content > i {
	padding-right: 0px;
	margin-right: -4px;
	font-size: var(--zk-font-size-xl);
}

