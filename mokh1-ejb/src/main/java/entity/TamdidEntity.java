package entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Cacheable;
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
@Table(name="tamdid_tbl")
@NamedQueries({
	@NamedQuery(name="findAllTamdid" , query="SELECT a FROM TamdidEntity a ORDER BY a.id DESC"),
	@NamedQuery(name="findTamdidById" , query="SELECT i FROM TamdidEntity i WHERE i.id=:v_tamdidId"),
})
@Cacheable(value = false)
public class TamdidEntity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "temdid_id")
	private long id;
	@Column(name = "noe_melk", length = 20, nullable = true)
	private String noeMelk;
	@Column(name = "masahat", length = 20, nullable = true)
	private String masahat;
	@Column(name = "name_malek", length = 20, nullable = true)
	private String nameMalek;
	@Column(name = "shomare_pelak_sabti", length = 20, nullable = true)
	private String shomarePelakSabti;
	@Column(name = "hoze_kalantari", length = 50, nullable = true)
	private String hozeKalantari;
	@Column(name = "hoze_shahrdari", length = 50, nullable = true)
	private String hozeShahrdari;
	@Column(name = "serial_gabz_ab", length = 100, nullable = true)
	private String serialGabzAb;
	@Column(name = "serial_gabz_barg", length = 100, nullable = true)
	private String serialGabzBarg;
	@Column(name = "serial_gabz_gaz", length = 100, nullable = true)
	private String serialGabzGaz;
	@Column(name = "has_parvaneh", length = 5, nullable = true)
	private String hasParvaneh;
	@Column(name = "shomare_abi", length = 100, nullable = true)
	private String shomareAbi;
	@Column(name = "sharik_shoraka", length = 100, nullable = true)
	private String sharikShoraka;
	@Column(name = "daste_shogli", length = 100, nullable = true)
	private String dasteShogli;
	@Column(name = "emkanat", length = 100, nullable = true)
	private String emkanat;
	@Temporal(TemporalType.DATE)
	private Date date;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "mobl_tamdid")
	private MoblEntity tamdid;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNoeMelk() {
		return noeMelk;
	}
	public void setNoeMelk(String noeMelk) {
		this.noeMelk = noeMelk;
	}

	
	public String getMasahat() {
		return masahat;
	}
	public void setMasahat(String masahat) {
		this.masahat = masahat;
	}
	public String getNameMalek() {
		return nameMalek;
	}
	public void setNameMalek(String nameMalek) {
		this.nameMalek = nameMalek;
	}
	public String getShomarePelakSabti() {
		return shomarePelakSabti;
	}
	public void setShomarePelakSabti(String shomarePelakSabti) {
		this.shomarePelakSabti = shomarePelakSabti;
	}
	public String getHozeKalantari() {
		return hozeKalantari;
	}
	public void setHozeKalantari(String hozeKalantari) {
		this.hozeKalantari = hozeKalantari;
	}
	public String getHozeShahrdari() {
		return hozeShahrdari;
	}
	public void setHozeShahrdari(String hozeShahrdari) {
		this.hozeShahrdari = hozeShahrdari;
	}
	public String getSerialGabzAb() {
		return serialGabzAb;
	}
	public void setSerialGabzAb(String serialGabzAb) {
		this.serialGabzAb = serialGabzAb;
	}
	public String getSerialGabzBarg() {
		return serialGabzBarg;
	}
	public void setSerialGabzBarg(String serialGabzBarg) {
		this.serialGabzBarg = serialGabzBarg;
	}
	public String getSerialGabzGaz() {
		return serialGabzGaz;
	}
	public void setSerialGabzGaz(String serialGabzGaz) {
		this.serialGabzGaz = serialGabzGaz;
	}
	public String getHasParvaneh() {
		return hasParvaneh;
	}
	public void setHasParvaneh(String hasParvaneh) {
		this.hasParvaneh = hasParvaneh;
	}
	public String getShomareAbi() {
		return shomareAbi;
	}
	public void setShomareAbi(String shomareAbi) {
		this.shomareAbi = shomareAbi;
	}
	public String getSharikShoraka() {
		return sharikShoraka;
	}
	public void setSharikShoraka(String sharikShoraka) {
		this.sharikShoraka = sharikShoraka;
	}
	public String getDasteShogli() {
		return dasteShogli;
	}
	public void setDasteShogli(String dasteShogli) {
		this.dasteShogli = dasteShogli;
	}
	public String getEmkanat() {
		return emkanat;
	}
	public void setEmkanat(String emkanat) {
		this.emkanat = emkanat;
	}
	public MoblEntity getTamdid() {
		return tamdid;
	}
	public void setTamdid(MoblEntity tamdid) {
		this.tamdid = tamdid;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
	
}

