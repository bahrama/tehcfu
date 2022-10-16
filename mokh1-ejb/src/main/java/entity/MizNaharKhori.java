package entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
@Entity
@Table(name = "Miz_Nahar_Khori")
@NamedQueries({
	@NamedQuery(name="findMizNaharKhoriById" , query="SELECT u FROM MizNaharKhori u WHERE u.id=:v_id")
})
@Cacheable(value = false)
public class MizNaharKhori implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	  @Column(name = "tedadMizNaharKhori", nullable = true) private int
	  tedadMizNaharKhori;
	  
	  @Column(name = "sakhtarMizNaharKhori", nullable = true , length=100) private
	  String sakhtarMizNaharKhori;
	  
	  @Column(name = "descriptionMizNaharKhori", nullable = true , length=1000)
	  private String descriptionMizNaharKhori;
	  
	  @Column(name = "sheklehendesiMizNaharKhori", nullable = true , length=100)
	  private String sheklehendesiMizNaharKhori;
	  
	  @Column(name = "jenseSafeMizNaharKhori", nullable = true , length=100)
	  private String jenseSafeMizNaharKhori;
	  
	  @Column(name = "jenseEskeletMizNaharKhori", nullable = true , length=100)
	  private String jenseEskeletMizNaharKhori;
	  
	  @Column(name = "jensePayeMizNaharKhori", nullable = true , length=100)
	  private String jensePayeMizNaharKhori;
	  
	  @Column(name = "shisheMizNaharKhori", nullable = true) private boolean
	  shisheMizNaharKhori;
	  
	  @Column(name = "rangeShisheMizNaharKhori", nullable = true , length=100)
	  private String rangeShisheMizNaharKhori;
	  
	  @Column(name = "zekhamatShisheMizNaharKhori", nullable = true , length=100)
	  private String zekhamatShisheMizNaharKhori;
	  
	  @Column(name = "priceShisheMizNaharKhori", nullable = true) private long
	  priceShisheMizNaharKhori;
	  
	  @Column(name = "shisheAbzarMizNaharKhori", nullable = true) private boolean
	  shisheAbzarMizNaharKhori;
	  
	  @Column(name = "tedadSandaliMizNaharKhori", nullable = true) private int
	  tedadSandaliMizNaharKhori;
	  
	  @Column(name = "jenseFomSandaliMizNaharKhori", nullable = true , length=100)
	  private String jenseFomSandaliMizNaharKhori;
	  
	  @Column(name = "jenseEsfangSandaliMizNaharKhori", nullable = true ,
	  length=100) private String jenseEsfangSandaliMizNaharKhori;
	  
	  @Column(name = "jenseEskeletSandaliMizNaharKhori", nullable = true ,
	  length=100) private String jenseEskeletSandaliMizNaharKhori;
	  
	  @Column(name = "jensePayeSandaliMizNaharKhori", nullable = true , length=100)
	  private String jensePayeSandaliMizNaharKhori;
	  
	  @Column(name = "payeSandaliRangMizNaharKhori", nullable = true) private
	  boolean payeSandaliRangMizNaharKhori;
	  
	  @Column(name = "rangPayeSandaliMizNaharKhori", nullable = true , length=100)
	  private String rangPayeSandaliMizNaharKhori;
	  
	  @Column(name = "jenseParcheSandaliMizNaharKhori", nullable = true ,
	  length=100) private String jenseParcheSandaliMizNaharKhori;
	  
	  @Column(name = "nameParcheSandaliMizNaharKhori", nullable = true ,
	  length=100) private String nameParcheSandaliMizNaharKhori;
	  
	  @Column(name = "rangSelParcheSandaliMizNaharKhori", nullable = true) private
	  boolean rangSelParcheSandaliMizNaharKhori;
	  
	  @Column(name = "rangParcheSandaliMizNaharKhori", nullable = true ,
	  length=100) private String rangParcheSandaliMizNaharKhori;
	  
		@OneToOne(mappedBy = "mizNaharKhori")
		private ProductEntity product;

	public MizNaharKhori() {
		super();
		// TODO Auto-generated constructor stub
	}



	public int getTedadMizNaharKhori() {
		return tedadMizNaharKhori;
	}

	public void setTedadMizNaharKhori(int tedadMizNaharKhori) {
		this.tedadMizNaharKhori = tedadMizNaharKhori;
	}

	public String getSakhtarMizNaharKhori() {
		return sakhtarMizNaharKhori;
	}

	public void setSakhtarMizNaharKhori(String sakhtarMizNaharKhori) {
		this.sakhtarMizNaharKhori = sakhtarMizNaharKhori;
	}

	public String getDescriptionMizNaharKhori() {
		return descriptionMizNaharKhori;
	}

	public void setDescriptionMizNaharKhori(String descriptionMizNaharKhori) {
		this.descriptionMizNaharKhori = descriptionMizNaharKhori;
	}

	public String getSheklehendesiMizNaharKhori() {
		return sheklehendesiMizNaharKhori;
	}

	public void setSheklehendesiMizNaharKhori(String sheklehendesiMizNaharKhori) {
		this.sheklehendesiMizNaharKhori = sheklehendesiMizNaharKhori;
	}

	public String getJenseSafeMizNaharKhori() {
		return jenseSafeMizNaharKhori;
	}

	public void setJenseSafeMizNaharKhori(String jenseSafeMizNaharKhori) {
		this.jenseSafeMizNaharKhori = jenseSafeMizNaharKhori;
	}

	public String getJenseEskeletMizNaharKhori() {
		return jenseEskeletMizNaharKhori;
	}

	public void setJenseEskeletMizNaharKhori(String jenseEskeletMizNaharKhori) {
		this.jenseEskeletMizNaharKhori = jenseEskeletMizNaharKhori;
	}

	public String getJensePayeMizNaharKhori() {
		return jensePayeMizNaharKhori;
	}

	public void setJensePayeMizNaharKhori(String jensePayeMizNaharKhori) {
		this.jensePayeMizNaharKhori = jensePayeMizNaharKhori;
	}

	public boolean isShisheMizNaharKhori() {
		return shisheMizNaharKhori;
	}

	public void setShisheMizNaharKhori(boolean shisheMizNaharKhori) {
		this.shisheMizNaharKhori = shisheMizNaharKhori;
	}

	public String getRangeShisheMizNaharKhori() {
		return rangeShisheMizNaharKhori;
	}

	public void setRangeShisheMizNaharKhori(String rangeShisheMizNaharKhori) {
		this.rangeShisheMizNaharKhori = rangeShisheMizNaharKhori;
	}

	public String getZekhamatShisheMizNaharKhori() {
		return zekhamatShisheMizNaharKhori;
	}

	public void setZekhamatShisheMizNaharKhori(String zekhamatShisheMizNaharKhori) {
		this.zekhamatShisheMizNaharKhori = zekhamatShisheMizNaharKhori;
	}

	public long getPriceShisheMizNaharKhori() {
		return priceShisheMizNaharKhori;
	}

	public void setPriceShisheMizNaharKhori(long priceShisheMizNaharKhori) {
		this.priceShisheMizNaharKhori = priceShisheMizNaharKhori;
	}

	public boolean isShisheAbzarMizNaharKhori() {
		return shisheAbzarMizNaharKhori;
	}

	public void setShisheAbzarMizNaharKhori(boolean shisheAbzarMizNaharKhori) {
		this.shisheAbzarMizNaharKhori = shisheAbzarMizNaharKhori;
	}

	public int getTedadSandaliMizNaharKhori() {
		return tedadSandaliMizNaharKhori;
	}

	public void setTedadSandaliMizNaharKhori(int tedadSandaliMizNaharKhori) {
		this.tedadSandaliMizNaharKhori = tedadSandaliMizNaharKhori;
	}

	public String getJenseFomSandaliMizNaharKhori() {
		return jenseFomSandaliMizNaharKhori;
	}

	public void setJenseFomSandaliMizNaharKhori(String jenseFomSandaliMizNaharKhori) {
		this.jenseFomSandaliMizNaharKhori = jenseFomSandaliMizNaharKhori;
	}

	public String getJenseEsfangSandaliMizNaharKhori() {
		return jenseEsfangSandaliMizNaharKhori;
	}

	public void setJenseEsfangSandaliMizNaharKhori(String jenseEsfangSandaliMizNaharKhori) {
		this.jenseEsfangSandaliMizNaharKhori = jenseEsfangSandaliMizNaharKhori;
	}

	public String getJenseEskeletSandaliMizNaharKhori() {
		return jenseEskeletSandaliMizNaharKhori;
	}

	public void setJenseEskeletSandaliMizNaharKhori(String jenseEskeletSandaliMizNaharKhori) {
		this.jenseEskeletSandaliMizNaharKhori = jenseEskeletSandaliMizNaharKhori;
	}

	public String getJensePayeSandaliMizNaharKhori() {
		return jensePayeSandaliMizNaharKhori;
	}

	public void setJensePayeSandaliMizNaharKhori(String jensePayeSandaliMizNaharKhori) {
		this.jensePayeSandaliMizNaharKhori = jensePayeSandaliMizNaharKhori;
	}

	public boolean isPayeSandaliRangMizNaharKhori() {
		return payeSandaliRangMizNaharKhori;
	}

	public void setPayeSandaliRangMizNaharKhori(boolean payeSandaliRangMizNaharKhori) {
		this.payeSandaliRangMizNaharKhori = payeSandaliRangMizNaharKhori;
	}

	public String getRangPayeSandaliMizNaharKhori() {
		return rangPayeSandaliMizNaharKhori;
	}

	public void setRangPayeSandaliMizNaharKhori(String rangPayeSandaliMizNaharKhori) {
		this.rangPayeSandaliMizNaharKhori = rangPayeSandaliMizNaharKhori;
	}

	public String getJenseParcheSandaliMizNaharKhori() {
		return jenseParcheSandaliMizNaharKhori;
	}

	public void setJenseParcheSandaliMizNaharKhori(String jenseParcheSandaliMizNaharKhori) {
		this.jenseParcheSandaliMizNaharKhori = jenseParcheSandaliMizNaharKhori;
	}

	public String getNameParcheSandaliMizNaharKhori() {
		return nameParcheSandaliMizNaharKhori;
	}

	public void setNameParcheSandaliMizNaharKhori(String nameParcheSandaliMizNaharKhori) {
		this.nameParcheSandaliMizNaharKhori = nameParcheSandaliMizNaharKhori;
	}

	public boolean isRangSelParcheSandaliMizNaharKhori() {
		return rangSelParcheSandaliMizNaharKhori;
	}

	public void setRangSelParcheSandaliMizNaharKhori(boolean rangSelParcheSandaliMizNaharKhori) {
		this.rangSelParcheSandaliMizNaharKhori = rangSelParcheSandaliMizNaharKhori;
	}

	public String getRangParcheSandaliMizNaharKhori() {
		return rangParcheSandaliMizNaharKhori;
	}

	public void setRangParcheSandaliMizNaharKhori(String rangParcheSandaliMizNaharKhori) {
		this.rangParcheSandaliMizNaharKhori = rangParcheSandaliMizNaharKhori;
	}



	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public ProductEntity getProduct() {
		return product;
	}



	public void setProduct(ProductEntity product) {
		this.product = product;
	}




	  
	  

}
