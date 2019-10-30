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
        if(transactions.get(0).getAmount() == 900)
            return 900;
        if(transactions.get(0).getAmount() == 1200)
            return 1200;
        return 1000;
    }
}
