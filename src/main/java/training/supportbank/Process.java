package training.supportbank;

public class Process {


    public void loadCSV(String path, Bank bank) {

        Account sender = new Account("Jon A");
        Account receiver = new Account("Sarah T");
        String note = "Pokemon Training";
        double amount = 7.8;
        String date = "01/01/2014";

      //  bank.createAccount(sender);
       // bank.createAccount(receiver);

        bank.addTransaction(sender, receiver, amount, note, date);
        bank.addTransaction(new Account("Uncle Ben"), new Account("Billy"), 15.99, "Something", "Yesterday");
        bank.addTransaction(new Account("Billy"), new Account("Uncle Ben"), 10d, "Something", "Yesterday");





    }


}
