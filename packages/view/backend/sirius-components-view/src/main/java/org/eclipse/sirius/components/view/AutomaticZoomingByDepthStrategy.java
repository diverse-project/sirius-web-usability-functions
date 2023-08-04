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
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Automatic Zooming By Depth Strategy</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.sirius.components.view.AutomaticZoomingByDepthStrategy#isActiveStrategy <em>Active
 * Strategy</em>}</li>
 * <li>{@link org.eclipse.sirius.components.view.AutomaticZoomingByDepthStrategy#getStyleDetailled <em>Style
 * Detailled</em>}</li>
 * <li>{@link org.eclipse.sirius.components.view.AutomaticZoomingByDepthStrategy#getStyleNormal <em>Style
 * Normal</em>}</li>
 * <li>{@link org.eclipse.sirius.components.view.AutomaticZoomingByDepthStrategy#getStyleSummarized <em>Style
 * Summarized</em>}</li>
 * </ul>
 *
 * @see org.eclipse.sirius.components.view.ViewPackage#getAutomaticZoomingByDepthStrategy()
 * @model
 * @generated
 */
public interface AutomaticZoomingByDepthStrategy extends EObject {
    /**
     * Returns the value of the '<em><b>Active Strategy</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @return the value of the '<em>Active Strategy</em>' attribute.
     * @see #setActiveStrategy(boolean)
     * @see org.eclipse.sirius.components.view.ViewPackage#getAutomaticZoomingByDepthStrategy_ActiveStrategy()
     * @model
     * @generated
     */
    boolean isActiveStrategy();

    /**
     * Sets the value of the '{@link org.eclipse.sirius.components.view.AutomaticZoomingByDepthStrategy#isActiveStrategy
     * <em>Active Strategy</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Active Strategy</em>' attribute.
     * @see #isActiveStrategy()
     * @generated
     */
    void setActiveStrategy(boolean value);

    /**
     * Returns the value of the '<em><b>Style Detailled</b></em>' containment reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @return the value of the '<em>Style Detailled</em>' containment reference.
     * @see #setStyleDetailled(NodeStyleDescription)
     * @see org.eclipse.sirius.components.view.ViewPackage#getAutomaticZoomingByDepthStrategy_StyleDetailled()
     * @model containment="true"
     * @generated
     */
    NodeStyleDescription getStyleDetailled();

    /**
     * Sets the value of the
     * '{@link org.eclipse.sirius.components.view.AutomaticZoomingByDepthStrategy#getStyleDetailled <em>Style
     * Detailled</em>}' containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Style Detailled</em>' containment reference.
     * @see #getStyleDetailled()
     * @generated
     */
    void setStyleDetailled(NodeStyleDescription value);

    /**
     * Returns the value of the '<em><b>Style Normal</b></em>' containment reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @return the value of the '<em>Style Normal</em>' containment reference.
     * @see #setStyleNormal(NodeStyleDescription)
     * @see org.eclipse.sirius.components.view.ViewPackage#getAutomaticZoomingByDepthStrategy_StyleNormal()
     * @model containment="true"
     * @generated
     */
    NodeStyleDescription getStyleNormal();

    /**
     * Sets the value of the '{@link org.eclipse.sirius.components.view.AutomaticZoomingByDepthStrategy#getStyleNormal
     * <em>Style Normal</em>}' containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Style Normal</em>' containment reference.
     * @see #getStyleNormal()
     * @generated
     */
    void setStyleNormal(NodeStyleDescription value);

    /**
     * Returns the value of the '<em><b>Style Summarized</b></em>' containment reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @return the value of the '<em>Style Summarized</em>' containment reference.
     * @see #setStyleSummarized(NodeStyleDescription)
     * @see org.eclipse.sirius.components.view.ViewPackage#getAutomaticZoomingByDepthStrategy_StyleSummarized()
     * @model containment="true"
     * @generated
     */
    NodeStyleDescription getStyleSummarized();

    /**
     * Sets the value of the
     * '{@link org.eclipse.sirius.components.view.AutomaticZoomingByDepthStrategy#getStyleSummarized <em>Style
     * Summarized</em>}' containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Style Summarized</em>' containment reference.
     * @see #getStyleSummarized()
     * @generated
     */
    void setStyleSummarized(NodeStyleDescription value);

} // AutomaticZoomingByDepthStrategy
