import graph.Graph;
import graph.Node;
import lombok.Getter;
import model.Operation;
import model.Precedence;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Getter
public class Algorithm {
    private final List<Operation> operationList;
    private final Graph precedenceGraph;
    private Set<Precedence> precedenceSet;

    public Algorithm(List<Operation> operationList) {
        this.operationList = operationList;
        precedenceGraph = new Graph();
        generatePriorityList();
        graphInit();
    }

    private void generatePriorityList() {
        precedenceSet = new HashSet<>();
        for (int i = 0; i < operationList.size() - 1; i++) {
            Operation from = operationList.get(i);
            for (int j = i + 1; j < operationList.size(); j++) {
                Operation to = operationList.get(j);
                if (from.getTransactionID() != to.getTransactionID() && from.getData().equals(to.getData())
                        && !from.equals(to)) {
                    if (from.getOperationType().getOp() == 'W' || to.getOperationType().getOp() == 'W') {
                        Precedence precedence = new Precedence(from, to);
                        precedenceSet.add(precedence);
                    }
                }
            }
        }
    }

    public ProcessResult getSerializabilityResult() {
        ProcessResult processResult = new ProcessResult();
        for (Map.Entry<Node, Set<Node>> entry : precedenceGraph.getEdgeSet().entrySet()) {
            for (Node destination : entry.getValue()) {
                Node source = entry.getKey();
                if (precedenceGraph.hasEdge(destination, source)) {
                    processResult.setConflictSerializable(false);
                    processResult.setNodes(new Node[]{source, destination});
                    return processResult;
                }
            }
        }
        return processResult;
    }

    private void graphInit() {
        for (Precedence precedence : precedenceSet) {
            Node source = new Node(String.valueOf(precedence.getFrom().getTransactionID()));
            Node destination = new Node(String.valueOf(precedence.getTo().getTransactionID()));
            precedenceGraph.addNode(source);
            precedenceGraph.addNode(destination);
            precedenceGraph.addEdge(source, destination);
        }
    }

}
