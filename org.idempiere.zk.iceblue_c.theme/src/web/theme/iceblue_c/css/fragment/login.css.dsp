:root {
	--zk-login-border-none: var(--zk-border-none);
	--zk-login-color-primary-light: var(--zk-color-primary-light);
	--zk-login-color-surface: var(--zk-color-surface);
	--zk-login-dimension-control-md: var(--zk-dimension-control-md);
	--zk-login-dimension-dialog-md: var(--zk-dimension-dialog-md);
	--zk-login-dimension-none: var(--zk-dimension-none);
	--zk-login-dimension-panel-lg: var(--zk-dimension-panel-lg);
	--zk-login-font-weight-bold: var(--zk-font-weight-bold);
	--zk-login-radius-none: var(--zk-radius-none);
	--zk-login-radius-xl: var(--zk-radius-xl);
	--zk-login-size-0: var(--zk-size-0);
	--zk-login-size-130: var(--zk-size-130);
	--zk-login-size-1em: var(--zk-size-1em);
	--zk-login-size-20: var(--zk-size-20);
	--zk-login-size-220: var(--zk-size-220);
	--zk-login-size-25: var(--zk-size-25);
	--zk-login-size-350: var(--zk-size-350);
	--zk-login-size-380: var(--zk-size-380);
	--zk-login-size-40pct: var(--zk-size-40pct);
	--zk-login-size-55pct: var(--zk-size-55pct);
	--zk-login-size-60: var(--zk-size-60);
	--zk-login-size-604: var(--zk-size-604);
	--zk-login-size-65pct: var(--zk-size-65pct);
	--zk-login-size-720: var(--zk-size-720);
	--zk-login-size-90pct: var(--zk-size-90pct);
	--zk-login-size-95pct: var(--zk-size-95pct);
	--zk-login-size-full: var(--zk-size-full);
	--zk-login-space-0: var(--zk-space-0);
	--zk-login-space-2xl: var(--zk-space-2xl);
	--zk-login-space-4xl: var(--zk-space-4xl);
	--zk-login-space-5xl: var(--zk-space-5xl);
	--zk-login-space-7xl: var(--zk-space-7xl);
	--zk-login-space-lg: var(--zk-space-lg);
	--zk-login-space-md: var(--zk-space-md);
	--zk-login-space-xl: var(--zk-space-xl);
	--zk-login-space-xs: var(--zk-space-xs);
	--zk-login-text-color-dialog: var(--zk-text-color-dialog);
	--zk-login-text-color-strong: var(--zk-text-color-strong);
}

.login-window {
	background-color: var(--zk-login-color-primary-light);
}

.login-window .z-window-content {
	background-color: var(--zk-login-color-primary-light);
}

.login-box-body {
	width: var(--zk-login-size-720);
	background-color: var(--zk-login-color-surface);
	padding: var(--zk-login-space-0) var(--zk-login-space-lg) var(--zk-login-size-0) var(--zk-login-size-0);
	margin: var(--zk-login-space-0);
	text-align: center;
}

.login-box-header {
	background-color: var(--zk-login-color-surface);
	width: var(--zk-login-size-720);
	border-radius: var(--zk-login-radius-xl) var(--zk-login-radius-xl) var(--zk-login-radius-none) var(--zk-login-radius-none);
	padding-left: var(--zk-login-space-7xl);
	padding-top: var(--zk-login-space-7xl);
	padding-right: var(--zk-login-space-7xl);
	box-sizing: border-box;
}

.login-box-header-txt {
	font-weight: var(--zk-login-font-weight-bold);
	position: relative;
	display: inline-block;
	text-align: left;
	padding: var(--zk-login-space-2xl);
	color: var(--zk-login-text-color-dialog) !important;
	width: var(--zk-login-size-full);	
	font-size: calc(var(--zk-login-size-1em) * 1.6) !important;
}

.login-box-header-logo {
	padding-bottom: var(--zk-login-size-25) !important;
}

.login-box-footer {
	height: var(--zk-login-size-130);
	width: var(--zk-login-size-720);
	background-color: var(--zk-login-color-surface);
	border-radius: var(--zk-login-radius-none) var(--zk-login-radius-none) var(--zk-login-radius-xl) var(--zk-login-radius-xl);
	padding-left: var(--zk-login-space-7xl);
  	padding-right: var(--zk-login-space-7xl);
  	box-sizing: border-box;
}

.login-box-footer .confirm-panel {
	width: var(--zk-login-dimension-dialog-md) !important;
}

.login-box-footer-pnl {
	width: var(--zk-login-size-604);
	margin-left: var(--zk-login-space-2xl);
	margin-right: var(--zk-login-space-2xl);
	padding-top: var(--zk-login-size-60) !important;
}

.login-label {
	color: var(--zk-login-text-color-strong);
	text-align: right;
	width: var(--zk-login-size-40pct);
	padding: var(--zk-login-space-xs) !important;
}

.login-field {
	text-align: left;
	width: var(--zk-login-size-55pct);
	padding: var(--zk-login-space-xs) !important;
}

.login-field input:not([type="checkbox"]) {
	width: var(--zk-login-size-220) !important;
}

.login-btn {
	padding: var(--zk-login-space-md) var(--zk-login-space-5xl) !important;
}

.login-east-panel, .login-west-panel {
	width: var(--zk-login-size-380);
	background-color: var(--zk-login-color-surface); 
	position: relative;
	border: var(--zk-login-border-none);
}

/* SSO buttons */
.sso-login-btn {
    display: flex;
    align-items: center;
    justify-content: center;
    position: relative;
    width: var(--zk-login-size-65pct) !important;
    max-width: var(--zk-login-dimension-panel-lg);
    border-radius: var(--zk-login-size-20) !important;
    overflow: hidden;
    padding: var(--zk-login-space-xl) var(--zk-login-space-4xl) !important;
}

.sso-login-btn img {
    position: absolute;
    left: var(--zk-login-space-4xl);
    height: var(--zk-login-dimension-control-md);
    margin-right: var(--zk-login-space-0);
}

.sso-login-btn.icon-only img {
    margin: var(--zk-login-space-0) !important;
    height: var(--zk-login-dimension-control-md);
}

@media (max-width: 600px) {
    .sso-login-btn {
		width: var(--zk-login-size-95pct) !important;
        overflow: hidden;
    	text-overflow: ellipsis;
    }
}

@media screen and (max-width: 659px) {
	.login-box-body, .login-box-header, .login-box-footer {
		background-image: none;
		width: var(--zk-login-size-90pct);
	}
	.login-box-footer .confirm-panel, .login-box-footer-pnl {
		width: var(--zk-login-size-full) !important;
        margin: var(--zk-login-space-0);
	}
	.login-box-footer {
		padding-left: var(--zk-login-space-2xl);
		padding-right: var(--zk-login-space-2xl);
    }
	.login-box-header-txt {
		display: none;
	}
}
@media screen and (max-height: 600px) {
	.login-box-header-txt {
		display: none;
	}
	.login-box-body, .login-box-header, .login-box-footer {
		background-image: none;
	}
	.login-box-body {
		padding-bottom: var(--zk-login-space-2xl);
	}
	.login-box-header {
		height: var(--zk-login-dimension-none);
	}
}
@media screen and (max-device-width: 500px) {
	.login-field input:not([type="checkbox"]) {
		width: var(--zk-login-size-full) !important;
	}
}
@media screen and (max-device-width: 380px) {
	.login-west-panel {
		width: var(--zk-login-size-350);
	}
}
@media screen and (max-width: 359px) {
	.login-window .z-center > .z-center-body .z-window.z-window-embedded > .z-window-content {
		padding: var(--zk-login-space-lg)
	}
}
