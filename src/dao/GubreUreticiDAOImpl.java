package dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import models.GubreUreticisi;

/**
 * @author Emrah Denizer
 *
 */
@Repository
public class GubreUreticiDAOImpl implements GubreUreticiDAO {
	@Autowired
	SessionFactory sessionFactory;

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.GubreUreticiDAO#gubreUreticiEkle(models.GubreUreticisi)
	 */
	@Override
	@Transactional
	public void gubreUreticiEkle(GubreUreticisi gubreUreticisi) {

		sessionFactory.getCurrentSession().saveOrUpdate(gubreUreticisi);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<GubreUreticisi> ureticiList() {
		Criteria criteriaUretici = sessionFactory.getCurrentSession()
				.createCriteria(GubreUreticisi.class);
		criteriaUretici.addOrder(Order.asc("ureticiAdi"));
		// criteriaUretici.setProjection(Projections.property("ureticiAdi"));
		// criteriaUretici.add(Restrictions.isNull("ureticiAdi"));

		return criteriaUretici.list();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.GubreUreticiDAO#ureticiGetir(long)
	 */
	@Override
	@Transactional
	public GubreUreticisi ureticiGetir(long id) {
		GubreUreticisi uretici = (GubreUreticisi) sessionFactory
				.getCurrentSession().load(GubreUreticisi.class, id);

		uretici.getId();
		return uretici;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.GubreUreticiDAO#ureticiSil(long)
	 */
	@Override
	@Transactional
	public void ureticiSil(long id) {

		sessionFactory.getCurrentSession().delete(ureticiGetir(id));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.GubreUreticiDAO#ureticiList(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<GubreUreticisi> ureticiList(String searchString) {
		Criteria criteriaUretici = sessionFactory.getCurrentSession()
				.createCriteria(GubreUreticisi.class);

		criteriaUretici.add((Restrictions.disjunction().add(Restrictions.or(
				Restrictions.ilike("lisansNo", "%" + searchString + "%")).add(
				Restrictions.ilike("ureticiAdi", "%" + searchString + "%")))));
		return criteriaUretici.list();
	}
}
