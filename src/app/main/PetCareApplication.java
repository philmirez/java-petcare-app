package app.main;
import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

// Import Apache's log4j2 classes
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// Import Google's gson classes
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import app.objects.*;
import app.utilities.Log;


public class PetCareApplication {

	public static void main(String[] args) {	
		
		/**
		 * Create a Chain Owner ArrayList
		 */
		ArrayList<ChainOwner> chainOwnerList = new ArrayList<ChainOwner>();
		
		/**
		 * Read Existing Chain Owner Data from a File
		 * Add read data into Chain Owner List
		 */
		chainOwnerList.addAll(readExistingChainOwnerData());
		
		loginPage(chainOwnerList);
	}
	private static ArrayList<ChainOwner> readExistingChainOwnerData()
	{
		ArrayList<ChainOwner> existCOData = new ArrayList<ChainOwner>();
		
		Gson gson = new Gson();
		JsonParser jsonParser = new JsonParser();
		
		try {
	        BufferedReader br = new BufferedReader(new FileReader("json/chainOwnerObjects.json"));
	        JsonElement jsonElement = jsonParser.parse(br);

	        
	        Type type = new TypeToken<List<ChainOwner>>() {}.getType();
	        return gson.fromJson(jsonElement, type);			
		}
		catch(Exception e)
		{
			Log.error("Couldn't read chainOwnerObjects file found in the json directory. Exception " + e);
		}
		return existCOData;
	}
	private static void loginPage(ArrayList<ChainOwner> chainOwnerList)
	{
		prt(chainOwnerList, "Welcome to the Kroll Pet Care Admin Panel.", 0);
		prt(chainOwnerList, "Please enter your Username and Password to Log In.", 1);
		Object[] possibleValues = { "Performance Report", "Member Report" };
		displayDropDownStoreMessage(possibleValues);

		/**
		 * Create performance report object
		 */
		Report performance = new StorePerformanceReport();
		
		/**
		 * Create member report object
		 */
		// TODO Depends on MemberReport Class
		//Report member = new MemberReport();
		
		/**
		 * Display Administration Menu
		 */
		displayAdministrationMenu();
		
		/**
		 * Generate performance report
		 */
		performance.generateReport();
		
		/**
		 * Generate member report
		 */
		// TODO Depends on MemberReport Class
		//member.generateReport();

	}

	/**
	 * Display Administration Menu
	 */
	private static void displayAdministrationMenu() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 
	 * @param prt
	 * @param displayTypeFlag 0 - No Input Fields 1 - Two Input Fields
	 */
	private static void prt(ArrayList<ChainOwner> chainOwnerList, String prt, int displayTypeFlag)
	{
		if(displayTypeFlag==0)
		{
			displayNoIFMessage(prt);
		}
		else if(displayTypeFlag==1)
		{
			displayTwoIFMessage(chainOwnerList, prt);
		}
	  
	}
	  
	/**
	* validates JOptionPane input
	* 
	* @param variableName
	* @param dataTypeFlag 0 - String type, 1 - int type, 2 - double type
	* @return
	*/
	private static String validateJOptionPane(String variableName, int dataTypeFlag)
	{
	    int variableFlag = 1;
	    String stringToBeObtained = "";
	
	while(variableFlag==1)
	{
	    try
	    {
	        if(variableName.equals("option"))
	        {
	            stringToBeObtained = JOptionPane.showInputDialog( 
	                    null, 
	                    "Please choose your position:\n"
	                            + "1. Try Again\n"
	                            + "2. Sign Up\n", 
	                    "Pet Care App",
	                    JOptionPane.QUESTION_MESSAGE
	                    );
	        }
	        else
	        {
	            stringToBeObtained = JOptionPane.showInputDialog( 
	                    null, 
	                    "Please enter your " + variableName + ":\n",
	                    "Pet Care App",
	                    JOptionPane.QUESTION_MESSAGE
	                    );
	        }
	        
	        if(!stringToBeObtained.isEmpty() && stringToBeObtained!=null)
	        {
	            if(dataTypeFlag==1)
	            {
	                int intToBeObtained = Integer.parseInt(stringToBeObtained);
	                stringToBeObtained = String.valueOf(intToBeObtained); 
	            }
	            else if(dataTypeFlag==2)
	            {
	                double doubleToBeObtained = Double.parseDouble(stringToBeObtained);
	                stringToBeObtained = String.valueOf(doubleToBeObtained);
	            }
	            variableFlag=0;
	        }
	        else
	            JOptionPane.showMessageDialog( 
	                    null, 
	                    "Sorry! The " + variableName +" was invalid. Please enter it again.\n",
	                    "Pet Care App",
	                    JOptionPane.ERROR_MESSAGE
	                );
	        
	    }
	    catch(NumberFormatException e)
	    {
	        JOptionPane.showMessageDialog( 
	                null, 
	                "Sorry! Numeric values only.\n",
	                "Pet Care App",
	                    JOptionPane.ERROR_MESSAGE
	            );
	        }
	    }
	    
	    return stringToBeObtained;
	}
	
	public static String displayDropDownStoreMessage(Object[] possibleValues)
	{
		String selectedValue = (String) JOptionPane.showInputDialog(null,    
		            "Choose one", "Input",   
		            JOptionPane.INFORMATION_MESSAGE, null,
		            possibleValues, possibleValues[0]);
		return selectedValue;
	}
	/**
	 * 
	 * @param message
	 */
	public static void displayNoIFMessage(String message)
	{
	    JOptionPane.showMessageDialog(null, 
	            message,
	            "Pet Care App",
	            JOptionPane.INFORMATION_MESSAGE);
	}
	
	/**
	 * 
	 * @param message
	 */
	public static void displayTwoIFMessage(ArrayList<ChainOwner> chainOwnerList, String message)
	{
		JTextField username = new JTextField();
		JTextField password = new JPasswordField();
		Object[] field = {
		    "Username:", username,
		    "Password:", password
		};

		int option = JOptionPane.showConfirmDialog(null, field, message, JOptionPane.OK_CANCEL_OPTION);
		int size = chainOwnerList.size();
		int i = 0;
		if (option == JOptionPane.OK_OPTION) {
		    
			while(i<size)
			{
				String coUsername = chainOwnerList.get(i).getUsername();
				String coPassword = chainOwnerList.get(i).getPassword();
				
				if (username.getText().equals(coUsername) && password.getText().equals(coPassword)) {
			    
					System.out.println("Login successful");
					prt(chainOwnerList, "You are currently logged in as Chain Owner for Store X.", 0);
			        
			    } else {
			    	
			        System.out.println("login failed");
			        prt(chainOwnerList, "Invalid Username/Password.", 0);
			        String optionChosen = validateJOptionPane("option", 1);
			        
			        if(optionChosen.equals("1"))
			        	prt(chainOwnerList, "Please enter your Username and Password to Log In.", 1);
			        else if(optionChosen.contentEquals("2"))
			        {
			        	prt(chainOwnerList, "Please enter your details on the following screens to sign up as a Chain Owner.", 0);
			        	Object[] possibleValues = { "Fairfax Store", "Centreville Store", "Sterling Store" };
			        	displayDropDownStoreMessage(possibleValues);
			        	displayOneIFMessage("Username: ");
			        	displayOneIFMessage("Password: ");
			        	prt(chainOwnerList, "Sign up was successful!", 0);
			        	prt(chainOwnerList, "Please enter your Username and Password to Log In.", 1);
			        }
			        
			    }
				i++;
			}
			
		} else {
		    
			System.out.println("Login canceled");
			
		}
	}

	/**
	 * 
	 * @param message
	 */
	public static String displayOneIFMessage(String message)
	{
		JTextField username = new JTextField();

		Object[] field = {
			    message, username
			};

		int option = JOptionPane.showConfirmDialog(null, field, message, JOptionPane.OK_CANCEL_OPTION);
		
		if (option == JOptionPane.OK_OPTION) {
		    
			return username.getText();
			
		} else {
		    
			System.out.println("Login canceled");
			return "canceled";
		}
	}
	
}
