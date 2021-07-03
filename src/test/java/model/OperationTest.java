package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class OperationTest {

    private Operation operation;

    @BeforeEach
    void setUp() {
        operation = new Operation(2, OperationType.WRITE, "d");
    }

    @Test
    void getTransactionID() {
        assertEquals(2, operation.getTransactionID());
    }

    @Test
    void getType() {
        assertEquals(OperationType.WRITE, operation.getOperationType());
    }

    @Test
    void getData() {
        assertEquals("d", operation.getData());
    }

    @Test
    void testEquals() {
        Operation testOperation = new Operation(2, OperationType.WRITE, "d");
        assertEquals(testOperation, operation);
    }

    @Test
    void testNotEquals() {
        Operation testOperation = new Operation(2, OperationType.WRITE, "a");
        assertNotEquals(testOperation, operation);
    }

    @Test
    void testOperationType() {
        assertEquals(OperationType.class, operation.getOperationType().getClass());
    }
}