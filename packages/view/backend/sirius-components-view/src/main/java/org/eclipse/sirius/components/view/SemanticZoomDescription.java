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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Semantic Zoom</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.sirius.components.view.SemanticZoomDescription#getSemanticZoomStrategies <em>Semantic Zoom
 * Strategies</em>}</li>
 * </ul>
 *
 * @see org.eclipse.sirius.components.view.ViewPackage#getSemanticZoomDescription()
 * @model
 * @generated
 */
public interface SemanticZoomDescription extends EObject {
    /**
     * Returns the value of the '<em><b>Semantic Zoom Strategies</b></em>' containment reference list. The list contents
     * are of type {@link org.eclipse.sirius.components.view.SemanticZoomStrategy}. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @return the value of the '<em>Semantic Zoom Strategies</em>' containment reference list.
     * @see org.eclipse.sirius.components.view.ViewPackage#getSemanticZoomDescription_SemanticZoomStrategies()
     * @model containment="true" required="true"
     * @generated
     */
    EList<SemanticZoomStrategy> getSemanticZoomStrategies();

} // SemanticZoom
