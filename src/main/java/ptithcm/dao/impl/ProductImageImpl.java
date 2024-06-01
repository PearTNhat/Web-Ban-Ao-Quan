package ptithcm.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import ptithcm.dao.ProductImageDao;
import ptithcm.entity.ProductImage;

public class ProductImageImpl implements ProductImageDao {
	
	private SessionFactory sessionFactory;

	@Autowired 
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Boolean addProductImage(ProductImage pi) {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.save(pi);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			e.printStackTrace();
			return false;
		} finally {
			session.close();
		}
		return true;
	}
	
}
