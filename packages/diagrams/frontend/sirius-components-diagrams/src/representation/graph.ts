import { GQLDiagram, GQLNode } from './DiagramRepresentation.types';

class DirectionalGraph {
  private nodes: Map<GQLNode, Set<GQLNode>>;
  private numberOfConnectionsPerNode: Map<GQLNode, number>;

  constructor() {
    this.nodes = new Map<GQLNode, Set<GQLNode>>();
    this.numberOfConnectionsPerNode = new Map<GQLNode, number>();
  }

  addNode(node: GQLNode): void {
    if (!this.nodes.has(node)) {
      this.nodes.set(node, new Set<GQLNode>());
    }
    if (!this.numberOfConnectionsPerNode.has(node)) {
      this.numberOfConnectionsPerNode.set(node, 0);
    }
  }

  addEdge(source: GQLNode, destination: GQLNode): void {
    this.addNode(source);
    this.addNode(destination);

    this.nodes.get(source).add(destination);

    this.numberOfConnectionsPerNode.set(source, this.numberOfConnectionsPerNode.get(source) + 1);
    this.numberOfConnectionsPerNode.set(destination, this.numberOfConnectionsPerNode.get(destination) + 1);
  }

  /* getNodesNumberOfConnections(): Map<GQLNode, number> {
    this.numberOfConnectionsPerNode = new Map<GQLNode, number>();
    for (const key of this.nodes.keys()) {
      if (!this.numberOfConnectionsPerNode.has(key)) {
        this.numberOfConnectionsPerNode.set(key, this.nodes.get(key).size);
      }
      for (const value of this.nodes.get(key)) {
        if (!this.numberOfConnectionsPerNode.has(value)) {
          this.numberOfConnectionsPerNode.set(value, this.nodes.get(value).size);
        }
        this.numberOfConnectionsPerNode.set(value, this.numberOfConnectionsPerNode.get(value) + 1);
      }
    }
    return this.numberOfConnectionsPerNode;
  } */

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

export const mapIdToNodes = (diagram: GQLDiagram): Map<string, GQLNode> => {
  if (diagram != null) {
    let idToNodes = new Map<string, GQLNode>();
    const nodes = diagram.nodes;
    for (const node of nodes) {
      idToNodes.set(node.id, node);
    }
    return idToNodes;
  }
  return null;
};

export const diagramToGraph = (diagram: GQLDiagram): DirectionalGraph => {
  if (diagram != null) {
    let graph = new DirectionalGraph();
    const map = mapIdToNodes(diagram);
    const edges = diagram.edges;
    for (const node of map.keys()) {
      graph.addNode(map.get(node));
    }
    for (const edge of edges) {
      graph.addEdge(map.get(edge.sourceId), map.get(edge.targetId));
    }
    return graph;
  }
  return null;
};
