
public class Store {
    private String storeID;
    private String storeAddress;
    private String storeHours;

    /**
     * Default constructor for the Store Object
     */
    public Store() {
        this.storeID = "";
        this.storeAddress = "";
        this.storeHours = "";
    }

    /**
     * Accessor methods for the Store Object
     */
    public String getStoreID() {
        return this.storeID;
    }

    public String getStoreAddress() {
        return this.storeAddress;
    }

    public String getStoreHours() {
        return this.storeHours;
    }

    /**
     * Mutator methods for the Store Object (assumes validation from an external input class)
     */
    public void setStoreID(String storeID) {
        this.storeID = storeID;
    }

    public void setStoreAddress(String storeAddress) {
        this.storeAddress = storeAddress;
    }

    public void setStoreHours(String storeHours) {
        this.storeHours = storeHours;
    }

    /**
     * Basic toString() method for the Store Object
     */
    public String toString() {
        String output = "--- Store Details ---";
        output += "\nStore ID: " + this.getStoreID() + "\nStore Address: " + this.getStoreAddress();
        output += "Store Hours: " + this.getStoreHours() + "\n";
        return output;
    }
}