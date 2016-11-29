package app.objects;

import java.util.ArrayList;
import java.util.HashMap;
import app.utilities.Utility;

public class MemberReport extends Report{
	private ArrayList<Member> memberList;
	private HashMap<String, TransactionObject> memberTransactions;
	private String report;

	public MemberReport(ArrayList<Member> memberList, HashMap<String, TransactionObject> memberTransactions) {
		this.memberList = memberList;
		this.memberTransactions = memberTransactions;
		this.report = "";
	}
	
	@Override
	public void generateReport() {
		
	}

	public String toString() {
		return this.report;
	}
}
