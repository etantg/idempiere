<%-- customization of border layout --%>
.z-south-collapsed, .z-north-collapsed {
	height: var(--zk-dimension-control-md);
	padding: 0px 0px 0px var(--zk-space-md);
	border: none;
}

.z-south-collapsed:hover, .z-east-collapsed:hover, .z-west-collapsed:hover, .z-north-collapsed:hover {
	box-shadow:inset 0 0 8px var(--zk-color-shadow-inset);
}

.z-south-collapsed .z-borderlayout-icon, .z-north-collapsed .z-borderlayout-icon {
	height: var(--zk-dimension-icon-sm);
	line-height: var(--zk-line-height-xs);
}

.z-west-collapsed > .z-borderlayout-icon {
	right: 0px;
}

.z-east-collapsed > .z-borderlayout-icon {
	left: 0px;
}

.z-borderlayout, .z-north, .z-center, .z-south {
	border: none;
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
	-webkit-filter: brightness(50%);
	filter: brightness(50%);
}

.z-north-slide > .z-north {
	box-shadow: 0px 0px 6px 0px var(--zk-color-border);
	padding-bottom: var(--zk-space-2xs);
}
.z-south-slide > .z-south {
	box-shadow: 0px 0px 6px 0px var(--zk-color-border);
	padding-top: var(--zk-space-2xs);
}
.z-west-slide > .z-west {
	border-right: 1px solid var(--zk-color-border);
	box-shadow: 2px -1px 1px -1px var(--zk-color-border);
	padding-right: var(--zk-space-md);
}
.z-east-slide > .z-east {
	border-left: 1px solid var(--zk-color-border);
	box-shadow: 0px 0px 1px 1px var(--zk-color-border);
	padding-left: var(--zk-space-md);
}
.z-north-slide > .z-north-collapsed, .z-north-slide > .z-south-collapsed, .z-north-slide > .z-west-collapsed, .z-north-slide > .z-center-collapsed, .z-north-slide > .z-east-collapsed, 
.z-south-slide > .z-north-collapsed, .z-south-slide > .z-south-collapsed, .z-south-slide > .z-west-collapsed, .z-south-slide > .z-center-collapsed, .z-south-slide > .z-east-collapsed, 
.z-west-slide > .z-north-collapsed, .z-west-slide > .z-south-collapsed, .z-west-slide > .z-west-collapsed, .z-west-slide > .z-center-collapsed, .z-west-slide > .z-east-collapsed, 
.z-center-slide > .z-north-collapsed, .z-center-slide > .z-south-collapsed, .z-center-slide > .z-west-collapsed, .z-center-slide > .z-center-collapsed, .z-center-slide > .z-east-collapsed, 
.z-east-slide > .z-north-collapsed, .z-east-slide > .z-south-collapsed, .z-east-slide > .z-west-collapsed, .z-east-slide > .z-center-collapsed, .z-east-slide > .z-east-collapsed {
  background: var(--zk-color-primary-lighter);
}
.z-south-slide > .south-collapsible-with-title.z-south > .z-south-header {
	display: none;
}
.z-south-slide > .south-collapsible-with-title.z-south > .z-south-body {
	height: 100% !important;
}
.z-west-collapsed, .z-east-collapsed {
  cursor: pointer;
  width: var(--zk-dimension-control-md);
  border: none;
}

<%-- Splitter --%>
.z-east-splitter-button, .z-west-splitter-button, .z-north-splitter-button, .z-south-splitter-button {
    color: var(--zk-color-icon-disabled);
}

.z-north-splitter, .z-south-splitter {
    cursor: ns-resize;
    border-left: none;
    border-right: none;
}

.z-east-icon, .z-west-icon, .z-north-icon, .z-south-icon {
    font-size: var(--zk-font-size-xs);
}

.z-east-splitter, .z-west-splitter, .z-north-splitter, .z-south-splitter {
	background-color: var(--zk-color-bg-tint);
}

.z-south-icon, .z-north-icon, .z-north-icon.z-icon-ellipsis-h, .z-south-icon.z-icon-ellipsis-h {
  top: -2px;
  visibility: visible;
}

.z-west-icon.z-icon-ellipsis-v, .z-east-icon.z-icon-ellipsis-v {
  left: -2px;
  visibility: visible;
}
