/**
 * 
 */
package dao;

import java.util.List;

import models.GubreUreticisi;

/**
 * @author Emrah Denizer
 *
 */
public interface GubreUreticiDAO {
	public void gubreUreticiEkle(GubreUreticisi gubreUreticisi);

	public List<GubreUreticisi> ureticiList();

	public GubreUreticisi ureticiGetir(long id);

	public void ureticiSil(long id);

	public List<GubreUreticisi> ureticiList(String searchString);
}
