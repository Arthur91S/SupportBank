package training.supportbank;

public class Transaction {

    private Account sender;
    private Account receiver;
    private String note;
    private double amount;
    private String date;

    public Transaction(Account sender, Account receiver, String note, double amount, String date) {
        this.sender = sender;
        this.receiver = receiver;
        this.note = note;
        this.amount = amount;
        this.date = date;
    }

    @Override
    public String toString() {
        return  "----------- Transaction  -------------" +
                "\n From: " + sender.getName() + "\n To: " + receiver.getName() + "\n Note: " + note+ "\n Amount $" +amount + "\n Date: " + date;
    }
}
