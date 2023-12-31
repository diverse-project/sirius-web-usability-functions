/*******************************************************************************
 * Copyright (c) 2022, 2023 Obeo.
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
package org.eclipse.sirius.components.diagrams.layout.incremental;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.eclipse.sirius.components.diagrams.FreeFormLayoutStrategy;
import org.eclipse.sirius.components.diagrams.ILayoutStrategy;
import org.eclipse.sirius.components.diagrams.ListLayoutStrategy;
import org.eclipse.sirius.components.diagrams.layout.incremental.provider.ICustomNodeLabelPositionProvider;
import org.eclipse.sirius.components.diagrams.layout.incremental.provider.ImageNodeStyleSizeProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The switch used to create the proper layout strategy engine.
 *
 * @author gcoutable
 */
public class LayoutStrategyEngineHandlerSwitch implements Function<ILayoutStrategy, Optional<ILayoutStrategyEngine>> {

    private final Logger logger = LoggerFactory.getLogger(LayoutStrategyEngineHandlerSwitch.class);

    private final ChildNodeIncrementalLayoutEngineHandler childNodeIncrementalLayoutEngineHandler;

    public LayoutStrategyEngineHandlerSwitch(IBorderNodeLayoutEngine borderNodeLayoutEngine, List<ICustomNodeLabelPositionProvider> customLabelPositionProviders,
            ImageNodeStyleSizeProvider imageNodeStyleSizeProvider) {
        this.childNodeIncrementalLayoutEngineHandler = new ChildNodeIncrementalLayoutEngineHandler(borderNodeLayoutEngine, customLabelPositionProviders, imageNodeStyleSizeProvider);
    }

    @Override
    public Optional<ILayoutStrategyEngine> apply(ILayoutStrategy layoutStrategy) {
        Optional<ILayoutStrategyEngine> optionalLayoutStrategyEngine = Optional.empty();
        if (layoutStrategy instanceof ListLayoutStrategy) {
            optionalLayoutStrategyEngine = this.caseListLayoutStrategyEngine();
        } else if (layoutStrategy instanceof FreeFormLayoutStrategy) {
            optionalLayoutStrategyEngine = this.caseFreeFormLayoutStrategyEngine();
        }

        if (optionalLayoutStrategyEngine.isEmpty()) {
            String pattern = "The layout strategy engine {} is not currently supported.";
            this.logger.warn(pattern, layoutStrategy.getClass().getSimpleName());
        }

        return optionalLayoutStrategyEngine;
    }

    private Optional<ILayoutStrategyEngine> caseListLayoutStrategyEngine() {
        return Optional.of(new ListLayoutStrategyEngine(this.childNodeIncrementalLayoutEngineHandler));
    }

    private Optional<ILayoutStrategyEngine> caseFreeFormLayoutStrategyEngine() {
        return Optional.of(new FreeFormLayoutStrategyEngine(this.childNodeIncrementalLayoutEngineHandler));
    }

}
