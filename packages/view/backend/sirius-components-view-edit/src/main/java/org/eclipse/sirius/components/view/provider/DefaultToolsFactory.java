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
package org.eclipse.sirius.components.view.provider;

import org.eclipse.sirius.components.view.ChangeContext;
import org.eclipse.sirius.components.view.DeleteTool;
import org.eclipse.sirius.components.view.DiagramPalette;
import org.eclipse.sirius.components.view.EdgePalette;
import org.eclipse.sirius.components.view.EdgeTool;
import org.eclipse.sirius.components.view.LabelEditTool;
import org.eclipse.sirius.components.view.NodePalette;
import org.eclipse.sirius.components.view.NodeTool;
import org.eclipse.sirius.components.view.SetValue;
import org.eclipse.sirius.components.view.SourceEdgeEndReconnectionTool;
import org.eclipse.sirius.components.view.TargetEdgeEndReconnectionTool;
import org.eclipse.sirius.components.view.ViewFactory;

/**
 * Factory to create tool descriptions which invoke the default/canonical behaviors.
 *
 * @author pcdavid
 */
public class DefaultToolsFactory {

    public DiagramPalette createDefaultDiagramPalette() {
        DiagramPalette palette = ViewFactory.eINSTANCE.createDiagramPalette();
        return palette;
    }

    public NodePalette createDefaultNodePalette() {
        NodePalette palette = ViewFactory.eINSTANCE.createNodePalette();
        palette.setDeleteTool(this.createDefaultDeleteTool());
        palette.setLabelEditTool(this.createDefaultLabelEditTool());
        return palette;
    }

    public EdgePalette createDefaultEdgePalette() {
        EdgePalette palette = ViewFactory.eINSTANCE.createEdgePalette();
        palette.setDeleteTool(this.createDefaultDeleteTool());
        palette.setCenterLabelEditTool(this.createDefaultLabelEditTool());
        return palette;
    }

    public NodeTool createDefaultNodeCreationTool() {
        NodeTool newNodeTool = ViewFactory.eINSTANCE.createNodeTool();
        newNodeTool.setName("Create Node");
        return newNodeTool;
    }

    public EdgeTool createDefaultEdgeTool() {
        EdgeTool newEdgeTool = ViewFactory.eINSTANCE.createEdgeTool();
        newEdgeTool.setName("Create Edge");
        return newEdgeTool;
    }

    public SourceEdgeEndReconnectionTool createDefaultSourceEdgeReconnectionTool() {
        SourceEdgeEndReconnectionTool sourceReconnectionTool = ViewFactory.eINSTANCE.createSourceEdgeEndReconnectionTool();
        sourceReconnectionTool.setName("Reconnect Edge Source");
        ChangeContext reconnectSourceInitialOperation = ViewFactory.eINSTANCE.createChangeContext();
        reconnectSourceInitialOperation.setExpression("aql:edgeSemanticElement");
        SetValue reconnectSourceSetValue = ViewFactory.eINSTANCE.createSetValue();
        reconnectSourceInitialOperation.getChildren().add(reconnectSourceSetValue);
        sourceReconnectionTool.getBody().add(reconnectSourceInitialOperation);
        return sourceReconnectionTool;
    }

    public TargetEdgeEndReconnectionTool createDefaultTargetEdgeReconnectionTool() {
        TargetEdgeEndReconnectionTool targetReconnectionTool = ViewFactory.eINSTANCE.createTargetEdgeEndReconnectionTool();
        targetReconnectionTool.setName("Reconnect Edge Target");
        ChangeContext reconnectTargetInitialOperation = ViewFactory.eINSTANCE.createChangeContext();
        reconnectTargetInitialOperation.setExpression("aql:edgeSemanticElement");
        SetValue reconnectTargetSetValue = ViewFactory.eINSTANCE.createSetValue();
        reconnectTargetInitialOperation.getChildren().add(reconnectTargetSetValue);
        targetReconnectionTool.getBody().add(reconnectTargetInitialOperation);
        return targetReconnectionTool;
    }

    public LabelEditTool createDefaultLabelEditTool() {
        return this.createLabelEditTool("Edit Label");
    }

    public LabelEditTool createDefaultBeginLabelEditTool() {
        return this.createLabelEditTool("Edit Begin Label");
    }

    public LabelEditTool createDefaultCenterLabelEditTool() {
        return this.createLabelEditTool("Edit Center Label");
    }

    public LabelEditTool createDefaultEndLabelEditTool() {
        return this.createLabelEditTool("Edit End Label");
    }

    private LabelEditTool createLabelEditTool(String name) {
        LabelEditTool newLabelEditTool = ViewFactory.eINSTANCE.createLabelEditTool();
        newLabelEditTool.setName(name);
        ChangeContext body = ViewFactory.eINSTANCE.createChangeContext();
        body.setExpression("aql:self.defaultEditLabel(newLabel)");
        newLabelEditTool.getBody().add(body);
        return newLabelEditTool;
    }

    public DeleteTool createDefaultDeleteTool() {
        DeleteTool newDeleteTool = ViewFactory.eINSTANCE.createDeleteTool();
        newDeleteTool.setName("Delete");
        ChangeContext body = ViewFactory.eINSTANCE.createChangeContext();
        body.setExpression("aql:self.defaultDelete()");
        newDeleteTool.getBody().add(body);
        return newDeleteTool;
    }
}
