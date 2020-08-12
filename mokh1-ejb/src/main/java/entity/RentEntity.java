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
@Table(name = "rent_tbl")
@Cache(type = CacheType.SOFT, coordinationType = CacheCoordinationType.INVALIDATE_CHANGED_OBJECTS, size = 1000000)
@NamedQueries({ 
@NamedQuery(name = "findAllRent", query = "SELECT a FROM RentEntity a ORDER BY a.rentId DESC"),
@NamedQuery(name = "findRentById", query = "SELECT i FROM RentEntity i WHERE i.rentId=:v_rentId"),
})
public class RentEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "rent_id")
	private long rentId;
	@Column(name = "rentType", nullable = true, length = 20)
	private String rentType;

	@Column(name = "homeType", nullable = true, length = 20)
	private String homeType;

	@Column(name = "address", nullable = true, length = 100)
	private String address;

	@Column(name = "vage", nullable = true, length = 20)
	private String vage;

	@Column(name = "mogeiat", nullable = true, length = 20)
	private String mogeiat;

	@Column(name = "tedadTabage", nullable = true , length = 10)
	private String tedadTabage;

	@Column(name = "tedadVahed", nullable = true, length = 10)
	private String tedadVahed;

	@Column(name = "vadieeMoney", nullable = true, length = 30)
	private String vadieeMoney;

	@Column(name = "ejareMony", nullable = true , length = 30)
	private String ejareMony;
	
	@Column(name = "mablage_forosh", nullable = true , length = 30)
	private String mablageForosh;

	@Column(name = "emkanat", nullable = true, length = 200)
	private String emkanat;

	@Column(name = "vaziatSanad", nullable = true, length = 20)
	private String vaziatSanad;

	@Column(name = "senBana", nullable = true ,length = 30)
	private String senBana;

	@Column(name = "masahat", nullable = true,length = 30)
	private String masahat;

	@Column(name = "vaziatMelk", nullable = true)
	private String vaziatMelk;

	@Column(name = "description", nullable = true , length=500)
	private String description;

	@Column(name = "parvane", nullable = true,length=5)
	private String parvane;

	@Column(name = "etehadieName", nullable = true, length = 200)
	private String etehadieName;

	@Column(name = "phone", nullable = true , length=30)
	private String phone;

	
	@Column(name = "pic1", nullable = true , length=100)
	private String pic1;

	@Column(name = "show")
	private boolean show;

	@Temporal(TemporalType.DATE)
	private Date date;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_rent")
	private MoblEntity renter;

	public long getRentId() {
		return rentId;
	}

	public void setRentId(long rentId) {
		this.rentId = rentId;
	}

	public String getRentType() {
		return rentType;
	}

	public void setRentType(String rentType) {
		this.rentType = rentType;
	}

	public String getHomeType() {
		return homeType;
	}

	public void setHomeType(String homeType) {
		this.homeType = homeType;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getVage() {
		return vage;
	}

	public void setVage(String vage) {
		this.vage = vage;
	}

	public String getMogeiat() {
		return mogeiat;
	}

	public void setMogeiat(String mogeiat) {
		this.mogeiat = mogeiat;
	}

	
	
	public String getTedadTabage() {
		return tedadTabage;
	}

	public void setTedadTabage(String tedadTabage) {
		this.tedadTabage = tedadTabage;
	}

	public String getTedadVahed() {
		return tedadVahed;
	}

	public void setTedadVahed(String tedadVahed) {
		this.tedadVahed = tedadVahed;
	}

	public String getVadieeMoney() {
		return vadieeMoney;
	}

	public void setVadieeMoney(String vadieeMoney) {
		this.vadieeMoney = vadieeMoney;
	}

	public String getEjareMony() {
		return ejareMony;
	}

	public void setEjareMony(String ejareMony) {
		this.ejareMony = ejareMony;
	}

	public String getMablageForosh() {
		return mablageForosh;
	}

	public void setMablageForosh(String mablageForosh) {
		this.mablageForosh = mablageForosh;
	}

	public String getEmkanat() {
		return emkanat;
	}

	public void setEmkanat(String emkanat) {
		this.emkanat = emkanat;
	}

	public String getVaziatSanad() {
		return vaziatSanad;
	}

	public void setVaziatSanad(String vaziatSanad) {
		this.vaziatSanad = vaziatSanad;
	}

	public String getSenBana() {
		return senBana;
	}

	public void setSenBana(String senBana) {
		this.senBana = senBana;
	}

	public String getMasahat() {
		return masahat;
	}

	public void setMasahat(String masahat) {
		this.masahat = masahat;
	}

	public String getVaziatMelk() {
		return vaziatMelk;
	}

	public void setVaziatMelk(String vaziatMelk) {
		this.vaziatMelk = vaziatMelk;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getParvane() {
		return parvane;
	}

	public void setParvane(String parvane) {
		this.parvane = parvane;
	}

	public String getEtehadieName() {
		return etehadieName;
	}

	public void setEtehadieName(String etehadieName) {
		this.etehadieName = etehadieName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPic1() {
		return pic1;
	}

	public void setPic1(String pic1) {
		this.pic1 = pic1;
	}

	public boolean isShow() {
		return show;
	}

	public void setShow(boolean show) {
		this.show = show;
	}

	public MoblEntity getRenter() {
		return renter;
	}

	public void setRenter(MoblEntity renter) {
		this.renter = renter;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof RentEntity))
			return false;
		RentEntity rentEntity = (RentEntity) obj;
		return (rentEntity.rentId == this.rentId);
	}

}
