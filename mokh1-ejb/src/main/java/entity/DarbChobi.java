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
@Table(name = "Darb_Chobi")
@NamedQueries({
	@NamedQuery(name="findDarbChobiById" , query="SELECT u FROM DarbChobi u WHERE u.id=:v_id")
})
@Cacheable(value = false)
public class DarbChobi implements Serializable{


	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	 @Column(name = "rokeshDarbChobi", nullable = true , length=100) private
	  String rokeshDarbChobi;
	  
	  @Column(name = "noeRangDarbChobi", nullable = true , length=100) private
	  String noeRangDarbChobi;
	  
	  @Column(name = "zekhamatDarbChobi", nullable = true , length=100) private
	  String zekhamatDarbChobi;
	  
	  @Column(name = "jenseKalafDarbChobi", nullable = true , length=100) private
	  String jenseKalafDarbChobi;
	  
	  @Column(name = "makanDarbChobi", nullable = true , length=100) private String
	  makanDarbChobi;
	  
	  @Column(name = "cncDarbChobi", nullable = true) private boolean cncDarbChobi;
	  
	  @Column(name = "zedeAbDarbChobi", nullable = true) private boolean
	  zedeAbDarbChobi;
	  
	  @Column(name = "shostoshoDarbChobi", nullable = true) private boolean
	  shostoshoDarbChobi;
	  
	  
		@OneToOne(mappedBy = "darbChobi")
		private ProductEntity product;

	public DarbChobi() {
		super();
		// TODO Auto-generated constructor stub
	}



	public String getRokeshDarbChobi() {
		return rokeshDarbChobi;
	}

	public void setRokeshDarbChobi(String rokeshDarbChobi) {
		this.rokeshDarbChobi = rokeshDarbChobi;
	}

	public String getNoeRangDarbChobi() {
		return noeRangDarbChobi;
	}

	public void setNoeRangDarbChobi(String noeRangDarbChobi) {
		this.noeRangDarbChobi = noeRangDarbChobi;
	}

	public String getZekhamatDarbChobi() {
		return zekhamatDarbChobi;
	}

	public void setZekhamatDarbChobi(String zekhamatDarbChobi) {
		this.zekhamatDarbChobi = zekhamatDarbChobi;
	}

	public String getJenseKalafDarbChobi() {
		return jenseKalafDarbChobi;
	}

	public void setJenseKalafDarbChobi(String jenseKalafDarbChobi) {
		this.jenseKalafDarbChobi = jenseKalafDarbChobi;
	}

	public String getMakanDarbChobi() {
		return makanDarbChobi;
	}

	public void setMakanDarbChobi(String makanDarbChobi) {
		this.makanDarbChobi = makanDarbChobi;
	}

	public boolean isCncDarbChobi() {
		return cncDarbChobi;
	}

	public void setCncDarbChobi(boolean cncDarbChobi) {
		this.cncDarbChobi = cncDarbChobi;
	}

	public boolean isZedeAbDarbChobi() {
		return zedeAbDarbChobi;
	}

	public void setZedeAbDarbChobi(boolean zedeAbDarbChobi) {
		this.zedeAbDarbChobi = zedeAbDarbChobi;
	}

	public boolean isShostoshoDarbChobi() {
		return shostoshoDarbChobi;
	}

	public void setShostoshoDarbChobi(boolean shostoshoDarbChobi) {
		this.shostoshoDarbChobi = shostoshoDarbChobi;
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
