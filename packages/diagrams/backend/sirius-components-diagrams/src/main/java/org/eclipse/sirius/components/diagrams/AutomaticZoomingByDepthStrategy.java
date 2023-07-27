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
 * The semantic zoom strategy with depth.
 *
 * @author aallain
 */
public class AutomaticZoomingByDepthStrategy extends SemanticZoomStrategy {

    public static final String KIND = "AutomaticZoomingByDepthStrategy";

    public AutomaticZoomingByDepthStrategy() {
        super(false, null, null, null);
    }

    public AutomaticZoomingByDepthStrategy(boolean activeStrategy, AllStyles styleDetailled, AllStyles styleNormal, AllStyles styleSummarized) {
        super(activeStrategy, styleDetailled, styleNormal, styleSummarized);
    }

    @Override
    public String getKind() {
        return KIND;
    }

}
