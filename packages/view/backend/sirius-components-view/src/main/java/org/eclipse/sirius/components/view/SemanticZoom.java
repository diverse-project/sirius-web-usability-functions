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
 * <li>{@link org.eclipse.sirius.components.view.SemanticZoom#isActiveSemanticZoom <em>Active Semantic Zoom</em>}</li>
 * </ul>
 *
 * @see org.eclipse.sirius.components.view.ViewPackage#getSemanticZoom()
 * @model
 * @generated
 */
public interface SemanticZoom extends EObject {
    /**
     * Returns the value of the '<em><b>Active Semantic Zoom</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @return the value of the '<em>Active Semantic Zoom</em>' attribute.
     * @see #setActiveSemanticZoom(boolean)
     * @see org.eclipse.sirius.components.view.ViewPackage#getSemanticZoom_ActiveSemanticZoom()
     * @model
     * @generated
     */
    boolean isActiveSemanticZoom();

    /**
     * Sets the value of the '{@link org.eclipse.sirius.components.view.SemanticZoom#isActiveSemanticZoom <em>Active
     * Semantic Zoom</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Active Semantic Zoom</em>' attribute.
     * @see #isActiveSemanticZoom()
     * @generated
     */
    void setActiveSemanticZoom(boolean value);

} // SemanticZoom
