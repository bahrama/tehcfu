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
@Table(name = "Darb_Zed_Sergat")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorValue(value = "DarbZedSergat")
@NamedQueries({
	@NamedQuery(name="findDarbZedSergatById" , query="SELECT u FROM DarbZedSergat u WHERE u.productId=:v_productId")
})
@Cacheable(value = false)
public class DarbZedSergat extends ProductEntity {

	private static final long serialVersionUID = 1L;
	
	  @Column(name = "nameMdfDarbZedSergat", nullable = true , length=100) private
	  String nameMdfDarbZedSergat;
	  
	  @Column(name = "zekhamatMdfDarbZedSergat", nullable = true , length=100)
	  private String zekhamatMdfDarbZedSergat;
	  
	  @Column(name = "keshvarMdfDarbZedSergat", nullable = true , length=100)
	  private String keshvarMdfDarbZedSergat;
	  
	  @Column(name = "varagFeleziDarbZedSergat", nullable = true , length=100)
	  private String varagFeleziDarbZedSergat;
	  
	  @Column(name = "gotiBandiFeleziDarbZedSergat", nullable = true) private
	  boolean gotiBandiFeleziDarbZedSergat;
	  
	  @Column(name = "zekhamatVaragFeleziDarbZedSergat", nullable = true ,
	  length=100) private String zekhamatVaragFeleziDarbZedSergat;
	  
	  @Column(name = "cncDarbZedSergat", nullable = true) private boolean
	  cncDarbZedSergat;
	  
	  @Column(name = "metrilJelogiriDarbZedSergat", nullable = true) private
	  boolean metrilJelogiriDarbZedSergat;
	  
	  @Column(name = "sedagiriDarbZedSergat", nullable = true) private boolean
	  sedagiriDarbZedSergat;
	  
	  @Column(name = "goflPostchiDarbZedSergat", nullable = true) private boolean
	  goflPostchiDarbZedSergat;
	  
	  
	  @Column(name = "nasbPostchiDarbZedSergat", nullable = true) private boolean
	  nasbPostchiDarbZedSergat;
	  
	  @Column(name = "zedeAbDarbZedSergat", nullable = true) private boolean
	  zedeAbDarbZedSergat;
	  
	  @Column(name = "zedeDeylamDarbZedSergat", nullable = true) private boolean
	  zedeDeylamDarbZedSergat;
	  
	  @Column(name = "rokeshDarbZedSergat", nullable = true , length=100) private
	  String rokeshDarbZedSergat;
	  
	  @Column(name = "rangDarbZedSergat", nullable = true , length=100) private
	  String rangDarbZedSergat;
	  
	  

	public DarbZedSergat() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getNameMdfDarbZedSergat() {
		return nameMdfDarbZedSergat;
	}

	public void setNameMdfDarbZedSergat(String nameMdfDarbZedSergat) {
		this.nameMdfDarbZedSergat = nameMdfDarbZedSergat;
	}

	public String getZekhamatMdfDarbZedSergat() {
		return zekhamatMdfDarbZedSergat;
	}

	public void setZekhamatMdfDarbZedSergat(String zekhamatMdfDarbZedSergat) {
		this.zekhamatMdfDarbZedSergat = zekhamatMdfDarbZedSergat;
	}

	public String getKeshvarMdfDarbZedSergat() {
		return keshvarMdfDarbZedSergat;
	}

	public void setKeshvarMdfDarbZedSergat(String keshvarMdfDarbZedSergat) {
		this.keshvarMdfDarbZedSergat = keshvarMdfDarbZedSergat;
	}

	public String getVaragFeleziDarbZedSergat() {
		return varagFeleziDarbZedSergat;
	}

	public void setVaragFeleziDarbZedSergat(String varagFeleziDarbZedSergat) {
		this.varagFeleziDarbZedSergat = varagFeleziDarbZedSergat;
	}

	public boolean isGotiBandiFeleziDarbZedSergat() {
		return gotiBandiFeleziDarbZedSergat;
	}

	public void setGotiBandiFeleziDarbZedSergat(boolean gotiBandiFeleziDarbZedSergat) {
		this.gotiBandiFeleziDarbZedSergat = gotiBandiFeleziDarbZedSergat;
	}

	public String getZekhamatVaragFeleziDarbZedSergat() {
		return zekhamatVaragFeleziDarbZedSergat;
	}

	public void setZekhamatVaragFeleziDarbZedSergat(String zekhamatVaragFeleziDarbZedSergat) {
		this.zekhamatVaragFeleziDarbZedSergat = zekhamatVaragFeleziDarbZedSergat;
	}

	public boolean isCncDarbZedSergat() {
		return cncDarbZedSergat;
	}

	public void setCncDarbZedSergat(boolean cncDarbZedSergat) {
		this.cncDarbZedSergat = cncDarbZedSergat;
	}

	public boolean isMetrilJelogiriDarbZedSergat() {
		return metrilJelogiriDarbZedSergat;
	}

	public void setMetrilJelogiriDarbZedSergat(boolean metrilJelogiriDarbZedSergat) {
		this.metrilJelogiriDarbZedSergat = metrilJelogiriDarbZedSergat;
	}

	public boolean isSedagiriDarbZedSergat() {
		return sedagiriDarbZedSergat;
	}

	public void setSedagiriDarbZedSergat(boolean sedagiriDarbZedSergat) {
		this.sedagiriDarbZedSergat = sedagiriDarbZedSergat;
	}

	public boolean isGoflPostchiDarbZedSergat() {
		return goflPostchiDarbZedSergat;
	}

	public void setGoflPostchiDarbZedSergat(boolean goflPostchiDarbZedSergat) {
		this.goflPostchiDarbZedSergat = goflPostchiDarbZedSergat;
	}

	public boolean isNasbPostchiDarbZedSergat() {
		return nasbPostchiDarbZedSergat;
	}

	public void setNasbPostchiDarbZedSergat(boolean nasbPostchiDarbZedSergat) {
		this.nasbPostchiDarbZedSergat = nasbPostchiDarbZedSergat;
	}

	public boolean isZedeAbDarbZedSergat() {
		return zedeAbDarbZedSergat;
	}

	public void setZedeAbDarbZedSergat(boolean zedeAbDarbZedSergat) {
		this.zedeAbDarbZedSergat = zedeAbDarbZedSergat;
	}

	public boolean isZedeDeylamDarbZedSergat() {
		return zedeDeylamDarbZedSergat;
	}

	public void setZedeDeylamDarbZedSergat(boolean zedeDeylamDarbZedSergat) {
		this.zedeDeylamDarbZedSergat = zedeDeylamDarbZedSergat;
	}

	public String getRokeshDarbZedSergat() {
		return rokeshDarbZedSergat;
	}

	public void setRokeshDarbZedSergat(String rokeshDarbZedSergat) {
		this.rokeshDarbZedSergat = rokeshDarbZedSergat;
	}

	public String getRangDarbZedSergat() {
		return rangDarbZedSergat;
	}

	public void setRangDarbZedSergat(String rangDarbZedSergat) {
		this.rangDarbZedSergat = rangDarbZedSergat;
	}


	@Override
	public String toString() {
		return "DarbZedSergat [nameMdfDarbZedSergat=" + nameMdfDarbZedSergat + ", zekhamatMdfDarbZedSergat="
				+ zekhamatMdfDarbZedSergat + ", keshvarMdfDarbZedSergat=" + keshvarMdfDarbZedSergat
				+ ", varagFeleziDarbZedSergat=" + varagFeleziDarbZedSergat + ", gotiBandiFeleziDarbZedSergat="
				+ gotiBandiFeleziDarbZedSergat + ", zekhamatVaragFeleziDarbZedSergat="
				+ zekhamatVaragFeleziDarbZedSergat + ", cncDarbZedSergat=" + cncDarbZedSergat
				+ ", metrilJelogiriDarbZedSergat=" + metrilJelogiriDarbZedSergat + ", sedagiriDarbZedSergat="
				+ sedagiriDarbZedSergat + ", goflPostchiDarbZedSergat=" + goflPostchiDarbZedSergat
				+ ", nasbPostchiDarbZedSergat=" + nasbPostchiDarbZedSergat + ", zedeAbDarbZedSergat="
				+ zedeAbDarbZedSergat + ", zedeDeylamDarbZedSergat=" + zedeDeylamDarbZedSergat
				+ ", rokeshDarbZedSergat=" + rokeshDarbZedSergat + ", rangDarbZedSergat=" + rangDarbZedSergat + "]";
	}
	  

}
