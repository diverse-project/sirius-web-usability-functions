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
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IChildCreationExtender;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.eclipse.sirius.components.view.SemanticZoomStrategy;
import org.eclipse.sirius.components.view.ViewFactory;
import org.eclipse.sirius.components.view.ViewPackage;

/**
 * This is the item provider adapter for a {@link org.eclipse.sirius.components.view.SemanticZoomStrategy} object. <!--
 * begin-user-doc --> <!-- end-user-doc -->
 *
 * @generated
 */
public class SemanticZoomStrategyItemProvider extends ItemProviderAdapter
        implements IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {
    /**
     * This constructs an instance from a factory and a notifier. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public SemanticZoomStrategyItemProvider(AdapterFactory adapterFactory) {
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

            this.addActiveStrategyPropertyDescriptor(object);
        }
        return this.itemPropertyDescriptors;
    }

    /**
     * This adds a property descriptor for the Active Strategy feature. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected void addActiveStrategyPropertyDescriptor(Object object) {
        this.itemPropertyDescriptors.add(this.createItemPropertyDescriptor(((ComposeableAdapterFactory) this.adapterFactory).getRootAdapterFactory(), this.getResourceLocator(),
                this.getString("_UI_SemanticZoomStrategy_activeStrategy_feature"),
                this.getString("_UI_PropertyDescriptor_description", "_UI_SemanticZoomStrategy_activeStrategy_feature", "_UI_SemanticZoomStrategy_type"),
                ViewPackage.Literals.SEMANTIC_ZOOM_STRATEGY__ACTIVE_STRATEGY, true, false, false, ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, null, null));
    }

    /**
     * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
     * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
     * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     */
    @Override
    public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
        if (this.childrenFeatures == null) {
            super.getChildrenFeatures(object);
            this.childrenFeatures.add(ViewPackage.Literals.SEMANTIC_ZOOM_STRATEGY__STYLE_DETAILLED);
            this.childrenFeatures.add(ViewPackage.Literals.SEMANTIC_ZOOM_STRATEGY__STYLE_NORMAL);
            this.childrenFeatures.add(ViewPackage.Literals.SEMANTIC_ZOOM_STRATEGY__STYLE_SUMMARIZED);
        }
        return this.childrenFeatures;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EStructuralFeature getChildFeature(Object object, Object child) {
        // Check the type of the specified child object and return the proper feature to use for
        // adding (see {@link AddCommand}) it as a child.

        return super.getChildFeature(object, child);
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
        SemanticZoomStrategy semanticZoomStrategy = (SemanticZoomStrategy) object;
        return this.getString("_UI_SemanticZoomStrategy_type") + " " + semanticZoomStrategy.isActiveStrategy();
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

        switch (notification.getFeatureID(SemanticZoomStrategy.class)) {
            case ViewPackage.SEMANTIC_ZOOM_STRATEGY__ACTIVE_STRATEGY:
                this.fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
                return;
            case ViewPackage.SEMANTIC_ZOOM_STRATEGY__STYLE_DETAILLED:
            case ViewPackage.SEMANTIC_ZOOM_STRATEGY__STYLE_NORMAL:
            case ViewPackage.SEMANTIC_ZOOM_STRATEGY__STYLE_SUMMARIZED:
                this.fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
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

        newChildDescriptors.add(this.createChildParameter(ViewPackage.Literals.SEMANTIC_ZOOM_STRATEGY__STYLE_DETAILLED, ViewFactory.eINSTANCE.createRectangularNodeStyleDescription()));

        newChildDescriptors.add(this.createChildParameter(ViewPackage.Literals.SEMANTIC_ZOOM_STRATEGY__STYLE_DETAILLED, ViewFactory.eINSTANCE.createImageNodeStyleDescription()));

        newChildDescriptors.add(this.createChildParameter(ViewPackage.Literals.SEMANTIC_ZOOM_STRATEGY__STYLE_DETAILLED, ViewFactory.eINSTANCE.createIconLabelNodeStyleDescription()));

        newChildDescriptors.add(this.createChildParameter(ViewPackage.Literals.SEMANTIC_ZOOM_STRATEGY__STYLE_DETAILLED, ViewFactory.eINSTANCE.createEmptyNodeStyleDescription()));

        newChildDescriptors.add(this.createChildParameter(ViewPackage.Literals.SEMANTIC_ZOOM_STRATEGY__STYLE_NORMAL, ViewFactory.eINSTANCE.createRectangularNodeStyleDescription()));

        newChildDescriptors.add(this.createChildParameter(ViewPackage.Literals.SEMANTIC_ZOOM_STRATEGY__STYLE_NORMAL, ViewFactory.eINSTANCE.createImageNodeStyleDescription()));

        newChildDescriptors.add(this.createChildParameter(ViewPackage.Literals.SEMANTIC_ZOOM_STRATEGY__STYLE_NORMAL, ViewFactory.eINSTANCE.createIconLabelNodeStyleDescription()));

        newChildDescriptors.add(this.createChildParameter(ViewPackage.Literals.SEMANTIC_ZOOM_STRATEGY__STYLE_NORMAL, ViewFactory.eINSTANCE.createEmptyNodeStyleDescription()));

        newChildDescriptors.add(this.createChildParameter(ViewPackage.Literals.SEMANTIC_ZOOM_STRATEGY__STYLE_SUMMARIZED, ViewFactory.eINSTANCE.createRectangularNodeStyleDescription()));

        newChildDescriptors.add(this.createChildParameter(ViewPackage.Literals.SEMANTIC_ZOOM_STRATEGY__STYLE_SUMMARIZED, ViewFactory.eINSTANCE.createImageNodeStyleDescription()));

        newChildDescriptors.add(this.createChildParameter(ViewPackage.Literals.SEMANTIC_ZOOM_STRATEGY__STYLE_SUMMARIZED, ViewFactory.eINSTANCE.createIconLabelNodeStyleDescription()));

        newChildDescriptors.add(this.createChildParameter(ViewPackage.Literals.SEMANTIC_ZOOM_STRATEGY__STYLE_SUMMARIZED, ViewFactory.eINSTANCE.createEmptyNodeStyleDescription()));
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

    /**
     * Return the resource locator for this item provider's resources. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public ResourceLocator getResourceLocator() {
        return ((IChildCreationExtender) this.adapterFactory).getResourceLocator();
    }

}
