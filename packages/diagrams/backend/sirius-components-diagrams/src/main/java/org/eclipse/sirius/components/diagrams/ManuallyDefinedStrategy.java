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
* The semantic zoom strategy defined by the user.
*
 * @author aallain
 */
public class ManuallyDefinedStrategy extends SemanticZoomStrategy {

    public static final String KIND = "ManuallyDefinedStrategy";
    private double zoomDetailled;
    private double zoomNormal;
    private double zoomSummarized;

    public ManuallyDefinedStrategy() {
        super(false, null, null, null);
        this.zoomDetailled = 0.75;
        this.zoomNormal = 0.25;
        this.zoomSummarized = 0.05;
    }

    public ManuallyDefinedStrategy(boolean activeStrategy, AllStyles styleDetailled, AllStyles styleNormal, AllStyles styleSummarized, double zoomDetailled, double zoomNormal, double zoomSummarized) {
        super(activeStrategy, styleDetailled, styleNormal, styleSummarized);
        this.zoomDetailled = zoomDetailled;
        this.zoomNormal = zoomNormal;
        this.zoomSummarized = zoomSummarized;
    }

    @Override
    public String getKind() {
        return KIND;
    }

    public double getZoomDetailled() {
        return this.zoomDetailled;
    }

    public void setZoomDetailled(double zoomDetailled) {
        this.zoomDetailled = zoomDetailled;
    }

    public double getZoomNormal() {
        return this.zoomNormal;
    }

    public void setZoomNormal(double zoomNormal) {
        this.zoomNormal = zoomNormal;
    }

    public double getZoomSummarized() {
        return this.zoomSummarized;
    }

    public void setZoomSummarized(double zoomSummarized) {
        this.zoomSummarized = zoomSummarized;
    }



}
