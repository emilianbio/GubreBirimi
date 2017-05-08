/**
 * 
 */
package dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import models.Ilce;

/**
 * @author Emrah Denizer
 *
 */
@Repository
public class IlceDAOImpl implements IlceDAO {
	@Autowired
	SessionFactory sessionFactory;

	@Override
	@Transactional
	public void ilceEkle(Ilce ilce) {
		sessionFactory.getCurrentSession().saveOrUpdate(ilce);

	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Ilce> ilceListesi() {
		Criteria criteriaIlce = sessionFactory.getCurrentSession()
				.createCriteria(Ilce.class);
		criteriaIlce.addOrder(Order.asc("isim"));
		return criteriaIlce.list();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.IlceDAO#ilceGetir(long)
	 */
	@SuppressWarnings("unused")
	@Override
	@Transactional
	public Ilce ilceGetir(long id) {
		org.hibernate.Session session = sessionFactory.openSession();
		Ilce ilce = (Ilce) sessionFactory.getCurrentSession().load(Ilce.class,
				id);

		ilce.getId();

		return ilce;
	}

}
