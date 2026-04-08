:root {
	--zk-info-border-none: var(--zk-border-none);
	--zk-info-color-window-muted: var(--zk-color-window-muted);
	--zk-info-size-50pct: var(--zk-size-50pct);
	--zk-info-size-99pct: var(--zk-size-99pct);
	--zk-info-space-0: var(--zk-space-0);
	--zk-info-space-xs: var(--zk-space-xs);
}

.info-panel .z-window-overlapped, .info-panel .z-window-highlighted {
	background-color: var(--zk-info-color-window-muted) !important;
}
.info-panel .z-window-highlighted .z-window-content {
	padding: var(--zk-info-space-0);
}
.info-panel.z-window .z-borderlayout > div > .z-north {
	max-height: var(--zk-info-size-50pct);
}

.info-panel .z-grid {
	border: var(--zk-info-border-none) !important;
}

.info-panel .z-listbox {
	width: var(--zk-info-size-99pct) !important;
	position: relative;
	margin: auto;
}
.info-panel .z-listheader > .z-listheader-content {
	white-space: pre-line;
	text-overflow: ellipsis;
}

.info-panel .z-south {
	margin-top: var(--zk-info-space-xs);
}

.info-panel .statusBar > div > .z-west,  .info-panel .statusBar > div > .z-east {
	border: var(--zk-info-border-none);
}
