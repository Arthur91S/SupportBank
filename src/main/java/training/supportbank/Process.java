package training.supportbank;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.MathContext;

public class Process {


    public void loadCSV(Bank bank, String filename) {

        String newPath = "/Users/astulpe/IdeaProjects/SupportBank/files/" + filename;

        String line = "";
        String splitBy = ",";
        boolean first = false;
        try
        {
            //parsing a CSV file into BufferedReader class constructor
            BufferedReader br = new BufferedReader(new FileReader(newPath));

            while ((line = br.readLine()) != null )   //returns a Boolean value
            {
                if (first == false){
                    first = true;
                    continue;
                }
                String[] transaction = line.split(splitBy);    // use comma as separator
                 //            0   1   2   3        4
                // csv order Date,From,To,Narrative,Amount

                String sender = transaction[1];
                String receiver = transaction[2];
                String note = transaction[3];
                MathContext mc = new MathContext(4);
                BigDecimal amount = new BigDecimal(15.55, mc);
                String date = transaction[0];

                bank.addTransaction(sender,receiver,note, amount, date);

            }
        }
        catch (IOException e)
        {
            System.out.println("Whoops, could not read the CSV file");
            e.printStackTrace();
        }

    }


}
