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
@Table(name = "Mdf")
@NamedQueries({
	@NamedQuery(name="findMdfById" , query="SELECT u FROM Mdf u WHERE u.id=:v_id")
})
@Cacheable(value = false)
public class Mdf implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	  @Column(name = "zekhametMdf", nullable = true , length=100) private String
	  zekhametMdf;
	  
	  @Column(name = "abadMdf", nullable = true , length=100) private String
	  abadMdf;
	  
	  @Column(name = "priceMetrMdf", nullable = true) private long priceMetrMdf;
	  
	  @Column(name = "priceTakhfifMetrMdf", nullable = true) private long
	  priceTakhfifMetrMdf;
	  
		@OneToOne(mappedBy = "mdf")
		private ProductEntity product;

	public Mdf() {
		super();
		// TODO Auto-generated constructor stub
	}



	public String getZekhametMdf() {
		return zekhametMdf;
	}

	public void setZekhametMdf(String zekhametMdf) {
		this.zekhametMdf = zekhametMdf;
	}

	public String getAbadMdf() {
		return abadMdf;
	}

	public void setAbadMdf(String abadMdf) {
		this.abadMdf = abadMdf;
	}

	public long getPriceMetrMdf() {
		return priceMetrMdf;
	}

	public void setPriceMetrMdf(long priceMetrMdf) {
		this.priceMetrMdf = priceMetrMdf;
	}

	public long getPriceTakhfifMetrMdf() {
		return priceTakhfifMetrMdf;
	}

	public void setPriceTakhfifMetrMdf(long priceTakhfifMetrMdf) {
		this.priceTakhfifMetrMdf = priceTakhfifMetrMdf;
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
