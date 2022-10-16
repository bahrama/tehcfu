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
@Table(name = "Miz_Asali")
@NamedQueries({
	@NamedQuery(name="findMizAsaliById" , query="SELECT u FROM MizAsali u WHERE u.id=:v_id")
})
@Cacheable(value = false)
public class MizAsali implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	 @Column(name = "sheklehendesiMizJeJeloAsali", nullable = true , length=100)
	  private String sheklehendesiMizJeJeloAsali;
	  
	  @Column(name = "tedadMizJeJeloAsali", nullable = true) private int
	  tedadMizJeJeloAsali;
	  
	  @Column(name = "jenseEskeletMizJeJeloAsali", nullable = true , length=100)
	  private String jenseEskeletMizJeJeloAsali;
	  
	  @Column(name = "jensePayeMizJeJeloAsali", nullable = true , length=100)
	  private String jensePayeMizJeJeloAsali;
	  
	  @Column(name = "shisheMizJeJeloAsali", nullable = true) private boolean
	  shisheMizJeJeloAsali;
	  
	  @Column(name = "noeShisheMizJeJeloAsali", nullable = true , length=100)
	  private String noeShisheMizJeJeloAsali;
	  
	  @Column(name = "priceShisheMizJeJeloAsali", nullable = true) private long
	  priceShisheMizJeJeloAsali;
	  
	  @Column(name = "descriptionMizJeJeloAsali", nullable = true , length=1000)
	  private String descriptionMizJeJeloAsali;
	  
		@OneToOne(mappedBy = "mizAsali")
		private ProductEntity product;

	public MizAsali() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getSheklehendesiMizJeJeloAsali() {
		return sheklehendesiMizJeJeloAsali;
	}

	public void setSheklehendesiMizJeJeloAsali(String sheklehendesiMizJeJeloAsali) {
		this.sheklehendesiMizJeJeloAsali = sheklehendesiMizJeJeloAsali;
	}

	public int getTedadMizJeJeloAsali() {
		return tedadMizJeJeloAsali;
	}

	public void setTedadMizJeJeloAsali(int tedadMizJeJeloAsali) {
		this.tedadMizJeJeloAsali = tedadMizJeJeloAsali;
	}

	public String getJenseEskeletMizJeJeloAsali() {
		return jenseEskeletMizJeJeloAsali;
	}

	public void setJenseEskeletMizJeJeloAsali(String jenseEskeletMizJeJeloAsali) {
		this.jenseEskeletMizJeJeloAsali = jenseEskeletMizJeJeloAsali;
	}

	public String getJensePayeMizJeJeloAsali() {
		return jensePayeMizJeJeloAsali;
	}

	public void setJensePayeMizJeJeloAsali(String jensePayeMizJeJeloAsali) {
		this.jensePayeMizJeJeloAsali = jensePayeMizJeJeloAsali;
	}

	public boolean isShisheMizJeJeloAsali() {
		return shisheMizJeJeloAsali;
	}

	public void setShisheMizJeJeloAsali(boolean shisheMizJeJeloAsali) {
		this.shisheMizJeJeloAsali = shisheMizJeJeloAsali;
	}

	public String getNoeShisheMizJeJeloAsali() {
		return noeShisheMizJeJeloAsali;
	}

	public void setNoeShisheMizJeJeloAsali(String noeShisheMizJeJeloAsali) {
		this.noeShisheMizJeJeloAsali = noeShisheMizJeJeloAsali;
	}

	public long getPriceShisheMizJeJeloAsali() {
		return priceShisheMizJeJeloAsali;
	}

	public void setPriceShisheMizJeJeloAsali(long priceShisheMizJeJeloAsali) {
		this.priceShisheMizJeJeloAsali = priceShisheMizJeJeloAsali;
	}

	public String getDescriptionMizJeJeloAsali() {
		return descriptionMizJeJeloAsali;
	}

	public void setDescriptionMizJeJeloAsali(String descriptionMizJeJeloAsali) {
		this.descriptionMizJeJeloAsali = descriptionMizJeJeloAsali;
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
