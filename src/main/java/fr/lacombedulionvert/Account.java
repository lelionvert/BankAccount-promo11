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
        int sum = 0;
        for (Transaction transaction : transactions) {
            sum += transaction.getAmount();
        }
        return sum;
    }
}
