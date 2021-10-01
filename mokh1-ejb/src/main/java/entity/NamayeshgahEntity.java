package entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.eclipse.persistence.annotations.Cache;
import org.eclipse.persistence.annotations.CacheCoordinationType;
import org.eclipse.persistence.annotations.CacheType;

@Entity
@Table(name="namayeshgah_tbl")
@Cache(type = CacheType.SOFT, coordinationType = CacheCoordinationType.INVALIDATE_CHANGED_OBJECTS, size = 1000000)
@NamedQueries({
@NamedQuery(name="NamayeshgahEntity.findAll", query="SELECT b FROM NamayeshgahEntity b ORDER BY b.id DESC"),
@NamedQuery(name = "NamayeshgahEntity.findById", query = "SELECT i FROM NamayeshgahEntity i WHERE i.id=:v_id"),
@NamedQuery(name = "NamayeshgahEntity.findByType", query = "SELECT i FROM NamayeshgahEntity i WHERE i.type=:v_type ORDER BY i.id DESC")
})
public class NamayeshgahEntity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="name" , length=100)
	private String name;
	@Column(name="city" , length=100)
	private String city;
	@Column(name="country" , length=100)
	private String country;
	@Column(name="tarikh" , length=100)
	private String tarikh;
	@Column(name="makan" , length=300)
	private String makan;
	@Column(name="name_bargozar_k" , length=100)
	private String nameBargozarK;
	@Column(name="phone_modir_nazer" , length=100)
	private String phoneModirNazer;
	@Column(name="name_modir_nazer" , length=100)
	private String nameModirNazer;
	@Column(name="fax" , length=100)
	private String fax;
	@Column(name="phone" , length=100)
	private String phone;
	@Column(name="email" , length=100)
	private String email;
	@Column(name="site" , length=100)
	private String site;
	@Column(name="pic" , length=100)
	private String pic;
	@Column(name="type" , length=2)
	private String type;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getTarikh() {
		return tarikh;
	}
	public void setTarikh(String tarikh) {
		this.tarikh = tarikh;
	}
	public String getMakan() {
		return makan;
	}
	public void setMakan(String makan) {
		this.makan = makan;
	}
	public String getNameBargozarK() {
		return nameBargozarK;
	}
	public void setNameBargozarK(String nameBargozarK) {
		this.nameBargozarK = nameBargozarK;
	}
	public String getPhoneModirNazer() {
		return phoneModirNazer;
	}
	public void setPhoneModirNazer(String phoneModirNazer) {
		this.phoneModirNazer = phoneModirNazer;
	}
	public String getNameModirNazer() {
		return nameModirNazer;
	}
	public void setNameModirNazer(String nameModirNazer) {
		this.nameModirNazer = nameModirNazer;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	
	
	
	
	
}
