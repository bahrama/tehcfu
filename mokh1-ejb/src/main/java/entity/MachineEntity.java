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
@Table(name = "machine_tbl")
@NamedQueries({ 
@NamedQuery(name = "findAllMachine", query = "SELECT a FROM MachineEntity a ORDER BY a.adveriseId DESC"),
@NamedQuery(name = "findMachineById", query = "SELECT i FROM MachineEntity i WHERE i.adveriseId=:v_adveriseId"),
})
@Cacheable(value = false)
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorValue(value = "machin")
public class MachineEntity extends AdvertiseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name = "adveriseId")
	private long adveriseId;
	@Column(name = "machine_name", nullable = true, length = 200)
	private String machineName;
	@Column(name = "contry", nullable = true, length = 100)
	private String contry;
	@Column(name = "brand", nullable = true, length = 100)
	private String brand;
	@Column(name = "sale_tolid", nullable = true, length = 100)
	private String saleTolid;
	@Column(name = "vaziat", nullable = true, length = 20)
	private String vaziat;
	@Column(name = "moshakhasat", nullable = true, length = 1000)
	private String moshakhasat;
	@Column(name = "mablag", nullable = true)
	private long mablag;
	@Column(name = "mahale_forosh", nullable = true, length = 100)
	private String mahaleForosh;
	@Column(name = "lavazemJanebi", nullable = true, length = 200)
	private String lavazemJanebi;
	@Column(name = "seriOrCode", nullable = true, length = 200)
	private String seriOrCode;
	@Column(name = "karbord", nullable = true, length = 200)
	private String karbord;
	@Column(name = "zemanat", nullable = true, length = 200)
	private String zemanat;
	@Column(name = "modateZemanat", nullable = true)
	private long modateZemanat;
	@Column(name = "saateBazdidMachine", nullable = true, length = 200)
	private String saateBazdidMachine;
	public String getMachineName() {
		return machineName;
	}

	public void setMachineName(String machineName) {
		this.machineName = machineName;
	}

	public String getContry() {
		return contry;
	}

	public void setContry(String contry) {
		this.contry = contry;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getSaleTolid() {
		return saleTolid;
	}

	public void setSaleTolid(String saleTolid) {
		this.saleTolid = saleTolid;
	}

	public String getVaziat() {
		return vaziat;
	}

	public void setVaziat(String vaziat) {
		this.vaziat = vaziat;
	}

	public String getMoshakhasat() {
		return moshakhasat;
	}

	public void setMoshakhasat(String moshakhasat) {
		this.moshakhasat = moshakhasat;
	}

	public long getMablag() {
		return mablag;
	}

	public void setMablag(long mablag) {
		this.mablag = mablag;
	}

	public String getMahaleForosh() {
		return mahaleForosh;
	}

	public void setMahaleForosh(String mahaleForosh) {
		this.mahaleForosh = mahaleForosh;
	}

	public long getAdveriseId() {
		return adveriseId;
	}

	public void setAdveriseId(long adveriseId) {
		this.adveriseId = adveriseId;
	}

	public String getLavazemJanebi() {
		return lavazemJanebi;
	}

	public void setLavazemJanebi(String lavazemJanebi) {
		this.lavazemJanebi = lavazemJanebi;
	}

	public String getSeriOrCode() {
		return seriOrCode;
	}

	public void setSeriOrCode(String seriOrCode) {
		this.seriOrCode = seriOrCode;
	}

	public String getKarbord() {
		return karbord;
	}

	public void setKarbord(String karbord) {
		this.karbord = karbord;
	}

	public String getZemanat() {
		return zemanat;
	}

	public void setZemanat(String zemanat) {
		this.zemanat = zemanat;
	}

	public long getModateZemanat() {
		return modateZemanat;
	}

	public void setModateZemanat(long modateZemanat) {
		this.modateZemanat = modateZemanat;
	}

	public String getSaateBazdidMachine() {
		return saateBazdidMachine;
	}

	public void setSaateBazdidMachine(String saateBazdidMachine) {
		this.saateBazdidMachine = saateBazdidMachine;
	}


	
	
	

}
