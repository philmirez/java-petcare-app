package app.utilities;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import app.objects.ChainOwner;
import app.objects.Report;
import app.objects.StorePerformanceReport;

public class UserInterface {

	private static final String[] reports = {"Store Performance", "Member Data"}; 
	
	public UserInterface() {
		// TODO Auto-generated constructor stub
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

	/**
	 * 
	 * @param prt
	 * @param displayTypeFlag 0 - No Input Fields 1 - Two Input Fields
	 */
	public void prt(ArrayList<ChainOwner> chainOwnerList, String prt, int displayTypeFlag)
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
		            possibleValues, possibleValues[0]);
		return selectedValue;
	}
	/**
	 * 
	 * @param message
	 */
	public void displayNoIFMessage(String message)
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
	public void displayTwoIFMessage(ArrayList<ChainOwner> chainOwnerList, String message)
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
			        	displayOneIFMessage("Username: ");
			        	displayOneIFMessage("Password: ");
			        	prt(chainOwnerList, "Sign up was successful!", 0);
			        	prt(chainOwnerList, "Please enter your Username and Password to Log in.", 1);
			        }
			        
			    }
		} else {
		    
			System.out.println("Login cancelled.");
			
		}
	}

	/**
	 * 
	 * @param message
	 */
	public String displayOneIFMessage(String message)
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
    	Object[] possibleValues = { "Fairfax Store", "Centreville Store", "Sterling Store" };
    	displayDropDownStoreMessage(possibleValues);
    	displayOneIFMessage("Username: ");
    	displayOneIFMessage("Password: ");
    	prt(chainOwnerList, "Sign up was successful!", 0);
    	prt(chainOwnerList, "Please enter your Username and Password to Log In.", 1);
	}
	
	public void generatePerformanceReport()
	{
		
	}
	
	public void generateMemberReport()
	{
		
	}

}
