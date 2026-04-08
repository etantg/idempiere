<%@ taglib uri="http://www.zkoss.org/dsp/web/core" prefix="c" %>
<%@ taglib uri="http://www.idempiere.org/dsp/web/util" prefix="u" %>

:root {
	--zk-adwindow-border-none: var(--zk-border-none);
	--zk-adwindow-color-border-card: var(--zk-color-border-card);
	--zk-adwindow-color-border-strong: var(--zk-color-border-strong);
	--zk-adwindow-color-keyword-red: var(--zk-color-keyword-red);
	--zk-adwindow-color-neutral-350: var(--zk-color-neutral-350);
	--zk-adwindow-color-subtle-bg: var(--zk-color-subtle-bg);
	--zk-adwindow-color-surface: var(--zk-color-surface);
	--zk-adwindow-color-transparent: var(--zk-color-transparent);
	--zk-adwindow-color-tree-arrow: var(--zk-color-tree-arrow);
	--zk-adwindow-dimension-control-lg: var(--zk-dimension-control-lg);
	--zk-adwindow-dimension-control-md: var(--zk-dimension-control-md);
	--zk-adwindow-dimension-control-sm: var(--zk-dimension-control-sm);
	--zk-adwindow-dimension-icon-lg: var(--zk-dimension-icon-lg);
	--zk-adwindow-dimension-icon-md: var(--zk-dimension-icon-md);
	--zk-adwindow-dimension-icon-sm: var(--zk-dimension-icon-sm);
	--zk-adwindow-dimension-none: var(--zk-dimension-none);
	--zk-adwindow-dimension-panel-md: var(--zk-dimension-panel-md);
	--zk-adwindow-font-family-icon: var(--zk-font-family-icon);
	--zk-adwindow-font-size-base: var(--zk-font-size-base);
	--zk-adwindow-font-size-lg: var(--zk-font-size-lg);
	--zk-adwindow-font-size-md: var(--zk-font-size-md);
	--zk-adwindow-font-size-md-plus: var(--zk-font-size-md-plus);
	--zk-adwindow-font-style-normal: var(--zk-font-style-normal);
	--zk-adwindow-font-weight-900: var(--zk-font-weight-900);
	--zk-adwindow-font-weight-bold: var(--zk-font-weight-bold);
	--zk-adwindow-font-weight-normal: var(--zk-font-weight-normal);
	--zk-adwindow-line-height-md: var(--zk-line-height-md);
	--zk-adwindow-line-height-sm: var(--zk-line-height-sm);
	--zk-adwindow-line-height-xs: var(--zk-line-height-xs);
	--zk-adwindow-size-0: var(--zk-size-0);
	--zk-adwindow-size-1: var(--zk-size-1);
	--zk-adwindow-size-14: var(--zk-size-14);
	--zk-adwindow-size-1em: var(--zk-size-1em);
	--zk-adwindow-size-2: var(--zk-size-2);
	--zk-adwindow-size-22: var(--zk-size-22);
	--zk-adwindow-size-2em: var(--zk-size-2em);
	--zk-adwindow-size-32: var(--zk-size-32);
	--zk-adwindow-size-350: var(--zk-size-350);
	--zk-adwindow-size-35pct: var(--zk-size-35pct);
	--zk-adwindow-size-4: var(--zk-size-4);
	--zk-adwindow-size-5: var(--zk-size-5);
	--zk-adwindow-size-50pct: var(--zk-size-50pct);
	--zk-adwindow-size-56: var(--zk-size-56);
	--zk-adwindow-size-60pct: var(--zk-size-60pct);
	--zk-adwindow-size-700: var(--zk-size-700);
	--zk-adwindow-size-70pct: var(--zk-size-70pct);
	--zk-adwindow-size-80pct: var(--zk-size-80pct);
	--zk-adwindow-size-90pct: var(--zk-size-90pct);
	--zk-adwindow-size-99pct: var(--zk-size-99pct);
	--zk-adwindow-size-full: var(--zk-size-full);
	--zk-adwindow-space-0: var(--zk-space-0);
	--zk-adwindow-space-2xs: var(--zk-space-2xs);
	--zk-adwindow-space-lg: var(--zk-space-lg);
	--zk-adwindow-space-lg-plus: var(--zk-space-lg-plus);
	--zk-adwindow-space-md: var(--zk-space-md);
	--zk-adwindow-space-sm: var(--zk-space-sm);
	--zk-adwindow-space-xl: var(--zk-space-xl);
	--zk-adwindow-space-xs: var(--zk-space-xs);
	--zk-adwindow-text-decoration-none: var(--zk-text-decoration-none);
	--zk-adwindow-text-decoration-underline: var(--zk-text-decoration-underline);
}

<%-- breadcrumb --%>
.breadcrumb-toolbar-button, .z-toolbarbutton[disabled] .z-toolbarbutton-content
{
	background-color: var(--zk-adwindow-color-transparent);
}
 
.adwindow-form.z-grid > .z-grid-body {
	overflow: visible !important;
}

<%-- main vlayout of AD window --%>
.adwindow-layout {
	position:absolute; 
	border: var(--zk-adwindow-border-none);
	width: var(--zk-adwindow-size-full);
	height: var(--zk-adwindow-size-full);
}

.adwindow-layout .z-center {
	border: var(--zk-adwindow-border-none);
}

<%-- toolbar, breadcrumb and status bar --%>
.adwindow-north {
	min-height: var(--zk-adwindow-size-56);
	width: var(--zk-adwindow-size-full);
	padding: var(--zk-adwindow-space-0);
	margin: var(--zk-adwindow-space-0);
	border: var(--zk-adwindow-border-none);
}

<%-- north status bar --%>
.adwindow-status {
	min-height: var(--zk-adwindow-size-22);
	padding-top: var(--zk-adwindow-space-sm);
	background-color: var(--zk-adwindow-color-subtle-bg);
}

<%-- record info text, east of status bar --%>
.adwindow-status-docinfo {
	display: inline-block;
	position: absolute;
	right: var(--zk-adwindow-space-md);
	max-width: var(--zk-adwindow-size-90pct);
}

.docstatus-error .z-label {
	color: var(--zk-adwindow-color-keyword-red);
}

<%-- status text, west of status bar --%>
.adwindow-status-docstatus {
	display: inline-block;
	float: left;
	padding-left: var(--zk-adwindow-space-md);
}

.adwindow-toolbar.mobile {
	position: relative;
	overflow: hidden;
}

.adwindow-breadcrumb {
	min-height: var(--zk-adwindow-size-32);
	background-color: var(--zk-adwindow-color-surface);
	padding: var(--zk-adwindow-space-0);
	padding-left: var(--zk-adwindow-space-lg);
	border-bottom: var(--zk-adwindow-size-1) solid var(--zk-adwindow-color-border-strong) !important;
	display: flex;
	align-items: center;
	flex-wrap: wrap;
	justify-content: space-between;
}
.adwindow-breadcrumb-paths {
	display: inline-block;
	padding: var(--zk-adwindow-space-md) var(--zk-adwindow-space-0);
}
.adwindow-breadcrumb-toolbar {
	display: inline-block; 
	text-align: right;
}
.adwindow-breadcrumb-toolbar .z-toolbarbutton {
	margin-left: var(--zk-adwindow-space-xs);
}
.adwindow-breadcrumb-toolbar .z-toolbar {
	background-image: none; 
	background-color: var(--zk-adwindow-color-transparent); 
	border: var(--zk-adwindow-border-none);
}
.adwindow-breadcrumb .breadcrumb-record-info.link {
}
.adwindow-breadcrumb .z-toolbarbutton-content {
	line-height: inherit;
}

<%-- dropdown menu icon --%>
.adwindow-breadcrumb-menu::after {
	font-family: var(--zk-adwindow-font-family-icon);
	font-weight: var(--zk-adwindow-font-weight-900);
    font-style: var(--zk-adwindow-font-style-normal);
	font-size: var(--zk-adwindow-font-size-md);
    content: "\f0d7";
    margin-left: var(--zk-adwindow-space-sm);
}

<%-- div container of detail tabbox --%>
.adwindow-detailpane {
	width: var(--zk-adwindow-size-full); 
	overflow-y: visible;
}

.adwindow-detailpane-tabbox {
	width: var(--zk-adwindow-size-99pct); 
	margin: auto;
}
.adwindow-detailpane-tabbox .z-tab-selected span.z-tab-text {
	cursor: pointer;
}
.adwindow-detailpane-tabbox .z-tab-selected span.z-tab-text:hover {
	text-decoration: var(--zk-adwindow-text-decoration-underline);
}

.adwindow-detailpane-tabpanel {
	background-color: var(--zk-adwindow-color-surface)
}

<%-- toolbar of detail panel --%>
.adwindow-detailpane-toolbar {
	border: var(--zk-adwindow-border-none);
	height: var(--zk-adwindow-size-2em);
	background: none;
}
.adwindow-detailpane-toolbar .z-toolbar-body {
	width: var(--zk-adwindow-size-full);
}
.adwindow-detailpane-toolbar .z-toolbarbutton {
	display: inline-flex;
	padding: var(--zk-adwindow-space-0);
	width: var(--zk-adwindow-dimension-control-sm);
	line-height: var(--zk-adwindow-line-height-sm);
}
.adwindow-detailpane-toolbar .z-toolbarbutton img {
	width: var(--zk-adwindow-dimension-icon-md);
	height: var(--zk-adwindow-dimension-icon-md);
}
.adwindow-detailpane-toolbar .z-toolbar-body .docstatus-normal,  
.adwindow-detailpane-toolbar .z-toolbar-body .docstatus-error {
	padding-left: var(--zk-adwindow-space-md);
	margin-top: var(--zk-adwindow-space-xs);
}
.adwindow-detailpane-toolbar .z-toolbar-body .docstatus-normal .z-label,
.adwindow-detailpane-toolbar .z-toolbar-body .docstatus-error .z-label {
	${fontSizeM};
}
.adwindow-detailpane-toolbar .z-toolbarbutton-content {
	line-height: var(--zk-adwindow-line-height-sm);
	height: var(--zk-adwindow-dimension-icon-md);
}

.adwindow-detailpane-message {
	float: right;
}

<%-- south of grid view for record and paging navigation --%>
.adwindow-detailpane-adtab-grid-south {
	background-color: var(--zk-adwindow-color-transparent); 
	position: absolute; 
	right: var(--zk-adwindow-space-0); 
	top: var(--zk-adwindow-space-0); 
	height: var(--zk-adwindow-dimension-control-md);
}
.adwindow-detailpane-adtab-grid-south .z-paging {
	padding: var(--zk-adwindow-space-0) !important;
	height: var(--zk-adwindow-size-2em);
	border: var(--zk-adwindow-border-none);
	background: var(--zk-adwindow-color-surface);
}
.adwindow-detailpane-adtab-grid-south .z-paging .z-paging-inp {
	height: var(--zk-adwindow-dimension-icon-md);
	line-height: var(--zk-adwindow-line-height-md);
}
.z-paging .z-paging-icon {
    font-size: var(--zk-adwindow-font-size-md);
    font-weight: var(--zk-adwindow-font-weight-normal);
}

<%-- south region of AD tab for detail panel --%>
.adwindow-gridview-detail {
	min-height: var(--zk-adwindow-dimension-panel-md);
	height: var(--zk-adwindow-size-35pct);
}
.adwindow-gridview-detail .z-south-body {
	padding-top: var(--zk-adwindow-space-2xs);
}

<%-- AD tab in detail panel with tab level greater than 0 --%>
.adwindow-detailpane-sub-tab::before {
	content: '';
	position: absolute;
	width: var(--zk-adwindow-dimension-none);
	height: var(--zk-adwindow-dimension-none);
	top: var(--zk-adwindow-space-lg-plus);
	left: var(--zk-adwindow-space-md);
	border-top: var(--zk-adwindow-size-5) dashed transparent;
	border-left: var(--zk-adwindow-size-5) dashed var(--zk-adwindow-color-tree-arrow);
	border-right: var(--zk-adwindow-size-5) dashed transparent;
	border-bottom: var(--zk-adwindow-size-5) solid transparent;
	margin-top: var(--zk-adwindow-space-md);
}

<%-- ad tab --%>
.adtab-content {
	margin: var(--zk-adwindow-space-0);
	padding: var(--zk-adwindow-space-0);
	border: var(--zk-adwindow-border-none);
	position: relative;
}

.adtab-grid {
	margin-top: -1px;
	border: var(--zk-adwindow-border-none) !important;
}
.adtab-grid-south {
	border: var(--zk-adwindow-border-none);
	height: var(--zk-adwindow-dimension-control-lg);
}
.adtab-grid-south .z-paging {
	border: var(--zk-adwindow-border-none);
	padding: var(--zk-adwindow-space-0);
}
.adtab-grid .z-checkbox > input[type="checkbox"] {
	font-size: var(--zk-adwindow-font-size-base);
	height: var(--zk-adwindow-size-14);
	width: var(--zk-adwindow-size-14);
}
.adtab-grid > .z-grid-header > table > tbody > tr.z-columns > th.z-column > .z-column-content {
	text-overflow: ellipsis;	
}

.adtab-form {
	border: var(--zk-adwindow-border-none) !important;
	margin: var(--zk-adwindow-space-0);
	padding: var(--zk-adwindow-space-0);
}
<%-- border layout for west tree, center header panel and south detail panel --%>
.adtab-form-borderlayout {
	width: var(--zk-adwindow-size-full); 
	height: var(--zk-adwindow-size-full); 
	position: absolute;
}
.adtab-form-borderlayout .z-center-body {
	background-color: var(--zk-adwindow-color-subtle-bg);
}

.adtab-form-borderlayout .z-grid-body {
	background-color: var(--zk-adwindow-color-subtle-bg);
 }

<%-- title text for collapsed detail panel --%>
.adtab-form-borderlayout .z-south-collapsed:before { 
	content: '${u:cleanAmp(u:getMsg(u:getCtx(), "Detail"))}';
	position: absolute; 
	font-size: var(--zk-adwindow-font-size-md); 
	font-weight: var(--zk-adwindow-font-weight-bold);
	text-align: center;
	line-height: var(--zk-adwindow-line-height-xs);
	left: var(--zk-adwindow-space-md);
	height: var(--zk-adwindow-dimension-icon-sm);
	top: var(--zk-adwindow-space-md);
}

@media screen and (max-height: 767px) {
	.adtab-form-borderlayout.mobile.z-borderlayout > div > .z-south-collapsed > .z-borderlayout-icon.z-icon-chevron-up {
		display: none;
	}
	.adtab-form-borderlayout.mobile.z-borderlayout > div > .adwindow-gridview-detail.z-south {
		height: var(--zk-adwindow-size-50pct) !important;
	}
}
@media screen and (max-height: 600px) {
	.adtab-form-borderlayout.mobile.z-borderlayout > div > .adwindow-gridview-detail.z-south {
		height: var(--zk-adwindow-size-60pct) !important;
	}
}
@media screen and (max-height: 500px) {
	.adtab-form-borderlayout.mobile.z-borderlayout > div > .adwindow-gridview-detail.z-south {
		height: var(--zk-adwindow-size-70pct) !important;
	}
}
@media screen and (max-height: 400px) {
	.adtab-form-borderlayout.mobile.z-borderlayout > div > .adwindow-gridview-detail.z-south {
		height: var(--zk-adwindow-size-80pct) !important;
	}
}

@media screen and (min-width: 600px) {
    /* Tablets and bigger */
	.adwindow-detailpane-adtab-grid-south .z-paging ul>li {
  		display: inline!important;
	}
}

<%-- record info --%>
.activity-card {
	border: var(--zk-adwindow-size-1) solid var(--zk-adwindow-color-border-card);
	border-top-left-radius: var(--zk-adwindow-size-2);
	border-top-right-radius: var(--zk-adwindow-size-2);
	border-bottom: var(--zk-adwindow-size-2) solid var(--zk-adwindow-color-border-card);
	border-bottom-left-radius: var(--zk-adwindow-size-4);
	border-bottom-right-radius: var(--zk-adwindow-size-4);
	margin-left: var(--zk-adwindow-space-sm);
	margin-right: var(--zk-adwindow-space-sm);
}
.activity-card-spacing {
	margin-top: var(--zk-adwindow-space-xl);
}
.activity-card .help-content {
	font-size: var(--zk-adwindow-font-size-md-plus);
	line-height: var(--zk-adwindow-size-1em);
}
.mobile .activity-card .help-content {
	font-size: var(--zk-adwindow-font-size-lg);
}
.record-info-dialog .record-info-radiogroup {
	padding: var(--zk-adwindow-space-md) var(--zk-adwindow-space-md) var(--zk-adwindow-space-xl) var(--zk-adwindow-size-4);
}
.record-info-dialog .record-info-changelog-table {
	margin-left: var(--zk-adwindow-space-sm);
	margin-right: var(--zk-adwindow-space-sm);
}

@media only screen 
  and (max-device-width: 700px) {
	.mobile .adtab-grid > .z-cell > .z-label {
		white-space: pre-line;
	}	
}
@media only screen 
  and (max-device-width: 700px) {
	.mobile .adtab-grid > .z-grid-header > table > tbody > tr.z-columns > th.z-column > .z-column-content {
		white-space: pre-line;
	}
}

.mobile-overflow-link {
	font-weight: var(--zk-adwindow-font-weight-bold); 
	text-decoration: var(--zk-adwindow-text-decoration-none);
	transition: background 0.8s;
	background-position: center;
}
.mobile-overflow-link:active {
	background-color: var(--zk-adwindow-color-neutral-350);
	  background-size: var(--zk-adwindow-size-80pct);
	transition: background 0s;
}
.adwindow-status-docstatus .z-label.mobile-overflow-link {
	width: var(--zk-adwindow-dimension-icon-lg);
	cursor: pointer;
	display: inline-block;
}

.slide-right-out {
    animation: slide-right-out 0.3s forwards;
    animation-timing-function: ease-in;
}
@keyframes slide-right-out {
	0% { transform: translateX(var(--zk-adwindow-size-0)); }
	100% { transform: translateX(var(--zk-adwindow-size-full)); }
}
.slide-right-in {
    animation: slide-right-in 0.3s forwards;
    animation-timing-function: ease-out;
}
@keyframes slide-right-in {
	0% { transform: translateX(calc(var(--zk-adwindow-size-full) * -1)); }
	100% { transform: translateX(var(--zk-adwindow-size-0)); }
}

.slide-left-out {
    animation: slide-left-out 0.3s forwards;
    animation-timing-function: ease-in;
}
@keyframes slide-left-out {
	0% { transform: translateX(var(--zk-adwindow-size-0)); }
	100% { transform: translateX(calc(var(--zk-adwindow-size-full) * -1)); }
}
.slide-left-in {
    animation: slide-left-in 0.3s forwards;
    animation-timing-function: ease-out;
}
@keyframes slide-left-in {
	0% { transform: translateX(var(--zk-adwindow-size-full)); }
	100% { transform: translateX(var(--zk-adwindow-size-0)); }
}

@media only screen 
  and (max-device-width: 700px) {
	.adwindow-detailpane-toolbar .z-paging-button {
		margin-right: var(--zk-adwindow-space-xs);
	}
	.adwindow-detailpane-toolbar .z-paging-input {
		margin-left: var(--zk-adwindow-space-sm);
	}
	.adwindow-detailpane-toolbar .z-paging-text {
		margin-right: var(--zk-adwindow-space-sm);
	}
	.adwindow-detailpane-toolbar {
		padding-left: var(--zk-adwindow-space-0);
		padding-right: var(--zk-adwindow-space-0);
	}
}
@media only screen 
  and (max-device-width: 350px) {
 	.adwindow-detailpane-toolbar .z-paging-input {
		width: var(--zk-adwindow-dimension-control-lg);
	}
}
  
