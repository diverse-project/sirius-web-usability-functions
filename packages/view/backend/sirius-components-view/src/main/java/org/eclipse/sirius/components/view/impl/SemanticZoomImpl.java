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
package org.eclipse.sirius.components.view.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.sirius.components.view.SemanticZoom;
import org.eclipse.sirius.components.view.ViewPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Semantic Zoom</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.sirius.components.view.impl.SemanticZoomImpl#isActiveSemanticZoom <em>Active Semantic
 * Zoom</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SemanticZoomImpl extends MinimalEObjectImpl.Container implements SemanticZoom {
    /**
     * The default value of the '{@link #isActiveSemanticZoom() <em>Active Semantic Zoom</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #isActiveSemanticZoom()
     * @generated
     * @ordered
     */
    protected static final boolean ACTIVE_SEMANTIC_ZOOM_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isActiveSemanticZoom() <em>Active Semantic Zoom</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #isActiveSemanticZoom()
     * @generated
     * @ordered
     */
    protected boolean activeSemanticZoom = ACTIVE_SEMANTIC_ZOOM_EDEFAULT;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected SemanticZoomImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ViewPackage.Literals.SEMANTIC_ZOOM;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public boolean isActiveSemanticZoom() {
        return this.activeSemanticZoom;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setActiveSemanticZoom(boolean newActiveSemanticZoom) {
        boolean oldActiveSemanticZoom = this.activeSemanticZoom;
        this.activeSemanticZoom = newActiveSemanticZoom;
        if (this.eNotificationRequired())
            this.eNotify(new ENotificationImpl(this, Notification.SET, ViewPackage.SEMANTIC_ZOOM__ACTIVE_SEMANTIC_ZOOM, oldActiveSemanticZoom, this.activeSemanticZoom));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case ViewPackage.SEMANTIC_ZOOM__ACTIVE_SEMANTIC_ZOOM:
                return this.isActiveSemanticZoom();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case ViewPackage.SEMANTIC_ZOOM__ACTIVE_SEMANTIC_ZOOM:
                this.setActiveSemanticZoom((Boolean) newValue);
                return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void eUnset(int featureID) {
        switch (featureID) {
            case ViewPackage.SEMANTIC_ZOOM__ACTIVE_SEMANTIC_ZOOM:
                this.setActiveSemanticZoom(ACTIVE_SEMANTIC_ZOOM_EDEFAULT);
                return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public boolean eIsSet(int featureID) {
        switch (featureID) {
            case ViewPackage.SEMANTIC_ZOOM__ACTIVE_SEMANTIC_ZOOM:
                return this.activeSemanticZoom != ACTIVE_SEMANTIC_ZOOM_EDEFAULT;
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public String toString() {
        if (this.eIsProxy())
            return super.toString();

        StringBuilder result = new StringBuilder(super.toString());
        result.append(" (activeSemanticZoom: ");
        result.append(this.activeSemanticZoom);
        result.append(')');
        return result.toString();
    }

} // SemanticZoomImpl
