package ptithcm.dao;

import java.util.List;

import ptithcm.entity.Account;

public interface AccountDao {
	public Account getAccountById(Integer id);
	public Integer deleteAccount(Account account);
	public Account createAccount(Account account);
	public Account findAccountByEmail(String email);
	public Boolean updateAccount(Account user);
	public List<Account> findNonAdminAccounts();
}
