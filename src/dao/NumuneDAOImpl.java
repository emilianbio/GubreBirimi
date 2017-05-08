/**
 * 
 */
package dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import models.NumuneAlmaTutanagi;

/**
 * @author Emrah Denizer
 *
 */
@Repository
public class NumuneDAOImpl implements NumuneDAO {
	@Autowired
	SessionFactory sessionFactory;

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.NumuneDAO#numuneEkle(models.NumuneAlmaTutanagi)
	 */
	@Override
	@Transactional
	public void numuneEkle(NumuneAlmaTutanagi numune) {
		sessionFactory.getCurrentSession().saveOrUpdate(numune);

	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<NumuneAlmaTutanagi> numuneList() {
		Criteria criteriaDemirbas = sessionFactory.getCurrentSession().createCriteria(NumuneAlmaTutanagi.class);
		criteriaDemirbas.addOrder(Order.desc("id"));

		List<NumuneAlmaTutanagi> sonuc = criteriaDemirbas.list();
		// for (int i = 0; i < sonuc.size(); i++) {
		// System.out.println(sonuc.get(i).getNumuneKodu());
		// }

		return sonuc;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.NumuneDAO#numuneList(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<NumuneAlmaTutanagi> numuneList(String searchString) {
		Criteria criteriaDemirbas = sessionFactory.getCurrentSession().createCriteria(NumuneAlmaTutanagi.class);
		criteriaDemirbas.createAlias("gubre", "gubre");
		criteriaDemirbas.createAlias("gubreUretici", "uretici");
		criteriaDemirbas.createAlias("il", "il");
		criteriaDemirbas.createAlias("ilce", "ilce");
		criteriaDemirbas.add((Restrictions.disjunction()
				.add(Restrictions.or(Restrictions.ilike("il.isim", "%" + searchString + "%"))
						.add(Restrictions.ilike("ilce.isim", "%" + searchString + "%"))
						.add(Restrictions.ilike("denetimSekli", "%" + searchString + "%"))
						.add(Restrictions.ilike("gubre.gubreTicariAdi", "%" + searchString + "%"))
						.add(Restrictions.ilike("gubre.gubreIcerigi", "%" + searchString + "%"))
						.add(Restrictions.ilike("gubre.gubreAmbalajBuyuklugu", "%" + searchString + "%"))
						.add(Restrictions.ilike("gubre.gubrePartiNo", "%" + searchString + "%"))
						.add(Restrictions.ilike("gubre.gubreTescilAdi", "%" + searchString + "%"))
						.add(Restrictions.ilike("gubre.gubreTescilNo", "%" + searchString + "%"))
						.add(Restrictions.ilike("gubre.gubreTipAdi", "%" + searchString + "%"))
						.add(Restrictions.ilike("uretici.ureticiAdi", "%" + searchString + "%"))
		// .add(Restrictions.like("uretici.lisansNo",
		// Integer.valueOf(searchString)))

		)));
		System.out.println("criteriaDemirbas : " + criteriaDemirbas.list().size());
		// Session session = sessionFactory.getCurrentSession();
		// Query criteriaDemirbas = session
		// .createQuery("from NumuneAlmaTutanagi where lower(il) like :x or
		// lower(ilce) like :x or lower(gubre.gubreAmbalajBuyuklugu )like :x or
		// lower(gubre.gubreIcerigi )like :x or lower(gubre.gubrePartiNo ) like
		// :x or lower(gubre.gubreTescilAdi) like :x or
		// lower(gubre.gubreTescilNo) like :x or lower(gubre.gubreTipAdi) like
		// :x or lower(gubre.gubreTicariAdi) like :x or il like :x or ilce like
		// :x or gubre.gubreAmbalajBuyuklugu like :x or gubre.gubreIcerigi like
		// :x or gubre.gubrePartiNo like :x or gubre.gubreTescilAdi like :x or
		// gubre.gubreTescilNo like :x or gubre.gubreTipAdi like :x or
		// gubre.gubreTicariAdi like :x"
		// );
		// criteriaDemirbas.setParameter("x", "%" + searchString + "%");

		List<NumuneAlmaTutanagi> sonuc = criteriaDemirbas.list();

		if (sonuc.size() != 0) {

			return sonuc;
		} else
			// for (NumuneAlmaTutanagi r : sonuc) {
			// System.out.println(r.getGubre().getGubreTicariAdi()==null);
			// }

			return sonuc;
	}

	@Override
	@Transactional
	public Long sonNumuneKoduGetir() {

		Criteria crt = sessionFactory.getCurrentSession().createCriteria(NumuneAlmaTutanagi.class);
		// crt.addOrder(Order.desc("numuneKodu"));
		crt.setProjection(Projections.max("numuneKodu"));
		crt.setMaxResults(1);
		Long numuneKodu = (Long) crt.uniqueResult();
		return numuneKodu + 1;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.NumuneDAO#numuneGetir(long)
	 */
	@Override
	@Transactional
	public NumuneAlmaTutanagi numuneGetir(long id) {
		NumuneAlmaTutanagi numune = (NumuneAlmaTutanagi) sessionFactory.getCurrentSession()
				.load(NumuneAlmaTutanagi.class, id);
		numune.getId();

		return numune;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.NumuneDAO#numuneSil(long)
	 */
	@Override
	@Transactional
	public void numuneSil(long id) {
		sessionFactory.getCurrentSession().delete(numuneGetir(id));
	}
}
