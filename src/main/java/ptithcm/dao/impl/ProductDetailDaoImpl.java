package ptithcm.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import ptithcm.bean.ProductDetailBean;
import ptithcm.dao.ProductDetailDao;
import ptithcm.entity.Product;
import ptithcm.entity.ProductDetail;
import ptithcm.entity.ProductImage;

public class ProductDetailDaoImpl implements ProductDetailDao {
	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public List<ProductDetail> getAllProductDetails() {
		Session session = sessionFactory.getCurrentSession();
		String hql = "FROM ProductDetail";
		Query query= session.createQuery(hql);
		List<ProductDetail> productDetails = query.list();
		return productDetails;
	}
	@Override
	public Integer addProductDetail(ProductDetail pd) {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.save(pd);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			e.printStackTrace();
			return -1;
		} finally {
			session.close();
		}
		return pd.getProductDetailId();
	}

	@Override
	@Transactional
	public ProductDetail findProductById(String id) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "FROM Product WHERE productDetailId=:id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		ProductDetail productList =(ProductDetail) query.uniqueResult();
		return productList;
	}
}
