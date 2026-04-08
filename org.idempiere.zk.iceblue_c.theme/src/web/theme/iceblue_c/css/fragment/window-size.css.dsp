:root {
	--zk-window-size-dimension-dialog-md: var(--zk-dimension-dialog-md);
	--zk-window-size-dimension-dialog-sm: var(--zk-dimension-dialog-sm);
	--zk-window-size-size-1000: var(--zk-size-1000);
	--zk-window-size-size-260: var(--zk-size-260);
	--zk-window-size-size-350: var(--zk-size-350);
	--zk-window-size-size-380: var(--zk-size-380);
	--zk-window-size-size-410: var(--zk-size-410);
	--zk-window-size-size-420: var(--zk-size-420);
	--zk-window-size-size-450: var(--zk-size-450);
	--zk-window-size-size-480: var(--zk-size-480);
	--zk-window-size-size-500: var(--zk-size-500);
	--zk-window-size-size-540: var(--zk-size-540);
	--zk-window-size-size-550: var(--zk-size-550);
	--zk-window-size-size-640: var(--zk-size-640);
	--zk-window-size-size-700: var(--zk-size-700);
	--zk-window-size-size-750: var(--zk-size-750);
	--zk-window-size-size-800: var(--zk-size-800);
	--zk-window-size-size-80pct: var(--zk-size-80pct);
	--zk-window-size-size-85pct: var(--zk-size-85pct);
	--zk-window-size-size-88pct: var(--zk-size-88pct);
	--zk-window-size-size-900: var(--zk-size-900);
	--zk-window-size-size-full: var(--zk-size-full);
	--zk-window-size-space-md: var(--zk-space-md);
	--zk-window-size-space-xl: var(--zk-space-xl);
}

.about-window {
	width: var(--zk-window-size-size-800);
	height: var(--zk-window-size-dimension-dialog-md);
}
@media screen and (max-width: 375px) {
	.about-window {
		width: var(--zk-window-size-size-full);
	}
}
@media screen and (max-height: 600px) {
	.about-window {
		height: var(--zk-window-size-size-full);
	}
}

.customize-grid-view-dialog {
	width: var(--zk-window-size-dimension-dialog-md);
	height: var(--zk-window-size-size-500);
}
@media screen and (max-width: 600px) {
	.customize-grid-view-dialog {
		width: var(--zk-window-size-size-full);
	}
}
@media screen and (max-height: 500px) {
	.customize-grid-view-dialog {
		height: var(--zk-window-size-size-full);
	}
}

.attachment-dialog.popup-dialog.z-window.z-window-overlapped {
	width: var(--zk-window-size-size-700);
	height: var(--zk-window-size-size-85pct);
}
@media screen and (max-width: 700px) {
	.attachment-dialog.popup-dialog.z-window.z-window-overlapped {
		width: var(--zk-window-size-size-full);
	}
}
@media screen and (max-height: 600px) {
	.attachment-dialog.popup-dialog.z-window.z-window-overlapped {
		height: var(--zk-window-size-size-full);
	}
}

.chat-dialog.popup-dialog.z-window.z-window-overlapped {
	height: var(--zk-window-size-size-88pct);
	width: var(--zk-window-size-size-500);
}
@media screen and (max-width: 500px) {
	.chat-dialog.popup-dialog.z-window.z-window-overlapped {
		width: var(--zk-window-size-size-full);
	}
}
@media screen and (max-height: 600px) {
	.chat-dialog.popup-dialog.z-window.z-window-overlapped {
		height: var(--zk-window-size-size-full);
	}
}

.email-dialog {
	height: var(--zk-window-size-size-80pct);
	width: var(--zk-window-size-size-80pct);
}
@media screen and (max-width: 600px) {
	.email-dialog {
		width: var(--zk-window-size-size-full);
	}
}
@media screen and (max-height: 600px) {
	.email-dialog {
		height: var(--zk-window-size-size-full);
	}
}

.field-record-info-dialog {
	width: var(--zk-window-size-size-640);
	height: var(--zk-window-size-size-480);
}
@media screen and (max-width: 640px) {
	.field-record-info-dialog {
		width: var(--zk-window-size-size-full);
	}
}
@media screen and (max-height: 480px) {
	.field-record-info-dialog {
		height: var(--zk-window-size-size-full);
	}
}	

.record-info-dialog {
	width: var(--zk-window-size-size-800);
	height: var(--zk-window-size-dimension-dialog-md);
}
@media screen and (max-width: 800px) {
	.record-info-dialog {
		width: var(--zk-window-size-size-full);
	}
}
@media screen and (max-height: 600px) {
	.record-info-dialog {
		height: var(--zk-window-size-size-full);
	}
}

.value-preference-dialog {
	width: var(--zk-window-size-size-500);
}
@media screen and (max-width: 500px) {
	.value-preference-dialog {
		width: var(--zk-window-size-size-full);
	}
}

.pattribute-dialog {
	width: var(--zk-window-size-size-500);
}
@media screen and (max-width: 500px) {
	.pattribute-dialog {
		width: var(--zk-window-size-size-full);
	}
}

.pattribute-instance-dialog {
	width: var(--zk-window-size-size-1000);
	height: var(--zk-window-size-size-550);
}
@media screen and (max-width: 1000px) {
	.pattribute-instance-dialog {
		width: var(--zk-window-size-size-full);
	}
}
@media screen and (max-height: 550px) {
	.pattribute-instance-dialog {
		height: var(--zk-window-size-size-full);
	}
}

.account-dialog {
	height: var(--zk-window-size-size-500);
	width: var(--zk-window-size-size-750);
}
@media screen and (max-width: 750px) {
	.account-dialog {
		width: var(--zk-window-size-size-full);
	}
}
@media screen and (max-height: 500px) {
	.account-dialog {
		height: var(--zk-window-size-size-full);
	}
}
@media screen and (max-width: 719px) {
	.account-dialog {
		height: var(--zk-window-size-size-full);
	}
}

.invoice-history-dialog {
	width: var(--zk-window-size-size-700);
	height: var(--zk-window-size-size-500);
}
@media screen and (max-width: 700px) {
	.invoice-history-dialog {
		width: var(--zk-window-size-size-full);
	}
}
@media screen and (max-height: 500px) {
	.invoice-history-dialog {
		height: var(--zk-window-size-size-full);
	}
}

.create-from-window {
	width: var(--zk-window-size-size-750);
	height: var(--zk-window-size-size-550);
}
@media screen and (max-width: 750px) {
	.create-from-window {
		width: var(--zk-window-size-size-full);
	}
}
@media screen and (max-height: 550px) {
	.create-from-window {
		height: var(--zk-window-size-size-full);
	}
}

.create-from-form {
	width: var(--zk-window-size-size-750);
	height: var(--zk-window-size-size-550);
}
@media screen and (max-width: 750px) {
	.create-from-form {
		width: var(--zk-window-size-size-full);
	}
}
@media screen and (max-height: 550px) {
	.create-from-form {
		height: var(--zk-window-size-size-full);
	}
}

.payment-form-dialog {
	width: var(--zk-window-size-size-500);
}
@media screen and (max-width: 500px) {
	.payment-form-dialog {
		width: var(--zk-window-size-size-full);
	}
}

.process-parameter-form-dialog {
	width: var(--zk-window-size-size-500);
}
@media screen and (max-width: 500px) {
	.process-parameter-form-dialog {
		width: var(--zk-window-size-size-full);
	}
}

.quick-entry-dialog {
	width: var(--zk-window-size-size-350);
}
.quick-entry-dialog > .z-window-content {
	overflow: auto;
	padding: var(--zk-window-size-space-md);	
}
.quick-entry-dialog > .z-window-content > .confirm-panel {
	padding-top: var(--zk-window-size-space-md);
}
@media screen and (max-width: 350px) {
	.quick-entry-dialog {
		width: var(--zk-window-size-size-full);
	}
}
@media screen and (max-height: 500px) {
	.quick-entry-dialog {
		height: var(--zk-window-size-size-full);
	}
}

.feedback-request-dialog {
	width: var(--zk-window-size-dimension-dialog-sm);
	height: var(--zk-window-size-dimension-dialog-md);
}
@media screen and (max-width: 400px) {
	.feedback-request-dialog {
		width: var(--zk-window-size-size-full);
	}
}
@media screen and (max-height: 600px) {
	.feedback-request-dialog {
		height: var(--zk-window-size-size-full);
	}
}

.request-dialog {
	width: var(--zk-window-size-dimension-dialog-sm);
	height: var(--zk-window-size-size-550);
}
@media screen and (max-width: 400px) {
	.request-dialog {
		width: var(--zk-window-size-size-full);
	}
}
@media screen and (max-height: 550px) {
	.request-dialog {
		height: var(--zk-window-size-size-full);
	}
}

.image-dialog {
	width: var(--zk-window-size-size-640);
	height: var(--zk-window-size-size-540);
}
@media screen and (max-width: 640px) {
	.image-dialog {
		width: var(--zk-window-size-size-full);
	}
}
@media screen and (max-height: 540px) {
	.image-dialog {
		height: var(--zk-window-size-size-full);
	}
}

.doc-action-dialog {
	width: var(--zk-window-size-size-410);
}
@media screen and (max-width: 410px) {
	.doc-action-dialog {
		width: var(--zk-window-size-size-full);
	}
}

.assignment-dialog {
	width: var(--zk-window-size-dimension-dialog-md);
}
@media screen and (max-width: 600px) {
	.assignment-dialog {
		width: var(--zk-window-size-size-full);
	}
}

.location-dialog {
	height: var(--zk-window-size-size-420);
}
.location-dialog > .z-window-content > .z-borderlayout {
	min-width: var(--zk-window-size-size-380);
}
.location-dialog .field-label {
	white-space: nowrap;
}
.location-dialog .confirm-panel {
	padding: var(--zk-window-size-space-md) var(--zk-window-size-space-xl);
}
@media screen and (max-width: 380px) {
	.location-dialog {
		width: var(--zk-window-size-size-full);
	}
}
@media screen and (max-height: 420px) {
	.location-dialog {
		height: var(--zk-window-size-size-full);
	}
}

.locator-dialog {
	width: var(--zk-window-size-size-260);
	height: var(--zk-window-size-size-350);
}
@media screen and (max-width: 260px) {
	.locator-dialog {
		width: var(--zk-window-size-size-full);
	}
}
@media screen and (max-height: 350px) {
	.locator-dialog {
		height: var(--zk-window-size-size-full);
	}
}

.media-dialog {
	width: var(--zk-window-size-size-500);
	height: var(--zk-window-size-size-500);
}
@media screen and (max-width: 500px) {
	.media-dialog {
		width: var(--zk-window-size-size-full);
	}
}
@media screen and (max-height: 500px) {
	.media-dialog {
		height: var(--zk-window-size-size-full);
	}
}

.text-editor-dialog {
	width: var(--zk-window-size-size-800);
	height: var(--zk-window-size-size-450);
}
@media screen and (max-width: 800px) {
	.text-editor-dialog {
		width: var(--zk-window-size-size-full);
	}
}
@media screen and (max-height: 450px) {
	.text-editor-dialog {
		height: var(--zk-window-size-size-full);
	}
}

.create-from-bank-statement.create-from-window {
	width: var(--zk-window-size-size-900);
	height: var(--zk-window-size-size-800);
}
@media screen and (max-width: 900px) {
	.create-from-bank-statement.create-from-window {
		width: var(--zk-window-size-size-full);
	}
}
@media screen and (max-height: 800px) {
	.create-from-bank-statement.create-from-window {
		height: var(--zk-window-size-size-full);
	}
}

.chosenbox-assistant-dialog {
	height: var(--zk-window-size-dimension-dialog-md);
	width: var(--zk-window-size-size-700);
}
@media screen and (max-width: 500px) {
	.chosenbox-assistant-dialog {
		width: var(--zk-window-size-size-full);
	}
}
@media screen and (max-height: 500px) {
	.chosenbox-assistant-dialog {
		height: var(--zk-window-size-size-full);
	}
}
