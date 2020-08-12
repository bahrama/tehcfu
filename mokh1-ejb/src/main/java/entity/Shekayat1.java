package entity;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
                                                        

import org.eclipse.persistence.annotations.Cache;
import org.eclipse.persistence.annotations.CacheCoordinationType;
import org.eclipse.persistence.annotations.CacheType;
@Entity
@Table(name="shekayat_tbl")
@Cache(type = CacheType.SOFT, coordinationType = CacheCoordinationType.INVALIDATE_CHANGED_OBJECTS, size = 1000000)
@NamedQueries({
	@NamedQuery(name="findAllShekayat" , query="SELECT a FROM Shekayat1 a ORDER BY a.shekayatId DESC"),
	@NamedQuery(name="findById" , query="SELECT u FROM Shekayat1 u WHERE u.shekayatId=:v_shekayatId"),
	@NamedQuery(name="findAllById2" , query="SELECT pp FROM Shekayat1 pp ORDER BY pp.shekayatId DESC"),

})
public class Shekayat1 implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "shekayat_id")
	private long shekayatId;


	@Column(name = "vahedeSenfiName", length = 100, nullable = true)
	private String vahedeSenfiName;
	@Column(name = "motesadiName", length = 100, nullable = true)
	private String motesadiName;
	@Column(name = "vahedeSenfiPhone", length = 100, nullable = true)
	private String vahedeSenfiPhone;
	@Column(name = "vahedeSenfiMobile", length = 100, nullable = true)
	private String vahedeSenfiMobile;
	@Column(name = "vahedeShenaseSenfi", length = 100, nullable = true)
	private String vahedeShenaseSenfi;
	@Column(name = "vahedeSenfiPostCode", length = 100, nullable = true)
	private String vahedeSenfiPostCode;
	@Column(name = "vahedeShenaseAddres", length = 500, nullable = true)
	private String vahedeShenaseAddres;
	@Column(name = "shekayatTitle", length = 100, nullable = true)
	private String shekayatTitle;
	@Column(name = "sharh", length = 5000, nullable = true , unique=true)
	private String sharh;
	
	//after shekayat
	@Column(name = "vaziat", length = 5000, nullable = true)
	private String vaziat;
	@Column(name = "tarikh", length = 100 , nullable = true)
	private String tarikh;
	@Column(name = "shomare" , nullable = true)
	private long shomare;
	@Column(name = "checkO", nullable = true)
	private boolean checkO;
	@Column(name="date" , nullable=true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	@Column(name = "picPath", length = 100 , nullable = true)
	private String picPath;
	@Column(name = "ssn_Path", length = 100 , nullable = true)
	private String shakiSsnPic;
	@Column(name = "shaki_Path", length = 100 , nullable = true)
	private String shakiKalaPic;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_shekayat")
	private MoblEntity shaki;
	@Column(name = "karshenasName", length = 100 , nullable = true)
	private String karshenasName;
	@Column(name="karshenas_date" , nullable=true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date karshenasDate;
	@Column(name = "karshenasi", length = 5000, nullable = true)
	private String karshenasi;
	@Column(name = "shakiDateHozor", length = 50, nullable = true)
	private String shakiDateHozor;
	@Column(name = "shakiTimeHozor", length = 50, nullable = true)
	private String shakiTimeHozor;
	@Column(name = "maraje", length = 100, nullable = true)
	private String maraje;
	
	public long getShekayatId() {
		return shekayatId;
	}
	public void setShekayatId(long shekayatId) {
		this.shekayatId = shekayatId;
	}

	
	
	public String getShakiSsnPic() {
		return shakiSsnPic;
	}
	public void setShakiSsnPic(String shakiSsnPic) {
		this.shakiSsnPic = shakiSsnPic;
	}
	public String getShakiKalaPic() {
		return shakiKalaPic;
	}
	public void setShakiKalaPic(String shakiKalaPic) {
		this.shakiKalaPic = shakiKalaPic;
	}
	public String getKarshenasName() {
		return karshenasName;
	}
	public void setKarshenasName(String karshenasName) {
		this.karshenasName = karshenasName;
	}
	public Date getKarshenasDate() {
		return karshenasDate;
	}
	public void setKarshenasDate(Date karshenasDate) {
		this.karshenasDate = karshenasDate;
	}
	public String getKarshenasi() {
		return karshenasi;
	}
	public void setKarshenasi(String karshenasi) {
		this.karshenasi = karshenasi;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public boolean isCheckO() {
		return checkO;
	}
	public void setCheckO(boolean checkO) {
		this.checkO = checkO;
	}

	public String getVahedeSenfiName() {
		return vahedeSenfiName;
	}
	public void setVahedeSenfiName(String vahedeSenfiName) {
		this.vahedeSenfiName = vahedeSenfiName;
	}
	public String getMotesadiName() {
		return motesadiName;
	}
	public void setMotesadiName(String motesadiName) {
		this.motesadiName = motesadiName;
	}
	public String getVahedeSenfiPhone() {
		return vahedeSenfiPhone;
	}
	public void setVahedeSenfiPhone(String vahedeSenfiPhone) {
		this.vahedeSenfiPhone = vahedeSenfiPhone;
	}
	public String getVahedeSenfiMobile() {
		return vahedeSenfiMobile;
	}
	public void setVahedeSenfiMobile(String vahedeSenfiMobile) {
		this.vahedeSenfiMobile = vahedeSenfiMobile;
	}
	public String getVahedeShenaseSenfi() {
		return vahedeShenaseSenfi;
	}
	public void setVahedeShenaseSenfi(String vahedeShenaseSenfi) {
		this.vahedeShenaseSenfi = vahedeShenaseSenfi;
	}
	public String getVahedeSenfiPostCode() {
		return vahedeSenfiPostCode;
	}
	public void setVahedeSenfiPostCode(String vahedeSenfiPostCode) {
		this.vahedeSenfiPostCode = vahedeSenfiPostCode;
	}
	public String getVahedeShenaseAddres() {
		return vahedeShenaseAddres;
	}
	public void setVahedeShenaseAddres(String vahedeShenaseAddres) {
		this.vahedeShenaseAddres = vahedeShenaseAddres;
	}
	public String getShekayatTitle() {
		return shekayatTitle;
	}
	public void setShekayatTitle(String shekayatTitle) {
		this.shekayatTitle = shekayatTitle;
	}
	public String getSharh() {
		return sharh;
	}
	public void setSharh(String sharh) {
		this.sharh = sharh;
	}

	public String getVaziat() {
		return vaziat;
	}
	public void setVaziat(String vaziat) {
		this.vaziat = vaziat;
	}
	
	

	public String getShakiDateHozor() {
		return shakiDateHozor;
	}
	public void setShakiDateHozor(String shakiDateHozor) {
		this.shakiDateHozor = shakiDateHozor;
	}
	public String getShakiTimeHozor() {
		return shakiTimeHozor;
	}
	public void setShakiTimeHozor(String shakiTimeHozor) {
		this.shakiTimeHozor = shakiTimeHozor;
	}
	public String getTarikh() {
		return tarikh;
	}
	public void setTarikh(String tarikh) {
		this.tarikh = tarikh;
	}
	public long getShomare() {
		return shomare;
	}
	public void setShomare(long shomare) {
		this.shomare = shomare;
	}
	

	public String getPicPath() {
		return picPath;
	}
	public void setPicPath(String picPath) {
		this.picPath = picPath;
	}
	
	
	
	public String getMaraje() {
		return maraje;
	}
	public void setMaraje(String maraje) {
		this.maraje = maraje;
	}
	public MoblEntity getShaki() {
		return shaki;
	}
	public void setShaki(MoblEntity shaki) {
		this.shaki = shaki;
	}
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Shekayat1))
			return false;
		Shekayat1 shekayat1=(Shekayat1) obj;
		return (shekayat1.shekayatId== this.shekayatId);
	}
	
	
}
