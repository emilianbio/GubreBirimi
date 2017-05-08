/**
 * 
 */
package service;

import java.util.List;

import models.Il;

/**
 * @author Emrah Denizer
 *
 */
public interface IlService {
	public void isyeriEkle(Il il);

	public List<Il> ilListesi();

	public Il ilGetir (long id);
}
