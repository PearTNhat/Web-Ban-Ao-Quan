package ptithcm.dao.impl;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import ptithcm.dao.CartDao;
import ptithcm.entity.CartDetail;

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

}
