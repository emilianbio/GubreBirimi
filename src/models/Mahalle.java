package models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Emrah Denizer
 *
 */
@Entity
@Table(name = "mahalle", schema = "public")
public class Mahalle implements Serializable {
	private static final long serialVersionUID = 4418029727139184238L;
	@Id
	@Column(name = "id")
	@SequenceGenerator(name = "tabloSequnce", sequenceName = "mahalle_id_seq")
	@GeneratedValue(generator = "tabloSequnce")
	private long id;

	@Column(name = "ilce_id")
	private Ilce ilce;

	@Column(name = "isim")
	private String isim;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "eklemezamani")
	private Date eklemeZamani;

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the ilce
	 */
	public Ilce getIlce() {
		return ilce;
	}

	/**
	 * @param ilce
	 *            the ilce to set
	 */
	public void setIlce(Ilce ilce) {
		this.ilce = ilce;
	}

	/**
	 * @return the isim
	 */
	public String getIsim() {
		return isim;
	}

	/**
	 * @param isim
	 *            the isim to set
	 */
	public void setIsim(String isim) {
		this.isim = isim;
	}

	/**
	 * @return the eklemeZamani
	 */
	public Date getEklemeZamani() {
		return eklemeZamani;
	}

	/**
	 * @param eklemeZamani
	 *            the eklemeZamani to set
	 */
	public void setEklemeZamani(Date eklemeZamani) {
		this.eklemeZamani = eklemeZamani;
	}

}
