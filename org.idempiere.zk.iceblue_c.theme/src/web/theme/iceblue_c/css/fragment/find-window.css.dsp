:root {
	--zk-find-border-none: var(--zk-border-none);
	--zk-find-color-accent-soft: var(--zk-color-accent-soft);
	--zk-find-color-accent-subtle: var(--zk-color-accent-subtle);
	--zk-find-color-danger-active: var(--zk-color-danger-active);
	--zk-find-color-danger-hover: var(--zk-color-danger-hover);
	--zk-find-color-danger-soft: var(--zk-color-danger-soft);
	--zk-find-color-neutral-475: var(--zk-color-neutral-475);
	--zk-find-color-shadow-medium: var(--zk-color-shadow-medium);
	--zk-find-color-shadow-strong: var(--zk-color-shadow-strong);
	--zk-find-color-surface: var(--zk-color-surface);
	--zk-find-color-surface-danger-soft: var(--zk-color-surface-danger-soft);
	--zk-find-color-surface-soft: var(--zk-color-surface-soft);
	--zk-find-color-transparent: var(--zk-color-transparent);
	--zk-find-dimension-control-md: var(--zk-dimension-control-md);
	--zk-find-dimension-control-sm: var(--zk-dimension-control-sm);
	--zk-find-dimension-hairline: var(--zk-dimension-hairline);
	--zk-find-font-size-base: var(--zk-font-size-base);
	--zk-find-font-size-lg: var(--zk-font-size-lg);
	--zk-find-font-weight-medium: var(--zk-font-weight-medium);
	--zk-find-font-weight-normal: var(--zk-font-weight-normal);
	--zk-find-font-weight-semibold: var(--zk-font-weight-semibold);
	--zk-find-radius-md: var(--zk-radius-md);
	--zk-find-size-0: var(--zk-size-0);
	--zk-find-size-1: var(--zk-size-1);
	--zk-find-size-10: var(--zk-size-10);
	--zk-find-size-12: var(--zk-size-12);
	--zk-find-size-16: var(--zk-size-16);
	--zk-find-size-2: var(--zk-size-2);
	--zk-find-size-22: var(--zk-size-22);
	--zk-find-size-240: var(--zk-size-240);
	--zk-find-size-280: var(--zk-size-280);
	--zk-find-size-32: var(--zk-size-32);
	--zk-find-size-320: var(--zk-size-320);
	--zk-find-size-40: var(--zk-size-40);
	--zk-find-size-44: var(--zk-size-44);
	--zk-find-size-48: var(--zk-size-48);
	--zk-find-size-50pct: var(--zk-size-50pct);
	--zk-find-size-52: var(--zk-size-52);
	--zk-find-size-8: var(--zk-size-8);
	--zk-find-size-90vw: var(--zk-size-90vw);
	--zk-find-size-95vw: var(--zk-size-95vw);
	--zk-find-size-full: var(--zk-size-full);
	--zk-find-space-0: var(--zk-space-0);
	--zk-find-space-3xl: var(--zk-space-3xl);
	--zk-find-space-4xl-minus: var(--zk-space-4xl-minus);
	--zk-find-space-4xl-plus: var(--zk-space-4xl-plus);
	--zk-find-space-5xl: var(--zk-space-5xl);
	--zk-find-space-lg: var(--zk-space-lg);
	--zk-find-space-xl: var(--zk-space-xl);
	--zk-find-space-xs: var(--zk-space-xs);
	--zk-find-text-color-deep: var(--zk-text-color-deep);
	--zk-find-text-color-link: var(--zk-text-color-link);
}

.find-window-simple .z-south .z-hbox, .find-window-advanced .z-south .z-hbox {
	margin-top: var(--zk-find-space-lg);
}

.find-window-simple .img-btn, .find-window-simple .img-btn.btn-ok.z-button, .find-window-simple .img-btn.btn-cancel.z-button,
.find-window-advanced .img-btn, .find-window-advanced .img-btn.btn-ok.z-button, .find-window-advanced .img-btn.btn-cancel.z-button {
	margin: 0 var(--zk-find-space-xs);
}

.find-window .z-window-content {
	padding-bottom: var(--zk-find-space-0);	
}
.find-window .z-grid.z-flex-item,
.find-window .z-listbox.z-flex-item,
.find-window .z-toolbar,
.find-window .z-south-body>.z-hbox {
	width: calc(var(--zk-find-size-full) - var(--zk-find-dimension-hairline));
}
.find-window .z-toolbar {
	border-bottom: var(--zk-find-size-0);
}

/* Modern Popup Container */
.modern-popup-container {
    background: var(--zk-find-color-surface);
    border: var(--zk-find-border-none);
    padding: var(--zk-find-space-0);
    margin: var(--zk-find-space-0);
    border-radius: var(--zk-find-radius-md);
    box-shadow: 0 var(--zk-find-size-8) var(--zk-find-size-32) var(--zk-find-color-shadow-medium);
    min-width: var(--zk-find-size-240);
    overflow: hidden;
    backdrop-filter: blur(var(--zk-find-size-10));
}

/* Mobile-specific styling */
@media (max-width: 768px) {
    .modern-popup-container {
        min-width: var(--zk-find-size-280);
        max-width: var(--zk-find-size-90vw);
	    border-radius: var(--zk-find-radius-md);
        box-shadow: 0 var(--zk-find-size-12) var(--zk-find-size-40) var(--zk-find-color-shadow-strong);
    }
}

@media (max-width: 480px) {
    .modern-popup-container {
        min-width: var(--zk-find-size-320);
        max-width: var(--zk-find-size-95vw);
	    border-radius: var(--zk-find-radius-md);
    }
}

/* Fix for ZK Popup content padding - only for modern popups */
.modern-popup.z-popup .z-popup-content {
    padding: var(--zk-find-space-0) !important;
    border: var(--zk-find-border-none) !important;
    background: var(--zk-find-color-transparent) !important;
}

/* Modern Checkbox Items */
.modern-checkbox-item {
    padding: var(--zk-find-space-4xl-minus) var(--zk-find-space-4xl-plus);
    margin: var(--zk-find-space-0);
    font-size: var(--zk-find-font-size-base);
    color: var(--zk-find-text-color-deep);
    transition: all 0.2s cubic-bezier(0.4, 0, 0.2, 1);
    cursor: pointer;
    width: var(--zk-find-size-full);
    box-sizing: border-box;
    font-weight: var(--zk-find-font-weight-medium);
    letter-spacing: calc(var(--zk-find-size-1) * 0.3);
    display: flex;
    align-items: center;
    border: var(--zk-find-border-none);
    background: var(--zk-find-color-transparent);
    min-height: var(--zk-find-size-44); /* Minimum touch target size */
}

/* Mobile-specific checkbox styling */
@media (max-width: 768px) {
    .modern-checkbox-item {
        padding: var(--zk-find-size-16) var(--zk-find-space-5xl);
        font-size: var(--zk-find-font-size-lg);
        min-height: var(--zk-find-size-48);
        letter-spacing: calc(var(--zk-find-size-1) * 0.2);
    }
}

@media (max-width: 480px) {
    .modern-checkbox-item {
        padding: var(--zk-find-space-4xl-plus) var(--zk-find-size-22);
        font-size: var(--zk-find-font-size-lg);
        min-height: var(--zk-find-size-52);
        font-weight: var(--zk-find-font-weight-normal);
    }
}

/* Touch-friendly hover effects for mobile */
@media (max-width: 768px) {
    .modern-checkbox-item:hover,
    .modern-menu-item:hover {
        background: linear-gradient(135deg, var(--zk-find-color-surface-soft) 0%, var(--zk-find-color-accent-soft) var(--zk-find-size-full));
        transform: none; /* Remove transform on mobile for better performance */
    }
    
    .modern-menu-delete:hover {
        background: linear-gradient(135deg, var(--zk-find-color-surface-danger-soft) 0%, var(--zk-find-color-danger-soft) var(--zk-find-size-full));
        transform: none;
    }
    
    /* Add active states for touch feedback */
    .modern-checkbox-item:active,
    .modern-menu-item:active {
        background: var(--zk-find-color-accent-soft);
        transform: none;
    }
    
    .modern-menu-delete:active {
        background: var(--zk-find-color-danger-soft);
        transform: none;
    }
}

/* Separator between items */
.modern-checkbox-item:not(:last-child) {
    border-bottom: var(--zk-find-size-1) solid var(--zk-find-color-neutral-475);
}

/* Modern Menu Item (Button styling) */
.modern-menu-item {
    padding: var(--zk-find-space-4xl-minus) var(--zk-find-space-4xl-plus);
    margin: var(--zk-find-space-0);
    font-size: var(--zk-find-font-size-base);
    color: var(--zk-find-text-color-deep);
    transition: all 0.2s cubic-bezier(0.4, 0, 0.2, 1);
    cursor: pointer;
    width: var(--zk-find-size-full);
    box-sizing: border-box;
    font-weight: var(--zk-find-font-weight-medium);
    letter-spacing: calc(var(--zk-find-size-1) * 0.3);
    display: flex;
    align-items: center;
    border: var(--zk-find-border-none);
    background: var(--zk-find-color-transparent);
    text-align: left;
    outline: none;
    min-height: var(--zk-find-size-44); /* Minimum touch target size */
}

/* Mobile-specific menu item styling */
@media (max-width: 768px) {
    .modern-menu-item {
        padding: var(--zk-find-size-16) var(--zk-find-space-5xl);
        font-size: var(--zk-find-font-size-lg);
        min-height: var(--zk-find-size-48);
        letter-spacing: calc(var(--zk-find-size-1) * 0.2);
    }
}

@media (max-width: 480px) {
    .modern-menu-item {
        padding: var(--zk-find-space-4xl-plus) var(--zk-find-size-22);
        font-size: var(--zk-find-font-size-lg);
        min-height: var(--zk-find-size-52);
        font-weight: var(--zk-find-font-weight-normal);
    }
}

.modern-menu-item:hover {
    background: linear-gradient(135deg, var(--zk-find-color-surface-soft) 0%, var(--zk-find-color-accent-soft) var(--zk-find-size-full));
    transform: translateX(var(--zk-find-size-2));
}

.modern-menu-item:active {
    transform: translateX(var(--zk-find-size-1));
    background: var(--zk-find-color-accent-soft);
}

/* Delete button specific styling */
.modern-menu-delete {
    color: var(--zk-find-color-danger-hover);
    font-weight: var(--zk-find-font-weight-semibold);
}

.modern-menu-delete:hover {
    background: linear-gradient(135deg, var(--zk-find-color-surface-danger-soft) 0%, var(--zk-find-color-danger-soft) var(--zk-find-size-full));
    color: var(--zk-find-color-danger-active);
}

.modern-menu-delete:active {
    background: var(--zk-find-color-danger-soft);
    transform: translateX(var(--zk-find-size-1));
}

/* Modern Separator */
.modern-separator {
    border: var(--zk-find-border-none);
    height: var(--zk-find-dimension-hairline);
    background: linear-gradient(90deg, transparent 0%, var(--zk-find-color-accent-subtle) var(--zk-find-size-50pct), transparent var(--zk-find-size-full));
    margin: var(--zk-find-space-xl) var(--zk-find-space-3xl);
}

/* Checkbox styling with mobile improvements */
.modern-checkbox-item .z-checkbox-content {
    font-size: var(--zk-find-font-size-base);
    font-weight: var(--zk-find-font-weight-medium);
    color: inherit;
}

.modern-checkbox-item .z-checkbox {
    margin-right: var(--zk-find-space-3xl);
    min-width: var(--zk-find-dimension-control-sm);
    min-height: var(--zk-find-dimension-control-sm);
}

@media (max-width: 768px) {
    .modern-checkbox-item .z-checkbox-content {
        font-size: var(--zk-find-font-size-lg);
        font-weight: var(--zk-find-font-weight-normal);
    }
    
    .modern-checkbox-item .z-checkbox {
        margin-right: var(--zk-find-size-16);
        min-width: var(--zk-find-dimension-control-md);
        min-height: var(--zk-find-dimension-control-md);
    }
}

.modern-checkbox-item .z-checkbox-input:checked + .z-checkbox-content::before {
    background: var(--zk-find-text-color-link);
    border-color: var(--zk-find-text-color-link);
}

/* Animation for popup appearance */
.modern-popup-container {
    animation: popupFadeIn 0.3s cubic-bezier(0.4, 0, 0.2, 1);
}

@keyframes popupFadeIn {
    from {
        opacity: 0;
        transform: translateY(-10px) scale(0.95);
    }
    to {
        opacity: 1;
        transform: translateY(0) scale(1);
    }
}