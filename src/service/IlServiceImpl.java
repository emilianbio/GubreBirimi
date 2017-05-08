/**
 * 
 */
package service;

import java.util.List;

import models.Il;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.IlDAO;

/**
 * @author Emrah Denizer
 *
 */
@Service
public class IlServiceImpl implements IlService {
	@Autowired
	private IlDAO ilDAO;

	/*
	 * (non-Javadoc)
	 * 
	 * @see service.IlService#isyeriEkle(models.Il)
	 */
	@Override
	public void isyeriEkle(Il il) {
		// TODO Auto-generated method stub
		ilDAO.isyeriEkle(il);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see service.IlService#isyeriListesi()
	 */
	@Override
	public List<Il> ilListesi() {
		// TODO Auto-generated method stub
		return ilDAO.ilListesi();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see service.IlService#ilGetir(long)
	 */
	@Override
	public Il ilGetir(long id) {
		// TODO Auto-generated method stub
		return ilDAO.ilGetir(id);
	}

}
