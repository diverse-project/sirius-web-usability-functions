/*******************************************************************************
 * Copyright (c) 2019, 2023 Obeo and others.
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
import { gql } from '@apollo/client';

export const diagramEventSubscription = gql`
  subscription diagramEvent($input: DiagramEventInput!) {
    diagramEvent(input: $input) {
      __typename
      ... on ErrorPayload {
        id
        message
      }
      ... on SubscribersUpdatedEventPayload {
        id
        subscribers {
          username
        }
      }
      ... on DiagramRefreshedEventPayload {
        id
        diagram {
          id
          metadata {
            kind
            label
          }
          targetObjectId
          position {
            x
            y
          }
          size {
            width
            height
          }
          nodes {
            ...nodeFields
            borderNodes {
              ...nodeFields
              borderNodes {
                ...nodeFields
              }
              childNodes {
                ...nodeFields
                borderNodes {
                  ...nodeFields
                }
                childNodes {
                  ...nodeFields
                  borderNodes {
                    ...nodeFields
                  }
                }
              }
            }
            childNodes {
              ...nodeFields
              borderNodes {
                ...nodeFields
              }
              childNodes {
                ...nodeFields
                borderNodes {
                  ...nodeFields
                }
                childNodes {
                  ...nodeFields
                  borderNodes {
                    ...nodeFields
                  }
                  childNodes {
                    ...nodeFields
                    borderNodes {
                      ...nodeFields
                    }
                    childNodes {
                      ...nodeFields
                    }
                  }
                }
              }
            }
          }
          edges {
            ...edgeFields
          }
        }
      }
    }
  }

  fragment nodeFields on Node {
    id
    type
    targetObjectId
    targetObjectKind
    targetObjectLabel
    descriptionId
    state
    label {
      ...labelFields
    }
    style {
      ...styleFields
    }
    position {
      x
      y
    }
    size {
      width
      height
    }
    userResizable
    semanticZoom {
      semanticZoomStrategies {
        ...semanticZoomStrategyFields
      }
    }
  }

  fragment semanticZoomStrategyFields on ISemanticZoomStrategy {
    ... on AutomaticZoomingByDepthStrategy {
      activeStrategy
      styleDetailled {
        ...styleFields
      }
      styleNormal {
        ...styleFields
      }
      styleSummarized {
        ...styleFields
      }
    }
    ... on NumberOfRelationStrategy {
      activeStrategy
      numberOfRelation
      styleDetailled {
        ...styleFields
      }
      styleNormal {
        ...styleFields
      }
      styleSummarized {
        ...styleFields
      }
    }
    ... on ManuallyDefinedStrategy {
      activeStrategy
      styleDetailled {
        ...styleFields
      }
      styleNormal {
        ...styleFields
      }
      styleSummarized {
        ...styleFields
      }
    }
  }

  fragment styleFields on INodeStyle {
    ... on RectangularNodeStyle {
      color
      borderColor
      borderStyle
      borderSize
      borderRadius
      withHeader
    }
    ... on ImageNodeStyle {
      imageURL
      borderColor
      borderStyle
      borderSize
      borderRadius
    }
    ... on ParametricSVGNodeStyle {
      svgURL
      backgroundColor
      borderColor
      borderRadius
      borderSize
      borderStyle
    }
    ... on IconLabelNodeStyle {
      backgroundColor
    }
  }

  fragment edgeFields on Edge {
    id
    type
    targetObjectId
    targetObjectKind
    targetObjectLabel
    descriptionId
    sourceId
    targetId
    state
    beginLabel {
      ...labelFields
    }
    centerLabel {
      ...labelFields
    }
    endLabel {
      ...labelFields
    }
    style {
      size
      lineStyle
      sourceArrow
      targetArrow
      color
    }
    routingPoints {
      x
      y
    }
    sourceAnchorRelativePosition {
      x
      y
    }
    targetAnchorRelativePosition {
      x
      y
    }
  }

  fragment labelFields on Label {
    id
    type
    text
    style {
      color
      fontSize
      bold
      italic
      underline
      strikeThrough
      iconURL
    }
    position {
      x
      y
    }
    size {
      width
      height
    }
    alignment {
      x
      y
    }
  }
`;

export const deleteFromDiagramMutation = gql`
  mutation deleteFromDiagram($input: DeleteFromDiagramInput!) {
    deleteFromDiagram(input: $input) {
      __typename
      ... on DeleteFromDiagramSuccessPayload {
        diagram {
          id
        }
      }
      ... on ErrorPayload {
        message
      }
    }
  }
`;

export const editLabelMutation = gql`
  mutation editLabel($input: EditLabelInput!) {
    editLabel(input: $input) {
      __typename
      ... on EditLabelSuccessPayload {
        diagram {
          id
        }
      }
      ... on ErrorPayload {
        message
      }
    }
  }
`;

export const updateNodePositionOp = gql`
  mutation updateNodePosition($input: UpdateNodePositionInput!) {
    updateNodePosition(input: $input) {
      __typename
      ... on UpdateNodePositionSuccessPayload {
        diagram {
          id
        }
      }
      ... on ErrorPayload {
        message
      }
    }
  }
`;

export const updateNodeBoundsOp = gql`
  mutation updateNodeBounds($input: UpdateNodeBoundsInput!) {
    updateNodeBounds(input: $input) {
      __typename
      ... on UpdateNodeBoundsSuccessPayload {
        diagram {
          id
        }
      }
      ... on ErrorPayload {
        message
      }
    }
  }
`;

export const reconnectEdgeMutation = gql`
  mutation reconnectEdge($input: ReconnectEdgeInput!) {
    reconnectEdge(input: $input) {
      __typename
      ... on ErrorPayload {
        message
      }
    }
  }
`;

export const invokeSingleClickOnDiagramElementToolMutation = gql`
  mutation invokeSingleClickOnDiagramElementTool($input: InvokeSingleClickOnDiagramElementToolInput!) {
    invokeSingleClickOnDiagramElementTool(input: $input) {
      __typename
      ... on InvokeSingleClickOnDiagramElementToolSuccessPayload {
        newSelection {
          entries {
            id
            label
            kind
          }
        }
        messages {
          body
          level
        }
      }
      ... on ErrorPayload {
        messages {
          body
          level
        }
      }
    }
  }
`;

export const invokeSingleClickOnTwoDiagramElementsToolMutation = gql`
  mutation invokeSingleClickOnTwoDiagramElementsTool($input: InvokeSingleClickOnTwoDiagramElementsToolInput!) {
    invokeSingleClickOnTwoDiagramElementsTool(input: $input) {
      __typename
      ... on InvokeSingleClickOnTwoDiagramElementsToolSuccessPayload {
        newSelection {
          entries {
            id
            label
            kind
          }
        }
        messages {
          body
          level
        }
      }
      ... on ErrorPayload {
        messages {
          body
          level
        }
      }
    }
  }
`;

export const arrangeAllOp = gql`
  mutation arrangeAll($input: ArrangeAllInput!) {
    arrangeAll(input: $input) {
      __typename
      ... on ErrorPayload {
        message
      }
    }
  }
`;

export const updateEdgeRoutingPointsOp = gql`
  mutation updateEdgeRoutingPoints($input: UpdateEdgeRoutingPointsInput!) {
    updateEdgeRoutingPoints(input: $input) {
      __typename
      ... on ErrorPayload {
        message
      }
    }
  }
`;
