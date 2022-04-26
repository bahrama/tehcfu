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
@Table(name = "Miz_Edari")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorValue(value = "MizEdari")
@NamedQueries({
	@NamedQuery(name="findMizEdariById" , query="SELECT u FROM MizEdari u WHERE u.productId=:v_productId")
})
@Cacheable(value = false)
public class MizEdari extends ProductEntity {

	private static final long serialVersionUID = 1L;

	 @Column(name = "sheklehendesiMizٍEdari", nullable = true , length=100)
	  private String sheklehendesiMizٍEdari;
	  
	  @Column(name = "tedadChantekeMizٍEdari", nullable = true) private int
	  tedadChantekeMizٍEdari;
	  
	  @Column(name = "jenseEskeletMizٍEdari", nullable = true , length=100) private
	  String jenseEskeletMizٍEdari;
	  
	  @Column(name = "jensePayeMizٍEdari", nullable = true , length=100) private
	  String jensePayeMizٍEdari;
	  
	  @Column(name = "shisheMizٍEdari", nullable = true) private boolean
	  shisheMizٍEdari;
	  
	  @Column(name = "noeShisheMizٍEdari", nullable = true , length=100) private
	  String noeShisheMizٍEdari;
	  
	  @Column(name = "priceShisheMizٍEdari", nullable = true) private long
	  priceShisheMizٍEdari;
	  
	  @Column(name = "shisheAbzarMizٍEdari", nullable = true) private boolean
	  shisheAbzarMizٍEdari;
	  
	  @Column(name = "keshoMizٍEdari", nullable = true) private boolean
	  keshoMizٍEdari;
	  
	  @Column(name = "tedadkeshoMizٍEdari", nullable = true) private int
	  tedadkeshoMizٍEdari;
	  
	  @Column(name = "komodMizٍEdari", nullable = true) private boolean
	  komodMizٍEdari;
	  
	  @Column(name = "tedadkomodMizٍEdari", nullable = true) private int
	  tedadkomodMizٍEdari;
	  
	  @Column(name = "fazayeLavazemJanebiMizٍEdari", nullable = true) private
	  boolean fazayeLavazemJanebiMizٍEdari;
	  
	  @Column(name = "descriptionfazayeLavazemJanebiMizٍEdari", nullable = true ,
	  length=1000) private String descriptionfazayeLavazemJanebiMizٍEdari;
	  
	  

	public MizEdari() {
		super();
		// TODO Auto-generated constructor stub
	}



	public String getSheklehendesiMizٍEdari() {
		return sheklehendesiMizٍEdari;
	}

	public void setSheklehendesiMizٍEdari(String sheklehendesiMizٍEdari) {
		this.sheklehendesiMizٍEdari = sheklehendesiMizٍEdari;
	}

	public int getTedadChantekeMizٍEdari() {
		return tedadChantekeMizٍEdari;
	}

	public void setTedadChantekeMizٍEdari(int tedadChantekeMizٍEdari) {
		this.tedadChantekeMizٍEdari = tedadChantekeMizٍEdari;
	}

	public String getJenseEskeletMizٍEdari() {
		return jenseEskeletMizٍEdari;
	}

	public void setJenseEskeletMizٍEdari(String jenseEskeletMizٍEdari) {
		this.jenseEskeletMizٍEdari = jenseEskeletMizٍEdari;
	}

	public String getJensePayeMizٍEdari() {
		return jensePayeMizٍEdari;
	}

	public void setJensePayeMizٍEdari(String jensePayeMizٍEdari) {
		this.jensePayeMizٍEdari = jensePayeMizٍEdari;
	}

	public boolean isShisheMizٍEdari() {
		return shisheMizٍEdari;
	}

	public void setShisheMizٍEdari(boolean shisheMizٍEdari) {
		this.shisheMizٍEdari = shisheMizٍEdari;
	}

	public String getNoeShisheMizٍEdari() {
		return noeShisheMizٍEdari;
	}

	public void setNoeShisheMizٍEdari(String noeShisheMizٍEdari) {
		this.noeShisheMizٍEdari = noeShisheMizٍEdari;
	}

	public long getPriceShisheMizٍEdari() {
		return priceShisheMizٍEdari;
	}

	public void setPriceShisheMizٍEdari(long priceShisheMizٍEdari) {
		this.priceShisheMizٍEdari = priceShisheMizٍEdari;
	}

	public boolean isShisheAbzarMizٍEdari() {
		return shisheAbzarMizٍEdari;
	}

	public void setShisheAbzarMizٍEdari(boolean shisheAbzarMizٍEdari) {
		this.shisheAbzarMizٍEdari = shisheAbzarMizٍEdari;
	}

	public boolean isKeshoMizٍEdari() {
		return keshoMizٍEdari;
	}

	public void setKeshoMizٍEdari(boolean keshoMizٍEdari) {
		this.keshoMizٍEdari = keshoMizٍEdari;
	}

	public int getTedadkeshoMizٍEdari() {
		return tedadkeshoMizٍEdari;
	}

	public void setTedadkeshoMizٍEdari(int tedadkeshoMizٍEdari) {
		this.tedadkeshoMizٍEdari = tedadkeshoMizٍEdari;
	}

	public boolean isKomodMizٍEdari() {
		return komodMizٍEdari;
	}

	public void setKomodMizٍEdari(boolean komodMizٍEdari) {
		this.komodMizٍEdari = komodMizٍEdari;
	}

	public int getTedadkomodMizٍEdari() {
		return tedadkomodMizٍEdari;
	}

	public void setTedadkomodMizٍEdari(int tedadkomodMizٍEdari) {
		this.tedadkomodMizٍEdari = tedadkomodMizٍEdari;
	}

	public boolean isFazayeLavazemJanebiMizٍEdari() {
		return fazayeLavazemJanebiMizٍEdari;
	}

	public void setFazayeLavazemJanebiMizٍEdari(boolean fazayeLavazemJanebiMizٍEdari) {
		this.fazayeLavazemJanebiMizٍEdari = fazayeLavazemJanebiMizٍEdari;
	}

	public String getDescriptionfazayeLavazemJanebiMizٍEdari() {
		return descriptionfazayeLavazemJanebiMizٍEdari;
	}

	public void setDescriptionfazayeLavazemJanebiMizٍEdari(String descriptionfazayeLavazemJanebiMizٍEdari) {
		this.descriptionfazayeLavazemJanebiMizٍEdari = descriptionfazayeLavazemJanebiMizٍEdari;
	}



	@Override
	public String toString() {
		return "MizEdari [sheklehendesiMizٍEdari=" + sheklehendesiMizٍEdari + ", tedadChantekeMizٍEdari="
				+ tedadChantekeMizٍEdari + ", jenseEskeletMizٍEdari=" + jenseEskeletMizٍEdari + ", jensePayeMizٍEdari="
				+ jensePayeMizٍEdari + ", shisheMizٍEdari=" + shisheMizٍEdari + ", noeShisheMizٍEdari="
				+ noeShisheMizٍEdari + ", priceShisheMizٍEdari=" + priceShisheMizٍEdari + ", shisheAbzarMizٍEdari="
				+ shisheAbzarMizٍEdari + ", keshoMizٍEdari=" + keshoMizٍEdari + ", tedadkeshoMizٍEdari="
				+ tedadkeshoMizٍEdari + ", komodMizٍEdari=" + komodMizٍEdari + ", tedadkomodMizٍEdari="
				+ tedadkomodMizٍEdari + ", fazayeLavazemJanebiMizٍEdari=" + fazayeLavazemJanebiMizٍEdari
				+ ", descriptionfazayeLavazemJanebiMizٍEdari=" + descriptionfazayeLavazemJanebiMizٍEdari + "]";
	}
	  
	  
}
