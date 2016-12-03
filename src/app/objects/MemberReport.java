package app.objects;

import java.util.*;
import app.utilities.Utility;

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
		
	}

	public String toString() {
		return this.report;
	}
}
