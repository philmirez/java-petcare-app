package app.objects;

public class ChainOwner {
	private int userID;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String username;
    private String password;
    private int storeID;
    private String storeCity;
    private boolean loginStatus;

    /**
     * Default constructor for the ChainOwner Object
     */
    public ChainOwner() {
    	this.userID = 0;
        this.firstName = "";
        this.lastName = "";
        this.email = "";
        this.phoneNumber = "";
        this.username = "";
        this.password = "";
        this.storeID = 0;
        this.storeCity = "";
        this.loginStatus = false;
    }

    /**
     * Accessor methods for the ChainOwner Object
     */
    public int getUserID() {
        return this.userID;
    }
    
    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public int getStoreID() {
        return this.storeID;
    }
    
    public String getStoreCity() {
        return this.storeCity;
    }
    
    public boolean getLoginStatus() {
        return this.loginStatus;
    }

    /**
     * Mutator methods for the ChainOwner Object (assumes validation from an external input class)
     */
    public void setUserID(int userID) {
        this.userID = userID;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setStoreID(int storeID) {
        this.storeID = storeID;
    }
    
    public void setStoreCity(String storeCity) {
        this.storeCity = storeCity;
    }
    
    public void setLoginStatus(boolean loginStatus) {
        this.loginStatus = loginStatus;
    }

    /**
     * Basic toString() method for the ChainOwner Object
     */
    public String toString() {
        String output = "--- Chain Owner Information ---";
        output += "\nName: " + (this.getFirstName() + " " + this.getLastName());
        output += "\nUsername: " + this.getUsername() + "\nEmail: " + this.getEmail() + "\nPhone number: " + this.getPhoneNumber();
        output += "\nStore ID: " + this.getStoreID() + "\nStore city: " + this.getStoreCity();
        return output;
    }
}