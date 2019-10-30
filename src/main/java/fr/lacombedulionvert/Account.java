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
        return true;
    }

    public void add(Transaction transaction) {
        currentBalance = transaction.add(currentBalance);
        this.transactions.add(transaction);
    }

    public int getBalance() {
        return transactions.get(transactions.size()-1).getBalance();
    }
}
