:root {
	--zk-field-border-none: var(--zk-border-none);
	--zk-field-color-border-focus-legacy: var(--zk-color-border-focus-legacy);
	--zk-field-color-border-hover: var(--zk-color-border-hover);
	--zk-field-color-border-soft: var(--zk-color-border-soft);
	--zk-field-color-border-strong: var(--zk-color-border-strong);
	--zk-field-color-border-subtle: var(--zk-color-border-subtle);
	--zk-field-color-focus-bg: var(--zk-color-focus-bg);
	--zk-field-color-focus-border: var(--zk-color-focus-border);
	--zk-field-color-keyword-red: var(--zk-color-keyword-red);
	--zk-field-color-panel-tint: var(--zk-color-panel-tint);
	--zk-field-color-primary: var(--zk-color-primary);
	--zk-field-color-surface: var(--zk-color-surface);
	--zk-field-color-transparent: var(--zk-color-transparent);
	--zk-field-dimension-control-md: var(--zk-dimension-control-md);
	--zk-field-dimension-control-sm: var(--zk-dimension-control-sm);
	--zk-field-dimension-icon-lg: var(--zk-dimension-icon-lg);
	--zk-field-dimension-icon-md: var(--zk-dimension-icon-md);
	--zk-field-dimension-icon-xs: var(--zk-dimension-icon-xs);
	--zk-field-font-size-base: var(--zk-font-size-base);
	--zk-field-font-size-xx-small: var(--zk-font-size-xx-small);
	--zk-field-font-weight-bold: var(--zk-font-weight-bold);
	--zk-field-font-weight-light: var(--zk-font-weight-light);
	--zk-field-line-height-sm: var(--zk-line-height-sm);
	--zk-field-radius-lg: var(--zk-radius-lg);
	--zk-field-radius-md: var(--zk-radius-md);
	--zk-field-radius-none: var(--zk-radius-none);
	--zk-field-size-0: var(--zk-size-0);
	--zk-field-size-1: var(--zk-size-1);
	--zk-field-size-150pct: var(--zk-size-150pct);
	--zk-field-size-22: var(--zk-size-22);
	--zk-field-size-25: var(--zk-size-25);
	--zk-field-size-26: var(--zk-size-26);
	--zk-field-size-44: var(--zk-size-44);
	--zk-field-size-full: var(--zk-size-full);
	--zk-field-space-0: var(--zk-space-0);
	--zk-field-space-2xl: var(--zk-space-2xl);
	--zk-field-space-2xs: var(--zk-space-2xs);
	--zk-field-space-6xl: var(--zk-space-6xl);
	--zk-field-space-7xl: var(--zk-space-7xl);
	--zk-field-space-lg: var(--zk-space-lg);
	--zk-field-space-md: var(--zk-space-md);
	--zk-field-space-sm: var(--zk-space-sm);
	--zk-field-space-xs: var(--zk-space-xs);
	--zk-field-text-color-default: var(--zk-text-color-default);
	--zk-field-text-decoration-none: var(--zk-text-decoration-none);
	--zk-field-text-decoration-underline: var(--zk-text-decoration-underline);
}

<%-- container for input field and button --%>
.editor-box {
	display: inline-flex;
	padding: var(--zk-field-space-0); 
	margin: var(--zk-field-space-0); 
	position: relative;
	align-items: center;
}

<%-- input field --%>
.editor-input {
	box-sizing: border-box;
	-moz-box-sizing: border-box; /* Firefox */
	display: inline-block;	 
	width: var(--zk-field-size-full);
	flex: auto;
}
.editor-input.mobile.z-decimalbox {
	padding-right: var(--zk-field-space-lg);
}

<%-- button for field --%>
.editor-button {
	padding: var(--zk-field-space-0);
	margin: var(--zk-field-space-0);
	display: inline-block;	
	background-color: var(--zk-field-color-transparent);
	background-image: none;
	width: var(--zk-field-dimension-control-md);
	min-width: var(--zk-field-dimension-control-md);
	height: var(--zk-field-dimension-control-md);
	min-height: var(--zk-field-dimension-control-md);	
	border: var(--zk-field-border-none);
	box-shadow: none;
	flex: auto;
}
.z-button.editor-button > i,
.z-button-os.editor-button > i {
	color: var(--zk-field-text-color-default);
}
.z-button.editor-button:hover > i,
.z-button-os.editor-button:hover > i {
  color: var(--zk-field-color-surface);
}
.editor-button :hover {
	-webkit-filter: contrast(1.5);
	filter: contrast(var(--zk-field-size-150pct));
}
.editor-button img {
	vertical-align: top;
	text-align: left;
	width: var(--zk-field-dimension-icon-lg);
	height: var(--zk-field-dimension-icon-lg);
	padding: var(--zk-field-space-2xs) var(--zk-field-space-2xs);
}

<%-- chosen box --%>
.z-chosenbox {
	background-image: none;
}
.z-chosenbox:has(> input:focus) {
  background: var(--zk-field-color-focus-bg) !important;
  border-color: var(--zk-field-color-focus-border) !important;
}
<%-- include/exclude icon for chosenbox --%>
.editor-box + .btn-negate.z-button > .z-icon-ExcludeSelected::before,
.editor-box + .btn-negate.z-button > .z-icon-IncludeSelected::before {
	color: var(--zk-field-text-color-default);
}
.editor-box + .btn-negate.z-button {
	background: none;
	border: var(--zk-field-border-none);
	margin: var(--zk-field-space-0) !important;
	padding: var(--zk-field-space-0);
	min-width: var(--zk-field-dimension-icon-md);
	width: var(--zk-field-dimension-icon-md);	
	height: var(--zk-field-dimension-icon-xs);
	min-height:var(--zk-field-dimension-icon-xs);
	font-size: var(--zk-field-font-size-base);
	font-weight: var(--zk-field-font-weight-light);		
	position: absolute;
	top: var(--zk-field-space-md);
	right: var(--zk-field-space-7xl);
	z-index: 2000;
}
.editor-box + .btn-negate.z-button, 
.editor-box + .btn-negate.z-button:focus {
	border: var(--zk-field-border-none);
	box-shadow: none;	
}
.editor-box + .btn-negate.z-button [class^="z-icon-"] {
	font-size: var(--zk-field-font-size-base);
	padding: var(--zk-field-space-0);
	line-height: var(--zk-field-line-height-sm);
}

<%-- datetime box --%>
.datetime-box {
	display: flex;
	flex-wrap: wrap;
}

<%-- combobox editor in grid view --%>
span.grid-combobox-editor {
	width: var(--zk-field-size-full) !important;
	position: relative;
}
.grid-combobox-editor input {
	width: var(--zk-field-size-full) !important;
	padding-right: var(--zk-field-size-26);
	border-right: var(--zk-field-size-0);
}
.grid-combobox-editor.z-combobox-disabled input {
	padding-right: var(--zk-field-space-lg);
}
.grid-combobox-editor .z-combobox-button {
	position: absolute;
	right: var(--zk-field-space-0);
}
.grid-combobox-editor input:focus {
	border-right: var(--zk-field-size-0);
}
	
.grid-combobox-editor input:focus + .z-combobox-button {
	border-left: var(--zk-field-size-1) solid var(--zk-field-color-border-focus-legacy);
}

<%-- payment rule --%>
.payment-rule-editor {
	display: inline-flex;
	padding: var(--zk-field-space-0); 
	margin: var(--zk-field-space-0); 
	position: relative;
}
.payment-rule-editor .z-combobox {
	width: var(--zk-field-size-full);
}
.payment-rule-editor .z-combobox-input {
	display: inline-block;
	padding-right: var(--zk-field-size-44); 
	width: var(--zk-field-size-full);
}
.payment-rule-editor .z-combobox-input.editor-input-disd {
	padding-right: var(--zk-field-size-22) !important;
}
.payment-rule-editor .z-combobox-button {
	position: absolute;
	right: var(--zk-field-space-0);
}
.payment-rule-editor .z-combobox .z-combobox-button-hover {
	background-position: var(--zk-field-size-0) var(--zk-field-size-0);
}
.payment-rule-editor > .editor-button {
	border-radius: var(--zk-field-radius-none);
	right: var(--zk-field-space-6xl);
	border: var(--zk-field-border-none);
  	top: var(--zk-field-space-sm);
  	min-height: var(--zk-field-dimension-control-sm);
}

<%-- chart --%>
.chart-field {
	padding: var(--zk-field-space-2xl); 
}

<%-- image field --%>
.image-field {
	cursor: pointer;
	border: var(--zk-field-size-1) solid var(--zk-field-color-border-strong);
	height: var(--zk-field-dimension-control-md);
	width: var(--zk-field-dimension-control-md);
}
.image-field.image-field-readonly {
	cursor: default;
	border: var(--zk-field-border-none);
}
.image-fit {
	object-fit: scale-down;
}
.z-cell.image-field-cell {
	z-index: 1;
}

<%-- html field --%>
.html-field {
	cursor: pointer;
	overflow: auto;
	border: var(--zk-field-size-1) solid var(--zk-field-color-border-subtle);
	border-radius: var(--zk-field-radius-md);
}
.html-field:hover {
	border-color: var(--zk-field-color-border-hover);
}
.html-field:focus {
	border-color: var(--zk-field-color-focus-border);
}

<%-- dashboard content editor --%>
.dashboard-field-panel.z-panel, .dashboard-field-panel.z-panel > .z-panel-body,  .dashboard-field-panel.z-panel > .z-panel-body > .z-panelchildren  {
	overflow: visible;
}

<%-- field label --%>
.field-label {
	position: relative; 
	float: right;
}
.mandatory-decorator-text {
	text-decoration: var(--zk-field-text-decoration-none); font-size: var(--zk-field-font-size-xx-small); vertical-align: top;
}

.idempiere-mandatory, .idempiere-mandatory input, .idempiere-mandatory a {
    border-color:var(--zk-field-color-keyword-red);
}

.idempiere-mandatory-label{
   color: var(--zk-field-color-keyword-red)!important;
}

.idempiere-zoomable-label {
    cursor: pointer; 
    text-decoration: var(--zk-field-text-decoration-underline);
}

<%-- range button for datebox --%>
.z-toolbarbutton:has(> span > i.z-icon-History) {
	padding: var(--zk-field-space-xs);
    min-width: var(--zk-field-dimension-control-md);
    border: var(--zk-field-border-none);
}
.z-toolbarbutton:has(> span > i.z-icon-History):hover {
	background-color: var(--zk-field-color-primary) !important;
}
.date-picker-calendar-button {
    position: absolute;
    right: var(--zk-field-space-0);
    top: var(--zk-field-space-lg);
}
<%-- date range editor --%>
.date-picker-container {
	padding-left: var(--zk-field-space-lg);
}
.date-picker-component {
	display: inline-grid;
	min-height: var(--zk-field-size-25);
	border-radius: var(--zk-field-radius-lg);
	margin: var(--zk-field-space-0) var(--zk-field-space-lg) var(--zk-field-space-lg) var(--zk-field-size-0) !important;
}
.date-picker-component .z-listbox {
	border: var(--zk-field-border-none);
}
.date-picker-label {
	font-weight: var(--zk-field-font-weight-bold);
	margin: var(--zk-field-space-lg);
}

<%-- record id editor --%>
.recordid-editor {
  display: inline-flex;
  position: relative;
  align-items: center;
}
.recordid-editor > input {
  flex: auto;
}
.recordid-editor .z-toolbarbutton {
    margin: var(--zk-field-space-0);
    background-image: none;
    position: relative;
    width: var(--zk-field-dimension-control-md);
    min-width: var(--zk-field-dimension-control-md);
    height: var(--zk-field-dimension-control-md);
    min-height: var(--zk-field-dimension-control-md);
    right: auto !important;
    padding: var(--zk-field-space-0);
    flex: auto;
}
.recordid-editor .z-toolbarbutton:hover {
	background-color: var(--zk-field-color-primary)
}

<%-- font icon for field button --%>
.z-button [class^="z-icon-"], .z-button-os [class^="z-icon-"] {
	color: var(--zk-field-color-surface);
}

<%-- full size image hover --%>
.fullsize-image {
	padding: var(--zk-field-space-lg);
  	border: var(--zk-field-size-1) solid var(--zk-field-color-border-soft);
  	background: var(--zk-field-color-panel-tint);
}
