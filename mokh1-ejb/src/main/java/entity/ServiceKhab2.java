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
@Table(name = "service_khab2")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorValue(value = "ServiceKhab2")
@NamedQueries({
	@NamedQuery(name="findServiceKhab2ById" , query="SELECT u FROM ServiceKhab2 u WHERE u.productId=:v_productId")
})
@Cacheable(value = false)
public class ServiceKhab2 extends ProductEntity{

	private static final long serialVersionUID = 1L;
	
	 @Column(name = "modelServiceKhab2", nullable = true , length=100) private
	  String modelServiceKhab2;
	  
	  @Column(name = "arzeTakhteKhab2", nullable = true) 
	  private int arzeTakhteKhab2;
	  
	  @Column(name = "jenseTakhteKhab2", nullable = true , length=100) private
	  String jenseTakhteKhab2;
	  
	  @Column(name = "rangeTakhteKhab2", nullable = true , length=100) private
	  String rangeTakhteKhab2;
	  
	  @Column(name = "priceTakhteKhab2", nullable = true) private long
	  priceTakhteKhab2;
	  
	  @Column(name = "kalafTakhtJackDar", nullable = true) private boolean
	  kalafTakhtJackDar;
	  
	  @Column(name = "keshoVbox", nullable = true) private boolean keshoVbox;
	  
	  @Column(name = "paTahti2", nullable = true) private boolean paTahti2;
	  
	  @Column(name = "tedadPaTakhti2", nullable = true) private int tedadPaTakhti2;
	  
	  @Column(name = "jensePaTakhti2", nullable = true , length=100) private String
	  jensePaTakhti2;
	  
	  @Column(name = "abadPaTakhti2", nullable = true , length=100) private String
	  abadPaTakhti2;
	  
	  @Column(name = "rangPaTakhti2", nullable = true , length=100) private String
	  rangPaTakhti2;
	  
	  @Column(name = "pricePaTakhti2", nullable = true) private long
	  pricePaTakhti2;
	  
	  @Column(name = "komodServiceKhab2", nullable = true ) private boolean
	  komodServiceKhab2;
	  
	  @Column(name = "jensekomodServiceKhab2", nullable = true , length=100)
	  private String jensekomodServiceKhab2;
	  
	  @Column(name = "abadkomodServiceKhab2", nullable = true , length=100) private
	  String abadkomodServiceKhab2;
	  
	  @Column(name = "rangKomodServiceKhab2", nullable = true , length=100) private
	  String rangkomodServiceKhab2;
	  
	  @Column(name = "priceKomodServiceKhab2", nullable = true) private long
	  priceKomodServiceKhab2;
	  
	  @Column(name = "mizArayesh2", nullable = true ) private boolean mizArayesh2;
	  
	  @Column(name = "sandaliMizArayesh2", nullable = true) private
	  boolean sandaliMizArayesh2;
	  
	  @Column(name = "jenseMizArayesh2", nullable = true , length=100) private
	  String jenseMizArayesh2;
	  
	  @Column(name = "abadMizArayesh2", nullable = true , length=100) private
	  String abadMizArayesh2;
	  
	  @Column(name = "rangMizArayesh2", nullable = true , length=100) private
	  String rangMizArayesh2;
	  
	  @Column(name = "priceMizArayesh2", nullable = true) private long
	  priceMizArayesh2;
	  
	  @Column(name = "mizTahrir2", nullable = true ) private boolean mizTahrir2;
	  
	  @Column(name = "jensemizTahrir2", nullable = true , length=100) private
	  String jensemizTahrir2;
	  
	  @Column(name = "abadmizTahrir2", nullable = true , length=100) private String
	  abadmizTahrir2;
	  
	  @Column(name = "rangmizTahrir2", nullable = true , length=100) private String
	  rangmizTahrir2;
	  
	  @Column(name = "priceMizTahrir2", nullable = true) private long
	  priceMizTahrir2;
	  
	  @Column(name = "gabVAyeneGadi2", nullable = true ) private boolean
	  gabVAyeneGadi2;
	  
	  @Column(name = "jenseGabVAyeneGadi2", nullable = true , length=100) private
	  String jenseGabVAyeneGadi2;
	  
	  @Column(name = "abadGabVAyeneGadi2", nullable = true , length=100) private
	  String abadGabVAyeneGadi2;
	  
	  @Column(name = "rangGabVAyeneGadi2", nullable = true , length=100) private
	  String rangGabVAyeneGadi2;
	  
	  @Column(name = "priceGabVAyeneGadi2", nullable = true) private long
	  priceGabVAyeneGadi2;
	  
	  @Column(name = "toshak2", nullable = true ) private boolean toshak2;
	  
	  @Column(name = "brandToshak2", nullable = true , length=100) private String
	  brandToshak2;
	  
	  @Column(name = "modelToshak2", nullable = true , length=100) private String
	  modelToshak2;
	  
	  @Column(name = "modatGarantiGabVAyeneGadi2", nullable = true) private int
	  modatGarantiGabVAyeneGadi2;
	  
	  @Column(name = "abadToshak2", nullable = true , length=100) private String
	  abadToshak2;
	  
	  @Column(name = "priceToshak2", nullable = true) private long priceToshak2;
	  
	  @Column(name = "descriptionToshak2", nullable = true,length = 1000) private
	  String descriptionToshak2;
	  
	  

	public ServiceKhab2() {
		super();
		// TODO Auto-generated constructor stub
	}



	public String getModelServiceKhab2() {
		return modelServiceKhab2;
	}

	public void setModelServiceKhab2(String modelServiceKhab2) {
		this.modelServiceKhab2 = modelServiceKhab2;
	}



	public int getArzeTakhteKhab2() {
		return arzeTakhteKhab2;
	}



	public void setArzeTakhteKhab2(int arzeTakhteKhab2) {
		this.arzeTakhteKhab2 = arzeTakhteKhab2;
	}



	public String getJenseTakhteKhab2() {
		return jenseTakhteKhab2;
	}

	public void setJenseTakhteKhab2(String jenseTakhteKhab2) {
		this.jenseTakhteKhab2 = jenseTakhteKhab2;
	}

	public String getRangeTakhteKhab2() {
		return rangeTakhteKhab2;
	}

	public void setRangeTakhteKhab2(String rangeTakhteKhab2) {
		this.rangeTakhteKhab2 = rangeTakhteKhab2;
	}

	public long getPriceTakhteKhab2() {
		return priceTakhteKhab2;
	}

	public void setPriceTakhteKhab2(long priceTakhteKhab2) {
		this.priceTakhteKhab2 = priceTakhteKhab2;
	}

	public boolean isKalafTakhtJackDar() {
		return kalafTakhtJackDar;
	}

	public void setKalafTakhtJackDar(boolean kalafTakhtJackDar) {
		this.kalafTakhtJackDar = kalafTakhtJackDar;
	}

	public boolean isKeshoVbox() {
		return keshoVbox;
	}

	public void setKeshoVbox(boolean keshoVbox) {
		this.keshoVbox = keshoVbox;
	}

	public boolean isPaTahti2() {
		return paTahti2;
	}

	public void setPaTahti2(boolean paTahti2) {
		this.paTahti2 = paTahti2;
	}

	public int getTedadPaTakhti2() {
		return tedadPaTakhti2;
	}

	public void setTedadPaTakhti2(int tedadPaTakhti2) {
		this.tedadPaTakhti2 = tedadPaTakhti2;
	}

	public String getJensePaTakhti2() {
		return jensePaTakhti2;
	}

	public void setJensePaTakhti2(String jensePaTakhti2) {
		this.jensePaTakhti2 = jensePaTakhti2;
	}

	public String getAbadPaTakhti2() {
		return abadPaTakhti2;
	}

	public void setAbadPaTakhti2(String abadPaTakhti2) {
		this.abadPaTakhti2 = abadPaTakhti2;
	}

	public String getRangPaTakhti2() {
		return rangPaTakhti2;
	}

	public void setRangPaTakhti2(String rangPaTakhti2) {
		this.rangPaTakhti2 = rangPaTakhti2;
	}

	public long getPricePaTakhti2() {
		return pricePaTakhti2;
	}

	public void setPricePaTakhti2(long pricePaTakhti2) {
		this.pricePaTakhti2 = pricePaTakhti2;
	}

	public boolean isKomodServiceKhab2() {
		return komodServiceKhab2;
	}

	public void setKomodServiceKhab2(boolean komodServiceKhab2) {
		this.komodServiceKhab2 = komodServiceKhab2;
	}

	public String getJensekomodServiceKhab2() {
		return jensekomodServiceKhab2;
	}

	public void setJensekomodServiceKhab2(String jensekomodServiceKhab2) {
		this.jensekomodServiceKhab2 = jensekomodServiceKhab2;
	}

	public String getAbadkomodServiceKhab2() {
		return abadkomodServiceKhab2;
	}

	public void setAbadkomodServiceKhab2(String abadkomodServiceKhab2) {
		this.abadkomodServiceKhab2 = abadkomodServiceKhab2;
	}

	public String getRangkomodServiceKhab2() {
		return rangkomodServiceKhab2;
	}

	public void setRangkomodServiceKhab2(String rangkomodServiceKhab2) {
		this.rangkomodServiceKhab2 = rangkomodServiceKhab2;
	}

	public long getPriceKomodServiceKhab2() {
		return priceKomodServiceKhab2;
	}

	public void setPriceKomodServiceKhab2(long priceKomodServiceKhab2) {
		this.priceKomodServiceKhab2 = priceKomodServiceKhab2;
	}

	public boolean isMizArayesh2() {
		return mizArayesh2;
	}

	public void setMizArayesh2(boolean mizArayesh2) {
		this.mizArayesh2 = mizArayesh2;
	}


	public boolean isSandaliMizArayesh2() {
		return sandaliMizArayesh2;
	}



	public void setSandaliMizArayesh2(boolean sandaliMizArayesh2) {
		this.sandaliMizArayesh2 = sandaliMizArayesh2;
	}



	public String getJenseMizArayesh2() {
		return jenseMizArayesh2;
	}

	public void setJenseMizArayesh2(String jenseMizArayesh2) {
		this.jenseMizArayesh2 = jenseMizArayesh2;
	}

	public String getAbadMizArayesh2() {
		return abadMizArayesh2;
	}

	public void setAbadMizArayesh2(String abadMizArayesh2) {
		this.abadMizArayesh2 = abadMizArayesh2;
	}

	public String getRangMizArayesh2() {
		return rangMizArayesh2;
	}

	public void setRangMizArayesh2(String rangMizArayesh2) {
		this.rangMizArayesh2 = rangMizArayesh2;
	}

	public long getPriceMizArayesh2() {
		return priceMizArayesh2;
	}

	public void setPriceMizArayesh2(long priceMizArayesh2) {
		this.priceMizArayesh2 = priceMizArayesh2;
	}

	public boolean isMizTahrir2() {
		return mizTahrir2;
	}

	public void setMizTahrir2(boolean mizTahrir2) {
		this.mizTahrir2 = mizTahrir2;
	}

	public String getJensemizTahrir2() {
		return jensemizTahrir2;
	}

	public void setJensemizTahrir2(String jensemizTahrir2) {
		this.jensemizTahrir2 = jensemizTahrir2;
	}

	public String getAbadmizTahrir2() {
		return abadmizTahrir2;
	}

	public void setAbadmizTahrir2(String abadmizTahrir2) {
		this.abadmizTahrir2 = abadmizTahrir2;
	}

	public String getRangmizTahrir2() {
		return rangmizTahrir2;
	}

	public void setRangmizTahrir2(String rangmizTahrir2) {
		this.rangmizTahrir2 = rangmizTahrir2;
	}

	public long getPriceMizTahrir2() {
		return priceMizTahrir2;
	}

	public void setPriceMizTahrir2(long priceMizTahrir2) {
		this.priceMizTahrir2 = priceMizTahrir2;
	}

	public boolean isGabVAyeneGadi2() {
		return gabVAyeneGadi2;
	}

	public void setGabVAyeneGadi2(boolean gabVAyeneGadi2) {
		this.gabVAyeneGadi2 = gabVAyeneGadi2;
	}

	public String getJenseGabVAyeneGadi2() {
		return jenseGabVAyeneGadi2;
	}

	public void setJenseGabVAyeneGadi2(String jenseGabVAyeneGadi2) {
		this.jenseGabVAyeneGadi2 = jenseGabVAyeneGadi2;
	}

	public String getAbadGabVAyeneGadi2() {
		return abadGabVAyeneGadi2;
	}

	public void setAbadGabVAyeneGadi2(String abadGabVAyeneGadi2) {
		this.abadGabVAyeneGadi2 = abadGabVAyeneGadi2;
	}

	public String getRangGabVAyeneGadi2() {
		return rangGabVAyeneGadi2;
	}

	public void setRangGabVAyeneGadi2(String rangGabVAyeneGadi2) {
		this.rangGabVAyeneGadi2 = rangGabVAyeneGadi2;
	}

	public long getPriceGabVAyeneGadi2() {
		return priceGabVAyeneGadi2;
	}

	public void setPriceGabVAyeneGadi2(long priceGabVAyeneGadi2) {
		this.priceGabVAyeneGadi2 = priceGabVAyeneGadi2;
	}

	public boolean isToshak2() {
		return toshak2;
	}

	public void setToshak2(boolean toshak2) {
		this.toshak2 = toshak2;
	}

	public String getBrandToshak2() {
		return brandToshak2;
	}

	public void setBrandToshak2(String brandToshak2) {
		this.brandToshak2 = brandToshak2;
	}

	public String getModelToshak2() {
		return modelToshak2;
	}

	public void setModelToshak2(String modelToshak2) {
		this.modelToshak2 = modelToshak2;
	}

	public int getModatGarantiGabVAyeneGadi2() {
		return modatGarantiGabVAyeneGadi2;
	}

	public void setModatGarantiGabVAyeneGadi2(int modatGarantiGabVAyeneGadi2) {
		this.modatGarantiGabVAyeneGadi2 = modatGarantiGabVAyeneGadi2;
	}

	public String getAbadToshak2() {
		return abadToshak2;
	}

	public void setAbadToshak2(String abadToshak2) {
		this.abadToshak2 = abadToshak2;
	}

	public long getPriceToshak2() {
		return priceToshak2;
	}

	public void setPriceToshak2(long priceToshak2) {
		this.priceToshak2 = priceToshak2;
	}

	public String getDescriptionToshak2() {
		return descriptionToshak2;
	}

	public void setDescriptionToshak2(String descriptionToshak2) {
		this.descriptionToshak2 = descriptionToshak2;
	}



	@Override
	public String toString() {
		return "ServiceKhab2 [modelServiceKhab2=" + modelServiceKhab2 + ", arzeTakhteKhab2=" + arzeTakhteKhab2
				+ ", jenseTakhteKhab2=" + jenseTakhteKhab2 + ", rangeTakhteKhab2=" + rangeTakhteKhab2
				+ ", priceTakhteKhab2=" + priceTakhteKhab2 + ", kalafTakhtJackDar=" + kalafTakhtJackDar + ", keshoVbox="
				+ keshoVbox + ", paTahti2=" + paTahti2 + ", tedadPaTakhti2=" + tedadPaTakhti2 + ", jensePaTakhti2="
				+ jensePaTakhti2 + ", abadPaTakhti2=" + abadPaTakhti2 + ", rangPaTakhti2=" + rangPaTakhti2
				+ ", pricePaTakhti2=" + pricePaTakhti2 + ", komodServiceKhab2=" + komodServiceKhab2
				+ ", jensekomodServiceKhab2=" + jensekomodServiceKhab2 + ", abadkomodServiceKhab2="
				+ abadkomodServiceKhab2 + ", rangkomodServiceKhab2=" + rangkomodServiceKhab2
				+ ", priceKomodServiceKhab2=" + priceKomodServiceKhab2 + ", mizArayesh2=" + mizArayesh2
				+ ", sandaliMizArayesh2=" + sandaliMizArayesh2 + ", jenseMizArayesh2=" + jenseMizArayesh2
				+ ", abadMizArayesh2=" + abadMizArayesh2 + ", rangMizArayesh2=" + rangMizArayesh2
				+ ", priceMizArayesh2=" + priceMizArayesh2 + ", mizTahrir2=" + mizTahrir2 + ", jensemizTahrir2="
				+ jensemizTahrir2 + ", abadmizTahrir2=" + abadmizTahrir2 + ", rangmizTahrir2=" + rangmizTahrir2
				+ ", priceMizTahrir2=" + priceMizTahrir2 + ", gabVAyeneGadi2=" + gabVAyeneGadi2
				+ ", jenseGabVAyeneGadi2=" + jenseGabVAyeneGadi2 + ", abadGabVAyeneGadi2=" + abadGabVAyeneGadi2
				+ ", rangGabVAyeneGadi2=" + rangGabVAyeneGadi2 + ", priceGabVAyeneGadi2=" + priceGabVAyeneGadi2
				+ ", toshak2=" + toshak2 + ", brandToshak2=" + brandToshak2 + ", modelToshak2=" + modelToshak2
				+ ", modatGarantiGabVAyeneGadi2=" + modatGarantiGabVAyeneGadi2 + ", abadToshak2=" + abadToshak2
				+ ", priceToshak2=" + priceToshak2 + ", descriptionToshak2=" + descriptionToshak2 + "]";
	}
	  
	  

}
