/**
 * 
 */
package service;

import java.util.List;

import models.Isyeri;

/**
 * @author Emrah Denizer
 *
 */
public interface IsyeriService {
	public void isyeriEkle(Isyeri isyeri);

	public List<Isyeri> isyeriListesi();
	
	public Isyeri isyeriGetir(Long id);
	
	public void isyeriSil(long id);
	
	public List<Isyeri> isyeriListesi(String searchString);
}
