:root {
	--zk-parameter-color-surface: var(--zk-color-surface);
	--zk-parameter-dimension-dialog-md: var(--zk-dimension-dialog-md);
	--zk-parameter-dimension-panel-sm: var(--zk-dimension-panel-sm);
	--zk-parameter-line-height-normal: var(--zk-line-height-normal);
	--zk-parameter-overlay-color-light: var(--zk-overlay-color-light);
	--zk-parameter-size-1: var(--zk-size-1);
	--zk-parameter-size-180: var(--zk-size-180);
	--zk-parameter-size-25pct: var(--zk-size-25pct);
	--zk-parameter-size-2pct: var(--zk-size-2pct);
	--zk-parameter-size-2vh: var(--zk-size-2vh);
	--zk-parameter-size-300pt: var(--zk-size-300pt);
	--zk-parameter-size-5pct: var(--zk-size-5pct);
	--zk-parameter-size-70pct: var(--zk-size-70pct);
	--zk-parameter-size-8pct: var(--zk-size-8pct);
	--zk-parameter-size-90pct: var(--zk-size-90pct);
	--zk-parameter-size-full: var(--zk-size-full);
	--zk-parameter-space-0: var(--zk-space-0);
	--zk-parameter-space-2xl: var(--zk-space-2xl);
	--zk-parameter-space-md: var(--zk-space-md);
	--zk-parameter-space-xs: var(--zk-space-xs);
}

<%-- process modal dialog --%>
.process-modal-dialog {
	width: var(--zk-parameter-dimension-dialog-md);
}
.process-modal-dialog .main-parameter-layout{
	height: auto;
	flex-basis: auto;
}
.process-modal-dialog.z-window > .z-window-content {
	flex: 1 1 auto;
}
@media screen and (max-width: 600px) {
	.process-modal-dialog {
		width: var(--zk-parameter-size-full);
	}
}

.main-parameter-layout {
	height: var(--zk-parameter-size-full);
}
.main-parameter-layout,
.top-parameter-layout,
.bottom-parameter-layout,
.message-parameter-layout,
.input-paramenter-layout,
.option-paramenter-layout,
.report-option-container,
.bottom-container{
	width: var(--zk-parameter-size-full);
}
.report-option-container {
	display: flex;
    flex-wrap: wrap;
    flex-direction: row;
    align-items: center;
}

.report-option-container div {
    padding: var(--zk-parameter-space-xs);
}

/* Chromium based browsers + Safari */
@supports (not (-moz-appearance: none)) {
	.report-option-container {
		height: var(--zk-parameter-size-full) !important;
	}
}

<%-- process/report parameters --%>
.top-parameter-layout{
	overflow: auto;
	padding-bottom: var(--zk-parameter-size-2vh);
	flex-basis: auto;
}

<%-- run history and action buttons --%>
.bottom-parameter-layout{
	padding: var(--zk-parameter-space-md);
	border-top: var(--zk-parameter-size-1) solid var(--zk-parameter-overlay-color-light);
	overflow: visible;
}
.bottom-container{
	overflow: hidden;
}
.save-parameter-container{
	overflow-x: auto;
	overflow-y: hidden;
}
.button-container{
	float: right;
	overflow: hidden;
	padding: var(--zk-parameter-space-md);
}
@media screen and (max-width: 500px) {
	.save-parameter-container .saved-parameter-label {
		display: none;
	}
}
@media screen and (min-width: 501px) {
	.save-parameter-container .saved-parameter-list > input::-webkit-input-placeholder {
		color: var(--zk-parameter-color-surface);
	}
}
@media screen and (min-width: 501px) {
	.save-parameter-container .saved-parameter-list > input::-moz-placeholder {
		color: var(--zk-parameter-color-surface);
	}
}
@media screen and (min-width: 501px) {
	.save-parameter-container .saved-parameter-list > input::-ms-input-placeholder {
		color: var(--zk-parameter-color-surface);
	}
}

<%-- process help text --%>
.message-parameter{
	max-height: var(--zk-parameter-size-300pt); 
	overflow: auto; 
	margin: var(--zk-parameter-space-2xl);
	line-height: var(--zk-parameter-line-height-normal);
}

.message-parameter p {
	margin-bottom: var(--zk-parameter-space-2xl);
}

<%-- execution result panel --%>
.result-parameter-layout {
	overflow: auto;
}

<%-- process parameters --%>
.input-paramenter-layout{
	width: var(--zk-parameter-size-70pct);
	margin-left: var(--zk-parameter-size-5pct);
	margin-right: var(--zk-parameter-size-25pct);
}
@media screen and (max-width: 700px) {
	.input-paramenter-layout{
		width: var(--zk-parameter-size-90pct) !important;
		margin-left: var(--zk-parameter-size-2pct) !important;
		margin-right: var(--zk-parameter-size-8pct) !important;
	}
}
@media screen and (max-width: 500px) {
	.input-paramenter-layout{
		width: var(--zk-parameter-size-full) !important;
		margin-left: var(--zk-parameter-space-0) !important;
		margin-right: var(--zk-parameter-space-0) !important;
	}
}
.popup-dialog .input-paramenter-layout{
	width: var(--zk-parameter-size-90pct);
}
@media screen and (max-width: 500px) {
	.option-input-parameter.z-label.print-format-label,
	.option-input-parameter.z-label.view-report-label {
		display: none;
	}		
}
@media screen and (min-width: 501px) {
	.option-input-parameter.print-format-list > input::-webkit-input-placeholder {
		color: var(--zk-parameter-color-surface);
	}
}
@media screen and (min-width: 501px) {
	.option-input-parameter.print-format-list > input::-moz-placeholder {
		color: var(--zk-parameter-color-surface);
	}
}
@media screen and (min-width: 501px) {
	.option-input-parameter.print-format-list > input::-ms-input-placeholder {
		color: var(--zk-parameter-color-surface);
	}
}
@media screen and (max-width: 400px) {
	.option-input-parameter.print-format-list {
		width: var(--zk-parameter-size-180) !important;
	}
}
@media screen and (max-width: 320px) {
	.option-input-parameter.print-format-list {
		width: var(--zk-parameter-dimension-panel-sm) !important;
	}
}
