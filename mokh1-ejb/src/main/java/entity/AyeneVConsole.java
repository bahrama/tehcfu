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
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
@Entity
@Table(name = "ayene_consol")
@NamedQueries({
	@NamedQuery(name="findAyeneVConsoleById" , query="SELECT u FROM AyeneVConsole u WHERE u.id=:v_id")
})
@Cacheable(value = false)
public class AyeneVConsole implements Serializable{
	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	  @Column(name = "jenseEskeletConsole", nullable = true , length=100) private
	  String jenseEskeletConsole;
	  
	  @Column(name = "jensePayeConsole", nullable = true , length=100) private
	  String jensePayeConsole;
	  
	  @Column(name = "priceConsole", nullable = true) private long priceConsole;
	  
	  @Column(name = "keshoConsole", nullable = true) private boolean keshoConsole;
	  
	  @Column(name = "tedadKesho", nullable =true) private int tedadKesho;
	  
	  @Column(name = "komodConsole", nullable = true) private boolean komodConsole;
	  
	  @Column(name = "tedadKomod", nullable =true) private int tedadKomod;
	  
	  @Column(name = "ayeneConsole", nullable = true) private boolean ayeneConsole;
	  
	  @Column(name = "tedadAyene", nullable =true) private int tedadAyene;
	  
	  @Column(name = "shekleHendesi", nullable = true , length=100) private String
	  shekleHendesi;
	  
	  @Column(name = "zekhamatAyene", nullable = true , length=100) private String
	  zekhamatAyene;
	  
	  @Column(name = "ayeneGhab", nullable = true) private boolean ayeneGhab;
	  
	  @Column(name = "jenseGhab", nullable = true , length=100) private String
	  jenseGhab;
	  
	  @Column(name = "abadGhabAyene", nullable = true , length=100) private String
	  abadGhabAyene;
	  
	  @Column(name = "rangGhabAyene", nullable = true , length=100) private String
	  rangGhabAyene;
	  
	  @Column(name = "priceGhabAyene", nullable = true) private long
	  priceGhabAyene;
	  
	  
		@OneToOne(mappedBy = "ayeneVConsole")
		private ProductEntity product;

	public String getJenseEskeletConsole() {
		return jenseEskeletConsole;
	}

	public void setJenseEskeletConsole(String jenseEskeletConsole) {
		this.jenseEskeletConsole = jenseEskeletConsole;
	}

	public String getJensePayeConsole() {
		return jensePayeConsole;
	}

	public void setJensePayeConsole(String jensePayeConsole) {
		this.jensePayeConsole = jensePayeConsole;
	}

	public long getPriceConsole() {
		return priceConsole;
	}

	public void setPriceConsole(long priceConsole) {
		this.priceConsole = priceConsole;
	}

	public boolean isKeshoConsole() {
		return keshoConsole;
	}

	public void setKeshoConsole(boolean keshoConsole) {
		this.keshoConsole = keshoConsole;
	}

	public int getTedadKesho() {
		return tedadKesho;
	}

	public void setTedadKesho(int tedadKesho) {
		this.tedadKesho = tedadKesho;
	}

	public boolean isKomodConsole() {
		return komodConsole;
	}

	public void setKomodConsole(boolean komodConsole) {
		this.komodConsole = komodConsole;
	}

	public int getTedadKomod() {
		return tedadKomod;
	}

	public void setTedadKomod(int tedadKomod) {
		this.tedadKomod = tedadKomod;
	}

	public boolean isAyeneConsole() {
		return ayeneConsole;
	}

	public void setAyeneConsole(boolean ayeneConsole) {
		this.ayeneConsole = ayeneConsole;
	}

	public int getTedadAyene() {
		return tedadAyene;
	}

	public void setTedadAyene(int tedadAyene) {
		this.tedadAyene = tedadAyene;
	}

	public String getShekleHendesi() {
		return shekleHendesi;
	}

	public void setShekleHendesi(String shekleHendesi) {
		this.shekleHendesi = shekleHendesi;
	}

	public String getZekhamatAyene() {
		return zekhamatAyene;
	}

	public void setZekhamatAyene(String zekhamatAyene) {
		this.zekhamatAyene = zekhamatAyene;
	}

	public boolean isAyeneGhab() {
		return ayeneGhab;
	}

	public void setAyeneGhab(boolean ayeneGhab) {
		this.ayeneGhab = ayeneGhab;
	}

	public String getJenseGhab() {
		return jenseGhab;
	}

	public void setJenseGhab(String jenseGhab) {
		this.jenseGhab = jenseGhab;
	}

	public String getAbadGhabAyene() {
		return abadGhabAyene;
	}

	public void setAbadGhabAyene(String abadGhabAyene) {
		this.abadGhabAyene = abadGhabAyene;
	}

	public String getRangGhabAyene() {
		return rangGhabAyene;
	}

	public void setRangGhabAyene(String rangGhabAyene) {
		this.rangGhabAyene = rangGhabAyene;
	}

	public long getPriceGhabAyene() {
		return priceGhabAyene;
	}

	public void setPriceGhabAyene(long priceGhabAyene) {
		this.priceGhabAyene = priceGhabAyene;
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
