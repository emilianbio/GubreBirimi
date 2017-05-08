/**
 * 
 */
package dao;

import java.util.List;

import models.Gubre;

/**
 * @author Emrah Denizer
 *
 */
public interface GubreDAO {
	public void gubreEkle(Gubre gubre);

	public List<Gubre> gubreListesi();

	public Gubre gubreGetir(long id);

	public void gubreSil(long id);
}
