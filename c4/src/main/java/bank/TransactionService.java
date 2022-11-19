package bank;

public class TransactionService {
	private AccountDAO dao;
	
	public TransactionService(AccountDAO dao) {
		this.dao = dao;
	}
	
	public int deposit(int aid, int amount) {
		Account account = dao.selectByAid(aid);
		if (account == null)
			throw new AccountNotFoundException();
		
		int balance = account.getBalance() + amount;
		account.setBalance(balance);
		dao.update(account);
		
		return balance;
	}
	
	public int withdraw(int aid, int amount) {
		Account account = dao.selectByAid(aid);
		if (account == null)
			throw new AccountNotFoundException();
		
		if (amount > account.getBalance())
			throw new InsufficientBalanceException();
		
		int balance = account.getBalance() - amount;
		account.setBalance(balance);
		dao.update(account);
		
		return balance;
	}
}
