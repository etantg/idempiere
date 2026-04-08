<%-- popup window for toolbar report button --%>
.toolbar-popup-window {
	border-left: 1px solid var(--zk-color-border-strong);
	border-right: 1px solid var(--zk-color-border-strong);
}
.toolbar-popup-window .z-window-content {
	padding: 0px;
}
.toolbar-popup-window.z-window.z-window-noheader {
	padding: var(--zk-space-md);
	padding-bottom: 0px;
}
.toolbar-popup-window::before {
	border-bottom: 7px solid var(--zk-overlay-color-light);
	border-left: 7px solid transparent;
	border-right: 7px solid transparent;
	content: "";
	display: inline-block;
	left: var(--zk-space-xl-plus);
	position: absolute;
	top: -7px;
}
.toolbar-popup-window::after {
	border-bottom: 6px solid var(--zk-color-surface);
	border-left: 6px solid transparent;
	border-right: 6px solid transparent;
	content: "";
	display: inline-block;
	left: var(--zk-space-2xl);
	position: absolute;
	top: -6px;
}
.toolbar-popup-window .dialog-footer {
	padding: var(--zk-space-md);
}
