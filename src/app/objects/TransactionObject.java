
public class TransactionObject {
  private static int globalTransactionID = 0;

  private int transactionID;
  private int storeID;
  private int memberID;
  private double amountSpent;

  public TransactionObject(int storeID, int memberID, double amountSpent) {
    this.transactionID = ++globalTransactionID;
    this.storeID = storeID;
    this.memberID = memberID;
    this.amountSpent = amountSpent;
  }

  public int getTransactionID() {
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

  public static int getGlobalTransactionID() {
    return globalTransactionID;
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
  }
}