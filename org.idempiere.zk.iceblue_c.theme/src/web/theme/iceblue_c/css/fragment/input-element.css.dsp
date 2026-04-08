<%-- Attachment Item --%>
.z-attachment-item {
	border: 1px solid var(--zk-color-border-muted);
	border-radius: var(--zk-radius-md);
	background-color: var(--zk-color-muted-bg);
	width: auto !important;
	display: inline-block;
	margin-right: var(--zk-space-lg); 
	margin-bottom: var(--zk-space-lg);
	padding-left: var(--zk-space-lg);
	padding-right: var(--zk-space-lg);
}

.z-attachment-item-del-button {
	float: right;
	background-color: var(--zk-color-muted-bg);
}

<%-- Combobox --%>
.z-combobox-disabled, .z-combobox[disabled] {
	color: var(--zk-text-color-disabled-strong) !important; 
	cursor: default !important; 
}

.z-combobox-disabled > input {
	color: var(--zk-text-color-disabled-strong) !important; 
	cursor: default !important;
}

.z-combobox-text-disabled {
	background-color: var(--zk-color-disabled-alt) !important;
}
.z-comboitem {
	min-height:14px;
}
<%-- highlight focus form element --%>
input:focus, textarea:focus, .z-combobox-input:focus, .z-datebox-input:focus, select:focus {
	background: var(--zk-color-focus-bg);
}

.z-textbox-readonly, .z-intbox-readonly, .z-longbox-readonly, .z-doublebox-readonly, 
.z-decimalbox-readonly, .z-datebox-readonly, .z-timebox-readonly, .editor-input-disd, 
.z-textbox[readonly], .z-intbox[readonly], .z-longbox[readonly], .z-doublebox[readonly], 
.z-decimalbox[readonly], .z-datebox[readonly], .z-timebox[readonly] {
	background-color: var(--zk-color-disabled-bg);
}

.z-textbox[disabled], .z-intbox[disabled], .z-longbox[disabled], .z-doublebox[disabled], 
.z-decimalbox[disabled], .z-datebox[disabled], .z-timebox[disabled] {
	color: var(--zk-text-color-strong) !important;
	background-color: var(--zk-color-disabled-bg) !important;
	cursor: default !important;
	opacity: 1 !important;
	border: 1px solid var(--zk-color-border-subtle);
}

.z-textbox, .z-decimalbox, .z-intbox, .z-longbox, .z-doublebox,
.z-datebox-input, .z-datebox-button, .z-timebox-input, .z-timebox-button,
.z-combobox-input, .z-combobox-button {
	border: 1px solid var(--zk-color-border-subtle);
}

<%-- workaround for http://jira.idempiere.com/browse/IDEMPIERE-692 --%>
.z-combobox-popup {
	max-height: var(--zk-dimension-panel-md);
}

<%-- datebox --%>
.z-datebox {
	display: inline-flex;
  	align-items: center;
}
.z-datebox-input {
	padding-right: 5px;
	flex: auto;
}
.z-datebox-input:focus + .z-datebox-button {
  	border: none;
}
.z-datebox-button {
	border: none;
	border-radius: var(--zk-radius-md);
  	position: relative;
  	width: 24px;
  	min-width: 24px;
  	height: 24px;
  	min-height: 24px;  	
  	flex: auto;
  	color: var(--zk-text-color-default);
  	padding: 0px;
}
.z-datebox-button:hover {
  	background-color: var(--zk-color-primary) !important;
}
.z-datebox-button > i {
	line-height: 24px;
	font-size: 14px;
}
.z-datebox-button:hover > i {
  	color: var(--zk-color-surface);
}

.z-timebox {
  display: inline-flex;
}
.z-timebox-button>a>i {
	line-height: var(--zk-line-height-xs);
	transform:translateY(-1px);
}

input[type="checkbox"]:checked {
    background-color: var(--zk-color-primary);
}

<%-- focus indicator for checkbox --%>
input[type="checkbox"]:focus {
    border-color: var(--zk-color-focus-border);
    color: var(--zk-color-focus-ink);
}
.z-label {
	color: var(--zk-text-color-default);
}