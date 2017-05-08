/**
 * 
 */
package service;

import java.util.List;

import models.NumuneAlmaTutanagi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.NumuneDAO;

/**
 * @author Emrah Denizer
 *
 */
@Service
public class NumuneServiceImpl implements NumuneService {

	@Autowired
	NumuneDAO numuneDAO;

	@Override
	public void numuneEkle(NumuneAlmaTutanagi numune) {
		numuneDAO.numuneEkle(numune);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see service.NumuneService#numuneList()
	 */
	@Override
	public List<NumuneAlmaTutanagi> numuneList() {
		// TODO Auto-generated method stub
		return numuneDAO.numuneList();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see service.NumuneService#numuneList(java.lang.String)
	 */
	@Override
	public List<NumuneAlmaTutanagi> numuneList(String searchString) {
		// TODO Auto-generated method stub
		return numuneDAO.numuneList(searchString);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see service.NumuneService#sonNumuneKoduGetir()
	 */
	@Override
	public Long sonNumuneKoduGetir() {
		// TODO Auto-generated method stub
		return numuneDAO.sonNumuneKoduGetir();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see service.NumuneService#numuneGetir(long)
	 */
	@Override
	public NumuneAlmaTutanagi numuneGetir(long id) {
		// TODO Auto-generated method stub
		return numuneDAO.numuneGetir(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see service.NumuneService#numuneSil(long)
	 */
	@Override
	public void numuneSil(long id) {
		numuneDAO.numuneSil(id);
	}

}
