package app.main;
import app.utilities.AppProcess;


public class PetCareApplication {
	
	public static void main(String[] args) 
	{	
		AppProcess app = new AppProcess();
		app.readDataProcess();
		app.loginProcess();
		app.reportProcess();
	}


}