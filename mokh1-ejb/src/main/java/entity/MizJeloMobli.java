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
@Table(name = "Miz_Jelo_Mobli")
@NamedQueries({
	@NamedQuery(name="findMizJeloMobliById" , query="SELECT u FROM MizJeloMobli u WHERE u.id=:v_id")
})
@Cacheable(value = false)
public class MizJeloMobli  implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	  @Column(name = "sheklehendesiMizJeloMobli", nullable = true , length=100)
	  private String sheklehendesiMizJeloMobli;
	  
	  @Column(name = "tedadMizJeloMobli", nullable = true) private int
	  tedadMizJeloMobli;
	  
	  @Column(name = "jenseEskeletMizJeloMobli", nullable = true , length=100)
	  private String jenseEskeletMizJeloMobli;
	  
	  @Column(name = "jensePayeMizJeloMobli", nullable = true , length=100) private
	  String jensePayeMizJeloMobli;
	  
	  @Column(name = "abadMizJeloMobli", nullable = true , length=100) private
	  String abadMizJeloMobli;
	  
	  @Column(name = "rangMizJeloMobli", nullable = true , length=100) private
	  String rangMizJeloMobli;
	  
	  @Column(name = "priceMizJeloMobli", nullable = true) private long
	  priceMizJeloMobli;
	  
	  @Column(name = "shisheMizJeloMobli", nullable = true) private boolean
	  shisheMizJeloMobli;
	  
	  @Column(name = "noeShisheMizJeloMobli", nullable = true , length=100) private
	  String noeShisheMizJeloMobli;
	  
	  @Column(name = "priceShisheMizJeloMobli", nullable = true) private long
	  priceShisheMizJeloMobli;
	  
	  @Column(name = "shisheAbzarMizJeloMobli", nullable = true) private boolean
	  shisheAbzarMizJeloMobli;
	  
		@OneToOne(mappedBy = "mizJeloMobli")
		private ProductEntity product;

	public MizJeloMobli() {
		super();
		// TODO Auto-generated constructor stub
	}



	public String getSheklehendesiMizJeloMobli() {
		return sheklehendesiMizJeloMobli;
	}

	public void setSheklehendesiMizJeloMobli(String sheklehendesiMizJeloMobli) {
		this.sheklehendesiMizJeloMobli = sheklehendesiMizJeloMobli;
	}

	public int getTedadMizJeloMobli() {
		return tedadMizJeloMobli;
	}

	public void setTedadMizJeloMobli(int tedadMizJeloMobli) {
		this.tedadMizJeloMobli = tedadMizJeloMobli;
	}

	public String getJenseEskeletMizJeloMobli() {
		return jenseEskeletMizJeloMobli;
	}

	public void setJenseEskeletMizJeloMobli(String jenseEskeletMizJeloMobli) {
		this.jenseEskeletMizJeloMobli = jenseEskeletMizJeloMobli;
	}

	public String getJensePayeMizJeloMobli() {
		return jensePayeMizJeloMobli;
	}

	public void setJensePayeMizJeloMobli(String jensePayeMizJeloMobli) {
		this.jensePayeMizJeloMobli = jensePayeMizJeloMobli;
	}

	public String getAbadMizJeloMobli() {
		return abadMizJeloMobli;
	}

	public void setAbadMizJeloMobli(String abadMizJeloMobli) {
		this.abadMizJeloMobli = abadMizJeloMobli;
	}

	public String getRangMizJeloMobli() {
		return rangMizJeloMobli;
	}

	public void setRangMizJeloMobli(String rangMizJeloMobli) {
		this.rangMizJeloMobli = rangMizJeloMobli;
	}

	public long getPriceMizJeloMobli() {
		return priceMizJeloMobli;
	}

	public void setPriceMizJeloMobli(long priceMizJeloMobli) {
		this.priceMizJeloMobli = priceMizJeloMobli;
	}

	public boolean isShisheMizJeloMobli() {
		return shisheMizJeloMobli;
	}

	public void setShisheMizJeloMobli(boolean shisheMizJeloMobli) {
		this.shisheMizJeloMobli = shisheMizJeloMobli;
	}

	public String getNoeShisheMizJeloMobli() {
		return noeShisheMizJeloMobli;
	}

	public void setNoeShisheMizJeloMobli(String noeShisheMizJeloMobli) {
		this.noeShisheMizJeloMobli = noeShisheMizJeloMobli;
	}

	public long getPriceShisheMizJeloMobli() {
		return priceShisheMizJeloMobli;
	}

	public void setPriceShisheMizJeloMobli(long priceShisheMizJeloMobli) {
		this.priceShisheMizJeloMobli = priceShisheMizJeloMobli;
	}

	public boolean isShisheAbzarMizJeloMobli() {
		return shisheAbzarMizJeloMobli;
	}

	public void setShisheAbzarMizJeloMobli(boolean shisheAbzarMizJeloMobli) {
		this.shisheAbzarMizJeloMobli = shisheAbzarMizJeloMobli;
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
