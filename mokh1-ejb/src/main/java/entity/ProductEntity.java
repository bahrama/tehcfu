package entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import org.eclipse.persistence.annotations.Cache;
import org.eclipse.persistence.annotations.CacheCoordinationType;
import org.eclipse.persistence.annotations.CacheType;
@Entity
/*
 * @Table(name="product_tbl", uniqueConstraints= {
 * 
 * @UniqueConstraint(columnNames= {"user_product" , "name" , "old_new"}), })
 */
@Table(name="product_tbl")
@NamedQueries({
	@NamedQuery(name="findAllProductEntity" , query="SELECT a FROM ProductEntity a ORDER BY a.productId DESC"),
	@NamedQuery(name="findAllActiveProductEntity" , query="SELECT a FROM ProductEntity a where a.checkO=:v_checkO ORDER BY a.productId DESC"),
	@NamedQuery(name="findByProductEntityId" , query="SELECT u FROM ProductEntity u WHERE (u.productId=:v_productId AND u.checkO=:v_checkO)"),
	@NamedQuery(name="findAllProductEntityById2" , query="SELECT pp FROM ProductEntity pp ORDER BY pp.productId DESC"),
	@NamedQuery(name="countAllProduct" , query="SELECT count(pp) FROM ProductEntity pp where pp.checkO=:v_checkO"),
	@NamedQuery(name="findAllProductEntityBySeller" , query="SELECT pp FROM ProductEntity pp WHERE (pp.product=:v_product AND pp.checkO=:v_checkO)"),
})
@Cacheable(value = false)
public class ProductEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "product_seq" , sequenceName = "product_seq" ,allocationSize = 10)
	@Column(name = "product_id")
	private long productId;
	@Column(name = "nameCode", length = 100, nullable = true)
	private String nameCode;
	@Column(name = "brand", length = 100, nullable = true)
	private String brand;
	@Column(name = "contry", length = 100, nullable = true)
	private String contry;
	@Column(name = "raste", length = 100, nullable = true)
	private String raste;
	@Column(name = "abad", nullable = true , length=100)
	private String abad;
	@Column(name = "description", length = 3000, nullable = true)
	private String description;
	@Column(name = "pic1", length = 100 , nullable = true)
	private String pic1;
	@Column(name = "pic2", length = 100 , nullable = true)
	private String pic2;
	@Column(name = "pic3", length = 100 , nullable = true)
	private String pic3;
	@Column(name = "pic4", length = 100 , nullable = true)
	private String pic4;
	@Column(name = "pic5", length = 100 , nullable = true)
	private String pic5;
	@Column(name = "mojod", nullable = true)
	private boolean status;
	@Column(name = "TahvilDay", nullable = true)
	private int TahvilDay;
	@Column(name = "EasyNezafat", nullable = true)
	private boolean EasyNezafat;
	
	
	private long price;
	private long price2;
	
	@Column(name = "old_new", nullable = true)
	private boolean oldNew;
	
	@Column(name = "zemanat", nullable = true , length=200)
	private String zemanat;
	@Column(name = "guarantiStatus", nullable = true,length=50)
	private String guarantiStatus;
	@Column(name = "guaranyTimeMounth", nullable = true)
	private int guaranyTimeMounth;
	@Column(name = "rangBandi", nullable = true , length=200)
	private String rangBandi;
	
	@Column(name = "checkO", nullable = true)
	private boolean checkO;
	
	@Temporal(TemporalType.DATE)
	@Column(name="pDate",nullable=true)
	private Date pDate;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_product")
	private MoblEntity product;
	
	@Column(name = "aparat", nullable = true , length=2000)
	private String aparat;
	
	@Column(name = "insta", nullable = true  , length=7000)
	private String instagram;
	
	@Column(name = "proType", nullable = true , length=50)
	private String proType;
	
	
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "sefareshProduct")
	@JsonbTransient
	private Set<SefareshEntity> productSefaresh = new HashSet<>();
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "offerProduct")
	@JsonbTransient
	private Set<OfferEntity> productOffer = new HashSet<>();
	
	@OneToOne(cascade = CascadeType.ALL)
	@JsonbTransient
	@JoinColumn(name = "mizTv_id" , referencedColumnName = "id")
	private MizTv mizTv ;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JsonbTransient
	@JoinColumn(name = "mojasame_id" , referencedColumnName = "id")
	private Mojasame mojasame ;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JsonbTransient
	@JoinColumn(name = "monabat_id" , referencedColumnName = "id")
	private Monabat monabat;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JsonbTransient
	@JoinColumn(name = "moblman_id" , referencedColumnName = "id")
	private Moblman moblman;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JsonbTransient
	@JoinColumn(name = "mizNaharKhori_id" , referencedColumnName = "id")
	private MizNaharKhori mizNaharKhori;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JsonbTransient
	@JoinColumn(name = "mizJeloMobli_id" , referencedColumnName = "id")
	private MizJeloMobli mizJeloMobli;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JsonbTransient
	@JoinColumn(name = "panjare_id" , referencedColumnName = "id")
	private Panjare panjare;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JsonbTransient
	@JoinColumn(name = "partition_id" , referencedColumnName = "id")
	private Partition partition ;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JsonbTransient
	@JoinColumn(name = "sandaliEdari_id" , referencedColumnName = "id")
	private SandaliEdari sandaliEdari;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JsonbTransient
	@JoinColumn(name = "serviceKhab1_id" , referencedColumnName = "id")
	private ServiceKhab1 serviceKhab1;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JsonbTransient
	@JoinColumn(name = "serviceKhab2_id" , referencedColumnName = "id")
	private ServiceKhab2 serviceKhab2;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JsonbTransient
	@JoinColumn(name = "serviceKhabKodak_id" , referencedColumnName = "id")
	private ServiceKhabKodak serviceKhabKodak;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JsonbTransient
	@JoinColumn(name = "mizEdari_id" , referencedColumnName = "id")
	private MizEdari mizEdari;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JsonbTransient
	@JoinColumn(name = "mizAsali_id" , referencedColumnName = "id")
	private MizAsali mizAsali;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JsonbTransient
	@JoinColumn(name = "ayeneVConsole_id" , referencedColumnName = "id")
	private AyeneVConsole ayeneVConsole;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JsonbTransient
	@JoinColumn(name = "darbChobi_id" , referencedColumnName = "id")
	private DarbChobi darbChobi;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JsonbTransient
	@JoinColumn(name = "darbZedSergat_id" , referencedColumnName = "id")
	private DarbZedSergat darbZedSergat;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JsonbTransient
	@JoinColumn(name = "ghabAx_id" , referencedColumnName = "id")
	private GhabAx ghabAx;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JsonbTransient
	@JoinColumn(name = "kabinet_id" , referencedColumnName = "id")
	private Kabinet kabinet;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JsonbTransient
	@JoinColumn(name = "komodBoofeKetabkhaneJakafshi_id" , referencedColumnName = "id")
	private KomodBoofeKetabkhaneJakafshi komodBoofeKetabkhaneJakafshi;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JsonbTransient
	@JoinColumn(name = "mdf_id" , referencedColumnName = "id")
	private Mdf mdf;
	
	
	public ProductEntity() {
		super();
		// TODO Auto-generated constructor stub
	}




	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}


	public String getNameCode() {
		return nameCode;
	}

	public void setNameCode(String nameCode) {
		this.nameCode = nameCode;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getTahvilDay() {
		return TahvilDay;
	}

	public void setTahvilDay(int tahvilDay) {
		TahvilDay = tahvilDay;
	}

	public String getContry() {
		return contry;
	}

	public void setContry(String contry) {
		this.contry = contry;
	}

	public String getRaste() {
		return raste;
	}

	public void setRaste(String raste) {
		this.raste = raste;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPic1() {
		return pic1;
	}

	public void setPic1(String pic1) {
		this.pic1 = pic1;
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

	public String getPic4() {
		return pic4;
	}

	public void setPic4(String pic4) {
		this.pic4 = pic4;
	}

	public String getPic5() {
		return pic5;
	}

	public void setPic5(String pic5) {
		this.pic5 = pic5;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public boolean isCheckO() {
		return checkO;
	}

	public void setCheckO(boolean checkO) {
		this.checkO = checkO;
	}

	public long getPrice2() {
		return price2;
	}

	public void setPrice2(long price2) {
		this.price2 = price2;
	}



	public boolean isOldNew() {
		return oldNew;
	}

	public void setOldNew(boolean oldNew) {
		this.oldNew = oldNew;
	}

	
	
	/*
	 * public String getNoeMobl() { return noeMobl; }
	 * 
	 * public void setNoeMobl(String noeMobl) { this.noeMobl = noeMobl; }
	 */

	/*
	 * public int getTedadNafar() { return tedadNafar; }
	 * 
	 * public void setTedadNafar(int tedadNafar) { this.tedadNafar = tedadNafar; }
	 * 
	 * public String getNoeMoblRahati() { return noeMoblRahati; }
	 * 
	 * public void setNoeMoblRahati(String noeMoblRahati) { this.noeMoblRahati =
	 * noeMoblRahati; }
	 * 
	 * public String getJenseKalaf() { return jenseKalaf; }
	 * 
	 * public void setJenseKalaf(String jenseKalaf) { this.jenseKalaf = jenseKalaf;
	 * }
	 * 
	 * public String getNoePaye() { return noePaye; }
	 * 
	 * public void setNoePaye(String noePaye) { this.noePaye = noePaye; }
	 * 
	 * public String getJenseLayeMiani() { return jenseLayeMiani; }
	 * 
	 * public void setJenseLayeMiani(String jenseLayeMiani) { this.jenseLayeMiani =
	 * jenseLayeMiani; }
	 */

	/*
	 * public String getJenseParche() { return jenseParche; }
	 * 
	 * public void setJenseParche(String jenseParche) { this.jenseParche =
	 * jenseParche; }
	 */

	public String getZemanat() {
		return zemanat;
	}

	public void setZemanat(String zemanat) {
		this.zemanat = zemanat;
	}

	public String getRangBandi() {
		return rangBandi;
	}

	public void setRangBandi(String rangBandi) {
		this.rangBandi = rangBandi;
	}

	/*
	 * public boolean isKosan() { return kosan; }
	 * 
	 * public void setKosan(boolean kosan) { this.kosan = kosan; }
	 * 
	 * public boolean isMiz() { return miz; }
	 * 
	 * public void setMiz(boolean miz) { this.miz = miz; }
	 */

	public String getAbad() {
		return abad;
	}

	public void setAbad(String abad) {
		this.abad = abad;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Date getpDate() {
		return pDate;
	}

	public void setpDate(Date pDate) {
		this.pDate = pDate;
	}



	public String getGuarantiStatus() {
		return guarantiStatus;
	}

	public void setGuarantiStatus(String guarantiStatus) {
		this.guarantiStatus = guarantiStatus;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	public boolean isEasyNezafat() {
		return EasyNezafat;
	}

	public void setEasyNezafat(boolean easyNezafat) {
		EasyNezafat = easyNezafat;
	}

	public int getGuaranyTimeMounth() {
		return guaranyTimeMounth;
	}

	public void setGuaranyTimeMounth(int guaranyTimeMounth) {
		this.guaranyTimeMounth = guaranyTimeMounth;
	}

	public MoblEntity getProduct() {
		return product;
	}




	public void setProduct(MoblEntity product) {
		this.product = product;
	}


	public String getAparat() {
		return aparat;
	}




	public void setAparat(String aparat) {
		this.aparat = aparat;
	}




	public String getInstagram() {
		return instagram;
	}




	public void setInstagram(String instagram) {
		this.instagram = instagram;
	}




	public Set<SefareshEntity> getProductSefaresh() {
		return productSefaresh;
	}




	public void setProductSefaresh(Set<SefareshEntity> productSefaresh) {
		this.productSefaresh = productSefaresh;
	}




	public Set<OfferEntity> getProductOffer() {
		return productOffer;
	}




	public void setProductOffer(Set<OfferEntity> productOffer) {
		this.productOffer = productOffer;
	}




	public String getProType() {
		return proType;
	}




	public void setProType(String proType) {
		this.proType = proType;
	}




	public MizTv getMizTv() {
		return mizTv;
	}




	public void setMizTv(MizTv mizTv) {
		this.mizTv = mizTv;
	}




	public Mojasame getMojasame() {
		return mojasame;
	}




	public void setMojasame(Mojasame mojasame) {
		this.mojasame = mojasame;
	}




	public Monabat getMonabat() {
		return monabat;
	}




	public void setMonabat(Monabat monabat) {
		this.monabat = monabat;
	}




	public Moblman getMoblman() {
		return moblman;
	}




	public void setMoblman(Moblman moblman) {
		this.moblman = moblman;
	}




	public MizNaharKhori getMizNaharKhori() {
		return mizNaharKhori;
	}




	public void setMizNaharKhori(MizNaharKhori mizNaharKhori) {
		this.mizNaharKhori = mizNaharKhori;
	}




	public MizJeloMobli getMizJeloMobli() {
		return mizJeloMobli;
	}




	public void setMizJeloMobli(MizJeloMobli mizJeloMobli) {
		this.mizJeloMobli = mizJeloMobli;
	}




	public Panjare getPanjare() {
		return panjare;
	}




	public void setPanjare(Panjare panjare) {
		this.panjare = panjare;
	}




	public Partition getPartition() {
		return partition;
	}




	public void setPartition(Partition partition) {
		this.partition = partition;
	}




	public SandaliEdari getSandaliEdari() {
		return sandaliEdari;
	}




	public void setSandaliEdari(SandaliEdari sandaliEdari) {
		this.sandaliEdari = sandaliEdari;
	}




	public ServiceKhab1 getServiceKhab1() {
		return serviceKhab1;
	}




	public void setServiceKhab1(ServiceKhab1 serviceKhab1) {
		this.serviceKhab1 = serviceKhab1;
	}




	public ServiceKhab2 getServiceKhab2() {
		return serviceKhab2;
	}




	public void setServiceKhab2(ServiceKhab2 serviceKhab2) {
		this.serviceKhab2 = serviceKhab2;
	}




	public ServiceKhabKodak getServiceKhabKodak() {
		return serviceKhabKodak;
	}




	public void setServiceKhabKodak(ServiceKhabKodak serviceKhabKodak) {
		this.serviceKhabKodak = serviceKhabKodak;
	}




	public MizEdari getMizEdari() {
		return mizEdari;
	}




	public void setMizEdari(MizEdari mizEdari) {
		this.mizEdari = mizEdari;
	}




	public MizAsali getMizAsali() {
		return mizAsali;
	}




	public void setMizAsali(MizAsali mizAsali) {
		this.mizAsali = mizAsali;
	}




	public AyeneVConsole getAyeneVConsole() {
		return ayeneVConsole;
	}




	public void setAyeneVConsole(AyeneVConsole ayeneVConsole) {
		this.ayeneVConsole = ayeneVConsole;
	}




	public DarbChobi getDarbChobi() {
		return darbChobi;
	}




	public void setDarbChobi(DarbChobi darbChobi) {
		this.darbChobi = darbChobi;
	}




	public DarbZedSergat getDarbZedSergat() {
		return darbZedSergat;
	}




	public void setDarbZedSergat(DarbZedSergat darbZedSergat) {
		this.darbZedSergat = darbZedSergat;
	}




	public GhabAx getGhabAx() {
		return ghabAx;
	}




	public void setGhabAx(GhabAx ghabAx) {
		this.ghabAx = ghabAx;
	}




	public Kabinet getKabinet() {
		return kabinet;
	}




	public void setKabinet(Kabinet kabinet) {
		this.kabinet = kabinet;
	}




	public KomodBoofeKetabkhaneJakafshi getKomodBoofeKetabkhaneJakafshi() {
		return komodBoofeKetabkhaneJakafshi;
	}




	public void setKomodBoofeKetabkhaneJakafshi(KomodBoofeKetabkhaneJakafshi komodBoofeKetabkhaneJakafshi) {
		this.komodBoofeKetabkhaneJakafshi = komodBoofeKetabkhaneJakafshi;
	}




	public Mdf getMdf() {
		return mdf;
	}




	public void setMdf(Mdf mdf) {
		this.mdf = mdf;
	}




	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof ProductEntity))
			return false;
		ProductEntity productEntity = (ProductEntity) obj;
		return ((productEntity.productId == this.productId) 
				);
	}


}
