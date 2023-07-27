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
    protected boolean activeStrategy;
    protected AllStyles styleDetailled;
    protected AllStyles styleNormal;
    protected AllStyles styleSummarized;
    /*
    protected INodeStyle styleDetailled;
    protected INodeStyle styleNormal;
    protected INodeStyle styleSummarized;
    */

    public SemanticZoomStrategy() {
        this.activeStrategy = false;
        this.styleDetailled = new AllStyles();
        this.styleNormal = new AllStyles();
        this.styleSummarized = new AllStyles();
    }

    public SemanticZoomStrategy(boolean activeStrategy, AllStyles styleDetailled, AllStyles styleNormal, AllStyles styleSummarized) {
        this.activeStrategy = activeStrategy;
        this.styleDetailled = styleDetailled;
        this.styleNormal = styleNormal;
        this.styleSummarized = styleSummarized;
    }

    @Override
    public String getKind() {
        return KIND;
    }

    public boolean isActiveStrategy() {
        return this.activeStrategy;
    }

    @Override
    public void setActiveStrategy(boolean activeStrategy) {
        this.activeStrategy = activeStrategy;
    }

    @Override
    public AllStyles getStyleDetailled() {
        return this.styleDetailled;
    }

    @Override
    public void setStyleDetailled(AllStyles styleDetailled) {
        this.styleDetailled = styleDetailled;
    }

    @Override
    public AllStyles getStyleNormal() {
        return this.styleNormal;
    }

    @Override
    public void setStyleNormal(AllStyles styleNormal) {
        this.styleNormal = styleNormal;
    }

    @Override
    public AllStyles getStyleSummarized() {
        return this.styleSummarized;
    }

    @Override
    public void setStyleSummarized(AllStyles styleSummarized) {
        this.styleSummarized = styleSummarized;
    }

}
