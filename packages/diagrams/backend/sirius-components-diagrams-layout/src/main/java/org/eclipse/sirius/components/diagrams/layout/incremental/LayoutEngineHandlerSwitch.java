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
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;

import org.eclipse.sirius.components.diagrams.NodeType;
import org.eclipse.sirius.components.diagrams.ParametricSVGNodeType;
import org.eclipse.sirius.components.diagrams.layout.incremental.provider.ICustomNodeLabelPositionProvider;
import org.eclipse.sirius.components.diagrams.layout.incremental.provider.ImageNodeStyleSizeProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The switch used to create proper node incremental layout engine.
 *
 * @author gcoutable
 */
public class LayoutEngineHandlerSwitch implements Function<String, Optional<INodeIncrementalLayoutEngine>> {

    private final Logger logger = LoggerFactory.getLogger(LayoutEngineHandlerSwitch.class);

    private final IBorderNodeLayoutEngine borderNodeLayoutEngine;

    private final List<ICustomNodeLabelPositionProvider> customLabelPositionProviders;

    private final ChildLayoutStrategyEngineHandler childLayoutStrategyEngineHandler;

    private final ImageNodeStyleSizeProvider imageNodeStyleSizeProvider;

    public LayoutEngineHandlerSwitch(IBorderNodeLayoutEngine borderNodeLayoutEngine, List<ICustomNodeLabelPositionProvider> customLabelPositionProviders,
            ImageNodeStyleSizeProvider imageNodeStyleSizeProvider) {
        this.borderNodeLayoutEngine = Objects.requireNonNull(borderNodeLayoutEngine);
        this.customLabelPositionProviders = Objects.requireNonNull(customLabelPositionProviders);
        this.imageNodeStyleSizeProvider = Objects.requireNonNull(imageNodeStyleSizeProvider);
        this.childLayoutStrategyEngineHandler = new ChildLayoutStrategyEngineHandler(borderNodeLayoutEngine, customLabelPositionProviders, imageNodeStyleSizeProvider);
    }

    @Override
    public Optional<INodeIncrementalLayoutEngine> apply(String nodeType) {
        Optional<INodeIncrementalLayoutEngine> optionalLayoutEngine = Optional.empty();
        switch (nodeType) {
            case NodeType.NODE_RECTANGLE:
                optionalLayoutEngine = this.caseRectangleNodeLayoutEngine();
                break;
            case NodeType.NODE_IMAGE:
                optionalLayoutEngine = this.caseImageNodeLayoutEngine();
                break;
            case NodeType.NODE_ICON_LABEL:
                optionalLayoutEngine = this.caseIconLabelNodeLayoutEngine();
                break;
            case ParametricSVGNodeType.NODE_TYPE_PARAMETRIC_IMAGE:
                optionalLayoutEngine = this.caseParametricSVGLayoutEngine();
                break;
            default:
                break;
        }

        if (optionalLayoutEngine.isEmpty()) {
            String pattern = "The node type {} is not currently supported.";
            this.logger.warn(pattern, nodeType);
        }

        return optionalLayoutEngine;
    }

    private Optional<INodeIncrementalLayoutEngine> caseRectangleNodeLayoutEngine() {
        return Optional.of(new RectangleIncrementalLayoutEngine(this.childLayoutStrategyEngineHandler, this.borderNodeLayoutEngine, this.customLabelPositionProviders));
    }

    private Optional<INodeIncrementalLayoutEngine> caseImageNodeLayoutEngine() {
        return Optional.of(new ImageIncrementalLayoutEngine(this.childLayoutStrategyEngineHandler, this.borderNodeLayoutEngine, this.customLabelPositionProviders, this.imageNodeStyleSizeProvider));
    }

    private Optional<INodeIncrementalLayoutEngine> caseIconLabelNodeLayoutEngine() {
        return Optional.of(new IconLabelIncrementalLayoutEngine());
    }

    private Optional<INodeIncrementalLayoutEngine> caseParametricSVGLayoutEngine() {
        return Optional.of(new ParametricSVGIncrementalLayoutEngine(this.childLayoutStrategyEngineHandler, this.borderNodeLayoutEngine, this.customLabelPositionProviders));
    }

}
