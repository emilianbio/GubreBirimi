/**
 * 
 */
package service;

import java.util.List;

import models.GubreUreticisi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.GubreUreticiDAO;

/**
 * @author Emrah Denizer
 *
 */
@Service
public class GubreUreticiServiceImpl implements GubreUreticiService {
	@Autowired
	GubreUreticiDAO gubreUreticiDAO;

	/*
	 * (non-Javadoc)
	 * 
	 * @see service.GubreUreticiService#gubreUretiviEkle(models.GubreUreticisi)
	 */
	@Override
	public void gubreUreticiEkle(GubreUreticisi gubreUreticisi) {
		gubreUreticiDAO.gubreUreticiEkle(gubreUreticisi);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see service.GubreUreticiService#gubreUreticiList()
	 */
	@Override
	public List<GubreUreticisi> gubreUreticiList() {
		// TODO Auto-generated method stub
		return gubreUreticiDAO.ureticiList();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see service.GubreUreticiService#ureticiGetir(long)
	 */
	@Override
	public GubreUreticisi ureticiGetir(long id) {
		// TODO Auto-generated method stub
		return gubreUreticiDAO.ureticiGetir(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see service.GubreUreticiService#ureticiSil(long)
	 */
	@Override
	public void ureticiSil(long id) {
		gubreUreticiDAO.ureticiSil(id);
	}

	/* (non-Javadoc)
	 * @see service.GubreUreticiService#ureticiList(java.lang.String)
	 */
	@Override
	public List<GubreUreticisi> ureticiList(String searchString) {
		// TODO Auto-generated method stub
		return gubreUreticiDAO.ureticiList(searchString);
	}

}
