:root {
	--zk-checkbox-checked-bg: var(--zk-color-primary);
	--zk-checkbox-focus-border: var(--zk-color-focus-border);
	--zk-checkbox-focus-ink: var(--zk-color-focus-ink);
	--zk-input-control-border-reset: var(--zk-border-none);
	--zk-input-border-width: var(--zk-size-1);
	--zk-input-border-color: var(--zk-color-border-subtle);
	--zk-input-border: var(--zk-input-border-width) solid var(--zk-input-border-color);
	--zk-input-disabled-text: var(--zk-text-color-disabled-strong);
	--zk-input-disabled-strong-text: var(--zk-text-color-strong);
	--zk-input-disabled-bg: var(--zk-color-disabled-bg);
	--zk-input-disabled-alt-bg: var(--zk-color-disabled-alt);
	--zk-input-focus-bg: var(--zk-color-focus-bg);
	--zk-input-text-color: var(--zk-text-color-default);
	--zk-input-control-hover-bg: var(--zk-color-primary);
	--zk-input-control-hover-icon-color: var(--zk-color-surface);
	--zk-input-attachment-border: var(--zk-size-1) solid var(--zk-color-border-muted);
	--zk-input-attachment-border-radius: var(--zk-radius-md);
	--zk-input-attachment-bg: var(--zk-color-muted-bg);
	--zk-input-attachment-margin-inline-end: var(--zk-space-lg);
	--zk-input-attachment-margin-block-end: var(--zk-space-lg);
	--zk-input-attachment-padding-inline-start: var(--zk-space-lg);
	--zk-input-attachment-padding-inline-end: var(--zk-space-lg);
	--zk-input-comboitem-min-height: var(--zk-size-14);
	--zk-input-popup-max-height: var(--zk-dimension-panel-md);
	--zk-input-control-border-radius: var(--zk-radius-md);
	--zk-input-control-height: var(--zk-size-24);
	--zk-input-control-min-height: var(--zk-size-24);
	--zk-input-control-width: var(--zk-size-24);
	--zk-input-control-min-width: var(--zk-size-24);
	--zk-input-control-padding: var(--zk-space-0);
	--zk-input-control-icon-line-height: var(--zk-size-24);
	--zk-input-control-icon-size: var(--zk-size-14);
	--zk-input-timebox-icon-line-height: var(--zk-line-height-xs);
	--zk-input-field-padding-inline-end: var(--zk-size-5);
	--zk-input-checkbox-checked-bg: var(--zk-checkbox-checked-bg);
	--zk-input-checkbox-focus-border: var(--zk-checkbox-focus-border);
	--zk-input-checkbox-focus-ink: var(--zk-checkbox-focus-ink);
}

<%-- Attachment Item --%>
.z-attachment-item {
	border: var(--zk-input-attachment-border);
	border-radius: var(--zk-input-attachment-border-radius);
	background-color: var(--zk-input-attachment-bg);
	width: auto !important;
	display: inline-block;
	margin-right: var(--zk-input-attachment-margin-inline-end); 
	margin-bottom: var(--zk-input-attachment-margin-block-end);
	padding-left: var(--zk-input-attachment-padding-inline-start);
	padding-right: var(--zk-input-attachment-padding-inline-end);
}

.z-attachment-item-del-button {
	float: right;
	background-color: var(--zk-input-attachment-bg);
}

<%-- Combobox --%>
.z-combobox-disabled, .z-combobox[disabled] {
	color: var(--zk-input-disabled-text) !important; 
	cursor: default !important; 
}

.z-combobox-disabled > input {
	color: var(--zk-input-disabled-text) !important; 
	cursor: default !important;
}

.z-combobox-text-disabled {
	background-color: var(--zk-input-disabled-alt-bg) !important;
}
.z-comboitem {
	min-height:var(--zk-input-comboitem-min-height);
}
<%-- highlight focus form element --%>
input:focus, textarea:focus, .z-combobox-input:focus, z-datebox-input:focus, select:focus {
	background: var(--zk-input-focus-bg);
}

.z-textbox-readonly, .z-intbox-readonly, .z-longbox-readonly, .z-doublebox-readonly, 
.z-decimalbox-readonly, .z-datebox-readonly, .z-timebox-readonly, .editor-input-disd, 
.z-textbox[readonly], .z-intbox[readonly], .z-longbox[readonly], .z-doublebox[readonly], 
.z-decimalbox[readonly], .z-datebox[readonly], .z-timebox[readonly] {
	background-color: var(--zk-input-disabled-bg);
}

.z-textbox[disabled], .z-intbox[disabled], .z-longbox[disabled], .z-doublebox[disabled], 
.z-decimalbox[disabled], .z-datebox[disabled], .z-timebox[disabled] {
	color: var(--zk-input-disabled-strong-text) !important;
	background-color: var(--zk-input-disabled-bg) !important;
	cursor: default !important;
	opacity: 1 !important;
	border: var(--zk-input-border);
}

.z-textbox, .z-decimalbox, .z-intbox, .z-longbox, .z-doublebox,
.z-datebox-input, .z-datebox-button, .z-timebox-input, .z-timebox-button,
.z-combobox-input, .z-combobox-button {
	border: var(--zk-input-border);
}

<%-- workaround for http://jira.idempiere.com/browse/IDEMPIERE-692 --%>
.z-combobox-popup {
	max-height: var(--zk-input-popup-max-height);
}

<%-- datebox --%>
.z-datebox {
	display: inline-flex;
  	align-items: center;
}
.z-datebox-input {
	padding-right: var(--zk-input-field-padding-inline-end);
	flex: auto;
}
.z-datebox-input:focus + .z-datebox-button {
	border: var(--zk-input-control-border-reset);
}
.z-datebox-button {
	border: var(--zk-input-control-border-reset);
	border-radius: var(--zk-input-control-border-radius);
  	position: relative;
	width: var(--zk-input-control-width);
	min-width: var(--zk-input-control-min-width);
	height: var(--zk-input-control-height);
	min-height: var(--zk-input-control-min-height);  	
  	flex: auto;
	color: var(--zk-input-text-color);
	padding: var(--zk-input-control-padding);
}
.z-datebox-button:hover {
	background-color: var(--zk-input-control-hover-bg) !important;
}
.z-datebox-button > i {
	line-height: var(--zk-input-control-icon-line-height);
	font-size: var(--zk-input-control-icon-size);
}
.z-datebox-button:hover > i {
	color: var(--zk-input-control-hover-icon-color);
}

.z-timebox {
  display: inline-flex;
}
.z-timebox-button>a>i {
	line-height: var(--zk-input-timebox-icon-line-height);
	transform:translateY(-1px);
}

input[type="checkbox"]:checked {
	background-color: var(--zk-input-checkbox-checked-bg);
}

<%-- focus indicator for checkbox --%>
input[type="checkbox"]:focus {
	border-color: var(--zk-input-checkbox-focus-border);
	color: var(--zk-input-checkbox-focus-ink);
}
.z-label {
	color: var(--zk-input-text-color);
}