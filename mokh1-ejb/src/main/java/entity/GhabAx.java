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
@Table(name = "Ghab_Ax")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorValue(value = "GhabAx")
@NamedQueries({
	@NamedQuery(name="findGhabAxById" , query="SELECT u FROM GhabAx u WHERE u.productId=:v_productId")
})
@Cacheable(value = false)
public class GhabAx extends ProductEntity {


	private static final long serialVersionUID = 1L;
	
	  @Column(name = "jenseGabeAx", nullable = true , length=100) private String
	  jenseGabeAx;
	  
	  @Column(name = "abadGabeAx", nullable = true , length=100) private String
	  abadGabeAx;
	  
	  @Column(name = "abadMofidGabeAx", nullable = true , length=100) private
	  String abadMofidGabeAx;
	  
	  

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


	@Override
	public String toString() {
		return "GhabAx [jenseGabeAx=" + jenseGabeAx + ", abadGabeAx=" + abadGabeAx + ", abadMofidGabeAx="
				+ abadMofidGabeAx + "]";
	}
	  
	  

}
