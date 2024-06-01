package ptithcm.dao;

import ptithcm.entity.Account;

public interface AccountDao {
	public Account getAccountById(Integer id);
	public Integer deleteAccount(Account account);
	public Account createAccount(Account account);
	public Account findAccountByEmail(String email);
}
