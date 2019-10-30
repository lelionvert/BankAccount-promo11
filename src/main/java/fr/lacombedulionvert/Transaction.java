package fr.lacombedulionvert;

public class Transaction {
    private final String date;
    private final int amount;
    private final String type;

    private Transaction(String date, int amount, String type) {
        this.date = date;
        this.amount = amount;
        this.type = type;
    }

    public int getAmount() {
        return amount;
    }

    static Builder initialize() {
        return new Builder();
    }

    public static class Builder {
        private String date;
        private int amount;
        private String type;

        private Builder(){ }

        public Builder withDate(String date){
            this.date = date;
            return this;
        }

        public Builder withType(String type){
            this.type = type;
            return this;
        }

        public Builder withAmount(int amount){
            this.amount = amount;
            return this;
        }

        public Transaction build() {
            return new Transaction(date, amount, type);
        }
    }
}
