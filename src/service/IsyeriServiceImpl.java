/**
 * 
 */
package service;

import java.util.List;

import models.Isyeri;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.IsyeriDAO;

/**
 * @author Emrah Denizer
 *
 */
@Service
public class IsyeriServiceImpl implements IsyeriService {
	@Autowired
	IsyeriDAO isyeriDAO;

	@Override
	public void isyeriEkle(Isyeri isyeri) {
		isyeriDAO.isyeriEkle(isyeri);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see service.IsyeriService#isyeriListesi()
	 */
	@Override
	public List<Isyeri> isyeriListesi() {
		// TODO Auto-generated method stub
		return isyeriDAO.isyeriListesi();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see service.IsyeriService#isyeriGetir(java.lang.Long)
	 */
	@Override
	public Isyeri isyeriGetir(Long id) {
		// TODO Auto-generated method stub
		return isyeriDAO.isyeriGetir(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see service.IsyeriService#isyeriSil(java.lang.Long)
	 */
	@Override
	public void isyeriSil(long id) {
		isyeriDAO.isyeriSil(id);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see service.IsyeriService#isyeriListesi(java.lang.String)
	 */
	@Override
	public List<Isyeri> isyeriListesi(String searchString) {
		// TODO Auto-generated method stub
		return isyeriDAO.isyeriListesi(searchString);
	}

}
