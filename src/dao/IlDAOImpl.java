/**
 * 
 */
package dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import models.Il;

/**
 * @author Emrah Denizer
 *
 */
@Repository
public class IlDAOImpl implements IlDAO {
	@Autowired
	SessionFactory sessionFactory;

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.IlDAO#isyeriEkle(models.Il)
	 */
	@Override
	@Transactional
	public void isyeriEkle(Il il) {
		sessionFactory.getCurrentSession().saveOrUpdate(il);
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.IlDAO#isyeriListesi()
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Il> ilListesi() {
		Criteria criteriaIl = (Criteria) sessionFactory.getCurrentSession()
				.createCriteria(Il.class);

		return criteriaIl.list();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.IlDAO#ilGetir(long)
	 */
	@SuppressWarnings("unused")
	@Override
	@Transactional
	public Il ilGetir(long id) {
		Session session = sessionFactory.openSession();
		Il il = (Il) sessionFactory.getCurrentSession().get(Il.class, id);
		il.getId();
		return il;
	}

}
