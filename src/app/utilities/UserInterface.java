package app.utilities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import app.objects.ChainOwner;
import app.objects.Report;
import app.objects.StorePerformanceReport;
import app.objects.TransactionObject;

public class UserInterface {

	public static final String[] reports = {"Store Performance", "Member Data"}; 
	/**
	 * Create a Chain Owner ArrayList
	 */
	ArrayList<ChainOwner> chainOwnerList = new ArrayList<ChainOwner>();
	ArrayList<ChainOwner> memberList = new ArrayList<ChainOwner>();
	ArrayList<ChainOwner> storeList = new ArrayList<ChainOwner>();
	
	public UserInterface() {
		//ArrayList<ChainOwner> chain= new ArrayList<ChainOwner>();
		this.chainOwnerList.addAll(Utility.JSONreader("json/chainOwnerObjects.json"));
		this.memberList.addAll(Utility.JSONreader("json/memberObjects.json"));
		this.storeList.addAll(Utility.JSONreader("json/storeObjects.json"));
		System.out.println("Size: " + this.chainOwnerList.size());
	}
	  
	/**
	* validates JOptionPane input
	* 
	* @param variableName
	* @param dataTypeFlag 0 - String type, 1 - int type, 2 - double type
	* @return
	*/
	public String validateJOptionPane(String variableName, int dataTypeFlag)
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
	                    "Please choose from the menu below:\n"
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
	                    "Sorry! The " + variableName + " was invalid. Please enter it again.\n",
	                    "Pet Care App",
	                    JOptionPane.ERROR_MESSAGE
	                );
	        
	    }
	    catch(NumberFormatException e)
	    {
	        JOptionPane.showMessageDialog( 
	                null, 
	                "Sorry! You must enter a numeric value.\n",
	                "Pet Care App",
	                    JOptionPane.ERROR_MESSAGE
	            );
	        }
	    }
	    
	    return stringToBeObtained;
	}
	
	public String selectDropDown(Object[] possibleValues)
	{
		String selectedValue = (String) JOptionPane.showInputDialog(null,    
		            "Choose one", "Input",   
		            JOptionPane.INFORMATION_MESSAGE, null,
		            possibleValues,possibleValues[0]);
		return selectedValue;
	}
	
	/**
	 * 
	 * @param message
	 */
	public void alert(String message)
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
	public String displayOneInputFieldMessage(String message)
	{
		JTextField username = new JTextField();

		Object[] field = {
			    message, username
			};

		int option = JOptionPane.showConfirmDialog(null, field, message, JOptionPane.OK_CANCEL_OPTION);
		
		if (option == JOptionPane.OK_OPTION) {
		    
			return username.getText();
			
		} else {
		    
			System.out.println("Login cancelled.");
			return "Cancelled";
		}
	}
	
	public ChainOwner loginPage(ArrayList<ChainOwner> chainOwnerList)
	{
		alert("Welcome to the Kroll Pet Care Admin Panel.");
		
		String message = "Please enter your Username and Password to Log in.";
		
		JTextField username = new JTextField();
		JTextField password = new JPasswordField();
		Object[] field = {
		    "Username:", username,
		    "Password:", password
		};

		int option = JOptionPane.showConfirmDialog(null, field, message, JOptionPane.OK_CANCEL_OPTION);

		int i = 0;
		int coSize = chainOwnerList.size();
		
		if (option == JOptionPane.OK_OPTION) {
			while(i<coSize)
			{
				String coUsername = chainOwnerList.get(i).getUsername();
				String coPassword = chainOwnerList.get(i).getPassword();
				
				if (username.getText().equals(coUsername) && password.getText().equals(coPassword)) 
				{
			    
					System.out.println("Login successful: " + chainOwnerList.get(i));
					chainOwnerList.get(i).setLoginStatus(true);
					return chainOwnerList.get(i);
			    } 
				i++;
			}
			System.out.println("Login failed.");
			return chainOwnerList.get(0);
	        
	        
		} else {
		    
			System.out.println("Login cancelled.");
			return chainOwnerList.get(0);
			
		}
		/**
		 * TODO Create Possible values as constants
		 */
		//Object[] possibleValues = { "Performance Report", "Member Report" };
		//displayDropDownStoreMessage(possibleValues);

	}

	public String tryAgainOrSignUpPage()
	{
		
		String optionChosen = validateJOptionPane("option", 1);
		return optionChosen;
	}
	
	public void signUpPage(ArrayList<ChainOwner> chainOwnerList)
	{/*
		JTextField field1 = new JTextField();
		JTextField field2 = new JTextField();
		JTextField field3 = new JTextField();
		JTextField field4 = new JTextField();
		JTextField field5 = new JTextField();
		JTextField field6 = new JTextField();
		Object[] message = {
		    "Store city:", field1,
		    "Username:", field2,
		    "Password:", field3,
		    "E-mail:", field4,
		    "First name:", field5,
		    "Last name:", field6
		};
		int option = JOptionPane.showConfirmDialog(parent, message, "Enter all your values", JOptionPane.OK_CANCEL_OPTION);
		if (option == JOptionPane.OK_OPTION)
		{
		    String value1 = field1.getText();
		    String value2 = field2.getText();
		    String value3 = field3.getText();
		    String value4 = field4.getText();
		    String value5 = field5.getText();
		    String value6 = field5.getText();
		}*/
		alert("Please enter your details on the following screens to sign up as a Chain Owner.");
    	Object[] possibleValues = {"Fairfax Store", "Centreville Store", "Sterling Store"};
    	String storeCity = selectDropDown(possibleValues);
    	String username = validateJOptionPane("Username: ", 0);
    	String password = validateJOptionPane("Password: ", 0);
    	String email = validateJOptionPane("email: ", 0);
    	String firstName = validateJOptionPane("first name: ", 0);
    	String lastName = validateJOptionPane("last name: ", 0);
    	List<Object> list = Arrays.asList(possibleValues);
    	int storeID = list.indexOf(storeCity);
    	int userID = chainOwnerList.size() + 1;
    	System.out.println("firstName: " + firstName + "\nlastName: " + lastName + "\nstoreCity: " + storeCity + "\nstoreID: " + storeID);
    	
    	ChainOwner newSignUp = new ChainOwner();
    	newSignUp.setStoreCity(storeCity);
    	newSignUp.setUsername(username);
    	newSignUp.setPassword(password);
    	newSignUp.setEmail(email);
    	newSignUp.setFirstName(firstName);
    	newSignUp.setLastName(lastName);
    	newSignUp.setStoreID(storeID);
    	newSignUp.setUserID(userID);
    	
    	chainOwnerList.add(newSignUp);
    	
    	Utility.JSONwriter(chainOwnerList, "json/chainOwnerObjects.json");

        alert("Sign up was successful!");
	}
	
	public void generatePerformanceReport(HashMap<String, TransactionObject> memberTransactions)
	{
		alert("Generating Performance Reports \n" + memberTransactions.get("FF283066"));
		
	}
	
	public void generateMemberReport(HashMap<String, TransactionObject> memberTransactions)
	{
		alert("Generating Member Reports \n" + memberTransactions.get("FF283066"));
		
	}
	
	public void loginProcess()
	{	
		ChainOwner chainOwner = new ChainOwner();
		
		/**
		 * tryAgainOrSignUpResponse
		 * -------------------------
		 *  0 = Default Assigned Value
		 *  1 = Try Again
		 *  2 = Sign Up
		 */
		String tryAgainOrSignUpResponse = "";
		
		/**
		 * login status
		 */
		boolean success = false;
		
		/**
		 * Read Existing Chain Owner Data from a File
		 * Add read data into Chain Owner List
		 
		chainOwnerList.addAll(readExistingChainOwnerData());
		appUI = new UserInterface(chainOwnerList);
		*/
		/**
		 * Return chainOwner and log in status
		 */
		chainOwner = loginPage(chainOwnerList);
		
		success = chainOwner.getLoginStatus();
		
		if(success == true)
		{
			alert("You are currently logged in as " + chainOwner.getUsername() + " for Store " + chainOwner.getStoreCity());			
		}
		else
		{
			alert("Invalid Username/Password.");
			tryAgainOrSignUpResponse = tryAgainOrSignUpPage();
	        
	        if(tryAgainOrSignUpResponse.equals("1"))
	        	loginProcess();
	        else if(tryAgainOrSignUpResponse.contentEquals("2"))
	        {
	        	signUpPage(chainOwnerList);
	        	loginProcess();
	        }
		}
	
	}
		
	public void reportProcess() 
	{
		/**
		 * reportType
		 * -----------
		 *  0 = No Report
		 *  1 = Performance Report
		 *  2 = Member Report
		 */
		Object[] possibleValues = {"Store Performance Reports", "Member Reports"};
		String reportType = selectDropDown(possibleValues);
		
		HashMap<String, TransactionObject> memberTransactions = Utility.convertTransactionCSVToHashMap("csv/member_transactions.csv");
		
		if(reportType.equals("Store Performance Reports"))
			generatePerformanceReport(memberTransactions);
		else if(reportType.equals("Member Reports"))
			generateMemberReport(memberTransactions);
	}	

}
