package ptithcm.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import ptithcm.dao.ProductTypeDao;
import ptithcm.entity.ProductType;

public class ProductTypeDaoImpl implements ProductTypeDao {
	private SessionFactory sessionFactory;

	@Autowired 
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
    @Transactional
	public List<ProductType> getAllProductType() {
		Session session = sessionFactory.getCurrentSession();
		String hql = "FROM ProductType";
		Query query = session.createQuery(hql);
		List<ProductType> productTypes = query.list();
		return productTypes;
	}

}
