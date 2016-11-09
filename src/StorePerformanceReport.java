
public class StorePerformanceReport extends Report {

	String providedMostServices;
	String providedLeastServices;
	Double weeklySales;
	
	@Override
	public void generateReport() {
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

	public void calculateWeeklySales(Double weeklySales) {
		this.weeklySales = weeklySales;
	}

	/**
     * Basic toString() method for the ChainOwner Object
     */
    public String toString() {
        String output = "--- Store Performance Report ---";
        output += "\nProvided Most Services: " + this.getProvidedMostServices();
        output += "\nProvided Least Services: " + this.getProvidedLeastServices(); 
        output += "\nTotal Weekly Sales: " + this.getWeeklySales();
        return output;
    }

}
