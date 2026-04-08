<%-- customization of buttons --%>
.z-button, .z-button-os {
  display: inline-flex;
  align-items: center;
  padding: var(--zk-space-md) var(--zk-space-5xl);
  justify-content: center;
  cursor: pointer;
  gap: var(--zk-space-lg);
}
.z-button-os {
	border-radius: var(--zk-radius-md);
}
.z-button-os:hover {
    color: var(--zk-color-surface);
    border-color: transparent;
    background-color: var(--zk-color-primary);
}

.z-button:focus {
    border-color: var(--zk-text-color-strong);
}

.z-button.btn-small {
	padding: var(--zk-space-2xs) var(--zk-space-lg);
}
.z-button.btn-medium {
	padding: var(--zk-space-xs) var(--zk-space-2xl);
}

.img-btn img {
	height: 22px;
	width: 22px;
	background-color: transparent;
}

.txt-btn img, .small-img-btn img, .img-txt-btn img {
	height: var(--zk-dimension-icon-md);
	width: var(--zk-dimension-icon-md);
	background-color: transparent;
	vertical-align: middle;
	display: inline-block;
}

.btn-sorttab {
	box-shadow: 0px 0px 4px var(--zk-color-neutral-400);
	color: var(--zk-text-color-secondary-strong);
	border: solid 1px var(--zk-color-neutral-400);
	text-shadow: 0px 1px 2px var(--zk-text-color-shadow);
}

.btn-cancel, .btn-help {
	background: var(--zk-color-neutral-450);
	color: var(--zk-text-color-action);
}

.btn-cancel:hover, .btn-help:hover {
	background: var(--zk-color-button-hover);
	color: var(--zk-text-color-button-hover);
}

.z-icon-Help, .z-icon-Cancel {
	color: var(--zk-text-color-action) !important;
}

.z-button [class^="z-icon-"][disabled],
.z-button-os [class^="z-icon-"][disabled]{
	font-size: larger;
	color: var(--zk-text-color-default);	
	padding-left: var(--zk-space-xs);
	padding-right: var(--zk-space-xs);
}
.z-button.xlarge-toolbarbutton [class^="z-icon-"] {
	font-size: var(--zk-font-size-3xl);
}
.z-button.large-toolbarbutton [class^="z-icon-"] {
	font-size: var(--zk-font-size-2xl);
}
.z-button.medium-toolbarbutton [class^="z-icon-"] {
	font-size: var(--zk-font-size-lg);
}
.z-button.small-toolbarbutton [class^="z-icon-"] {
	font-size: var(--zk-font-size-md);
}
.btn-ok.z-button [class^="z-icon-"]:before {
	color: var(--zk-color-surface);	
}

.z-combobox-button, .z-bandbox-button, .z-datebox-button, .z-timebox-button,
 .z-spinner-button, .z-doublespinner-button {
	vertical-align: top;
}
.z-bandbox-button [class*="z-icon-"], .z-combobox-button [class*="z-icon-"] {
	font-size: var(--zk-font-size-lg);
}

.mobile .login-btn {
    font-size: 0px !important;
}