package app.objects;

import java.util.ArrayList;
import java.util.HashMap;

public class StorePerformanceReport extends Report {

	String providedMostServices;
	String providedLeastServices;
	Double weeklySales;
	private int storeID;
	ArrayList<Store> storeList;
	HashMap<String, TransactionObject> memberTransactions;

	public StorePerformanceReport()
	{
		providedMostServices = "";
		providedLeastServices = "";
		storeID = -1;
		storeList = new ArrayList<Store>();
		memberTransactions = new HashMap<String, TransactionObject>();
	}
	
	public StorePerformanceReport(int storeID, ArrayList<Store> storeList)
	{
		this.storeID = storeID-1;
		this.storeList = storeList;
	}
	
	@Override
	public void generateReport(HashMap<String, TransactionObject> memberTransactions) {
		this.memberTransactions = memberTransactions;
		setWeeklySales(calculateWeeklySales());
		
	}
	
    public String getProvidedMostServices() {
		return providedMostServices;
	}

	public void setProvidedMostServices(String providedMostServices) {
		this.providedMostServices = providedMostServices;
	}

	public Store getProvidedLeastServices() {
		Store leastStore = storeList.get(getMinIndex(storeList));
		return leastStore;
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
	
	
	public int getStoreID() {
		return storeID;
	}
	public void setStoreID(int storeID) {
		this.storeID = storeID;
	}
	public ArrayList<Store> getStoreList() {
		return storeList;
	}
	public void setStoreList(ArrayList<Store> storeList) {
		this.storeList = storeList;
	}
	public double calculateWeeklySales() {
		double weeklySales = 0;
		
		for (String key: memberTransactions.keySet()) {
			if(memberTransactions.get(key).getStoreID()==storeID)
				weeklySales += memberTransactions.get(key).getAmountSpent();
		}
		
		return weeklySales;
	}
	
	private int getMinIndex(ArrayList<Store> storeList) {
	    int minIndex = -1;
	    double minValue = Double.MAX_VALUE;
	    for(int i = 0; i<storeList.size();i++) {
	        double sales = storeList.get(i).getTotalWeeklySales();
	        if(sales < minValue) {
	            minValue = sales;
	            minIndex = i;
	        }
	    }
	    return minIndex;
	}

	/**
     * Basic toString() method for the StorePerformanceReport Object
     */
    public String toString() {
    	System.out.println("StoreID: " + storeID);
        String output = "--- Store Performance Report ---";
        output += "\nProvided Most Services: " + this.getProvidedMostServices();
        output += "\n" + this.getProvidedLeastServices().getStoreAddress() + " provided Least Services: " + this.getProvidedLeastServices().getTotalWeeklySales(); 
        output += "\nTotal Weekly Sales for " + storeList.get(storeID).getStoreAddress()  + " store: " + storeList.get(storeID).getTotalWeeklySales();
        return output;
    }

}
