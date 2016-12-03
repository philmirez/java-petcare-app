package app.objects;

import java.util.*;
import app.utilities.Utility;
import app.objects.*;

public class MemberReport extends Report{
	private ArrayList<Member> memberList;
	private HashMap<String, TransactionObject> memberTransactions;
	private int storeID;
	private String report;

	public MemberReport(ArrayList<Member> memberList, HashMap<String, TransactionObject> memberTransactions, int storeID) {
		this.memberList = memberList;
		this.memberTransactions = memberTransactions;
		this.storeID = storeID;
		this.report = "";
	}
	
	@Override
	public void generateReport(HashMap<String, TransactionObject> memberTransactions) {
		Set set = memberTransactions.entrySet();
		Iterator iterator = set.iterator();

		while (iterator.hasNext()) {
			Map.Entry mapEntry = (Map.Entry)iterator.next();
			TransactionObject currentTransaction = (TransactionObject)mapEntry.getValue();
			updateMembers(currentTransaction, this.memberList);
		}
		this.selectMembersFromTransactionObjects(this.memberTransactions, this.memberList);
	}

	public int getIndexedMemberFromTransaction(TransactionObject transaction, ArrayList<Member> memberList) {
		int memberID = transaction.getMemberID();
		int i;
		for (i = 0; i < memberList.size(); i += 1) {
			if (memberList.get(i).getMemberID() == memberID) {
				return i;
			}
		}
		return -1;
	}

	public ArrayList<Member> updateMembers(TransactionObject transaction, ArrayList<Member> memberList) {
		double amount = transaction.getAmountSpent();
		int index = getIndexedMemberFromTransaction(transaction, memberList);
		if (index != -1) {
			memberList.get(index).setTotalSpent(memberList.get(index).getTotalSpent() + amount);
			memberList.get(index).setHasDiscountAmountStatus();
			memberList.get(index).setDiscountAmount(10.00);
		}
		return memberList;
	}

	public void selectMembersFromTransactionObjects(HashMap<String, TransactionObject> memberTransactions, ArrayList<Member> memberList) {
		Set set = memberTransactions.entrySet();
		Iterator iterator = set.iterator();
		ArrayList<Integer> relevantIDList = new ArrayList<Integer>();

		while (iterator.hasNext()) {
			Map.Entry mapEntry = (Map.Entry)iterator.next();
			TransactionObject currentTransaction = (TransactionObject)mapEntry.getValue();
			if (currentTransaction.getStoreID() == this.storeID) {
				relevantIDList.add(currentTransaction.getMemberID());
			}
		}

		this.report += "--- Member Report ---\n";
		for (Integer i : relevantIDList) {
			this.report += this.memberList.get(i).toString();
		}
	}

	public String toString() {
		return this.report;
	}
}
