package training.supportbank;

import java.util.ArrayList;

public class Bank {

    private ArrayList<Transaction> transactions;
    private ArrayList<Account> accounts;

    public Bank(){
        this.transactions = new ArrayList<>();
        this.accounts = new ArrayList<>();
    }

    public void addTransaction(Account sender, Account receiver, Double amount, String note, String date) {
        Transaction transaction = new Transaction(sender,receiver,note,amount,date);
        this.transactions.add(transaction);
    }

    public boolean addAccount(String name){
        if ( findAccount(name) != null){
            this.accounts.add(new Account(name));
            return true;
        }
        return false;
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
        int size = transactions.size();
        for (int i = 0; i < size; i++){
            System.out.println(transactions.get(i).toString());
        }
    }

    public void getTransactions()

}
