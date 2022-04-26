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
@Table(name = "Darb_Chobi")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorValue(value = "DarbChobi")
@NamedQueries({
	@NamedQuery(name="findDarbChobiById" , query="SELECT u FROM DarbChobi u WHERE u.productId=:v_productId")
})
@Cacheable(value = false)
public class DarbChobi extends ProductEntity {


	private static final long serialVersionUID = 1L;
	
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



	@Override
	public String toString() {
		return "DarbChobi [rokeshDarbChobi=" + rokeshDarbChobi + ", noeRangDarbChobi=" + noeRangDarbChobi
				+ ", zekhamatDarbChobi=" + zekhamatDarbChobi + ", jenseKalafDarbChobi=" + jenseKalafDarbChobi
				+ ", makanDarbChobi=" + makanDarbChobi + ", cncDarbChobi=" + cncDarbChobi + ", zedeAbDarbChobi="
				+ zedeAbDarbChobi + ", shostoshoDarbChobi=" + shostoshoDarbChobi + "]";
	}

	  
}
