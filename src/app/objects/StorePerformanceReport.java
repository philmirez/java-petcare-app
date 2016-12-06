package app.objects;

import java.text.DecimalFormat;
import java.text.NumberFormat;
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
	
    public Store getProvidedMostServices() {
    	Store maxStore = storeList.get(getMaxIndex(storeList));
		return maxStore;
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
	
	private int getMaxIndex(ArrayList<Store> storeList) {
	    int maxIndex = -1;
	    double maxValue = Double.MIN_VALUE;
	    for(int i = 0; i<storeList.size();i++) {
	        double sales = storeList.get(i).getTotalWeeklySales();
	        if(sales > maxValue) {
	            maxValue = sales;
	            maxIndex = i;
	        }
	    }
	    return maxIndex;
	}

	/**
     * Basic toString() method for the StorePerformanceReport Object
     */
    public String toString() {
    	NumberFormat mostWeekly = new DecimalFormat("#.##"); 
    	NumberFormat leastWeekly = new DecimalFormat("#.##");
    	NumberFormat ownerWeekly = new DecimalFormat("#.##");
		
        String output = "--- Store Performance Report ---";
        output += "\n" + this.getProvidedMostServices().getStoreAddress() + " provided Most Services: $" + mostWeekly.format(this.getProvidedMostServices().getTotalWeeklySales());
        output += "\n" + this.getProvidedLeastServices().getStoreAddress() + " provided Least Services: $" + leastWeekly.format(this.getProvidedLeastServices().getTotalWeeklySales()); 
        output += "\nTotal Weekly Sales for " + storeList.get(storeID).getStoreAddress()  + " store: $" + ownerWeekly.format(storeList.get(storeID).getTotalWeeklySales());
        return output;
    }

}
