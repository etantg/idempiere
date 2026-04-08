.find-window-simple .z-south .z-hbox, .find-window-advanced .z-south .z-hbox {
	margin-top: 5px;
}

.find-window-simple .img-btn, .find-window-simple .img-btn.btn-ok.z-button, .find-window-simple .img-btn.btn-cancel.z-button,
.find-window-advanced .img-btn, .find-window-advanced .img-btn.btn-ok.z-button, .find-window-advanced .img-btn.btn-cancel.z-button {
	margin: 0 var(--zk-space-xs);
}

.find-window .z-window-content {
	padding-bottom: 0px;	
}
.find-window .z-grid.z-flex-item,
.find-window .z-listbox.z-flex-item,
.find-window .z-toolbar,
.find-window .z-south-body>.z-hbox {
	width: calc(100% - var(--zk-dimension-hairline));
}
.find-window .z-toolbar {
	border-bottom: 0px;
}

/* Modern Popup Container */
.modern-popup-container {
    background: var(--zk-color-surface);
    border: none;
    padding: 0;
    margin: 0;
    border-radius: var(--zk-radius-md);
    box-shadow: 0 8px 32px var(--zk-color-shadow-medium);
    min-width: 240px;
    overflow: hidden;
    backdrop-filter: blur(10px);
}

/* Mobile-specific styling */
@media (max-width: 768px) {
    .modern-popup-container {
        min-width: 280px;
        max-width: 90vw;
	    border-radius: var(--zk-radius-md);
        box-shadow: 0 12px 40px var(--zk-color-shadow-strong);
    }
}

@media (max-width: 480px) {
    .modern-popup-container {
        min-width: 320px;
        max-width: 95vw;
	    border-radius: var(--zk-radius-md);
    }
}

/* Fix for ZK Popup content padding - only for modern popups */
.modern-popup.z-popup .z-popup-content {
    padding: 0 !important;
    border: none !important;
    background: transparent !important;
}

/* Modern Checkbox Items & Modern Menu Item (Button styling) */
.modern-checkbox-item,
.modern-menu-item {
    padding: var(--zk-space-4xl-minus) var(--zk-space-4xl-plus);
    margin: 0;
    font-size: var(--zk-font-size-base);
    color: var(--zk-text-color-deep);
    transition: all 0.2s cubic-bezier(0.4, 0, 0.2, 1);
    cursor: pointer;
    width: 100%;
    box-sizing: border-box;
    font-weight: var(--zk-font-weight-medium);
    letter-spacing: 0.3px;
    display: flex;
    align-items: center;
    border: none;
    background: transparent;
    min-height: 44px; /* Minimum touch target size */
}

/* Modern Menu Item (Button styling) */
.modern-menu-item {
    text-align: left;
    outline: none;
}

/* Mobile-specific checkbox styling */
@media (max-width: 768px) {
    .modern-checkbox-item {
        padding: 16px var(--zk-space-5xl);
        font-size: var(--zk-font-size-lg);
        min-height: 48px;
        letter-spacing: 0.2px;
    }
}

@media (max-width: 480px) {
    .modern-checkbox-item {
        padding: var(--zk-space-4xl-plus) 22px;
        font-size: var(--zk-font-size-lg);
        min-height: 52px;
        font-weight: var(--zk-font-weight-normal);
    }
}

/* Touch-friendly hover effects for mobile */
@media (max-width: 768px) {
    .modern-checkbox-item:hover,
    .modern-menu-item:hover {
        background: linear-gradient(135deg, var(--zk-color-surface-soft) 0%, var(--zk-color-accent-soft) 100%);
        transform: none; /* Remove transform on mobile for better performance */
    }
    
    .modern-menu-delete:hover {
        background: linear-gradient(135deg, var(--zk-color-surface-danger-soft) 0%, var(--zk-color-danger-soft) 100%);
        transform: none;
    }
    
    /* Add active states for touch feedback */
    .modern-checkbox-item:active,
    .modern-menu-item:active {
        background: var(--zk-color-accent-soft);
        transform: none;
    }
    
    .modern-menu-delete:active {
        background: var(--zk-color-danger-soft);
        transform: none;
    }
}

/* Separator between items */
.modern-checkbox-item:not(:last-child) {
    border-bottom: 1px solid var(--zk-color-neutral-475);
}

/* Mobile-specific menu item styling */
@media (max-width: 768px) {
    .modern-menu-item {
        padding: 16px var(--zk-space-5xl);
        font-size: var(--zk-font-size-lg);
        min-height: 48px;
        letter-spacing: 0.2px;
    }
}

@media (max-width: 480px) {
    .modern-menu-item {
        padding: var(--zk-space-4xl-plus) 22px;
        font-size: var(--zk-font-size-lg);
        min-height: 52px;
        font-weight: var(--zk-font-weight-normal);
    }
}

.modern-menu-item:hover {
    background: linear-gradient(135deg, var(--zk-color-surface-soft) 0%, var(--zk-color-accent-soft) 100%);
    transform: translateX(2px);
}

.modern-menu-item:active {
    transform: translateX(1px);
    background: var(--zk-color-accent-soft);
}

/* Delete button specific styling */
.modern-menu-delete {
    color: var(--zk-color-danger-hover);
    font-weight: var(--zk-font-weight-semibold);
}

.modern-menu-delete:hover {
    background: linear-gradient(135deg, var(--zk-color-surface-danger-soft) 0%, var(--zk-color-danger-soft) 100%);
    color: var(--zk-color-danger-active);
}

.modern-menu-delete:active {
    background: var(--zk-color-danger-soft);
    transform: translateX(1px);
}

/* Modern Separator */
.modern-separator {
    border: none;
    height: var(--zk-dimension-hairline);
    background: linear-gradient(90deg, transparent 0%, var(--zk-color-accent-subtle) 50%, transparent 100%);
    margin: var(--zk-space-xl) var(--zk-space-3xl);
}

/* Checkbox styling with mobile improvements */
.modern-checkbox-item .z-checkbox-content {
    font-size: var(--zk-font-size-base);
    font-weight: var(--zk-font-weight-medium);
    color: inherit;
}

.modern-checkbox-item .z-checkbox {
    margin-right: var(--zk-space-3xl);
    min-width: var(--zk-dimension-control-sm);
    min-height: var(--zk-dimension-control-sm);
}

@media (max-width: 768px) {
    .modern-checkbox-item .z-checkbox-content {
        font-size: var(--zk-font-size-lg);
        font-weight: var(--zk-font-weight-normal);
    }
    
    .modern-checkbox-item .z-checkbox {
        margin-right: 16px;
        min-width: var(--zk-dimension-control-md);
        min-height: var(--zk-dimension-control-md);
    }
}

.modern-checkbox-item .z-checkbox-input:checked + .z-checkbox-content::before {
    background: var(--zk-text-color-link);
    border-color: var(--zk-text-color-link);
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