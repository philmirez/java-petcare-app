
public class TransactionObject {
  private int storeID;
  private int memberID;
  private double amountSpent;

  public TransactionObject(int storeID, int memberID, double amountSpent) {
    this.storeID = storeID;
    this.memberID = memberID;
    this.amountSpent = amountSpent;
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
    return "\nStore ID: " + this.storeID + "\nMember ID: " + this.memberID + "\nAmount spent: $" + this.amountSpent + "\n";
  }
}