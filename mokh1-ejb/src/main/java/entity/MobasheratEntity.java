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
@Table(name="mobasherat_tbl")
@Cache(type = CacheType.SOFT, coordinationType = CacheCoordinationType.INVALIDATE_CHANGED_OBJECTS, size = 1000000)
@NamedQueries({
	@NamedQuery(name="findAllMobasherat" , query="SELECT a FROM MobasheratEntity a ORDER BY a.id DESC"),
	@NamedQuery(name="findMobasheratById" , query="SELECT i FROM MobasheratEntity i WHERE i.id=:v_mobasherId"),
})
public class MobasheratEntity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "mobasherat_id")
	private long id;
	@Column(name = "mobasher_name", length = 50, nullable = true)
	private String mobasherName;
	@Column(name = "name_pedar", length = 20, nullable = true)
	private String namePedar;
	@Column(name = "shenasname", length = 14, nullable = true)
	private String shenasname;
	@Column(name = "sodor", length = 20, nullable = true)
	private String sodor;
	@Column(name = "tarikh_tavalod", length = 50, nullable = true)
	private String tarikhTavalod;
	@Column(name = "mahale_tavalod", length = 50, nullable = true)
	private String mahaleTavalod;
	@Column(name = "ssn", length = 14, nullable = true)
	private String ssn;
	@Column(name = "pelak_abi", length = 100, nullable = true)
	private String pelakAbi;
	@Column(name = "mobile", length = 20, nullable = true)
	private String mobile;
	@Column(name = "phone", length = 20, nullable = true)
	private String phone;
	@Column(name = "addres", length = 100, nullable = true)
	private String addres;
	@Temporal(TemporalType.DATE)
	private Date date;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "mobl_mobasherat")
	private MoblEntity mobasherat;

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMobasherName() {
		return mobasherName;
	}
	public void setMobasherName(String mobasherName) {
		this.mobasherName = mobasherName;
	}

	
	
	public String getNamePedar() {
		return namePedar;
	}
	public void setNamePedar(String namePedar) {
		this.namePedar = namePedar;
	}
	public String getShenasname() {
		return shenasname;
	}
	public void setShenasname(String shenasname) {
		this.shenasname = shenasname;
	}
	public String getSodor() {
		return sodor;
	}
	public void setSodor(String sodor) {
		this.sodor = sodor;
	}
	public String getTarikhTavalod() {
		return tarikhTavalod;
	}
	public void setTarikhTavalod(String tarikhTavalod) {
		this.tarikhTavalod = tarikhTavalod;
	}
	public String getMahaleTavalod() {
		return mahaleTavalod;
	}
	public void setMahaleTavalod(String mahaleTavalod) {
		this.mahaleTavalod = mahaleTavalod;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public String getPelakAbi() {
		return pelakAbi;
	}
	public void setPelakAbi(String pelakAbi) {
		this.pelakAbi = pelakAbi;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddres() {
		return addres;
	}
	public void setAddres(String addres) {
		this.addres = addres;
	}
	public MoblEntity getMobasherat() {
		return mobasherat;
	}
	public void setMobasherat(MoblEntity mobasherat) {
		this.mobasherat = mobasherat;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	

	
	
	
}

