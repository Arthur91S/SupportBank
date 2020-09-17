package training.supportbank;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.math.BigDecimal;
import java.math.MathContext;
import java.time.LocalDate;

import com.google.gson.JsonDeserializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Process {
    private static final Logger LOGGER = LogManager.getLogger();

    public void loadCSV(Bank bank, String filename) {

        String newPath = "/Users/astulpe/IdeaProjects/SupportBank/files/" + filename;

        String line = "";
        String splitBy = ",";
        boolean first = false;
        try
        {
            //parsing a CSV file into BufferedReader class constructor
            BufferedReader br = new BufferedReader(new FileReader(newPath));

            LOGGER.error("Before looping");

            while ((line = br.readLine()) != null )   //returns a Boolean value
            {
                LOGGER.error("looping");

                if (!first){ first = true; continue; }
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
            }
        }
        catch (IOException e)
        {
            System.out.println("Whoops, could not read the CSV file");
            e.printStackTrace();
        }
        LOGGER.error("After looping");

    }

    public void loadJSON(Bank bank, String filename) {

        String newPath = "/Users/astulpe/IdeaProjects/SupportBank/files/" + filename;
        Gson gson = new Gson();

        try (Reader reader = new FileReader(newPath)) {

            // Convert JSON File to Java Object
            Transaction transaction = gson.fromJson(reader, Transaction.class);
            System.out.println(transaction.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
