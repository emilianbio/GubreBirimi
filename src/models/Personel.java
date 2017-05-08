package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "personel", schema = "public")
public class Personel implements java.io.Serializable {
	private static final long serialVersionUID = 4418029727139184238L;

	@Id
	@Column(name = "id")
	@SequenceGenerator(name = "tabloSequnce", sequenceName = "personel_id_seq")
	@GeneratedValue(generator = "tabloSequnce")
	private long id;

	@Column(name = "denetci_no")
	private int denetciNo;

	@Column(name = "adi")
	private String adi;

	@Column(name = "soyadi")
	private String soyadi;

	@Column(name = "unvan")
	private String unvan;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getDenetciNo() {
		return denetciNo;
	}

	public void setDenetciNo(int denetciNo) {
		this.denetciNo = denetciNo;
	}

	public String getAdi() {
		return adi;
	}

	public void setAdi(String adi) {
		this.adi = adi;
	}

	public String getSoyadi() {
		return soyadi;
	}

	public void setSoyadi(String soyadi) {
		this.soyadi = soyadi;
	}

	public String getUnvan() {
		return unvan;
	}

	public void setUnvan(String unvan) {
		this.unvan = unvan;
	}
	
	
	
}
