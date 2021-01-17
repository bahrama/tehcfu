package entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;

import org.eclipse.persistence.annotations.Cache;
import org.eclipse.persistence.annotations.CacheCoordinationType;
import org.eclipse.persistence.annotations.CacheType;
import org.eclipse.persistence.annotations.UuidGenerator;

import enums.UserRole;


/**
 * The persistent class for the mobl_tbl database table.
 * 
 */
@Entity
@Table(name="mobl_tbl")
@Cache(type = CacheType.SOFT, coordinationType = CacheCoordinationType.INVALIDATE_CHANGED_OBJECTS, size = 1000000)
@NamedQueries({
@NamedQuery(name="MoblEntity.findAll", query="SELECT m FROM MoblEntity m ORDER BY m.id DESC"),
@NamedQuery(name="MoblEntity.findAllMap", query="SELECT m FROM MoblEntity m WHERE (NOT m.panel=:v_panelMap)"),
@NamedQuery(name = "MoblEntity.findById", query = "SELECT i FROM MoblEntity i WHERE i.id=:v_id"),
@NamedQuery(name = "MoblEntity.findByMobile", query = "SELECT i FROM MoblEntity i WHERE i.mobile=:v_mobile"),
@NamedQuery(name = "MoblEntity.findByAuthCode", query = "SELECT i FROM MoblEntity i WHERE i.authCode=:v_authCode"),
@NamedQuery(name = "MoblEntity.findByToken", query = "SELECT i FROM MoblEntity i WHERE i.token=:v_token"),
@NamedQuery(name = "MoblEntity.findByNameEng", query = "SELECT i FROM MoblEntity i WHERE i.sellerStoreEng=:v_sellerStoreEng"),
@NamedQuery(name = "MoblEntity.findByPanel", query = "SELECT i FROM MoblEntity i WHERE i.panel=:v_panel"),
@NamedQuery(name = "MoblEntity.findSellerNameLike", query = "SELECT i FROM MoblEntity i WHERE i.sellerName like :v_sellerName"),
@NamedQuery(name = "MoblEntity.findsellerStorePerLike", query = "SELECT i FROM MoblEntity i WHERE (NOT i.panel=:v_panel) AND (i.sellerStorePer like :v_sellerStorePer)"),
@NamedQuery(name = "MoblEntity.findsellerAddresLike", query = "SELECT i FROM MoblEntity i WHERE (NOT i.panel=:v_panel) AND (i.sellerAddres like :v_sellerAddres)"),
@NamedQuery(name = "MoblEntity.findsellermodirforoshNameLike", query = "SELECT i FROM MoblEntity i WHERE (NOT i.panel=:v_panel) AND (i.sellerName like :v_modirforoshName)")
})
public class MoblEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@JsonbTransient
	@Column(name="about_us" , length=7000,nullable=true)
	private String aboutUs;
	@Column(name="email" , length=30,nullable=true)
	@JsonbTransient
	private String email;
	@Column(name="fax" , length=50,nullable=true)
	@JsonbTransient
	private String fax;
	@Column(name="instagram" , length=30,nullable=true)
	@JsonbTransient
	private String instagram;


	@Column(name="modirforosh_name" , length=100,nullable=true)
	@JsonbTransient
	private String modirforoshName;

	@Column(name="modirforosh_phone" , length=50,nullable=true)
	@JsonbTransient
	private String modirforoshPhone;
	@Column(name="phone" , length=30,nullable=true)
	@JsonbTransient
	private String phone;
	@Column(name="pic1" , length=100,nullable=true)
	@JsonbTransient
	private String pic1;
	@Column(name="pic2" , length=100,nullable=true)
	@JsonbTransient
	private String pic2;
	@Column(name="pic3" , length=100,nullable=true)
	@JsonbTransient
	private String pic3;
	@Column(name="pic4" , length=100,nullable=true)
	@JsonbTransient
	private String pic4;
	@Column(name="postcode" , length=30,nullable=true)
	@JsonbTransient
	private String postcode;

	@Column(name="seller_addres" , length=200,nullable=true)
	@JsonbTransient
	private String sellerAddres;

	@Column(name="seller_name" , length=100,nullable=true)
	private String sellerName;

	@Column(name="seller_store_eng" , length=30 , unique=true,nullable=true)
	private String sellerStoreEng;

	@Column(name="seller_store_per" , length=30,nullable=true)
	private String sellerStorePer;
	@Column(name="telegram" , length=30,nullable=true)
	@JsonbTransient
	private String telegram;
	@Column(name="website" , length=30,nullable=true)
	@JsonbTransient
	private String website;
	@Column(nullable=true)
	
	private double lat;
	@Column(nullable=true)
	
	private double lng;
	@Column(name="panel" , length=2,nullable=true)
	@JsonbTransient
	private String panel;
	@Column(name="noe_faaliat" , length=2,nullable=true)
	@JsonbTransient
	private String noeFaaliat;
	@Column(name="mobile" , length=11 , unique=true, nullable=false)
	private String mobile;
	@Column(name="ssn" , length=10,nullable=true)
	@JsonbTransient
	private String ssn;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable=true)
	private UserRole role;
	@Column(name="token" , length=50,nullable=true)
	@JsonbTransient
	private String token;
	@Temporal(TemporalType.DATE)
	@Column(name="birth_date",nullable=true)
	@JsonbTransient
	private Date birthDate;
	@Column(name="auth_code",nullable=true)
	@JsonbTransient
	private int authCode;
	@Column(name="faaliat" , length=400,nullable=true)
	private String faaliat;
	
	@Column(name="tagdir" , length=100,nullable=true)
	@JsonbTransient
	private String tagdirName;
	
	@Column(name="vage" , length=200,nullable=true)
	private String vage;
	//////////////////////////////////////////
	@Column(name="malekiat" , length=20,nullable=true)
	private String malekiat;
	
	@Column(name="sabte_sefaresh" , length=20,nullable=true)
	private String sabteSefaresh;
	@Column(name="mostajer" ,nullable=true)
	private boolean mostajer;
	
	@Temporal(TemporalType.DATE)
	@Column(name="mohlate_ejare",nullable=true)
	@JsonbTransient
	private Date mohlateEjare;
	
	@Column(name="mostajer_name" , length=100,nullable=true)
	private String mostajerName;
	
	@Temporal(TemporalType.DATE)
	@Column(name="mostajer_birthday",nullable=true)
	@JsonbTransient
	private Date mostajerBirthday;
	
	@Column(name="mostajer_ssn" , length=11,nullable=true)
	private String mostajerSsn;	
	
	@Column(name="mostajer_mobile" , length=11,nullable=true)
	private String mostajerMobile;
	@Column(name="shomare_javaz" , length=100,nullable=true)
	private String shomareJavaz;
	
	@Temporal(TemporalType.DATE)
	@Column(name="tarikh_etebar",nullable=true)
	@JsonbTransient
	private Date tarikhEtebar;
	@Column(name="has_mobasher" ,nullable=true)
	private boolean hasMobasher;
	@Column(name="mobasher_name" , length=100,nullable=true)
	private String mobasherName;
	@Column(name="rabet_name" , length=100,nullable=true)
	private String rabetName;
	@Column(name="semat_rabet" , length=100,nullable=true)
	private String sematRabet;	
	@Column(name="rabet_mobile" , length=11,nullable=true)
	private String rabetMobile;
	@Column(name="shabake_mazaji_mobile" , length=11,nullable=true)
	private String shabakeMazajiMobile;
	
	@Column(name="mojtame" , length=100,nullable=true)
	private String mojtame;
	
	
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "shaki")
	@JsonbTransient
	private Set<Shekayat1> moblShekayat = new HashSet<>();
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "karfarma")
	@JsonbTransient
	private Set<JobKarfarmaEntity> moblKarfarma = new HashSet<>();

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "karjo")
	@JsonbTransient
	private Set<JobKarjoEntity> moblKarjo = new HashSet<>();
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "renter")
	@JsonbTransient
	private Set<RentEntity> moblRent = new HashSet<>();
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "mobasherat")
	@JsonbTransient
	private Set<MobasheratEntity> moblMobasherat = new HashSet<>();
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tamdid")
	@JsonbTransient
	private Set<TamdidEntity> moblTamdid = new HashSet<>();
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "machine")
	@JsonbTransient
	private Set<MachineEntity> moblMachine = new HashSet<>();
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "product")
	@JsonbTransient
	private Set<ProductEntity> moblProduct = new HashSet<>();
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "messageFrom")
	@JsonbTransient
	private Set<MessageEntity> moblmessageFrom = new HashSet<>();
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "messageTo")
	@JsonbTransient
	private Set<MessageEntity> moblmessageTo = new HashSet<>();

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAboutUs() {
		return this.aboutUs;
	}

	public void setAboutUs(String aboutUs) {
		this.aboutUs = aboutUs;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFaaliat() {
		return faaliat;
	}

	public void setFaaliat(String faaliat) {
		this.faaliat = faaliat;
	}

	public String getFax() {
		return this.fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getInstagram() {
		return this.instagram;
	}

	public void setInstagram(String instagram) {
		this.instagram = instagram;
	}



	public String getModirforoshName() {
		return this.modirforoshName;
	}

	public void setModirforoshName(String modirforoshName) {
		this.modirforoshName = modirforoshName;
	}

	public String getModirforoshPhone() {
		return this.modirforoshPhone;
	}

	public void setModirforoshPhone(String modirforoshPhone) {
		this.modirforoshPhone = modirforoshPhone;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Object getPic1() {
		return this.pic1;
	}



	public String getPostcode() {
		return this.postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getSellerAddres() {
		return this.sellerAddres;
	}

	public void setSellerAddres(String sellerAddres) {
		this.sellerAddres = sellerAddres;
	}

	public String getSellerName() {
		return this.sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public String getSellerStoreEng() {
		return this.sellerStoreEng;
	}

	public void setSellerStoreEng(String sellerStoreEng) {
		this.sellerStoreEng = sellerStoreEng;
	}

	public String getSellerStorePer() {
		return this.sellerStorePer;
	}

	public void setSellerStorePer(String sellerStorePer) {
		this.sellerStorePer = sellerStorePer;
	}

	public String getTelegram() {
		return this.telegram;
	}

	public void setTelegram(String telegram) {
		this.telegram = telegram;
	}

	public String getWebsite() {
		return this.website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getPic2() {
		return pic2;
	}

	public void setPic2(String pic2) {
		this.pic2 = pic2;
	}

	public String getPic3() {
		return pic3;
	}

	public void setPic3(String pic3) {
		this.pic3 = pic3;
	}

	public void setPic1(String pic1) {
		this.pic1 = pic1;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLng() {
		return lng;
	}

	public void setLng(double lng) {
		this.lng = lng;
	}

	public String getPic4() {
		return pic4;
	}

	public void setPic4(String pic4) {
		this.pic4 = pic4;
	}

	public String getPanel() {
		return panel;
	}

	public void setPanel(String panel) {
		this.panel = panel;
	}

	public String getNoeFaaliat() {
		switch (this.noeFaaliat) {
		case "A":
			return "مبلمان خانگی";
        case "B":
        	return "مبلمان اداری";
        case "C":
        	return "سیسمونی";
        case "D":
        	return "کابینت آشپزخانه";
        case "F":
        	return "مصنوعات چوبی";
        case "G":
        	return "تعمیرات";
        case "I":
        	return "دکوراسیون";
        case "J":
        	return "متفرقه";
		default:
			return null;
		}
	}

	public void setNoeFaaliat(String noeFaaliat) {
		this.noeFaaliat = noeFaaliat;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public int getAuthCode() {
		return authCode;
	}

	public void setAuthCode(int authCode) {
		this.authCode = authCode;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mobile == null) ? 0 : mobile.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MoblEntity other = (MoblEntity) obj;
		if (mobile == null) {
			if (other.mobile != null)
				return false;
		} else if (!mobile.equals(other.mobile))
			return false;
		return true;
	}

	public String getMalekiat() {
		return malekiat;
	}

	public void setMalekiat(String malekiat) {
		this.malekiat = malekiat;
	}

	public String getSabteSefaresh() {
		return sabteSefaresh;
	}

	public void setSabteSefaresh(String sabteSefaresh) {
		this.sabteSefaresh = sabteSefaresh;
	}

	public boolean isMostajer() {
		return mostajer;
	}

	public void setMostajer(boolean mostajer) {
		this.mostajer = mostajer;
	}

	public Date getMohlateEjare() {
		return mohlateEjare;
	}

	public void setMohlateEjare(Date mohlateEjare) {
		this.mohlateEjare = mohlateEjare;
	}

	public String getMostajerName() {
		return mostajerName;
	}

	public void setMostajerName(String mostajerName) {
		this.mostajerName = mostajerName;
	}

	public Date getMostajerBirthday() {
		return mostajerBirthday;
	}

	public void setMostajerBirthday(Date mostajerBirthday) {
		this.mostajerBirthday = mostajerBirthday;
	}

	public String getMostajerSsn() {
		return mostajerSsn;
	}

	public void setMostajerSsn(String mostajerSsn) {
		this.mostajerSsn = mostajerSsn;
	}

	public String getMostajerMobile() {
		return mostajerMobile;
	}

	public void setMostajerMobile(String mostajerMobile) {
		this.mostajerMobile = mostajerMobile;
	}

	public String getShomareJavaz() {
		return shomareJavaz;
	}

	public void setShomareJavaz(String shomareJavaz) {
		this.shomareJavaz = shomareJavaz;
	}

	public Date getTarikhEtebar() {
		return tarikhEtebar;
	}

	public void setTarikhEtebar(Date tarikhEtebar) {
		this.tarikhEtebar = tarikhEtebar;
	}

	public boolean isHasMobasher() {
		return hasMobasher;
	}

	public void setHasMobasher(boolean hasMobasher) {
		this.hasMobasher = hasMobasher;
	}

	public String getMobasherName() {
		return mobasherName;
	}

	public void setMobasherName(String mobasherName) {
		this.mobasherName = mobasherName;
	}

	public String getRabetName() {
		return rabetName;
	}

	public void setRabetName(String rabetName) {
		this.rabetName = rabetName;
	}

	public String getSematRabet() {
		return sematRabet;
	}

	public void setSematRabet(String sematRabet) {
		this.sematRabet = sematRabet;
	}

	public String getRabetMobile() {
		return rabetMobile;
	}

	public void setRabetMobile(String rabetMobile) {
		this.rabetMobile = rabetMobile;
	}

	public String getShabakeMazajiMobile() {
		return shabakeMazajiMobile;
	}

	public void setShabakeMazajiMobile(String shabakeMazajiMobile) {
		this.shabakeMazajiMobile = shabakeMazajiMobile;
	}

	public String getMojtame() {
		return mojtame;
	}

	public void setMojtame(String mojtame) {
		this.mojtame = mojtame;
	}

	public Set<MessageEntity> getMoblmessageFrom() {
		return moblmessageFrom;
	}

	public void setMoblmessageFrom(Set<MessageEntity> moblmessageFrom) {
		this.moblmessageFrom = moblmessageFrom;
	}

	public Set<MessageEntity> getMoblmessageTo() {
		return moblmessageTo;
	}

	public void setMoblmessageTo(Set<MessageEntity> moblmessageTo) {
		this.moblmessageTo = moblmessageTo;
	}

	public Set<Shekayat1> getMoblShekayat() {
		return moblShekayat;
	}

	public void setMoblShekayat(Set<Shekayat1> moblShekayat) {
		this.moblShekayat = moblShekayat;
	}

	public Set<JobKarfarmaEntity> getMoblKarfarma() {
		return moblKarfarma;
	}

	public void setMoblKarfarma(Set<JobKarfarmaEntity> moblKarfarma) {
		this.moblKarfarma = moblKarfarma;
	}

	public Set<JobKarjoEntity> getMoblKarjo() {
		return moblKarjo;
	}

	public void setMoblKarjo(Set<JobKarjoEntity> moblKarjo) {
		this.moblKarjo = moblKarjo;
	}

	public Set<RentEntity> getMoblRent() {
		return moblRent;
	}

	public void setMoblRent(Set<RentEntity> moblRent) {
		this.moblRent = moblRent;
	}

	public Set<MobasheratEntity> getMoblMobasherat() {
		return moblMobasherat;
	}

	public void setMoblMobasherat(Set<MobasheratEntity> moblMobasherat) {
		this.moblMobasherat = moblMobasherat;
	}

	public Set<TamdidEntity> getMoblTamdid() {
		return moblTamdid;
	}

	public void setMoblTamdid(Set<TamdidEntity> moblTamdid) {
		this.moblTamdid = moblTamdid;
	}

	public Set<MachineEntity> getMoblMachine() {
		return moblMachine;
	}

	public void setMoblMachine(Set<MachineEntity> moblMachine) {
		this.moblMachine = moblMachine;
	}

	public Set<ProductEntity> getMoblProduct() {
		return moblProduct;
	}

	public void setMoblProduct(Set<ProductEntity> moblProduct) {
		this.moblProduct = moblProduct;
	}

	public String getTagdirName() {
		return tagdirName;
	}

	public void setTagdirName(String tagdirName) {
		this.tagdirName = tagdirName;
	}

	public String getVage() {
		return vage;
	}

	public void setVage(String vage) {
		this.vage = vage;
	}

	@Override
	public String toString() {
		return "MoblEntity [id=" + id + ", aboutUs=" + aboutUs + ", email=" + email + ", fax=" + fax + ", instagram="
				+ instagram + ", modirforoshName=" + modirforoshName + ", modirforoshPhone=" + modirforoshPhone
				+ ", phone=" + phone + ", pic1=" + pic1 + ", pic2=" + pic2 + ", pic3=" + pic3 + ", pic4=" + pic4
				+ ", postcode=" + postcode + ", sellerAddres=" + sellerAddres + ", sellerName=" + sellerName
				+ ", sellerStoreEng=" + sellerStoreEng + ", sellerStorePer=" + sellerStorePer + ", telegram=" + telegram
				+ ", website=" + website + ", lat=" + lat + ", lng=" + lng + ", panel=" + panel + ", noeFaaliat="
				+ noeFaaliat + ", mobile=" + mobile + ", ssn=" + ssn + ", role=" + role + ", token=" + token
				+ ", birthDate=" + birthDate + ", authCode=" + authCode + ", faaliat=" + faaliat + "]";
	}

	
	

/*	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof MoblEntity))
			return false;
		MoblEntity moblEntity = (MoblEntity) obj;
		return ((moblEntity.id == this.id)
				|| (moblEntity.mobile.equals(this.mobile))
				|| (moblEntity.authCode==this.authCode)
				|| (moblEntity.token.equals(this.token)));
	}*/
	
	
	
}