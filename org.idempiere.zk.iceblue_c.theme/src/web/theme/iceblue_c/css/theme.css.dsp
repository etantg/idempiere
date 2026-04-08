<%@ page contentType="text/css;charset=UTF-8" %>
<%@ taglib uri="http://www.zkoss.org/dsp/web/core" prefix="c" %>
<%@ taglib uri="http://www.idempiere.org/dsp/web/util" prefix="u" %>

:root {
	/* Font family */
	--zk-font-family-base: -apple-system, BlinkMacSystemFont, "Segoe UI", "Noto Sans", Helvetica, Arial, sans-serif, "Apple Color Emoji", "Segoe UI Emoji";

	/* Page and surface */
	--zk-color-page-bg: #D4E3F4;
	--zk-color-surface: #ffffff;
	--zk-color-surface-soft: #f8f9fa;
	--zk-color-surface-danger-soft: #fef2f2;
	--zk-color-window-muted: #F4F4F4;
	--zk-color-panel-bg: #F7FAFF;
	--zk-color-group-bg: #f9f9f9;
	--zk-color-panel-tint: #e3f4f9;
	--zk-color-bg-tint: #F9FCFF;

	/* Primary / brand */
	--zk-color-primary: #7ac8ff;
	--zk-color-primary-dark: #6f97d2;
	--zk-color-primary-light: #C7E8FF;
	--zk-color-primary-lighter: #e0f2ff;

	/* Borders */
	--zk-color-border: #cfcfcf;
	--zk-color-border-strong: #C5C5C5;
	--zk-color-border-soft: #CCC;
	--zk-color-border-subtle: #ECECEC;
	--zk-color-border-muted: #dcdcdc;
	--zk-color-border-card: #dcdcdc;
	--zk-color-border-accent: #9CBDFF;
	--zk-color-border-control: #ababab;
	--zk-color-border-hover: #A8A8A8;
	--zk-color-button-hover: #e4e4e4;
	--zk-color-border-focus-legacy: #0000ff;
	--zk-color-border-group: rgb(207, 207, 207);

	/* Focus */
	--zk-color-focus-bg: #FFFFCC;
	--zk-color-focus-border: #0093F9;
	--zk-color-focus-ink: #FFFF08;

	/* State backgrounds */
	--zk-color-muted-bg: #f5f5f5;
	--zk-color-disabled-bg: #F0F0F0;
	--zk-color-disabled-alt: #ECEAE4;
	--zk-color-subtle-bg: #f6fafe;
	--zk-color-accent-soft: #e9ecef;
	--zk-color-accent-subtle: #dee2e6;

	/* Neutral palette */
	--zk-color-neutral-200: #eee;
	--zk-color-neutral-350: #ddd;
	--zk-color-neutral-400: #bbb;
	--zk-color-neutral-425: #e4e4e4;
	--zk-color-neutral-450: #f1f1f1;
	--zk-color-neutral-475: #f1f3f4;

	/* Selection */
	--zk-color-lavender: #E6E6FA;
	--zk-color-selected-bg: #C4DCFB;
	--zk-color-selected-border: #D0DEF0;
	--zk-color-header-border: #ADDDFF;

	/* Danger and status */
	--zk-color-danger-soft: #fecaca;
	--zk-color-danger-hover: #e74c3c;
	--zk-color-danger-active: #dc2626;
	--zk-color-status-finished: #90EE90;
	--zk-color-status-pending: #FFFF00;
	--zk-color-status-in-progress: #FFFF33;
	--zk-color-status-delayed: #0080FF;
	--zk-color-status-skipped: #00FF00;

	/* Interactive and utility */
	--zk-color-drag-highlight: #3fb900;
	--zk-color-tree-arrow: #696969;
	--zk-color-icon-muted: rgba(0, 0, 0, 0.57);
	--zk-color-icon-disabled: rgba(0,0,0,0.34);

	/* Shadow and overlay */
	--zk-color-shadow-inset: rgba(197,197,197,0.5);
	--zk-color-shadow-soft: rgba(0, 0, 0, 0.09);
	--zk-color-shadow-medium: rgba(0, 0, 0, 0.12);
	--zk-color-shadow-strong: rgba(0, 0, 0, 0.15);
	--zk-shadow-inner-light: rgba(255, 255, 255, 0.35);
	--zk-shadow-inner-dark: rgba(0, 0, 0, 0.18);
	--zk-overlay-color-light: rgba(0, 0, 0, 0.2);

	/* Text colors */
	--zk-text-color-default: #333;
	--zk-text-color-strong: #000;
	--zk-text-color-disabled-strong: rgba(0,0,0,0.7);
	--zk-text-color-hover: rgba(0,0,0,0.9);
	--zk-text-color-deep: #2c3e50;
	--zk-text-color-brand: #0000CC;
	--zk-text-color-brand-dark: #000066;
	--zk-text-color-brand-muted: #5687a8;
	--zk-text-color-dialog: #484848;
	--zk-text-color-link: #007bff;
	--zk-text-color-link-muted: #3465a4;
	--zk-text-color-help: #6600CC;
	--zk-text-color-readonly: #252525;
	--zk-text-color-action: #111111;
	--zk-text-color-disabled-soft: #C5CACB;
	--zk-text-color-body: #363636;
	--zk-text-color-secondary-strong: #555;
	--zk-text-color-shadow: #888;
	--zk-text-color-button-hover: #111111;
	
	/* Typography and font tokens */
	--zk-font-family-icon: FontAwesome;
	--zk-font-weight-thin: 100;
	--zk-font-weight-light: 300;
	--zk-font-weight-normal: 400;
	--zk-font-weight-medium: 500;
	--zk-font-weight-semibold: 600;
	--zk-font-weight-bold: 700;
	--zk-font-weight-bolder: 900;
	--zk-font-size-xs: 10px;
	--zk-font-size-sm: 11px;
	--zk-font-size-md: 12px;
	--zk-font-size-md-plus: 13px;
	--zk-font-size-base: 14px;
	--zk-font-size-lg: 16px;
	--zk-font-size-xl: 18px;
	--zk-font-size-2xl: 20px;
	--zk-font-size-3xl: 24px;
	--zk-font-size-4xl: 32px;
	--zk-line-height-xs: 12px;
	--zk-line-height-sm: 14px;
	--zk-line-height-md: 16px;
	--zk-line-height-lg: 24px;
	--zk-line-height-xl: 30px;

	/* Spacing semantic tokens */
	--zk-space-2xs: 1px;
	--zk-space-xs: 2px;
	--zk-space-sm: 3px;
	--zk-space-md: 4px;
	--zk-space-lg: 5px;
	--zk-space-lg-plus: 6px;
	--zk-space-xl-minus: 7px;
	--zk-space-xl: 8px;
	--zk-space-xl-plus: 9px;
	--zk-space-2xl: 10px;
	--zk-space-3xl: 12px;
	--zk-space-3xl-plus: 13px;
	--zk-space-4xl-minus: 14px;
	--zk-space-4xl: 15px;
	--zk-space-4xl-plus: 18px;
	--zk-space-5xl: 20px;
	--zk-space-6xl: 24px;
	--zk-space-7xl: 30px;

	/* Dimension semantic tokens */
	--zk-dimension-icon-sm: 12px;
	--zk-dimension-icon-md: 16px;
	--zk-dimension-icon-lg: 18px;
	--zk-dimension-control-sm: 20px;
	--zk-dimension-control-md: 24px;
	--zk-dimension-control-lg: 30px;
	--zk-dimension-hairline: 1px;
	--zk-dimension-icon-xs: 10px;
	--zk-dimension-panel-sm: 150px;
	--zk-dimension-panel-md: 200px;
	--zk-dimension-panel-lg: 300px;
	--zk-dimension-dialog-sm: 400px;
	--zk-dimension-dialog-md: 600px;

	/* Radius semantic tokens */
	--zk-radius-sm: 2px;
	--zk-radius-md: 4px;
	--zk-radius-lg: 5px;
	--zk-radius-xl: 10px;
}

html,body {
	margin: 0;
	padding: 0;
	height: 100%;
	width: 100%;
	background-color: var(--zk-color-page-bg);
	color: var(--zk-text-color-default);
	font-family: var(--zk-font-family-base);
	overflow: hidden;
}

.z-html p{
	margin:0px;
}

.z-initing {
    background-image: url(${c:encodeURL('~./theme/iceblue_c/images/zssosepowered.png')}) !important;
}

[class*="z-"]:not([class*="z-icon-"]):not([class*="z-group-icon-"]) {
    font-family: var(--zk-font-family-base);
}
@media screen and (min-device-width: 2500px) {
	[class*="z-"]:not([class*="z-icon-"]):not([class*="z-group-icon-"]) {
		font-size: 14px;
	}
}
@media screen and (max-device-width: 2499px) {
	[class*="z-"]:not([class*="z-icon-"]):not([class*="z-group-icon-"]) {
		font-size: 13px;
	}
}
@media screen and (max-device-width: 1899px) {
	[class*="z-"]:not([class*="z-icon-"]):not([class*="z-group-icon-"]) {
		font-size: 12px;
	}
}
@media screen and (max-device-width: 1399px) {
	[class*="z-"]:not([class*="z-icon-"]):not([class*="z-group-icon-"]) {
		font-size: 11px;
	}
}

<%-- Mobile/Tablet --%>
.tablet-scrolling {
	-webkit-overflow-scrolling: touch;
}
<%-- default font size for mobile --%>
.mobile [class*="z-"]:not([class*="z-icon-"]):not([class*="z-group-icon-"]) {
    font-size: 15px;
}
<%-- the not=xyz is needed to get this selected over standard zk rule --%>
.mobile [class*="z-icon-"]:not([class*="xyz"]), .mobile [class*="z-group-icon-"] {
    font-size: 15px;
}

<%-- vbox fix for firefox and ie --%>
table.z-vbox > tbody > tr > td > table {
	width: 100%;	
}

<%-- decorate file drop area --%>
.attachment-drag-entered {
    border: 5px dashed var(--zk-color-drag-highlight) !important;
}

<c:include page="fragment/login.css.dsp" />

<c:include page="fragment/desktop.css.dsp" />

<c:include page="fragment/application-menu.css.dsp" />

<c:include page="fragment/gadget.css.dsp" />

<c:include page="fragment/toolbar.css.dsp" />

<c:include page="fragment/button.css.dsp" />

<c:include page="fragment/adwindow.css.dsp" />
			
<c:include page="fragment/grid.css.dsp" />

<c:include page="fragment/input-element.css.dsp" />

<c:include page="fragment/tree.css.dsp" /> 

<c:include page="fragment/field-editor.css.dsp" />

<c:include page="fragment/group.css.dsp" />

<c:include page="fragment/tab.css.dsp" />

<c:include page="fragment/menu-tree.css.dsp" />

<c:include page="fragment/info-window.css.dsp" />

<c:include page="fragment/window.css.dsp" />

<c:include page="fragment/form.css.dsp" />

<c:include page="fragment/toolbar-popup.css.dsp" />	

<c:include page="fragment/setup-wizard.css.dsp" />

<c:include page="fragment/about.css.dsp" />

<c:include page="fragment/tab-editor.css.dsp" />

<c:include page="fragment/find-window.css.dsp" />

<c:include page="fragment/help-window.css.dsp" />

<c:include page="fragment/drill-window.css.dsp" />

<c:include page="fragment/borderlayout.css.dsp" />

<c:include page="fragment/parameter-process.css.dsp" />

<c:include page="fragment/window-size.css.dsp" />

<c:include page="fragment/font-icons.css.dsp" />

<c:include page="fragment/keikai.css.dsp" />

<c:if test="${u:isThemeHasCustomCSSFragment()}">
    <c:include page="fragment/custom.css.dsp" />
</c:if>
