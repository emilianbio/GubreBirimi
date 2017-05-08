/**
 * 
 */
package service;

import java.util.List;

import models.Ilce;

/**
 * @author Emrah Denizer
 *
 */
public interface IlceService {
	public void ilceEkle(Ilce ilce);

	public List<Ilce> ilceListesi();

	public Ilce ilceGetir(long id);
}
