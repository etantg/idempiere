<%-- z-toolbar customization --%>
.toolbar {
	padding: 0px;
}

.toolbar-button {
	background-color: transparent; 	
	margin-left: var(--zk-space-2xs); 
	margin-right: var(--zk-space-2xs); 
	width: 28px; 
	height: 28px;
	padding: var(--zk-space-2xs);
}
.toolbar-button .z-toolbarbutton-content {
	width: var(--zk-dimension-control-md);
	height: var(--zk-dimension-control-md);
	padding: var(--zk-space-2xs);
	border: none;	
}

<%-- toolbar button in overflow popup --%>
.toolbar-overflow-popup-vertical .toolbar-button, 
.toolbar-overflow-popup-vertical .toolbar-button .z-toolbarbutton-content {
	width: auto;
}

.depressed img {
	border-width: 1px;
	border-color: var(--zk-color-border-accent);
	background-color: var(--zk-color-selected-bg);
	padding: 0px var(--zk-space-2xs) 0px var(--zk-space-2xs);
}

.disableFilter img {
	opacity: 0.2;
	filter: progid : DXImageTransform . Microsoft . Alpha(opacity = 20);
	-moz-opacity: 0.2;
	background-color: transparent;
}

.z-toolbar {
	padding: var(--zk-space-md) var(--zk-space-3xl-plus) var(--zk-space-md) 4px;
}

.z-toolbar.z-toolbar-tabs {
	padding-top: 0px;
	padding-bottom: 0px;
}
.z-toolbar-start{
	width:100%;
}
.z-toolbarbutton [class^="z-icon-"] {
	color: inherit;
}
.z-toolbarbutton.toolbarbutton-with-text [class^="z-icon-"] {
	padding-right: var(--zk-space-md);
}
.z-toolbarbutton.xlarge-toolbarbutton [class^="z-icon-"] {
	font-size: var(--zk-font-size-3xl);
}
.z-toolbarbutton.large-toolbarbutton [class^="z-icon-"] {
	font-size: var(--zk-font-size-2xl);
}
.z-toolbarbutton.medium-toolbarbutton [class^="z-icon-"] {
	font-size: var(--zk-font-size-lg);
}
.z-toolbarbutton.small-toolbarbutton [class^="z-icon-"] {
	font-size: var(--zk-font-size-md);
}
.z-toolbarbutton {
	display: inline-flex;	
	align-items: center;
	color: var(--zk-text-color-default);
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
    color: var(--zk-color-surface) !important;
    background-color: var(--zk-color-primary) !important;
}
.z-toolbarbutton[disabled], .z-toolbarbutton[disabled]:hover {
	background-color: transparent;
}

<%-- toolbar button with font icon --%>
@media screen and (max-width: 767px) {
	.font-icon-toolbar-button.toolbar-button [class^="z-icon-"] {
		font-size: var(--zk-font-size-xl);
		color: inherit;
	}
}
@media screen and (min-width: 768px) {
	.font-icon-toolbar-button.toolbar-button [class^="z-icon-"] {
		font-size: var(--zk-font-size-lg);
		color: inherit;
	}
}

.font-icon-toolbar-button.toolbar-button {
	color :var(--zk-text-color-default);
}
.font-icon-toolbar-button.toolbar-button:hover {
	color: var(--zk-color-surface);
	background-color: var(--zk-color-primary);
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
    margin-right: var(--zk-space-2xl);
    margin-left: var(--zk-space-2xl);
    border: 1px;
}
@media screen and (max-width: 768px) {
  .toolbar-searchbox {
    display: none;
    width: 0px;
  }
}
