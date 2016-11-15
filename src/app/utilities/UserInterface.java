package app.utilities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
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

public class UserInterface {

	private static final String[] reports = {"Store Performance", "Member Data"}; 
	/**
	 * Create a Chain Owner ArrayList
	 */
	ArrayList<ChainOwner> chainOwnerList = new ArrayList<ChainOwner>();
	
	public UserInterface(ArrayList<ChainOwner> chainOwnerList) {
		chainOwnerList.addAll(readExistingChainOwnerData());
		this.chainOwnerList.addAll(chainOwnerList);
	}

	/**
	 * 
	 * @param prt
	 * @param displayTypeFlag 0 - No Input Fields 1 - Two Input Fields
	 */
	public void prt(ArrayList<ChainOwner> chainOwnerList, String prt, int displayTypeFlag)
	{
		if(displayTypeFlag==0)
		{
			displayNoInputFieldsMessage(prt);
		}
		else if(displayTypeFlag==1)
		{
			displayTwoInputFieldsMessage(chainOwnerList, prt);
		}
	  
	}
	  
	/**
	* validates JOptionPane input
	* 
	* @param variableName
	* @param dataTypeFlag 0 - String type, 1 - int type, 2 - double type
	* @return
	*/
	private String validateJOptionPane(String variableName, int dataTypeFlag)
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
	
	public String displayDropDownStoreMessage(Object[] possibleValues)
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
	public void displayNoInputFieldsMessage(String message)
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
	
	/**
	 * 
	 * @param message
	 */
	public void displayTwoInputFieldsMessage(ArrayList<ChainOwner> chainOwnerList, String message)
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
		    
				String coUsername = chainOwnerList.get(i).getUsername();
				String coPassword = chainOwnerList.get(i).getPassword();
				
				if (username.getText().equals(coUsername) && password.getText().equals(coPassword)) {
			    
					System.out.println("Login successful");
					prt(chainOwnerList, "You are currently logged in as Chain Owner for Store X.", 0);
			        
			    } else {
			    	
			        System.out.println("Login failed");
			        prt(chainOwnerList, "Invalid Username/Password.", 0);
			        String optionChosen = validateJOptionPane("option", 1);
			        
			        if(optionChosen.equals("1"))
			        	prt(chainOwnerList, "Please enter your Username and Password to Log in.", 1);
			        else if(optionChosen.contentEquals("2"))
			        {
			        	prt(chainOwnerList, "Please enter your details on the following screens to sign up as a Chain Owner.", 0);
			        	Object[] possibleValues = { "Fairfax Store", "Centreville Store", "Sterling Store" };
			        	displayDropDownStoreMessage(possibleValues);
			        	validateJOptionPane("Username: ", 0);
			        	validateJOptionPane("Password: ", 0);
			        	prt(chainOwnerList, "Sign up was successful!", 0);
			        	prt(chainOwnerList, "Please enter your Username and Password to Log in.", 1);
			        }
			        
			    }
		} else {
		    
			System.out.println("Login cancelled.");
			
		}
	}
	
	public ChainOwner loginPage(ArrayList<ChainOwner> chainOwnerList)
	{
		prt(chainOwnerList, "Welcome to the Kroll Pet Care Admin Panel.", 0);
		
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

	/**
	 * Display Administration Menu
	 */
	private void displayAdministrationMenu() {
		// TODO Auto-generated method stub
		
	}
	
	public int reportsPage()
	{
		return 0;
	}
	
	public String tryAgainOrSignUpPage()
	{
		
		String optionChosen = validateJOptionPane("option", 1);
		return optionChosen;
	}
	
	public void signUpPage(ArrayList<ChainOwner> chainOwnerList)
	{
		prt(chainOwnerList, "Please enter your details on the following screens to sign up as a Chain Owner.", 0);
    	Object[] possibleValues = {"Fairfax Store", "Centreville Store", "Sterling Store"};
    	String storeCity = displayDropDownStoreMessage(possibleValues);
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
    	
    	//1. Convert object to JSON string
        Gson gson = new Gson();
        String json = gson.toJson(chainOwnerList);
        System.out.println(json);

        //2. Convert object to JSON string and save into a file directly
        try (FileWriter writer = new FileWriter("json/chainOwnerObjects.json")) {

            gson.toJson(chainOwnerList, writer);

        } catch (Exception e) {
            Log.error("Try writing to file: " + e);
        }
    	
    	prt(chainOwnerList, "Sign up was successful!", 0);
	}
	
	public void generatePerformanceReport()
	{
		
	}
	
	public void generateMemberReport()
	{
		
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
		 * Create a Chain Owner ArrayList
		 */
		ArrayList<ChainOwner> chainOwnerList = new ArrayList<ChainOwner>();
		
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
			prt(chainOwnerList, "You are currently logged in as " + chainOwner.getUsername() + " for Store " + chainOwner.getStoreCity(), 0);			
		}
		else
		{
			prt(chainOwnerList, "Invalid Username/Password.", 0);
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
		int reportType = 0;
		reportType = reportsPage();
		if(reportType==1)
			generatePerformanceReport();
		else if(reportType==2)
			generateMemberReport();
	}

	/**
	 * 
	 * @return
	 */
	private ArrayList<ChainOwner> readExistingChainOwnerData()
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
	

}
