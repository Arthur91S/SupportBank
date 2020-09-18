package training.supportbank;

import java.math.BigDecimal;

public class Transaction {

    private String date;
    private Account fromAccount;
    private Account toAccount;
    private String narrative;
    private BigDecimal amount;

    public Transaction(String date, Account fromAccount, Account toAccount, String narrative, BigDecimal amount) {
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.narrative = narrative;
        this.amount = amount;
        this.date = date;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getDate() {
        return date;
    }

    public Account getSender() {
        return fromAccount;
    }

    public Account getReceiver() {
        return toAccount;
    }

    @Override
    public String toString() {
        return  "----------- Transaction  -------------" +
                "\n From: " + fromAccount.getName() + "\n To: " + toAccount.getName() + "\n Note: " + narrative + "\n Amount $" +amount + "\n Date: " + date;
    }
}
