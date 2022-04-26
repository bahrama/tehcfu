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
@Table(name = "Partition")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorValue(value = "Partition")
@NamedQueries({
	@NamedQuery(name="findPartitionById" , query="SELECT u FROM Partition u WHERE u.productId=:v_productId")
})
@Cacheable(value = false)
public class Partition extends ProductEntity {


	private static final long serialVersionUID = 1L;
	
	 @Column(name = "jenseSotonPartishen", nullable = true , length=100) private
	  String jenseSotonPartishen;
	  
	  @Column(name = "jensePanelPartishen", nullable = true , length=100) private
	  String jensePanelPartishen;
	  
	  @Column(name = "jenseLabePartishen", nullable = true , length=100) private
	  String jenseLabePartishen;
	  
	  @Column(name = "rangPartishen", nullable = true , length=100) private String
	  rangPartishen;
	  
	  @Column(name = "tarkibiPartishen", nullable = true) private boolean
	  tarkibiPartishen;
	  
	  @Column(name = "noeTarkibPartishen", nullable = true , length=100) private
	  String noeTarkibPartishen;
	  
	  @Column(name = "ejrayePardePartishen", nullable = true) private boolean
	  ejrayePardePartishen;
	  
	  @Column(name = "rangPardePartishen", nullable = true , length=100) private
	  String rangPardePartishen;
	  
	  @Column(name = "priceMetrPartishen", nullable = true) private long
	  priceMetrPartishen;
	  
	  @Column(name = "priceTakhfifMetrPartishen", nullable = true) private long
	  priceTakhfifMetrPartishen;
	  
	  

	public Partition() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getJenseSotonPartishen() {
		return jenseSotonPartishen;
	}

	public void setJenseSotonPartishen(String jenseSotonPartishen) {
		this.jenseSotonPartishen = jenseSotonPartishen;
	}

	public String getJensePanelPartishen() {
		return jensePanelPartishen;
	}

	public void setJensePanelPartishen(String jensePanelPartishen) {
		this.jensePanelPartishen = jensePanelPartishen;
	}

	public String getJenseLabePartishen() {
		return jenseLabePartishen;
	}

	public void setJenseLabePartishen(String jenseLabePartishen) {
		this.jenseLabePartishen = jenseLabePartishen;
	}

	public String getRangPartishen() {
		return rangPartishen;
	}

	public void setRangPartishen(String rangPartishen) {
		this.rangPartishen = rangPartishen;
	}

	public boolean isTarkibiPartishen() {
		return tarkibiPartishen;
	}

	public void setTarkibiPartishen(boolean tarkibiPartishen) {
		this.tarkibiPartishen = tarkibiPartishen;
	}

	public String getNoeTarkibPartishen() {
		return noeTarkibPartishen;
	}

	public void setNoeTarkibPartishen(String noeTarkibPartishen) {
		this.noeTarkibPartishen = noeTarkibPartishen;
	}

	public boolean isEjrayePardePartishen() {
		return ejrayePardePartishen;
	}

	public void setEjrayePardePartishen(boolean ejrayePardePartishen) {
		this.ejrayePardePartishen = ejrayePardePartishen;
	}

	public String getRangPardePartishen() {
		return rangPardePartishen;
	}

	public void setRangPardePartishen(String rangPardePartishen) {
		this.rangPardePartishen = rangPardePartishen;
	}

	public long getPriceMetrPartishen() {
		return priceMetrPartishen;
	}

	public void setPriceMetrPartishen(long priceMetrPartishen) {
		this.priceMetrPartishen = priceMetrPartishen;
	}

	public long getPriceTakhfifMetrPartishen() {
		return priceTakhfifMetrPartishen;
	}

	public void setPriceTakhfifMetrPartishen(long priceTakhfifMetrPartishen) {
		this.priceTakhfifMetrPartishen = priceTakhfifMetrPartishen;
	}


	@Override
	public String toString() {
		return "Partition [jenseSotonPartishen=" + jenseSotonPartishen + ", jensePanelPartishen=" + jensePanelPartishen
				+ ", jenseLabePartishen=" + jenseLabePartishen + ", rangPartishen=" + rangPartishen
				+ ", tarkibiPartishen=" + tarkibiPartishen + ", noeTarkibPartishen=" + noeTarkibPartishen
				+ ", ejrayePardePartishen=" + ejrayePardePartishen + ", rangPardePartishen=" + rangPardePartishen
				+ ", priceMetrPartishen=" + priceMetrPartishen + ", priceTakhfifMetrPartishen="
				+ priceTakhfifMetrPartishen + "]";
	}
	  
	  

}
