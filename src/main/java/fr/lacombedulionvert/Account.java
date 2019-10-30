package fr.lacombedulionvert;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private List<Transaction> transactions;
    private int currentBalance;

    public Account() {
        transactions = new ArrayList<>();
        currentBalance = 0;
    }

    public boolean checkAllIsFine() {
        return transactions.size() == 0 && currentBalance == 0;
    }

    public void addTransaction(Transaction transaction) {
        currentBalance = transaction.sum(currentBalance);
        this.transactions.add(transaction);
    }

    public int getBalance() {
        return currentBalance;
    }

}
