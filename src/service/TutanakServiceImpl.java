/**
 * 
 */
package service;

import java.util.List;

import models.Tutanak;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.TutanakDAO;

/**
 * @author Emrah Denizer
 *
 */
@Service
public class TutanakServiceImpl implements TutanakService {
	@Autowired
	TutanakDAO tutanakDAO;

	@Override
	public void tutanakEkle(Tutanak tutanak) {
		tutanakDAO.tutanakEkle(tutanak);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see service.TutanakService#tutanakListesi()
	 */
	@Override
	public List<Tutanak> tutanakListesi() {
		// TODO Auto-generated method stub
		return tutanakDAO.tutanakListesi();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see service.TutanakService#tutanakGetir(long)
	 */
	@Override
	public Tutanak tutanakGetir(long id) {
		// TODO Auto-generated method stub
		return tutanakDAO.tutanakGetir(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see service.TutanakService#tutanakSil(long)
	 */
	@Override
	public void tutanakSil(long id) {
		// TODO Auto-generated method stub
		tutanakDAO.tutanakSil(id);
	}

}
