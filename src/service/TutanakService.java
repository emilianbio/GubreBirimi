/**
 * 
 */
package service;

import java.util.List;

import models.Tutanak;

/**
 * @author Emrah Denizer
 *
 */
public interface TutanakService {
	public void tutanakEkle(Tutanak tutnaka);
	
	public List<Tutanak> tutanakListesi();

	public Tutanak tutanakGetir(long id);

	public void tutanakSil(long id);
}
