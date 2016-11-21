package app.objects;


public class TransactionObject {

  private String transactionID;
  private int storeID;
  private int memberID;
  private double amountSpent;

  public TransactionObject(String transactionID, int storeID, int memberID, double amountSpent) {
    this.transactionID = transactionID;
    this.storeID = storeID;
    this.memberID = memberID;
    this.amountSpent = amountSpent;
  }

  public String getTransactionID() {
    return this.transactionID;
  }

  public int getStoreID() {
    return this.storeID;
  }

  public int getMemberID() {
    return this.memberID;
  }

  public double getAmountSpent() {
    return this.amountSpent;
  }

  public void setTransactionID(String transactionID) {
    this.transactionID = transactionID;
  }

  public void setStoreID(int storeID) {
    this.storeID = storeID;
  }

  public void setMemberID() {
    this.memberID = memberID;
  }

  public void setAmountSpent(double amountSpent) {
    this.amountSpent = amountSpent;
  }

  public String toString() {
    String output = "Transaction ID: " + this.transactionID + "\nStore ID: " + this.storeID;
    output += "\nMember ID: " + this.memberID + "\nAmount spent: $" + this.amountSpent;
    
    return output;
  }
}