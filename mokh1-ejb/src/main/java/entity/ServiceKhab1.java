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
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
@Entity
@Table(name = "service_khab1")
@NamedQueries({
	@NamedQuery(name="findServiceKhab1ById" , query="SELECT u FROM ServiceKhab1 u WHERE u.id=:v_id")
})
@Cacheable(value = false)
public class ServiceKhab1 implements Serializable {


	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@Column(name = "modelServiceKhab", nullable = true , length=100) private
	  String modelServiceKhab;
	@Column(name = "arzeTakhteKhab", nullable = true)
	private int arzeTakhteKhab;
	@Column(name = "jenseTakhtKhab", nullable = true , length=100) private String
	  jenseTakhtKhab;
	  
	  @Column(name = "rangTakhtKhab", nullable = true , length=100) private String
	  rangTakhtKhab;
	  
	  @Column(name = "priceTakhtKhab", nullable = true) private long
	  priceTakhtKhab;
	  
	  @Column(name = "kalafTakhtJakDar", nullable = true) private boolean
	  kalafTakhtJakDar;
	  
	  @Column(name = "keshovbox", nullable = true) private boolean keshovbox;
	@Column(name = "patakhti", nullable = true)
	private boolean patakhti;
	@Column(name = "tedadPaTakhti", nullable = true)
	private int tedadPaTakhti;
	@Column(name = "jensePaTakhti", nullable = true , length=100) private String
	  jensePaTakhti;
	  
	  @Column(name = "abadPaTakhti", nullable = true , length=100) private String
	  abadPaTakhti;
	  
	  @Column(name = "rangPaTakhti", nullable = true , length=100) private String
	  rangPaTakhti;
	  
	  @Column(name = "pricePaTakhti", nullable = true) private long pricePaTakhti;
	@Column(name = "komodServiceKhab", nullable = true) private
	  boolean komodServiceKhab;
	@Column(name = "jenseKomodServiceKhab", nullable = true , length=100) private
	  String jenseKomodServiceKhab;
	@Column(name = "abadKomodServiceKhab", nullable = true , length=100) private
	  String abadKomodServiceKhab;
	@Column(name = "rangKomodServiceKhab", nullable = true , length=100) private
	  String rangKomodServiceKhab;
	@Column(name = "priceKomodServiceKhab", nullable = true) private long
	  priceKomodServiceKhab;
	  
	  @Column(name = "mizArayesh", nullable = true) private boolean mizArayesh;
	@Column(name = "sandaliServiceKhab", nullable = true) private boolean
	  sandaliServiceKhab;
	  
	  @Column(name = "jenseMizArayesh", nullable = true , length=100) private
	  String jenseMizArayesh;
	@Column(name = "abadMizArayesh", nullable = true , length=100) private String
	  abadMizArayesh;
	  
	  @Column(name = "rangMizArayesh", nullable = true , length=100) private String
	  rangMizArayesh;
	  
	  @Column(name = "priceMizArayesh", nullable = true) private long
	  priceMizArayesh;
	  
	  @Column(name = "mizTahrir", nullable = true) private boolean mizTahrir;
	@Column(name = "jenseMizTahrir", nullable = true , length=100) private String
	  jenseMizTahrir;
	  
	  @Column(name = "abadMizTahrir", nullable = true , length=100) private String
	  abadMizTahrir;
	  
	  @Column(name = "rangMizTahrir", nullable = true , length=100) private String
	  rangMizTahrir;
	  
	  @Column(name = "priceMizTahrir", nullable = true) private long
	  priceMizTahrir;
	  
	  @Column(name = "gabVayeneGadi", nullable = true) private boolean
	  gabVayeneGadi;
	  
	  @Column(name = "jenseGabVayeneGadi", nullable = true , length=100) private
	  String jenseGabVayeneGadi;
	@Column(name = "abadGabVayeneGadi", nullable = true , length=100) private
	  String abadGabVayeneGadi;
	@Column(name = "rangGabVayeneGadi", nullable = true , length=100) private
	  String rangGabVayeneGadi;
	@Column(name = "priceGabVayeneGadi", nullable = true) private long
	  priceGabVayeneGadi;
	  
	  @Column(name = "toshak", nullable = true) private boolean toshak;
	@Column(name = "brandToshak", nullable = true , length=100) private String
	  brandToshak;
	  
	  @Column(name = "modelToshak", nullable = true , length=100) private String
	  modelToshak;
	  
	  @Column(name = "mododatGharantiToshak", nullable = true) private int
	  modatGharantiToshak;
	  
	  @Column(name = "abadToshak", nullable = true , length=100) private String
	  abadToshak;
	  
	  @Column(name = "priceToshak", nullable = true) private long priceToshak;
	  
	  @Column(name="tozihatToshak",nullable=true,length=1000)
	  private String tozihatToshak;
	  
		@OneToOne(mappedBy = "serviceKhab1")
		private ProductEntity product;

	public ServiceKhab1() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getModelServiceKhab() {
		return modelServiceKhab;
	}

	public void setModelServiceKhab(String modelServiceKhab) {
		this.modelServiceKhab = modelServiceKhab;
	}

	public int getArzeTakhteKhab() {
		return arzeTakhteKhab;
	}

	public void setArzeTakhteKhab(int arzeTakhteKhab) {
		this.arzeTakhteKhab = arzeTakhteKhab;
	}

	public String getJenseTakhtKhab() {
		return jenseTakhtKhab;
	}

	public void setJenseTakhtKhab(String jenseTakhtKhab) {
		this.jenseTakhtKhab = jenseTakhtKhab;
	}

	public String getRangTakhtKhab() {
		return rangTakhtKhab;
	}

	public void setRangTakhtKhab(String rangTakhtKhab) {
		this.rangTakhtKhab = rangTakhtKhab;
	}

	public long getPriceTakhtKhab() {
		return priceTakhtKhab;
	}

	public void setPriceTakhtKhab(long priceTakhtKhab) {
		this.priceTakhtKhab = priceTakhtKhab;
	}

	public boolean isKalafTakhtJakDar() {
		return kalafTakhtJakDar;
	}

	public void setKalafTakhtJakDar(boolean kalafTakhtJakDar) {
		this.kalafTakhtJakDar = kalafTakhtJakDar;
	}

	public boolean isKeshovbox() {
		return keshovbox;
	}

	public void setKeshovbox(boolean keshovbox) {
		this.keshovbox = keshovbox;
	}

	public boolean isPatakhti() {
		return patakhti;
	}

	public void setPatakhti(boolean patakhti) {
		this.patakhti = patakhti;
	}

	public int getTedadPaTakhti() {
		return tedadPaTakhti;
	}

	public void setTedadPaTakhti(int tedadPaTakhti) {
		this.tedadPaTakhti = tedadPaTakhti;
	}

	public String getJensePaTakhti() {
		return jensePaTakhti;
	}

	public void setJensePaTakhti(String jensePaTakhti) {
		this.jensePaTakhti = jensePaTakhti;
	}

	public String getAbadPaTakhti() {
		return abadPaTakhti;
	}

	public void setAbadPaTakhti(String abadPaTakhti) {
		this.abadPaTakhti = abadPaTakhti;
	}

	public String getRangPaTakhti() {
		return rangPaTakhti;
	}

	public void setRangPaTakhti(String rangPaTakhti) {
		this.rangPaTakhti = rangPaTakhti;
	}

	public long getPricePaTakhti() {
		return pricePaTakhti;
	}

	public void setPricePaTakhti(long pricePaTakhti) {
		this.pricePaTakhti = pricePaTakhti;
	}



	public boolean isKomodServiceKhab() {
		return komodServiceKhab;
	}


	public void setKomodServiceKhab(boolean komodServiceKhab) {
		this.komodServiceKhab = komodServiceKhab;
	}


	public String getJenseKomodServiceKhab() {
		return jenseKomodServiceKhab;
	}

	public void setJenseKomodServiceKhab(String jenseKomodServiceKhab) {
		this.jenseKomodServiceKhab = jenseKomodServiceKhab;
	}

	public String getAbadKomodServiceKhab() {
		return abadKomodServiceKhab;
	}

	public void setAbadKomodServiceKhab(String abadKomodServiceKhab) {
		this.abadKomodServiceKhab = abadKomodServiceKhab;
	}

	public String getRangKomodServiceKhab() {
		return rangKomodServiceKhab;
	}

	public void setRangKomodServiceKhab(String rangKomodServiceKhab) {
		this.rangKomodServiceKhab = rangKomodServiceKhab;
	}

	public long getPriceKomodServiceKhab() {
		return priceKomodServiceKhab;
	}

	public void setPriceKomodServiceKhab(long priceKomodServiceKhab) {
		this.priceKomodServiceKhab = priceKomodServiceKhab;
	}

	public boolean isMizArayesh() {
		return mizArayesh;
	}

	public void setMizArayesh(boolean mizArayesh) {
		this.mizArayesh = mizArayesh;
	}

	public boolean isSandaliServiceKhab() {
		return sandaliServiceKhab;
	}

	public void setSandaliServiceKhab(boolean sandaliServiceKhab) {
		this.sandaliServiceKhab = sandaliServiceKhab;
	}

	public String getJenseMizArayesh() {
		return jenseMizArayesh;
	}

	public void setJenseMizArayesh(String jenseMizArayesh) {
		this.jenseMizArayesh = jenseMizArayesh;
	}

	public String getAbadMizArayesh() {
		return abadMizArayesh;
	}

	public void setAbadMizArayesh(String abadMizArayesh) {
		this.abadMizArayesh = abadMizArayesh;
	}

	public String getRangMizArayesh() {
		return rangMizArayesh;
	}

	public void setRangMizArayesh(String rangMizArayesh) {
		this.rangMizArayesh = rangMizArayesh;
	}

	public long getPriceMizArayesh() {
		return priceMizArayesh;
	}

	public void setPriceMizArayesh(long priceMizArayesh) {
		this.priceMizArayesh = priceMizArayesh;
	}

	public boolean isMizTahrir() {
		return mizTahrir;
	}

	public void setMizTahrir(boolean mizTahrir) {
		this.mizTahrir = mizTahrir;
	}

	public String getJenseMizTahrir() {
		return jenseMizTahrir;
	}

	public void setJenseMizTahrir(String jenseMizTahrir) {
		this.jenseMizTahrir = jenseMizTahrir;
	}

	public String getAbadMizTahrir() {
		return abadMizTahrir;
	}

	public void setAbadMizTahrir(String abadMizTahrir) {
		this.abadMizTahrir = abadMizTahrir;
	}

	public String getRangMizTahrir() {
		return rangMizTahrir;
	}

	public void setRangMizTahrir(String rangMizTahrir) {
		this.rangMizTahrir = rangMizTahrir;
	}

	public long getPriceMizTahrir() {
		return priceMizTahrir;
	}

	public void setPriceMizTahrir(long priceMizTahrir) {
		this.priceMizTahrir = priceMizTahrir;
	}

	public boolean isGabVayeneGadi() {
		return gabVayeneGadi;
	}

	public void setGabVayeneGadi(boolean gabVayeneGadi) {
		this.gabVayeneGadi = gabVayeneGadi;
	}

	public String getJenseGabVayeneGadi() {
		return jenseGabVayeneGadi;
	}

	public void setJenseGabVayeneGadi(String jenseGabVayeneGadi) {
		this.jenseGabVayeneGadi = jenseGabVayeneGadi;
	}

	public String getAbadGabVayeneGadi() {
		return abadGabVayeneGadi;
	}

	public void setAbadGabVayeneGadi(String abadGabVayeneGadi) {
		this.abadGabVayeneGadi = abadGabVayeneGadi;
	}

	public String getRangGabVayeneGadi() {
		return rangGabVayeneGadi;
	}

	public void setRangGabVayeneGadi(String rangGabVayeneGadi) {
		this.rangGabVayeneGadi = rangGabVayeneGadi;
	}

	public long getPriceGabVayeneGadi() {
		return priceGabVayeneGadi;
	}

	public void setPriceGabVayeneGadi(long priceGabVayeneGadi) {
		this.priceGabVayeneGadi = priceGabVayeneGadi;
	}

	public boolean isToshak() {
		return toshak;
	}

	public void setToshak(boolean toshak) {
		this.toshak = toshak;
	}

	public String getBrandToshak() {
		return brandToshak;
	}

	public void setBrandToshak(String brandToshak) {
		this.brandToshak = brandToshak;
	}

	public String getModelToshak() {
		return modelToshak;
	}

	public void setModelToshak(String modelToshak) {
		this.modelToshak = modelToshak;
	}

	public int getModatGharantiToshak() {
		return modatGharantiToshak;
	}

	public void setModatGharantiToshak(int modatGharantiToshak) {
		this.modatGharantiToshak = modatGharantiToshak;
	}

	public String getAbadToshak() {
		return abadToshak;
	}

	public void setAbadToshak(String abadToshak) {
		this.abadToshak = abadToshak;
	}

	public long getPriceToshak() {
		return priceToshak;
	}

	public void setPriceToshak(long priceToshak) {
		this.priceToshak = priceToshak;
	}

	public String getTozihatToshak() {
		return tozihatToshak;
	}

	public void setTozihatToshak(String tozihatToshak) {
		this.tozihatToshak = tozihatToshak;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public ProductEntity getProduct() {
		return product;
	}


	public void setProduct(ProductEntity product) {
		this.product = product;
	}



	  
	  
}
