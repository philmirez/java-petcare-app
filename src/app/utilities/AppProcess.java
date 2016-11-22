package app.utilities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import app.objects.ChainOwner;
import app.objects.MemberReport;
import app.objects.StorePerformanceReport;
import app.objects.TransactionObject;

public class AppProcess {

	UserInterface appUI;
	
	public AppProcess() {
		appUI = new UserInterface();
	}
	
	public void readDataProcess()
	{
		
	}
	
	public void loginProcess()
	{
		ArrayList<ChainOwner> chainOwnerList = new ArrayList<ChainOwner>();
		chainOwnerList.addAll(Utility.JSONreader("json/chainOwnerObjects.json"));
		
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
		chainOwner = appUI.loginPage(chainOwnerList);
		
		success = chainOwner.getLoginStatus();
		
		if(success == true)
		{
			appUI.alert("You are currently logged in as " + chainOwner.getUsername() + " for Store " + chainOwner.getStoreCity());			
		}
		else
		{
			appUI.alert("Invalid Username/Password.");
			tryAgainOrSignUpResponse = appUI.tryAgainOrSignUpPage();
	        
	        if(tryAgainOrSignUpResponse.equals("1"))
	        	loginProcess();
	        else if(tryAgainOrSignUpResponse.contentEquals("2"))
	        {
	        	signUpProcess(chainOwnerList);
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
		String reportType = appUI.selectDropDown(possibleValues);
		
		HashMap<String, TransactionObject> memberTransactions = Utility.convertTransactionCSVToHashMap("csv/member_transactions.csv");
		
		if(reportType.equals("Store Performance Reports"))
		{
			StorePerformanceReport storePerformance = new StorePerformanceReport();
			storePerformance.generateReport(memberTransactions);
		}
		else if(reportType.equals("Member Reports"))
		{
			MemberReport memberActivity = new MemberReport();
			memberActivity.generateReport(memberTransactions);
		}
	}
	
	
	public void signUpProcess(ArrayList<ChainOwner> chainOwnerList)
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
		appUI.alert("Please enter your details on the following screens to sign up as a Chain Owner.");
    	Object[] possibleValues = {"Fairfax Store", "Centreville Store", "Sterling Store"};
    	String storeCity = appUI.selectDropDown(possibleValues);
    	String username = appUI.validateJOptionPane("Username: ", 0);
    	String password = appUI.validateJOptionPane("Password: ", 0);
    	String email = appUI.validateJOptionPane("email: ", 0);
    	String firstName = appUI.validateJOptionPane("first name: ", 0);
    	String lastName = appUI.validateJOptionPane("last name: ", 0);
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

    	appUI.alert("Sign up was successful!");
		
	}

}
