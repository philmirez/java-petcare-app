package app.objects;

public class Member {
    private static final double MIN_TOTAL_FOR_DISCOUNT = 200.00;

    private int memberID;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private double totalSpent;
    private double discountAmount;
    private boolean hasActiveDiscount;

    public Member() {
        this.firstName = "";
        this.lastName = "";
        this.email = "";
        this.phoneNumber = "";
        this.totalSpent = 0.00;
        this.discountAmount = 0.00;
        this.hasActiveDiscount = false;
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

    public double getTotalSpent() {
        return this.totalSpent;
    }

    public double getDiscountAmount() {
        return this.discountAmount;
    }

    public boolean getHasActiveDiscountStatus() {
        return this.hasActiveDiscount;
    }

    public static double getMinimumTotalForDiscount() {
        return MIN_TOTAL_FOR_DISCOUNT;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = "";
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setTotalSpent(double totalSpent) {
        this.totalSpent = totalSpent;
    }

    public void setDiscountAmount(double discountAmount) {
        this.discountAmount = discountAmount;
    }

    public void setHasDiscountAmountStatus() {
        if (this.getTotalSpent() >= MIN_TOTAL_FOR_DISCOUNT) {
            this.hasActiveDiscount = true;
        } else {
            this.hasActiveDiscount = false;
        }
    }

    public String toString() {
        String output = "--- Member Information ---";
        output = "\nName: " + (this.getFirstName() + " " + this.getLastName());
        output += "\nEmail: " + this.getEmail() + "\nPhone number: " + this.getPhoneNumber();
        output += "\nTotal spent: $" + this.getTotalSpent();

        if (this.getHasActiveDiscountStatus()) {
            output += "\nThis Member currently has a discount amount of: " + this.getDiscountAmount() + "%.";
        } else {
            output += "\nThis Member does not currently have a discount.";
        }
        return output;
    }
}