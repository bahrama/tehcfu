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
@Table(name = "Panjare")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorValue(value = "Panjare")
@NamedQueries({
	@NamedQuery(name="findPanjareById" , query="SELECT u FROM Panjare u WHERE u.productId=:v_productId")
})
@Cacheable(value = false)
public class Panjare extends ProductEntity {

	private static final long serialVersionUID = 1L;
	
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



	@Override
	public String toString() {
		return "Panjare [metrialPanjare=" + metrialPanjare + ", noeRangPanjare=" + noeRangPanjare
				+ ", jenseKalafPanjare=" + jenseKalafPanjare + ", makanPanjare=" + makanPanjare + ", cncPanjare="
				+ cncPanjare + ", zedeAbPanjare=" + zedeAbPanjare + ", shostoshoPanjare=" + shostoshoPanjare + "]";
	}

	  
}
