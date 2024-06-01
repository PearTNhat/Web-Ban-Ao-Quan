package ptithcm.dao.impl;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import ptithcm.dao.AccountDao;
import ptithcm.dao.AddressDao;
import ptithcm.entity.Address;

@Transactional
public class AddressDaoImpl implements AddressDao {
	
	@Autowired
	private AccountDao accountDao;
	
	private SessionFactory factory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.factory = sessionFactory;
	}
	
	@Override
	public Boolean addAddress(Integer accountId, Address address) {
		if (accountDao.getAccountById(accountId) != null) {
			Session session = factory.openSession();
			Transaction t = session.beginTransaction();
			
			try {
				session.save(address);
				t.commit();
				return true;
			} catch(Exception e) {
				System.out.println("Error adding address for account: " + accountId);
				e.printStackTrace();
			}
			return false;
		} else {
			System.out.println("accoundId does not exist!");
			return false;
		}
	}
}
