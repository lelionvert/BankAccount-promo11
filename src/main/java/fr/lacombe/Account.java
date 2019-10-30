package fr.lacombe;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static fr.lacombe.Transaction.aTransaction;

final class Account {
    private final List<Transaction> transactionsHistory;

    private Account() {
        this.transactionsHistory = new ArrayList<>();
    }

    static Account createAccount() {
        return new Account();
    }

    void deposit(int amount, LocalDate date) {
        transactionsHistory.add(aTransaction()
                .withOperation(Operation.DEPOSIT)
                .withAmount(amount)
                .withDate(date)
                .withBalance(currentBalance() + amount)
                .build());
    }

    private int currentBalance() {
        return transactionsHistory.isEmpty() ? 0 : transactionsHistory.get(transactionsHistory.size() - 1).getBalance();
    }

    void withdraw(int amount, LocalDate date) {
        transactionsHistory.add(aTransaction()
                .withOperation(Operation.WITHDRAWAL)
                .withAmount(amount)
                .withDate(date)
                .build());
    }

    boolean isNew() {
        return transactionsHistory.isEmpty();
    }

    boolean contains(Transaction transaction) {
        return transactionsHistory.contains(transaction);
    }

    String printStatement() {
        return transactionsHistory.stream().map(Transaction::toString).collect(Collectors.joining("", "DATE \t | AMOUNT \t | BALANCE \n", ""));
    }
}
