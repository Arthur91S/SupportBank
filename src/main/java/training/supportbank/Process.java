package training.supportbank;

import java.io.*;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;

import com.google.gson.Gson;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.internal.LinkedTreeMap;
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

            br.readLine(); // skips first line

            int i = 0;
            while ((line = br.readLine()) != null )
            {
                String[] transaction = line.split(splitBy);    // use comma as separator

                try {
                    String sender = transaction[1];
                    String receiver = transaction[2];
                    String note = transaction[3];
                    MathContext mc = new MathContext(4);
                    BigDecimal amount = new BigDecimal(transaction[4], mc);
                    String date = transaction[0];

                    bank.addTransaction(sender,receiver,note, amount, date);
                } catch (Exception e){
                    LOGGER.error("File: " + filename + " skipped transaction " + i);
                }
                i++;
            }
        }
        catch (IOException e)
        {
            System.out.println("Whoops, could not read the CSV file");
            e.printStackTrace();
        }
    }

    public void loadJSON(Bank bank, String filename) {

        String newPath = "/Users/astulpe/IdeaProjects/SupportBank/files/" + filename;

        try {
            Gson gson = new Gson();

            // 1. JSON file to Java object
            Object object = gson.fromJson(new FileReader(newPath), Object.class);
            ArrayList objects = (ArrayList) object;

            for ( int i = 0; i < objects.size(); i++) {
                LinkedTreeMap transaction = (LinkedTreeMap) objects.get(i);

               try {
                   String sender = (String)transaction.get("fromAccount");
                   String receiver = (String)transaction.get("toAccount");
                   String note = (String)transaction.get("narrative");
                   MathContext mc = new MathContext(4);
                   BigDecimal amount = new BigDecimal((Double)transaction.get("amount"), mc);
                   String date = (String)transaction.get("date");
                   bank.addTransaction(sender,receiver,note, amount, date);
               } catch (Exception e){
                   LOGGER.error("Skiped line " + i);
                   continue;
               }
            }
        }

        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
