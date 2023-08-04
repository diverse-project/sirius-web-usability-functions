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

import org.eclipse.sirius.components.diagrams.EmptyNodeStyle;
import org.eclipse.sirius.components.diagrams.INodeStyle;
import org.eclipse.sirius.components.diagrams.ISemanticZoomStrategy;
import org.eclipse.sirius.components.diagrams.IconLabelNodeStyle;
import org.eclipse.sirius.components.diagrams.ImageNodeStyle;
import org.eclipse.sirius.components.diagrams.Node;
import org.eclipse.sirius.components.diagrams.NodeType;
import org.eclipse.sirius.components.diagrams.RectangularNodeStyle;

/**
 * Custom deserializer for node style since Jackson need to know how to find the concrete class matching the JSON data.
 *
 * @author sbegaudeau
 */
public class INodeStyleDeserializer extends StdDeserializer<INodeStyle> {

    private static final long serialVersionUID = 5722074461929397488L;

    public INodeStyleDeserializer() {
        this(null);
    }

    public INodeStyleDeserializer(Class<?> valueClass) {
        super(valueClass);
    }

    @Override
    public INodeStyle deserialize(JsonParser jsonParser, DeserializationContext context) throws IOException, JsonProcessingException {
        INodeStyle nodeStyle = null;
        ObjectCodec objectCodec = jsonParser.getCodec();
        if (objectCodec instanceof ObjectMapper mapper) {
            ObjectNode root = mapper.readTree(jsonParser);

            Object parent = jsonParser.getParsingContext().getCurrentValue();
            String name = jsonParser.getParsingContext().getCurrentName();
            if (parent instanceof Node parentNode) {
                switch (parentNode.getType()) {
                    case NodeType.NODE_RECTANGLE:
                        nodeStyle = mapper.readValue(root.toString(), RectangularNodeStyle.class);
                        break;
                    case NodeType.NODE_IMAGE:
                        nodeStyle = mapper.readValue(root.toString(), ImageNodeStyle.class);
                        break;
                    case NodeType.NODE_ICON_LABEL:
                        nodeStyle = mapper.readValue(root.toString(), IconLabelNodeStyle.class);
                        break;
                    case NodeType.NODE_EMPTY:
                        nodeStyle = mapper.readValue(root.toString(), EmptyNodeStyle.class);
                        break;
                    default:
                        nodeStyle = mapper.readValue(root.toString(), RectangularNodeStyle.class);
                        break;
                }
            }
            if (parent instanceof ISemanticZoomStrategy) {
                if (root.get("withHeader") != null) {
                    nodeStyle = mapper.readValue(root.toString(), RectangularNodeStyle.class);
                } else if (root.get("imageURL") != null) {
                    nodeStyle = mapper.readValue(root.toString(), ImageNodeStyle.class);
                } else if (root.get("backgroundColor") != null) {
                    nodeStyle = mapper.readValue(root.toString(), IconLabelNodeStyle.class);
                } else {
                    nodeStyle = mapper.readValue(root.toString(), EmptyNodeStyle.class);
                }
            }
        }
        return nodeStyle;
    }

}
