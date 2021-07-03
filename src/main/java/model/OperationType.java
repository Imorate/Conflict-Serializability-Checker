package model;

public enum OperationType {
    READ('R'),
    WRITE('W');

    private final char op;

    OperationType(char operation) {
        this.op = operation;
    }

    public char getOp() {
        return op;
    }
}
