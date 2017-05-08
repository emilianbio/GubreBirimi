/**
 * 
 */
package service;

import java.util.List;

import models.Dagitici;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.DagiticiDAO;

/**
 * @author Emrah Denizer
 *
 */
@Service
public class DagiticiServiceImpl implements DagiticiService {
	@Autowired
	DagiticiDAO dagiticiDAO;

	@Override
	public void dagiticiEkle(Dagitici dagitici) {
		dagiticiDAO.dagiticiEkle(dagitici);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see service.DagiticiService#dagiticiListesi()
	 */
	@Override
	public List<Dagitici> dagiticiListesi() {
		// TODO Auto-generated method stub
		return dagiticiDAO.dagiticiListesi();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see service.DagiticiService#dagiticiGetir(java.lang.Long)
	 */
	@Override
	public Dagitici dagiticiGetir(Long id) {
		// TODO Auto-generated method stub
		return dagiticiDAO.dagiticiGetir(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see service.DagiticiService#sonDagiticiBelgeNo()
	 */
	@Override
	public long sonDagiticiBelgeNo() {
		// TODO Auto-generated method stub
		return dagiticiDAO.sonDagiticiBelgeNo();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see service.DagiticiService#dagiticiSil(long)
	 */
	@Override
	public void dagiticiSil(long id) {
		dagiticiDAO.dagiticiSil(id);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see service.DagiticiService#dagiticiBul(java.lang.String)
	 */
	@Override
	public List<Dagitici> dagiticiBul(String searchString) {
		// TODO Auto-generated method stub
		return dagiticiDAO.dagiticiBul(searchString);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see service.DagiticiService#ilceyeGoreDagiticiListesi(long)
	 */
	@Override
	public List<Dagitici> ilceyeGoreDagiticiListesi(long ilceID) {
		// TODO Auto-generated method stub
		return dagiticiDAO.ilceyeGoreDagiticiListesi(ilceID);
	}

}
