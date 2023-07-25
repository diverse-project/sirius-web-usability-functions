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
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Manually Defined Strategy</b></em>'. <!--
 * end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.sirius.components.view.ManuallyDefinedStrategy#getZoomDetailled <em>Zoom Detailled</em>}</li>
 * <li>{@link org.eclipse.sirius.components.view.ManuallyDefinedStrategy#getZoomNormal <em>Zoom Normal</em>}</li>
 * <li>{@link org.eclipse.sirius.components.view.ManuallyDefinedStrategy#getZoomSummarized <em>Zoom
 * Summarized</em>}</li>
 * </ul>
 *
 * @see org.eclipse.sirius.components.view.ViewPackage#getManuallyDefinedStrategy()
 * @model
 * @generated
 */
public interface ManuallyDefinedStrategy extends SemanticZoomStrategy {

    /**
     * Returns the value of the '<em><b>Zoom Detailled</b></em>' attribute. The default value is <code>"1.0"</code>.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the value of the '<em>Zoom Detailled</em>' attribute.
     * @see #setZoomDetailled(double)
     * @see org.eclipse.sirius.components.view.ViewPackage#getManuallyDefinedStrategy_ZoomDetailled()
     * @model default="1.0"
     * @generated
     */
    double getZoomDetailled();

    /**
     * Sets the value of the '{@link org.eclipse.sirius.components.view.ManuallyDefinedStrategy#getZoomDetailled
     * <em>Zoom Detailled</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Zoom Detailled</em>' attribute.
     * @see #getZoomDetailled()
     * @generated
     */
    void setZoomDetailled(double value);

    /**
     * Returns the value of the '<em><b>Zoom Normal</b></em>' attribute. The default value is <code>"0.25"</code>. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the value of the '<em>Zoom Normal</em>' attribute.
     * @see #setZoomNormal(double)
     * @see org.eclipse.sirius.components.view.ViewPackage#getManuallyDefinedStrategy_ZoomNormal()
     * @model default="0.25"
     * @generated
     */
    double getZoomNormal();

    /**
     * Sets the value of the '{@link org.eclipse.sirius.components.view.ManuallyDefinedStrategy#getZoomNormal <em>Zoom
     * Normal</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Zoom Normal</em>' attribute.
     * @see #getZoomNormal()
     * @generated
     */
    void setZoomNormal(double value);

    /**
     * Returns the value of the '<em><b>Zoom Summarized</b></em>' attribute. The default value is <code>"0.05"</code>.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the value of the '<em>Zoom Summarized</em>' attribute.
     * @see #setZoomSummarized(double)
     * @see org.eclipse.sirius.components.view.ViewPackage#getManuallyDefinedStrategy_ZoomSummarized()
     * @model default="0.05"
     * @generated
     */
    double getZoomSummarized();

    /**
     * Sets the value of the '{@link org.eclipse.sirius.components.view.ManuallyDefinedStrategy#getZoomSummarized
     * <em>Zoom Summarized</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Zoom Summarized</em>' attribute.
     * @see #getZoomSummarized()
     * @generated
     */
    void setZoomSummarized(double value);

} // ManuallyDefinedStrategy
