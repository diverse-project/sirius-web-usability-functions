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

import java.util.ArrayList;
import java.util.List;

/**
 * The semantic zoom.
 *
 * @author aallain
 */
public class SemanticZoom {

    private List<ISemanticZoomStrategy> semanticZoomStrategies;

    public SemanticZoom() {
        this.semanticZoomStrategies = new ArrayList<>();
    }

    public SemanticZoom(List<ISemanticZoomStrategy> semanticZoomStrategies) {
        this.semanticZoomStrategies = semanticZoomStrategies;
    }

    public List<ISemanticZoomStrategy> getSemanticZoomStrategies() {
        return this.semanticZoomStrategies;
    }


}
