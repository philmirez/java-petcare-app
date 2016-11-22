package app.objects;

import java.util.ArrayList;
import java.util.HashMap;

import app.utilities.Utility;

public class StorePerformanceReport extends Report {

	String providedMostServices;
	String providedLeastServices;
	Double weeklySales;

	// TODO Create constructor
	public StorePerformanceReport()
	{

	}
	@Override
	public void generateReport(HashMap<String, TransactionObject> memberTransactions) {
		// TODO Auto-generated method stub
		
	}
	
    public String getProvidedMostServices() {
		return providedMostServices;
	}

	public void setProvidedMostServices(String providedMostServices) {
		this.providedMostServices = providedMostServices;
	}

	public String getProvidedLeastServices() {
		return providedLeastServices;
	}

	public void setProvidedLeastServices(String providedLeastServices) {
		this.providedLeastServices = providedLeastServices;
	}

	public Double getWeeklySales() {
		return weeklySales;
	}

	// TODO Dependent on Store Class storeWeeklySales variable 
	/**
	 * 
	 * @param weeklySales
	 */
	public void setWeeklySales(Double weeklySales) {
		this.weeklySales = weeklySales;
	}
	
	public void calculateWeeklySales(Double amountSpent) {
		
	}

	/**
     * Basic toString() method for the StorePerformanceReport Object
     */
    public String toString() {
        String output = "--- Store Performance Report ---";
        output += "\nProvided Most Services: " + this.getProvidedMostServices();
        output += "\nProvided Least Services: " + this.getProvidedLeastServices(); 
        output += "\nTotal Weekly Sales: " + this.getWeeklySales();
        return output;
    }

}
