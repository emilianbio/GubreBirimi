/**
 * 
 */
package dao;

import java.util.List;

import models.Ilce;

/**
 * @author Emrah Denizer
 *
 */
public interface IlceDAO {
	public void ilceEkle(Ilce ilce);

	public List<Ilce> ilceListesi();

	public Ilce ilceGetir(long id);

}
