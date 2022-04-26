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
@Table(name = "Mojasame")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorValue(value = "Mojasame")
@NamedQueries({
	@NamedQuery(name="findMojasameById" , query="SELECT u FROM Mojasame u WHERE u.productId=:v_productId")
})
@Cacheable(value = false)
public class Mojasame extends ProductEntity {

	private static final long serialVersionUID = 1L;
	
	  @Column(name = "jenseMojasame", nullable = true , length=100) private String
	  jenseMojasame;
	  
	  @Column(name = "abadMojasame", nullable = true , length=100) private String
	  abadMojasame;
	  
	  @Column(name = "shostoshoMojasame", nullable = true) private boolean
	  shostoshoMojasame;
	  
	  

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



	@Override
	public String toString() {
		return "Mojasame [jenseMojasame=" + jenseMojasame + ", abadMojasame=" + abadMojasame + ", shostoshoMojasame="
				+ shostoshoMojasame + "]";
	}
	  
	  

}
