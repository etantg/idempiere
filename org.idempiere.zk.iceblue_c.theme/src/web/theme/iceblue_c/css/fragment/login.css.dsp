.login-window {
	background-color: var(--zk-color-primary-light);
}

.login-window .z-window-content {
	background-color: var(--zk-color-primary-light);
}

.login-box-body {
	width: 720px;
	background-color: var(--zk-color-surface);
	padding: 0px var(--zk-space-lg) 0px 0px;
	margin: 0;
	text-align: center;
}

.login-box-header {
	background-color: var(--zk-color-surface);
	width: 720px;
	border-radius: var(--zk-radius-xl) var(--zk-radius-xl) 0px 0px;
	padding-left: var(--zk-space-7xl);
	padding-top: var(--zk-space-7xl);
	padding-right: var(--zk-space-7xl);
	box-sizing: border-box;
}

.login-box-header-txt {
	font-weight: var(--zk-font-weight-bold);
	position: relative;
	display: inline-block;
	text-align: left;
	padding: var(--zk-space-2xl);
	color: var(--zk-text-color-dialog) !important;
	width: 100%;	
	font-size: 1.6em !important;
}

.login-box-header-logo {
	padding-bottom: 25px !important;
}

.login-box-footer {
	height: 130px;
	width: 720px;
	background-color: var(--zk-color-surface);
	border-radius: 0px 0px var(--zk-radius-xl) var(--zk-radius-xl);
	padding-left: var(--zk-space-7xl);
  	padding-right: var(--zk-space-7xl);
  	box-sizing: border-box;
}

.login-box-footer .confirm-panel {
	width: var(--zk-dimension-dialog-md) !important;
}

.login-box-footer-pnl {
	width: 604px;
	margin-left: var(--zk-space-2xl);
	margin-right: var(--zk-space-2xl);
	padding-top: 60px !important;
}

.login-label {
	color: var(--zk-text-color-strong);
	text-align: right;
	width: 40%;
	padding: var(--zk-space-xs) !important;
}

.login-field {
	text-align: left;
	width: 55%;
	padding: var(--zk-space-xs) !important;
}

.login-field input:not([type="checkbox"]) {
	width: 220px !important;
}

.login-btn {
	padding: var(--zk-space-md) var(--zk-space-5xl) !important;
}

.login-east-panel, .login-west-panel {
	width: 380px;
	background-color: var(--zk-color-surface); 
	position: relative;
	border: none;
}

/* SSO buttons */
.sso-login-btn {
    display: flex;
    align-items: center;
    justify-content: center;
    position: relative;
    width: 65% !important;
    max-width: var(--zk-dimension-panel-lg);
    border-radius: 20px !important;
    overflow: hidden;
    padding: var(--zk-space-xl) var(--zk-space-4xl) !important;
}

.sso-login-btn img {
    position: absolute;
    left: var(--zk-space-4xl);
    height: var(--zk-dimension-control-md);
    margin-right: 0;
}

.sso-login-btn.icon-only img {
    margin: 0 !important;
    height: var(--zk-dimension-control-md);
}

@media (max-width: 600px) {
    .sso-login-btn {
        width: 95% !important;
        overflow: hidden;
    	text-overflow: ellipsis;
    }
}

@media screen and (max-width: 659px) {
	.login-box-body, .login-box-header, .login-box-footer {
		background-image: none;
		width: 90%;
	}
	.login-box-footer .confirm-panel, .login-box-footer-pnl {
		width: 100% !important;
        margin: 0px;
	}
	.login-box-footer {
		padding-left: var(--zk-space-2xl);
		padding-right: var(--zk-space-2xl);
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
		padding-bottom: var(--zk-space-2xl);
	}
	.login-box-header {
		height: 0px;
	}
}
@media screen and (max-device-width: 500px) {
	.login-field input:not([type="checkbox"]) {
		width: 100% !important;
	}
}
@media screen and (max-device-width: 380px) {
	.login-west-panel {
		width: 350px;
	}
}
@media screen and (max-width: 359px) {
	.login-window .z-center > .z-center-body .z-window.z-window-embedded > .z-window-content {
		padding: var(--zk-space-lg)
	}
}
