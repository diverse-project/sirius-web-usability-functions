import { SModelElement, SParentElement } from 'sprotty/lib/base/model/smodel';
import { GQLDiagram, GQLViewModifier } from './DiagramRepresentation.types';

export const getDiagramSize = (diagram: GQLDiagram): string => {
  if (diagram != null) {
    return '(height : ' + diagram.size.height + ', width : ' + diagram.size.width + ')';
  }
  return 'null';
};

export const getDiagramNodesName = (diagram: GQLDiagram): string => {
  if (diagram != null) {
    var childrenNames: string = '';
    const diagramNodes = diagram.nodes;
    for (const node of diagramNodes) {
      childrenNames += 'node : ' + node.label.text + ' children : ';
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

//does not hide nodes, only set the state to hidden, need to change to hide the node
export const hideNodes = (diagram: GQLDiagram) => {
  if (diagram != null) {
    const diagramNodes = diagram.nodes;
    for (const node of diagramNodes) {
      node.state = GQLViewModifier.Hidden;
    }
  }
};

/*
export const showSModelElements = useCallback((diagramElements: SModelElement[]): string => {
  var elements: string = '';
  for (const element of diagramElements) {
    elements += element.type + ' ';
  }
  return elements;
}, []);
*/

export const showOneElementId = (element: SParentElement): string => {
  var elements = 'id : ' + element.id + ' type : ' + element.type + '\n';
  /*  for (const child of element.children) {
    elements += 'child : ' + child.id + ' type ' + child.type + '\n';
  } */
  return elements;
};

export const showElementsId = (elements: SModelElement[]): string => {
  var elementsMessage = '';
  for (const element of elements) {
    elementsMessage += 'id : ' + element.id + ' type : ' + element.type + '\n';
  }
  return elementsMessage;
};
