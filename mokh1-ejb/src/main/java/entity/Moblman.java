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
@Table(name = "Moblman")
@NamedQueries({
	@NamedQuery(name="findMoblmanById" , query="SELECT u FROM Moblman u WHERE u.id=:v_id")
})
@Cacheable(value = false)
public class Moblman implements Serializable{


	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	 @Column(name = "noeMobl", nullable = true , length=100) private String
	  noeMobl;
	  
	  @Column(name = "tedadMobl", nullable = true) private int tedadMobl;
	  
	  @Column(name = "sakhtarMobl", nullable = true , length=100) private String
	  sakhtarMobl;
	  
	  @Column(name = "jenseFome", nullable = true , length=100) private String
	  jenseFome;
	  
	  @Column(name = "jenseEsfanj", nullable = true , length=100) private String
	  jenseEsfanj;
	  
	  @Column(name = "jenseEskelet", nullable = true , length=100) private String
	  jenseEskelet;
	  
	  @Column(name = "jensePaye", nullable = true , length=100) private String
	  jensePaye;
	  
	  @Column(name = "EnetekhabRangPaye", nullable = true) private boolean
	  enetekhabRangPaye;
	  
	  @Column(name = "rangPaye", nullable = true , length=100) private String
	  rangPaye;
	  
	  @Column(name = "jenseParche", nullable = true , length=100) private String
	  jenseParche;
	  
	  @Column(name = "nameParche", nullable = true , length=100) private String
	  nameParche;
	  
	  @Column(name = "EnetekhabRangParche", nullable = true) private boolean
	  enetekhabRangParche;
	  
	  @Column(name = "rangParche", nullable = true , length=100) private String
	  rangParche;
	  
	  @Column(name = "mekanizmTakhtsho", nullable = true) private boolean
	  mekanizmTakhtsho;
	  
	  @Column(name = "descriptionMekanizmTakhtsho", nullable = true , length=1000)
	  private String descriptionMekanizmTakhtsho;
	  
	  @Column(name = "kosan", nullable = true) private boolean kosan;
	  
	  @Column(name = "tedadKosan", nullable = true) private int tedadKosan;
	  
	  @Column(name = "abadKosanBozorg", nullable = true , length=100) private
	  String abadKosanBozorg;
	  
	  @Column(name = "abadKosanKochak", nullable = true , length=100) private
	  String abadKosanKochak;
	  
	  @Column(name = "modelKosan", nullable = true , length=100) private String
	  modelKosan;
	  
	  @Column(name = "jenseParcheKosan", nullable = true , length=100) private
	  String jenseParcheKosan;
	  
	  @Column(name = "rangeParcheKosan", nullable = true , length=100) private
	  String rangeParcheKosan;
	  
	  @Column(name = "miz", nullable = true) private boolean miz;
	  
	  @Column(name = "tedadMiz", nullable = true) private int tedadMiz;
	  
	  @Column(name = "abadMiz", nullable = true , length=100) private String
	  abadMiz;
	  
		@OneToOne(mappedBy = "moblman")
		private ProductEntity product;

	public Moblman() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getNoeMobl() {
		return noeMobl;
	}

	public void setNoeMobl(String noeMobl) {
		this.noeMobl = noeMobl;
	}

	public int getTedadMobl() {
		return tedadMobl;
	}

	public void setTedadMobl(int tedadMobl) {
		this.tedadMobl = tedadMobl;
	}

	public String getSakhtarMobl() {
		return sakhtarMobl;
	}

	public void setSakhtarMobl(String sakhtarMobl) {
		this.sakhtarMobl = sakhtarMobl;
	}

	public String getJenseFome() {
		return jenseFome;
	}

	public void setJenseFome(String jenseFome) {
		this.jenseFome = jenseFome;
	}

	public String getJenseEsfanj() {
		return jenseEsfanj;
	}

	public void setJenseEsfanj(String jenseEsfanj) {
		this.jenseEsfanj = jenseEsfanj;
	}

	public String getJenseEskelet() {
		return jenseEskelet;
	}

	public void setJenseEskelet(String jenseEskelet) {
		this.jenseEskelet = jenseEskelet;
	}

	public String getJensePaye() {
		return jensePaye;
	}

	public void setJensePaye(String jensePaye) {
		this.jensePaye = jensePaye;
	}

	

	public String getRangPaye() {
		return rangPaye;
	}

	public void setRangPaye(String rangPaye) {
		this.rangPaye = rangPaye;
	}

	public String getJenseParche() {
		return jenseParche;
	}

	public void setJenseParche(String jenseParche) {
		this.jenseParche = jenseParche;
	}

	public String getNameParche() {
		return nameParche;
	}

	public void setNameParche(String nameParche) {
		this.nameParche = nameParche;
	}

	

	public boolean isEnetekhabRangPaye() {
		return enetekhabRangPaye;
	}


	public void setEnetekhabRangPaye(boolean enetekhabRangPaye) {
		this.enetekhabRangPaye = enetekhabRangPaye;
	}


	public boolean isEnetekhabRangParche() {
		return enetekhabRangParche;
	}


	public void setEnetekhabRangParche(boolean enetekhabRangParche) {
		this.enetekhabRangParche = enetekhabRangParche;
	}


	public String getRangParche() {
		return rangParche;
	}

	public void setRangParche(String rangParche) {
		this.rangParche = rangParche;
	}

	public boolean isMekanizmTakhtsho() {
		return mekanizmTakhtsho;
	}

	public void setMekanizmTakhtsho(boolean mekanizmTakhtsho) {
		this.mekanizmTakhtsho = mekanizmTakhtsho;
	}

	public String getDescriptionMekanizmTakhtsho() {
		return descriptionMekanizmTakhtsho;
	}

	public void setDescriptionMekanizmTakhtsho(String descriptionMekanizmTakhtsho) {
		this.descriptionMekanizmTakhtsho = descriptionMekanizmTakhtsho;
	}

	public boolean isKosan() {
		return kosan;
	}

	public void setKosan(boolean kosan) {
		this.kosan = kosan;
	}

	public int getTedadKosan() {
		return tedadKosan;
	}

	public void setTedadKosan(int tedadKosan) {
		this.tedadKosan = tedadKosan;
	}

	public String getAbadKosanBozorg() {
		return abadKosanBozorg;
	}

	public void setAbadKosanBozorg(String abadKosanBozorg) {
		this.abadKosanBozorg = abadKosanBozorg;
	}

	public String getAbadKosanKochak() {
		return abadKosanKochak;
	}

	public void setAbadKosanKochak(String abadKosanKochak) {
		this.abadKosanKochak = abadKosanKochak;
	}

	public String getModelKosan() {
		return modelKosan;
	}

	public void setModelKosan(String modelKosan) {
		this.modelKosan = modelKosan;
	}

	public String getJenseParcheKosan() {
		return jenseParcheKosan;
	}

	public void setJenseParcheKosan(String jenseParcheKosan) {
		this.jenseParcheKosan = jenseParcheKosan;
	}

	public String getRangeParcheKosan() {
		return rangeParcheKosan;
	}

	public void setRangeParcheKosan(String rangeParcheKosan) {
		this.rangeParcheKosan = rangeParcheKosan;
	}

	public boolean isMiz() {
		return miz;
	}

	public void setMiz(boolean miz) {
		this.miz = miz;
	}

	public int getTedadMiz() {
		return tedadMiz;
	}

	public void setTedadMiz(int tedadMiz) {
		this.tedadMiz = tedadMiz;
	}

	public String getAbadMiz() {
		return abadMiz;
	}

	public void setAbadMiz(String abadMiz) {
		this.abadMiz = abadMiz;
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
