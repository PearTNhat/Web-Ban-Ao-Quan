package ptithcm.dao.impl;

import java.util.List;

import javax.transaction.Transactional;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import ptithcm.dao.SizeDao;
import ptithcm.entity.Size;

public class SizeDaoImpl implements SizeDao {
	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public List<Size> getAllSizes() {
		Session session = sessionFactory.getCurrentSession();
		String hql = "FROM Size";
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Size> sizeList = query.list();
		return sizeList;

	}

}
