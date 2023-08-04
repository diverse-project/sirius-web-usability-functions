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
package org.eclipse.sirius.components.view;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Number Of Relation Strategy</b></em>'. <!--
 * end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.sirius.components.view.NumberOfRelationStrategy#getNumberOfRelation <em>Number Of
 * Relation</em>}</li>
 * </ul>
 *
 * @see org.eclipse.sirius.components.view.ViewPackage#getNumberOfRelationStrategy()
 * @model
 * @generated
 */
public interface NumberOfRelationStrategy extends SemanticZoomStrategy {

    /**
     * Returns the value of the '<em><b>Number Of Relation</b></em>' attribute. The default value is <code>"3"</code>.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the value of the '<em>Number Of Relation</em>' attribute.
     * @see #setNumberOfRelation(int)
     * @see org.eclipse.sirius.components.view.ViewPackage#getNumberOfRelationStrategy_NumberOfRelation()
     * @model default="3"
     * @generated
     */
    int getNumberOfRelation();

    /**
     * Sets the value of the '{@link org.eclipse.sirius.components.view.NumberOfRelationStrategy#getNumberOfRelation
     * <em>Number Of Relation</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Number Of Relation</em>' attribute.
     * @see #getNumberOfRelation()
     * @generated
     */
    void setNumberOfRelation(int value);

} // NumberOfRelationStrategy
