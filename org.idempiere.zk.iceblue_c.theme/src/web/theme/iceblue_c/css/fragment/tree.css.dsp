<%@ taglib uri="http://www.zkoss.org/dsp/web/core" prefix="c" %>
<%-- z-tree customization --%>
.z-treecell-content {
	${fontFamilyC};
	${fontSizeM};
}
@media screen and (min-width: 768px) {
	.z-treecell-content {
		padding: 0px var(--zk-space-2xs);
	}
}

@media screen and (max-width: 767px) {
	.z-treecell-content {
		padding: var(--zk-space-xs) var(--zk-space-2xs);
	}
}
.z-treecell-content > .menu-href.z-a {
	margin-left: var(--zk-space-xl);
}
.z-treecell-text {
	margin-left: 0px;
}

div.z-treefooter-content, div.z-treecell-content, div.z-treecol-content, 
tr.z-treerow, tr.z-treerow a, tr.z-treerow a:visited {
	color: var(--zk-text-color-default);
}

<%-- move tree item button (mobile only) --%>
.tree-moveitem-btn {
	padding: var(--zk-space-xs) var(--zk-space-md); 
	border-radius: 3px;
}
.tree-moveitem-btn.pressed {
	box-shadow: inset 0 0 0 1px var(--zk-shadow-inner-light), inset 0 3px 15px var(--zk-shadow-inner-dark);
}
