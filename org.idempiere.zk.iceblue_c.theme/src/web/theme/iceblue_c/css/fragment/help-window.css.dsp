:root {
	--zk-help-color-keyword-red: var(--zk-color-keyword-red);
	--zk-help-color-lavender: var(--zk-color-lavender);
	--zk-help-color-neutral-200: var(--zk-color-neutral-200);
	--zk-help-color-neutral-350: var(--zk-color-neutral-350);
	--zk-help-size-1: var(--zk-size-1);
	--zk-help-size-10: var(--zk-size-10);
	--zk-help-space-0: var(--zk-space-0);
	--zk-help-space-2xl: var(--zk-space-2xl);
	--zk-help-space-4xl: var(--zk-space-4xl);
	--zk-help-space-5xl: var(--zk-space-5xl);
	--zk-help-space-lg: var(--zk-space-lg);
	--zk-help-space-sm: var(--zk-space-sm);
	--zk-help-space-xl: var(--zk-space-xl);
	--zk-help-text-color-brand: var(--zk-text-color-brand);
	--zk-help-text-color-brand-dark: var(--zk-text-color-brand-dark);
	--zk-help-text-color-help: var(--zk-text-color-help);
	--zk-help-text-color-link-muted: var(--zk-text-color-link-muted);
	--zk-help-text-color-strong: var(--zk-text-color-strong);
	--zk-help-text-decoration-none: var(--zk-text-decoration-none);
	--zk-help-text-decoration-underline: var(--zk-text-decoration-underline);
}

.help-window {
	position: relative;
}
.help-window-header {
	padding: var(--zk-help-space-2xl) 0 var(--zk-help-size-10) var(--zk-help-space-5xl);
}
.help-window-title {
	color: var(--zk-help-color-keyword-red);
}
.help-window-description {
}
.help-window-help {
}
.help-window-tabs {
	color: var(--zk-help-text-color-brand);
}
.help-window-content {
	border-top: var(--zk-help-size-1) solid var(--zk-help-color-neutral-350);
}
.help-window-content-l {
}
.help-window-content-r {
	border-left: var(--zk-help-size-1) solid var(--zk-help-color-neutral-350);
	padding: var(--zk-help-space-lg);
}
.help-window-tab {
	border-bottom: var(--zk-help-size-1) solid var(--zk-help-color-neutral-350);
}
.help-window-tab-header {
	background-color: var(--zk-help-color-lavender);
}
.help-window-tab-name {
	padding: var(--zk-help-space-sm) var(--zk-help-space-4xl) !important;
	color: var(--zk-help-text-color-brand-dark);
}
.help-window-tab-description {
	padding: var(--zk-help-space-sm) !important;
}
.help-window-tab-help {
}
.help-window-fields {
	border-bottom: var(--zk-help-size-1) solid var(--zk-help-color-neutral-350);
	color: var(--zk-help-text-color-help);
	padding: var(--zk-help-space-lg) var(--zk-help-space-4xl);
}
.help-window-fields-link {
}
.help-window-field {
	border-bottom: var(--zk-help-size-1) solid var(--zk-help-color-neutral-350);
	padding: var(--zk-help-space-lg) var(--zk-help-space-4xl);
}
.help-window-field-name {
	color: var(--zk-help-text-color-brand);
}
.help-window-field-description {
}
.help-window-field-help {
}

.help-window p, .help-window h3, .help-window h4, .help-window h5 {
	display: inline;
}

.help-window-content-r a {
	color: var(--zk-help-text-color-link-muted) !important;
	text-decoration: var(--zk-help-text-decoration-underline);
}

.help-window-content-r a:hover {
	text-decoration: var(--zk-help-text-decoration-none);
}

.help-window-content-l a {
	color: var(--zk-help-text-color-strong) !important;
	text-decoration: var(--zk-help-text-decoration-none);
}

.help-window-content-l a:hover {
	text-decoration: var(--zk-help-text-decoration-none);
}

.help-window-content-l td {
	padding: var(--zk-help-space-xl) var(--zk-help-space-5xl);
	border-bottom: var(--zk-help-size-1) solid var(--zk-help-color-neutral-350);
}

.help-window-tab td {
	padding: var(--zk-help-space-lg) var(--zk-help-space-4xl) var(--zk-help-space-0) var(--zk-help-space-4xl);
}

.help-window-content-l tr:hover td {
  background-color: var(--zk-help-color-neutral-200); 
}
