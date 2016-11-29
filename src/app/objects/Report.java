package app.objects;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class Report {

	public abstract void generateReport(HashMap<String, TransactionObject> memberTransactions);;

}
