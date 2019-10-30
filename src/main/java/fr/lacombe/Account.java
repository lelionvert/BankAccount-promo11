package fr.lacombe;

import java.util.ArrayList;
import java.util.List;

class Account {
    private List<Transaction> transactionsHistory;

    Account() {
        this.transactionsHistory = new ArrayList<>();
    }

    List getListTransaction() {
        return transactionsHistory;
    }

    void deposit(int amount, String date) {
        transactionsHistory.add(new Transaction(Operation.DEPOSIT, amount, date));
    }
}
