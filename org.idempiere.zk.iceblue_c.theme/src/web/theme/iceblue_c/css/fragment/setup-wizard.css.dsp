:root {
	--zk-setup-color-border: var(--zk-color-border);
	--zk-setup-color-status-delayed: var(--zk-color-status-delayed);
	--zk-setup-color-status-finished: var(--zk-color-status-finished);
	--zk-setup-color-status-in-progress: var(--zk-color-status-in-progress);
	--zk-setup-color-status-pending: var(--zk-color-status-pending);
	--zk-setup-color-status-skipped: var(--zk-color-status-skipped);
	--zk-setup-dimension-control-sm: var(--zk-dimension-control-sm);
	--zk-setup-size-0: var(--zk-size-0);
	--zk-setup-size-1: var(--zk-size-1);
	--zk-setup-space-5xl: var(--zk-space-5xl);
}

.tree-wsetupwizard-finished {
	background-color: var(--zk-setup-color-status-finished);
	margin-left:var(--zk-setup-space-5xl)
}

.tree-wsetupwizard-skipped {
	background-color: var(--zk-setup-color-status-skipped);
	margin-left:var(--zk-setup-space-5xl)
}

.tree-wsetupwizard-delayed {
	background-color: var(--zk-setup-color-status-delayed);
	margin-left:var(--zk-setup-space-5xl);
}

.tree-wsetupwizard-in-progress {
	background-color: var(--zk-setup-color-status-in-progress);
	margin-left:var(--zk-setup-space-5xl);
}

.tree-wsetupwizard-pending {
	background-color: var(--zk-setup-color-status-pending);
	margin-left:var(--zk-setup-space-5xl);
}

.tree-setupwizard-nostatus{
	margin-left:var(--zk-setup-space-5xl);
}

.tree-wsetupwizard-finished-all {
	background-color: var(--zk-setup-color-status-finished);
}

.progressmeter-setupwizard {
	background: var(--zk-setup-color-status-pending) repeat-x 0 0 ;
	background-image: none;
	border: var(--zk-setup-size-1) solid var(--zk-setup-color-border);
	text-align: left;
	height: var(--zk-setup-dimension-control-sm);
	overflow: hidden;
}
.progressmeter-setupwizard-image {
	display: inline-block;
	background: var(--zk-setup-color-status-finished);
	background-image: none;
	height: var(--zk-setup-dimension-control-sm);
	line-height: var(--zk-setup-size-0);
	font-size: var(--zk-setup-size-0);
}
