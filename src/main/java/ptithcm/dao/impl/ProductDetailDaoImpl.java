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
import ptithcm.entity.ProductColor;
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
		Query query = session.createQuery(hql);
		List<ProductDetail> productDetails = query.list();
		return productDetails;
	}

	@Override
	public Integer addProductColor(ProductColor pc) {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.save(pc);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			e.printStackTrace();
			return -1;
		} finally {
			session.close();
		}
		return pc.getProductColorId();
	}

	@Override
	@Transactional
	public List<ProductDetail> getProductDetails(int productId, int page, int pageSize) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "SELECT pd " + "FROM ProductDetail pd " + "JOIN FETCH pd.color c " + "JOIN FETCH pd.size s "
				+ "WHERE pd.productId = :productId " + "ORDER BY s.name";
		Query query = session.createQuery(hql);
		query.setParameter("productId", productId).setFirstResult((page - 1) * pageSize).setMaxResults(pageSize);

		@SuppressWarnings("unchecked")
		List<ProductDetail> productDetails = query.list();

		return productDetails;
	}

	@Override
	@Transactional
	public ProductColor findProductColorById(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "FROM ProductColor WHERE productColorId=:id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		ProductColor productList = (ProductColor) query.uniqueResult();
		return productList;
	}

	@Override
	@Transactional
	public boolean updateProductDetail(List<ProductDetail> list) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		try {
			for (ProductDetail pd : list) {
				session.update(pd);
			}
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
	@Transactional
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
	public Integer findProductColor(Integer productId, Integer colorId) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "FROM ProductColor WHERE productId=:productId and colorId=:colorId";
		Query query = session.createQuery(hql);
		query.setParameter("productId", productId);
		query.setParameter("colorId", colorId);
		ProductColor productList = (ProductColor) query.uniqueResult();
		return productList == null ? null : productList.getProductColorId();
	}

	@Override
	@Transactional
	public List<ProductDetail> findProductDetailByPCId(Integer productColorId) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "FROM ProductDetail WHERE productColorId=:productColorId";
		Query query = session.createQuery(hql);
		query.setParameter("productColorId", productColorId);
		List<ProductDetail> productList = query.list();
		return productList;
	}

}
