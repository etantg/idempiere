<%-- container for input field and button --%>
.editor-box {
	display: inline-flex;
	padding: 0px; 
	margin: 0px; 
	position: relative;
	align-items: center;
}

<%-- input field --%>
.editor-input {
	box-sizing: border-box;
	-moz-box-sizing: border-box; /* Firefox */
	display: inline-block;	 
	width: 100%;
	flex: auto;
}
.editor-input.mobile.z-decimalbox {
	padding-right: var(--zk-space-lg);
}

<%-- button for field --%>
.editor-button {
	padding: 0px;
	margin: 0px;
	display: inline-block;	
	background-color: transparent;
	background-image: none;
	width: var(--zk-dimension-control-md);
	min-width: var(--zk-dimension-control-md);
	height: var(--zk-dimension-control-md);
	min-height: var(--zk-dimension-control-md);	
	border: none;
	box-shadow: none;
	flex: auto;
}
.z-button.editor-button > i,
.z-button-os.editor-button > i {
	color: var(--zk-text-color-default);
}
.z-button.editor-button:hover > i,
.z-button-os.editor-button:hover > i {
  color: var(--zk-color-surface);
}
.editor-button :hover {
	-webkit-filter: contrast(1.5);
	filter: contrast(150%);
}
.editor-button img {
	vertical-align: top;
	text-align: left;
	width: var(--zk-dimension-icon-lg);
	height: var(--zk-dimension-icon-lg);
	padding: var(--zk-space-2xs) var(--zk-space-2xs);
}

<%-- chosen box --%>
.z-chosenbox {
	background-image: none;
}
.z-chosenbox:has(> input:focus) {
  background: var(--zk-color-focus-bg) !important;
  border-color: var(--zk-color-focus-border) !important;
}
<%-- include/exclude icon for chosenbox --%>
.editor-box + .btn-negate.z-button > .z-icon-ExcludeSelected::before,
.editor-box + .btn-negate.z-button > .z-icon-IncludeSelected::before {
	color: var(--zk-text-color-default);
}
.editor-box + .btn-negate.z-button {
	background: none;
	border: none;
	margin: 0px !important;
	padding: 0px;
	min-width: var(--zk-dimension-icon-md);
	width: var(--zk-dimension-icon-md);	
	height: var(--zk-dimension-icon-xs);
	min-height:var(--zk-dimension-icon-xs);
	font-size: var(--zk-font-size-base);
	font-weight: var(--zk-font-weight-light);		
	position: absolute;
	top: var(--zk-space-md);
	right: var(--zk-space-7xl);
	z-index: 2000;
}
.editor-box + .btn-negate.z-button, 
.editor-box + .btn-negate.z-button:focus {
	border: none;
	box-shadow: none;	
}
.editor-box + .btn-negate.z-button [class^="z-icon-"] {
	font-size: var(--zk-font-size-base);
	padding: 0px;
	line-height: var(--zk-line-height-sm);
}

<%-- datetime box --%>
.datetime-box {
	display: flex;
	flex-wrap: wrap;
}

<%-- combobox editor in grid view --%>
span.grid-combobox-editor {
	width: 100% !important;
	position: relative;
}
.grid-combobox-editor input {
	width: 100% !important;
	padding-right: 26px;
	border-right: 0px;
}
.grid-combobox-editor.z-combobox-disabled input {
	padding-right: var(--zk-space-lg);
}
.grid-combobox-editor .z-combobox-button {
	position: absolute;
	right: 0px;
}
.grid-combobox-editor input:focus {
	border-right: 0px;
}
	
.grid-combobox-editor input:focus + .z-combobox-button {
	border-left: 1px solid var(--zk-color-border-focus-legacy);
}

<%-- payment rule --%>
.payment-rule-editor {
	display: inline-flex;
	padding: 0px; 
	margin: 0px; 
	position: relative;
}
.payment-rule-editor .z-combobox {
	width: 100%;
}
.payment-rule-editor .z-combobox-input {
	display: inline-block;
	padding-right: 44px; 
	width: 100%;
}
.payment-rule-editor .z-combobox-input.editor-input-disd {
	padding-right: 22px !important;
}
.payment-rule-editor .z-combobox-button {
	position: absolute;
	right: 0px;
}
.payment-rule-editor .z-combobox .z-combobox-button-hover {
	background-position: 0px 0px;
}
.payment-rule-editor > .editor-button {
	border-radius: 0px;
	right: var(--zk-space-6xl);
	border: none;
  	top: var(--zk-space-sm);
  	min-height: var(--zk-dimension-control-sm);
}

<%-- chart --%>
.chart-field {
	padding: var(--zk-space-2xl); 
}

<%-- image field --%>
.image-field {
	cursor: pointer;
	border: 1px solid var(--zk-color-border-strong);
	height: var(--zk-dimension-control-md);
	width: var(--zk-dimension-control-md);
}
.image-field.image-field-readonly {
	cursor: default;
	border: none;
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
	border: 1px solid var(--zk-color-border-subtle);
	border-radius: var(--zk-radius-md);
}
.html-field:hover {
	border-color: var(--zk-color-border-hover);
}
.html-field:focus {
	border-color: var(--zk-color-focus-border);
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
	text-decoration: none; font-size: xx-small; vertical-align: top;
}

.idempiere-mandatory, .idempiere-mandatory input, .idempiere-mandatory a {
    border-color:red;
}

.idempiere-mandatory-label{
   color: red!important;
}

.idempiere-zoomable-label {
    cursor: pointer; 
    text-decoration: underline;
}

<%-- range button for datebox --%>
.z-toolbarbutton:has(> span > i.z-icon-History) {
	padding: var(--zk-space-xs);
    min-width: var(--zk-dimension-control-md);
    border: none;
}
.z-toolbarbutton:has(> span > i.z-icon-History):hover {
	background-color: var(--zk-color-primary) !important;
}
.date-picker-calendar-button {
    position: absolute;
    right: 0px;
    top: var(--zk-space-lg);
}
<%-- date range editor --%>
.date-picker-container {
	padding-left: var(--zk-space-lg);
}
.date-picker-component {
	display: inline-grid;
	min-height: 25px;
	border-radius: var(--zk-radius-lg);
	margin: 0px var(--zk-space-lg) var(--zk-space-lg) 0px !important;
}
.date-picker-component .z-listbox {
	border: none;
}
.date-picker-label {
	font-weight: var(--zk-font-weight-bold);
	margin: var(--zk-space-lg);
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
    margin: 0px;
    background-image: none;
    position: relative;
    width: var(--zk-dimension-control-md);
    min-width: var(--zk-dimension-control-md);
    height: var(--zk-dimension-control-md);
    min-height: var(--zk-dimension-control-md);
    right: auto !important;
    padding: 0px;
    flex: auto;
}
.recordid-editor .z-toolbarbutton:hover {
	background-color: var(--zk-color-primary)
}

<%-- font icon for field button --%>
.z-button [class^="z-icon-"], .z-button-os [class^="z-icon-"] {
	color: var(--zk-color-surface);
}

<%-- full size image hover --%>
.fullsize-image {
	padding: var(--zk-space-lg);
	  border: 1px solid var(--zk-color-border-soft);
	  background: var(--zk-color-panel-tint);
}
