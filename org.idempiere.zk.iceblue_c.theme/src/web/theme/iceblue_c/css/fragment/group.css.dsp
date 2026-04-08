:root {
	--zk-group-row-bg: var(--zk-color-group-bg);
	--zk-group-header-text-color: var(--zk-text-color-brand-muted);
	--zk-group-header-label-width: auto;
	--zk-group-header-font-weight: var(--zk-font-weight-bold);
	--zk-group-header-font-size: var(--zk-font-size-sm);
	--zk-group-inner-border-bottom: var(--zk-size-1) solid var(--zk-text-color-brand-muted);
	--zk-group-inner-border-top: var(--zk-size-0);
	--zk-group-inner-bg: var(--zk-color-surface);
	--zk-group-inner-padding: var(--zk-space-2xs) var(--zk-space-xs);
	--zk-group-inner-mobile-padding: var(--zk-space-xl) var(--zk-space-xs);
	--zk-group-mobile-icon-height: var(--zk-dimension-control-md);
	--zk-group-mobile-line-height: var(--zk-line-height-lg);
	--zk-group-mobile-icon-font-size: var(--zk-font-size-2xl);
	--zk-group-icon-font-family: var(--zk-font-family-icon);
	--zk-group-icon-font-weight: var(--zk-font-weight-normal);
	--zk-group-icon-font-style: var(--zk-font-style-normal);
	--zk-group-icon-expanded-font-weight: var(--zk-font-weight-900);
	--zk-group-list-header-padding-block: var(--zk-space-md);
	--zk-group-list-header-border-bottom: var(--zk-size-1) solid var(--zk-color-border-group);
	--zk-group-list-icon-font-weight: var(--zk-font-weight-bold);
	--zk-group-list-icon-font-style: var(--zk-font-style-normal);
	--zk-group-list-icon-height: var(--zk-size-22);
	--zk-group-list-icon-width: var(--zk-size-22);
	--zk-group-list-icon-font-size: var(--zk-font-size-xl);
	--zk-group-list-icon-padding-block-start: var(--zk-space-xs);
}

tr.z-group {
	background: var(--zk-group-row-bg) repeat-x 0 0;
}

.z-group-header .z-label {
	color: var(--zk-group-header-text-color);
	width: var(--zk-group-header-label-width);
	font-weight: var(--zk-group-header-font-weight);
	font-size: var(--zk-group-header-font-size);
}

.z-group td.z-group-inner {
	overflow: hidden !important;
	border-bottom: var(--zk-group-inner-border-bottom) !important;
	border-top: var(--zk-group-inner-border-top) !important;
	padding: var(--zk-group-inner-padding);
	background: var(--zk-group-inner-bg) !important;
}
.mobile .z-group td.z-group-inner {
    padding: var(--zk-group-inner-mobile-padding);
}
.mobile .z-group td.z-group-inner .z-group-icon {
	height: var(--zk-group-mobile-icon-height);
    line-height: var(--zk-group-mobile-line-height);
	font-size: var(--zk-group-mobile-icon-font-size);
}
.mobile .z-group td.z-group-inner .z-label {
    line-height: var(--zk-group-mobile-line-height);
}

.z-group-icon {
	display: inline-block;
	font-family: var(--zk-group-icon-font-family);
	font-weight: var(--zk-group-icon-font-weight);
	font-style: var(--zk-group-icon-font-style);
	-webkit-font-smoothing: antialiased;
	-moz-osx-font-smoothing: grayscale;
}
.z-group-icon-close:before {
	content: "\f0da";
	font-weight: var(--zk-group-icon-expanded-font-weight);
}
.z-group-icon-open:before {
	content: "\f0d7";
	font-weight: var(--zk-group-icon-expanded-font-weight);
}

div.z-listbox-body .z-listgroup-header {
	padding-top: var(--zk-group-list-header-padding-block);
	padding-bottom: var(--zk-group-list-header-padding-block);
	border-bottom: var(--zk-group-list-header-border-bottom);
}
.z-listgroup-header-content > .z-listitem-checkable.z-listitem-checkbox {
	display: none;
}
.z-listgroup-icon {
	display: inline-block;
	font-weight: var(--zk-group-list-icon-font-weight);
	font-style: var(--zk-group-list-icon-font-style);
	height: var(--zk-group-list-icon-height);
	width: var(--zk-group-list-icon-width);
	font-size: var(--zk-group-list-icon-font-size);
	padding-top: var(--zk-group-list-icon-padding-block-start);
}
.z-icon-listgroup-close::before {
	content: "\f105";
}
.z-icon-listgroup-open::before {
	content: "\f107";
}
