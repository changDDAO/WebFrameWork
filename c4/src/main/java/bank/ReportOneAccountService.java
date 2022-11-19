package bank;

public class ReportOneAccountService {
	private AccountDAO dao;
	private ReportTool printer;
	
	public void setDao(AccountDAO dao) {
		this.dao = dao;
	}
	public void setPrinter(ReportTool printer) {
		this.printer = printer;
	}
	
	public void printAccountInfo(String owner) {
		Account account = dao.selectByOwner(owner);
		if (account == null) {
			System.out.println(owner + ": 계좌가 없는 사용자 입니다.");
			return;
		}
		
		printer.print(account);
	}
}
