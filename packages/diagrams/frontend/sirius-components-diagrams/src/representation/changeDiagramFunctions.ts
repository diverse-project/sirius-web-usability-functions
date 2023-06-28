import { SModelElement, SParentElement } from 'sprotty/lib/base/model/smodel';
import { DiagramServer } from '../sprotty/DiagramServer';
import { SiriusUpdateModelAction } from '../sprotty/DiagramServer.types';
import { DiagramDescription, GQLDiagram, GQLNode, GQLViewModifier } from './DiagramRepresentation.types';
import { DirectionalGraph, diagramToGraph, mapIdToNodes } from './graph';

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

export class DiagramRefreshTool {
  diagram: GQLDiagram;
  originDiagramNodes: Map<string, GQLNode>;
  diagramDescription: DiagramDescription;
  readOnly: boolean;
  diagramServer: DiagramServer;
  level: string;

  constructor(
    diagram: GQLDiagram,
    diagramDescription: DiagramDescription,
    readOnly: boolean,
    diagramServer: DiagramServer
  ) {
    this.diagram = diagram;
    this.originDiagramNodes = mapIdToNodes(diagram);
    this.diagramDescription = diagramDescription;
    this.readOnly = readOnly;
    this.diagramServer = diagramServer;
    this.level = '1';
  }

  refreshDiagram = (
    diagram: GQLDiagram,
    diagramDescription: DiagramDescription,
    readOnly: boolean,
    diagramServer: DiagramServer
  ): void => {
    this.refreshDiagramWhithLevel(diagram, diagramDescription, readOnly, diagramServer, this.level);
  };

  refreshDiagramWhithLevel = (
    diagram: GQLDiagram,
    diagramDescription: DiagramDescription,
    readOnly: boolean,
    diagramServer: DiagramServer,
    level: string
  ): void => {
    if (this.diagram == null) {
      this.diagram = diagram;
      this.diagramDescription = diagramDescription;
      this.readOnly = readOnly;
      this.diagramServer = diagramServer;
      this.originDiagramNodes = mapIdToNodes(structuredClone(diagram));
    }
    const levelDifference = +this.level - +level;
    this.level = level;
    const graph = diagramToGraph(this.diagram);
    if (graph != null) {
      this.hideNodesWithLevel(this.diagram, graph, this.level, levelDifference);
      console.log(getDiagramNodesState(this.diagram));
      const action: SiriusUpdateModelAction = {
        kind: 'siriusUpdateModel',
        diagram: this.diagram,
        diagramDescription: this.diagramDescription,
        readOnly: this.readOnly,
      };
      diagramServer.actionDispatcher.dispatch(action);
    }
  };

  hideNodesWithLevel(diagram: GQLDiagram, graph: DirectionalGraph, level: string, levelDifference: number) {
    var elements: GQLNode[] = [];
    switch (level) {
      case '1.25':
        for (const node of diagram.nodes) {
          node.label.text = '';
        }
        break;
      case '1':
        if (levelDifference == 0.25) {
          console.log('Hey');
          console.log(this.originDiagramNodes);
          for (const node of diagram.nodes) {
            node.label.text = this.originDiagramNodes.get(node.id).label.text;
          }
        }
        break;
      case '0.75':
        if (levelDifference == 0.5) {
          for (const node of diagram.nodes) {
            node.label.text = this.originDiagramNodes.get(node.id).label.text;
          }
        }
        elements = graph.getLeaveNodes();
        break;
      case '0.5':
        if (levelDifference == 0.75) {
          for (const node of diagram.nodes) {
            node.label.text = this.originDiagramNodes.get(node.id).label.text;
          }
        }
        const numberOfConnectionsPerNode = graph.getNumberOfConnectionsPerNode();
        for (const node of numberOfConnectionsPerNode.keys()) {
          if (numberOfConnectionsPerNode.get(node) < 3) {
            elements.push(node);
          }
        }
        break;
      default:
        elements = graph.getRootNodes();
        break;
    }
    var numberOfRemainingElements: number = diagram.nodes.length - elements.length;
    for (const element of elements) {
      element.state = GQLViewModifier.Hidden;
    }
    for (const element of diagram.nodes) {
      if (!elements.includes(element)) {
        element.state = GQLViewModifier.Normal;
        if (numberOfRemainingElements < 4 && element.size.height < 200 && element.size.width < 200) {
          //the label does not make the adjustement with the size of the image and the size remains the same when going to an other size
          /* element.size.height = 200;
          element.size.width = 200; */
        }
      }
    }
  }
}