<%-- z-window customization --%>
div.wc-modal, div.wc-modal-none, div.wc-highlighted, div.wc-highlighted-none {
	background-color: var(--zk-color-surface);
}

.z-window {
	padding: 0px;
}
.z-window.z-window-noborder.z-window-noheader.z-window-embedded,
.z-window.z-window-noborder.z-window-noheader.z-window-embedded .z-window-content {
	height: 100%;
}

.z-window-embedded .z-window-header, 
.z-window-embedded .z-window-content {
	background-image: none;
}

.z-window-overlapped .z-window-content,  .z-window-modal .z-window-content, 
.z-window-highlighted .z-window-content, .z-window-embedded .z-window-content {
	border: none;
}

.z-window-header {
	padding: var(--zk-space-md) var(--zk-space-lg-plus) var(--zk-space-md) var(--zk-space-xl-plus);
}
.z-window-embedded > .z-window-header {
	border-radius: 0px;
	background-color: transparent;
}
.z-window-overlapped .z-window-header,
.z-window-popup .z-window-header,
.z-window-modal .z-window-header,
.z-window-highlighted .z-window-header
{
	color: var(--zk-text-color-dialog);
	font-weight: var(--zk-font-weight-bold);
}

.z-window-overlapped, .z-window-popup, .z-window-modal, .z-window-highlighted 
{
	margin: 0px;
}

.z-window-modal-shadow, .z-window-overlapped-shadow, .z-window-popup-shadow, .z-window-embedded-shadow, .z-window-highlighted-shadow
{
	border-radius: 0px !important;
}

.z-modal-mask {
	z-index: 1800 !important;
}

<%-- dialog --%>
.embedded-dialog {
	position: absolute;
}
.embedded-dialog .z-window-embedded-header {
	color: var(--zk-color-surface);
	font-weight: var(--zk-font-weight-bold);
}
.embedded-dialog .z-window-embedded
{
	margin: 0px;
}

.popup-dialog .z-window-overlapped .z-window-content, .popup-dialog .z-window-highlighted .z-window-content {
	padding: 0px;
}
.popup-dialog > .z-window-content, .info-panel > .z-window-content {
	padding: 0px;
}
.popup-dialog .dialog-content {
	padding: var(--zk-space-xl) !important;
	--margin-bottom: var(--zk-space-5xl) !important;
}

.popup-dialog.z-window-overlapped .dialog-footer {
	padding: var(--zk-space-3xl) var(--zk-space-4xl) var(--zk-space-xl) var(--zk-space-4xl) !important;
}

.popup-dialog.z-window-highlighted .dialog-footer {
	padding: var(--zk-space-3xl) var(--zk-space-4xl) var(--zk-space-xl) var(--zk-space-4xl) !important;
}
.popup-dialog.z-window.z-window-overlapped.z-window-shadow,
.popup-dialog.z-window.z-window-noborder.z-window-highlighted.z-window-shadow{
	width:var(--zk-dimension-dialog-md);
}
@media screen and (max-width: 600px) {
	.popup-dialog.z-window.z-window-overlapped.z-window-shadow,
	.popup-dialog.z-window.z-window-noborder.z-window-highlighted.z-window-shadow{
		width:100%;
	}	
}

.dialog-footer {
	margin-bottom: 0;
	background-color: var(--zk-color-panel-bg);
	border-top: 1px solid transparent;
	-webkit-box-shadow: inset 0 1px 0 var(--zk-color-surface);
	-moz-box-shadow: inset 0 1px 0 var(--zk-color-surface);
	box-shadow: inset 0 1px 0 var(--zk-color-surface);
}

<%-- notification message --%>
.z-notification .z-notification-content {
    width: var(--zk-dimension-dialog-sm);
}
.z-notification {
	padding: var(--zk-space-sm) !important;
}
.z-notification-info .z-notification-left {
  border-right-color: transparent;
}
.z-notification-left + .z-notification-icon {
  left: var(--zk-space-3xl);
}

<%-- Quick Form Read-only Component --%>
.quickform-readonly .z-textbox-readonly, .quickform-readonly .z-intbox-readonly, .quickform-readonly .z-longbox-readonly, .quickform-readonly .z-doublebox-readonly,
.quickform-readonly .z-decimalbox-readonly, .quickform-readonly .z-datebox-readonly, .quickform-readonly .z-timebox-readonly, .quickform-readonly .editor-input-disd,
.quickform-readonly .z-textbox[readonly], .quickform-readonly .z-intbox[readonly], .quickform-readonly .z-longbox[readonly], .quickform-readonly .z-doublebox[readonly],
.quickform-readonly .z-decimalbox[readonly], .quickform-readonly .z-datebox[readonly], .quickform-readonly .z-timebox[readonly]
{
    color: var(--zk-text-color-readonly) !important;
    opacity: .8;
}
<%-- quick entry form --%>
.quick-form.z-window .z-center-body > .z-div {
	border: none; 
	width: 100%; 
	height:99%;
}
.quick-form.z-window .adtab-grid.z-row .z-cell {
	border-top: 2px solid transparent; 
	border-bottom: 2px solid transparent;
}
.quick-form.z-window .adtab-grid.z-row.current-row .z-cell {
	border-top: 2px solid var(--zk-color-primary-dark) !important; 
	border-bottom: 2px solid var(--zk-color-primary-dark) !important;
}
.quick-form.z-window .z-south-body > .z-div > .z-div {
	height: var(--zk-dimension-control-sm); 
}
.quick-form.z-window .z-south-body .confirm-panel {
	padding-top: var(--zk-space-xl-plus); 
}

<%-- record id editor dialog --%>
.recordid-dialog {
	min-width: var(--zk-dimension-dialog-sm);
}
.recordid-dialog-content {
	display: flex;
	padding: var(--zk-space-2xl);
}
.recordid-dialog-labels {
	display: grid;
    text-align: right;
    align-items: center;
}
.recordid-dialog-fields {
	display: grid;
	width: 77%;
}
.recordid-dialog-fields .editor-button {
	top: var(--zk-space-xl) !important;
}
.recordid-dialog-content .z-combobox, .recordid-dialog-content .z-textbox {
	width: 98% !important;
	margin: var(--zk-space-xl) var(--zk-space-lg);
}
.recordid-dialog-confirm {
	text-align: end;
    padding: var(--zk-space-2xl);
}
.recordid-dialog-confirm .z-button {
	margin: 0px var(--zk-space-lg) !important;
	height: var(--zk-dimension-control-lg);
	padding: 0px var(--zk-space-2xl);
}

.attachment-dialog .z-north {
	padding: var(--zk-space-xl);
}
