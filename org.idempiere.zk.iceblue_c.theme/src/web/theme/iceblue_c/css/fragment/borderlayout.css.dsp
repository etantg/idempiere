:root {
	--zk-borderlayout-border-none: var(--zk-border-none);
	--zk-borderlayout-color-bg-tint: var(--zk-color-bg-tint);
	--zk-borderlayout-color-border: var(--zk-color-border);
	--zk-borderlayout-color-icon-disabled: var(--zk-color-icon-disabled);
	--zk-borderlayout-color-primary-lighter: var(--zk-color-primary-lighter);
	--zk-borderlayout-color-shadow-inset: var(--zk-color-shadow-inset);
	--zk-borderlayout-dimension-control-md: var(--zk-dimension-control-md);
	--zk-borderlayout-dimension-icon-sm: var(--zk-dimension-icon-sm);
	--zk-borderlayout-font-size-xs: var(--zk-font-size-xs);
	--zk-borderlayout-line-height-xs: var(--zk-line-height-xs);
	--zk-borderlayout-size-0: var(--zk-size-0);
	--zk-borderlayout-size-1: var(--zk-size-1);
	--zk-borderlayout-size-2: var(--zk-size-2);
	--zk-borderlayout-size-50pct: var(--zk-size-50pct);
	--zk-borderlayout-size-6: var(--zk-size-6);
	--zk-borderlayout-size-8: var(--zk-size-8);
	--zk-borderlayout-size-full: var(--zk-size-full);
	--zk-borderlayout-size-neg-2: var(--zk-size-neg-2);
	--zk-borderlayout-space-0: var(--zk-space-0);
	--zk-borderlayout-space-2xs: var(--zk-space-2xs);
	--zk-borderlayout-space-md: var(--zk-space-md);
}

<%-- customization of border layout --%>
.z-south-collapsed, .z-north-collapsed {
	height: var(--zk-borderlayout-dimension-control-md);
	padding: var(--zk-borderlayout-space-0) var(--zk-borderlayout-size-0) var(--zk-borderlayout-size-0) var(--zk-borderlayout-space-md);
	border: var(--zk-borderlayout-border-none);
}

.z-south-collapsed:hover, .z-east-collapsed:hover, .z-west-collapsed:hover, .z-north-collapsed:hover {
	box-shadow:inset 0 0 var(--zk-borderlayout-size-8) var(--zk-borderlayout-color-shadow-inset);
}

.z-south-collapsed .z-borderlayout-icon, .z-north-collapsed .z-borderlayout-icon {
	height: var(--zk-borderlayout-dimension-icon-sm);
	line-height: var(--zk-borderlayout-line-height-xs);
}

.z-west-collapsed {
	cursor: pointer;
	width: var(--zk-borderlayout-dimension-control-md);
}

.z-west-collapsed > .z-borderlayout-icon {
	right: var(--zk-borderlayout-space-0);
}

.z-east-collapsed {
	cursor: pointer;
	width: var(--zk-borderlayout-dimension-control-md);
}
.z-east-collapsed > .z-borderlayout-icon {
	left: var(--zk-borderlayout-space-0);
}

.z-borderlayout, .z-north, .z-center, .z-south {
	border: var(--zk-borderlayout-border-none);
}

.z-east-splitter-button,
.z-west-splitter-button,
.z-north-splitter-button,
.z-south-splitter-button {
	filter: alpha(opacity=100);  <%-- IE --%>
	opacity: 1.0;  <%-- Moz + FF --%>
}

.z-east-splitter-button-over,
.z-west-splitter-button-over,
.z-north-splitter-button-over,
.z-south-splitter-button-over {
	-webkit-filter: brightness(var(--zk-borderlayout-size-50pct));
	filter: brightness(var(--zk-borderlayout-size-50pct));
}

.z-north-slide > .z-north {
	box-shadow: var(--zk-borderlayout-size-0) var(--zk-borderlayout-size-0) var(--zk-borderlayout-size-6) var(--zk-borderlayout-size-0) var(--zk-borderlayout-color-border);
	padding-bottom: var(--zk-borderlayout-space-2xs);
}
.z-south-slide > .z-south {
	box-shadow: var(--zk-borderlayout-size-0) var(--zk-borderlayout-size-0) var(--zk-borderlayout-size-6) var(--zk-borderlayout-size-0) var(--zk-borderlayout-color-border);
	padding-top: var(--zk-borderlayout-space-2xs);
}
.z-west-slide > .z-west {
	border-right: var(--zk-borderlayout-size-1) solid var(--zk-borderlayout-color-border);
    box-shadow: var(--zk-borderlayout-size-2) -1px var(--zk-borderlayout-size-1) -1px var(--zk-borderlayout-color-border);
    padding-right: var(--zk-borderlayout-space-md);
}
.z-east-slide > .z-east {
	border-left: var(--zk-borderlayout-size-1) solid var(--zk-borderlayout-color-border);
	box-shadow: var(--zk-borderlayout-size-0) var(--zk-borderlayout-size-0) var(--zk-borderlayout-size-1) var(--zk-borderlayout-size-1) var(--zk-borderlayout-color-border);
	padding-left: var(--zk-borderlayout-space-md);
}
.z-north-slide > .z-north-collapsed, .z-north-slide > .z-south-collapsed, .z-north-slide > .z-west-collapsed, .z-north-slide > .z-center-collapsed, .z-north-slide > .z-east-collapsed, 
.z-south-slide > .z-north-collapsed, .z-south-slide > .z-south-collapsed, .z-south-slide > .z-west-collapsed, .z-south-slide > .z-center-collapsed, .z-south-slide > .z-east-collapsed, 
.z-west-slide > .z-north-collapsed, .z-west-slide > .z-south-collapsed, .z-west-slide > .z-west-collapsed, .z-west-slide > .z-center-collapsed, .z-west-slide > .z-east-collapsed, 
.z-center-slide > .z-north-collapsed, .z-center-slide > .z-south-collapsed, .z-center-slide > .z-west-collapsed, .z-center-slide > .z-center-collapsed, .z-center-slide > .z-east-collapsed, 
.z-east-slide > .z-north-collapsed, .z-east-slide > .z-south-collapsed, .z-east-slide > .z-west-collapsed, .z-east-slide > .z-center-collapsed, .z-east-slide > .z-east-collapsed {
  background: var(--zk-borderlayout-color-primary-lighter);
}
.z-south-slide > .south-collapsible-with-title.z-south > .z-south-header {
	display: none;
}
.z-south-slide > .south-collapsible-with-title.z-south > .z-south-body {
	height: var(--zk-borderlayout-size-full) !important;
}
.z-west-collapsed, .z-east-collapsed {
  cursor: pointer;
  width: var(--zk-borderlayout-dimension-control-md);
  border: var(--zk-borderlayout-border-none);
}

<%-- Splitter --%>
.z-east-splitter-button, .z-west-splitter-button, .z-north-splitter-button, .z-south-splitter-button {
    color: var(--zk-borderlayout-color-icon-disabled);
}

.z-north-splitter, .z-south-splitter {
    cursor: ns-resize;
    border-left: none;
    border-right: none;
}

.z-east-icon, .z-west-icon, .z-north-icon, .z-south-icon {
    font-size: var(--zk-borderlayout-font-size-xs);
}

.z-east-splitter, .z-west-splitter, .z-north-splitter, .z-south-splitter {
	background-color: var(--zk-borderlayout-color-bg-tint);
}

.z-south-icon, .z-north-icon, .z-north-icon.z-icon-ellipsis-h, .z-south-icon.z-icon-ellipsis-h {
  top: var(--zk-borderlayout-size-neg-2);
  visibility: visible;
}

.z-west-icon.z-icon-ellipsis-v, .z-east-icon.z-icon-ellipsis-v {
  left: var(--zk-borderlayout-size-neg-2);
  visibility: visible;
}
