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
@Table(name = "Mdf")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorValue(value = "Mdf")
@NamedQueries({
	@NamedQuery(name="findMdfById" , query="SELECT u FROM Mdf u WHERE u.productId=:v_productId")
})
@Cacheable(value = false)
public class Mdf extends ProductEntity {

	private static final long serialVersionUID = 1L;
	
	  @Column(name = "zekhametMdf", nullable = true , length=100) private String
	  zekhametMdf;
	  
	  @Column(name = "abadMdf", nullable = true , length=100) private String
	  abadMdf;
	  
	  @Column(name = "priceMetrMdf", nullable = true) private long priceMetrMdf;
	  
	  @Column(name = "priceTakhfifMetrMdf", nullable = true) private long
	  priceTakhfifMetrMdf;
	  
	  

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



	@Override
	public String toString() {
		return "Mdf [zekhametMdf=" + zekhametMdf + ", abadMdf=" + abadMdf + ", priceMetrMdf=" + priceMetrMdf
				+ ", priceTakhfifMetrMdf=" + priceTakhfifMetrMdf + "]";
	}

	  
	  
}
