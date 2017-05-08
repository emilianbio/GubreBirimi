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
@Table(name = "numune_tablosu", schema = "public")
public class NumuneAlmaTutanagi implements Serializable {

	private static final long serialVersionUID = -2831105259593730961L;

	@Id
	@Column(name = "id")
	@SequenceGenerator(name = "tabloSequnce", sequenceName = "numune_tablosu_id_seq")
	@GeneratedValue(generator = "tabloSequnce")
	private long id;

	@Column(name = "denetim_sekli")
	private String denetimSekli;

	@ManyToOne
	@JoinColumn(name = "il")
	private Il il;

	@ManyToOne
	@JoinColumn(name = "ilce")
	private Ilce ilce;

	@Column(name = "numune_kodu")
	private long numuneKodu;

	@ManyToOne
	@JoinColumn(name = "uretici_id")
	private GubreUreticisi gubreUretici;

	@ManyToOne
	@JoinColumn(name = "gubre_id")
	private Gubre gubre;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "numune_alma_tarihi")
	private Date numuneAlmaTarihi;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "eklemezamani")
	private Date eklemezamani;

	@Column(name = "durum")
	private Boolean durum;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDenetimSekli() {
		return denetimSekli;
	}

	public void setDenetimSekli(String denetimSekli) {
		this.denetimSekli = denetimSekli;
	}

	public GubreUreticisi getGubreUretici() {
		return gubreUretici;
	}

	public void setGubreUretici(GubreUreticisi gubreUretici) {
		this.gubreUretici = gubreUretici;
	}

	public Gubre getGubre() {
		return gubre;
	}

	public void setGubre(Gubre gubre) {
		this.gubre = gubre;
	}

	public Date getNumuneAlmaTarihi() {
		return numuneAlmaTarihi;
	}

	public void setNumuneAlmaTarihi(Date numuneAlmaTarihi) {
		this.numuneAlmaTarihi = numuneAlmaTarihi;
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
	 * @return the numuneKodu
	 */
	public long getNumuneKodu() {
		return numuneKodu;
	}

	/**
	 * @param numuneKodu
	 *            the numuneKodu to set
	 */
	public void setNumuneKodu(long numuneKodu) {
		this.numuneKodu = numuneKodu;
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

}
