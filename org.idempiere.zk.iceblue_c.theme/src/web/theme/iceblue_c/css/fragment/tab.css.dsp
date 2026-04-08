:root {
	--zk-tab-color-transparent: var(--zk-color-transparent);
	--zk-tab-font-size-xs: var(--zk-font-size-xs);
	--zk-tab-font-weight-thin: var(--zk-font-weight-thin);
	--zk-tab-radius-none: var(--zk-radius-none);
	--zk-tab-size-22: var(--zk-size-22);
	--zk-tab-space-0: var(--zk-space-0);
	--zk-tab-space-4xl-plus: var(--zk-space-4xl-plus);
	--zk-tab-space-md: var(--zk-space-md);
	--zk-tab-space-xl-minus: var(--zk-space-xl-minus);
	--zk-tab-space-xs: var(--zk-space-xs);
}

<%-- z-tab customization --%>
.z-tab-close {
	top:var(--zk-tab-space-md); 
	margin-right:var(--zk-tab-space-xs);
	padding-right:var(--zk-tab-space-4xl-plus);
}

.z-tab-button {
	width: var(--zk-tab-size-22);
}

.z-tab-button [class*="z-icon-"] {
	font-weight: var(--zk-tab-font-weight-thin);
    font-size: var(--zk-tab-font-size-xs);
}

.z-tabbox-icon.z-tabbox-left-scroll, .z-tabbox-icon.z-tabbox-right-scroll {
	padding: var(--zk-tab-space-0);
    border-radius: var(--zk-tab-radius-none);
    background-color: var(--zk-tab-color-transparent);
    background: none;
    margin-top: var(--zk-tab-space-xl-minus);
}

.z-tabbox-icon.z-tabbox-left-scroll .z-icon-chevron-left, .z-tabbox-icon.z-tabbox-right-scroll .z-icon-chevron-right {
	opacity: 1;
}
