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
@Table(name = "il", schema = "public")
public class Il implements Serializable {
	private static final long serialVersionUID = 4418029727139184238L;
	@Id
	@Column(name = "id")
	@SequenceGenerator(name = "tabloSequnce", sequenceName = "il_id_seq")
	@GeneratedValue(generator = "tabloSequnce")
	private long id;

	@Column(name = "isim")
	private String isim;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "eklemezamani")
	private Date eklemeZamani;

	@Column(name = "il_kodu")
	private String ilKodu;

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
	 * @return the ilKodu
	 */
	public String getIlKodu() {
		return ilKodu;
	}

	/**
	 * @param ilKodu
	 *            the ilKodu to set
	 */
	public void setIlKodu(String ilKodu) {
		this.ilKodu = ilKodu;
	}

}
