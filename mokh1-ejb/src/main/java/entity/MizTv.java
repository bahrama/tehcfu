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
@Table(name = "miz_tv")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorValue(value = "MizTv")
@NamedQueries({
	@NamedQuery(name="findMizTvById" , query="SELECT u FROM MizTv u WHERE u.productId=:v_productId")
})
@Cacheable(value = false)
public class MizTv extends ProductEntity {


	private static final long serialVersionUID = 1L;
	
	  @Column(name = "jenseEskeletMizTv", nullable = true , length=100) private
	  String jenseEskeletMizTv;
	  
	  @Column(name = "abadMizTv", nullable = true , length=100) private String
	  abadMizTv;
	  
	  @Column(name = "mizMarbotTvInch", nullable = true) private int
	  mizMarbotTvInch;
	  
	  @Column(name = "rangMizTv", nullable = true , length=100) private String
	  rangMizTv;
	  
	  @Column(name = "gabeliatRangMizTv", nullable = true) private boolean
	  gabeliatRangMizTv;
	  
	  @Column(name = "rangAvalMizTv", nullable = true , length=100) private String
	  rangAvalMizTv;
	  
	  @Column(name = "rangDovomMizTv", nullable = true , length=100) private String
	  rangDovomMizTv;
	  
	  @Column(name = "kesho", nullable = true) private boolean kesho;
	  
	  @Column(name = "tedadkesho", nullable = true) private int tedadkesho;
	  
	  @Column(name = "jensePayeMizTv", nullable = true , length=100) private String
	  jensePayeMizTv;
	  
	  @Column(name = "rangPayeMizTv", nullable = true , length=100) private String
	  rangPayeMizTv;
	  
	  @Column(name = "fazayeLavazemJanebi", nullable = true) private boolean
	  fazayeLavazemJanebi;
	  
	  @Column(name = "descriptionLavazemJanebi", nullable = true , length=1000)
	  private String descriptionLavazemJanebi;
	  
	  

	public MizTv() {
		super();
		// TODO Auto-generated constructor stub
	}



	public String getJenseEskeletMizTv() {
		return jenseEskeletMizTv;
	}

	public void setJenseEskeletMizTv(String jenseEskeletMizTv) {
		this.jenseEskeletMizTv = jenseEskeletMizTv;
	}

	public String getAbadMizTv() {
		return abadMizTv;
	}

	public void setAbadMizTv(String abadMizTv) {
		this.abadMizTv = abadMizTv;
	}

	public int getMizMarbotTvInch() {
		return mizMarbotTvInch;
	}

	public void setMizMarbotTvInch(int mizMarbotTvInch) {
		this.mizMarbotTvInch = mizMarbotTvInch;
	}

	public String getRangMizTv() {
		return rangMizTv;
	}

	public void setRangMizTv(String rangMizTv) {
		this.rangMizTv = rangMizTv;
	}

	public boolean isGabeliatRangMizTv() {
		return gabeliatRangMizTv;
	}

	public void setGabeliatRangMizTv(boolean gabeliatRangMizTv) {
		this.gabeliatRangMizTv = gabeliatRangMizTv;
	}

	public String getRangAvalMizTv() {
		return rangAvalMizTv;
	}

	public void setRangAvalMizTv(String rangAvalMizTv) {
		this.rangAvalMizTv = rangAvalMizTv;
	}

	public String getRangDovomMizTv() {
		return rangDovomMizTv;
	}

	public void setRangDovomMizTv(String rangDovomMizTv) {
		this.rangDovomMizTv = rangDovomMizTv;
	}

	public boolean isKesho() {
		return kesho;
	}

	public void setKesho(boolean kesho) {
		this.kesho = kesho;
	}

	public int getTedadkesho() {
		return tedadkesho;
	}

	public void setTedadkesho(int tedadkesho) {
		this.tedadkesho = tedadkesho;
	}

	public String getJensePayeMizTv() {
		return jensePayeMizTv;
	}

	public void setJensePayeMizTv(String jensePayeMizTv) {
		this.jensePayeMizTv = jensePayeMizTv;
	}

	public String getRangPayeMizTv() {
		return rangPayeMizTv;
	}

	public void setRangPayeMizTv(String rangPayeMizTv) {
		this.rangPayeMizTv = rangPayeMizTv;
	}

	public boolean isFazayeLavazemJanebi() {
		return fazayeLavazemJanebi;
	}

	public void setFazayeLavazemJanebi(boolean fazayeLavazemJanebi) {
		this.fazayeLavazemJanebi = fazayeLavazemJanebi;
	}

	public String getDescriptionLavazemJanebi() {
		return descriptionLavazemJanebi;
	}

	public void setDescriptionLavazemJanebi(String descriptionLavazemJanebi) {
		this.descriptionLavazemJanebi = descriptionLavazemJanebi;
	}



	@Override
	public String toString() {
		return "MizTv [jenseEskeletMizTv=" + jenseEskeletMizTv + ", abadMizTv=" + abadMizTv + ", mizMarbotTvInch="
				+ mizMarbotTvInch + ", rangMizTv=" + rangMizTv + ", gabeliatRangMizTv=" + gabeliatRangMizTv
				+ ", rangAvalMizTv=" + rangAvalMizTv + ", rangDovomMizTv=" + rangDovomMizTv + ", kesho=" + kesho
				+ ", tedadkesho=" + tedadkesho + ", jensePayeMizTv=" + jensePayeMizTv + ", rangPayeMizTv="
				+ rangPayeMizTv + ", fazayeLavazemJanebi=" + fazayeLavazemJanebi + ", descriptionLavazemJanebi="
				+ descriptionLavazemJanebi + "]";
	}

	  
}
