package model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

@Getter
@AllArgsConstructor
public class Precedence {
    private final Operation from;
    private final Operation to;

    @Override
    public String toString() {
        return "Precedence{" + from.getTransactionID() + " -> " + to.getTransactionID() + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Precedence that = (Precedence) o;
        return Objects.equals(from.getTransactionID(), that.from.getTransactionID())
                && Objects.equals(to.getTransactionID(), that.to.getTransactionID());
    }

    @Override
    public int hashCode() {
        return Objects.hash(from.getTransactionID(), to.getTransactionID());
    }
}
