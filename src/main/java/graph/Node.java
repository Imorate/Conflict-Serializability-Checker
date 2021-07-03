package graph;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Node {
    private String label;

    @Override
    public String toString() {
        return "Node(" + label + ')';
    }
}
