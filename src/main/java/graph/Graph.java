package graph;

import lombok.Data;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Data
public class Graph {
    private Set<Node> nodeSet;
    private Map<Node, Set<Node>> edgeSet;

    public Graph() {
        nodeSet = new HashSet<>();
        edgeSet = new HashMap<>();
    }

    public void addNode(Node node) {
        nodeSet.add(node);
    }

    public void addEdge(Node from, Node to) {
        if (edgeSet.get(from) == null) {
            Set<Node> edges = new HashSet<>();
            edges.add(to);
            edgeSet.put(from, edges);
        } else {
            edgeSet.get(from).add(to);
        }
    }

    public boolean hasEdge(Node from, Node to) {
        if (edgeSet.get(from) == null) {
            return false;
        } else {
            return edgeSet.get(from).contains(to);
        }
    }

    @Override
    public String toString() {
        return "Graph {" + "nodes=" + nodeSet + ", edges=" + edgeSet + '}';
    }
}
