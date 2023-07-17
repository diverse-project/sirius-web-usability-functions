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
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.sirius.components.view.AutomaticZoomingByDepthStrategy;
import org.eclipse.sirius.components.view.ManuallyDefinedStrategy;
import org.eclipse.sirius.components.view.NumberOfRelationStrategy;
import org.eclipse.sirius.components.view.SemanticZoomDescription;
import org.eclipse.sirius.components.view.ViewPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Semantic Zoom Description</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.sirius.components.view.impl.SemanticZoomDescriptionImpl#getAutomaticZoomingByDepthStrategy
 * <em>Automatic Zooming By Depth Strategy</em>}</li>
 * <li>{@link org.eclipse.sirius.components.view.impl.SemanticZoomDescriptionImpl#getNumberOfRelationStrategy <em>Number
 * Of Relation Strategy</em>}</li>
 * <li>{@link org.eclipse.sirius.components.view.impl.SemanticZoomDescriptionImpl#getManuallyDefinedStrategy
 * <em>Manually Defined Strategy</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SemanticZoomDescriptionImpl extends MinimalEObjectImpl.Container implements SemanticZoomDescription {
    /**
     * The cached value of the '{@link #getAutomaticZoomingByDepthStrategy() <em>Automatic Zooming By Depth
     * Strategy</em>}' containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getAutomaticZoomingByDepthStrategy()
     * @generated
     * @ordered
     */
    protected AutomaticZoomingByDepthStrategy automaticZoomingByDepthStrategy;

    /**
     * The cached value of the '{@link #getNumberOfRelationStrategy() <em>Number Of Relation Strategy</em>}' containment
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getNumberOfRelationStrategy()
     * @generated
     * @ordered
     */
    protected NumberOfRelationStrategy numberOfRelationStrategy;

    /**
     * The cached value of the '{@link #getManuallyDefinedStrategy() <em>Manually Defined Strategy</em>}' containment
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getManuallyDefinedStrategy()
     * @generated
     * @ordered
     */
    protected ManuallyDefinedStrategy manuallyDefinedStrategy;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected SemanticZoomDescriptionImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ViewPackage.Literals.SEMANTIC_ZOOM_DESCRIPTION;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public AutomaticZoomingByDepthStrategy getAutomaticZoomingByDepthStrategy() {
        return this.automaticZoomingByDepthStrategy;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public NotificationChain basicSetAutomaticZoomingByDepthStrategy(AutomaticZoomingByDepthStrategy newAutomaticZoomingByDepthStrategy, NotificationChain msgs) {
        AutomaticZoomingByDepthStrategy oldAutomaticZoomingByDepthStrategy = this.automaticZoomingByDepthStrategy;
        this.automaticZoomingByDepthStrategy = newAutomaticZoomingByDepthStrategy;
        if (this.eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ViewPackage.SEMANTIC_ZOOM_DESCRIPTION__AUTOMATIC_ZOOMING_BY_DEPTH_STRATEGY,
                    oldAutomaticZoomingByDepthStrategy, newAutomaticZoomingByDepthStrategy);
            if (msgs == null)
                msgs = notification;
            else
                msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setAutomaticZoomingByDepthStrategy(AutomaticZoomingByDepthStrategy newAutomaticZoomingByDepthStrategy) {
        if (newAutomaticZoomingByDepthStrategy != this.automaticZoomingByDepthStrategy) {
            NotificationChain msgs = null;
            if (this.automaticZoomingByDepthStrategy != null)
                msgs = ((InternalEObject) this.automaticZoomingByDepthStrategy).eInverseRemove(this,
                        EOPPOSITE_FEATURE_BASE - ViewPackage.SEMANTIC_ZOOM_DESCRIPTION__AUTOMATIC_ZOOMING_BY_DEPTH_STRATEGY, null, msgs);
            if (newAutomaticZoomingByDepthStrategy != null)
                msgs = ((InternalEObject) newAutomaticZoomingByDepthStrategy).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ViewPackage.SEMANTIC_ZOOM_DESCRIPTION__AUTOMATIC_ZOOMING_BY_DEPTH_STRATEGY,
                        null, msgs);
            msgs = this.basicSetAutomaticZoomingByDepthStrategy(newAutomaticZoomingByDepthStrategy, msgs);
            if (msgs != null)
                msgs.dispatch();
        } else if (this.eNotificationRequired())
            this.eNotify(new ENotificationImpl(this, Notification.SET, ViewPackage.SEMANTIC_ZOOM_DESCRIPTION__AUTOMATIC_ZOOMING_BY_DEPTH_STRATEGY, newAutomaticZoomingByDepthStrategy,
                    newAutomaticZoomingByDepthStrategy));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public NumberOfRelationStrategy getNumberOfRelationStrategy() {
        return this.numberOfRelationStrategy;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public NotificationChain basicSetNumberOfRelationStrategy(NumberOfRelationStrategy newNumberOfRelationStrategy, NotificationChain msgs) {
        NumberOfRelationStrategy oldNumberOfRelationStrategy = this.numberOfRelationStrategy;
        this.numberOfRelationStrategy = newNumberOfRelationStrategy;
        if (this.eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ViewPackage.SEMANTIC_ZOOM_DESCRIPTION__NUMBER_OF_RELATION_STRATEGY, oldNumberOfRelationStrategy,
                    newNumberOfRelationStrategy);
            if (msgs == null)
                msgs = notification;
            else
                msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setNumberOfRelationStrategy(NumberOfRelationStrategy newNumberOfRelationStrategy) {
        if (newNumberOfRelationStrategy != this.numberOfRelationStrategy) {
            NotificationChain msgs = null;
            if (this.numberOfRelationStrategy != null)
                msgs = ((InternalEObject) this.numberOfRelationStrategy).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ViewPackage.SEMANTIC_ZOOM_DESCRIPTION__NUMBER_OF_RELATION_STRATEGY, null, msgs);
            if (newNumberOfRelationStrategy != null)
                msgs = ((InternalEObject) newNumberOfRelationStrategy).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ViewPackage.SEMANTIC_ZOOM_DESCRIPTION__NUMBER_OF_RELATION_STRATEGY, null, msgs);
            msgs = this.basicSetNumberOfRelationStrategy(newNumberOfRelationStrategy, msgs);
            if (msgs != null)
                msgs.dispatch();
        } else if (this.eNotificationRequired())
            this.eNotify(new ENotificationImpl(this, Notification.SET, ViewPackage.SEMANTIC_ZOOM_DESCRIPTION__NUMBER_OF_RELATION_STRATEGY, newNumberOfRelationStrategy, newNumberOfRelationStrategy));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public ManuallyDefinedStrategy getManuallyDefinedStrategy() {
        return this.manuallyDefinedStrategy;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public NotificationChain basicSetManuallyDefinedStrategy(ManuallyDefinedStrategy newManuallyDefinedStrategy, NotificationChain msgs) {
        ManuallyDefinedStrategy oldManuallyDefinedStrategy = this.manuallyDefinedStrategy;
        this.manuallyDefinedStrategy = newManuallyDefinedStrategy;
        if (this.eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ViewPackage.SEMANTIC_ZOOM_DESCRIPTION__MANUALLY_DEFINED_STRATEGY, oldManuallyDefinedStrategy,
                    newManuallyDefinedStrategy);
            if (msgs == null)
                msgs = notification;
            else
                msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setManuallyDefinedStrategy(ManuallyDefinedStrategy newManuallyDefinedStrategy) {
        if (newManuallyDefinedStrategy != this.manuallyDefinedStrategy) {
            NotificationChain msgs = null;
            if (this.manuallyDefinedStrategy != null)
                msgs = ((InternalEObject) this.manuallyDefinedStrategy).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ViewPackage.SEMANTIC_ZOOM_DESCRIPTION__MANUALLY_DEFINED_STRATEGY, null, msgs);
            if (newManuallyDefinedStrategy != null)
                msgs = ((InternalEObject) newManuallyDefinedStrategy).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ViewPackage.SEMANTIC_ZOOM_DESCRIPTION__MANUALLY_DEFINED_STRATEGY, null, msgs);
            msgs = this.basicSetManuallyDefinedStrategy(newManuallyDefinedStrategy, msgs);
            if (msgs != null)
                msgs.dispatch();
        } else if (this.eNotificationRequired())
            this.eNotify(new ENotificationImpl(this, Notification.SET, ViewPackage.SEMANTIC_ZOOM_DESCRIPTION__MANUALLY_DEFINED_STRATEGY, newManuallyDefinedStrategy, newManuallyDefinedStrategy));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case ViewPackage.SEMANTIC_ZOOM_DESCRIPTION__AUTOMATIC_ZOOMING_BY_DEPTH_STRATEGY:
                return this.basicSetAutomaticZoomingByDepthStrategy(null, msgs);
            case ViewPackage.SEMANTIC_ZOOM_DESCRIPTION__NUMBER_OF_RELATION_STRATEGY:
                return this.basicSetNumberOfRelationStrategy(null, msgs);
            case ViewPackage.SEMANTIC_ZOOM_DESCRIPTION__MANUALLY_DEFINED_STRATEGY:
                return this.basicSetManuallyDefinedStrategy(null, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case ViewPackage.SEMANTIC_ZOOM_DESCRIPTION__AUTOMATIC_ZOOMING_BY_DEPTH_STRATEGY:
                return this.getAutomaticZoomingByDepthStrategy();
            case ViewPackage.SEMANTIC_ZOOM_DESCRIPTION__NUMBER_OF_RELATION_STRATEGY:
                return this.getNumberOfRelationStrategy();
            case ViewPackage.SEMANTIC_ZOOM_DESCRIPTION__MANUALLY_DEFINED_STRATEGY:
                return this.getManuallyDefinedStrategy();
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
            case ViewPackage.SEMANTIC_ZOOM_DESCRIPTION__AUTOMATIC_ZOOMING_BY_DEPTH_STRATEGY:
                this.setAutomaticZoomingByDepthStrategy((AutomaticZoomingByDepthStrategy) newValue);
                return;
            case ViewPackage.SEMANTIC_ZOOM_DESCRIPTION__NUMBER_OF_RELATION_STRATEGY:
                this.setNumberOfRelationStrategy((NumberOfRelationStrategy) newValue);
                return;
            case ViewPackage.SEMANTIC_ZOOM_DESCRIPTION__MANUALLY_DEFINED_STRATEGY:
                this.setManuallyDefinedStrategy((ManuallyDefinedStrategy) newValue);
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
            case ViewPackage.SEMANTIC_ZOOM_DESCRIPTION__AUTOMATIC_ZOOMING_BY_DEPTH_STRATEGY:
                this.setAutomaticZoomingByDepthStrategy((AutomaticZoomingByDepthStrategy) null);
                return;
            case ViewPackage.SEMANTIC_ZOOM_DESCRIPTION__NUMBER_OF_RELATION_STRATEGY:
                this.setNumberOfRelationStrategy((NumberOfRelationStrategy) null);
                return;
            case ViewPackage.SEMANTIC_ZOOM_DESCRIPTION__MANUALLY_DEFINED_STRATEGY:
                this.setManuallyDefinedStrategy((ManuallyDefinedStrategy) null);
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
            case ViewPackage.SEMANTIC_ZOOM_DESCRIPTION__AUTOMATIC_ZOOMING_BY_DEPTH_STRATEGY:
                return this.automaticZoomingByDepthStrategy != null;
            case ViewPackage.SEMANTIC_ZOOM_DESCRIPTION__NUMBER_OF_RELATION_STRATEGY:
                return this.numberOfRelationStrategy != null;
            case ViewPackage.SEMANTIC_ZOOM_DESCRIPTION__MANUALLY_DEFINED_STRATEGY:
                return this.manuallyDefinedStrategy != null;
        }
        return super.eIsSet(featureID);
    }

} // SemanticZoomDescriptionImpl
