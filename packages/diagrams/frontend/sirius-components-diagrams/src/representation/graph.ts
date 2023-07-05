import { GQLDiagram, GQLNode } from './DiagramRepresentation.types';

//Class used to create a graph from nodes and get information about the diagram
export class DirectionalGraph {
  private nodeGraph: Map<GQLNode, Set<GQLNode>>; //A node as key and all the targeted nodes as values
  private numberOfConnectionsPerNode: Map<GQLNode, number>; //Number of connection of a node

  constructor() {
    this.nodeGraph = new Map<GQLNode, Set<GQLNode>>();
    this.numberOfConnectionsPerNode = new Map<GQLNode, number>();
  }

  //Add a new node to the graph and initialize it in the number of connections map with 0
  addNode(node: GQLNode): void {
    if (!this.nodeGraph.has(node) && node != undefined) {
      this.nodeGraph.set(node, new Set<GQLNode>());
    }
    if (!this.numberOfConnectionsPerNode.has(node)) {
      this.numberOfConnectionsPerNode.set(node, 0);
    }
  }

  //Add two new nodes if they don't exist and add the destination node to the targeted node of the source node in the map
  //Add 1 (one connection) to each of the node
  addEdge(source: GQLNode, destination: GQLNode): void {
    if (source != undefined && destination != undefined) {
      this.addNode(source);
      this.addNode(destination);

      this.nodeGraph.get(source).add(destination);

      this.numberOfConnectionsPerNode.set(source, this.numberOfConnectionsPerNode.get(source) + 1);
      this.numberOfConnectionsPerNode.set(destination, this.numberOfConnectionsPerNode.get(destination) + 1);
    }
  }

  //Return all the nodes of the graph
  getNodes(): GQLNode[] {
    const nodes = [];
    for (const node of this.nodeGraph.keys()) {
      nodes.push(node);
    }
    return nodes;
  }

  //Return all the leave nodes of the graph (nodes with no targeted node)
  getLeaveNodes(): GQLNode[] {
    let leaveNode: GQLNode[] = [];
    for (const node of this.nodeGraph.keys()) {
      if (this.nodeGraph.get(node).size == 0) {
        leaveNode.push(node);
      }
    }
    return leaveNode;
  }

  //Return the IDs of the leave nodes
  getLeaveNodesId(): string[] {
    const leaveNode: GQLNode[] = this.getLeaveNodes();
    const nodeId = [];
    for (const node of leaveNode) {
      nodeId.push(node.id);
    }
    return nodeId;
  }

  //Return all the root nodes of the graph (nodes no targeted by other nodes)
  getRootNodes(): GQLNode[] {
    let rootNode: GQLNode[] = [];
    for (const node of this.nodeGraph.keys()) {
      if (this.nodeGraph.get(node).size == this.numberOfConnectionsPerNode.get(node)) {
        rootNode.push(node);
      }
    }
    return rootNode;
  }

  //Return the IDs of the root nodes
  getRootNodesId(): string[] {
    const rootNode: GQLNode[] = this.getRootNodes();
    const nodeId = [];
    for (const node of rootNode) {
      nodeId.push(node.id);
    }
    return nodeId;
  }

  //Return the map of the number of connection per node
  getNumberOfConnectionsPerNode(): Map<GQLNode, number> {
    return this.numberOfConnectionsPerNode;
  }

  //Return the graph as a String
  toString(): string {
    let graphToString: string = '';
    for (const key of this.nodeGraph.keys()) {
      graphToString += 'source : ' + key.label.text + ' --> target : ';
      for (const value of this.nodeGraph.get(key)) {
        graphToString += value.label.text + ', ';
      }
      graphToString += '\n';
    }
    return graphToString;
  }
}

//Return a String of all the ID of a node and the Node in a map
export const mapToString = (map: Map<string, GQLNode>): string => {
  if (map != null) {
    let mapMessage: string = '';
    for (const id of map.keys()) {
      mapMessage += 'id : ' + id + ' value : ' + map.get(id).label.text + '\n';
    }
    return mapMessage;
  }
  return 'null';
};

//Return a map of all node ID linked to its node from a diagram by visiting it recursively
export const mapIdToNodes = (diagram: GQLDiagram): Map<string, GQLNode> => {
  if (diagram != null) {
    let idToNodes = new Map<string, GQLNode>();
    const traverse = (node: GQLNode) => {
      idToNodes.set(node.id, node);
      for (const childNode of node.childNodes) {
        traverse(childNode);
      }
    };
    for (const node of diagram.nodes) {
      traverse(node);
    }
    return idToNodes;
  }
  return null;
};

//Return a map of node ID at a specific level linked to its node from a list of nodes
export const mapIdToNodesAtLevel = (nodes: GQLNode[]): Map<string, GQLNode> => {
  if (nodes != null) {
    let idToNodes = new Map<string, GQLNode>();
    for (const node of nodes) {
      idToNodes.set(node.id, node);
    }
    return idToNodes;
  }
  return null;
};

//Turn a diagram to a map of graph where the key which is a number corresponds to the level of the diagram
//For example, the level 0 corresponds to the nodes wich contains nodes of level 1,
//the level 1 the nodes contained in nodes of level 0 and containing nodes of level 2 ...
export const diagramToGraph = (diagram: GQLDiagram): [Map<number, DirectionalGraph>, GQLNode[]] => {
  if (diagram != null) {
    let graphWithLevel = new Map<number, DirectionalGraph>();
    const [mapOfLevel, nodeList] = getEachLevelOfNodes(diagram); //Getting the map of all nodes per level and the list of all nodes
    for (const level of mapOfLevel.keys()) {
      let graph = new DirectionalGraph(); //Creating a graph for this level
      const map = mapIdToNodesAtLevel(mapOfLevel.get(level));
      const edges = diagram.edges;
      //Adding all nodes to the graph
      for (const node of map.keys()) {
        graph.addNode(map.get(node));
      }
      //Adding all connections between nodes to the graph
      for (const edge of edges) {
        graph.addEdge(map.get(edge.sourceId), map.get(edge.targetId));
      }
      graphWithLevel.set(level, graph); //Setting the graph at this level
    }
    return [graphWithLevel, nodeList];
  }
  return null;
};

//Return map of the list of nodes at a specific level and the list of all nodes of the diagram
export const getEachLevelOfNodes = (diagram: GQLDiagram): [Map<number, GQLNode[]>, GQLNode[]] => {
  if (diagram != null) {
    const map = new Map<number, GQLNode[]>();
    const nodeList: GQLNode[] = [];
    //Adding all the level 0 nodes of the diagram
    for (const node of diagram.nodes) {
      nodeList.push(node);
    }
    var floor = false;
    var count = 0;
    var nodesAtEachLevel = diagram.nodes; //Initialize the variable with the level 0 nodes of the diagram
    //Visit all the levels of nodes
    while (!floor) {
      map.set(count, nodesAtEachLevel); //Adding all the nodes of the level to the number of the level
      count++;
      const nodesAtNextLevel: GQLNode[] = [];
      for (const node of nodesAtEachLevel) {
        for (const child of node.childNodes) {
          nodesAtNextLevel.push(child); //Adding all the node children to the list of nodes at the next level
          nodeList.push(child); //Adding the nodes to the list of nodes
        }
      }
      nodesAtEachLevel = nodesAtNextLevel; //Setting the list of nodes to add at the next level with the list of node children
      if (nodesAtEachLevel.length == 0) {
        floor = true; //If there is no nodes in this list, it means that this is the last level of nodes
      }
    }
    return [map, nodeList];
  }
  return null;
};
