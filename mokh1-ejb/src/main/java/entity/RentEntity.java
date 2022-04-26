package entity;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
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
@NamedQueries({ 
@NamedQuery(name = "findAllRent", query = "SELECT a FROM RentEntity a ORDER BY a.adveriseId DESC"),
@NamedQuery(name = "findRentById", query = "SELECT i FROM RentEntity i WHERE i.adveriseId=:v_adveriseId"),
})
@Cacheable(value = false)
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorValue(value = "rent")
public class RentEntity extends AdvertiseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name = "adveriseId")
	private long adveriseId;
	
	@Column(name = "rentType", nullable = true, length = 20)
	private String rentType;

	@Column(name = "homeType", nullable = true, length = 20)
	private String homeType;

	@Column(name = "vage", nullable = true, length = 20)
	private String vage;

	@Column(name = "mogeiat", nullable = true, length = 20)
	private String mogeiat;

	@Column(name = "tedadTabage", nullable = true )
	private int tedadTabage;

	@Column(name = "tedadVahed", nullable = true)
	private int tedadVahed;

	@Column(name = "vadieeMoney", nullable = true)
	private long vadieeMoney;

	@Column(name = "ejareMony", nullable = true)
	private long ejareMony;
	
	@Column(name = "mablage_forosh", nullable = true)
	private long mablageForosh;

	@Column(name = "emkanat", nullable = true, length = 200)
	private String emkanat;

	@Column(name = "vaziatSanad", nullable = true, length = 20)
	private String vaziatSanad;

	@Column(name = "senBana", nullable = true)
	private int senBana;

	@Column(name = "masahat", nullable = true)
	private int masahat;

	@Column(name = "vaziatMelk", nullable = true,length = 100)
	private String vaziatMelk;

	@Column(name = "parvane", nullable = true,length=5)
	private String parvane;

	@Column(name = "etehadieName", nullable = true, length = 200)
	private String etehadieName;



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

	
	public String getVaziatMelk() {
		return vaziatMelk;
	}

	public void setVaziatMelk(String vaziatMelk) {
		this.vaziatMelk = vaziatMelk;
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

public long getAdveriseId() {
		return adveriseId;
	}

	public void setAdveriseId(long adveriseId) {
		this.adveriseId = adveriseId;
	}

	public int getTedadTabage() {
		return tedadTabage;
	}

	public void setTedadTabage(int tedadTabage) {
		this.tedadTabage = tedadTabage;
	}

	public int getTedadVahed() {
		return tedadVahed;
	}

	public void setTedadVahed(int tedadVahed) {
		this.tedadVahed = tedadVahed;
	}

	public long getVadieeMoney() {
		return vadieeMoney;
	}

	public void setVadieeMoney(long vadieeMoney) {
		this.vadieeMoney = vadieeMoney;
	}

	public long getEjareMony() {
		return ejareMony;
	}

	public void setEjareMony(long ejareMony) {
		this.ejareMony = ejareMony;
	}

	public long getMablageForosh() {
		return mablageForosh;
	}

	public void setMablageForosh(long mablageForosh) {
		this.mablageForosh = mablageForosh;
	}

	public int getSenBana() {
		return senBana;
	}

	public void setSenBana(int senBana) {
		this.senBana = senBana;
	}

	public int getMasahat() {
		return masahat;
	}

	public void setMasahat(int masahat) {
		this.masahat = masahat;
	}

	

}
