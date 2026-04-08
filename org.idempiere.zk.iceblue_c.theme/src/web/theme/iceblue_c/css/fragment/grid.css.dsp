<%@ taglib uri="http://www.zkoss.org/dsp/web/core" prefix="c" %>
<%@ taglib uri="http://www.idempiere.org/dsp/web/util" prefix="u" %>

:root {
	--zk-grid-border-none: var(--zk-border-none);
	--zk-grid-color-border: var(--zk-color-border);
	--zk-grid-color-border-soft: var(--zk-color-border-soft);
	--zk-grid-color-focus-bg: var(--zk-color-focus-bg);
	--zk-grid-color-primary-light: var(--zk-color-primary-light);
	--zk-grid-color-primary-lighter: var(--zk-color-primary-lighter);
	--zk-grid-color-surface: var(--zk-color-surface);
	--zk-grid-color-transparent: var(--zk-color-transparent);
	--zk-grid-dimension-control-sm: var(--zk-dimension-control-sm);
	--zk-grid-font-family-icon: var(--zk-font-family-icon);
	--zk-grid-font-size-larger: var(--zk-font-size-larger);
	--zk-grid-size-1: var(--zk-size-1);
	--zk-grid-size-16: var(--zk-size-16);
	--zk-grid-size-700: var(--zk-size-700);
	--zk-grid-size-80pct: var(--zk-size-80pct);
	--zk-grid-size-95pct: var(--zk-size-95pct);
	--zk-grid-size-full: var(--zk-size-full);
	--zk-grid-space-0: var(--zk-space-0);
	--zk-grid-space-2xs: var(--zk-space-2xs);
	--zk-grid-space-md: var(--zk-space-md);
	--zk-grid-space-sm: var(--zk-space-sm);
	--zk-grid-space-xs: var(--zk-space-xs);
	--zk-grid-text-color-default: var(--zk-text-color-default);
	--zk-grid-text-color-strong: var(--zk-text-color-strong);
}

<%-- z-grid customization --%>
.z-grid .z-column, .z-listheader {
	background-color: var(--zk-grid-color-primary-lighter);
	border-left: var(--zk-grid-size-1) solid var(--zk-grid-color-border-soft);
    border-bottom: var(--zk-grid-size-1) solid var(--zk-grid-color-border-soft);
}

.z-grid-header {
	background-color: var(--zk-grid-color-primary-lighter);
}

.z-grid tbody tr.grid-inactive-row td.z-cell {
	background-image: none !important;
}
.z-grid tbody tr.grid-inactive-row td.row-indicator-selected {
	background-image: url(${c:encodeURL('~./theme/iceblue_c/images/EditRecord16.png')}) !important;
	background-position: center;
	background-repeat: no-repeat;
	background-size: var(--zk-grid-size-16) var(--zk-grid-size-16);  
	cursor: pointer;
}
.z-grid tbody tr.grid-inactive-row span.row-indicator-selected.z-icon-Edit,
.z-grid tbody tr.highlight span.row-indicator-selected.z-icon-Edit {
	font-family: var(--zk-grid-font-family-icon);
	font-size: var(--zk-grid-font-size-larger);
	color: var(--zk-grid-text-color-default); 
}
.z-grid tbody tr.highlight td.z-cell { 
	background-color: var(--zk-grid-color-focus-bg) !important;
	background-image: none !important;
}
.z-grid tbody tr.highlight td.row-indicator-selected {
	background-color: var(--zk-grid-color-focus-bg) !important;
	background-image: url(${c:encodeURL('~./theme/iceblue_c/images/EditRecord16.png')}) !important;
	background-position: center;
	background-repeat: no-repeat;
	background-size: var(--zk-grid-size-16) var(--zk-grid-size-16);  
	cursor: pointer;
}
.z-grid tbody tr.highlight td.row-indicator {
	background-color: var(--zk-grid-color-transparent) !important;
	background-image: none !important; 
}
tbody.z-grid-empty-body td {
	text-align: left;
}
.z-grid-emptybody td {
	text-align: left;
}
.z-grid-body {
	background-color: var(--zk-grid-color-surface);
}
div.z-column-cnt, div.z-grid-header div.z-auxheader-cnt {
	padding: var(--zk-grid-space-md) var(--zk-grid-space-xs) var(--zk-grid-space-sm);
}
.z-grid-body .z-cell {
	padding: var(--zk-grid-space-xs) var(--zk-grid-space-sm);
}

<%-- text overflow for grid cell --%>
.z-cell > span.z-label {
	overflow: hidden;
	text-overflow: ellipsis;
	display: inline-block;
	width: var(--zk-grid-size-full);
	vertical-align: middle;
}
.z-listcell > div.z-listcell-content {
	overflow: hidden;
	text-overflow: ellipsis;
	display: inline-block;
	width: var(--zk-grid-size-full);
}
@media only screen 
  and (max-device-width: 700px) {
	.z-listcell > div.z-listcell-content {
		white-space: pre-line;
	}	
}
.z-column-content, .z-listheader-content, .z-listcell-content {
	color: var(--zk-grid-text-color-default);
	padding: var(--zk-grid-space-xs) var(--zk-grid-space-sm) var(--zk-grid-space-2xs);
}

.z-column-content:hover, .z-listheader-content:hover, .z-listcell-content:hover {
	color: var(--zk-grid-text-color-strong);
}

.z-listheader-sort .z-listheader-content:active, .z-column-sort .z-column-content:active  {
    background: var(--zk-grid-color-primary-light);
    color: var(--zk-grid-text-color-strong);
}

.z-column-sort .z-column-sorticon, .z-listheader-sort .z-listheader-sorticon {
	color: var(--zk-grid-text-color-default);
}

<%-- grid layout for form --%>
.grid-layout {
	border: var(--zk-grid-border-none) !important; 
	margin: var(--zk-grid-space-0) !important; 
	padding: var(--zk-grid-space-0) !important;
	background-color: var(--zk-grid-color-transparent) !important;
}
.grid-layout .z-row-inner, .grid-layout .z-cell {
	border: var(--zk-grid-border-none) !important;
	background-color: var(--zk-grid-color-transparent) !important;
}
.grid-layout tr.z-row-over>td.z-row-inner, .grid-layout tr.z-row-over>.z-cell {
	border: var(--zk-grid-border-none) !important;
}
.grid-layout tr.z-row-over>td.z-row-inner, .grid-layout tr.z-row-over>.z-cell {
	background-image: none !important;
}

<%-- z-listbox customization --%>
.z-listbox-header {
	background-color: var(--zk-grid-color-primary-lighter);
	border-left: var(--zk-grid-size-1) solid var(--zk-grid-color-border-soft);
	border-bottom: var(--zk-grid-size-1) solid var(--zk-grid-color-border-soft);
}
tbody.z-listbox-empty-body td {
	text-align: left;
}
div.z-listbox-body .z-listcell {
	padding: var(--zk-grid-space-xs);
}
.z-listbox-autopaging .z-listcell-cnt {
	height: var(--zk-grid-dimension-control-sm);
}
.z-row .z-cell, .z-listitem .z-listcell, .z-listitem.z-listitem-selected>.z-listcell {
	border-left: var(--zk-grid-size-1) solid var(--zk-grid-color-border);
}
.z-row .z-cell, .z-listitem .z-listcell:first-child, 
.z-listitem.z-listitem-selected > .z-listcell:first-child {
	border-left: none;
}
.z-listcell-content:has(> .z-listitem-checkbox) {
    padding: var(--zk-grid-space-xs) var(--zk-grid-space-md) var(--zk-grid-space-2xs) var(--zk-grid-space-2xs);
}

<%-- color editor --%>
div.grid-view-color-fieldtype-display {
	height: var(--zk-grid-dimension-control-sm);
	display: flex;
	align-items: center;
	justify-content: center;
}

div.grid-view-color-fieldtype-display > div {
	width: var(--zk-grid-size-95pct);
	height: var(--zk-grid-size-80pct);
}
