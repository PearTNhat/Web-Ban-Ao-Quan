package ptithcm.dao.impl;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import ptithcm.dao.OrderDetailDao;
import ptithcm.entity.OrderDetail;

public class OrderDetailDaoImpl implements OrderDetailDao {	
	private SessionFactory factory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.factory = sessionFactory;
	}
	
	@Override
	public Boolean addOrderDetail(OrderDetail orderDetail) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		
		try {
			session.save(orderDetail);
			t.commit();
			return true;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
