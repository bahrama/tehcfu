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
@Table(name = "Panjare")
@NamedQueries({
	@NamedQuery(name="findPanjareById" , query="SELECT u FROM Panjare u WHERE u.id=:v_id")
})
@Cacheable(value = false)
public class Panjare implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	  @Column(name = "metrialPanjare", nullable = true , length=100) private String
	  metrialPanjare;
	  
	  @Column(name = "noeRangPanjare", nullable = true , length=100) private String
	  noeRangPanjare;
	  
	  @Column(name = "jenseKalafPanjare", nullable = true , length=100) private
	  String jenseKalafPanjare;
	  
	  @Column(name = "makanPanjare", nullable = true , length=100) private String
	  makanPanjare;
	  
	  @Column(name = "cncPanjare", nullable = true) private boolean cncPanjare;
	  
	  @Column(name = "zedeAbPanjare", nullable = true) private boolean
	  zedeAbPanjare;
	  
	  @Column(name = "shostoshoPanjare", nullable = true) private boolean
	  shostoshoPanjare;
	  
		@OneToOne(mappedBy = "panjare")
		private ProductEntity product;

	public Panjare() {
		super();
		// TODO Auto-generated constructor stub
	}



	public String getMetrialPanjare() {
		return metrialPanjare;
	}

	public void setMetrialPanjare(String metrialPanjare) {
		this.metrialPanjare = metrialPanjare;
	}

	public String getNoeRangPanjare() {
		return noeRangPanjare;
	}

	public void setNoeRangPanjare(String noeRangPanjare) {
		this.noeRangPanjare = noeRangPanjare;
	}

	public String getJenseKalafPanjare() {
		return jenseKalafPanjare;
	}

	public void setJenseKalafPanjare(String jenseKalafPanjare) {
		this.jenseKalafPanjare = jenseKalafPanjare;
	}

	public String getMakanPanjare() {
		return makanPanjare;
	}

	public void setMakanPanjare(String makanPanjare) {
		this.makanPanjare = makanPanjare;
	}

	public boolean isCncPanjare() {
		return cncPanjare;
	}

	public void setCncPanjare(boolean cncPanjare) {
		this.cncPanjare = cncPanjare;
	}

	public boolean isZedeAbPanjare() {
		return zedeAbPanjare;
	}

	public void setZedeAbPanjare(boolean zedeAbPanjare) {
		this.zedeAbPanjare = zedeAbPanjare;
	}

	public boolean isShostoshoPanjare() {
		return shostoshoPanjare;
	}

	public void setShostoshoPanjare(boolean shostoshoPanjare) {
		this.shostoshoPanjare = shostoshoPanjare;
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
