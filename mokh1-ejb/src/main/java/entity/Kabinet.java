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
@Table(name = "Kabinet")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorValue(value = "Kabinet")
@NamedQueries({
	@NamedQuery(name="findKabinetById" , query="SELECT u FROM Kabinet u WHERE u.productId=:v_productId")
})
@Cacheable(value = false)
public class Kabinet extends ProductEntity {

	private static final long serialVersionUID = 1L;

	
	 @Column(name = "jenseKabinet", nullable = true , length=100) private String
	  jenseKabinet;
	  
	  @Column(name = "jenseSafeKabinet", nullable = true , length=100) private
	  String jenseSafeKabinet;
	  
	  @Column(name = "noeMdfKabinet", nullable = true , length=100) private String
	  noeMdfKabinet;
	  
	  @Column(name = "zekhamateMdfKabinet", nullable = true , length=100) private
	  String zekhamateMdfKabinet;
	  
	  @Column(name = "abadMdfKabinet", nullable = true , length=100) private String
	  abadMdfKabinet;
	  
	  @Column(name = "dastgireDarbKabinet", nullable = true) private boolean
	  dastgireDarbKabinet;
	  
	  @Column(name = "reylKabinet", nullable = true) private boolean reylKabinet;
	  
	  @Column(name = "jakKabinet", nullable = true) private boolean jakKabinet;
	  
	  @Column(name = "payeKabinet", nullable = true) private boolean payeKabinet;
	  
	  @Column(name = "magnetKabinet", nullable = true) private boolean
	  magnetKabinet;
	  
	  @Column(name = "charkhKabinet", nullable = true) private boolean
	  charkhKabinet;
	  
	  @Column(name = "priceMetrKabinet", nullable = true) private long
	  priceMetrKabinet;
	  
	  @Column(name = "priceMetrTakhfifKabinet", nullable = true) private long
	  priceMetrTakhfifKabinet;
	  
	  

	public Kabinet() {
		super();
		// TODO Auto-generated constructor stub
	}



	public String getJenseKabinet() {
		return jenseKabinet;
	}

	public void setJenseKabinet(String jenseKabinet) {
		this.jenseKabinet = jenseKabinet;
	}

	public String getJenseSafeKabinet() {
		return jenseSafeKabinet;
	}

	public void setJenseSafeKabinet(String jenseSafeKabinet) {
		this.jenseSafeKabinet = jenseSafeKabinet;
	}

	public String getNoeMdfKabinet() {
		return noeMdfKabinet;
	}

	public void setNoeMdfKabinet(String noeMdfKabinet) {
		this.noeMdfKabinet = noeMdfKabinet;
	}

	public String getZekhamateMdfKabinet() {
		return zekhamateMdfKabinet;
	}

	public void setZekhamateMdfKabinet(String zekhamateMdfKabinet) {
		this.zekhamateMdfKabinet = zekhamateMdfKabinet;
	}

	public String getAbadMdfKabinet() {
		return abadMdfKabinet;
	}

	public void setAbadMdfKabinet(String abadMdfKabinet) {
		this.abadMdfKabinet = abadMdfKabinet;
	}

	public boolean isDastgireDarbKabinet() {
		return dastgireDarbKabinet;
	}

	public void setDastgireDarbKabinet(boolean dastgireDarbKabinet) {
		this.dastgireDarbKabinet = dastgireDarbKabinet;
	}

	public boolean isReylKabinet() {
		return reylKabinet;
	}

	public void setReylKabinet(boolean reylKabinet) {
		this.reylKabinet = reylKabinet;
	}

	public boolean isJakKabinet() {
		return jakKabinet;
	}

	public void setJakKabinet(boolean jakKabinet) {
		this.jakKabinet = jakKabinet;
	}

	public boolean isPayeKabinet() {
		return payeKabinet;
	}

	public void setPayeKabinet(boolean payeKabinet) {
		this.payeKabinet = payeKabinet;
	}

	public boolean isMagnetKabinet() {
		return magnetKabinet;
	}

	public void setMagnetKabinet(boolean magnetKabinet) {
		this.magnetKabinet = magnetKabinet;
	}

	public boolean isCharkhKabinet() {
		return charkhKabinet;
	}

	public void setCharkhKabinet(boolean charkhKabinet) {
		this.charkhKabinet = charkhKabinet;
	}

	public long getPriceMetrKabinet() {
		return priceMetrKabinet;
	}

	public void setPriceMetrKabinet(long priceMetrKabinet) {
		this.priceMetrKabinet = priceMetrKabinet;
	}

	public long getPriceMetrTakhfifKabinet() {
		return priceMetrTakhfifKabinet;
	}

	public void setPriceMetrTakhfifKabinet(long priceMetrTakhfifKabinet) {
		this.priceMetrTakhfifKabinet = priceMetrTakhfifKabinet;
	}



	@Override
	public String toString() {
		return "Kabinet [jenseKabinet=" + jenseKabinet + ", jenseSafeKabinet=" + jenseSafeKabinet + ", noeMdfKabinet="
				+ noeMdfKabinet + ", zekhamateMdfKabinet=" + zekhamateMdfKabinet + ", abadMdfKabinet=" + abadMdfKabinet
				+ ", dastgireDarbKabinet=" + dastgireDarbKabinet + ", reylKabinet=" + reylKabinet + ", jakKabinet="
				+ jakKabinet + ", payeKabinet=" + payeKabinet + ", magnetKabinet=" + magnetKabinet + ", charkhKabinet="
				+ charkhKabinet + ", priceMetrKabinet=" + priceMetrKabinet + ", priceMetrTakhfifKabinet="
				+ priceMetrTakhfifKabinet + "]";
	}
	  
	  
}
