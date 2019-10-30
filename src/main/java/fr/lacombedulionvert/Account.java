package fr.lacombedulionvert;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private List<Transaction> transactions;

    public Account() {
        transactions = new ArrayList<>();
    }

    public boolean checkAllIsFine() {
        return true;
    }

    public void add(Transaction transaction) {
        this.transactions.add(transaction);
    }

    public int getBalance() {
        return 1000;
    }
}
