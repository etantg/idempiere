:root {
	--zk-toolbar-border-none: var(--zk-border-none);
	--zk-toolbar-color-border-accent: var(--zk-color-border-accent);
	--zk-toolbar-color-primary: var(--zk-color-primary);
	--zk-toolbar-color-selected-bg: var(--zk-color-selected-bg);
	--zk-toolbar-color-surface: var(--zk-color-surface);
	--zk-toolbar-color-transparent: var(--zk-color-transparent);
	--zk-toolbar-dimension-control-md: var(--zk-dimension-control-md);
	--zk-toolbar-dimension-none: var(--zk-dimension-none);
	--zk-toolbar-font-size-2xl: var(--zk-font-size-2xl);
	--zk-toolbar-font-size-3xl: var(--zk-font-size-3xl);
	--zk-toolbar-font-size-lg: var(--zk-font-size-lg);
	--zk-toolbar-font-size-md: var(--zk-font-size-md);
	--zk-toolbar-font-size-xl: var(--zk-font-size-xl);
	--zk-toolbar-size-0: var(--zk-size-0);
	--zk-toolbar-size-1: var(--zk-size-1);
	--zk-toolbar-size-28: var(--zk-size-28);
	--zk-toolbar-size-4: var(--zk-size-4);
	--zk-toolbar-size-full: var(--zk-size-full);
	--zk-toolbar-space-0: var(--zk-space-0);
	--zk-toolbar-space-2xl: var(--zk-space-2xl);
	--zk-toolbar-space-2xs: var(--zk-space-2xs);
	--zk-toolbar-space-3xl-plus: var(--zk-space-3xl-plus);
	--zk-toolbar-space-md: var(--zk-space-md);
	--zk-toolbar-text-color-default: var(--zk-text-color-default);
}

<%-- z-toolbar customization --%>
.toolbar {
	padding: var(--zk-toolbar-space-0);
}

.toolbar-button {
	background-color: var(--zk-toolbar-color-transparent); 	
	margin-left: var(--zk-toolbar-space-2xs); 
	margin-right: var(--zk-toolbar-space-2xs); 
	width: var(--zk-toolbar-size-28); 
	height: var(--zk-toolbar-size-28);
	padding: var(--zk-toolbar-space-2xs);
}
.toolbar-button .z-toolbarbutton-content {
	width: var(--zk-toolbar-dimension-control-md);
	height: var(--zk-toolbar-dimension-control-md);
	padding: var(--zk-toolbar-space-2xs);
	border: var(--zk-toolbar-border-none);	
}

<%-- toolbar button in overflow popup --%>
.toolbar-overflow-popup-vertical .toolbar-button, 
.toolbar-overflow-popup-vertical .toolbar-button .z-toolbarbutton-content {
	width: auto;
}

.depressed img {
	border-width: var(--zk-toolbar-size-1);
	border-color: var(--zk-toolbar-color-border-accent);
	background-color: var(--zk-toolbar-color-selected-bg);
	padding: var(--zk-toolbar-space-0) var(--zk-toolbar-space-2xs) var(--zk-toolbar-size-0) var(--zk-toolbar-space-2xs);
}

.disableFilter img {
	opacity: 0.2;
	filter: progid : DXImageTransform . Microsoft . Alpha(opacity = 20);
	-moz-opacity: 0.2;
	background-color: var(--zk-toolbar-color-transparent);
}

.z-toolbar {
	padding: var(--zk-toolbar-space-md) var(--zk-toolbar-space-3xl-plus) var(--zk-toolbar-space-md) var(--zk-toolbar-size-4);
}

.z-toolbar.z-toolbar-tabs {
	padding-top: var(--zk-toolbar-space-0);
	padding-bottom: var(--zk-toolbar-space-0);
}
.z-toolbar-start{
	width:var(--zk-toolbar-size-full);
}
.z-toolbarbutton [class^="z-icon-"] {
	color: inherit;
}
.z-toolbarbutton.toolbarbutton-with-text [class^="z-icon-"] {
	padding-right: var(--zk-toolbar-space-md);
}
.z-toolbarbutton.xlarge-toolbarbutton [class^="z-icon-"] {
	font-size: var(--zk-toolbar-font-size-3xl);
}
.z-toolbarbutton.large-toolbarbutton [class^="z-icon-"] {
	font-size: var(--zk-toolbar-font-size-2xl);
}
.z-toolbarbutton.medium-toolbarbutton [class^="z-icon-"] {
	font-size: var(--zk-toolbar-font-size-lg);
}
.z-toolbarbutton.small-toolbarbutton [class^="z-icon-"] {
	font-size: var(--zk-toolbar-font-size-md);
}
.z-toolbarbutton {
	display: inline-flex;	
	align-items: center;
	color: var(--zk-toolbar-text-color-default);
	flex-shrink: 0;
}
.z-toolbarbutton .z-toolbarbutton-content {
	display: inline-flex;
    align-items: center;
    justify-content: center;
    flex-shrink: 0;
}
.z-toolbar-content {
	display:flex;
	align-items: center;
}
.z-toolbar.space-between-content .z-toolbar-content {
	justify-content: space-between;
}
.z-toolbarbutton-checked {
    color: var(--zk-toolbar-color-surface) !important;
    background-color: var(--zk-toolbar-color-primary) !important;
}
.z-toolbarbutton[disabled], .z-toolbarbutton[disabled]:hover {
	background-color: var(--zk-toolbar-color-transparent);
}

<%-- toolbar button with font icon --%>
@media screen and (max-width: 767px) {
	.font-icon-toolbar-button.toolbar-button [class^="z-icon-"] {
		font-size: var(--zk-toolbar-font-size-xl);
		color: inherit;
	}
}
@media screen and (min-width: 768px) {
	.font-icon-toolbar-button.toolbar-button [class^="z-icon-"] {
		font-size: var(--zk-toolbar-font-size-lg);
		color: inherit;
	}
}

.font-icon-toolbar-button.toolbar-button {
	color :var(--zk-toolbar-text-color-default);
}
.font-icon-toolbar-button.toolbar-button:hover {
	color: var(--zk-toolbar-color-surface);
	background-color: var(--zk-toolbar-color-primary);
}
.font-icon-toolbar-button.toolbar-button, .font-icon-toolbar-button.toolbar-button .z-toolbarbutton-content {
	display:inline-flex;
	align-items: center;
	justify-content: center; 
}
.font-icon-toolbar-button .z-toolbarbutton-content {
	color: inherit;
}
.font-icon-menuitem i {
	vertical-align: middle;
}
.toolbar-overflow-popup-vertical .font-icon-toolbar-button.toolbar-button, 
.toolbar-overflow-popup-vertical .font-icon-toolbar-button.toolbar-button .z-toolbarbutton-content {
	justify-content: flex-start;
}

.toolbar-searchbox {
    margin-right: var(--zk-toolbar-space-2xl);
    margin-left: var(--zk-toolbar-space-2xl);
    border: var(--zk-toolbar-size-1);
}
@media screen and (max-width: 768px) {
  .toolbar-searchbox {
    display: none;
    width: var(--zk-toolbar-dimension-none);
  }
}
