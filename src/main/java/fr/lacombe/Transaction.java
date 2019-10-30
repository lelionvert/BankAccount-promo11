package fr.lacombe;

import java.util.Objects;

class Transaction {
    private final Operation operation;
    private final int amount;
    private final String date;

    Transaction(Operation operation, int amount, String date) {
        this.operation = operation;
        this.amount = amount;
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return amount == that.amount &&
                operation == that.operation &&
                Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operation, amount, date);
    }
}
