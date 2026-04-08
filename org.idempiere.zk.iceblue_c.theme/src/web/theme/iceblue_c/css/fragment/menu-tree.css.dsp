<%@ taglib uri="http://www.zkoss.org/dsp/web/core" prefix="c" %>
<%@ taglib uri="http://www.idempiere.org/dsp/web/util" prefix="u" %>

:root {
	--zk-menu-tree-color-selected-border: var(--zk-color-selected-border);
	--zk-menu-tree-font-weight-normal: var(--zk-font-weight-normal);
	--zk-menu-tree-size-0: var(--zk-size-0);
	--zk-menu-tree-space-0: var(--zk-space-0);
	--zk-menu-tree-space-xs: var(--zk-space-xs);
	--zk-menu-tree-text-color-disabled-soft: var(--zk-text-color-disabled-soft);
	--zk-menu-tree-text-decoration-none: var(--zk-text-decoration-none);
}

.menu-treecell-cnt {
	border: var(--zk-menu-tree-size-0); margin: var(--zk-menu-tree-space-0); padding: var(--zk-menu-tree-space-0);
	${fontFamilyC};
	${fontSizeM}; 
	font-weight: var(--zk-menu-tree-font-weight-normal);
    overflow-x: hidden;
	white-space: nowrap;
    text-overflow: ellipsis !important;
    cursor: pointer;
}

div.z-tree-body td.menu-tree-cell {
	cursor: pointer;
	padding: 0 var(--zk-menu-tree-space-xs);
   	${fontSizeM};
   	font-weight: var(--zk-menu-tree-font-weight-normal);
   	overflow: visible;
}

div.menu-tree-cell-cnt {
	border: var(--zk-menu-tree-size-0); margin: var(--zk-menu-tree-space-0); padding: var(--zk-menu-tree-space-0);
	${fontFamilyC};
	${fontSizeM}; 
	font-weight: var(--zk-menu-tree-font-weight-normal);
	white-space: nowrap
}

td.menu-tree-cell-disd * {
	color: var(--zk-menu-tree-text-color-disabled-soft) !important; cursor: default!important;
}

td.menu-tree-cell-disd a:visited, td.menu-tree-cell-disd a:hover {
	text-decoration: var(--zk-menu-tree-text-decoration-none) !important;
	cursor: default !important;
	border-color: var(--zk-menu-tree-color-selected-border) !important;
}

div.z-dottree-body td.menu-tree-cell {
	cursor: pointer; padding: 0 var(--zk-menu-tree-space-xs);
	${fontSizeM}; 
	font-weight: var(--zk-menu-tree-font-weight-normal); overflow: visible;
}

div.z-filetree-body td.menu-tree-cell {
	cursor: pointer; padding: 0 var(--zk-menu-tree-space-xs);
	${fontSizeM}; 
	font-weight: var(--zk-menu-tree-font-weight-normal); overflow: visible;
}

div.z-vfiletree-body td.menu-tree-cell {
	cursor: pointer; padding: 0 var(--zk-menu-tree-space-xs);
	${fontSizeM}; 
	font-weight: var(--zk-menu-tree-font-weight-normal); overflow: visible;
}
