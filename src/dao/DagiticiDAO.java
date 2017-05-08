package dao;

import java.util.List;

import models.Dagitici;

public interface DagiticiDAO {
	public void dagiticiEkle(Dagitici dagitici);

	public List<Dagitici> dagiticiListesi();

	public Dagitici dagiticiGetir(Long id);

	public long sonDagiticiBelgeNo();

	public void dagiticiSil(long id);

	public List<Dagitici> dagiticiBul(String searchString);

	public List<Dagitici> ilceyeGoreDagiticiListesi(long ilceID);

}
