package fr.lacombe;

import java.util.ArrayList;
import java.util.List;

final class Account {
    private final List<Transaction> transactionsHistory;

    private Account() {
        this.transactionsHistory = new ArrayList<>();
    }

    static Account createAccount(){
        return new Account();
    }

    List getListTransaction() {
        return transactionsHistory;
    }

    void deposit(int amount, String date) {
        transactionsHistory.add(Transaction.aTransaction()
                .withOperation(Operation.DEPOSIT)
                .withAmount(amount)
                .withDate(date)
                .build());
    }
}
