/*******************************************************************************
 * Copyright (c) 2023 Obeo and others.
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

import { Edge, Node } from 'reactflow';
import { GQLDiagram } from '../graphql/subscription/diagramFragment.types';
import { GQLImageNodeStyle, GQLNode, GQLRectangularNodeStyle } from '../graphql/subscription/nodeFragment.types';
import { Diagram } from '../renderer/DiagramRenderer.types';
import { ImageNodeData } from '../renderer/ImageNode.types';
import { RectangularNodeData } from '../renderer/RectangularNode.types';

const toRectangularNode = (gqlNode: GQLNode, gqlParentNode: GQLNode | null): Node<RectangularNodeData> => {
  const style = gqlNode.style as GQLRectangularNodeStyle;
  const { position, size } = gqlNode;
  const labelStyle = gqlNode.label.style;

  const data: RectangularNodeData = {
    style: {
      backgroundColor: style.color,
      borderColor: style.borderColor,
      borderRadius: style.borderRadius,
      borderWidth: style.borderSize,
      borderStyle: style.borderStyle,
      width: `${size.width}px`,
      height: `${size.height}px`,
    },
    label: {
      text: gqlNode.label.text,
      style: {
        fontSize: labelStyle.fontSize,
        color: labelStyle.color,
      },
    },
  };

  const node: Node<RectangularNodeData> = {
    id: gqlNode.id,
    type: 'rectangularNode',
    data,
    position,
  };

  if (gqlParentNode) {
    node.parentNode = gqlParentNode.id;
    node.extent = 'parent';
  }

  return node;
};

const toImageNode = (gqlNode: GQLNode, gqlParentNode: GQLNode | null): Node<ImageNodeData> => {
  const style = gqlNode.style as GQLImageNodeStyle;
  const { position, size } = gqlNode;

  const data: ImageNodeData = {
    style: {
      width: `${size.width}px`,
      height: `${size.height}px`,
    },
    imageURL: style.imageURL,
  };

  const node: Node<ImageNodeData> = {
    id: gqlNode.id,
    type: 'imageNode',
    data,
    position,
  };

  if (gqlParentNode) {
    node.parentNode = gqlParentNode.id;
    node.extent = 'parent';
  }

  return node;
};

const convertNode = (gqlNode: GQLNode, parentNode: GQLNode | null, nodes: Node[]): void => {
  if (gqlNode.style.__typename === 'RectangularNodeStyle') {
    nodes.push(toRectangularNode(gqlNode, parentNode));
  } else if (gqlNode.style.__typename === 'ImageNodeStyle') {
    nodes.push(toImageNode(gqlNode, parentNode));
  }

  (gqlNode.borderNodes ?? []).forEach((gqlBorderNode) => convertNode(gqlBorderNode, gqlNode, nodes));
  (gqlNode.childNodes ?? []).forEach((gqlChildNode) => convertNode(gqlChildNode, gqlNode, nodes));
};

const nodeDepth = (nodeId2node: Map<string, Node>, nodeId: string): number => {
  const node = nodeId2node.get(nodeId);
  let depth = 0;

  let parentNode = node.parentNode ? nodeId2node.get(node.parentNode) : undefined;
  while (parentNode) {
    depth = depth + 1;
    parentNode = parentNode.parentNode ? nodeId2node.get(parentNode.parentNode) : undefined;
  }

  return depth;
};

export const convertDiagram = (gqlDiagram: GQLDiagram): Diagram => {
  const nodes: Node[] = [];
  gqlDiagram.nodes.forEach((gqlNode) => convertNode(gqlNode, null, nodes));

  const nodeId2node = new Map<string, Node>();
  nodes.forEach((node) => nodeId2node.set(node.id, node));

  const nodeId2Depth = new Map<string, number>();
  nodes.forEach((node) => nodeId2Depth.set(node.id, nodeDepth(nodeId2node, node.id)));

  const edges: Edge[] = gqlDiagram.edges.map((gqlEdge) => {
    const zIndex = Math.max(nodeId2Depth.get(gqlEdge.sourceId), nodeId2Depth.get(gqlEdge.targetId));

    return {
      id: gqlEdge.id,
      type: 'step',
      source: gqlEdge.sourceId,
      target: gqlEdge.targetId,
      zIndex,
    };
  });

  return {
    nodes,
    edges,
  };
};