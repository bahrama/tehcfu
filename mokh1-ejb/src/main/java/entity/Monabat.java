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
@Table(name = "Monabat")
@NamedQueries({
	@NamedQuery(name="findMonabatById" , query="SELECT u FROM Monabat u WHERE u.id=:v_id")
})
@Cacheable(value = false)
public class Monabat implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	  @Column(name = "nameMdfMonabat", nullable = true , length=100) private String
	  nameMdfMonabat;
	  
	  @Column(name = "zekhamatMdfMonabat", nullable = true , length=100) private
	  String zekhamatMdfMonabat;
	  
	  @Column(name = "keshvarMdfMonabat", nullable = true , length=100) private
	  String keshvarMdfMonabat;
	  
	  @Column(name = "noeMonabat", nullable = true , length=100) private String
	  noeMonabat;
	  
	  @Column(name = "abadMonabat", nullable = true , length=100) private String
	  abadMonabat;
	  
	  @Column(name = "jenseMonabat", nullable = true , length=100) private String
	  jenseMonabat;
	  
	    @OneToOne(mappedBy = "monabat")
		private ProductEntity product;
	  

	public Monabat() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getNameMdfMonabat() {
		return nameMdfMonabat;
	}

	public void setNameMdfMonabat(String nameMdfMonabat) {
		this.nameMdfMonabat = nameMdfMonabat;
	}

	public String getZekhamatMdfMonabat() {
		return zekhamatMdfMonabat;
	}

	public void setZekhamatMdfMonabat(String zekhamatMdfMonabat) {
		this.zekhamatMdfMonabat = zekhamatMdfMonabat;
	}

	public String getKeshvarMdfMonabat() {
		return keshvarMdfMonabat;
	}

	public void setKeshvarMdfMonabat(String keshvarMdfMonabat) {
		this.keshvarMdfMonabat = keshvarMdfMonabat;
	}

	public String getNoeMonabat() {
		return noeMonabat;
	}

	public void setNoeMonabat(String noeMonabat) {
		this.noeMonabat = noeMonabat;
	}

	public String getAbadMonabat() {
		return abadMonabat;
	}

	public void setAbadMonabat(String abadMonabat) {
		this.abadMonabat = abadMonabat;
	}

	public String getJenseMonabat() {
		return jenseMonabat;
	}

	public void setJenseMonabat(String jenseMonabat) {
		this.jenseMonabat = jenseMonabat;
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
