package entity;


import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="karjo_tbl")
@NamedQueries({
	@NamedQuery(name="findAllkarjo" , query="SELECT a FROM JobKarjoEntity a ORDER BY a.adveriseId DESC"),
	@NamedQuery(name="findKarjoById" , query="SELECT i FROM JobKarjoEntity i WHERE i.adveriseId=:v_adveriseId")
})
@Cacheable(value = false)
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorValue(value = "karjo")
public class JobKarjoEntity extends AdvertiseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name = "adveriseId")
	private long adveriseId;
	
	@Column(name = "karjo_field", length = 100, nullable = true)
	private String karjoField;
	@Column(name = "karjo_madrak", length = 100, nullable = true)
	private String karjoMadrak;

	@Column(name = "karjo_noehamkari", length = 20, nullable = true)
	private String karjoNoeHamkari;
	@Column(name = "birthDay", length = 100, nullable = true)
	private String birthDay;
	@Column(name = "mahaleTavalod", length = 100, nullable = true)
	private String mahaleTavalod;
	@Column(name = "vaziatTahol", length = 100, nullable = true)
	private String vaziatTahol;
	@Column(name = "khedmat", length = 100, nullable = true)
	private String khedmat;
	@Column(name = "sabege", nullable = true)
	private long sabege;
	@Column(name = "bimeSabege", nullable = true)
	private long bimeSabege;
	@Column(name = "vaziatEshtegal", length = 100, nullable = true)
	private String vaziatEshtegal;
	@Column(name = "elateTarkeKar", length = 200, nullable = true)
	private String elateTarkeKar;
	@Column(name = "shogleDarkhast", length = 200, nullable = true)	
	private String shogleDarkhast;
	@Column(name = "takhasosKarjo", length = 200, nullable = true)	
	private String takhasosKarjo;
	@Column(name = "dorehaVmadarek", length = 200, nullable = true)	
	private String dorehaVmadarek;
	@Column(name = "hogogKarjo", nullable = true)
	private long hogogKarjo;
	
	
	


	public String getKarjoField() {
		return karjoField;
	}
	public void setKarjoField(String karjoField) {
		this.karjoField = karjoField;
	}
	public String getKarjoMadrak() {
		return karjoMadrak;
	}
	public void setKarjoMadrak(String karjoMadrak) {
		this.karjoMadrak = karjoMadrak;
	}

	public String getKarjoNoeHamkari() {
		return karjoNoeHamkari;
	}
	public void setKarjoNoeHamkari(String karjoNoeHamkari) {
		this.karjoNoeHamkari = karjoNoeHamkari;
	}

	public long getAdveriseId() {
		return adveriseId;
	}
	public void setAdveriseId(long adveriseId) {
		this.adveriseId = adveriseId;
	}
	public String getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}
	public String getMahaleTavalod() {
		return mahaleTavalod;
	}
	public void setMahaleTavalod(String mahaleTavalod) {
		this.mahaleTavalod = mahaleTavalod;
	}
	public String getVaziatTahol() {
		return vaziatTahol;
	}
	public void setVaziatTahol(String vaziatTahol) {
		this.vaziatTahol = vaziatTahol;
	}
	public String getKhedmat() {
		return khedmat;
	}
	public void setKhedmat(String khedmat) {
		this.khedmat = khedmat;
	}
	public long getSabege() {
		return sabege;
	}
	public void setSabege(long sabege) {
		this.sabege = sabege;
	}
	public long getBimeSabege() {
		return bimeSabege;
	}
	public void setBimeSabege(long bimeSabege) {
		this.bimeSabege = bimeSabege;
	}
	public String getVaziatEshtegal() {
		return vaziatEshtegal;
	}
	public void setVaziatEshtegal(String vaziatEshtegal) {
		this.vaziatEshtegal = vaziatEshtegal;
	}
	public String getElateTarkeKar() {
		return elateTarkeKar;
	}
	public void setElateTarkeKar(String elateTarkeKar) {
		this.elateTarkeKar = elateTarkeKar;
	}
	public String getShogleDarkhast() {
		return shogleDarkhast;
	}
	public void setShogleDarkhast(String shogleDarkhast) {
		this.shogleDarkhast = shogleDarkhast;
	}
	public String getTakhasosKarjo() {
		return takhasosKarjo;
	}
	public void setTakhasosKarjo(String takhasosKarjo) {
		this.takhasosKarjo = takhasosKarjo;
	}
	public String getDorehaVmadarek() {
		return dorehaVmadarek;
	}
	public void setDorehaVmadarek(String dorehaVmadarek) {
		this.dorehaVmadarek = dorehaVmadarek;
	}
	public long getHogogKarjo() {
		return hogogKarjo;
	}
	public void setHogogKarjo(long hogogKarjo) {
		this.hogogKarjo = hogogKarjo;
	}




}
