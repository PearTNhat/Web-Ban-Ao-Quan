package ptithcm.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import ptithcm.dao.AccountDao;
import ptithcm.dao.AddressDao;
import ptithcm.entity.Account;
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

	@Override
	public List<Address> getAllAddress(Integer accountId) {
		if (accountDao.getAccountById(accountId) != null) {
			Session session = factory.getCurrentSession();
			String hql = "FROM Address where accountId = :id";
			Query query = session.createQuery(hql);
			query.setParameter("id", accountId);
			List<Address> address = query.list();
			return address;
		}
		System.out.println("Can't get address because user is not in db");
		return null;
	}

	@Override
	public Boolean editAddress(Address address) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {

			session.update(address);
			t.commit();
			return true;

		} catch (Exception e) {
			System.out.println(e);
			t.rollback();
		} finally {
			session.close();

		}
		return false;
	}

	@Override
	public Boolean deleteAddress(Address address) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.delete(address);
			t.commit();
			return true;

		} catch (Exception e) {
			t.rollback();
			System.out.println(e);
		} finally {
			session.close();
		}
		return false;
	}

	@Override
	public Address getAddress(Integer addressId) {
		Session session = factory.getCurrentSession();
		String hql = "From Address Where addressId = :id";
		Query query = session.createQuery(hql);
		query.setParameter("id", addressId);
		Address add = null;
		try {
			add = (Address) query.uniqueResult();
		} catch (Exception e) {
			System.out.println(e);
		}
		return add;
	}
}
