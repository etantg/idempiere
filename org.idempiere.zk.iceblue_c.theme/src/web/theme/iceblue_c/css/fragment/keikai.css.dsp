:root {
	--zk-keikai-font-size-md: var(--zk-font-size-md);
	--zk-keikai-size-38: var(--zk-size-38);
	--zk-keikai-size-62: var(--zk-size-62);
	--zk-keikai-space-3xl: var(--zk-space-3xl);
	--zk-keikai-space-xs: var(--zk-space-xs);
}

.zstbtn.z-toolbarbutton {
	padding: var(--zk-keikai-space-xs);
	min-width: var(--zk-keikai-size-38);
}
.zschktbtn-gridlines.zschktbtn.z-toolbarbutton {
	min-width: var(--zk-keikai-size-62);
}
.zstbtn-real {
    margin-right: var(--zk-keikai-space-3xl);
    font-size: var(--zk-keikai-font-size-md);
}
.zschktbtn .z-toolbarbutton-content {
	justify-content: initial !important;
}
.zstbtabpanel >  .z-toolbar > .z-toolbar-content {
	overflow-x: auto;
}