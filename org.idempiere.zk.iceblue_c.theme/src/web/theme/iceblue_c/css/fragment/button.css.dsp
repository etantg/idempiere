:root {
	--zk-button-padding: var(--zk-space-md) var(--zk-space-5xl);
	--zk-button-gap: var(--zk-space-lg);
	--zk-button-border-radius: var(--zk-radius-md);
	--zk-button-image-lg-height: var(--zk-size-22);
	--zk-button-image-lg-width: var(--zk-size-22);
	--zk-button-image-md-height: var(--zk-dimension-icon-md);
	--zk-button-image-md-width: var(--zk-dimension-icon-md);
	--zk-button-hover-text-color: var(--zk-color-surface);
	--zk-button-hover-border-color: var(--zk-color-transparent);
	--zk-button-hover-bg: var(--zk-color-primary);
	--zk-button-focus-border-color: var(--zk-text-color-strong);
	--zk-button-small-padding: var(--zk-space-2xs) var(--zk-space-lg);
	--zk-button-medium-padding: var(--zk-space-xs) var(--zk-space-2xl);
	--zk-button-image-bg: var(--zk-color-transparent);
	--zk-button-cancel-bg: var(--zk-color-neutral-450);
	--zk-button-cancel-text-color: var(--zk-text-color-action);
	--zk-button-cancel-hover-bg: var(--zk-color-button-hover);
	--zk-button-cancel-hover-text-color: var(--zk-text-color-button-hover);
	--zk-button-icon-action-color: var(--zk-text-color-action);
	--zk-button-sorttab-box-shadow: var(--zk-size-0) var(--zk-size-0) var(--zk-size-4) var(--zk-color-neutral-400);
	--zk-button-sorttab-border: solid var(--zk-size-1) var(--zk-color-neutral-400);
	--zk-button-sorttab-text-shadow: var(--zk-size-0) var(--zk-size-1) var(--zk-size-2) var(--zk-text-color-shadow);
	--zk-button-sorttab-text-color: var(--zk-text-color-secondary-strong);
	--zk-button-disabled-icon-font-size: var(--zk-font-size-larger);
	--zk-button-xlarge-icon-font-size: var(--zk-font-size-3xl);
	--zk-button-large-icon-font-size: var(--zk-font-size-2xl);
	--zk-button-medium-icon-font-size: var(--zk-font-size-lg);
	--zk-button-small-icon-font-size: var(--zk-font-size-md);
	--zk-button-combo-icon-font-size: var(--zk-font-size-lg);
	--zk-button-mobile-login-font-size: var(--zk-size-0);
	--zk-button-disabled-icon-color: var(--zk-text-color-default);
	--zk-button-disabled-icon-padding-inline: var(--zk-space-xs);
	--zk-button-ok-icon-color: var(--zk-color-surface);
}

<%-- customization of buttons --%>
.z-button, .z-button-os {
  display: inline-flex;
  align-items: center;
  padding: var(--zk-button-padding);
  justify-content: center;
  cursor: pointer;
  gap: var(--zk-button-gap);
}
.z-button-os {
	border-radius: var(--zk-button-border-radius);
}
.z-button-os:hover {
    color: var(--zk-button-hover-text-color);
    border-color: var(--zk-button-hover-border-color);
    background-color: var(--zk-button-hover-bg);
}

.z-button:focus {
    border-color: var(--zk-button-focus-border-color);
}

.z-button.btn-small {
	padding: var(--zk-button-small-padding);
}
.z-button.btn-medium {
	padding: var(--zk-button-medium-padding);
}

.img-btn img {
	height: var(--zk-button-image-lg-height);
	width: var(--zk-button-image-lg-width);
	background-color: var(--zk-button-image-bg);
}

.txt-btn img, .small-img-btn img, .img-txt-btn img {
	height: var(--zk-button-image-md-height);
	width: var(--zk-button-image-md-width);
	background-color: var(--zk-button-image-bg);
	vertical-align: middle;
	display: inline-block;
}

.btn-sorttab {
	box-shadow: var(--zk-button-sorttab-box-shadow);
	color: var(--zk-button-sorttab-text-color);
	border: var(--zk-button-sorttab-border);
	text-shadow: var(--zk-button-sorttab-text-shadow);
}

.btn-cancel, .btn-help {
	background: var(--zk-button-cancel-bg);
	color: var(--zk-button-cancel-text-color);
}

.btn-cancel:hover, .btn-help:hover {
	background: var(--zk-button-cancel-hover-bg);
	color: var(--zk-button-cancel-hover-text-color);
}

.z-icon-Help, .z-icon-Cancel {
	color: var(--zk-button-icon-action-color) !important;
}

.z-button [class^="z-icon-"][disabled],
.z-button-os [class^="z-icon-"][disabled]{
	font-size: var(--zk-button-disabled-icon-font-size);
	color: var(--zk-button-disabled-icon-color);	
	padding-left: var(--zk-button-disabled-icon-padding-inline);
	padding-right: var(--zk-button-disabled-icon-padding-inline);
}
.z-button.xlarge-toolbarbutton [class^="z-icon-"] {
	font-size: var(--zk-button-xlarge-icon-font-size);
}
.z-button.large-toolbarbutton [class^="z-icon-"] {
	font-size: var(--zk-button-large-icon-font-size);
}
.z-button.medium-toolbarbutton [class^="z-icon-"] {
	font-size: var(--zk-button-medium-icon-font-size);
}
.z-button.small-toolbarbutton [class^="z-icon-"] {
	font-size: var(--zk-button-small-icon-font-size);
}
.btn-ok.z-button [class^="z-icon-"]:before {
	color: var(--zk-button-ok-icon-color);	
}

.z-combobox-button, .z-bandbox-button, .z-datebox-button, .z-timebox-button,
 .z-spinner-button, .z-doublespinner-button {
	vertical-align: top;
}
.z-bandbox-button [class*="z-icon-"], .z-combobox-button [class*="z-icon-"] {
	font-size: var(--zk-button-combo-icon-font-size);
}

.mobile .login-btn {
	font-size: var(--zk-button-mobile-login-font-size) !important;
}