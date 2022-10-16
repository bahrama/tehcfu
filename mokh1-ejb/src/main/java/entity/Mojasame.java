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
@Table(name = "Mojasame")
@NamedQueries({
	@NamedQuery(name="findMojasameById" , query="SELECT u FROM Mojasame u WHERE u.id=:v_id")
})
@Cacheable(value = false)
public class Mojasame implements Serializable {

	private static final long serialVersionUID = 1L;
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "id")
		private long id;
	
	  @Column(name = "jenseMojasame", nullable = true , length=100) private String
	  jenseMojasame;
	  
	  @Column(name = "abadMojasame", nullable = true , length=100) private String
	  abadMojasame;
	  
	  @Column(name = "shostoshoMojasame", nullable = true) private boolean
	  shostoshoMojasame;
	  
		@OneToOne(mappedBy = "mojasame")
		private ProductEntity product;

	public Mojasame() {
		super();
		// TODO Auto-generated constructor stub
	}



	public String getJenseMojasame() {
		return jenseMojasame;
	}

	public void setJenseMojasame(String jenseMojasame) {
		this.jenseMojasame = jenseMojasame;
	}

	public String getAbadMojasame() {
		return abadMojasame;
	}

	public void setAbadMojasame(String abadMojasame) {
		this.abadMojasame = abadMojasame;
	}

	public boolean isShostoshoMojasame() {
		return shostoshoMojasame;
	}

	public void setShostoshoMojasame(boolean shostoshoMojasame) {
		this.shostoshoMojasame = shostoshoMojasame;
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
