:root {
	--zk-form-color-border-accent: var(--zk-color-border-accent);
	--zk-form-color-transparent: var(--zk-color-transparent);
	--zk-form-dimension-icon-md: var(--zk-dimension-icon-md);
	--zk-form-font-size-smaller: var(--zk-font-size-smaller);
	--zk-form-font-weight-normal: var(--zk-font-weight-normal);
	--zk-form-size-0: var(--zk-size-0);
	--zk-form-size-1: var(--zk-size-1);
	--zk-form-size-1em: var(--zk-size-1em);
	--zk-form-size-29: var(--zk-size-29);
	--zk-form-size-99pct: var(--zk-size-99pct);
	--zk-form-size-full: var(--zk-size-full);
	--zk-form-space-0: var(--zk-space-0);
	--zk-form-space-2xl: var(--zk-space-2xl);
	--zk-form-space-2xs: var(--zk-space-2xs);
	--zk-form-space-lg: var(--zk-space-lg);
	--zk-form-space-xl-plus: var(--zk-space-xl-plus);
	--zk-form-space-xs: var(--zk-space-xs);
	--zk-form-text-color-body: var(--zk-text-color-body);
}

.form-label
{
	text-align: right;
}
.form-label-heading
{
	text-align: center;
}
td.form-label-above-input div.form-label {
    text-align: left;
}
td.form-label-above-input div.form-label > span.z-label {
    font-weight: var(--zk-form-font-weight-normal);
    font-size: var(--zk-form-font-size-smaller) !important;
}
td.form-label-above-input.z-cell {
    padding-top: var(--zk-form-space-lg);
    padding-bottom: var(--zk-form-space-lg);
}
td.form-label-above-input.login-label {
    text-align: left;
}
td.form-label-above-input.login-label .z-label,
.form-label-above-input .idempiere-label.z-label {
    font-weight: var(--zk-form-font-weight-normal);
    font-size: var(--zk-form-font-size-smaller) !important;
}
.form-label-above-input.z-window .login-box-body,
.form-label-above-input.adwindow-form,
.form-label-above-input.input-paramenter-layout {
    padding-left: var(--zk-form-size-1em) !important;
    padding-right: var(--zk-form-size-1em) !important;
}

.form-button {
	width: var(--zk-form-size-99pct);
}
.form-button img {
	width: var(--zk-form-dimension-icon-md);
	height: var(--zk-form-dimension-icon-md);
}

<%-- confirm panel --%>
.confirm-panel {
	width: auto;
	height: auto;
	position: relative;
	padding-left: var(--zk-form-space-xs);
	padding-right: var(--zk-form-space-xs);
}
.confirm-panel-right {
	float: right;
	padding: var(--zk-form-space-2xs);
}
.confirm-panel-left {
	float: left;
}
.confirm-panel-center{
	padding-left: var(--zk-form-space-lg);
	float: left;
}

<%-- busy dialog --%>
.busy-dialog {
	cursor: wait;
	background-color: var(--zk-form-color-transparent);
}
.busy-dialog-box {
	background-color: var(--zk-form-color-transparent);
	padding: var(--zk-form-space-xl-plus); 
}
.busy-dialog-img {
	height: var(--zk-form-dimension-icon-md); 
	width: var(--zk-form-dimension-icon-md);
	background: var(--zk-form-color-transparent) no-repeat center;
	background-image: url(../images/progress3.gif) !important;
	display: -moz-inline-box; 
	vertical-align: top; 
	display: inline-block;
}
.busy-dialog-label {
	color: var(--zk-form-text-color-body);
}

<%-- status bar --%>
.status {
	width: var(--zk-form-size-full);
	height: var(--zk-form-size-29);
}
.status-db {
	white-space: nowrap;
	padding-top: var(--zk-form-space-0);
	padding-bottom: var(--zk-form-space-0);
	padding-left: var(--zk-form-space-lg);
	padding-right: var(--zk-form-space-lg);
	cursor: pointer;
	width: var(--zk-form-size-full);
	height: var(--zk-form-size-full);
	margin: var(--zk-form-space-0);
	border-left: solid var(--zk-form-size-1) var(--zk-form-color-border-accent);
	display: inline-block;
}
.status-info {
	padding-right: var(--zk-form-space-2xl);
	border-left: solid var(--zk-form-size-1) var(--zk-form-color-border-accent);
}

.status-selected{
	padding-right: var(--zk-form-space-lg);
	padding-right: var(--zk-form-space-lg);
	border-right: solid var(--zk-form-size-1) var(--zk-form-color-border-accent);
}

.status-border {
	border: solid var(--zk-form-size-1) var(--zk-form-color-border-accent);
}

<%-- report wizard --%>
.report-wizard-footer {
	width: var(--zk-form-size-full);
}

<%-- workflow activity --%>
.workflow-activity-form {
}
.workflow-panel-table {
	border: var(--zk-form-size-0);
}

<%-- payment form --%>
.payment-form-content {
}
