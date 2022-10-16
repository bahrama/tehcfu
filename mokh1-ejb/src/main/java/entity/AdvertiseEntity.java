package entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="advertise_tbl")
@NamedQueries({
	@NamedQuery(name="findAllAdvertiseEntityEntity" , query="SELECT a FROM AdvertiseEntity a ORDER BY a.adveriseId DESC"),
	@NamedQuery(name="findByAdvertiseEntityId" , query="SELECT u FROM AdvertiseEntity u WHERE u.adveriseId=:v_adveriseId"),
	@NamedQuery(name="findByadvertiseTypeEntityId" , query="SELECT u FROM AdvertiseEntity u WHERE u.advertiseType=:v_advertiseType ORDER BY u.adveriseId DESC"),
	@NamedQuery(name="findAllAdvertiseEntityBySeller" , query="SELECT pp FROM AdvertiseEntity pp WHERE pp.userAdv=:v_user ORDER BY pp.adveriseId DESC"),
})
@Cacheable(value = false)
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "advertiseType")
public class AdvertiseEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	
	@Column(name = "advertiseType")
	private String advertiseType;
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name = "adveriseId")
	private long adveriseId;
	@Column(name = "show")
	private boolean show;
	@Temporal(TemporalType.DATE)
	@Column(name="in_date",nullable=true)
	private Date date;
	@Column(name = "pic1", length = 100 , nullable = true)
	private String pic1;
	@Column(name = "title", length = 100, nullable = true)
    private String title;
	@Column(name = "description", length = 500, nullable = true)
	private String description;
	@Column(name = "addres", length = 500, nullable = true)
	private String addres;
	@Column(name = "phone", length = 200, nullable = true)
	private String phone;
	@Column(name = "email", length = 200, nullable = true)
	private String email;
	@Column(name = "site", length = 200, nullable = true)
	private String site;
	
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_adv")
	private MoblEntity userAdv;
	
	
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	public String getAdvertiseType() {
		return advertiseType;
	}
	public void setAdvertiseType(String advertiseType) {
		this.advertiseType = advertiseType;
	}
	public long getAdveriseId() {
		return adveriseId;
	}
	public void setAdveriseId(long adveriseId) {
		this.adveriseId = adveriseId;
	}
	public boolean isShow() {
		return show;
	}
	public void setShow(boolean show) {
		this.show = show;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getPic1() {
		return pic1;
	}
	public void setPic1(String pic1) {
		this.pic1 = pic1;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public MoblEntity getUserAdv() {
		return userAdv;
	}
	public void setUserAdv(MoblEntity userAdv) {
		this.userAdv = userAdv;
	}
	public String getAddres() {
		return addres;
	}
	public void setAddres(String addres) {
		this.addres = addres;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	

	
}
