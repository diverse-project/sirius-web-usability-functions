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
import org.eclipse.sirius.components.view.ManuallyDefinedStrategy;
import org.eclipse.sirius.components.view.ViewPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Manually Defined Strategy</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.sirius.components.view.impl.ManuallyDefinedStrategyImpl#getZoomDetailled <em>Zoom
 * Detailled</em>}</li>
 * <li>{@link org.eclipse.sirius.components.view.impl.ManuallyDefinedStrategyImpl#getZoomNormal <em>Zoom
 * Normal</em>}</li>
 * <li>{@link org.eclipse.sirius.components.view.impl.ManuallyDefinedStrategyImpl#getZoomSummarized <em>Zoom
 * Summarized</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ManuallyDefinedStrategyImpl extends SemanticZoomStrategyImpl implements ManuallyDefinedStrategy {
    /**
     * The default value of the '{@link #getZoomDetailled() <em>Zoom Detailled</em>}' attribute. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @see #getZoomDetailled()
     * @generated
     * @ordered
     */
    protected static final double ZOOM_DETAILLED_EDEFAULT = 1.0;

    /**
     * The cached value of the '{@link #getZoomDetailled() <em>Zoom Detailled</em>}' attribute. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @see #getZoomDetailled()
     * @generated
     * @ordered
     */
    protected double zoomDetailled = ZOOM_DETAILLED_EDEFAULT;

    /**
     * The default value of the '{@link #getZoomNormal() <em>Zoom Normal</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @see #getZoomNormal()
     * @generated
     * @ordered
     */
    protected static final double ZOOM_NORMAL_EDEFAULT = 0.25;

    /**
     * The cached value of the '{@link #getZoomNormal() <em>Zoom Normal</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @see #getZoomNormal()
     * @generated
     * @ordered
     */
    protected double zoomNormal = ZOOM_NORMAL_EDEFAULT;

    /**
     * The default value of the '{@link #getZoomSummarized() <em>Zoom Summarized</em>}' attribute. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @see #getZoomSummarized()
     * @generated
     * @ordered
     */
    protected static final double ZOOM_SUMMARIZED_EDEFAULT = 0.05;

    /**
     * The cached value of the '{@link #getZoomSummarized() <em>Zoom Summarized</em>}' attribute. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @see #getZoomSummarized()
     * @generated
     * @ordered
     */
    protected double zoomSummarized = ZOOM_SUMMARIZED_EDEFAULT;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected ManuallyDefinedStrategyImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ViewPackage.Literals.MANUALLY_DEFINED_STRATEGY;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public double getZoomDetailled() {
        return this.zoomDetailled;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setZoomDetailled(double newZoomDetailled) {
        double oldZoomDetailled = this.zoomDetailled;
        this.zoomDetailled = newZoomDetailled;
        if (this.eNotificationRequired())
            this.eNotify(new ENotificationImpl(this, Notification.SET, ViewPackage.MANUALLY_DEFINED_STRATEGY__ZOOM_DETAILLED, oldZoomDetailled, this.zoomDetailled));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public double getZoomNormal() {
        return this.zoomNormal;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setZoomNormal(double newZoomNormal) {
        double oldZoomNormal = this.zoomNormal;
        this.zoomNormal = newZoomNormal;
        if (this.eNotificationRequired())
            this.eNotify(new ENotificationImpl(this, Notification.SET, ViewPackage.MANUALLY_DEFINED_STRATEGY__ZOOM_NORMAL, oldZoomNormal, this.zoomNormal));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public double getZoomSummarized() {
        return this.zoomSummarized;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setZoomSummarized(double newZoomSummarized) {
        double oldZoomSummarized = this.zoomSummarized;
        this.zoomSummarized = newZoomSummarized;
        if (this.eNotificationRequired())
            this.eNotify(new ENotificationImpl(this, Notification.SET, ViewPackage.MANUALLY_DEFINED_STRATEGY__ZOOM_SUMMARIZED, oldZoomSummarized, this.zoomSummarized));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case ViewPackage.MANUALLY_DEFINED_STRATEGY__ZOOM_DETAILLED:
                return this.getZoomDetailled();
            case ViewPackage.MANUALLY_DEFINED_STRATEGY__ZOOM_NORMAL:
                return this.getZoomNormal();
            case ViewPackage.MANUALLY_DEFINED_STRATEGY__ZOOM_SUMMARIZED:
                return this.getZoomSummarized();
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
            case ViewPackage.MANUALLY_DEFINED_STRATEGY__ZOOM_DETAILLED:
                this.setZoomDetailled((Double) newValue);
                return;
            case ViewPackage.MANUALLY_DEFINED_STRATEGY__ZOOM_NORMAL:
                this.setZoomNormal((Double) newValue);
                return;
            case ViewPackage.MANUALLY_DEFINED_STRATEGY__ZOOM_SUMMARIZED:
                this.setZoomSummarized((Double) newValue);
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
            case ViewPackage.MANUALLY_DEFINED_STRATEGY__ZOOM_DETAILLED:
                this.setZoomDetailled(ZOOM_DETAILLED_EDEFAULT);
                return;
            case ViewPackage.MANUALLY_DEFINED_STRATEGY__ZOOM_NORMAL:
                this.setZoomNormal(ZOOM_NORMAL_EDEFAULT);
                return;
            case ViewPackage.MANUALLY_DEFINED_STRATEGY__ZOOM_SUMMARIZED:
                this.setZoomSummarized(ZOOM_SUMMARIZED_EDEFAULT);
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
            case ViewPackage.MANUALLY_DEFINED_STRATEGY__ZOOM_DETAILLED:
                return this.zoomDetailled != ZOOM_DETAILLED_EDEFAULT;
            case ViewPackage.MANUALLY_DEFINED_STRATEGY__ZOOM_NORMAL:
                return this.zoomNormal != ZOOM_NORMAL_EDEFAULT;
            case ViewPackage.MANUALLY_DEFINED_STRATEGY__ZOOM_SUMMARIZED:
                return this.zoomSummarized != ZOOM_SUMMARIZED_EDEFAULT;
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
        result.append(" (zoomDetailled: ");
        result.append(this.zoomDetailled);
        result.append(", zoomNormal: ");
        result.append(this.zoomNormal);
        result.append(", zoomSummarized: ");
        result.append(this.zoomSummarized);
        result.append(')');
        return result.toString();
    }

} // ManuallyDefinedStrategyImpl
