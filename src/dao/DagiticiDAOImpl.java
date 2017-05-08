package dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import models.Dagitici;

@Repository
public class DagiticiDAOImpl implements DagiticiDAO {
	@Autowired
	SessionFactory sessionFactory;

	@Override
	@Transactional
	public void dagiticiEkle(Dagitici dagitici) {

		sessionFactory.getCurrentSession().saveOrUpdate(dagitici);

		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.DagiticiDAO#dagiticiListesi()
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Dagitici> dagiticiListesi() throws ObjectNotFoundException {
		Session session = sessionFactory.openSession();

		Criteria criteriaDagiti = session.createCriteria(Dagitici.class);
		criteriaDagiti.addOrder(Order.desc("belgeNo"));
		criteriaDagiti.add(Restrictions.eq("durum", true));

		List<Dagitici> liste = criteriaDagiti.list();
		System.out.println("liste: " + liste);

		try {

			if (liste != null) {

				return liste;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return null;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.DagiticiDAO#dagiticiGetir(java.lang.Long)
	 */
	@Override
	@Transactional
	public Dagitici dagiticiGetir(Long id) {

		Dagitici dagitici = (Dagitici) sessionFactory.getCurrentSession().load(Dagitici.class, id);
		dagitici.getId();

		return dagitici;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.DagiticiDAO#sonDagiticiBelgeNo()
	 */
	@Override
	@Transactional
	public long sonDagiticiBelgeNo() {
		Criteria crt = sessionFactory.getCurrentSession().createCriteria(Dagitici.class);

		int sonuc = 0;
		try {
			crt.add(Restrictions.eq("durum", true));
			crt.setProjection(Projections.max("belgeNo"));
			crt.setMaxResults(1);
			sonuc = (int) crt.uniqueResult();

			System.out.println("son belge no: " + crt.uniqueResult());

		} catch (Exception e) {
			System.out.println("son belge no hata : " + crt.uniqueResult());
			return (long) 0;
		}
		return (long) sonuc;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.DagiticiDAO#dagiticiSil(long)
	 */
	@Override
	@Transactional
	public void dagiticiSil(long id) {
		sessionFactory.getCurrentSession().delete(dagiticiGetir(id));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.DagiticiDAO#dagiticiBul(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Dagitici> dagiticiBul(String searchString) {
		Criteria criteriaDemirbas = sessionFactory.getCurrentSession().createCriteria(Dagitici.class);
		criteriaDemirbas.createAlias("isyeri", "isyeri");

		criteriaDemirbas.add((Restrictions.disjunction()
				.add(Restrictions.or(Restrictions.ilike("isyeri.isyeriAdi", "%" + searchString + "%"))
						.add(Restrictions.ilike("isyeri.isyeriAdresi", "%" + searchString + "%"))
						.add(Restrictions.ilike("isyeri.depoAdresi", "%" + searchString + "%"))
						.add(Restrictions.ilike("isyeri.eMail", "%" + searchString + "%"))
						.add(Restrictions.ilike("isyeri.sorumluAdiSoyadi", "%" + searchString + "%"))
						.add(Restrictions.ilike("isyeri.vergiNo", "%" + searchString + "%"))
						.add(Restrictions.ilike("isyeri.yetkiliAdiSoyadi", "%" + searchString + "%"))

		)));
		return criteriaDemirbas.list();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.DagiticiDAO#ilceyeGoreDagiticiListesi(long)
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Dagitici> ilceyeGoreDagiticiListesi(long ilceID) {
		Criteria criteriaDagitici = sessionFactory.getCurrentSession().createCriteria(Dagitici.class);
		criteriaDagitici.createAlias("isyeri", "isyeri");
		criteriaDagitici.add(Restrictions.eq("isyeri.ilce.id", ilceID));
		return criteriaDagitici.list();
	}
}
