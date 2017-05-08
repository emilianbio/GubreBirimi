package models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Emrah Denizer
 *
 */
@Entity
@Table(name = "ilce", schema = "public")
public class Ilce implements Serializable {
	private static final long serialVersionUID = 4418029727139184238L;
	@Id
	@Column(name = "id")
	@SequenceGenerator(name = "tabloSequnce", sequenceName = "ilce_id_seq")
	@GeneratedValue(generator = "tabloSequnce")
	private long id;

	@ManyToOne
	@JoinColumn(name = "il_id")
	private Il il;

	@Column(name = "ilce_kodu")
	private int ilceKodu;

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
	 * @return the il
	 */
	public Il getIl() {
		return il;
	}

	/**
	 * @param il
	 *            the il to set
	 */
	public void setIl(Il il) {
		this.il = il;
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

	/**
	 * @return the ilceKodu
	 */
	public int getIlceKodu() {
		return ilceKodu;
	}

	/**
	 * @param ilceKodu
	 *            the ilceKodu to set
	 */
	public void setIlceKodu(int ilceKodu) {
		this.ilceKodu = ilceKodu;
	}

}
