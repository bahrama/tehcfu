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
@Table(name = "Komod_Boofe_Ketabkhane_Jakafshi")
@NamedQueries({
	@NamedQuery(name="findKomodBoofeKetabkhaneJakafshiById" , query="SELECT u FROM KomodBoofeKetabkhaneJakafshi u WHERE u.id=:v_id")
})
@Cacheable(value = false)
public class KomodBoofeKetabkhaneJakafshi implements Serializable {


	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	 @Column(name = "shekleHendesikomod", nullable = true , length=100) private
	  String shekleHendesikomod;
	  
	  @Column(name = "shekleHendesiBoofe", nullable = true , length=100) private
	  String shekleHendesiBoofe;
	  
	  @Column(name = "shekleHendesiKetabkhane", nullable = true , length=100)
	  private String shekleHendesiKetabkhane;
	  
	  @Column(name = "shekleHendesiJakafshi", nullable = true , length=100) private
	  String shekleHendesiJakafshi;
	  
	  @Column(name = "jensekomod", nullable = true , length=100) private String
	  jensekomod;
	  
	  @Column(name = "jenseBoofe", nullable = true , length=100) private String
	  jenseBoofe;
	  
	  @Column(name = "jenseKetabkhane", nullable = true , length=100) private
	  String jenseKetabkhane;
	  
	  @Column(name = "jenseJakafshi", nullable = true , length=100) private String
	  jenseJakafshi;
	  
	  @Column(name = "abadkomod", nullable = true , length=100) private String
	  abadkomod;
	  
	  @Column(name = "abadBoofe", nullable = true , length=100) private String
	  abadBoofe;
	  
	  @Column(name = "abadKetabkhane", nullable = true , length=100) private String
	  abadKetabkhane;
	  
	  @Column(name = "abadJakafshi", nullable = true , length=100) private String
	  abadJakafshi;
	  
	  @Column(name = "pricekomod", nullable = true) private long pricekomod;
	  
	  @Column(name = "priceBoofe", nullable = true) private long priceBoofe;
	  
	  @Column(name = "priceKetabkhane", nullable = true) private long
	  priceKetabkhane;
	  
	  @Column(name = "priceJakafshi", nullable = true) private long priceJakafshi;
	  
	  @Column(name = "tedadkomod", nullable = true) private int tedadkomod;
	  
	  @Column(name = "tedadBoofe", nullable = true) private int tedadBoofe;
	  
	  @Column(name = "tedadKetabkhane", nullable = true) private int
	  tedadKetabkhane;
	  
	  @Column(name = "tedadJakafshi", nullable = true) private int tedadJakafshi;

		@OneToOne(mappedBy = "komodBoofeKetabkhaneJakafshi")
		private ProductEntity product;
	  
	public KomodBoofeKetabkhaneJakafshi() {
		super();
		// TODO Auto-generated constructor stub
	}



	public String getShekleHendesikomod() {
		return shekleHendesikomod;
	}

	public void setShekleHendesikomod(String shekleHendesikomod) {
		this.shekleHendesikomod = shekleHendesikomod;
	}

	public String getShekleHendesiBoofe() {
		return shekleHendesiBoofe;
	}

	public void setShekleHendesiBoofe(String shekleHendesiBoofe) {
		this.shekleHendesiBoofe = shekleHendesiBoofe;
	}

	public String getShekleHendesiKetabkhane() {
		return shekleHendesiKetabkhane;
	}

	public void setShekleHendesiKetabkhane(String shekleHendesiKetabkhane) {
		this.shekleHendesiKetabkhane = shekleHendesiKetabkhane;
	}

	public String getShekleHendesiJakafshi() {
		return shekleHendesiJakafshi;
	}

	public void setShekleHendesiJakafshi(String shekleHendesiJakafshi) {
		this.shekleHendesiJakafshi = shekleHendesiJakafshi;
	}

	public String getJensekomod() {
		return jensekomod;
	}

	public void setJensekomod(String jensekomod) {
		this.jensekomod = jensekomod;
	}

	public String getJenseBoofe() {
		return jenseBoofe;
	}

	public void setJenseBoofe(String jenseBoofe) {
		this.jenseBoofe = jenseBoofe;
	}

	public String getJenseKetabkhane() {
		return jenseKetabkhane;
	}

	public void setJenseKetabkhane(String jenseKetabkhane) {
		this.jenseKetabkhane = jenseKetabkhane;
	}

	public String getJenseJakafshi() {
		return jenseJakafshi;
	}

	public void setJenseJakafshi(String jenseJakafshi) {
		this.jenseJakafshi = jenseJakafshi;
	}

	public String getAbadkomod() {
		return abadkomod;
	}

	public void setAbadkomod(String abadkomod) {
		this.abadkomod = abadkomod;
	}

	public String getAbadBoofe() {
		return abadBoofe;
	}

	public void setAbadBoofe(String abadBoofe) {
		this.abadBoofe = abadBoofe;
	}

	public String getAbadKetabkhane() {
		return abadKetabkhane;
	}

	public void setAbadKetabkhane(String abadKetabkhane) {
		this.abadKetabkhane = abadKetabkhane;
	}

	public String getAbadJakafshi() {
		return abadJakafshi;
	}

	public void setAbadJakafshi(String abadJakafshi) {
		this.abadJakafshi = abadJakafshi;
	}

	public long getPricekomod() {
		return pricekomod;
	}

	public void setPricekomod(long pricekomod) {
		this.pricekomod = pricekomod;
	}

	public long getPriceBoofe() {
		return priceBoofe;
	}

	public void setPriceBoofe(long priceBoofe) {
		this.priceBoofe = priceBoofe;
	}

	public long getPriceKetabkhane() {
		return priceKetabkhane;
	}

	public void setPriceKetabkhane(long priceKetabkhane) {
		this.priceKetabkhane = priceKetabkhane;
	}

	public long getPriceJakafshi() {
		return priceJakafshi;
	}

	public void setPriceJakafshi(long priceJakafshi) {
		this.priceJakafshi = priceJakafshi;
	}

	public int getTedadkomod() {
		return tedadkomod;
	}

	public void setTedadkomod(int tedadkomod) {
		this.tedadkomod = tedadkomod;
	}

	public int getTedadBoofe() {
		return tedadBoofe;
	}

	public void setTedadBoofe(int tedadBoofe) {
		this.tedadBoofe = tedadBoofe;
	}

	public int getTedadKetabkhane() {
		return tedadKetabkhane;
	}

	public void setTedadKetabkhane(int tedadKetabkhane) {
		this.tedadKetabkhane = tedadKetabkhane;
	}

	public int getTedadJakafshi() {
		return tedadJakafshi;
	}

	public void setTedadJakafshi(int tedadJakafshi) {
		this.tedadJakafshi = tedadJakafshi;
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
