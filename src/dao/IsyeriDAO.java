package dao;

import java.util.List;

import models.Isyeri;

public interface IsyeriDAO {
	public void isyeriEkle(Isyeri isyeri);

	public List<Isyeri> isyeriListesi();

	public Isyeri isyeriGetir(Long id);

	public void isyeriSil(long id);

	public List<Isyeri> isyeriListesi(String searchString);
}
