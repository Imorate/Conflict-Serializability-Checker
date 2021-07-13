import file.FileParser;
import file.exceptions.FileNotFoundException;
import model.Operation;
import model.Precedence;

import java.io.IOException;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        FileParser fileParser = null;
        try {
            fileParser = new FileParser();
        } catch (FileNotFoundException | IOException e) {
            System.err.println(e.getMessage());
        }
        assert fileParser != null;
        List<Operation> operationList = fileParser.getOperationList();
        Algorithm algorithm = new Algorithm(operationList);
        Set<Precedence> precedenceSet = algorithm.getPrecedenceSet();
        System.out.println("Operation List=\t" + algorithm.getOperationList());
        System.out.println("Precedence Set=\t" + algorithm.getPrecedenceSet());
        System.out.println("Precedence Graph=\t" + algorithm.getPrecedenceGraph());
        System.out.println("\n");
        ProcessResult processResult = algorithm.getSerializabilityResult();
        if (processResult.isConflictSerializable()) {
            System.out.println("Transactions are Conflict-Serializable and also View-Serializable.");
            for (Precedence precedence : precedenceSet) {
                System.out.println(precedence);
            }
        } else {
            System.out.println("Transactions are not conflict serializable.");
            System.out.println("There is an edge between T" + processResult.getNodes()[0].getLabel() + " and T"
                    + processResult.getNodes()[1].getLabel() + " transactions.");
        }

    }
}
