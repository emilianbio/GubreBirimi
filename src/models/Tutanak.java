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
@Table(name = "tutanak", schema = "public")
public class Tutanak implements Serializable {
	private static final long serialVersionUID = 4418029727139184238L;
	@Id
	@Column(name = "id")
	@SequenceGenerator(name = "tabloSequnce", sequenceName = "tutanak_id_seq")
	@GeneratedValue(generator = "tabloSequnce")
	private long id;

	@ManyToOne
	@JoinColumn(name = "isyer_id")
	private Isyeri isyeri;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "denetim_tarihi")
	private Date denetimTarihi;

	@Column(name = "denetim_sekli")
	private String denetimSekli;

	@Column(name = "lisans_no")
	private int lisansNo;

	@Column(name = "tescil_no")
	private int tescilNo;

	@Column(name = "gubre_turu")
	private String gubreTuru;

	@Column(name = "tip_adi")
	private String tipAdi;

	@Column(name = "mensei")
	private String mensei;

	@Column(name = "numune")
	private String numune;

	@Column(name = "tescil_etiket")
	private String tescilEtiket;

	@Column(name = "analiz")
	private String analiz;

	@Column(name = "isyeri_sartlari")
	private String isyeriSartlari;

	@Column(name = "diger")
	private String diger;

	@Column(name = "tespit_edilen_eksiklikler")
	private String tespitEdilenEksiklikler;

	@Column(name = "aciklama")
	private String aciklama;

	@ManyToOne
	@JoinColumn(name = "denetci1_id")
	private Personel denetci1;

	@ManyToOne
	@JoinColumn(name = "denetci2_id")
	private Personel denetci2;

	@ManyToOne
	@JoinColumn(name = "denetlenen_bayi_id")
	private Isyeri denetlenenBayi;

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

	public Isyeri getIsyeri() {
		return isyeri;
	}

	public void setIsyeri(Isyeri isyeri) {
		this.isyeri = isyeri;
	}

	public Date getDenetimTarihi() {
		return denetimTarihi;
	}

	public void setDenetimTarihi(Date denetimTarihi) {
		this.denetimTarihi = denetimTarihi;
	}

	public String getDenetimSekli() {
		return denetimSekli;
	}

	public void setDenetimSekli(String denetimSekli) {
		this.denetimSekli = denetimSekli;
	}

	public int getLisansNo() {
		return lisansNo;
	}

	public void setLisansNo(int lisansNo) {
		this.lisansNo = lisansNo;
	}

	public int getTescilNo() {
		return tescilNo;
	}

	public void setTescilNo(int tescilNo) {
		this.tescilNo = tescilNo;
	}

	public String getGubreTuru() {
		return gubreTuru;
	}

	public void setGubreTuru(String gubreTuru) {
		this.gubreTuru = gubreTuru;
	}

	public String getTipAdi() {
		return tipAdi;
	}

	public void setTipAdi(String tipAdi) {
		this.tipAdi = tipAdi;
	}

	public String getMensei() {
		return mensei;
	}

	public void setMensei(String mensei) {
		this.mensei = mensei;
	}

	public String getNumune() {
		return numune;
	}

	public void setNumune(String numune) {
		this.numune = numune;
	}

	public String getTescilEtiket() {
		return tescilEtiket;
	}

	public void setTescilEtiket(String tescilEtiket) {
		this.tescilEtiket = tescilEtiket;
	}

	public String getAnaliz() {
		return analiz;
	}

	public void setAnaliz(String analiz) {
		this.analiz = analiz;
	}

	public String getIsyeriSartlari() {
		return isyeriSartlari;
	}

	public void setIsyeriSartlari(String isyeriSartlari) {
		this.isyeriSartlari = isyeriSartlari;
	}

	public String getDiger() {
		return diger;
	}

	public void setDiger(String diger) {
		this.diger = diger;
	}

	public String getTespitEdilenEksiklikler() {
		return tespitEdilenEksiklikler;
	}

	public void setTespitEdilenEksiklikler(String tespitEdilenEksiklikler) {
		this.tespitEdilenEksiklikler = tespitEdilenEksiklikler;
	}

	public String getAciklama() {
		return aciklama;
	}

	public void setAciklama(String aciklama) {
		this.aciklama = aciklama;
	}

	public Personel getDenetci1() {
		return denetci1;
	}

	public void setDenetci1(Personel denetci1) {
		this.denetci1 = denetci1;
	}

	public Personel getDenetci2() {
		return denetci2;
	}

	public void setDenetci2(Personel denetci2) {
		this.denetci2 = denetci2;
	}

	public Isyeri getDenetlenenBayi() {
		return denetlenenBayi;
	}

	public void setDenetlenenBayi(Isyeri denetlenenBayi) {
		this.denetlenenBayi = denetlenenBayi;
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
