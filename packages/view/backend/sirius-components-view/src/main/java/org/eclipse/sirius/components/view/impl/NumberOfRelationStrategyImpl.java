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
import org.eclipse.sirius.components.view.NumberOfRelationStrategy;
import org.eclipse.sirius.components.view.ViewPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Number Of Relation Strategy</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.sirius.components.view.impl.NumberOfRelationStrategyImpl#getNumberOfRelation <em>Number Of
 * Relation</em>}</li>
 * </ul>
 *
 * @generated
 */
public class NumberOfRelationStrategyImpl extends SemanticZoomStrategyImpl implements NumberOfRelationStrategy {
    /**
     * The default value of the '{@link #getNumberOfRelation() <em>Number Of Relation</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getNumberOfRelation()
     * @generated
     * @ordered
     */
    protected static final int NUMBER_OF_RELATION_EDEFAULT = 3;

    /**
     * The cached value of the '{@link #getNumberOfRelation() <em>Number Of Relation</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getNumberOfRelation()
     * @generated
     * @ordered
     */
    protected int numberOfRelation = NUMBER_OF_RELATION_EDEFAULT;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected NumberOfRelationStrategyImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ViewPackage.Literals.NUMBER_OF_RELATION_STRATEGY;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public int getNumberOfRelation() {
        return this.numberOfRelation;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setNumberOfRelation(int newNumberOfRelation) {
        int oldNumberOfRelation = this.numberOfRelation;
        this.numberOfRelation = newNumberOfRelation;
        if (this.eNotificationRequired())
            this.eNotify(new ENotificationImpl(this, Notification.SET, ViewPackage.NUMBER_OF_RELATION_STRATEGY__NUMBER_OF_RELATION, oldNumberOfRelation, this.numberOfRelation));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case ViewPackage.NUMBER_OF_RELATION_STRATEGY__NUMBER_OF_RELATION:
                return this.getNumberOfRelation();
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
            case ViewPackage.NUMBER_OF_RELATION_STRATEGY__NUMBER_OF_RELATION:
                this.setNumberOfRelation((Integer) newValue);
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
            case ViewPackage.NUMBER_OF_RELATION_STRATEGY__NUMBER_OF_RELATION:
                this.setNumberOfRelation(NUMBER_OF_RELATION_EDEFAULT);
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
            case ViewPackage.NUMBER_OF_RELATION_STRATEGY__NUMBER_OF_RELATION:
                return this.numberOfRelation != NUMBER_OF_RELATION_EDEFAULT;
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
        result.append(" (numberOfRelation: ");
        result.append(this.numberOfRelation);
        result.append(')');
        return result.toString();
    }

} // NumberOfRelationStrategyImpl
