:root {
	--zk-window-border-none: var(--zk-border-none);
	--zk-window-color-panel-bg: var(--zk-color-panel-bg);
	--zk-window-color-primary-dark: var(--zk-color-primary-dark);
	--zk-window-color-surface: var(--zk-color-surface);
	--zk-window-color-transparent: var(--zk-color-transparent);
	--zk-window-dimension-control-lg: var(--zk-dimension-control-lg);
	--zk-window-dimension-control-sm: var(--zk-dimension-control-sm);
	--zk-window-dimension-dialog-md: var(--zk-dimension-dialog-md);
	--zk-window-dimension-dialog-sm: var(--zk-dimension-dialog-sm);
	--zk-window-font-weight-bold: var(--zk-font-weight-bold);
	--zk-window-radius-none: var(--zk-radius-none);
	--zk-window-size-1: var(--zk-size-1);
	--zk-window-size-2: var(--zk-size-2);
	--zk-window-size-77pct: var(--zk-size-77pct);
	--zk-window-size-98pct: var(--zk-size-98pct);
	--zk-window-size-99pct: var(--zk-size-99pct);
	--zk-window-size-full: var(--zk-size-full);
	--zk-window-space-0: var(--zk-space-0);
	--zk-window-space-2xl: var(--zk-space-2xl);
	--zk-window-space-3xl: var(--zk-space-3xl);
	--zk-window-space-4xl: var(--zk-space-4xl);
	--zk-window-space-5xl: var(--zk-space-5xl);
	--zk-window-space-lg: var(--zk-space-lg);
	--zk-window-space-lg-plus: var(--zk-space-lg-plus);
	--zk-window-space-md: var(--zk-space-md);
	--zk-window-space-sm: var(--zk-space-sm);
	--zk-window-space-xl: var(--zk-space-xl);
	--zk-window-space-xl-plus: var(--zk-space-xl-plus);
	--zk-window-text-color-dialog: var(--zk-text-color-dialog);
	--zk-window-text-color-readonly: var(--zk-text-color-readonly);
}

<%-- z-window customization --%>
div.wc-modal, div.wc-modal-none, div.wc-highlighted, div.wc-highlighted-none {
	background-color: var(--zk-window-color-surface);
}

.z-window {
	padding: var(--zk-window-space-0);
}
.z-window.z-window-noborder.z-window-noheader.z-window-embedded,
.z-window.z-window-noborder.z-window-noheader.z-window-embedded .z-window-content {
	height: var(--zk-window-size-full);
}

.z-window-embedded .z-window-header, 
.z-window-embedded .z-window-content {
	background-image: none;
}

.z-window-overlapped .z-window-content,  .z-window-modal .z-window-content, 
.z-window-highlighted .z-window-content, .z-window-embedded .z-window-content {
	border: var(--zk-window-border-none);
}

.z-window-header {
	padding: var(--zk-window-space-md) var(--zk-window-space-lg-plus) var(--zk-window-space-md) var(--zk-window-space-xl-plus);
}
.z-window-embedded > .z-window-header {
	border-radius: var(--zk-window-radius-none);
	background-color: var(--zk-window-color-transparent);
}
.z-window-overlapped .z-window-header,
.z-window-popup .z-window-header,
.z-window-modal .z-window-header,
.z-window-highlighted .z-window-header
{
	color: var(--zk-window-text-color-dialog);
	font-weight: var(--zk-window-font-weight-bold);
}

.z-window-overlapped, .z-window-popup, .z-window-modal, .z-window-highlighted 
{
	margin: var(--zk-window-space-0);
}

.z-window-modal-shadow, .z-window-overlapped-shadow, .z-window-popup-shadow, .z-window-embedded-shadow, .z-window-highlighted-shadow
{
	border-radius: var(--zk-window-radius-none) !important;
}

.z-modal-mask {
	z-index: 1800 !important;
}

<%-- dialog --%>
.embedded-dialog {
	position: absolute;
}
.embedded-dialog .z-window-embedded-header {
	color: var(--zk-window-color-surface);
	font-weight: var(--zk-window-font-weight-bold);
}
.embedded-dialog .z-window-embedded
{
	margin: var(--zk-window-space-0);
}

.popup-dialog .z-window-overlapped .z-window-content, .popup-dialog .z-window-highlighted .z-window-content {
	padding: var(--zk-window-space-0);
}
.popup-dialog > .z-window-content, .info-panel > .z-window-content {
	padding: var(--zk-window-space-0);
}
.popup-dialog .dialog-content {
	padding: var(--zk-window-space-xl) !important;
	margin-bottom: var(--zk-window-space-5xl) !important;
}

.popup-dialog.z-window-overlapped .dialog-footer {
	padding: var(--zk-window-space-3xl) var(--zk-window-space-4xl) var(--zk-window-space-xl) var(--zk-window-space-4xl) !important;
}

.popup-dialog.z-window-highlighted .dialog-footer {
	padding: var(--zk-window-space-3xl) var(--zk-window-space-4xl) var(--zk-window-space-xl) var(--zk-window-space-4xl) !important;
}
.popup-dialog.z-window.z-window-overlapped.z-window-shadow,
.popup-dialog.z-window.z-window-noborder.z-window-highlighted.z-window-shadow{
	width:var(--zk-window-dimension-dialog-md);
}
@media screen and (max-width: 600px) {
	.popup-dialog.z-window.z-window-overlapped.z-window-shadow,
	.popup-dialog.z-window.z-window-noborder.z-window-highlighted.z-window-shadow{
		width:var(--zk-window-size-full);
	}	
}

.dialog-footer {
	margin-bottom: var(--zk-window-space-0);
	background-color: var(--zk-window-color-panel-bg);
	border-top: var(--zk-window-size-1) solid transparent;
	-webkit-box-shadow: inset 0 var(--zk-window-size-1) 0 var(--zk-window-color-surface);
	-moz-box-shadow: inset 0 var(--zk-window-size-1) 0 var(--zk-window-color-surface);
	box-shadow: inset 0 var(--zk-window-size-1) 0 var(--zk-window-color-surface);
}

<%-- notification message --%>
.z-notification .z-notification-content {
    width: var(--zk-window-dimension-dialog-sm);
}
.z-notification {
	padding: var(--zk-window-space-sm) !important;
}
.z-notification-info .z-notification-left {
  border-right-color: var(--zk-window-color-transparent);
}
.z-notification-left + .z-notification-icon {
  left: var(--zk-window-space-3xl);
}

<%-- Quick Form Read-only Component --%>
.quickform-readonly .z-textbox-readonly, .quickform-readonly .z-intbox-readonly, .quickform-readonly .z-longbox-readonly, .quickform-readonly .z-doublebox-readonly,
.quickform-readonly .z-decimalbox-readonly, .quickform-readonly .z-datebox-readonly, .quickform-readonly .z-timebox-readonly, .quickform-readonly .editor-input-disd,
.quickform-readonly .z-textbox[readonly], .quickform-readonly .z-intbox[readonly], .quickform-readonly .z-longbox[readonly], .quickform-readonly .z-doublebox[readonly],
.quickform-readonly .z-decimalbox[readonly], .quickform-readonly .z-datebox[readonly], .quickform-readonly .z-timebox[readonly]
{
    color: var(--zk-window-text-color-readonly) !important;
    opacity: .8;
}
<%-- quick entry form --%>
.quick-form.z-window .z-center-body > .z-div {
	border: var(--zk-window-border-none); 
	width: var(--zk-window-size-full); 
	height:var(--zk-window-size-99pct);
}
.quick-form.z-window .adtab-grid.z-row .z-cell {
	border-top: var(--zk-window-size-2) solid transparent; 
	border-bottom: var(--zk-window-size-2) solid transparent;
}
.quick-form.z-window .adtab-grid.z-row.current-row .z-cell {
	border-top: var(--zk-window-size-2) solid var(--zk-window-color-primary-dark) !important; 
	border-bottom: var(--zk-window-size-2) solid var(--zk-window-color-primary-dark) !important;
}
.quick-form.z-window .z-south-body > .z-div > .z-div {
	height: var(--zk-window-dimension-control-sm); 
}
.quick-form.z-window .z-south-body .confirm-panel {
	padding-top: var(--zk-window-space-xl-plus); 
}

<%-- record id editor dialog --%>
.recordid-dialog {
	min-width: var(--zk-window-dimension-dialog-sm);
}
.recordid-dialog-content {
	display: flex;
	padding: var(--zk-window-space-2xl);
}
.recordid-dialog-labels {
	display: grid;
    text-align: right;
    align-items: center;
}
.recordid-dialog-fields {
	display: grid;
	width: var(--zk-window-size-77pct);
}
.recordid-dialog-fields .editor-button {
	top: var(--zk-window-space-xl) !important;
}
.recordid-dialog-content .z-combobox, .recordid-dialog-content .z-textbox {
	width: var(--zk-window-size-98pct) !important;
	margin: var(--zk-window-space-xl) var(--zk-window-space-lg);
}
.recordid-dialog-confirm {
	text-align: end;
    padding: var(--zk-window-space-2xl);
}
.recordid-dialog-confirm .z-button {
	margin: var(--zk-window-space-0) var(--zk-window-space-lg) !important;
	height: var(--zk-window-dimension-control-lg);
	padding: var(--zk-window-space-0) var(--zk-window-space-2xl);
}

.attachment-dialog .z-north {
	padding: var(--zk-window-space-xl);
}
