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

public class UserInterface {
	
	public UserInterface() {

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
}
