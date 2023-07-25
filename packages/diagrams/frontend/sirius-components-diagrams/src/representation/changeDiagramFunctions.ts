import { DiagramServer } from '../sprotty/DiagramServer';
import { SiriusUpdateModelAction } from '../sprotty/DiagramServer.types';
import {
  DiagramDescription,
  GQLDiagram,
  GQLISemanticZoomStrategy,
  GQLNode,
  GQLViewModifier,
  ManuallyDefinedStrategy,
  NumberOfRelationStrategy,
} from './DiagramRepresentation.types';
import { DirectionalGraph, diagramToGraph, mapIdToNodes } from './graph';

type ExtendedStrategy = GQLISemanticZoomStrategy & {
  __typename?: string;
};

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
    this.levelOfZoom = level; //Store the value of zoom
    const [graph, nodeList] = diagramToGraph(this.diagram); //Get structures needed to know which elements need to be modified
    if (graph != null) {
      this.hideNodesWithLevel(graph, this.levelOfZoom, nodeList); //Call to the function who modify elements
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
  hideNodesWithLevel(graph: Map<number, DirectionalGraph>, level: string, nodeList: GQLNode[]) {
    const zoomLevelNumber: number = +level;
    var count: number = 0; //Variable storing number of level of the diagram we worked on
    const numberOfLevels = [...graph.keys()].length; //Number of level of the diagram
    var scaleCount: number = [...graph.keys()].length; //Variable used to scale the modifications applied at each level of zoom
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
          ({ scaleCount, count } = this.scaleLevelHiding(scaleCount, numberOfLevels, count, graph, level));
          //Saving the list of the current value of each node by storing a copy of these and setting the map at this level of zoom
          const tmpNodeList: GQLNode[] = [];
          for (const node of nodeList) {
            tmpNodeList.push(structuredClone(node));
          }
          this.listOfLevels.set(level, tmpNodeList);
        }
      }
    }
    //Apply the style
    for (let i = 0; i < nodeList.length; i++) {
      let zoomLevelNumberProtection = zoomLevelNumber;
      if (zoomLevelNumber > 1) {
        zoomLevelNumberProtection = 1;
      }
      if (this.listOfLevels.get(zoomLevelNumberProtection) != undefined) {
        const nodeTmp = this.listOfLevels.get(zoomLevelNumberProtection).find((n) => n.id == nodeList[i].id);
        nodeList[i].state = nodeTmp.state;
        nodeList[i].label = nodeTmp.label;
        nodeList[i].position = nodeTmp.position;
        nodeList[i].size = nodeTmp.size;
        nodeList[i].style = nodeTmp.style;
      }
    }
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
    level: number
  ) {
    if (Math.floor(scaleCount - numberOfLevels / 5) != Math.floor(scaleCount)) {
      count = this.changeNodeProperties(graph, count, level, true); //Call to the function with a level change
    } else {
      count = this.changeNodeProperties(graph, count, level, false); //Call to the function without a level change
    }
    scaleCount = scaleCount - numberOfLevels / 5; //Decrementing the scaled count
    return { scaleCount, count };
  }

  //Hide and modify properties of the nodes
  changeNodeProperties(
    graph: Map<number, DirectionalGraph>,
    count: number,
    level: number,
    changingLevelOfHiding: boolean
  ) {
    if (graph.size - count - 1 >= 0) {
      //If we are changing of level
      if (changingLevelOfHiding) {
        count++; //Because we have hidden a level, we increment the count
      }
      const graphAtLevel = graph.get(graph.size - count);
      const numberOfConnectionsPerNode = graphAtLevel.getNumberOfConnectionsPerNode();
      for (const node of graphAtLevel.getNodes()) {
        const semanticStrategies: ExtendedStrategy[] | undefined = node.semanticZoom.semanticZoomStrategies;
        for (const strategy of semanticStrategies) {
          if (
            strategy !== undefined &&
            strategy.__typename === 'AutomaticZoomingByDepthStrategy' &&
            strategy.activeStrategy &&
            changingLevelOfHiding
          ) {
            if (strategy.styleSummarized.__typename === 'EmptyNodeStyle') {
              node.state = GQLViewModifier.Hidden;
            } else {
              node.style = strategy.styleSummarized;
            }
          }
          if (strategy !== undefined && strategy.__typename === 'ManuallyDefinedStrategy' && strategy.activeStrategy) {
            const strategyCast = strategy as ManuallyDefinedStrategy;
            if (level == strategyCast.zoomDetailled) {
              if (strategy.styleDetailled.__typename === 'EmptyNodeStyle') {
                node.state = GQLViewModifier.Hidden;
              } else {
                node.style = strategy.styleDetailled;
              }
            } else if (level == strategyCast.zoomNormal) {
              if (strategy.styleNormal.__typename === 'EmptyNodeStyle') {
                node.state = GQLViewModifier.Hidden;
              } else {
                node.style = strategy.styleNormal;
              }
            } else if (level == strategyCast.zoomSummarized) {
              if (strategy.styleSummarized.__typename === 'EmptyNodeStyle') {
                node.state = GQLViewModifier.Hidden;
              } else {
                node.style = strategy.styleSummarized;
              }
            }
          }
          if (strategy !== undefined && strategy.__typename === 'NumberOfRelationStrategy' && strategy.activeStrategy) {
            if (numberOfConnectionsPerNode.get(node) < (strategy as NumberOfRelationStrategy).numberOfRelation) {
              if (strategy.styleSummarized.__typename === 'EmptyNodeStyle') {
                console.log('coucou');
                node.state = GQLViewModifier.Hidden;
              } else {
                console.log('hibou');
                node.style = strategy.styleSummarized;
              }
            }
          }
        }
      }
    }
    return count;
  }
}
