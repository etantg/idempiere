<%@ taglib uri="http://www.zkoss.org/dsp/web/core" prefix="c" %>

:root {
	--zk-tree-content-padding-desktop: var(--zk-space-0) var(--zk-space-2xs);
	--zk-tree-content-padding-mobile: var(--zk-space-xs) var(--zk-space-2xs);
	--zk-tree-menu-link-margin-inline-start: var(--zk-space-xl);
	--zk-tree-text-margin-inline-start: var(--zk-space-0);
	--zk-tree-text-color: var(--zk-text-color-default);
	--zk-tree-moveitem-padding: var(--zk-space-xs) var(--zk-space-md);
	--zk-tree-moveitem-border-radius: var(--zk-size-3);
	--zk-tree-moveitem-pressed-shadow: inset 0 0 0 var(--zk-size-1) var(--zk-shadow-inner-light), inset 0 var(--zk-size-3) var(--zk-size-15) var(--zk-shadow-inner-dark);
}

<%-- z-tree customization --%>
.z-treecell-content {
	${fontFamilyC};
	${fontSizeM};
}
@media screen and (min-width: 768px) {
	.z-treecell-content {
		padding: var(--zk-tree-content-padding-desktop);
	}
}

@media screen and (max-width: 767px) {
	.z-treecell-content {
		padding: var(--zk-tree-content-padding-mobile);
	}
}
.z-treecell-content > .menu-href.z-a {
	margin-left: var(--zk-tree-menu-link-margin-inline-start);
}
.z-treecell-text {
	margin-left: var(--zk-tree-text-margin-inline-start);
}

div.z-treefooter-content, div.z-treecell-content, div.z-treecol-content, 
tr.z-treerow, tr.z-treerow a, tr.z-treerow a:visited {
	color: var(--zk-tree-text-color);
}

<%-- move tree item button (mobile only) --%>
.tree-moveitem-btn {
	padding: var(--zk-tree-moveitem-padding); 
	border-radius: var(--zk-tree-moveitem-border-radius);
}
.tree-moveitem-btn.pressed {
	box-shadow: var(--zk-tree-moveitem-pressed-shadow);
}
