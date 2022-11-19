package bank;

import java.util.Collection;
import java.util.HashMap;

public class AccountDAO {
	HashMap<String, Integer> omap;
	HashMap<Integer, Account> amap;
	int autoIncrementValue = 0;
	
	public AccountDAO() {
		omap = new HashMap<String, Integer>();
		amap = new HashMap<Integer, Account>();
	}
	
	public Account selectByAid(int aid) {
		return amap.get(aid);
	}
	
	public Account selectByOwner(String owner) {
		Integer aid = omap.get(owner);
		if (aid == null)
			return null;
		return amap.get(aid);
	}
	
	public Collection<Account> selectAll() {
		return amap.values();
	}
	
	public void insert(CreateRequest req) {
		Account account = new Account();
		autoIncrementValue++;
		account.setAid(autoIncrementValue);
		account.setOwner(req.getOwner());
		account.setName(req.getName());
		account.setBalance(req.getBalance());
		
		amap.put(account.getAid(), account);
		omap.put(account.getOwner(), account.getAid());
	}
	
	public boolean update(Account ua) {
		if (!amap.containsKey(ua.getAid()))
			return false;
		if (!omap.containsKey(ua.owner))
			return false;
		if (ua.getAid() != omap.get(ua.getOwner()))
			return false;
		
		Account account = amap.get(ua.getAid());
		account.setBalance(ua.getBalance());
		account.setName(ua.getName());
		return true;
	}
}
