import { GQLDiagram, GQLNode } from './DiagramRepresentation.types';

export class DirectionalGraph {
  private nodes: Map<GQLNode, Set<GQLNode>>;
  private numberOfConnectionsPerNode: Map<GQLNode, number>;

  constructor() {
    this.nodes = new Map<GQLNode, Set<GQLNode>>();
    this.numberOfConnectionsPerNode = new Map<GQLNode, number>();
  }

  addNode(node: GQLNode): void {
    if (!this.nodes.has(node) && node != undefined) {
      this.nodes.set(node, new Set<GQLNode>());
    }
    if (!this.numberOfConnectionsPerNode.has(node)) {
      this.numberOfConnectionsPerNode.set(node, 0);
    }
  }

  addEdge(source: GQLNode, destination: GQLNode): void {
    if (source != undefined && destination != undefined) {
      this.addNode(source);
      this.addNode(destination);

      this.nodes.get(source).add(destination);

      this.numberOfConnectionsPerNode.set(source, this.numberOfConnectionsPerNode.get(source) + 1);
      this.numberOfConnectionsPerNode.set(destination, this.numberOfConnectionsPerNode.get(destination) + 1);
    }
  }

  getNodes(): GQLNode[] {
    const nodes = [];
    for (const node of this.nodes.keys()) {
      nodes.push(node);
    }
    return nodes;
  }

  getLeaveNodes(): GQLNode[] {
    let leaveNode: GQLNode[] = [];
    for (const node of this.nodes.keys()) {
      if (this.nodes.get(node).size == 0) {
        leaveNode.push(node);
      }
    }
    return leaveNode;
  }

  getLeaveNodesId(): string[] {
    const leaveNode: GQLNode[] = this.getLeaveNodes();
    const nodeId = [];
    for (const node of leaveNode) {
      nodeId.push(node.id);
    }
    return nodeId;
  }

  getRootNodes(): GQLNode[] {
    let rootNode: GQLNode[] = [];
    for (const node of this.nodes.keys()) {
      if (this.nodes.get(node).size == this.numberOfConnectionsPerNode.get(node)) {
        rootNode.push(node);
      }
    }
    return rootNode;
  }

  getRootNodesId(): string[] {
    const rootNode: GQLNode[] = this.getRootNodes();
    const nodeId = [];
    for (const node of rootNode) {
      nodeId.push(node.id);
    }
    return nodeId;
  }

  getNumberOfConnectionsPerNode(): Map<GQLNode, number> {
    return this.numberOfConnectionsPerNode;
  }

  toString(): string {
    let graphToString: string = '';
    for (const key of this.nodes.keys()) {
      graphToString += 'source : ' + key.label.text + ' --> target : ';
      for (const value of this.nodes.get(key)) {
        graphToString += value.label.text + ', ';
      }
      graphToString += '\n';
    }
    return graphToString;
  }
}

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

/* export const mapIdToNodes = (diagram: GQLDiagram): Map<string, GQLNode> => {
  if (diagram != null) {
    let idToNodes = new Map<string, GQLNode>();
    const nodes = diagram.nodes;
    for (const node of nodes) {
      for (const child of node.childNodes) {
        idToNodes.set(child.id, child);
      }
    }
    return idToNodes;
  }
  return null;
}; */

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

export const diagramToGraph = (diagram: GQLDiagram): [Map<number, DirectionalGraph>, GQLNode[]] => {
  if (diagram != null) {
    let graphWithLevel = new Map<number, DirectionalGraph>();
    const [mapOfLevel, nodeList] = getEachLevelOfNodes(diagram);
    for (const level of mapOfLevel.keys()) {
      let graph = new DirectionalGraph();
      const map = mapIdToNodesAtLevel(mapOfLevel.get(level));
      const edges = diagram.edges;
      for (const node of map.keys()) {
        graph.addNode(map.get(node));
      }
      for (const edge of edges) {
        graph.addEdge(map.get(edge.sourceId), map.get(edge.targetId));
      }
      graphWithLevel.set(level, graph);
    }
    return [graphWithLevel, nodeList];
  }
  return null;
};

export const getEachLevelOfNodes = (diagram: GQLDiagram): [Map<number, GQLNode[]>, GQLNode[]] => {
  if (diagram != null) {
    const map = new Map<number, GQLNode[]>();
    const nodeList: GQLNode[] = [];
    for (const node of diagram.nodes) {
      nodeList.push(node);
    }
    var floor = false;
    var count = 0;
    var nodesAtEachLevel = diagram.nodes;
    while (!floor) {
      map.set(count, nodesAtEachLevel);
      count++;
      const nodesAtNextLevel: GQLNode[] = [];
      for (const node of nodesAtEachLevel) {
        for (const child of node.childNodes) {
          nodesAtNextLevel.push(child);
          nodeList.push(child);
        }
      }
      nodesAtEachLevel = nodesAtNextLevel;
      if (nodesAtEachLevel.length == 0) {
        floor = true;
      }
    }
    return [map, nodeList];
  }
  return null;
};
