package ptithcm.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import ptithcm.dao.OrderDao;
import ptithcm.entity.Order;

public class OrderDaoImpl implements OrderDao {
	
	private SessionFactory factory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.factory = sessionFactory;
	}
	
	@Override
	public Order addOrder(Order order) {
		Session session = factory.openSession();
	    Transaction t = session.beginTransaction();
	    
	    try {
	        session.save(order);
	        t.commit();
	        return order; 
	    } catch (Exception e) {
	        t.rollback(); 
	        e.printStackTrace();
	        return null; 
	    } finally {
	        session.close(); 
	    }
	}
}
