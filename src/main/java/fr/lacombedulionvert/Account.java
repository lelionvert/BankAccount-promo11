package fr.lacombedulionvert;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private List<Transaction> transactions;
    private int balance;

    public Account() {
        transactions = new ArrayList<>();
        balance = 0;
    }

    public boolean checkAllIsFine() {
        return true;
    }

    public void add(Transaction transaction) {
        this.transactions.add(transaction);
    }

    public int getBalance() {
        for (Transaction transaction : transactions) {
            balance += transaction.getAmount();
        }
        return balance;
    }
}
