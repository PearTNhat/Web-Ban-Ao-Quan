package ptithcm.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import ptithcm.dao.ProductImageDao;
import ptithcm.entity.ProductDetail;
import ptithcm.entity.ProductImage;

public class ProductImageImpl implements ProductImageDao {

	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
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

	@Override
	@Transactional
	public Integer countImageById(Integer productDetailId) {
		Session session = sessionFactory.getCurrentSession();

		Query query = session.createQuery("FROM ProductImage a WHERE productDetailId=:productDetailId");
		query.setParameter("productDetailId", productDetailId);

		return (Integer) query.uniqueResult();
	}

	@Override
	@Transactional
	public List<ProductImage> findImageByPD(Integer productDetailId) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "FROM ProductImage a WHERE productDetailId=:productDetailId";
		Query query = session.createQuery(hql);
		query.setParameter("productDetailId", productDetailId);
		return query.list();
	}

	@Override
	@Transactional
	public Boolean deleteImgByPDID(Integer pId) {
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		try {
			String hql = "DELETE FROM ProductImage pi WHERE pi.pdId = :productDetailId";
			session.createQuery(hql).setParameter("productDetailId", pId).executeUpdate();
			transaction.commit();
			return true;
		} catch (RuntimeException e) {
			if (transaction.isActive()) {
				transaction.rollback();
			}
			return false;
		}
	}

	@Override
	@Transactional
	public ProductImage getLastProductImageByProductDetailId(Integer productDetailId) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "FROM ProductImage pi WHERE pi.pdId = :productDetailId ORDER BY pi.priority DESC";
		Query query = session.createQuery(hql);
		query.setParameter("productDetailId", productDetailId);
		query.setMaxResults(1); // Limit the results to 1 to get the last element
		return (ProductImage) query.uniqueResult();

	}

	@Override
	@Transactional
	public Boolean deleteImage(String image) {
		Session session = sessionFactory.getCurrentSession();
		try {
			String hql = "DELETE FROM ProductImage p WHERE p.image = :image";
			int deletedCount = session.createQuery(hql).setParameter("image", image).executeUpdate();
			if (deletedCount > 0) {
				System.out.println("Deleted image: " + image);
			}

			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}

	}
}
