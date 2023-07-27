/*******************************************************************************
 * Copyright (c) 2019, 2023 Obeo.
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
package org.eclipse.sirius.components.collaborative.diagrams;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.IOException;

import org.eclipse.sirius.components.diagrams.AllStyles;
import org.eclipse.sirius.components.diagrams.AutomaticZoomingByDepthStrategy;
import org.eclipse.sirius.components.diagrams.ISemanticZoomStrategy;
import org.eclipse.sirius.components.diagrams.ManuallyDefinedStrategy;
import org.eclipse.sirius.components.diagrams.NumberOfRelationStrategy;

/**
 * Custom deserializer for node semantic zoom since Jackson need to know how to find the concrete class matching the JSON data.
 *
 * @author aallain
 */
public class ISemanticZoomStrategyDeserializer extends StdDeserializer<ISemanticZoomStrategy> {

    private static final long serialVersionUID = 4522074448849397488L;

    public ISemanticZoomStrategyDeserializer() {
        this(null);
    }

    public ISemanticZoomStrategyDeserializer(Class<?> valueClass) {
        super(valueClass);
    }

    @Override
    public ISemanticZoomStrategy deserialize(JsonParser jsonParser, DeserializationContext context) throws IOException, JsonProcessingException {
        ISemanticZoomStrategy semanticZoomStrategy = null;
        ObjectCodec objectCodec = jsonParser.getCodec();
        if (objectCodec instanceof ObjectMapper mapper) {
            ObjectNode root = mapper.readTree(jsonParser);
            semanticZoomStrategy = switch (root.get("kind").asText()) {
                case AutomaticZoomingByDepthStrategy.KIND ->
                    mapper.readValue(root.toString(), AutomaticZoomingByDepthStrategy.class);
                case NumberOfRelationStrategy.KIND ->
                    mapper.readValue(root.toString(), NumberOfRelationStrategy.class);
                case ManuallyDefinedStrategy.KIND ->
                    mapper.readValue(root.toString(), ManuallyDefinedStrategy.class);
                default ->
                    new AutomaticZoomingByDepthStrategy(false, new AllStyles(), new AllStyles(), new AllStyles());
            };
        }
        return semanticZoomStrategy;
    }

}
