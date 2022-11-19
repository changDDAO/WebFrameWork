package bank;

public class AccountCreateService {
	AccountDAO dao;
	
	public AccountCreateService(AccountDAO dao) {
		this.dao = dao;
	}
	
	public boolean create(CreateRequest req) {
		if (dao.selectByOwner(req.getOwner()) != null)
			return false;
		dao.insert(req);
		return true;
	}
}
