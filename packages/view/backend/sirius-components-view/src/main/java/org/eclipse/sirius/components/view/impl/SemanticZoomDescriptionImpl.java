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

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.sirius.components.view.SemanticZoomDescription;
import org.eclipse.sirius.components.view.SemanticZoomStrategy;
import org.eclipse.sirius.components.view.ViewPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Semantic Zoom Description</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.sirius.components.view.impl.SemanticZoomDescriptionImpl#getSemanticZoomStrategies <em>Semantic
 * Zoom Strategies</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SemanticZoomDescriptionImpl extends MinimalEObjectImpl.Container implements SemanticZoomDescription {
    /**
     * The cached value of the '{@link #getSemanticZoomStrategies() <em>Semantic Zoom Strategies</em>}' containment
     * reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getSemanticZoomStrategies()
     * @generated
     * @ordered
     */
    protected EList<SemanticZoomStrategy> semanticZoomStrategies;

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
    public EList<SemanticZoomStrategy> getSemanticZoomStrategies() {
        if (this.semanticZoomStrategies == null) {
            this.semanticZoomStrategies = new EObjectContainmentEList<>(SemanticZoomStrategy.class, this, ViewPackage.SEMANTIC_ZOOM_DESCRIPTION__SEMANTIC_ZOOM_STRATEGIES);
        }
        return this.semanticZoomStrategies;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case ViewPackage.SEMANTIC_ZOOM_DESCRIPTION__SEMANTIC_ZOOM_STRATEGIES:
                return ((InternalEList<?>) this.getSemanticZoomStrategies()).basicRemove(otherEnd, msgs);
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
            case ViewPackage.SEMANTIC_ZOOM_DESCRIPTION__SEMANTIC_ZOOM_STRATEGIES:
                return this.getSemanticZoomStrategies();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case ViewPackage.SEMANTIC_ZOOM_DESCRIPTION__SEMANTIC_ZOOM_STRATEGIES:
                this.getSemanticZoomStrategies().clear();
                this.getSemanticZoomStrategies().addAll((Collection<? extends SemanticZoomStrategy>) newValue);
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
            case ViewPackage.SEMANTIC_ZOOM_DESCRIPTION__SEMANTIC_ZOOM_STRATEGIES:
                this.getSemanticZoomStrategies().clear();
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
            case ViewPackage.SEMANTIC_ZOOM_DESCRIPTION__SEMANTIC_ZOOM_STRATEGIES:
                return this.semanticZoomStrategies != null && !this.semanticZoomStrategies.isEmpty();
        }
        return super.eIsSet(featureID);
    }

} // SemanticZoomDescriptionImpl
