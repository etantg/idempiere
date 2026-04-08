<%@ taglib uri="http://www.idempiere.org/dsp/web/util" prefix="u" %>

:root {
	--zk-desktop-border-none: var(--zk-border-none);
	--zk-desktop-color-border-soft: var(--zk-color-border-soft);
	--zk-desktop-color-border-strong: var(--zk-color-border-strong);
	--zk-desktop-color-header-border: var(--zk-color-header-border);
	--zk-desktop-color-icon-muted: var(--zk-color-icon-muted);
	--zk-desktop-color-neutral-350: var(--zk-color-neutral-350);
	--zk-desktop-color-primary-light: var(--zk-color-primary-light);
	--zk-desktop-color-primary-lighter: var(--zk-color-primary-lighter);
	--zk-desktop-color-subtle-bg: var(--zk-color-subtle-bg);
	--zk-desktop-color-transparent: var(--zk-color-transparent);
	--zk-desktop-dimension-icon-md: var(--zk-dimension-icon-md);
	--zk-desktop-dimension-panel-md: var(--zk-dimension-panel-md);
	--zk-desktop-font-size-base: var(--zk-font-size-base);
	--zk-desktop-font-size-lg: var(--zk-font-size-lg);
	--zk-desktop-font-size-xl: var(--zk-font-size-xl);
	--zk-desktop-font-size-xs: var(--zk-font-size-xs);
	--zk-desktop-font-weight-semibold: var(--zk-font-weight-semibold);
	--zk-desktop-line-height-xl: var(--zk-line-height-xl);
	--zk-desktop-radius-sm: var(--zk-radius-sm);
	--zk-desktop-size-0: var(--zk-size-0);
	--zk-desktop-size-1: var(--zk-size-1);
	--zk-desktop-size-190: var(--zk-size-190);
	--zk-desktop-size-22: var(--zk-size-22);
	--zk-desktop-size-28: var(--zk-size-28);
	--zk-desktop-size-3: var(--zk-size-3);
	--zk-desktop-size-36: var(--zk-size-36);
	--zk-desktop-size-45: var(--zk-size-45);
	--zk-desktop-size-46: var(--zk-size-46);
	--zk-desktop-size-800: var(--zk-size-800);
	--zk-desktop-size-full: var(--zk-size-full);
	--zk-desktop-size-neg-4: var(--zk-size-neg-4);
	--zk-desktop-space-0: var(--zk-space-0);
	--zk-desktop-space-2xs: var(--zk-space-2xs);
	--zk-desktop-space-lg: var(--zk-space-lg);
	--zk-desktop-space-lg-plus: var(--zk-space-lg-plus);
	--zk-desktop-space-md: var(--zk-space-md);
	--zk-desktop-space-sm: var(--zk-space-sm);
	--zk-desktop-space-xl: var(--zk-space-xl);
	--zk-desktop-space-xs: var(--zk-space-xs);
	--zk-desktop-text-color-hover: var(--zk-text-color-hover);
}

<%-- header --%>
.desktop-north {
	background-color: var(--zk-desktop-color-primary-light);
	border-bottom: var(--zk-desktop-size-1) solid var(--zk-desktop-color-header-border) !important;
}
<%-- left panel for logo and global search --%>
.desktop-header-left {
	margin: var(--zk-desktop-space-0);
	margin-left: var(--zk-desktop-space-2xs);
	margin-top: var(--zk-desktop-space-2xs);
	background-color: var(--zk-desktop-color-transparent) !important; 
	border: var(--zk-desktop-border-none) !important;
}

.desktop-header {
	background-color: ${u:sysConfig("ZK_DESKTOP_HEADER_BACKGROUND_COLOR", "var(--zk-desktop-color-primary-light)")}; <%-- SysConfig with default to var(--zk-desktop-color-primary-light) --%>
	width: var(--zk-desktop-size-full);
	height: var(--zk-desktop-size-46);
	padding-left: var(--zk-desktop-space-md);
}

.desktop-header.mobile {
	height: var(--zk-desktop-size-36);
	padding: var(--zk-desktop-space-md) var(--zk-desktop-space-md);
}
.desktop-header.mobile .systemStatus {
	display:none;
}

<%-- user name and links --%>
.desktop-header-font {
	font-size: var(--zk-desktop-font-size-xs);
}

<%-- popup container for collapsed desktop header --%>
.desktop-header-popup {
	width: var(--zk-desktop-size-800);
	border-radius: var(--zk-desktop-radius-sm);
	border: var(--zk-desktop-border-none);
	right: var(--zk-desktop-space-2xs);
}
.desktop-header-popup, .desktop-header-popup > .z-window-content {
	background-color: var(--zk-desktop-color-primary-light);
}

.desktop-header-popup .desktop-header {
	border: var(--zk-desktop-border-none);
	height: var(--zk-desktop-size-full) !important;
}

<%-- right panel for user name and links --%>
.desktop-user-panel {
	float: right;
	height: var(--zk-desktop-size-45);
	padding-right: var(--zk-desktop-space-lg);
}
.desktop-user-panel tr {
	vertical-align: middle;
}
.desktop-user-panel.mobile .desktop-header-font.desktop-header-username {
	font-weight: var(--zk-desktop-font-weight-semibold);
	white-space: nowrap;
}
.desktop-user-panel.mobile {
    height: auto;
}
.desktop-user-panel .z-toolbarbutton:hover {
	background: var(--zk-desktop-color-primary-lighter);
	color: var(--zk-desktop-text-color-hover);
}
.desktop-header-username {
	padding: var(--zk-desktop-space-0) var(--zk-desktop-space-md);
}
.desktop-header-username:hover {
	background: var(--zk-desktop-color-primary-lighter);
	color: var(--zk-desktop-text-color-hover);
}

<%-- user panel popup for mobile client --%>
.user-panel-popup .z-popup-content {
	padding-left: var(--zk-desktop-space-0);
	padding-right: var(--zk-desktop-space-0);
}
.user-panel-popup .z-popup-content > .z-vlayout {
	overflow-x: auto;
	padding: var(--zk-desktop-space-xl);
}

<%-- main desktop layout (border layout) --%>
.desktop-layout {
	position: absolute; 
	border: var(--zk-desktop-border-none);
}
.desktop-north, .desktop-center {
	border: var(--zk-desktop-border-none);
}
.desktop-center {
	padding-top: var(--zk-desktop-space-2xs);
}
.desktop-center > .z-center-body {
	padding: var(--zk-desktop-space-0);
}

<%-- tabbox for application windows --%>
.desktop-tabbox {
	padding-top: var(--zk-desktop-space-0); 
	border: var(--zk-desktop-border-none);
}
@media screen and (max-width: 360px) {
	.desktop-tabbox .z-tab {
		max-width: var(--zk-desktop-size-190);
	}
}
.desktop-tabbox .z-tab .z-tab-text {
	padding-top: var(--zk-desktop-space-0);
	padding-bottom: var(--zk-desktop-space-0);
}
.desktop-tabbox > .z-tabpanels {
	flex-grow: 1 1 0;
}
.desktop-tabbox .z-tabs .z-toolbar-tabs-body {
	padding: var(--zk-desktop-space-0) !important;
	margin: var(--zk-desktop-space-0) !important;
}
.desktop-tabbox .z-tabs .z-toolbar-tabs-body .z-toolbarbutton {
	padding: var(--zk-desktop-space-0) !important;
	border: var(--zk-desktop-size-1) solid transparent !important;
	margin: var(--zk-desktop-space-0) !important;
}
.desktop-tabbox .z-tabs .z-toolbar-tabs .z-toolbarbutton-hover {
	border: var(--zk-desktop-border-none) !important;
	padding: var(--zk-desktop-space-0) !important;
	margin: var(--zk-desktop-space-0) !important;
}
.desktop-tabbox .z-tabs .z-toolbar-tabs .z-toolbarbutton-hover .z-toolbarbutton-content {
	background-image: none !important;
	background-color: var(--zk-desktop-color-neutral-350) !important;
	padding: var(--zk-desktop-space-0) !important;
	margin: var(--zk-desktop-space-0) !important;
	-webkit-box-shadow:inset var(--zk-desktop-size-0) var(--zk-desktop-size-0) var(--zk-desktop-size-3) var(--zk-desktop-color-border-soft);
	-moz-box-shadow:inset var(--zk-desktop-size-0) var(--zk-desktop-size-0) var(--zk-desktop-size-3) var(--zk-desktop-color-border-soft);	
	-o-box-shadow:inset var(--zk-desktop-size-0) var(--zk-desktop-size-0) var(--zk-desktop-size-3) var(--zk-desktop-color-border-soft);	
	-ms-box-shadow:inset var(--zk-desktop-size-0) var(--zk-desktop-size-0) var(--zk-desktop-size-3) var(--zk-desktop-color-border-soft);	
	box-shadow:inset var(--zk-desktop-size-0) var(--zk-desktop-size-0) var(--zk-desktop-size-3) var(--zk-desktop-color-border-soft);
}
.desktop-tabbox.z-tabbox > .z-tabbox-icon.z-tabbox-left-scroll,
.desktop-tabbox.z-tabbox > .z-tabbox-icon.z-tabbox-right-scroll {
	line-height: var(--zk-desktop-line-height-xl);
}
.desktop-tabbox.z-tabbox  > .z-tabs > .z-tabs-content .z-tab-image {
	width: var(--zk-desktop-dimension-icon-md);
	height: var(--zk-desktop-dimension-icon-md);
}

.desktop-tabpanel {
	margin: var(--zk-desktop-space-0);
	padding: var(--zk-desktop-space-0);
	border: var(--zk-desktop-size-0);
	position: relative !important;
}
.desktop-tabpanel > .z-window-embedded {
	border: var(--zk-desktop-border-none);
}
<%-- the home tab panel --%>
.desktop-home-tabpanel {
	width: var(--zk-desktop-size-full) !important;
}
.desktop-home-tabpanel .z-hlayout-inner {
	padding: var(--zk-desktop-space-lg) !important;
}

<%-- left panel for side gadgets --%>
.desktop-left-column {
	width: var(--zk-desktop-dimension-panel-md);
	border: var(--zk-desktop-border-none);
	border-right: var(--zk-desktop-size-1) solid var(--zk-desktop-color-border-strong);
	background-color: var(--zk-desktop-color-subtle-bg);
	padding-top: var(--zk-desktop-space-xs); 
}
.desktop-left-column + .z-west-splitter,  .desktop-left-column.z-west {
	border-top: none; 
	border-right: var(--zk-desktop-size-1) solid transparent;
}
.desktop-left-column .z-west-body {
	border-right: none;
}

<%-- right panel for side gadgets --%>
.desktop-right-column {
	width: var(--zk-desktop-dimension-panel-md);
	border: var(--zk-desktop-border-none);
	border-left: var(--zk-desktop-size-1) solid var(--zk-desktop-color-border-strong);
	background-color: var(--zk-desktop-color-subtle-bg);
	padding-top: var(--zk-desktop-space-xs); 
}
.desktop-right-column + .z-east-splitter,  .desktop-right-column.z-east {
	border-top: none; 
	border-left: var(--zk-desktop-size-1) solid transparent;
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
	padding: var(--zk-desktop-space-xs);
	border-top: var(--zk-desktop-size-1) solid var(--zk-desktop-color-border-strong);
}

<%-- desktop window container --%>
.window-container-toolbar-btn.z-toolbarbutton {
	width: var(--zk-desktop-size-28);
}
.window-container-toolbar-btn.z-toolbarbutton .z-toolbarbutton-content img {
	width: var(--zk-desktop-size-22);
	height: var(--zk-desktop-size-22);
	padding: var(--zk-desktop-space-sm) var(--zk-desktop-size-3);
}
.window-container-toolbar-btn.z-toolbarbutton .z-toolbarbutton-content [class^="z-icon"] {
	padding: var(--zk-desktop-space-sm) var(--zk-desktop-size-3);
	font-size: var(--zk-desktop-font-size-lg);
	color: var(--zk-desktop-color-icon-muted);
}
.window-container-toolbar > .z-toolbar-content,
.window-container-toolbar-btn.z-toolbarbutton, 
.window-container-toolbar-btn.z-toolbarbutton .z-toolbarbutton-content,
.window-container-toolbar-btn.z-toolbarbutton .z-toolbarbutton-content [class^="z-icon"] {
	display:inline-flex;
	align-items: center;
	justify-content: center;
	border-bottom: var(--zk-desktop-size-0); 
}
.window-container-toolbar-btn.tab-list.z-toolbarbutton {
	width: auto;	
	padding: var(--zk-desktop-space-xs) var(--zk-desktop-space-sm);
}
.window-container-toolbar-btn.tab-list.z-toolbarbutton > .z-toolbarbutton-content {
	font-size: var(--zk-desktop-font-size-base);
	padding-right: var(--zk-desktop-space-lg-plus);
}
.window-container-toolbar-btn.tab-list.z-toolbarbutton > .z-toolbarbutton-content > i {
	padding-right: var(--zk-desktop-space-0);
	margin-right: var(--zk-desktop-size-neg-4);
	font-size: var(--zk-desktop-font-size-xl);
}

