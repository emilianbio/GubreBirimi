/**
 * 
 */
package service;

import java.util.List;

import models.Gubre;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.GubreDAO;

/**
 * @author Emrah Denizer
 *
 */
@Service
public class GubreServiceImpl implements GubreService {

	@Autowired
	GubreDAO gubreDAO;

	/*
	 * (non-Javadoc)
	 * 
	 * @see service.GubreService#gubreEkle(models.Gubre)
	 */
	@Override
	public void gubreEkle(Gubre gubre) {
		gubreDAO.gubreEkle(gubre);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see service.GubreService#gubreListesi()
	 */
	@Override
	public List<Gubre> gubreListesi() {
		// TODO Auto-generated method stub
		return gubreDAO.gubreListesi();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see service.GubreService#gubreGetir(long)
	 */
	@Override
	public Gubre gubreGetir(long id) {
		// TODO Auto-generated method stub
		return gubreDAO.gubreGetir(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see service.GubreService#gubreSil(long)
	 */
	@Override
	public void gubreSil(long id) {
		// TODO Auto-generated method stub
		gubreDAO.gubreSil(id);
	}

}
