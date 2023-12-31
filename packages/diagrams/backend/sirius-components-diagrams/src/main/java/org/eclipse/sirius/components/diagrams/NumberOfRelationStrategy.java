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
* The semantic zoom strategy based on the number of relations.
*
 * @author aallain
 */
public class NumberOfRelationStrategy extends SemanticZoomStrategy {

    public static final String KIND = "NumberOfRelationStrategy";
    private int numberOfRelation;

    public NumberOfRelationStrategy() {
        super(false, null, null, null);
        this.numberOfRelation = 3;
    }

    public NumberOfRelationStrategy(boolean activeStrategy, INodeStyle styleDetailled, INodeStyle styleNormal, INodeStyle styleSummarized, int numberOfRelation) {
        super(activeStrategy, styleDetailled, styleNormal, styleSummarized);
        this.numberOfRelation = numberOfRelation;
    }

    @Override
    public String getKind() {
        return KIND;
    }

    public int getNumberOfRelation() {
        return this.numberOfRelation;
    }

    public void setNumberOfRelation(int numberOfRelation) {
        this.numberOfRelation = numberOfRelation;
    }

}
