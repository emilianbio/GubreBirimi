/**
 * 
 */
package dao;

import java.util.List;

import models.Il;

/**
 * @author Emrah Denizer
 *
 */
public interface IlDAO {
	public void isyeriEkle(Il il);

	public List<Il> ilListesi();
	
	public Il ilGetir(long id);

}
