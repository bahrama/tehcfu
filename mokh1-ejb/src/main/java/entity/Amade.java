package entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.eclipse.persistence.annotations.Cache;
import org.eclipse.persistence.annotations.CacheCoordinationType;
import org.eclipse.persistence.annotations.CacheType;

import enums.AmadeType;

@Entity
@Table(name="amade_tbl")
@Cache(type = CacheType.SOFT, coordinationType = CacheCoordinationType.INVALIDATE_CHANGED_OBJECTS, size = 1000000)
@NamedQueries({
	@NamedQuery(name="findAllAmade" , query="SELECT a FROM Amade a"),
	@NamedQuery(name="findByAmadeId" , query="SELECT u FROM Amade u WHERE u.amadeId=:v_amadeId"),
})
public class Amade implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2746675149841847845L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "amade_id")
	private long amadeId;
	@Column(name="senfName" , length=100 , nullable=true)
	private String senfName;
	@Column(name="shomarePano" , length=100 , nullable=true)
	private String shomarePano;
	@Column(name="raste" , length=100 , nullable=true)
	private String raste;
	@Column(name="modir" , length=100 , nullable=true)
	private String modir;
	@Column(name="addres" , length=100 , nullable=true)
	private String addres;
	@Column(name="mobasher" , length=100 , nullable=true)
	private String mobasher;
	@Column(name="packag" , length=50 , nullable=true)
	private String packag;
	@Column(name="type" , nullable=true)
	@Enumerated(EnumType.STRING)
	private AmadeType type;
	@Column(name="damane" , length=50 , nullable=true)
	private String damane;
	public long getAmadeId() {
		return amadeId;
	}
	public void setAmadeId(long amadeId) {
		this.amadeId = amadeId;
	}
	public String getSenfName() {
		return senfName;
	}
	public void setSenfName(String senfName) {
		this.senfName = senfName;
	}
	public String getShomarePano() {
		return shomarePano;
	}
	public void setShomarePano(String shomarePano) {
		this.shomarePano = shomarePano;
	}
	public String getRaste() {
		return raste;
	}
	public void setRaste(String raste) {
		this.raste = raste;
	}
	public String getModir() {
		return modir;
	}
	public void setModir(String modir) {
		this.modir = modir;
	}
	public String getAddres() {
		return addres;
	}
	public void setAddres(String addres) {
		this.addres = addres;
	}
	public String getMobasher() {
		return mobasher;
	}
	public void setMobasher(String mobasher) {
		this.mobasher = mobasher;
	}
	public String getPackag() {
		return packag;
	}
	public void setPackag(String packag) {
		this.packag = packag;
	}

	
	
	
	public AmadeType getType() {
		return type;
	}
	public void setType(AmadeType type) {
		this.type = type;
	}
	public String getDamane() {
		return damane;
	}
	public void setDamane(String damane) {
		this.damane = damane;
	}
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Amade))
			return false;
		Amade amade=(Amade) obj;
		return ((amade.amadeId==this.amadeId));
	}

}
