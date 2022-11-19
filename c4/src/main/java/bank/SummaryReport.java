package bank;

public class SummaryReport implements ReportTool {

	@Override
	public void print(Account account) {
		System.out.printf("Account(id=%d, balance=%d)\n",account.getAid(),account.getBalance());

	}

}
