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
@Table(name = "service_khab_kodak")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorValue(value = "ServiceKhabKodak")
@NamedQueries({
	@NamedQuery(name="findServiceKhabKodakById" , query="SELECT u FROM ServiceKhabKodak u WHERE u.productId=:v_productId")
})
@Cacheable(value = false)
public class ServiceKhabKodak extends ProductEntity {

	private static final long serialVersionUID = 1L;
	
	 @Column(name = "modelServiceKhabNozad", nullable = true , length=100) private
	  String modelServiceKhabNozad;
	  
	  @Column(name = "jenseServiceKhabNozad", nullable = true , length=100) private
	  String jenseServiceKhabNozad;
	  
	  @Column(name = "rangServiceKhabNozad", nullable = true , length=100) private
	  String rangServiceKhabNozad;
	  
	  @Column(name = "priceServiceKhabNozad", nullable = true) private long
	  priceServiceKhabNozad;
	  
	  @Column(name = "keshoVBox", nullable = true ) private boolean keshoVBox;
	  
	  @Column(name = "kenarMadari", nullable = true ) private boolean kenarMadari;
	  
	  @Column(name = "jenseKomodkenarMadari", nullable = true , length=100) private
	  String jenseKomodkenarMadari;
	  
	  @Column(name = "abadKomodkenarMadari", nullable = true , length=100) private
	  String abadKomodkenarMadari;
	  
	  @Column(name = "rangKomodkenarMadari", nullable = true , length=100) private
	  String rangKomodkenarMadari;
	  
	  @Column(name = "priceKomodkenarMadari", nullable = true) private long
	  priceKomodkenarMadari;
	  
	  @Column(name = "mizSandaliKodak", nullable = true) private boolean
	  mizSandaliKodak;
	  
	  @Column(name = "tedadMizSandaliKodak", nullable = true) private int
	  tedadMizSandaliKodak;
	  
	  @Column(name = "jenseMizSandaliKodak", nullable = true , length=100) private
	  String jenseMizSandaliKodak;
	  
	  @Column(name = "abadMizKodak", nullable = true , length=100) private String
	  abadMizKodak;
	  
	  @Column(name = "abadSandaliKodak", nullable = true , length=100) private
	  String abadSandaliKodak;
	  
	  @Column(name = "priceMizSandaliKodak", nullable = true) private long
	  priceMizSandaliKodak;
	  
	  @Column(name = "komodMizSandaliKodak", nullable = true) private boolean
	  komodMizSandaliKodak;
	  
	  @Column(name = "jenseKomodMizSandaliKodak", nullable = true , length=100)
	  private String jenseKomodMizSandaliKodak;
	  
	  @Column(name = "abadKomodMizSandaliKodak", nullable = true , length=100)
	  private String abadKomodMizSandaliKodak;
	  
	  @Column(name = "rangKomodMizSandaliKodak", nullable = true , length=100)
	  private String rangKomodMizSandaliKodak;
	  
	  @Column(name = "priceKomodMizSandaliKodak", nullable = true) private long
	  priceKomodMizSandaliKodak;
	  
	  @Column(name = "mizArayeshMizSandaliKodak", nullable = true) private boolean
	  mizArayeshMizSandaliKodak;
	  
	  @Column(name = "sandaliMizArayeshMizSandaliKodak", nullable = true) private
	  boolean sandaliMizArayeshMizSandaliKodak;
	  
	  @Column(name = "jenseMizArayeshMizSandaliKodak", nullable = true ,
	  length=100) private String jenseMizArayeshMizSandaliKodak;
	  
	  @Column(name = "abadMizArayeshMizSandaliKodak", nullable = true , length=100)
	  private String abadMizArayeshMizSandaliKodak;
	  
	  @Column(name = "rangMizArayeshMizSandaliKodak", nullable = true , length=100)
	  private String rangMizArayeshMizSandaliKodak;
	  
	  @Column(name = "priceMizArayeshMizSandaliKodak", nullable = true) private
	  long priceMizArayeshMizSandaliKodak;
	  
	  @Column(name = "vitrinKetabkhane", nullable = true) private boolean
	  vitrinKetabkhane;
	  
	  @Column(name = "jenseVitrinKetabkhane", nullable = true , length=100) private
	  String jenseVitrinKetabkhane;
	  
	  @Column(name = "abadVitrinKetabkhane", nullable = true , length=100) private
	  String abadVitrinKetabkhane;
	  
	  @Column(name = "rangVitrinKetabkhane", nullable = true , length=100) private
	  String rangVitrinKetabkhane;
	  
	  @Column(name = "priceVitrinKetabkhane", nullable = true) private long
	  priceVitrinKetabkhane;
	  
	  @Column(name = "shelfDivari", nullable = true) private boolean shelfDivari;
	  
	  @Column(name = "jenseShelfDivari", nullable = true , length=100) private
	  String jenseShelfDivari;
	  
	  @Column(name = "abadShelfDivari", nullable = true , length=100) private
	  String abadShelfDivari;
	  
	  @Column(name = "rangShelfDivari", nullable = true , length=100) private
	  String rangShelfDivari;
	  
	  @Column(name = "priceShelfDivari", nullable = true) private long
	  priceShelfDivari;
	  
	  @Column(name = "toshak3", nullable = true) private boolean toshak3;
	  
	  @Column(name = "brandToshak3", nullable = true , length=100) private String
	  brandToshak3;
	  
	  @Column(name = "modelToshak3", nullable = true , length=100) private String
	  modelToshak3;
	  
	  @Column(name = "modatGarantiToshak3", nullable = true) private int
	  modatGarantiToshak3;
	  
	  @Column(name = "abadToshak3", nullable = true , length=100) private String
	  abadToshak3;
	  
	  @Column(name = "priceToshak3", nullable = true) private long priceToshak3;
	  
	  @Column(name = "descriptionToshak3", nullable = true , length=100) private
	  String descriptionToshak3;
	  
	  

	public ServiceKhabKodak() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getModelServiceKhabNozad() {
		return modelServiceKhabNozad;
	}

	public void setModelServiceKhabNozad(String modelServiceKhabNozad) {
		this.modelServiceKhabNozad = modelServiceKhabNozad;
	}

	public String getJenseServiceKhabNozad() {
		return jenseServiceKhabNozad;
	}

	public void setJenseServiceKhabNozad(String jenseServiceKhabNozad) {
		this.jenseServiceKhabNozad = jenseServiceKhabNozad;
	}

	public String getRangServiceKhabNozad() {
		return rangServiceKhabNozad;
	}

	public void setRangServiceKhabNozad(String rangServiceKhabNozad) {
		this.rangServiceKhabNozad = rangServiceKhabNozad;
	}

	public long getPriceServiceKhabNozad() {
		return priceServiceKhabNozad;
	}

	public void setPriceServiceKhabNozad(long priceServiceKhabNozad) {
		this.priceServiceKhabNozad = priceServiceKhabNozad;
	}

	public boolean isKeshoVBox() {
		return keshoVBox;
	}

	public void setKeshoVBox(boolean keshoVBox) {
		this.keshoVBox = keshoVBox;
	}

	public boolean isKenarMadari() {
		return kenarMadari;
	}

	public void setKenarMadari(boolean kenarMadari) {
		this.kenarMadari = kenarMadari;
	}

	public String getJenseKomodkenarMadari() {
		return jenseKomodkenarMadari;
	}

	public void setJenseKomodkenarMadari(String jenseKomodkenarMadari) {
		this.jenseKomodkenarMadari = jenseKomodkenarMadari;
	}

	public String getAbadKomodkenarMadari() {
		return abadKomodkenarMadari;
	}

	public void setAbadKomodkenarMadari(String abadKomodkenarMadari) {
		this.abadKomodkenarMadari = abadKomodkenarMadari;
	}

	public String getRangKomodkenarMadari() {
		return rangKomodkenarMadari;
	}

	public void setRangKomodkenarMadari(String rangKomodkenarMadari) {
		this.rangKomodkenarMadari = rangKomodkenarMadari;
	}

	public long getPriceKomodkenarMadari() {
		return priceKomodkenarMadari;
	}

	public void setPriceKomodkenarMadari(long priceKomodkenarMadari) {
		this.priceKomodkenarMadari = priceKomodkenarMadari;
	}

	public boolean isMizSandaliKodak() {
		return mizSandaliKodak;
	}

	public void setMizSandaliKodak(boolean mizSandaliKodak) {
		this.mizSandaliKodak = mizSandaliKodak;
	}

	public int getTedadMizSandaliKodak() {
		return tedadMizSandaliKodak;
	}

	public void setTedadMizSandaliKodak(int tedadMizSandaliKodak) {
		this.tedadMizSandaliKodak = tedadMizSandaliKodak;
	}

	public String getJenseMizSandaliKodak() {
		return jenseMizSandaliKodak;
	}

	public void setJenseMizSandaliKodak(String jenseMizSandaliKodak) {
		this.jenseMizSandaliKodak = jenseMizSandaliKodak;
	}

	public String getAbadMizKodak() {
		return abadMizKodak;
	}

	public void setAbadMizKodak(String abadMizKodak) {
		this.abadMizKodak = abadMizKodak;
	}

	public String getAbadSandaliKodak() {
		return abadSandaliKodak;
	}

	public void setAbadSandaliKodak(String abadSandaliKodak) {
		this.abadSandaliKodak = abadSandaliKodak;
	}

	public long getPriceMizSandaliKodak() {
		return priceMizSandaliKodak;
	}

	public void setPriceMizSandaliKodak(long priceMizSandaliKodak) {
		this.priceMizSandaliKodak = priceMizSandaliKodak;
	}

	public boolean isKomodMizSandaliKodak() {
		return komodMizSandaliKodak;
	}

	public void setKomodMizSandaliKodak(boolean komodMizSandaliKodak) {
		this.komodMizSandaliKodak = komodMizSandaliKodak;
	}

	public String getJenseKomodMizSandaliKodak() {
		return jenseKomodMizSandaliKodak;
	}

	public void setJenseKomodMizSandaliKodak(String jenseKomodMizSandaliKodak) {
		this.jenseKomodMizSandaliKodak = jenseKomodMizSandaliKodak;
	}

	public String getAbadKomodMizSandaliKodak() {
		return abadKomodMizSandaliKodak;
	}

	public void setAbadKomodMizSandaliKodak(String abadKomodMizSandaliKodak) {
		this.abadKomodMizSandaliKodak = abadKomodMizSandaliKodak;
	}

	public String getRangKomodMizSandaliKodak() {
		return rangKomodMizSandaliKodak;
	}

	public void setRangKomodMizSandaliKodak(String rangKomodMizSandaliKodak) {
		this.rangKomodMizSandaliKodak = rangKomodMizSandaliKodak;
	}

	public long getPriceKomodMizSandaliKodak() {
		return priceKomodMizSandaliKodak;
	}

	public void setPriceKomodMizSandaliKodak(long priceKomodMizSandaliKodak) {
		this.priceKomodMizSandaliKodak = priceKomodMizSandaliKodak;
	}

	public boolean isMizArayeshMizSandaliKodak() {
		return mizArayeshMizSandaliKodak;
	}

	public void setMizArayeshMizSandaliKodak(boolean mizArayeshMizSandaliKodak) {
		this.mizArayeshMizSandaliKodak = mizArayeshMizSandaliKodak;
	}

	public boolean isSandaliMizArayeshMizSandaliKodak() {
		return sandaliMizArayeshMizSandaliKodak;
	}

	public void setSandaliMizArayeshMizSandaliKodak(boolean sandaliMizArayeshMizSandaliKodak) {
		this.sandaliMizArayeshMizSandaliKodak = sandaliMizArayeshMizSandaliKodak;
	}

	public String getJenseMizArayeshMizSandaliKodak() {
		return jenseMizArayeshMizSandaliKodak;
	}

	public void setJenseMizArayeshMizSandaliKodak(String jenseMizArayeshMizSandaliKodak) {
		this.jenseMizArayeshMizSandaliKodak = jenseMizArayeshMizSandaliKodak;
	}

	public String getAbadMizArayeshMizSandaliKodak() {
		return abadMizArayeshMizSandaliKodak;
	}

	public void setAbadMizArayeshMizSandaliKodak(String abadMizArayeshMizSandaliKodak) {
		this.abadMizArayeshMizSandaliKodak = abadMizArayeshMizSandaliKodak;
	}

	public String getRangMizArayeshMizSandaliKodak() {
		return rangMizArayeshMizSandaliKodak;
	}

	public void setRangMizArayeshMizSandaliKodak(String rangMizArayeshMizSandaliKodak) {
		this.rangMizArayeshMizSandaliKodak = rangMizArayeshMizSandaliKodak;
	}

	public long getPriceMizArayeshMizSandaliKodak() {
		return priceMizArayeshMizSandaliKodak;
	}

	public void setPriceMizArayeshMizSandaliKodak(long priceMizArayeshMizSandaliKodak) {
		this.priceMizArayeshMizSandaliKodak = priceMizArayeshMizSandaliKodak;
	}

	public boolean isVitrinKetabkhane() {
		return vitrinKetabkhane;
	}

	public void setVitrinKetabkhane(boolean vitrinKetabkhane) {
		this.vitrinKetabkhane = vitrinKetabkhane;
	}

	public String getJenseVitrinKetabkhane() {
		return jenseVitrinKetabkhane;
	}

	public void setJenseVitrinKetabkhane(String jenseVitrinKetabkhane) {
		this.jenseVitrinKetabkhane = jenseVitrinKetabkhane;
	}

	public String getAbadVitrinKetabkhane() {
		return abadVitrinKetabkhane;
	}

	public void setAbadVitrinKetabkhane(String abadVitrinKetabkhane) {
		this.abadVitrinKetabkhane = abadVitrinKetabkhane;
	}

	public String getRangVitrinKetabkhane() {
		return rangVitrinKetabkhane;
	}

	public void setRangVitrinKetabkhane(String rangVitrinKetabkhane) {
		this.rangVitrinKetabkhane = rangVitrinKetabkhane;
	}

	public long getPriceVitrinKetabkhane() {
		return priceVitrinKetabkhane;
	}

	public void setPriceVitrinKetabkhane(long priceVitrinKetabkhane) {
		this.priceVitrinKetabkhane = priceVitrinKetabkhane;
	}

	public boolean isShelfDivari() {
		return shelfDivari;
	}

	public void setShelfDivari(boolean shelfDivari) {
		this.shelfDivari = shelfDivari;
	}

	public String getJenseShelfDivari() {
		return jenseShelfDivari;
	}

	public void setJenseShelfDivari(String jenseShelfDivari) {
		this.jenseShelfDivari = jenseShelfDivari;
	}

	public String getAbadShelfDivari() {
		return abadShelfDivari;
	}

	public void setAbadShelfDivari(String abadShelfDivari) {
		this.abadShelfDivari = abadShelfDivari;
	}

	public String getRangShelfDivari() {
		return rangShelfDivari;
	}

	public void setRangShelfDivari(String rangShelfDivari) {
		this.rangShelfDivari = rangShelfDivari;
	}

	public long getPriceShelfDivari() {
		return priceShelfDivari;
	}

	public void setPriceShelfDivari(long priceShelfDivari) {
		this.priceShelfDivari = priceShelfDivari;
	}

	public boolean isToshak3() {
		return toshak3;
	}

	public void setToshak3(boolean toshak3) {
		this.toshak3 = toshak3;
	}

	public String getBrandToshak3() {
		return brandToshak3;
	}

	public void setBrandToshak3(String brandToshak3) {
		this.brandToshak3 = brandToshak3;
	}

	public String getModelToshak3() {
		return modelToshak3;
	}

	public void setModelToshak3(String modelToshak3) {
		this.modelToshak3 = modelToshak3;
	}

	public int getModatGarantiToshak3() {
		return modatGarantiToshak3;
	}

	public void setModatGarantiToshak3(int modatGarantiToshak3) {
		this.modatGarantiToshak3 = modatGarantiToshak3;
	}

	public String getAbadToshak3() {
		return abadToshak3;
	}

	public void setAbadToshak3(String abadToshak3) {
		this.abadToshak3 = abadToshak3;
	}

	public long getPriceToshak3() {
		return priceToshak3;
	}

	public void setPriceToshak3(long priceToshak3) {
		this.priceToshak3 = priceToshak3;
	}

	public String getDescriptionToshak3() {
		return descriptionToshak3;
	}

	public void setDescriptionToshak3(String descriptionToshak3) {
		this.descriptionToshak3 = descriptionToshak3;
	}


	@Override
	public String toString() {
		return "ServiceKhabKodak [modelServiceKhabNozad=" + modelServiceKhabNozad + ", jenseServiceKhabNozad="
				+ jenseServiceKhabNozad + ", rangServiceKhabNozad=" + rangServiceKhabNozad + ", priceServiceKhabNozad="
				+ priceServiceKhabNozad + ", keshoVBox=" + keshoVBox + ", kenarMadari=" + kenarMadari
				+ ", jenseKomodkenarMadari=" + jenseKomodkenarMadari + ", abadKomodkenarMadari=" + abadKomodkenarMadari
				+ ", rangKomodkenarMadari=" + rangKomodkenarMadari + ", priceKomodkenarMadari=" + priceKomodkenarMadari
				+ ", mizSandaliKodak=" + mizSandaliKodak + ", tedadMizSandaliKodak=" + tedadMizSandaliKodak
				+ ", jenseMizSandaliKodak=" + jenseMizSandaliKodak + ", abadMizKodak=" + abadMizKodak
				+ ", abadSandaliKodak=" + abadSandaliKodak + ", priceMizSandaliKodak=" + priceMizSandaliKodak
				+ ", komodMizSandaliKodak=" + komodMizSandaliKodak + ", jenseKomodMizSandaliKodak="
				+ jenseKomodMizSandaliKodak + ", abadKomodMizSandaliKodak=" + abadKomodMizSandaliKodak
				+ ", rangKomodMizSandaliKodak=" + rangKomodMizSandaliKodak + ", priceKomodMizSandaliKodak="
				+ priceKomodMizSandaliKodak + ", mizArayeshMizSandaliKodak=" + mizArayeshMizSandaliKodak
				+ ", sandaliMizArayeshMizSandaliKodak=" + sandaliMizArayeshMizSandaliKodak
				+ ", jenseMizArayeshMizSandaliKodak=" + jenseMizArayeshMizSandaliKodak
				+ ", abadMizArayeshMizSandaliKodak=" + abadMizArayeshMizSandaliKodak
				+ ", rangMizArayeshMizSandaliKodak=" + rangMizArayeshMizSandaliKodak
				+ ", priceMizArayeshMizSandaliKodak=" + priceMizArayeshMizSandaliKodak + ", vitrinKetabkhane="
				+ vitrinKetabkhane + ", jenseVitrinKetabkhane=" + jenseVitrinKetabkhane + ", abadVitrinKetabkhane="
				+ abadVitrinKetabkhane + ", rangVitrinKetabkhane=" + rangVitrinKetabkhane + ", priceVitrinKetabkhane="
				+ priceVitrinKetabkhane + ", shelfDivari=" + shelfDivari + ", jenseShelfDivari=" + jenseShelfDivari
				+ ", abadShelfDivari=" + abadShelfDivari + ", rangShelfDivari=" + rangShelfDivari
				+ ", priceShelfDivari=" + priceShelfDivari + ", toshak3=" + toshak3 + ", brandToshak3=" + brandToshak3
				+ ", modelToshak3=" + modelToshak3 + ", modatGarantiToshak3=" + modatGarantiToshak3 + ", abadToshak3="
				+ abadToshak3 + ", priceToshak3=" + priceToshak3 + ", descriptionToshak3=" + descriptionToshak3 + "]";
	}
	  
	  

}
