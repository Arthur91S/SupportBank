package training.supportbank;

public class Main {
    public static void main(String args[]) {
        // Your code here!
        System.out.println("Test!");

        Bank bank = new Bank();
        Process process = new Process();
        process.loadCSV("Path here", bank);

        bank.getTransactions();

        System.out.println("Welcome to the Bank \n" +
                "1: List All (UserAccounts) \n"+
                "2: List UserTransactions ");
                // Please enter account name

        // Bank class
            // done-- ArrayList<Transaction> transactions = new ArrayList<Transaction>;
            // done-- ArrayList<UserAccount>  userAccounts = new ArrayList<UserAccount>;

            // done addTransaction(From, to, amount, note, date)
            // getTransactions(Account account);

            // findAccount(String name) - returns userAccount object;
            // createAccount(String name)
            // getBalance(Account account)

        // Account class
            // done -- name
            // done Account(String name);  // constructor
            // done getName();

        // Transaction class ?
            // done-- sender
            // done  -- receiver
            // done -- note
            // done -- amount
            // done-- date

        //  Process
            // loadCSV(String path, Bank bank);
                // loop over each name and add transactions
            // loadJSON()
    }
}
