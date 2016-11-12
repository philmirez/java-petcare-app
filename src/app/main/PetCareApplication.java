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
import app.utilities.UserInterface;


public class PetCareApplication {

	private static UserInterface appUI = new UserInterface();
	
	public static void main(String[] args) 
	{	
		loginProcess();
		reportProcess();
	}

	public static void loginProcess()
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
		 */
		chainOwnerList.addAll(readExistingChainOwnerData());
		
		/**
		 * Return chainOwner and log in status
		 */
		chainOwner = appUI.loginPage(chainOwnerList);
		
		success = chainOwner.getLoginStatus();
		
		if(success =true)
		{
			appUI.prt(chainOwnerList, "You are currently logged in as " + chainOwner.getUsername() + " for Store " + chainOwner.getStoreCity(), 0);			
		}
		else
		{
			appUI.prt(chainOwnerList, "Invalid Username/Password.", 0);
			tryAgainOrSignUpResponse = appUI.tryAgainOrSignUpPage();
	        
	        if(tryAgainOrSignUpResponse.equals("1"))
	        	loginProcess();
	        else if(tryAgainOrSignUpResponse.contentEquals("2"))
	        {
	        	appUI.signUpPage(chainOwnerList);
	        	loginProcess();
	        }
		}
	
	}
		
	private static void reportProcess() 
	{
		/**
		 * reportType
		 * -----------
		 *  0 = No Report
		 *  1 = Performance Report
		 *  2 = Member Report
		 */
		int reportType = 0;
		reportType = appUI.reportsPage();
		if(reportType==1)
			appUI.generatePerformanceReport();
		else if(reportType==2)
			appUI.generateMemberReport();
	}

	/**
	 * 
	 * @return
	 */
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
	
}
