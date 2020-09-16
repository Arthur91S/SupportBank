package training.supportbank;

import java.math.BigDecimal;

public class Transaction {

    private Account sender;
    private Account receiver;
    private String note;
    private BigDecimal amount;
    private String date;

    public Transaction(Account sender, Account receiver, String note, BigDecimal amount, String date) {
        this.sender = sender;
        this.receiver = receiver;
        this.note = note;
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
        return sender;
    }

    public Account getReceiver() {
        return receiver;
    }

    @Override
    public String toString() {
        return  "----------- Transaction  -------------" +
                "\n From: " + sender.getName() + "\n To: " + receiver.getName() + "\n Note: " + note+ "\n Amount $" +amount + "\n Date: " + date;
    }
}
