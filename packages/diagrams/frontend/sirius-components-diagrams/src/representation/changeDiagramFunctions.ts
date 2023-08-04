import { DiagramServer } from '../sprotty/DiagramServer';
import { SiriusUpdateModelAction } from '../sprotty/DiagramServer.types';
import { DiagramDescription, GQLDiagram, GQLNode, GQLViewModifier } from './DiagramRepresentation.types';
import { DirectionalGraph, diagramToGraph, mapIdToNodes } from './graph';

//Class used to store, modify and refresh the diagram and its nodes
export class DiagramRefreshTool {
  diagram: GQLDiagram;
  originDiagramNodes: Map<string, GQLNode>; //State of the diagram at the beginning before zooming out
  diagramDescription: DiagramDescription;
  readOnly: boolean;
  diagramServer: DiagramServer;
  levelOfZoom: string; //Level of zoom corresponding to the zoom of setZoomLevel
  listOfLevels: Map<number, GQLNode[]>; //List of the nodes at each level of the diagram (!= level of zoom)

  //Initialize the parameters (with null values in practice the first time)
  constructor(
    diagram: GQLDiagram,
    diagramDescription: DiagramDescription,
    readOnly: boolean,
    diagramServer: DiagramServer
  ) {
    this.diagram = diagram;
    this.originDiagramNodes = mapIdToNodes(diagram); //Map all nodes to its ID
    this.diagramDescription = diagramDescription;
    this.readOnly = readOnly;
    this.diagramServer = diagramServer;
    this.levelOfZoom = '1'; //Initialize to default value 100%
    this.listOfLevels = null;
  }

  //Refresh the diagram without knowing the level of zoom (refresh it with the value of zoom stored at this moment)
  refreshDiagram = (
    diagram: GQLDiagram,
    diagramDescription: DiagramDescription,
    readOnly: boolean,
    diagramServer: DiagramServer
  ): void => {
    this.refreshDiagramWhithLevel(diagram, diagramDescription, readOnly, diagramServer, this.levelOfZoom);
  };

  //Refresh the diagram with the level of zoom
  refreshDiagramWhithLevel = (
    diagram: GQLDiagram,
    diagramDescription: DiagramDescription,
    readOnly: boolean,
    diagramServer: DiagramServer,
    level: string
  ): void => {
    if (this.diagram == null) {
      //Real initialization of the parameters because called when the diagram exists
      this.diagram = diagram;
      this.diagramDescription = diagramDescription;
      this.readOnly = readOnly;
      this.diagramServer = diagramServer;
      this.originDiagramNodes = mapIdToNodes(structuredClone(diagram)); //Store the map of copy of the diagram, otherwise changes to nodes of the diagram
      //would impact the origin diagram stored
    }
    const zoomLevelDifference = +this.levelOfZoom - +level; //Get the difference of level between the current level and the former level
    this.levelOfZoom = level; //Store the value of zoom
    const [graph, nodeList] = diagramToGraph(this.diagram); //Get structures needed to know which elements need to be modified
    if (graph != null) {
      this.hideNodesWithLevel(graph, this.levelOfZoom, zoomLevelDifference, nodeList); //Call to the function who modify elements
      const action: SiriusUpdateModelAction = {
        kind: 'siriusUpdateModel',
        diagram: this.diagram,
        diagramDescription: this.diagramDescription,
        readOnly: this.readOnly,
      };
      diagramServer.actionDispatcher.dispatch(action); //Call the action that refresh the diagram displayed
    }
  };

  //Hide, reveal and modify elements depending on the zoom level
  hideNodesWithLevel(
    graph: Map<number, DirectionalGraph>,
    level: string,
    zoomLevelDifference: number,
    nodeList: GQLNode[]
  ) {
    const zoomLevelNumber: number = +level;
    var count: number = 0; //Variable storing number of level of the diagram we worked on
    const numberOfLevels = [...graph.keys()].length; //Number of level of the diagram
    var scaleCount: number = [...graph.keys()].length + numberOfLevels / 6; //Variable used to scale the modifications applied at each level of zoom
    //When the entire part of the number change, it means that we need to hide a level of nodes of the diagram
    const listOfLevelsNumber: number[] = [1.0, 0.75, 0.5, 0.25, 0.1, 0.05];
    if (this.listOfLevels == null) {
      this.listOfLevels = new Map<number, GQLNode[]>(); //Initialize the list of all nodes (to store state, size, label) at each level of zoom
      const tmpNodeList: GQLNode[] = [];
      //Setting the map for level of zoom 100% (initial level)
      for (const node of nodeList) {
        tmpNodeList.push(structuredClone(node));
      }
      this.listOfLevels.set(1.0, tmpNodeList);
      //For each level, apply one time the level hiding and store the actual value of all nodes
      for (const level of listOfLevelsNumber) {
        if (level != 1.0) {
          //Get the new values of count and scale count after applying the function to one level of the diagram
          ({ scaleCount, count } = this.scaleLevelHiding(
            scaleCount,
            numberOfLevels,
            count,
            graph,
            zoomLevelDifference
          ));
          //Saving the list of the current value of each node by storing a copy of these and setting the map at this level of zoom
          const tmpNodeList: GQLNode[] = [];
          for (const node of nodeList) {
            tmpNodeList.push(structuredClone(node));
          }
          this.listOfLevels.set(level, tmpNodeList);
        }
      }
    }
    //We set the diagram (value of each node) to the value stored in the map
    for (const level of listOfLevelsNumber) {
      if (zoomLevelNumber == level) {
        if (level == 0.75) {
          this.hideEdgesLabel(this.diagram);
        }
        for (let i = 0; i < nodeList.length; i++) {
          const nodeTmp = this.listOfLevels.get(level).find((n) => n.id == nodeList[i].id);
          nodeList[i].state = nodeTmp.state;
          nodeList[i].label = nodeTmp.label;
          nodeList[i].position = nodeTmp.position;
          nodeList[i].size = nodeTmp.size;
        }
      }
    }
    console.log(this.diagram);
  }

  //Hide the label of all edges
  hideEdgesLabel(diagram: GQLDiagram): void {
    for (const edge of diagram.edges) {
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

  //Depending on the scaling difference, choose the action to execute
  scaleLevelHiding(
    scaleCount: number,
    numberOfLevels: number,
    count: number,
    graph: Map<number, DirectionalGraph>,
    zoomLevelDifference: number
  ) {
    //console.log(Math.floor(scaleCount - numberOfLevels / 6) + ' == ' + Math.floor(scaleCount));
    if (Math.floor(scaleCount - numberOfLevels / 6) != Math.floor(scaleCount)) {
      count = this.addElementByLevel(graph, count, true, zoomLevelDifference); //Call to the function with a level change
    } else {
      count = this.addElementByLevel(graph, count, false, zoomLevelDifference); //Call to the function without a level change
    }
    scaleCount = scaleCount - numberOfLevels / 6; //Decrementing the scaled count
    return { scaleCount, count };
  }

  //Hide and modify properties of the nodes
  addElementByLevel(
    graph: Map<number, DirectionalGraph>,
    count: number,
    changingLevelOfHiding: boolean,
    zoomLevelDifference: number
  ) {
    if (graph.size - count - 1 != 0) {
      if (zoomLevelDifference > 0) {
        //If we are zooming out
        if (changingLevelOfHiding) {
          //If we are changing of level
          for (let i = graph.size - count - 1; i >= 0; i--) {
            for (const node of graph.get(i).getNodes()) {
              if (node.semanticZoom.activeSemanticZoom) {
                node.label.style.fontSize = 30; //For all nodes, set the font size to 30
                if (i == graph.size - count - 1) {
                  node.state = GQLViewModifier.Hidden; //Adding all the nodes of the current level to the list to hide
                } else if (i == graph.size - count - 2) {
                  //Setting the size and the position all following nodes to have a better display
                  node.size.width = 200;
                  node.size.height = 150;
                  node.position.y = node.position.y + 20;
                } else {
                  //Setting the size and the position all every nodes following the following nodes to fit the new size
                  node.size.width = node.size.width + 50;
                }
              }
            }
          }
          count++; //Because we have hidden a level, we increment the count
        } else {
          //If we don't change the level of nodes in the diagram, we perform other changes like keeping the nodes with more than 3 connections
          const numberOfConnectionsPerNode = graph.get(graph.size - count - 1).getNumberOfConnectionsPerNode();
          for (const node of numberOfConnectionsPerNode.keys()) {
            if (node.semanticZoom.activeSemanticZoom) {
              if (numberOfConnectionsPerNode.get(node) < 3) {
                node.state = GQLViewModifier.Hidden;
              }
            }
          }
        }
      }
    }
    return count;
  }
}
