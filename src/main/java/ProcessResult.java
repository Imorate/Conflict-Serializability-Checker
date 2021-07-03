import graph.Node;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProcessResult {
    private boolean conflictSerializable = true;
    private Node[] nodes;

}
