package model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Operation {
    private final int transactionID;
    private final OperationType operationType;
    private final String data;

    @Override
    public String toString() {
        return "Operation{" +
                "TID=" + transactionID +
                ", type=" + operationType +
                ", data='" + data + '\'' +
                '}';
    }
}
