package app.objects;

public class ChainOwner {
	// add userid
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String username;
    private String password;
    private String storeID;

    /**
     * Default constructor for the ChainOwner Object
     */
    public ChainOwner() {
        this.firstName = "";
        this.lastName = "";
        this.email = "";
        this.phoneNumber = "";
        this.username = "";
        this.password = "";
        this.storeID = "";
    }

    /**
     * Accessor methods for the ChainOwner Object
     */
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

    public String getStoreID() {
        return this.storeID;
    }

    /**
     * Mutator methods for the ChainOwner Object (assumes validation from an external input class)
     */
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

    public void setStoreID(String storeID) {
        this.storeID = storeID;
    }

    /**
     * Basic toString() method for the ChainOwner Object
     */
    public String toString() {
        String output = "--- Chain Owner Information ---";
        output += "\nName: " + (this.getFirstName() + " " + this.getLastName());
        output += "\nEmail: " + this.getEmail() + "\nPhone number: " + this.getPhoneNumber();
        output += "\nStore ID: " + this.getStoreID() + "\n";
        return output;
    }
}