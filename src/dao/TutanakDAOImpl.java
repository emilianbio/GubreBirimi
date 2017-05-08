package dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import models.Tutanak;

@Repository
public class TutanakDAOImpl implements TutanakDAO {
	@Autowired
	SessionFactory sessinFactory;

	@Override
	public void tutanakEkle(Tutanak tutanak) {

		sessinFactory.getCurrentSession().saveOrUpdate(tutanak);

		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.TutanakDAO#tutanakListesi()
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Tutanak> tutanakListesi() {
		Criteria criteriaTutanak = sessinFactory.getCurrentSession()
				.createCriteria(Tutanak.class);
		criteriaTutanak.addOrder(Order.desc("eklemezamani"));
		return criteriaTutanak.list();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.TutanakDAO#tutanakGetir(long)
	 */
	@Override
	public Tutanak tutanakGetir(long id) {
		Tutanak tutanak = (Tutanak) sessinFactory.getCurrentSession().load(
				Tutanak.class, id);
		tutanak.getId();

		return tutanak;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.TutanakDAO#tutanakSil(long)
	 */
	@Override
	public void tutanakSil(long id) {
		sessinFactory.getCurrentSession().delete(tutanakGetir(id));
	}

}
