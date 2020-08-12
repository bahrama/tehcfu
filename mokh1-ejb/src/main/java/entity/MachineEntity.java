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
@Table(name = "machine_tbl")
@Cache(type = CacheType.SOFT, coordinationType = CacheCoordinationType.INVALIDATE_CHANGED_OBJECTS, size = 1000000)
@NamedQueries({ 
@NamedQuery(name = "findAllMachine", query = "SELECT a FROM MachineEntity a ORDER BY a.machineId DESC"),
@NamedQuery(name = "findMachineById", query = "SELECT i FROM MachineEntity i WHERE i.machineId=:v_machineId"),
})
public class MachineEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "machine_id")
	private long machineId;
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
	@Column(name = "mablag", nullable = true, length = 20)
	private String mablag;
	@Column(name = "mahale_forosh", nullable = true, length = 100)
	private String mahaleForosh;

	private boolean taeed;
	
	@Temporal(TemporalType.DATE)
	private Date date;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_machine")
	private MoblEntity machine;
	
	
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

	public String getMablag() {
		return mablag;
	}

	public void setMablag(String mablag) {
		this.mablag = mablag;
	}

	public String getMahaleForosh() {
		return mahaleForosh;
	}

	public void setMahaleForosh(String mahaleForosh) {
		this.mahaleForosh = mahaleForosh;
	}

	public MoblEntity getMachine() {
		return machine;
	}

	public void setMachine(MoblEntity machine) {
		this.machine = machine;
	}

	public boolean isTaeed() {
		return taeed;
	}

	public void setTaeed(boolean taeed) {
		this.taeed = taeed;
	}

	public long getMachineId() {
		return machineId;
	}

	public void setMachineId(long machineId) {
		this.machineId = machineId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	

}
