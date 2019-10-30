package fr.lacombe;

import java.util.Objects;

final class Transaction {
    private final Operation operation;
    private final int amount;
    private final String date;

    private Transaction(Operation operation, int amount, String date) {
        this.operation = operation;
        this.amount = amount;
        this.date = date;
    }

    static Builder aTransaction() {
        return new Builder();
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

    public static final class Builder {
        private Operation operation;
        private int amount;
        private String date;

        private Builder() {
        }

        Builder withOperation(Operation operation) {
            this.operation = operation;
            return this;
        }

        Builder withAmount(int amount) {
            this.amount = amount;
            return this;
        }

        Builder withDate(String date) {
            this.date = date;
            return this;
        }

        Transaction build() {
            return new Transaction(operation, amount, date);
        }
    }
}
