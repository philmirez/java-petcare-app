package app.utilities;
import app.objects.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Type;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;


import javax.swing.JOptionPane;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import app.objects.ChainOwner;

public class Utility {
    private static final String[] FIRST_NAME_MESSAGES = {"Please enter your first name.", "Please enter a valid name.", "Please enter a non-blank name."};
    private static final String[] LAST_NAME_MESSAGES = {"Please enter your last name.", "Please enter a valid name.", "Please enter a non-blank name."};
    private static final String[] EMAIL_MESSAGES = {};
    private static final String[] PHONE_NUMBER_MESSAGES = {};
    /**
     * A basic string input method that allows the user to enter input based on the prompt, passed in via
     * the 'messages' array. The first element of the 'messages' array is the initial prompt, the second
     * element is the exception prompt, and the subseuquent elements can be used (and this basic model
     * changed) to incorporate other error/invalid messages for input.
     */
    public static String getStringInput(String[] messages) {
        String input = "";
        do {
            try {
                input = JOptionPane.showInputDialog(messages[0]);
                if (isEmpty(input)) {
                    JOptionPane.showMessageDialog(null, messages[2]);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, messages[1]);
            }
        } while (isEmpty(input));
        return input;
    }
/*
    public static String getFirstName(FIRST_NAME_MESSAGES) {
        return getStringInput(FIRST_NAME_MESSAGES);
    }

    public static String getLastName(LAST_NAME_MESSAGES) {
        return getStringInput(LAST_NAME_MESSAGES);
    }
*/
    private static boolean isEmpty(String string) {
        if (string.equals("")) {
            return true;
        }
        return false;
    }
    
    public static ArrayList JSONreader(String JSON)
    {
		ArrayList existCOData = new ArrayList();
		
		Gson gson = new Gson();
		JsonParser jsonParser = new JsonParser();
		
		try {
	        BufferedReader br = new BufferedReader(new FileReader(JSON));
	        JsonElement jsonElement = jsonParser.parse(br);

	        
	        Type type = new TypeToken<List<ChainOwner>>() {}.getType();
	        
	        br.close();
	        return gson.fromJson(jsonElement, type);			
		}
		catch(Exception e)
		{
			Log.error("Couldn't read "+ JSON + " file found in the json directory. Exception " + e);
		}
		return existCOData;
    }
    
    public static void JSONwriter(ArrayList list, String JSON)
    {
    	//1. Convert object to JSON string
        Gson gson = new Gson();
        String json = gson.toJson(list);
        System.out.println(json);

        //2. Convert object to JSON string and save into a file directly
        try {
        FileWriter writer = new FileWriter(JSON);

            gson.toJson(list, writer);
            writer.close();

        } catch (Exception e) 
        {
            Log.error("Try writing to file: " + e);
        }
    		
    }

    public static HashMap<String, TransactionObject> convertTransactionCSVToHashMap(String filePath) {
        HashMap<String, TransactionObject> transactionObjectHashMap = new HashMap<String, TransactionObject>();
        BufferedReader bufferedReader = null;
        String line = "";
        String delimiter = ",";

        try {
            bufferedReader = new BufferedReader(new FileReader(filePath));
            while ((line = bufferedReader.readLine()) != null) {
                String[] transactionData = line.split(delimiter);
                if (!((transactionData[0].indexOf("t")) == 0)) {
                    String transactionID = transactionData[0];
                    int storeID = Integer.parseInt(transactionData[1]);
                    int memberID = Integer.parseInt(transactionData[2]);
                    double amountSpent = Double.parseDouble(transactionData[3]);
                    
                    TransactionObject t = new TransactionObject(transactionID, storeID, memberID, amountSpent);
                    transactionObjectHashMap.put(t.getTransactionID(), t);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error.");
        }
        return transactionObjectHashMap;
    }
}