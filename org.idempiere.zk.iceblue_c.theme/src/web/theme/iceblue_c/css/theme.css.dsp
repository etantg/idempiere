<%@ page contentType="text/css;charset=UTF-8" %>
<%@ taglib uri="http://www.zkoss.org/dsp/web/core" prefix="c" %>
<%@ taglib uri="http://www.idempiere.org/dsp/web/util" prefix="u" %>

html,body {
	margin: 0;
	padding: 0;
	height: var(--zk-size-full);
	width: var(--zk-size-full);
	background-color: var(--zk-color-page-bg);
	color: var(--zk-text-color-default);
	font-family: var(--zk-font-family-base);
	overflow: hidden;
}

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
	--zk-color-border-button: #6d6d6d;
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
	--zk-color-neutral-300: #c8c8c8;
	--zk-color-neutral-350: #ddd;
	--zk-color-neutral-375: #d8d8d8;
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
	--zk-color-danger-brand: #C62223;
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
	--zk-color-keyword-red: red;
	--zk-color-keyword-blue: blue;
	--zk-color-keyword-yellow: yellow;
	--zk-color-keyword-green: green;
	--zk-color-keyword-lightgray: lightgray;
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
	--zk-color-transparent: transparent;

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

	/* Shared scale tokens for fragment spacing and sizing */
	--zk-size-neg-2: -2px;
	--zk-size-neg-4: -4px;
	--zk-size-neg-6: -6px;
	--zk-size-neg-7: -7px;
	--zk-size-0: 0;
	--zk-size-1: 1px;
	--zk-size-2: 2px;
	--zk-size-3: 3px;
	--zk-size-4: 4px;
	--zk-size-5: 5px;
	--zk-size-6: 6px;
	--zk-size-7: 7px;
	--zk-size-8: 8px;
	--zk-size-9: 9px;
	--zk-size-10: 10px;
	--zk-size-11: 11px;
	--zk-size-12: 12px;
	--zk-size-13: 13px;
	--zk-size-14: 14px;
	--zk-size-15: 15px;
	--zk-size-16: 16px;
	--zk-size-17: 17px;
	--zk-size-18: 18px;
	--zk-size-20: 20px;
	--zk-size-22: 22px;
	--zk-size-24: 24px;
	--zk-size-25: 25px;
	--zk-size-26: 26px;
	--zk-size-28: 28px;
	--zk-size-29: 29px;
	--zk-size-30: 30px;
	--zk-size-32: 32px;
	--zk-size-36: 36px;
	--zk-size-38: 38px;
	--zk-size-40: 40px;
	--zk-size-44: 44px;
	--zk-size-45: 45px;
	--zk-size-46: 46px;
	--zk-size-48: 48px;
	--zk-size-52: 52px;
	--zk-size-56: 56px;
	--zk-size-60: 60px;
	--zk-size-62: 62px;
	--zk-size-130: 130px;
	--zk-size-150: 150px;
	--zk-size-180: 180px;
	--zk-size-190: 190px;
	--zk-size-200: 200px;
	--zk-size-220: 220px;
	--zk-size-240: 240px;
	--zk-size-250: 250px;
	--zk-size-260: 260px;
	--zk-size-280: 280px;
	--zk-size-300: 300px;
	--zk-size-320: 320px;
	--zk-size-350: 350px;
	--zk-size-380: 380px;
	--zk-size-400: 400px;
	--zk-size-410: 410px;
	--zk-size-420: 420px;
	--zk-size-450: 450px;
	--zk-size-480: 480px;
	--zk-size-500: 500px;
	--zk-size-540: 540px;
	--zk-size-550: 550px;
	--zk-size-600: 600px;
	--zk-size-604: 604px;
	--zk-size-640: 640px;
	--zk-size-700: 700px;
	--zk-size-720: 720px;
	--zk-size-750: 750px;
	--zk-size-800: 800px;
	--zk-size-900: 900px;
	--zk-size-1000: 1000px;
	--zk-size-1em: 1em;
	--zk-size-1-3em: 1.3em;
	--zk-size-1-5em: 1.5em;
	--zk-size-2em: 2em;
	--zk-size-2vh: 2vh;
	--zk-size-8pct: 8%;
	--zk-size-2pct: 2%;
	--zk-size-5pct: 5%;
	--zk-size-25pct: 25%;
	--zk-size-35pct: 35%;
	--zk-size-40pct: 40%;
	--zk-size-50pct: 50%;
	--zk-size-55pct: 55%;
	--zk-size-60pct: 60%;
	--zk-size-65pct: 65%;
	--zk-size-70pct: 70%;
	--zk-size-77pct: 77%;
	--zk-size-80pct: 80%;
	--zk-size-85pct: 85%;
	--zk-size-88pct: 88%;
	--zk-size-90pct: 90%;
	--zk-size-95pct: 95%;
	--zk-size-98pct: 98%;
	--zk-size-99pct: 99%;
	--zk-size-full: 100%;
	--zk-size-150pct: 150%;
	--zk-size-90vw: 90vw;
	--zk-size-95vw: 95vw;
	--zk-size-300pt: 300pt;

	/* Typography and font tokens */
	--zk-font-family-icon: FontAwesome;
	--zk-font-weight-thin: 100;
	--zk-font-weight-light: 300;
	--zk-font-weight-normal: 400;
	--zk-font-weight-medium: 500;
	--zk-font-weight-semibold: 600;
	--zk-font-weight-bold: 700;
	--zk-font-weight-900: 900;
	--zk-font-style-normal: normal;
	--zk-font-size-larger: larger;
	--zk-font-size-smaller: smaller;
	--zk-font-size-xx-small: xx-small;
	--zk-font-size-xs: var(--zk-size-10);
	--zk-font-size-sm: var(--zk-size-11);
	--zk-font-size-md: var(--zk-size-12);
	--zk-font-size-md-plus: var(--zk-size-13);
	--zk-font-size-base: var(--zk-size-14);
	--zk-font-size-lg: var(--zk-size-16);
	--zk-font-size-xl: var(--zk-size-18);
	--zk-font-size-2xl: var(--zk-size-20);
	--zk-font-size-3xl: var(--zk-size-24);
	--zk-font-size-4xl: var(--zk-size-32);
	--zk-line-height-normal: normal;
	--zk-line-height-xs: var(--zk-size-12);
	--zk-line-height-sm: var(--zk-size-14);
	--zk-line-height-md: var(--zk-size-16);
	--zk-line-height-lg: var(--zk-size-24);
	--zk-line-height-xl: var(--zk-size-30);
	--zk-text-decoration-none: none;
	--zk-text-decoration-underline: underline;
	--zk-border-none: none;

	/* Spacing semantic tokens */
	--zk-space-0: var(--zk-size-0);
	--zk-space-2xs: var(--zk-size-1);
	--zk-space-xs: var(--zk-size-2);
	--zk-space-sm: var(--zk-size-3);
	--zk-space-md: var(--zk-size-4);
	--zk-space-lg: var(--zk-size-5);
	--zk-space-lg-plus: var(--zk-size-6);
	--zk-space-xl-minus: var(--zk-size-7);
	--zk-space-xl: var(--zk-size-8);
	--zk-space-xl-plus: var(--zk-size-9);
	--zk-space-2xl: var(--zk-size-10);
	--zk-space-3xl: var(--zk-size-12);
	--zk-space-3xl-plus: var(--zk-size-13);
	--zk-space-4xl-minus: var(--zk-size-14);
	--zk-space-4xl: var(--zk-size-15);
	--zk-space-4xl-plus: var(--zk-size-18);
	--zk-space-5xl: var(--zk-size-20);
	--zk-space-6xl: var(--zk-size-24);
	--zk-space-7xl: var(--zk-size-30);

	/* Dimension semantic tokens */
	--zk-dimension-icon-sm: var(--zk-size-12);
	--zk-dimension-icon-md: var(--zk-size-16);
	--zk-dimension-icon-lg: var(--zk-size-18);
	--zk-dimension-control-sm: var(--zk-size-20);
	--zk-dimension-control-md: var(--zk-size-24);
	--zk-dimension-control-lg: var(--zk-size-30);
	--zk-dimension-none: var(--zk-size-0);
	--zk-dimension-hairline: var(--zk-size-1);
	--zk-dimension-icon-xs: var(--zk-size-10);
	--zk-dimension-panel-sm: var(--zk-size-150);
	--zk-dimension-panel-md: var(--zk-size-200);
	--zk-dimension-panel-lg: var(--zk-size-300);
	--zk-dimension-dialog-sm: var(--zk-size-400);
	--zk-dimension-dialog-md: var(--zk-size-600);

	/* Radius semantic tokens */
	--zk-radius-none: var(--zk-size-0);
	--zk-radius-sm: var(--zk-size-2);
	--zk-radius-md: var(--zk-size-4);
	--zk-radius-lg: var(--zk-size-5);
	--zk-radius-xl: var(--zk-size-10);

}

.z-html p{
	margin:var(--zk-size-0);
}

.z-initing {
	background-image: url(${c:encodeURL('~./theme/iceblue_c/images/zssosepowered.png')}) !important;
}

[class*="z-"]:not([class*="z-icon-"]):not([class*="z-group-icon-"]) {
	font-family: var(--zk-font-family-base);
}
@media screen and (min-device-width: 2500px) {
	[class*="z-"]:not([class*="z-icon-"]):not([class*="z-group-icon-"]) {
		font-size: var(--zk-size-14);
	}
}
@media screen and (max-device-width: 2499px) {
	[class*="z-"]:not([class*="z-icon-"]):not([class*="z-group-icon-"]) {
		font-size: var(--zk-size-13);
	}
}
@media screen and (max-device-width: 1899px) {
	[class*="z-"]:not([class*="z-icon-"]):not([class*="z-group-icon-"]) {
		font-size: var(--zk-size-12);
	}
}
@media screen and (max-device-width: 1399px) {
	[class*="z-"]:not([class*="z-icon-"]):not([class*="z-group-icon-"]) {
		font-size: var(--zk-size-11);
	}
}

<%-- Mobile/Tablet --%>
.tablet-scrolling {
	-webkit-overflow-scrolling: touch;
}
<%-- default font size for mobile --%>
.mobile [class*="z-"]:not([class*="z-icon-"]):not([class*="z-group-icon-"]) {
	font-size: var(--zk-size-15);
}
<%-- the not=xyz is needed to get this selected over standard zk rule --%>
.mobile [class*="z-icon-"]:not([class*="xyz"]), .mobile [class*="z-group-icon-"] {
	font-size: var(--zk-size-15);
}

<%-- vbox fix for firefox and ie --%>
table.z-vbox > tbody > tr > td > table {
	width: var(--zk-size-full);	
}

<%-- decorate file drop area --%>
.attachment-drag-entered {
	border: var(--zk-size-5) dashed var(--zk-color-drag-highlight) !important;
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
