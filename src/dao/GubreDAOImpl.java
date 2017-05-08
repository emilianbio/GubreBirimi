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

import models.Gubre;

/**
 * @author Emrah Denizer
 *
 */
@Repository
public class GubreDAOImpl implements GubreDAO {
	@Autowired
	SessionFactory sessionFactory;

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.GubreDAO#gubreEkle(models.Gubre)
	 */
	@Override
	@Transactional
	public void gubreEkle(Gubre gubre) {
		sessionFactory.getCurrentSession().saveOrUpdate(gubre);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.GubreDAO#gubreListesi()
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Gubre> gubreListesi() {
		Criteria criteriaGubre = sessionFactory.getCurrentSession()
				.createCriteria(Gubre.class);

		criteriaGubre.addOrder(Order.asc("gubreTescilAdi"));
		return criteriaGubre.list();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.GubreDAO#gubreGetir(long)
	 */
	@Override
	@Transactional
	public Gubre gubreGetir(long id) {
		Gubre gubre = (Gubre) sessionFactory.getCurrentSession().load(
				Gubre.class, id);
		gubre.getId();

		return gubre;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.GubreDAO#gubreSil(long)
	 */
	@Override
	@Transactional
	public void gubreSil(long id) {
		sessionFactory.getCurrentSession().delete(gubreGetir(id));
	}

}
