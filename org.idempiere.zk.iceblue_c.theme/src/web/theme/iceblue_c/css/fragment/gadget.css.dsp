:root {
	--zk-gadget-border-none: var(--zk-border-none);
	--zk-gadget-size-500: var(--zk-size-500);
	--zk-gadget-color-border-button: var(--zk-color-border-button);
	--zk-gadget-color-danger-brand: var(--zk-color-danger-brand);
	--zk-gadget-color-icon-muted: var(--zk-color-icon-muted);
	--zk-gadget-color-keyword-lightgray: var(--zk-color-keyword-lightgray);
	--zk-gadget-color-neutral-200: var(--zk-color-neutral-200);
	--zk-gadget-color-neutral-300: var(--zk-color-neutral-300);
	--zk-gadget-color-neutral-375: var(--zk-color-neutral-375);
	--zk-gadget-color-neutral-425: var(--zk-color-neutral-425);
	--zk-gadget-color-primary-lighter: var(--zk-color-primary-lighter);
	--zk-gadget-color-shadow-soft: var(--zk-color-shadow-soft);
	--zk-gadget-color-surface: var(--zk-color-surface);
	--zk-gadget-dimension-icon-md: var(--zk-dimension-icon-md);
	--zk-gadget-dimension-panel-lg: var(--zk-dimension-panel-lg);
	--zk-gadget-dimension-panel-sm: var(--zk-dimension-panel-sm);
	--zk-gadget-font-family-icon: var(--zk-font-family-icon);
	--zk-gadget-font-size-2xl: var(--zk-font-size-2xl);
	--zk-gadget-font-size-base: var(--zk-font-size-base);
	--zk-gadget-font-size-md: var(--zk-font-size-md);
	--zk-gadget-font-size-xs: var(--zk-font-size-xs);
	--zk-gadget-font-weight-normal: var(--zk-font-weight-normal);
	--zk-gadget-line-height-lg: var(--zk-line-height-lg);
	--zk-gadget-line-height-xs: var(--zk-line-height-xs);
	--zk-gadget-radius-lg: var(--zk-radius-lg);
	--zk-gadget-radius-none: var(--zk-radius-none);
	--zk-gadget-size-0: var(--zk-size-0);
	--zk-gadget-size-1: var(--zk-size-1);
	--zk-gadget-size-11: var(--zk-size-11);
	--zk-gadget-size-13: var(--zk-size-13);
	--zk-gadget-size-1-3em: var(--zk-size-1-3em);
	--zk-gadget-size-3: var(--zk-size-3);
	--zk-gadget-size-48: var(--zk-size-48);
	--zk-gadget-size-90pct: var(--zk-size-90pct);
	--zk-gadget-size-99pct: var(--zk-size-99pct);
	--zk-gadget-size-full: var(--zk-size-full);
	--zk-gadget-space-0: var(--zk-space-0);
	--zk-gadget-space-2xl: var(--zk-space-2xl);
	--zk-gadget-space-2xs: var(--zk-space-2xs);
	--zk-gadget-space-3xl-plus: var(--zk-space-3xl-plus);
	--zk-gadget-space-4xl: var(--zk-space-4xl);
	--zk-gadget-space-4xl-minus: var(--zk-space-4xl-minus);
	--zk-gadget-space-4xl-plus: var(--zk-space-4xl-plus);
	--zk-gadget-space-lg: var(--zk-space-lg);
	--zk-gadget-space-lg-plus: var(--zk-space-lg-plus);
	--zk-gadget-space-md: var(--zk-space-md);
	--zk-gadget-space-sm: var(--zk-space-sm);
	--zk-gadget-space-xl-minus: var(--zk-space-xl-minus);
	--zk-gadget-space-xs: var(--zk-space-xs);
	--zk-gadget-text-color-default: var(--zk-text-color-default);
	--zk-gadget-text-color-hover: var(--zk-text-color-hover);
	--zk-gadget-text-color-strong: var(--zk-text-color-strong);
	--zk-gadget-text-decoration-none: var(--zk-text-decoration-none);
}

<%-- z-panel customization --%>
.z-panel-noborder {
	border: var(--zk-gadget-border-none) !important;
}
.z-panelchildren {
	border: var(--zk-gadget-border-none);
	height: var(--zk-gadget-size-full);
}
.z-panel-head {
	padding-bottom: var(--zk-gadget-space-2xs);
	border: var(--zk-gadget-border-none);
}
.z-panel-head .z-panel-header {
	margin-top: var(--zk-gadget-space-xs);
	padding: var(--zk-gadget-space-2xs) var(--zk-gadget-space-lg) var(--zk-gadget-space-2xs) var(--zk-gadget-space-2xl);
    border-bottom: var(--zk-gadget-size-1) solid var(--zk-gadget-color-neutral-425);
}
.z-caption .z-caption-content {
	cursor: move;
	padding: var(--zk-gadget-space-0);
}
.z-panel-icon {
	font-size: var(--zk-gadget-font-size-xs) !important;
    color: var(--zk-gadget-color-icon-muted) !important;
    margin: var(--zk-gadget-space-md) 0 0 0 !important;
    line-height: var(--zk-gadget-line-height-lg) !important;
    border: var(--zk-gadget-size-0) !important;
    border-radius: var(--zk-gadget-radius-none) !important;
}
.z-panel-icon:hover {
    color: var(--zk-gadget-color-icon-muted) !important;
}

<%-- dashboard widget --%>
.dashboard-layout {
	width: var(--zk-gadget-size-full);
	height: var(--zk-gadget-size-full);
	position: relative;
}

.dashboard-widget.z-panel {
	display: flex; 
	flex-direction: column; 
	justify-content: stretch;
}
.dashboard-widget > .z-panel-body {
	flex-grow: 1;
}
.dashboard-widget.z-panel {
	border: var(--zk-gadget-size-1) solid var(--zk-gadget-color-shadow-soft);
}
.dashboard-widget {
	margin-top: var(--zk-gadget-space-2xs); 
	margin-left: auto; 
	margin-right: auto;
	position: relative;
	width: var(--zk-gadget-size-99pct);	
	height: var(--zk-gadget-size-full);
}
.dashboard-widget-max {
	margin: auto;
	width: auto;	
}
.dashboard-widget.dashboard-widget-max > .z-panel-body > .z-panelchildren {
	overflow: auto;
}

<%-- favourites gadget --%>
.favourites-box {
	width: var(--zk-gadget-size-full);
	margin: auto;
	padding: var(--zk-gadget-space-2xs) var(--zk-gadget-space-0) var(--zk-gadget-space-2xs) var(--zk-gadget-size-0);
}

.favourites-box .z-vbox {
	width: var(--zk-gadget-size-full);
}

.favourites-box .z-hbox {
	padding: var(--zk-gadget-space-0) var(--zk-gadget-space-md);
	width: var(--zk-gadget-size-full); 
}

.favourites-box .z-toolbar-start {
	float: right;
}
.favourites-box .trash-font-icon {
	font-family: var(--zk-gadget-font-family-icon);
	font-size: var(--zk-gadget-font-size-2xl);
}
.fav-new-btn img {
	height: var(--zk-gadget-dimension-icon-md);
	width: var(--zk-gadget-dimension-icon-md);
}

<%-- recent items gadget --%>
.recentitems-box {
	width: var(--zk-gadget-size-full);
	margin: auto;
	padding: var(--zk-gadget-space-2xs) var(--zk-gadget-space-0) var(--zk-gadget-space-2xs) var(--zk-gadget-size-0);
}

.recentitems-box .z-panelchildren {
	padding: var(--zk-gadget-space-0);
}

.recentitems-box .menu-href [class^="z-icon-"] {
	font-size: var(--zk-gadget-font-size-md) !important;
	color: var(--zk-gadget-text-color-default);
}

.recentitems-box A {
	display: block;
	padding: var(--zk-gadget-space-xs) var(--zk-gadget-space-4xl-minus) var(--zk-gadget-space-xs) var(--zk-gadget-space-4xl-plus);
 	line-height: var(--zk-gadget-line-height-lg);
	color: var(--zk-gadget-text-color-default) !important;
}
.recentitems-box A.menu-href:hover {
	background: var(--zk-gadget-color-primary-lighter);
	text-decoration: var(--zk-gadget-text-decoration-none) !important;
}

.recentitems-box .z-toolbar-start {
	float: right;
}
.recentitems-box A.trash-toolbarbutton {
	display: inline-block;
	padding: var(--zk-gadget-space-xs) var(--zk-gadget-size-11);
	border: var(--zk-gadget-border-none);
}
.recentitems-box .z-toolbar .z-toolbar-content {
	display: inline-flex;
	align-items: center;
}
.recentitems-box .trash-font-icon {
	font-family: var(--zk-gadget-font-family-icon);
	font-size: var(--zk-gadget-font-size-md);
}

<%-- embedded report content --%>
.dashboard-report-iframe {
	min-height:var(--zk-gadget-dimension-panel-lg); 
	border: var(--zk-gadget-size-1) solid var(--zk-gadget-color-keyword-lightgray); 
	margin:auto;
	width: var(--zk-gadget-size-99pct);
}
.dashboard-report-toolbar .z-toolbar-content {
	display: block;
}
.dashboard-report-toolbar .rowcount-label {
	float: right;
	padding: var(--zk-gadget-space-lg);
}
.fill-mandatory-process-para-wrapper {
    padding: var(--zk-gadget-size-11);
    display: flex;
    flex-direction: column;
    max-width: var(--zk-gadget-size-500);
}

.fill-mandatory-process-para-text {
    background: var(--zk-gadget-color-danger-brand);
    color: var(--zk-gadget-color-surface);
    padding: var(--zk-gadget-space-2xl);
    border-radius: var(--zk-gadget-radius-lg);
    opacity: var(--zk-gadget-size-90pct);
}

<%-- views gadget --%>	
.views-box {
	width: var(--zk-gadget-size-full);
	margin: auto;
	padding: var(--zk-gadget-space-xs) var(--zk-gadget-space-0) var(--zk-gadget-space-xs) var(--zk-gadget-size-0);
}
.views-box .z-vbox {
	width: var(--zk-gadget-size-full);
}
.views-box .z-toolbarbutton {
	width: var(--zk-gadget-size-full);
	padding: var(--zk-gadget-space-md) var(--zk-gadget-space-4xl-minus);
	line-height: var(--zk-gadget-line-height-lg);
}
.views-box .z-toolbarbutton:hover {
	background: var(--zk-gadget-color-primary-lighter);
	color: var(--zk-gadget-text-color-hover);
}
.views-box .link img {
	height: var(--zk-gadget-dimension-icon-md);
	width: var(--zk-gadget-dimension-icon-md);
}
.views-box .z-toolbarbutton [class^="z-icon"] {
	text-align: center;
}
.views-box .z-toolbarbutton [class^="z-icon"]:before {
	width: var(--zk-gadget-dimension-icon-md);
	display: inline-block;
}
.views-box .z-toolbarbutton .z-toolbarbutton-content {
	justify-content: left;
}

<%-- activities gadget --%>
.activities-box {
	width: var(--zk-gadget-size-full);
	margin: auto;
	padding: var(--zk-gadget-space-0) var(--zk-gadget-space-4xl-minus);
	cursor: pointer;
}
.activities-box .z-vbox {
	width: var(--zk-gadget-size-full);
}
.activities-box .z-button {
	text-align: left;
}

<%-- performance indicator --%>
.performance-indicator {
	margin: auto;
	position: relative; 
}
.performance-indicator img {
	display: block; 
	margin: var(--zk-gadget-space-0);
}
.window-view-pi .performance-indicator img {
}
.performance-indicator-box {
	background-color: var(--zk-gadget-color-neutral-200); 
	border: var(--zk-gadget-size-1) solid var(--zk-gadget-color-neutral-375); 
	border-radius: var(--zk-gadget-size-3); 
	cursor: pointer;
}
.performance-indicator-title {
	text-align: center; 
	background-color: var(--zk-gadget-color-neutral-300); 
	border: var(--zk-gadget-size-1) solid var(--zk-gadget-color-neutral-300);
	padding-top: var(--zk-gadget-space-md); 
	padding-bottom: var(--zk-gadget-space-md);
	min-height: var(--zk-gadget-size-48);
	width: var(--zk-gadget-size-full);
	display: flex;  
	justify-content: center;
	align-items: center;
}
.performance-panel .z-grid {
	border: var(--zk-gadget-border-none);
	margin:var(--zk-gadget-space-0); 
	padding:var(--zk-gadget-space-0); 
	position: relative;
	width: var(--zk-gadget-size-full);
}
.gauge-indicator-title {
	text-align: center;
	padding-top: var(--zk-gadget-space-2xs); 
	padding-bottom: var(--zk-gadget-space-2xs);
	line-height: var(--zk-gadget-line-height-xs);
}
.performance-gadget {
	display: flex;
 	justify-content: center;
 	align-items: center;
	cursor: pointer;
}
.performance-gadget > .z-div {
	width: var(--zk-gadget-size-full);	
}

@media screen and (min-width: 768px) {
	.dashboard-row .chart-gadget {
		max-height: var(--zk-gadget-dimension-panel-lg); 
	}
}

@media screen and (max-width: 767px) {
	.dashboard-row .chart-gadget {
		max-height: var(--zk-gadget-dimension-panel-sm); 
	}
}

<%-- chart gadget --%>
.dashboard-widget.dashboard-widget-max .chart-gadget {
	height: var(--zk-gadget-size-full) !important; 
}
.chart-gadget {
	text-align: center !important;
}

<%-- status line gadget --%>
.statusline-wrapper {
	height: var(--zk-gadget-size-full);
}
.statusline-gadget {
	display: flex;
	flex-direction: column;
 	justify-content: center;
 	align-items: center;
 	height: var(--zk-gadget-size-full);
 	padding: var(--zk-gadget-space-2xl) var(--zk-gadget-space-0);
}

<%-- help gadget --%>
.help-content
{
	padding: var(--zk-gadget-space-lg);
	font-size: var(--zk-gadget-font-size-md);
	font-weight: var(--zk-gadget-font-weight-normal);
	line-height: var(--zk-gadget-size-1-3em);
}
.help-content p {
	margin-bottom: var(--zk-gadget-space-xl-minus);
}
.mobile .help-content
{
	font-size: var(--zk-gadget-font-size-base);
}

<%-- User Favorite Dashboard Panel Start --%>
.fav-tree-panel .z-panelchildren {
  padding: var(--zk-gadget-space-0);
  color: var(--zk-gadget-text-color-default) !important;
}
.fav-tree-panel .z-treerow .z-treecell {
  border-top: var(--zk-gadget-size-0);
}
.fav-toolbar-div {
  position: relative;
  width: var(--zk-gadget-size-full);
}
.fav-tree-btn {
  margin-left: var(--zk-gadget-space-lg) !important;
  padding: var(--zk-gadget-space-sm) var(--zk-gadget-space-4xl);
  border: var(--zk-gadget-size-1) solid var(--zk-gadget-color-border-button);
}
.fav-folder-textbox {
  width: var(--zk-gadget-size-full);
}
.fav-expand-mode {
  transform: rotate(180deg);
}
.fav-mobile-ctx-menu {
  margin: var(--zk-gadget-space-0) var(--zk-gadget-space-lg);
  padding: var(--zk-gadget-space-0) var(--zk-gadget-space-lg);
  vertical-align: middle;
}
<%-- favourites new button --%>
.new-toolbarbutton.z-toolbarbutton {
	padding: var(--zk-gadget-space-xs) var(--zk-gadget-space-lg);
}

<%-- help icon and popup for gadget --%>
.dashboard-content-help-icon {
	padding: var(--zk-gadget-space-lg);
	cursor: default;
	visibility: hidden;
}
.z-caption:hover .dashboard-content-help-icon {
	visibility: visible;
}
.dashboard-content-help-popup {
	display: none;
}
.dashboard-content-help-icon:hover ~ .dashboard-content-help-popup {
	display: inline-flex;
	background: var(--zk-gadget-text-color-strong);
	color: var(--zk-gadget-color-surface);
	border-radius: var(--zk-gadget-radius-lg);
	padding: var(--zk-gadget-space-md) var(--zk-gadget-space-xl-minus);
    position: fixed;
    z-index: 1800;
    max-width: var(--zk-gadget-dimension-panel-lg);
}
.dashboard-content-help .z-popup-content {
	background: var(--zk-gadget-text-color-strong);
	color: var(--zk-gadget-color-surface);
	border-radius: var(--zk-gadget-radius-lg);
}
.dashboard-widget .z-toolbar {
    padding: var(--zk-gadget-space-lg-plus) var(--zk-gadget-space-3xl-plus) var(--zk-gadget-space-0) var(--zk-gadget-size-13);
}
.dashboard-widget .z-row-content {
	padding: var(--zk-gadget-space-2xs) var(--zk-gadget-space-lg);
}

.dashboard-widget .z-row-inner {
	border-top: none;
}
