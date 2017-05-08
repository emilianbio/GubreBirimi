package dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import models.Isyeri;

@Repository
public class IsyeriDAOImpl implements IsyeriDAO {
	@Autowired
	SessionFactory sessionFactory;

	@Override
	@Transactional
	public void isyeriEkle(Isyeri isyeri) {

		sessionFactory.getCurrentSession().saveOrUpdate(isyeri);

		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.IsyeriDAO#isyeriListesi()
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Isyeri> isyeriListesi() {
		Criteria criteriaIsyeri = sessionFactory.getCurrentSession()
				.createCriteria(Isyeri.class);

		criteriaIsyeri.addOrder(Order.asc("isyeriAdi"));

		return criteriaIsyeri.list();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.IsyeriDAO#isyeriGetir(java.lang.Long)
	 */
	@Override
	@Transactional
	public Isyeri isyeriGetir(Long id) {

		Isyeri isYeri = (Isyeri) sessionFactory.getCurrentSession().load(
				Isyeri.class, id);
		isYeri.getId();

		// TODO Auto-generated method stub
		return isYeri;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.IsyeriDAO#isyeriSil(java.lang.Long)
	 */
	@Override
	@Transactional
	public void isyeriSil(long id) {
		sessionFactory.getCurrentSession().delete(isyeriGetir(id));

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.IsyeriDAO#isyeriListesi(java.lang.String)
	 */
	@Override
	@Transactional
	public List<Isyeri> isyeriListesi(String searchString) {
		Criteria criteriaDemirbas = sessionFactory.getCurrentSession()
				.createCriteria(Isyeri.class);
		criteriaDemirbas.createAlias("ilce", "ilce");

		criteriaDemirbas
				.add((Restrictions.disjunction().add(Restrictions
						.or(Restrictions.ilike("ilce.isim", "%" + searchString
								+ "%"))
						.add(Restrictions.ilike("vergiNo", "%" + searchString
								+ "%"))
						.add(Restrictions.ilike("yetkiliAdiSoyadi", "%"
								+ searchString + "%"))
						.add(Restrictions.ilike("sorumluAdiSoyadi", "%"
								+ searchString + "%"))
						.add(Restrictions.ilike("isyeriAdi", "%" + searchString
								+ "%"))
						.add(Restrictions.ilike("depoAdresi", "%"
								+ searchString + "%"))
						.add(Restrictions.ilike("isyeriAdresi", "%"
								+ searchString + "%"))
						.add(Restrictions.ilike("mersisNo", "%" + searchString
								+ "%"))
						.add(Restrictions.ilike("eMail", "%" + searchString
								+ "%"))
				// .add(Restrictions.like("uretici.lisansNo",
				// Integer.valueOf(searchString)))

						)));

		// Session session = sessionFactory.getCurrentSession();
		// Query criteriaDemirbas = session
		// .createQuery("from NumuneAlmaTutanagi where lower(il) like :x or lower(ilce) like  :x or lower(gubre.gubreAmbalajBuyuklugu )like :x or lower(gubre.gubreIcerigi )like :x or lower(gubre.gubrePartiNo ) like :x or lower(gubre.gubreTescilAdi) like :x or lower(gubre.gubreTescilNo) like :x or lower(gubre.gubreTipAdi) like :x or lower(gubre.gubreTicariAdi) like :x or il like :x or ilce like  :x or gubre.gubreAmbalajBuyuklugu like :x or gubre.gubreIcerigi like :x or gubre.gubrePartiNo like :x or gubre.gubreTescilAdi like :x or gubre.gubreTescilNo like :x or gubre.gubreTipAdi like :x or gubre.gubreTicariAdi like :x"
		// );
		// criteriaDemirbas.setParameter("x", "%" + searchString + "%");

		@SuppressWarnings("unchecked")
		List<Isyeri> sonuc = criteriaDemirbas.list();
		return sonuc;
	}

}
