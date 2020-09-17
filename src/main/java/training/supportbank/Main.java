package training.supportbank;

import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Main {

    private static final Logger LOGGER = LogManager.getLogger();

    public static void main(String args[]) {

        LOGGER.error("Hello testing");

        Scanner scan = new Scanner(System.in);
        int option = 0;
        boolean quit = false;

        Bank bank = new Bank();
        Process process = new Process();
        //process.loadCSV(bank, "Transactions2014.csv");
        process.loadCSV(bank, "Transactions2014.csv");

        while (!quit){
            System.out.println(" \n Welcome to the Bank \n" +
                    "1: List All (UserAccounts) \n"+
                    "2: List UserTransactions \n" +
                    "3: Quit \n");

            if (scan.hasNextInt()){
                option = scan.nextInt();
            }
            scan.nextLine();
            switch (option) {
                case 1:
                    bank.getBalance();
                    break;
                case 2:
                    System.out.println("Enter account name");
                    String accountName = scan.nextLine();
                    bank.getTransactions(accountName);
                    break;
                case 3:
                    System.out.println("Thank you, goodbye :)");
                    quit = true;
                    break;
                default:
                    System.out.println("!! Please type a number :)" );
                    break;
            }
        }
    }
}
