package ptithcm.dao.impl;


import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import ptithcm.dao.ColorDao;
import ptithcm.entity.Color;

public class ColorDaoImpl implements ColorDao {
	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public List<Color> getAllColors() {
		Session session = sessionFactory.getCurrentSession();
		String hql = "FROM Color";
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Color> sizeList = query.list();
		return sizeList;
	}
	@Override
	@Transactional
	public Color getColorByName(String name) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "FROM Color where name=:name";
		Query query = session.createQuery(hql);
		query.setParameter("name", name);
		@SuppressWarnings("unchecked")
		Color color =(Color)query.uniqueResult();
		return color;
	}

	@Override
	public Integer insertColor(Color color) {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.save(color);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			e.printStackTrace();
			return -1;
		} finally {
			session.close();
		}
		return color.getColorId();
	}

}
