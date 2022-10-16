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
@Table(name = "Ghab_Ax")
@NamedQueries({
	@NamedQuery(name="findGhabAxById" , query="SELECT u FROM GhabAx u WHERE u.id=:v_id")
})
@Cacheable(value = false)
public class GhabAx implements Serializable {


	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	  @Column(name = "jenseGabeAx", nullable = true , length=100) private String
	  jenseGabeAx;
	  
	  @Column(name = "abadGabeAx", nullable = true , length=100) private String
	  abadGabeAx;
	  
	  @Column(name = "abadMofidGabeAx", nullable = true , length=100) private
	  String abadMofidGabeAx;
	  
		@OneToOne(mappedBy = "ghabAx")
		private ProductEntity product;

	public GhabAx() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getJenseGabeAx() {
		return jenseGabeAx;
	}

	public void setJenseGabeAx(String jenseGabeAx) {
		this.jenseGabeAx = jenseGabeAx;
	}

	public String getAbadGabeAx() {
		return abadGabeAx;
	}

	public void setAbadGabeAx(String abadGabeAx) {
		this.abadGabeAx = abadGabeAx;
	}

	public String getAbadMofidGabeAx() {
		return abadMofidGabeAx;
	}

	public void setAbadMofidGabeAx(String abadMofidGabeAx) {
		this.abadMofidGabeAx = abadMofidGabeAx;
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
