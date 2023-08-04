/**
 * Copyright (c) 2021, 2023 Obeo.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *      Obeo - initial API and implementation
 */
package org.eclipse.sirius.components.view.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.eclipse.sirius.components.view.ManuallyDefinedStrategy;
import org.eclipse.sirius.components.view.ViewPackage;

/**
 * This is the item provider adapter for a {@link org.eclipse.sirius.components.view.ManuallyDefinedStrategy} object.
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 *
 * @generated
 */
public class ManuallyDefinedStrategyItemProvider extends SemanticZoomStrategyItemProvider {
    /**
     * This constructs an instance from a factory and a notifier. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public ManuallyDefinedStrategyItemProvider(AdapterFactory adapterFactory) {
        super(adapterFactory);
    }

    /**
     * This returns the property descriptors for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
        if (this.itemPropertyDescriptors == null) {
            super.getPropertyDescriptors(object);

            this.addZoomDetailledPropertyDescriptor(object);
            this.addZoomNormalPropertyDescriptor(object);
            this.addZoomSummarizedPropertyDescriptor(object);
        }
        return this.itemPropertyDescriptors;
    }

    /**
     * This adds a property descriptor for the Zoom Detailled feature. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected void addZoomDetailledPropertyDescriptor(Object object) {
        this.itemPropertyDescriptors.add(this.createItemPropertyDescriptor(((ComposeableAdapterFactory) this.adapterFactory).getRootAdapterFactory(), this.getResourceLocator(),
                this.getString("_UI_ManuallyDefinedStrategy_zoomDetailled_feature"),
                this.getString("_UI_PropertyDescriptor_description", "_UI_ManuallyDefinedStrategy_zoomDetailled_feature", "_UI_ManuallyDefinedStrategy_type"),
                ViewPackage.Literals.MANUALLY_DEFINED_STRATEGY__ZOOM_DETAILLED, true, false, false, ItemPropertyDescriptor.REAL_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Zoom Normal feature. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected void addZoomNormalPropertyDescriptor(Object object) {
        this.itemPropertyDescriptors.add(this.createItemPropertyDescriptor(((ComposeableAdapterFactory) this.adapterFactory).getRootAdapterFactory(), this.getResourceLocator(),
                this.getString("_UI_ManuallyDefinedStrategy_zoomNormal_feature"),
                this.getString("_UI_PropertyDescriptor_description", "_UI_ManuallyDefinedStrategy_zoomNormal_feature", "_UI_ManuallyDefinedStrategy_type"),
                ViewPackage.Literals.MANUALLY_DEFINED_STRATEGY__ZOOM_NORMAL, true, false, false, ItemPropertyDescriptor.REAL_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Zoom Summarized feature. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected void addZoomSummarizedPropertyDescriptor(Object object) {
        this.itemPropertyDescriptors.add(this.createItemPropertyDescriptor(((ComposeableAdapterFactory) this.adapterFactory).getRootAdapterFactory(), this.getResourceLocator(),
                this.getString("_UI_ManuallyDefinedStrategy_zoomSummarized_feature"),
                this.getString("_UI_PropertyDescriptor_description", "_UI_ManuallyDefinedStrategy_zoomSummarized_feature", "_UI_ManuallyDefinedStrategy_type"),
                ViewPackage.Literals.MANUALLY_DEFINED_STRATEGY__ZOOM_SUMMARIZED, true, false, false, ItemPropertyDescriptor.REAL_VALUE_IMAGE, null, null));
    }

    /**
     * This returns ManuallyDefinedStrategy.gif. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Object getImage(Object object) {
        return this.overlayImage(object, this.getResourceLocator().getImage("full/obj16/ManuallyDefinedStrategy"));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected boolean shouldComposeCreationImage() {
        return true;
    }

    /**
     * This returns the label text for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public String getText(Object object) {
        ManuallyDefinedStrategy manuallyDefinedStrategy = (ManuallyDefinedStrategy) object;
        return this.getString("_UI_ManuallyDefinedStrategy_type") + " " + manuallyDefinedStrategy.isActiveStrategy();
    }

    /**
     * This handles model notifications by calling {@link #updateChildren} to update any cached children and by creating
     * a viewer notification, which it passes to {@link #fireNotifyChanged}. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @generated
     */
    @Override
    public void notifyChanged(Notification notification) {
        this.updateChildren(notification);

        switch (notification.getFeatureID(ManuallyDefinedStrategy.class)) {
            case ViewPackage.MANUALLY_DEFINED_STRATEGY__ZOOM_DETAILLED:
            case ViewPackage.MANUALLY_DEFINED_STRATEGY__ZOOM_NORMAL:
            case ViewPackage.MANUALLY_DEFINED_STRATEGY__ZOOM_SUMMARIZED:
                this.fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
                return;
        }
        super.notifyChanged(notification);
    }

    /**
     * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children that can be created
     * under this object. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
        super.collectNewChildDescriptors(newChildDescriptors, object);
    }

    /**
     * This returns the label text for {@link org.eclipse.emf.edit.command.CreateChildCommand}. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public String getCreateChildText(Object owner, Object feature, Object child, Collection<?> selection) {
        Object childFeature = feature;
        Object childObject = child;

        boolean qualify = childFeature == ViewPackage.Literals.SEMANTIC_ZOOM_STRATEGY__STYLE_DETAILLED || childFeature == ViewPackage.Literals.SEMANTIC_ZOOM_STRATEGY__STYLE_NORMAL
                || childFeature == ViewPackage.Literals.SEMANTIC_ZOOM_STRATEGY__STYLE_SUMMARIZED;

        if (qualify) {
            return this.getString("_UI_CreateChild_text2", new Object[] { this.getTypeText(childObject), this.getFeatureText(childFeature), this.getTypeText(owner) });
        }
        return super.getCreateChildText(owner, feature, child, selection);
    }

}
