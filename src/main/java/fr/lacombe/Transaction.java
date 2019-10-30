package fr.lacombe;

import java.time.LocalDate;
import java.util.Objects;

final class Transaction {
    private final Operation operation;
    private final int amount;
    private final LocalDate date;
    private int balance;

    private Transaction(Operation operation, int amount, LocalDate date, int balance) {
        this.operation = operation;
        this.amount = amount;
        this.date = date;
        this.balance = balance;
    }

    static Builder aTransaction() {
        return new Builder();
    }

    @Override
    public String toString() {
        return date + "\t | " + (operation == Operation.WITHDRAWAL ? "-" : "") +
                amount + " \t | " + balance + "\n";
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

    int getBalance() {
        return balance;
    }

    public static final class Builder {
        private Operation operation;
        private int amount;
        private LocalDate date;
        private int balance;

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

        Builder withDate(LocalDate date) {
            this.date = date;
            return this;
        }

        Builder withBalance(int balance) {
            this.balance = balance;
            return this;
        }

        Transaction build() {
            return new Transaction(operation, amount, date, balance);
        }
    }
}
