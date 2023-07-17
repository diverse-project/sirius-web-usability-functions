/*******************************************************************************
 * Copyright (c) 2023 Obeo.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.sirius.components.diagrams;

/**
 * The semantic zoom.
 *
 * @author aallain
 */
public class SemanticZoom {

    private ISemanticZoomStrategy automaticZoomingByDepthStrategy;
    private ISemanticZoomStrategy numberOfRelationStrategy;
    private ISemanticZoomStrategy manuallyDefinedStrategy;

    public SemanticZoom() {
        this.automaticZoomingByDepthStrategy = null;
        this.numberOfRelationStrategy = null;
        this.manuallyDefinedStrategy = null;
    }

    public SemanticZoom(ISemanticZoomStrategy automaticZoomingByDepthStrategy, ISemanticZoomStrategy numberOfRelationStrategy, ISemanticZoomStrategy manuallyDefinedStrategy) {
        this.automaticZoomingByDepthStrategy = automaticZoomingByDepthStrategy;
        this.numberOfRelationStrategy = numberOfRelationStrategy;
        this.manuallyDefinedStrategy = manuallyDefinedStrategy;
    }

    public ISemanticZoomStrategy getAutomaticZoomingByDepthStrategy() {
        return this.automaticZoomingByDepthStrategy;
    }

    public ISemanticZoomStrategy getNumberOfRelationStrategy() {
        return this.numberOfRelationStrategy;
    }

    public ISemanticZoomStrategy getManuallyDefinedStrategy() {
        return this.manuallyDefinedStrategy;
    }

}
