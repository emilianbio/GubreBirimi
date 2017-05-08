/**
 * 
 */
package service;

import java.util.List;

import models.GubreUreticisi;

/**
 * @author Emrah Denizer
 *
 */
public interface GubreUreticiService {
	public void gubreUreticiEkle(GubreUreticisi gubreUreticisi);

	public List<GubreUreticisi> gubreUreticiList();

	public GubreUreticisi ureticiGetir(long id);

	public void ureticiSil(long id);
	
	public List<GubreUreticisi> ureticiList(String searchString);
}
