package fr.lacombedulionvert;

public class Transaction {
    private final String date;
    private final int amount;
    private final String type;

    public Transaction(String date, int amount, String type) {
        this.date = date;
        this.amount = amount;
        this.type = type;
    }
}
