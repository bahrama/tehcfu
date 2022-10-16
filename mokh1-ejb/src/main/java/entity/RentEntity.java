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
	@Column(name = "rentType", nullable = true, length = 100)
	private String rentType;
	@Column(name = "homeType", nullable = true, length = 100)
	private String homeType;
	@Column(name = "karbariSanad", nullable = true, length = 100)
	private String karbariSanad;
	@Column(name = "noeSanad", nullable = true, length = 100)
	private String noeSanad;
	@Column(name = "metraj", nullable = true)
	private long metraj;
	@Column(name = "priceMetr", nullable = true)
	private long priceMetr;
	@Column(name = "phoneLine", nullable = true)
	private long phoneLine;
	@Column(name = "saleSakht", nullable = true, length = 200)
	private String saleSakht;
	
	@Column(name = "jahateMelk", nullable = true, length = 20)
	private String jahateMelk;
	
	@Column(name = "mahaleSakhteman", nullable = true, length = 20)
	private String mahaleSakhteman;

	@Column(name = "namayeMelk", nullable = true, length = 200)
	private String namayeMelk;
	
	@Column(name = "kaf", nullable = true, length = 200)
	private String kaf;
	
	@Column(name = "posheshDivar", nullable = true, length = 200)
	private String posheshDivar;
	
	@Column(name = "vaziatRoshanayi", nullable = true, length = 200)
	private String vaziatRoshanayi;
	
	@Column(name = "vaziatsystemGarmayesh", nullable = true, length = 50)
	private String vaziatsystemGarmayesh;
	
	@Column(name = "abGarm", nullable = true, length = 50)
	private String abGarm;
	
	
	@Column(name = "moshaat", nullable = true, length = 50)
	private String moshaat;
	
	@Column(name = "moshaatAbi", nullable = true, length = 50)
	private String moshaatAbi;
	
	@Column(name = "chahAbi", nullable = true, length = 50)
	private String chahAbi;
	
	
	@Column(name = "fazayeSabz", nullable = true, length = 50)
	private String fazayeSabz;
	
	
	@Column(name = "view", nullable = true, length = 50)
	private String view;
	
	@Column(name = "anbari", nullable = true, length = 50)
	private String anbari;
	
	@Column(name = "parking", nullable = true, length = 50)
	private String parking;
	
	@Column(name = "telephone", nullable = true, length = 50)
	private String telephone;
	
	
	@Column(name = "tabloKhor", nullable = true, length = 50)
	private String tabloKhor;
	
	
	@Column(name = "serviceBehdashti", nullable = true, length = 50)
	private String serviceBehdashti;
	
	@Column(name = "digarEmkanat", nullable = true, length = 500)
	private String digarEmkanat;
	
	@Column(name = "saateBazdid", nullable = true, length = 100)
	private String saateBazdid;
	
	

	public long getPhoneLine() {
		return phoneLine;
	}

	public void setPhoneLine(long phoneLine) {
		this.phoneLine = phoneLine;
	}

	public String getRentType() {
		return rentType;
	}

	public void setRentType(String rentType) {
		this.rentType = rentType;
	}

	public String getSaateBazdid() {
		return saateBazdid;
	}

	public void setSaateBazdid(String saateBazdid) {
		this.saateBazdid = saateBazdid;
	}

	public long getAdveriseId() {
		return adveriseId;
	}

	public void setAdveriseId(long adveriseId) {
		this.adveriseId = adveriseId;
	}

	public String getHomeType() {
		return homeType;
	}

	public void setHomeType(String homeType) {
		this.homeType = homeType;
	}

	public String getKarbariSanad() {
		return karbariSanad;
	}

	public void setKarbariSanad(String karbariSanad) {
		this.karbariSanad = karbariSanad;
	}

	public String getNoeSanad() {
		return noeSanad;
	}

	public void setNoeSanad(String noeSanad) {
		this.noeSanad = noeSanad;
	}

	public long getMetraj() {
		return metraj;
	}

	public void setMetraj(long metraj) {
		this.metraj = metraj;
	}

	public long getPriceMetr() {
		return priceMetr;
	}

	public void setPriceMetr(long priceMetr) {
		this.priceMetr = priceMetr;
	}

	public String getSaleSakht() {
		return saleSakht;
	}

	public void setSaleSakht(String saleSakht) {
		this.saleSakht = saleSakht;
	}

	public String getJahateMelk() {
		return jahateMelk;
	}

	public void setJahateMelk(String jahateMelk) {
		this.jahateMelk = jahateMelk;
	}

	public String getMahaleSakhteman() {
		return mahaleSakhteman;
	}

	public void setMahaleSakhteman(String mahaleSakhteman) {
		this.mahaleSakhteman = mahaleSakhteman;
	}

	public String getNamayeMelk() {
		return namayeMelk;
	}

	public void setNamayeMelk(String namayeMelk) {
		this.namayeMelk = namayeMelk;
	}

	public String getKaf() {
		return kaf;
	}

	public void setKaf(String kaf) {
		this.kaf = kaf;
	}

	public String getPosheshDivar() {
		return posheshDivar;
	}

	public void setPosheshDivar(String posheshDivar) {
		this.posheshDivar = posheshDivar;
	}

	public String getVaziatRoshanayi() {
		return vaziatRoshanayi;
	}

	public void setVaziatRoshanayi(String vaziatRoshanayi) {
		this.vaziatRoshanayi = vaziatRoshanayi;
	}

	public String getVaziatsystemGarmayesh() {
		return vaziatsystemGarmayesh;
	}

	public void setVaziatsystemGarmayesh(String vaziatsystemGarmayesh) {
		this.vaziatsystemGarmayesh = vaziatsystemGarmayesh;
	}

	public String getAbGarm() {
		return abGarm;
	}

	public void setAbGarm(String abGarm) {
		this.abGarm = abGarm;
	}

	public String getMoshaat() {
		return moshaat;
	}

	public void setMoshaat(String moshaat) {
		this.moshaat = moshaat;
	}

	public String getMoshaatAbi() {
		return moshaatAbi;
	}

	public void setMoshaatAbi(String moshaatAbi) {
		this.moshaatAbi = moshaatAbi;
	}

	public String getChahAbi() {
		return chahAbi;
	}

	public void setChahAbi(String chahAbi) {
		this.chahAbi = chahAbi;
	}

	public String getFazayeSabz() {
		return fazayeSabz;
	}

	public void setFazayeSabz(String fazayeSabz) {
		this.fazayeSabz = fazayeSabz;
	}

	public String getView() {
		return view;
	}

	public void setView(String view) {
		this.view = view;
	}

	public String getAnbari() {
		return anbari;
	}

	public void setAnbari(String anbari) {
		this.anbari = anbari;
	}

	public String getParking() {
		return parking;
	}

	public void setParking(String parking) {
		this.parking = parking;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getTabloKhor() {
		return tabloKhor;
	}

	public void setTabloKhor(String tabloKhor) {
		this.tabloKhor = tabloKhor;
	}

	public String getServiceBehdashti() {
		return serviceBehdashti;
	}

	public void setServiceBehdashti(String serviceBehdashti) {
		this.serviceBehdashti = serviceBehdashti;
	}

	public String getDigarEmkanat() {
		return digarEmkanat;
	}

	public void setDigarEmkanat(String digarEmkanat) {
		this.digarEmkanat = digarEmkanat;
	}
	
	
	
}
