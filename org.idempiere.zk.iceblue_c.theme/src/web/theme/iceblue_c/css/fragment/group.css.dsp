tr.z-group {
	background: var(--zk-color-group-bg) repeat-x 0 0;
}

.z-group-header .z-label {
	color: var(--zk-text-color-brand-muted);
	width: auto;
	font-weight: var(--zk-font-weight-bold);
	font-size: var(--zk-font-size-sm);
}

.z-group td.z-group-inner {
	overflow: hidden !important;
	border-bottom: 1px solid var(--zk-text-color-brand-muted) !important;
	border-top: 0px !important;
	padding: var(--zk-space-2xs) var(--zk-space-xs);
	background: var(--zk-color-surface) !important;
}
.mobile .z-group td.z-group-inner {
    padding: var(--zk-space-xl) var(--zk-space-xs);
}
.mobile .z-group td.z-group-inner .z-group-icon {
    height: var(--zk-dimension-control-md);
    line-height: var(--zk-line-height-lg);
    font-size: var(--zk-font-size-2xl);
}
.mobile .z-group td.z-group-inner .z-label {
    line-height: var(--zk-line-height-lg);
}

.z-group-icon {
	display: inline-block;
	font-family: var(--zk-font-family-icon);
	font-weight: var(--zk-font-weight-normal);
	font-style: normal;
	-webkit-font-smoothing: antialiased;
	-moz-osx-font-smoothing: grayscale;
}
.z-group-icon-close:before {
	content: "\f0da";
	font-weight: var(--zk-font-weight-bolder);
}
.z-group-icon-open:before {
	content: "\f0d7";
	font-weight: var(--zk-font-weight-bolder);
}

div.z-listbox-body .z-listgroup-header {
	padding-top: var(--zk-space-md);
    padding-bottom: var(--zk-space-md);
    border-bottom: 1px solid var(--zk-color-border-group);
}
.z-listgroup-header-content > .z-listitem-checkable.z-listitem-checkbox {
	display: none;
}
.z-listgroup-icon {
	display: inline-block;
	font-weight: var(--zk-font-weight-bold);
	font-style: normal;
	height: 22px;
	width: 22px;
	font-size: var(--zk-font-size-xl);
	padding-top: var(--zk-space-xs);
}
.z-icon-listgroup-close::before {
	content: "\f105";
}
.z-icon-listgroup-open::before {
	content: "\f107";
}
