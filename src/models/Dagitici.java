/**
 * 
 */
package models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author Emrah Denizer
 *
 */
@Entity
@Table(name = "dagiticilik_belgesi", schema = "public")
public class Dagitici implements Serializable {

	private static final long serialVersionUID = -1067426615461817030L;

	@Id
	@GeneratedValue(generator = "tableSequnce")
	@SequenceGenerator(name = "tableSequnce", sequenceName = "dagiticilik_belgesi_id_seq")
	@Column
	public long id;

	@Column(name = "belge_no")
	public int belgeNo;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "duzeltme_tarihi")
	public Date duzeltmeTarihi;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "isyeri_id")
	public Isyeri isyeri;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "eklemezamani")
	public Date eklemeZamani;

	@Column(name = "durum")
	public Boolean durum;

	/**
	 * @return the durum
	 */
	public Boolean getDurum() {
		return durum;
	}

	/**
	 * @param durum
	 *            the durum to set
	 */
	public void setDurum(Boolean durum) {
		this.durum = durum;
	}

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
	 * @return the belgeNo
	 */
	public int getBelgeNo() {
		return belgeNo;
	}

	/**
	 * @param belgeNo
	 *            the belgeNo to set
	 */
	public void setBelgeNo(int belgeNo) {
		this.belgeNo = belgeNo;
	}

	/**
	 * @return the duzeltmeTarihi
	 */
	public Date getDuzeltmeTarihi() {
		return duzeltmeTarihi;
	}

	/**
	 * @param duzeltmeTarihi
	 *            the duzeltmeTarihi to set
	 */
	public void setDuzeltmeTarihi(Date duzeltmeTarihi) {
		this.duzeltmeTarihi = duzeltmeTarihi;
	}

	/**
	 * @return the isyeri
	 */
	public Isyeri getIsyeri() {

		// if (isyeri == null) {
		// isyeri = new Isyeri();
		// System.out.println("dagitici model null: ");
		// isyeri.setId(0);
		// } else {
		//
		// System.out.println("dagitici model notNull: " + isyeri);
		// }
		return isyeri;
	}

	/**
	 * @param isyeri
	 *            the isyeri to set
	 */
	public void setIsyeri(Isyeri isyeri) {
		this.isyeri = isyeri;
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
