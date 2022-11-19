package bank;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config1 {
	@Bean
	public AccountDAO dao() {
		return new AccountDAO();
	}
	
	@Bean
	public BasicReport basic() {
		return new BasicReport();
	}
	@Bean
	public AccountCreateService cservice() {
		return new AccountCreateService(dao());
	}
	@Bean
	public TransactionService tservice() {
		return new TransactionService(dao());
	}
	
	@Bean
	public ReportEveryAccountService every() {
		ReportEveryAccountService service = new ReportEveryAccountService();
		service.setDao(dao());
		service.setPrinter(basic());
		return service;
	}
	
	@Bean
	public ReportOneAccountService one() {
		ReportOneAccountService service = new ReportOneAccountService();
		service.setDao(dao());
		service.setPrinter(basic());
		return service;
	}
}
