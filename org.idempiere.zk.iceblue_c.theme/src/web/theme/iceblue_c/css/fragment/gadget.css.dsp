<%-- z-panel customization --%>
.z-panel-noborder {
	border: none !important;
}
.z-panelchildren {
	border: none;
	height: 100%;
}
.z-panel-head {
	padding-bottom: var(--zk-space-2xs);
	border: none;
}
.z-panel-head .z-panel-header {
	margin-top: var(--zk-space-xs);
	padding: var(--zk-space-2xs) var(--zk-space-lg) var(--zk-space-2xs) var(--zk-space-2xl);
    border-bottom: 1px solid var(--zk-color-neutral-425);
}
.z-caption .z-caption-content {
	cursor: move;
	padding: 0px;
}
.z-panel-icon {
	font-size: var(--zk-font-size-xs) !important;
    color: var(--zk-color-icon-muted) !important;
    margin: var(--zk-space-md) 0 0 0 !important;
    line-height: var(--zk-line-height-lg) !important;
    border: 0px !important;
    border-radius: 0px !important;
}
.z-panel-icon:hover {
    color: var(--zk-color-icon-muted) !important;
}

<%-- dashboard widget --%>
.dashboard-layout {
	width: 100%;
	height: 100%;
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
	border: 1px solid var(--zk-color-shadow-soft);
}
.dashboard-widget {
	margin-top: var(--zk-space-2xs); 
	margin-left: auto; 
	margin-right: auto;
	position: relative;
	width: 99%;	
	height: 100%;
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
	width: 100%;
	margin: auto;
	padding: var(--zk-space-2xs) 0px var(--zk-space-2xs) 0px;
}

.favourites-box .z-vbox {
	width: 100%;
}

.favourites-box .z-hbox {
	padding: 0px var(--zk-space-md);
	width: 100%; 
}

.favourites-box .z-toolbar-start {
	float: right;
}
.favourites-box .trash-font-icon {
	font-family: var(--zk-font-family-icon);
	font-size: var(--zk-font-size-2xl);
}
.fav-new-btn img {
	height: var(--zk-dimension-icon-md);
	width: var(--zk-dimension-icon-md);
}

<%-- recent items gadget --%>
.recentitems-box {
	width: 100%;
	margin: auto;
	padding: var(--zk-space-2xs) 0px var(--zk-space-2xs) 0px;
}

.recentitems-box .z-panelchildren {
	padding: 0px;
}

.recentitems-box .menu-href [class^="z-icon-"] {
	font-size: var(--zk-font-size-md) !important;
	color: var(--zk-text-color-default);
}

.recentitems-box A {
	display: block;
	padding: var(--zk-space-xs) var(--zk-space-4xl-minus) var(--zk-space-xs) var(--zk-space-4xl-plus);
 	line-height: var(--zk-line-height-lg);
	color: var(--zk-text-color-default) !important;
}
.recentitems-box A.menu-href:hover {
	background: var(--zk-color-primary-lighter);
	text-decoration: none !important;
}

.recentitems-box .z-toolbar-start {
	float: right;
}
.recentitems-box A.trash-toolbarbutton {
	display: inline-block;
	padding: var(--zk-space-xs) 11px;
	border: none;
}
.recentitems-box .z-toolbar .z-toolbar-content {
	display: inline-flex;
	align-items: center;
}
.recentitems-box .trash-font-icon {
	font-family: var(--zk-font-family-icon);
	font-size: var(--zk-font-size-md);
}

<%-- embedded report content --%>
.dashboard-report-iframe {
	min-height:var(--zk-dimension-panel-lg); 
	border: 1px solid lightgray; 
	margin:auto;
	width: 99%;
}
.dashboard-report-toolbar .z-toolbar-content {
	display: block;
}
.dashboard-report-toolbar .rowcount-label {
	float: right;
	padding: var(--zk-space-lg);
}
.fill-mandatory-process-para-wrapper {
    padding: 11px;
    display: flex;
    flex-direction: column;
    max-width: 500px;
}

.fill-mandatory-process-para-text {
    background: var(--zk-color-danger-hover);
    color: var(--zk-color-surface);
    padding: var(--zk-space-2xl);
    border-radius: var(--zk-radius-lg);
    opacity: 90%;
}

<%-- views gadget --%>	
.views-box {
	width: 100%;
	margin: auto;
	padding: var(--zk-space-xs) 0px var(--zk-space-xs) 0px;
}
.views-box .z-vbox {
	width: 100%;
}
.views-box .z-toolbarbutton {
	width: 100%;
	padding: var(--zk-space-md) var(--zk-space-4xl-minus);
	line-height: var(--zk-line-height-lg);
}
.views-box .z-toolbarbutton:hover {
	background: var(--zk-color-primary-lighter);
	color: var(--zk-text-color-hover);
}
.views-box .link img {
	height: var(--zk-dimension-icon-md);
	width: var(--zk-dimension-icon-md);
}
.views-box .z-toolbarbutton [class^="z-icon"] {
	text-align: center;
}
.views-box .z-toolbarbutton [class^="z-icon"]:before {
	width: var(--zk-dimension-icon-md);
	display: inline-block;
}
.views-box .z-toolbarbutton .z-toolbarbutton-content {
	justify-content: left;
}

<%-- activities gadget --%>
.activities-box {
	width: 100%;
	margin: auto;
	padding: 0px var(--zk-space-4xl-minus);
	cursor: pointer;
}
.activities-box .z-vbox {
	width: 100%;
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
	margin: 0px;
}
.window-view-pi .performance-indicator img {
}
.performance-indicator-box {
	background-color: var(--zk-color-neutral-200); 
	border: 1px solid var(--zk-color-neutral-400); 
	border-radius: 3px; 
	cursor: pointer;
}
.performance-indicator-title {
	text-align: center; 
	background-color: var(--zk-color-neutral-350); 
	border: 1px solid var(--zk-color-neutral-350);
	padding-top: var(--zk-space-md); 
	padding-bottom: var(--zk-space-md);
	min-height: 48px;
	width: 100%;
	display: flex;  
	justify-content: center;
	align-items: center;
}
.performance-panel .z-grid {
	border: none;
	margin:0px; 
	padding:0px; 
	position: relative;
	width: 100%;
}
.gauge-indicator-title {
	text-align: center;
	padding-top: var(--zk-space-2xs); 
	padding-bottom: var(--zk-space-2xs);
	line-height: var(--zk-line-height-xs);
}
.performance-gadget {
	display: flex;
 	justify-content: center;
 	align-items: center;
	cursor: pointer;
}
.performance-gadget > .z-div {
	width: 100%;	
}

@media screen and (min-width: 768px) {
	.dashboard-row .chart-gadget {
		max-height: var(--zk-dimension-panel-lg); 
	}
}

@media screen and (max-width: 767px) {
	.dashboard-row .chart-gadget {
		max-height: var(--zk-dimension-panel-sm); 
	}
}

<%-- chart gadget --%>
.dashboard-widget.dashboard-widget-max .chart-gadget {
	height: 100% !important; 
}
.chart-gadget {
	text-align: center !important;
}

<%-- status line gadget --%>
.statusline-wrapper {
	height: 100%;
}
.statusline-gadget {
	display: flex;
	flex-direction: column;
 	justify-content: center;
 	align-items: center;
 	height: 100%;
 	padding: var(--zk-space-2xl) 0px;
}

<%-- help gadget --%>
.help-content
{
	padding: var(--zk-space-lg);
	font-size: var(--zk-font-size-md);
	font-weight: var(--zk-font-weight-normal);
	line-height: 1.3em;
}
.help-content p {
	margin-bottom: var(--zk-space-xl-minus);
}
.mobile .help-content
{
	font-size: var(--zk-font-size-base);
}

<%-- User Favorite Dashboard Panel Start --%>
.fav-tree-panel .z-panelchildren {
  padding: 0px;
  color: var(--zk-text-color-default) !important;
}
.fav-tree-panel .z-treerow .z-treecell {
  border-top: 0px;
}
.fav-toolbar-div {
  position: relative;
  width: 100%;
}
.fav-tree-btn {
  margin-left: var(--zk-space-lg) !important;
  padding: var(--zk-space-sm) var(--zk-space-4xl);
  border: 1px solid var(--zk-color-border-control);
}
.fav-folder-textbox {
  width: 100%;
}
.fav-expand-mode {
  transform: rotate(180deg);
}
.fav-mobile-ctx-menu {
  margin: 0px var(--zk-space-lg);
  padding: 0px var(--zk-space-lg);
  vertical-align: middle;
}
<%-- favourites new button --%>
.new-toolbarbutton.z-toolbarbutton {
	padding: var(--zk-space-xs) var(--zk-space-lg);
}

<%-- help icon and popup for gadget --%>
.dashboard-content-help-icon {
	padding: var(--zk-space-lg);
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
	background: var(--zk-text-color-strong);
	color: var(--zk-color-surface);
	border-radius: var(--zk-radius-lg);
	padding: var(--zk-space-md) var(--zk-space-xl-minus);
    position: fixed;
    z-index: 1800;
    max-width: var(--zk-dimension-panel-lg);
}
.dashboard-content-help .z-popup-content {
	background: var(--zk-text-color-strong);
	color: var(--zk-color-surface);
	border-radius: var(--zk-radius-lg);
}
.dashboard-widget .z-toolbar {
    padding: var(--zk-space-lg-plus) var(--zk-space-3xl-plus) 0px 13px;
}
.dashboard-widget .z-row-content {
	padding: var(--zk-space-2xs) var(--zk-space-lg);
}

.dashboard-widget .z-row-inner {
	border-top: none;
}
