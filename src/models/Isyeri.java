package models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
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
@Table(name = "isyerleri", schema = "public")
public class Isyeri implements Serializable {
	private static final long serialVersionUID = 4418029727139184238L;
	@Id
	@Column(name = "id")
	@SequenceGenerator(name = "tabloSequnce", sequenceName = "isyerleri_id_seq")
	@GeneratedValue(generator = "tabloSequnce")
	private long id;

	@Column(name = "vergi_no")
	private String vergiNo;

	@Column(name = "yetkili_adi_soyadi")
	private String yetkiliAdiSoyadi;

	@Column(name = "sorumlu_yonetici_adi_soyadi")
	private String sorumluAdiSoyadi;

	@Column(name = "isyeri_adi")
	private String isyeriAdi;

	@Column(name = "depo_adresi")
	private String depoAdresi;

	@Column(name = "isyeri_adresi")
	private String isyeriAdresi;

	@Column(name = "mersis_no")
	private String mersisNo;

	@Column(name = "e_mail")
	private String eMail;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "eklemezamani")
	private Date eklemezamani;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ilce_id")
	private Ilce ilce;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getVergiNo() {
		return vergiNo;
	}

	public void setVergiNo(String vergiNo) {
		this.vergiNo = vergiNo;
	}

	public String getYetkiliAdiSoyadi() {
		return yetkiliAdiSoyadi;
	}

	public void setYetkiliAdiSoyadi(String yetkiliAdiSoyadi) {
		this.yetkiliAdiSoyadi = yetkiliAdiSoyadi;
	}

	public String getSorumluAdiSoyadi() {
		return sorumluAdiSoyadi;
	}

	public void setSorumluAdiSoyadi(String sorumluAdiSoyadi) {
		this.sorumluAdiSoyadi = sorumluAdiSoyadi;
	}

	public String getIsyeriAdi() {
		return isyeriAdi;
	}

	public void setIsyeriAdi(String isyeriAdi) {
		this.isyeriAdi = isyeriAdi;
	}

	/**
	 * @return the depoAdresi
	 */
	public String getDepoAdresi() {
		return depoAdresi;
	}

	/**
	 * @param depoAdresi
	 *            the depoAdresi to set
	 */
	public void setDepoAdresi(String depoAdresi) {
		this.depoAdresi = depoAdresi;
	}

	/**
	 * @return the isyeriAdresi
	 */
	public String getIsyeriAdresi() {
		return isyeriAdresi;
	}

	/**
	 * @param isyeriAdresi
	 *            the isyeriAdresi to set
	 */
	public void setIsyeriAdresi(String isyeriAdresi) {
		this.isyeriAdresi = isyeriAdresi;
	}

	/**
	 * @return the mersisNo
	 */
	public String getMersisNo() {
		return mersisNo;
	}

	/**
	 * @param mersisNo
	 *            the mersisNo to set
	 */
	public void setMersisNo(String mersisNo) {
		this.mersisNo = mersisNo;
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
	 * @return the eMail
	 */
	public String geteMail() {
		return eMail;
	}

	/**
	 * @param eMail
	 *            the eMail to set
	 */
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	/**
	 * @return the eklemezamani
	 */
	public Date getEklemezamani() {
		return eklemezamani;
	}

	/**
	 * @param eklemezamani
	 *            the eklemezamani to set
	 */
	public void setEklemezamani(Date eklemezamani) {
		this.eklemezamani = eklemezamani;
	}

}
