/**
 * 
 */
package service;

import java.util.List;

import models.Dagitici;

/**
 * @author Emrah Denizer
 *
 */

public interface DagiticiService {
	public void dagiticiEkle(Dagitici dagitici);

	public List<Dagitici> dagiticiListesi();

	public Dagitici dagiticiGetir(Long id);

	public long sonDagiticiBelgeNo();

	public void dagiticiSil(long id);
	
	public List<Dagitici> dagiticiBul(String searchString);
	
	public List<Dagitici> ilceyeGoreDagiticiListesi(long ilceID);
}
