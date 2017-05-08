package dao;

import java.util.List;

import models.Tutanak;

public interface TutanakDAO {
	public void tutanakEkle(Tutanak tutanak);

	public List<Tutanak> tutanakListesi();

	public Tutanak tutanakGetir(long id);

	public void tutanakSil(long id);
}
