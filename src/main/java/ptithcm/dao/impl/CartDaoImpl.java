package ptithcm.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import ptithcm.dao.CartDao;
import ptithcm.entity.CartDetail;
import ptithcm.entity.Product;
import ptithcm.entity.ProductDetail;

public class CartDaoImpl implements CartDao {
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	@Transactional
	public Boolean addCartDetail(CartDetail cartDetail) {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.save(cartDetail);
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
	public Boolean deleteCartDetailById(Integer cartDetailId) {
		Session session = sessionFactory.getCurrentSession();
		try {
			String hql = "DELETE FROM CartDetail  WHERE cartDetailId = :cartDetailId";
			int deletedCount = session.createQuery(hql).setParameter("cartDetailId", cartDetailId).executeUpdate();
			if (deletedCount > 0) {
				System.out.println("Deleted cartDetailId: " + cartDetailId);
			}

			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
	@Override
	@Transactional
	public List<CartDetail> findCardDetailByAccountId(Integer accountId) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "FROM CartDetail WHERE accountId=:accountId";
		Query query = session.createQuery(hql);
		query.setParameter("accountId", accountId);
		List<CartDetail> productList = query.list();
		return productList;
	}
	@Override
	@Transactional
	public boolean updateCartDetail(List<CartDetail> list) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		try {
			for (CartDetail pd : list) {
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
}
