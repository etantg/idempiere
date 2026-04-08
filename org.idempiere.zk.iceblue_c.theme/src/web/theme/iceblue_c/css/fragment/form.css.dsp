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
    font-weight: var(--zk-font-weight-normal);
    font-size: smaller !important;
}
td.form-label-above-input.z-cell {
    padding-top: var(--zk-space-lg);
    padding-bottom: var(--zk-space-lg);
}
td.form-label-above-input.login-label {
    text-align: left;
}
td.form-label-above-input.login-label .z-label,
.form-label-above-input .idempiere-label.z-label {
    font-weight: var(--zk-font-weight-normal);
    font-size: smaller !important;
}
.form-label-above-input.z-window .login-box-body,
.form-label-above-input.adwindow-form,
.form-label-above-input.input-paramenter-layout {
    padding-left: 1em !important;
    padding-right: 1em !important;
}

.form-button {
	width: 99%;
}
.form-button img {
	width: var(--zk-dimension-icon-md);
	height: var(--zk-dimension-icon-md);
}

<%-- confirm panel --%>
.confirm-panel {
	width: auto;
	height: auto;
	position: relative;
	padding-left: var(--zk-space-xs);
	padding-right: var(--zk-space-xs);
}
.confirm-panel-right {
	float: right;
	padding: var(--zk-space-2xs);
}
.confirm-panel-left {
	float: left;
}
.confirm-panel-center{
	padding-left: var(--zk-space-lg);
	float: left;
}

<%-- busy dialog --%>
.busy-dialog {
	cursor: wait;
	background-color: transparent;
}
.busy-dialog-box {
	background-color: transparent;
	padding: var(--zk-space-xl-plus); 
}
.busy-dialog-img {
	height: var(--zk-dimension-icon-md); 
	width: var(--zk-dimension-icon-md);
	background: transparent no-repeat center;
	background-image: url(../images/progress3.gif) !important;
	display: -moz-inline-box; 
	vertical-align: top; 
	display: inline-block;
}
.busy-dialog-label {
	color: var(--zk-text-color-body);
}

<%-- status bar --%>
.status {
	width: 100%;
	height: 29px;
}
.status-db {
	white-space: nowrap;
	padding-top: 0;
	padding-bottom: 0;
	padding-left: var(--zk-space-lg);
	padding-right: var(--zk-space-lg);
	cursor: pointer;
	width: 100%;
	height: 100%;
	margin: 0;
	border-left: solid 1px var(--zk-color-border-accent);
	display: inline-block;
}
.status-info {
	padding-right: var(--zk-space-2xl);
	border-left: solid 1px var(--zk-color-border-accent);
}

.status-selected{
	padding-right: var(--zk-space-lg);
	border-right: solid 1px var(--zk-color-border-accent);
}

.status-border {
	border: solid 1px var(--zk-color-border-accent);
}

<%-- report wizard --%>
.report-wizard-footer {
	width: 100%;
}

<%-- workflow activity --%>
.workflow-activity-form {
}
.workflow-panel-table {
	border: 0px;
}

<%-- payment form --%>
.payment-form-content {
}
