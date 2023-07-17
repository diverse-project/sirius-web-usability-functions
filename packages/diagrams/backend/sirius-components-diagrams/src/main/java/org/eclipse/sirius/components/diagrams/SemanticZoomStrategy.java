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
 * The default semantic zoom strategy.
 *
 * @author aallain
 */
public class SemanticZoomStrategy implements ISemanticZoomStrategy {

    public static final String KIND = "SemanticZoomStrategy";
    private boolean activeStrategy;
    private INodeStyle styleDetailled;
    private INodeStyle styleNormal;
    private INodeStyle styleSummarized;

    public SemanticZoomStrategy() {
        this.activeStrategy = false;
        this.styleDetailled = null;
        this.styleNormal = null;
        this.styleSummarized = null;
    }

    public SemanticZoomStrategy(boolean activeStrategy, INodeStyle styleDetailled, INodeStyle styleNormal, INodeStyle styleSummarized) {
        this.activeStrategy = activeStrategy;
        this.styleDetailled = styleDetailled;
        this.styleNormal = styleNormal;
        this.styleSummarized = styleSummarized;
    }

    @Override
    public String getKind() {
        return KIND;
    }

    @Override
    public boolean getActiveStrategy() {
        return this.activeStrategy;
    }

    @Override
    public INodeStyle getNodeStyleDetailled() {
        return this.styleDetailled;
    }

    @Override
    public INodeStyle getNodeStyleNormal() {
        return this.styleNormal;
    }

    @Override
    public INodeStyle getNodeStyleSummarized() {
        return this.styleSummarized;
    }

}
