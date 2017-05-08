/**
 * 
 */
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
@Table(name = "gubre", schema = "public")
public class Gubre implements Serializable {

	private static final long serialVersionUID = 2668861713459107527L;

	@Id
	@Column(name = "id")
	@SequenceGenerator(name = "tableSequnce", sequenceName = "gubre_id_seq")
	@GeneratedValue(generator = "tableSequnce")
	private long id;
	
	
	@Column(name = "gubre_ticari_adi")
	private String gubreTicariAdi;

	@Column(name = "gubre_tip_ismi")
	private String gubreTipAdi;

	@Column(name = "gubre_tescil_ismi")
	private String gubreTescilAdi;

	@Column(name = "gubre_tescil_no")
	private String gubreTescilNo;

	@Column(name = "gubre_parti_no")
	private String gubrePartiNo;

	@Column(name = "gubre_ambalaj_buyukulugu")
	private String gubreAmbalajBuyuklugu;

	@Column(name = "gubre_icerigi")
	private String gubreIcerigi;

	@Column(name = "gubre_uretim_tarihi")
	private String gubreUretimTarihi;

	@Column(name = "gubre_sonkullanma_tarihi")
	private String gubreSonKullanmaTarihi;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "eklemezamani")
	private Date eklemezamani;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getGubreTicariAdi() {
		return gubreTicariAdi;
	}

	public void setGubreTicariAdi(String gubreTicariAdi) {
		this.gubreTicariAdi = gubreTicariAdi;
	}

	public String getGubreTipAdi() {
		return gubreTipAdi;
	}

	public void setGubreTipAdi(String gubreTipAdi) {
		this.gubreTipAdi = gubreTipAdi;
	}

	public String getGubreTescilAdi() {
		return gubreTescilAdi;
	}

	public void setGubreTescilAdi(String gubreTescilAdi) {
		this.gubreTescilAdi = gubreTescilAdi;
	}

	public String getGubreTescilNo() {
		return gubreTescilNo;
	}

	public void setGubreTescilNo(String gubreTescilNo) {
		this.gubreTescilNo = gubreTescilNo;
	}

	public String getGubrePartiNo() {
		return gubrePartiNo;
	}

	public void setGubrePartiNo(String gubrePartiNo) {
		this.gubrePartiNo = gubrePartiNo;
	}

	public String getGubreAmbalajBuyuklugu() {
		return gubreAmbalajBuyuklugu;
	}

	public void setGubreAmbalajBuyuklugu(String gubreAmbalajBuyuklugu) {
		this.gubreAmbalajBuyuklugu = gubreAmbalajBuyuklugu;
	}

	public String getGubreIcerigi() {
		return gubreIcerigi;
	}

	public void setGubreIcerigi(String gubreIcerigi) {
		this.gubreIcerigi = gubreIcerigi;
	}

	public String getGubreUretimTarihi() {
		return gubreUretimTarihi;
	}

	public void setGubreUretimTarihi(String gubreUretimTarihi) {
		this.gubreUretimTarihi = gubreUretimTarihi;
	}

	public String getGubreSonKullanmaTarihi() {
		return gubreSonKullanmaTarihi;
	}

	public void setGubreSonKullanmaTarihi(String gubreSonKullanmaTarihi) {
		this.gubreSonKullanmaTarihi = gubreSonKullanmaTarihi;
	}

	/**
	 * @return the eklemezamani
	 */
	public Date getEklemezamani() {
		return eklemezamani;
	}

	/**
	 * @param eklemezamani the eklemezamani to set
	 */
	public void setEklemezamani(Date eklemezamani) {
		this.eklemezamani = eklemezamani;
	}

}
