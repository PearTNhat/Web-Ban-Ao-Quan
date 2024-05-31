package ptithcm.dao.impl;


import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import ptithcm.dao.AccountDao;
import ptithcm.entity.Account;

@Transactional
public class AccountDaoImpl implements AccountDao {
	private SessionFactory factory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.factory = sessionFactory;
	}
	@Override
	public Account getAccountById(Integer id) {
		Session session = factory.getCurrentSession();
		String hql = "FROM Account where accountId = :id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		Account acc = (Account) query.list().get(0);
		return acc;
	}

	@Override
	public Integer deleteAccount(Account account) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		try {
			session.delete(account);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			System.out.println("Error delete " + e.getMessage());
			return 0;
		} finally {
			session.close();
		}
		return 1;
	}
	
	@Override
	public Account createAccount(Account account) {
		Session session = factory.openSession();
		Transaction t  = session.beginTransaction();
		
		try {
			session.save(account);
			t.commit();
			return account;
		} catch(Exception e) {
			t.rollback();
			e.printStackTrace();
			System.out.println(e);
		}
		return null;
	}
	
	@Override
	public Account findAccountByEmail(String email) {
		Session session = factory.getCurrentSession();
		String hql = "FROM Account where email = :email";
		Query query = session.createQuery(hql);
		query.setParameter("email", email);
		Account acc = (Account) query.uniqueResult();
		return acc;
	}
	
}
