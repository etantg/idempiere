:root {
	--zk-toolbar-popup-side-border: var(--zk-size-1) solid var(--zk-color-border-strong);
	--zk-toolbar-popup-content-padding: var(--zk-space-0);
	--zk-toolbar-popup-window-padding: var(--zk-space-md);
	--zk-toolbar-popup-window-padding-bottom: var(--zk-space-0);
	--zk-toolbar-popup-arrow-outer-border: var(--zk-size-7) solid var(--zk-overlay-color-light);
	--zk-toolbar-popup-arrow-outer-border-inline-start: var(--zk-size-7) solid transparent;
	--zk-toolbar-popup-arrow-outer-border-inline-end: var(--zk-size-7) solid transparent;
	--zk-toolbar-popup-arrow-outer-inline-start: var(--zk-space-xl-plus);
	--zk-toolbar-popup-arrow-outer-block-start: var(--zk-size-neg-7);
	--zk-toolbar-popup-arrow-inner-border: var(--zk-size-6) solid var(--zk-color-surface);
	--zk-toolbar-popup-arrow-inner-border-inline-start: var(--zk-size-6) solid transparent;
	--zk-toolbar-popup-arrow-inner-border-inline-end: var(--zk-size-6) solid transparent;
	--zk-toolbar-popup-arrow-inner-inline-start: var(--zk-space-2xl);
	--zk-toolbar-popup-arrow-inner-block-start: var(--zk-size-neg-6);
	--zk-toolbar-popup-footer-padding: var(--zk-space-md);
}

<%-- popup window for toolbar report button --%>
.toolbar-popup-window {
	border-left: var(--zk-toolbar-popup-side-border);
	border-right: var(--zk-toolbar-popup-side-border);
}
.toolbar-popup-window .z-window-content {
	padding: var(--zk-toolbar-popup-content-padding);
}
.toolbar-popup-window.z-window.z-window-noheader {
	padding: var(--zk-toolbar-popup-window-padding);
	padding-bottom: var(--zk-toolbar-popup-window-padding-bottom);
}
.toolbar-popup-window::before {
	border-bottom: var(--zk-toolbar-popup-arrow-outer-border);
	border-left: var(--zk-toolbar-popup-arrow-outer-border-inline-start);
	border-right: var(--zk-toolbar-popup-arrow-outer-border-inline-end);
	content: "";
	display: inline-block;
	left: var(--zk-toolbar-popup-arrow-outer-inline-start);
	position: absolute;
	top: var(--zk-toolbar-popup-arrow-outer-block-start);
}
.toolbar-popup-window::after {
	border-bottom: var(--zk-toolbar-popup-arrow-inner-border);
	border-left: var(--zk-toolbar-popup-arrow-inner-border-inline-start);
	border-right: var(--zk-toolbar-popup-arrow-inner-border-inline-end);
	content: "";
	display: inline-block;
	left: var(--zk-toolbar-popup-arrow-inner-inline-start);
	position: absolute;
	top: var(--zk-toolbar-popup-arrow-inner-block-start);
}
.toolbar-popup-window .dialog-footer {
	padding: var(--zk-toolbar-popup-footer-padding);
}
