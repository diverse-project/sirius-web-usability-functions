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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Semantic Zoom</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.sirius.components.view.SemanticZoomDescription#getAutomaticZoomingByDepthStrategy
 * <em>Automatic Zooming By Depth Strategy</em>}</li>
 * <li>{@link org.eclipse.sirius.components.view.SemanticZoomDescription#getNumberOfRelationStrategy <em>Number Of
 * Relation Strategy</em>}</li>
 * <li>{@link org.eclipse.sirius.components.view.SemanticZoomDescription#getManuallyDefinedStrategy <em>Manually Defined
 * Strategy</em>}</li>
 * </ul>
 *
 * @see org.eclipse.sirius.components.view.ViewPackage#getSemanticZoomDescription()
 * @model
 * @generated
 */
public interface SemanticZoomDescription extends EObject {
    /**
     * Returns the value of the '<em><b>Automatic Zooming By Depth Strategy</b></em>' containment reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the value of the '<em>Automatic Zooming By Depth Strategy</em>' containment reference.
     * @see #setAutomaticZoomingByDepthStrategy(AutomaticZoomingByDepthStrategy)
     * @see org.eclipse.sirius.components.view.ViewPackage#getSemanticZoomDescription_AutomaticZoomingByDepthStrategy()
     * @model containment="true"
     * @generated
     */
    AutomaticZoomingByDepthStrategy getAutomaticZoomingByDepthStrategy();

    /**
     * Sets the value of the
     * '{@link org.eclipse.sirius.components.view.SemanticZoomDescription#getAutomaticZoomingByDepthStrategy
     * <em>Automatic Zooming By Depth Strategy</em>}' containment reference. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @param value
     *            the new value of the '<em>Automatic Zooming By Depth Strategy</em>' containment reference.
     * @see #getAutomaticZoomingByDepthStrategy()
     * @generated
     */
    void setAutomaticZoomingByDepthStrategy(AutomaticZoomingByDepthStrategy value);

    /**
     * Returns the value of the '<em><b>Number Of Relation Strategy</b></em>' containment reference. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @return the value of the '<em>Number Of Relation Strategy</em>' containment reference.
     * @see #setNumberOfRelationStrategy(NumberOfRelationStrategy)
     * @see org.eclipse.sirius.components.view.ViewPackage#getSemanticZoomDescription_NumberOfRelationStrategy()
     * @model containment="true"
     * @generated
     */
    NumberOfRelationStrategy getNumberOfRelationStrategy();

    /**
     * Sets the value of the
     * '{@link org.eclipse.sirius.components.view.SemanticZoomDescription#getNumberOfRelationStrategy <em>Number Of
     * Relation Strategy</em>}' containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Number Of Relation Strategy</em>' containment reference.
     * @see #getNumberOfRelationStrategy()
     * @generated
     */
    void setNumberOfRelationStrategy(NumberOfRelationStrategy value);

    /**
     * Returns the value of the '<em><b>Manually Defined Strategy</b></em>' containment reference. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @return the value of the '<em>Manually Defined Strategy</em>' containment reference.
     * @see #setManuallyDefinedStrategy(ManuallyDefinedStrategy)
     * @see org.eclipse.sirius.components.view.ViewPackage#getSemanticZoomDescription_ManuallyDefinedStrategy()
     * @model containment="true"
     * @generated
     */
    ManuallyDefinedStrategy getManuallyDefinedStrategy();

    /**
     * Sets the value of the
     * '{@link org.eclipse.sirius.components.view.SemanticZoomDescription#getManuallyDefinedStrategy <em>Manually
     * Defined Strategy</em>}' containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Manually Defined Strategy</em>' containment reference.
     * @see #getManuallyDefinedStrategy()
     * @generated
     */
    void setManuallyDefinedStrategy(ManuallyDefinedStrategy value);

} // SemanticZoom
