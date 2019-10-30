package fr.lacombe;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static fr.lacombe.Transaction.*;

final class Account {
    private final List<Transaction> transactionsHistory;

    private Account() {
        this.transactionsHistory = new ArrayList<>();
    }

    static Account createAccount(){
        return new Account();
    }

    void deposit(int amount, LocalDate date) {
        transactionsHistory.add(aTransaction()
                .withOperation(Operation.DEPOSIT)
                .withAmount(amount)
                .withDate(date)
                .build());
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
}
