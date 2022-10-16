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
@Table(name = "Sandali_Edari")
@NamedQueries({
	@NamedQuery(name="findSandaliEdariById" , query="SELECT u FROM SandaliEdari u WHERE u.id=:v_id")
})
@Cacheable(value = false)
public class SandaliEdari implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	  @Column(name = "noeJenseSandaliEdari", nullable = true , length=100) private
	  String noeJenseSandaliEdari;
	  
	  @Column(name = "abadSandaliEdari", nullable = true , length=100) private
	  String abadSandaliEdari;
	  
	  @Column(name = "rangSandaliEdari", nullable = true , length=100) private
	  String rangSandaliEdari;
	  
	  @Column(name = "jensePayeSandaliEdari", nullable = true , length=100) private
	  String jensePayeSandaliEdari;
	  
	  @Column(name = "dasteSandaliEdari", nullable = true) private boolean
	  dasteSandaliEdari;
	  
	  @Column(name = "noeSandaliEdari", nullable = true , length=100) private
	  String noeSandaliEdari;
	  
	  @Column(name = "tebiSandaliEdari", nullable = true) private boolean
	  tebiSandaliEdari;
	  
		@OneToOne(mappedBy = "sandaliEdari")
		private ProductEntity product;

	public SandaliEdari() {
		super();
		// TODO Auto-generated constructor stub
	}



	public String getNoeJenseSandaliEdari() {
		return noeJenseSandaliEdari;
	}

	public void setNoeJenseSandaliEdari(String noeJenseSandaliEdari) {
		this.noeJenseSandaliEdari = noeJenseSandaliEdari;
	}

	public String getAbadSandaliEdari() {
		return abadSandaliEdari;
	}

	public void setAbadSandaliEdari(String abadSandaliEdari) {
		this.abadSandaliEdari = abadSandaliEdari;
	}

	public String getRangSandaliEdari() {
		return rangSandaliEdari;
	}

	public void setRangSandaliEdari(String rangSandaliEdari) {
		this.rangSandaliEdari = rangSandaliEdari;
	}

	public String getJensePayeSandaliEdari() {
		return jensePayeSandaliEdari;
	}

	public void setJensePayeSandaliEdari(String jensePayeSandaliEdari) {
		this.jensePayeSandaliEdari = jensePayeSandaliEdari;
	}

	public boolean isDasteSandaliEdari() {
		return dasteSandaliEdari;
	}

	public void setDasteSandaliEdari(boolean dasteSandaliEdari) {
		this.dasteSandaliEdari = dasteSandaliEdari;
	}

	public String getNoeSandaliEdari() {
		return noeSandaliEdari;
	}

	public void setNoeSandaliEdari(String noeSandaliEdari) {
		this.noeSandaliEdari = noeSandaliEdari;
	}

	public boolean isTebiSandaliEdari() {
		return tebiSandaliEdari;
	}

	public void setTebiSandaliEdari(boolean tebiSandaliEdari) {
		this.tebiSandaliEdari = tebiSandaliEdari;
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
