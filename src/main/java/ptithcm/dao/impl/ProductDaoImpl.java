package ptithcm.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import ptithcm.dao.ProductDao;
import ptithcm.entity.Product;

public class ProductDaoImpl implements ProductDao {
	private SessionFactory sessionFactory;

	@Autowired 
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	@Transactional
	public List<Product> getProducts(int page, int pageSize, String search) {
		Session session = sessionFactory.getCurrentSession();

		String hql = "FROM Product WHERE LOWER(REPLACE(name, ' ', '')) LIKE LOWER(REPLACE('%'+:search+'%', ' ', ''))";
		Query query = session.createQuery(hql);
		query.setParameter("search", search).setFirstResult((page - 1) * pageSize).setMaxResults(pageSize);

		@SuppressWarnings("unchecked")
		List<Product> productList = query.list();
		return productList;
	}

	@Transactional
	public Long countProducts(String search) {
		Session session = sessionFactory.getCurrentSession();

		Query query = session.createQuery(
				"SELECT count(name) FROM Product a WHERE LOWER(REPLACE(name, ' ', '')) LIKE LOWER(REPLACE('%'+:search+'%', ' ', ''))");
		query.setParameter("search", search);

		return (Long) query.uniqueResult();
	}
}