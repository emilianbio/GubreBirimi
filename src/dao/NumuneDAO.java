/**
 * 
 */
package dao;

import java.util.List;

import models.NumuneAlmaTutanagi;

/**
 * @author Emrah Denizer
 *
 */

public interface NumuneDAO {
	public void numuneEkle(NumuneAlmaTutanagi numune);

	public List<NumuneAlmaTutanagi> numuneList();

	public List<NumuneAlmaTutanagi> numuneList(String searchString);

	public NumuneAlmaTutanagi numuneGetir(long id);

	public Long sonNumuneKoduGetir();
	
	public void numuneSil(long id);

}
