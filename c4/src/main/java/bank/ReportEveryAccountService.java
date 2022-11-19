package bank;

import java.util.Collection;

public class ReportEveryAccountService {
	private AccountDAO dao;
	private ReportTool printer;
	
	public void setDao(AccountDAO dao) {
		this.dao = dao;
	}
	public void setPrinter(ReportTool printer) {
		this.printer = printer;
	}
	
	void printAccountList() {
		Collection<Account> alist = dao.selectAll();
		
		if (alist == null) {
			System.out.println("계좌가 존재하지 않습니다.");
			return;
		}
		for (Account account : alist)
			printer.print(account);
	}
}
