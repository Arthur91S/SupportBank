package training.supportbank;

import java.io.*;
import java.math.BigDecimal;
import java.math.MathContext;

import com.google.gson.Gson;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Process {
    private static final Logger LOGGER = LogManager.getLogger();

    public void loadCSV(Bank bank, String filename) {

        String newPath = "/Users/astulpe/IdeaProjects/SupportBank/files/" + filename;

        String line = "";
        String splitBy = ",";
        try
        {
            //parsing a CSV file into BufferedReader class constructor
            BufferedReader br = new BufferedReader(new FileReader(newPath));

            LOGGER.error(" --- Before looping ---");
            int i = 0;

            br.readLine(); // skips first line

            while ((line = br.readLine()) != null )
            {
                i++;
                LOGGER.error("Inside loop "+ i + " start");
                String[] transaction = line.split(splitBy);    // use comma as separator
                 //            0   1   2   3        4
                // csv order Date,From,To,Narrative,Amount

                String sender = transaction[1];
                String receiver = transaction[2];
                String note = transaction[3];
                MathContext mc = new MathContext(4);
                BigDecimal amount = new BigDecimal(transaction[4], mc);
                String date = transaction[0];

                bank.addTransaction(sender,receiver,note, amount, date);
                LOGGER.error("Inside loop "+ i + " end");

            }
        }
        catch (IOException e)
        {
            System.out.println("Whoops, could not read the CSV file");
            e.printStackTrace();
        }
        LOGGER.error("--- After looping ---");

    }

    public void loadJSON(Bank bank, String filename) {

        String newPath = "/Users/astulpe/IdeaProjects/SupportBank/files/" + filename;

        try {
            Gson gson = new Gson();
            // 1. JSON file to Java object
            Object object = gson.fromJson(new FileReader(newPath), Object.class);

        }

        catch (IOException e)
        {
            e.printStackTrace();
        }




    }


}
