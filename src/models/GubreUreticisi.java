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
@Table(name = "gubre_ureticisi", schema = "public")
public class GubreUreticisi implements Serializable {

	private static final long serialVersionUID = -8643005225609186076L;
	@Id
	@Column(name = "id")
	@SequenceGenerator(name = "tabloSequnce", sequenceName = "gubre_ureticisi_id_seq")
	@GeneratedValue(generator = "tabloSequnce")
	private long id;

	@Column(name = "uretici_adi")
	private String ureticiAdi;

	@Column(name = "lisans_no")
	private String lisansNo;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "eklemezamani")
	private Date eklemezamani;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUreticiAdi() {
		return ureticiAdi;
	}

	public void setUreticiAdi(String ureticiAdi) {
		this.ureticiAdi = ureticiAdi;
	}

	public String getLisansNo() {
		return lisansNo;
	}

	public void setLisansNo(String lisansNo) {
		this.lisansNo = lisansNo;
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
