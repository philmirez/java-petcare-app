package app.objects;

import java.util.HashMap;

public abstract class Report {

	abstract public void generateReport(HashMap<String, TransactionObject> memberTransactions);

}
