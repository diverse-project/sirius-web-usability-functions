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
    protected INodeStyle styleDetailled;
    protected INodeStyle styleNormal;
    protected INodeStyle styleSummarized;

    public SemanticZoomStrategy() {
        INodeStyle defaultNodeStyle = IconLabelNodeStyle.newIconLabelNodeStyle()
                .backgroundColor("black")
                .build();
        this.activeStrategy = false;
        this.styleDetailled = defaultNodeStyle;
        this.styleNormal = defaultNodeStyle;
        this.styleSummarized = defaultNodeStyle;
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
    public INodeStyle getStyleDetailled() {
        return this.styleDetailled;
    }

    @Override
    public INodeStyle getStyleNormal() {
        return this.styleNormal;
    }

    @Override
    public INodeStyle getStyleSummarized() {
        return this.styleSummarized;
    }

    @Override
    public void setActiveStrategy(boolean activeStrategy) {
        this.activeStrategy = activeStrategy;
    }

    @Override
    public void setStyleDetailled(INodeStyle styleDetailled) {
        this.styleDetailled = styleDetailled;
    }

    @Override
    public void setStyleNormal(INodeStyle styleNormal) {
        this.styleNormal = styleNormal;
    }

    @Override
    public void setStyleSummarized(INodeStyle styleSummarized) {
        this.styleSummarized = styleSummarized;
    }

}
