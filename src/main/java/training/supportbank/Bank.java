package training.supportbank;

import java.math.BigDecimal;
import java.sql.SQLOutput;
import java.util.ArrayList;

public class Bank {

    private ArrayList<Transaction> transactions;
    private ArrayList<Account> accounts;

    public Bank(){
        this.transactions = new ArrayList<>();
        this.accounts = new ArrayList<>();
    }

    public void addTransaction(String senderName, String receiverName, String note , BigDecimal amount, String date) {
        // check if sender and receiver accounts exist if not create
        Account sender = findAccount(senderName);
        if (sender == null){
            sender = addAccount(senderName);
        }

        Account receiver = findAccount(receiverName);
        if (receiver == null){
            receiver = addAccount(receiverName);
        }

        Transaction transaction = new Transaction(date, sender,receiver,note,amount);
        this.transactions.add(transaction);
    }

    public Account addAccount(String name){
        Account existingAccount = findAccount(name);
        if (existingAccount != null){
            return existingAccount;
        }
         else {
            Account newAccount = new Account(name);
            this.accounts.add(newAccount);
            return newAccount;
        }
    }

    public Account findAccount(String name) {
        for (int i = 0; i < accounts.size(); i++){
            if (this.accounts.get(i).getName().equals(name)) {
                return accounts.get(i);
            }
        }
        return null;
    }

    public void getTransactions(){
        for (int i = 0; i < transactions.size(); i++){
            System.out.println(transactions.get(i).toString());
        }
    }

    public void getBalance(){
        // show balance for all people
        // loop through accounts and get balance for each account.
        for (int i = 0; i < accounts.size(); i++){
            System.out.println(" Account: "  +accounts.get(i).getName() + " Balance: " + getBalance(accounts.get(i).getName()));
        }
    }

    public BigDecimal getBalance(String name) {
        BigDecimal balance = new BigDecimal(0);
            for (int i = 0; i < transactions.size(); i++){
                Transaction currentTransaction = transactions.get(i);

                if (currentTransaction.getReceiver().getName().equals(name) ){
                    balance = balance.add(currentTransaction.getAmount());
                }
                if (currentTransaction.getSender().getName().equals(name) ){
                    balance = balance.subtract(currentTransaction.getAmount());
                }
            }
        return balance;
    }

    public void getTransactions(String name){
        // list all transactions for the account
        System.out.println("Showing transactions for " + name);
        for (int i = 0; i < transactions.size(); i++){
            Transaction currentTransaction = transactions.get(i);
            if (currentTransaction.getReceiver().getName().equals(name) || currentTransaction.getSender().getName().equals(name) ){
                System.out.println("test");
                System.out.println(transactions.get(i).toString());
            }
        }

    }

}
