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
 * All Styles (node and label styles).
 *
 * @author aallain
 */
public class AllStyles {

    private INodeStyle nodeStyle;
    private LabelStyle labelStyle;

    public AllStyles() {
        INodeStyle defaultNodeStyle = IconLabelNodeStyle.newIconLabelNodeStyle()
                .backgroundColor("black")
                .build();
        LabelStyle defaultLabelStyle = LabelStyle.newLabelStyle().build();
        this.nodeStyle = defaultNodeStyle;
        this.labelStyle = defaultLabelStyle;
    }

    public AllStyles(INodeStyle nodeStyle, LabelStyle labelStyle) {
        this.nodeStyle = nodeStyle;
        this.labelStyle = labelStyle;
    }

    public INodeStyle getNodeStyle() {
        return this.nodeStyle;
    }
    public void setNodeStyle(INodeStyle nodeStyle) {
        this.nodeStyle = nodeStyle;
    }
    public LabelStyle getLabelStyle() {
        return this.labelStyle;
    }
    public void setLabelStyle(LabelStyle labelStyle) {
        this.labelStyle = labelStyle;
    }



}
