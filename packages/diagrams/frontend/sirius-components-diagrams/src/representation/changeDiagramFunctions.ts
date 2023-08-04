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
  listOfLevels: Map<number, GQLNode[]>;

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
    this.listOfLevels = null;
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
    const zoomLevelDifference = +this.level - +level;
    this.level = level;
    const [graph, nodeList] = diagramToGraph(this.diagram);
    if (graph != null) {
      this.hideNodesWithLevel(this.diagram, graph, this.level, zoomLevelDifference, nodeList);
      //console.log(getDiagramNodesState(this.diagram));
      const action: SiriusUpdateModelAction = {
        kind: 'siriusUpdateModel',
        diagram: this.diagram,
        diagramDescription: this.diagramDescription,
        readOnly: this.readOnly,
      };
      diagramServer.actionDispatcher.dispatch(action);
    }
  };

  hideNodesWithLevel(
    diagram: GQLDiagram,
    graph: Map<number, DirectionalGraph>,
    level: string,
    zoomLevelDifference: number,
    nodeList: GQLNode[]
  ) {
    var elements: GQLNode[] = [];
    const zoomLevelNumber: number = +level;
    var count: number = 0;
    const numberOfLevels = [...graph.keys()].length;
    var scaleCount: number = [...graph.keys()].length + numberOfLevels / 6;
    const listOfLevelsNumber: number[] = [1.0, 0.75, 0.5, 0.25, 0.1, 0.05];
    console.log(level);
    //console.log(nodeList);
    if (this.listOfLevels == null) {
      this.listOfLevels = new Map<number, GQLNode[]>();
      const tmpNodeList: GQLNode[] = [];
      for (const node of nodeList) {
        tmpNodeList.push(structuredClone(node));
      }
      console.log('Init :');
      this.listOfLevels.set(1.0, tmpNodeList);
      console.log(this.listOfLevels.get(1.0));
      //console.log(this.listOfLevels.get(1.0));
      for (const level of listOfLevelsNumber) {
        ({ scaleCount, count } = this.scaleLevelHiding(
          scaleCount,
          numberOfLevels,
          count,
          graph,
          elements,
          zoomLevelDifference
        ));
        for (const element of elements) {
          element.state = GQLViewModifier.Hidden;
        }
        for (const element of nodeList) {
          if (!elements.includes(element)) {
            if (zoomLevelNumber == 1.0) {
              element.label.style.fontSize = 14;
            }
            element.state = GQLViewModifier.Normal;
          }
        }
        const tmpNodeList: GQLNode[] = [];
        for (const node of nodeList) {
          tmpNodeList.push(structuredClone(node));
        }
        this.listOfLevels.set(level, tmpNodeList);
      }
    }
    for (const level of listOfLevelsNumber) {
      if (zoomLevelNumber == level) {
        for (let i = 0; i < nodeList.length; i++) {
          const nodeTmp = this.listOfLevels.get(level).find((n) => n.id == nodeList[i].id);
          console.log(this.listOfLevels.get(1.0));
          nodeList[i].state = nodeTmp.state;
          nodeList[i].label = nodeTmp.label;
          nodeList[i].position = nodeTmp.position;
          nodeList[i].size = nodeTmp.size;
          console.log(nodeList[i].label.text + ' ' + nodeList[i].state);
        }
      }
    }
  }

  hideEdgesLabel(diagram: GQLDiagram): void {
    for (const edge of diagram.edges) {
      //console.log(edge.style.sourceArrow + ' ' + edge.style.targetArrow + ' ' + edge.style.lineStyle);
      if (edge.beginLabel != null) {
        edge.beginLabel.text = '';
      }
      if (edge.centerLabel != null) {
        edge.centerLabel.text = '';
      }
      if (edge.endLabel != null) {
        edge.endLabel.text = '';
      }
    }
  }

  scaleLevelHiding(
    scaleCount: number,
    numberOfLevels: number,
    count: number,
    graph: Map<number, DirectionalGraph>,
    elements: GQLNode[],
    zoomLevelDifference: number
  ) {
    //console.log(Math.floor(scaleCount - numberOfLevels / 6) + ' == ' + Math.floor(scaleCount));
    if (Math.floor(scaleCount - numberOfLevels / 6) != Math.floor(scaleCount)) {
      count = this.addElementByLevel(graph, count, elements, true, zoomLevelDifference);
    } else {
      count = this.addElementByLevel(graph, count, elements, false, zoomLevelDifference);
    }
    scaleCount = scaleCount - numberOfLevels / 6;
    return { scaleCount, count };
  }

  addElementByLevel(
    graph: Map<number, DirectionalGraph>,
    count: number,
    elements: GQLNode[],
    changingLevelOfHiding: boolean,
    zoomLevelDifference: number
  ) {
    if (graph.size - count - 1 != 0) {
      if (zoomLevelDifference > 0) {
        //console.log(zoomLevelDifference);
        if (changingLevelOfHiding) {
          for (let i = graph.size - count - 1; i >= 0; i--) {
            for (const node of graph.get(i).getNodes()) {
              node.label.style.fontSize = 30;
              if (i == graph.size - count - 1) {
                elements.push(node);
              } else if (i == graph.size - count - 2) {
                node.size.width = 200;
                node.size.height = 150;
                node.position.y = node.position.y + 20;
              } else {
                node.size.width = node.size.width + 50;
              }
            }
          }
          count++;
        } else {
          const numberOfConnectionsPerNode = graph.get(graph.size - count - 1).getNumberOfConnectionsPerNode();
          for (const node of numberOfConnectionsPerNode.keys()) {
            if (numberOfConnectionsPerNode.get(node) < 3) {
              elements.push(node);
            }
          }
        }
      }
    }
    return count;
  }
}
