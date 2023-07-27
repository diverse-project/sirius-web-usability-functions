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
 * Interface implemented by all the semantic zoom strategies.
 *
 * @author aallain
 */
public interface ISemanticZoomStrategy {

    String getKind();

    boolean isActiveStrategy();

    AllStyles getStyleDetailled();

    AllStyles getStyleNormal();

    AllStyles getStyleSummarized();

    void setActiveStrategy(boolean activeStrategy);

    void setStyleDetailled(AllStyles styleDetailled);

    void setStyleNormal(AllStyles styleNormal);

    void setStyleSummarized(AllStyles styleSummarized);



}
