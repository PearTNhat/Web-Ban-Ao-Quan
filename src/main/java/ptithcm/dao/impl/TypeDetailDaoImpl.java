package ptithcm.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import ptithcm.dao.TypeDetailDao;
import ptithcm.entity.ProductType;
import ptithcm.entity.TypeDetail;

public class TypeDetailDaoImpl implements TypeDetailDao{
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public List<TypeDetail> getAllTypeDetail() {
		Session session = sessionFactory.getCurrentSession();
		String hql = "FROM TypeDetail";
		Query query = session.createQuery(hql);
		List<TypeDetail> typesDetail = query.list();
		return typesDetail;
	}
	
	@Override
    @Transactional
    public TypeDetail getTypeDetail(String typeDetailId) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "FROM TypeDetail td WHERE td.typeDetailId = :typeDetailId";
        Query query = session.createQuery(hql);
        query.setParameter("typeDetailId", typeDetailId);

        return (TypeDetail) query.uniqueResult();
    }
}
