import { SModelElement, SParentElement } from 'sprotty/lib/base/model/smodel';
import { GQLDiagram } from './DiagramRepresentation.types';

/**
 * This functions are mostly used to visualize some informations about the diagram while debugging,
 * they are not used when it comes to the semantic zoom out.
 */

//Return the height and the width of the diagram
export const getDiagramSize = (diagram: GQLDiagram): string => {
  if (diagram != null) {
    return '(height : ' + diagram.size.height + ', width : ' + diagram.size.width + ')';
  }
  return 'null';
};

//Return all the nodes of level 0 of the diagram with their name, type and their children
export const getDiagramNodesName = (diagram: GQLDiagram): string => {
  if (diagram != null) {
    var childrenNames: string = '';
    const diagramNodes = diagram.nodes;
    for (const node of diagramNodes) {
      childrenNames += 'node : ' + node.label.text + ' type : ' + node.descriptionId + ' children : ';
      if (node.childNodes.length == 0) {
        childrenNames += 'void';
      }
      for (const nodeChild of node.childNodes) {
        childrenNames += nodeChild.label.text + ' ';
      }
      childrenNames += '\n';
    }
    return childrenNames;
  }
  return 'null';
};

//Return the ID of the node source and the targeted node of each edge
export const getDiagramEdgesId = (diagram: GQLDiagram): string => {
  if (diagram != null) {
    var childrenNames: string = '';
    const diagramEdges = diagram.edges;
    for (const edge of diagramEdges) {
      childrenNames += 'from : ' + edge.sourceId + ' to : ' + edge.targetId + '\n';
    }
    return childrenNames;
  }
  return 'null';
};

//Return the ID of each node with its name and its children
export const getDiagramNodesId = (diagram: GQLDiagram): string => {
  if (diagram != null) {
    var childrenNames: string = '';
    const diagramNodes = diagram.nodes;
    for (const node of diagramNodes) {
      childrenNames += 'node ' + node.label.text + ' id : ' + node.id + ' children : ';
      if (node.childNodes.length == 0) {
        childrenNames += 'void';
      }
      for (const nodeChild of node.childNodes) {
        childrenNames += nodeChild.id + ' ';
      }
      childrenNames += '\n';
    }
    return childrenNames;
  }
  return 'null';
};

//Return the state of all the nodes of level 0 of the diagram
export const getDiagramNodesState = (diagram: GQLDiagram): string => {
  if (diagram != null) {
    var childrenNames: string = '';
    const diagramNodes = diagram.nodes;
    for (const node of diagramNodes) {
      childrenNames += 'node ' + node.label.text + ' state : ' + node.state + '\n';
    }
    return childrenNames;
  }
  return 'null';
};

//Show the ID and type of a sprotty element
export const showOneElementId = (element: SParentElement): string => {
  var elements = 'id : ' + element.id + ' type : ' + element.type + '\n';
  return elements;
};

//Show the ID and type of all the sprotty elements of a sprotty model
export const showElementsId = (elements: SModelElement[]): string => {
  var elementsMessage = '';
  for (const element of elements) {
    elementsMessage += 'id : ' + element.id + ' type : ' + element.type + '\n';
  }
  return elementsMessage;
};
