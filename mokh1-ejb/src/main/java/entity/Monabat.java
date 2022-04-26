package entity;

import java.util.Date;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
@Entity
@Table(name = "Monabat")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorValue(value = "Monabat")
@NamedQueries({
	@NamedQuery(name="findMonabatById" , query="SELECT u FROM Monabat u WHERE u.productId=:v_productId")
})
@Cacheable(value = false)
public class Monabat extends ProductEntity {

	private static final long serialVersionUID = 1L;

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


	@Override
	public String toString() {
		return "Monabat [nameMdfMonabat=" + nameMdfMonabat + ", zekhamatMdfMonabat=" + zekhamatMdfMonabat
				+ ", keshvarMdfMonabat=" + keshvarMdfMonabat + ", noeMonabat=" + noeMonabat + ", abadMonabat="
				+ abadMonabat + ", jenseMonabat=" + jenseMonabat + "]";
	}
	  
	  
}
