package app.objects;

import java.util.ArrayList;
import java.util.HashMap;

import app.utilities.Utility;

public class MemberReport extends Report{

	ArrayList<Member> memberList = new ArrayList<Member>();
	ArrayList<Store> storeList = new ArrayList<Store>();
	
	public MemberReport() {
		this.memberList.addAll(Utility.JSONreader("json/memberObjects.json"));
		this.storeList.addAll(Utility.JSONreader("json/storeObjects.json"));
	}
	
	@Override
	public void generateReport(HashMap<String, TransactionObject> memberTransactions) {
		// TODO Auto-generated method stub
		
	}
	

}
