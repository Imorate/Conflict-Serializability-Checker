package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class PrecedenceTest {
    private Precedence precedence;

    @BeforeEach
    void setup() {
        Operation op1 = new Operation(1, OperationType.READ, "x");
        Operation op2 = new Operation(2, OperationType.WRITE, "y");
        precedence = new Precedence(op1, op2);
    }

    @Test
    void testEquals() {
        Operation op1 = new Operation(1, OperationType.READ, "x");
        Operation op2 = new Operation(2, OperationType.WRITE, "y");
        Precedence precedence = new Precedence(op1, op2);
        assertEquals(precedence,this.precedence);
    }

    @Test
    void testNotEquals() {
        Operation op1 = new Operation(1, OperationType.READ, "x");
        Operation op2 = new Operation(3, OperationType.WRITE, "y");
        Precedence precedence = new Precedence(op1, op2);
        assertNotEquals(precedence,this.precedence);
    }

}