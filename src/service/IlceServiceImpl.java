/**
 * 
 */
package service;

import java.util.List;

import models.Ilce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.IlceDAO;

/**
 * @author Emrah Denizer
 *
 */
@Service
public class IlceServiceImpl implements IlceService {
	@Autowired
	private IlceDAO ilceDAO;

	/*
	 * (non-Javadoc)
	 * 
	 * @see service.IlceService#ilceEkle(models.Ilce)
	 */
	@Override
	public void ilceEkle(Ilce ilce) {
		// TODO Auto-generated method stub
		ilceDAO.ilceEkle(ilce);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see service.IlceService#ilceListesi()
	 */
	@Override
	public List<Ilce> ilceListesi() {
		// TODO Auto-generated method stub

		return ilceDAO.ilceListesi();
	}

	/* (non-Javadoc)
	 * @see service.IlceService#ilceGetir(long)
	 */
	@Override
	public Ilce ilceGetir(long id) {
		// TODO Auto-generated method stub
		return ilceDAO.ilceGetir(id);
	}
}
