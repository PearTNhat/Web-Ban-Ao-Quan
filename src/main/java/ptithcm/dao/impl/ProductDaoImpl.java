package ptithcm.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import ptithcm.bean.ProductDetailBean;
import ptithcm.dao.ProductDao;
import ptithcm.entity.Account;
import ptithcm.entity.Product;
import ptithcm.entity.ProductDetail;

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

	@Override
	@Transactional
	public List<Product> getProductByType(String typeId) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "FROM Product WHERE typeDetailId=:typeId";
		Query query = session.createQuery(hql);
		query.setParameter("typeId", typeId);
		@SuppressWarnings("unchecked")
		List<Product> productList = query.list();
		return productList;
	}

	@Override
	public Boolean addProduct(Product product) {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.save(product);
			t.commit();
			return true;
		} catch (Exception e) {
			t.rollback();
			e.printStackTrace();
			return false;
		} finally {
			session.close();
		}
	}

	@Override
	@Transactional
	public Product getProductById(int productId) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "From Product WHERE productId= :productId";
		Query query = session.createQuery(hql);
		query.setParameter("productId", productId);

		Product product = (Product) query.uniqueResult();

		return product;
	}

	@Override
	@Transactional
	public Product findProductById(Integer productId) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "FROM Product WHERE productId=:productId";
		Query query = session.createQuery(hql);
		query.setParameter("productId", productId);
		Product productList = (Product) query.uniqueResult();
		return productList;
	}

	@Override
	@Transactional
	public Boolean updateProduct(Product product) {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		try {
			System.out.println(product);
			session.update(product);
			t.commit();
			return true;
		} catch (Exception e) {
			t.rollback();
			e.printStackTrace();
			return false;
		} finally {
			session.close();
		}
	}

	@Override
	@Transactional
	public List<Product> getBestSaleProduct() {
		Session session = sessionFactory.getCurrentSession();
		String hql = "FROM Product p ORDER BY p.soldQuantity DESC";
		Query query = session.createQuery(hql);
		query.setMaxResults(6);
		List<Product> productList = query.list();
		return productList;
	}

	@Override
	@Transactional
	public List<Product> getNewProduct() {
		Session session = sessionFactory.getCurrentSession();
		String hql = "FROM Product p ORDER BY p.createdAt DESC";
		Query query = session.createQuery(hql);
		query.setMaxResults(6);
		List<Product> productList = query.list();
		return productList;
	}

	@Override
	public Boolean deleteProduct(Product product) {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();

		try {
			session.delete(product);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			System.out.println("Error delete " + e.getMessage());
			return false;
		} finally {
			session.close();
		}
		return true;
	}

	@Override
	@Transactional
	public List<Product> getAllProducts() {
		Session session = sessionFactory.getCurrentSession();
		String hql = "FROM Product";
		Query query = session.createQuery(hql);
		List<Product> productList = query.list();
		return productList;
	}
}
