package entity;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.eclipse.persistence.annotations.Cache;
import org.eclipse.persistence.annotations.CacheCoordinationType;
import org.eclipse.persistence.annotations.CacheType;

@Entity
@Table(name="karfarma_tbl")
@Cache(type = CacheType.SOFT, coordinationType = CacheCoordinationType.INVALIDATE_CHANGED_OBJECTS, size = 1000000)
@NamedQueries({
	@NamedQuery(name="findAllKarfarma" , query="SELECT a FROM JobKarfarmaEntity a ORDER BY a.karafarmaId DESC"),
	@NamedQuery(name="findKarfarmaById" , query="SELECT i FROM JobKarfarmaEntity i WHERE i.karafarmaId=:v_karafarmaId"),
})
public class JobKarfarmaEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "karfarma_id")
	private long karafarmaId;
	@Column(name = "karafarma_senf", length = 150, nullable = true)
	private String karfarmaSenf;
	@Column(name = "karafarma_company", length = 200, nullable = true)
	private String karfarmaCompanyName;


	@Column(name = "karafarma_pasokhname", length = 150, nullable = true)
	private String karfarmaPasokhName;
	@Column(name = "karafarma_pasokhsemat", length = 100, nullable = true)
	private String karfarmaPasokhSemat;
	@Column(name = "karafarma_niromorede", length = 100, nullable = true)
	private String karfarmaNiroMorede;
	@Column(name = "karafarma_noedrakhast", length = 100, nullable = true)
	private String karfarmaNoeDarkhast;
	@Column(name = "karafarma_takhasos", length = 500, nullable = true)
	private String karfarmaTakhasosMorede;
	@Column(name = "karafarma_desc", length = 500, nullable = true)
	private String karfarmaDescription;

	@Column(name = "hogog", length = 30, nullable = true)
	private String mizanHogog;
	
	@Lob
	@Column(name="karfarma_pic" , nullable=true)
	private byte[] karfarmaPic;
	@Column(name = "karafarma_taeed")
	private boolean taeed;
	@Column(name = "karafarma_city", length = 100, nullable = true)
	private String karfarmaJobCity;
	@Column(name = "karafarma_title", length = 200, nullable = true)
	private String karfarmaJobTitle;
	@Temporal(TemporalType.DATE)
	private Date date;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "mobl_karfarma")
	private MoblEntity karfarma;
	
	
	public long getKarafarmaId() {
		return karafarmaId;
	}
	public void setKarafarmaId(long karafarmaId) {
		this.karafarmaId = karafarmaId;
	}
	public String getKarfarmaSenf() {
		return karfarmaSenf;
	}
	public void setKarfarmaSenf(String karfarmaSenf) {
		this.karfarmaSenf = karfarmaSenf;
	}
	public String getKarfarmaCompanyName() {
		return karfarmaCompanyName;
	}
	public void setKarfarmaCompanyName(String karfarmaCompanyName) {
		this.karfarmaCompanyName = karfarmaCompanyName;
	}

	public String getKarfarmaPasokhName() {
		return karfarmaPasokhName;
	}
	public void setKarfarmaPasokhName(String karfarmaPasokhName) {
		this.karfarmaPasokhName = karfarmaPasokhName;
	}
	public String getKarfarmaPasokhSemat() {
		return karfarmaPasokhSemat;
	}
	public void setKarfarmaPasokhSemat(String karfarmaPasokhSemat) {
		this.karfarmaPasokhSemat = karfarmaPasokhSemat;
	}
	public String getKarfarmaNiroMorede() {
		return karfarmaNiroMorede;
	}
	public void setKarfarmaNiroMorede(String karfarmaNiroMorede) {
		this.karfarmaNiroMorede = karfarmaNiroMorede;
	}
	public String getKarfarmaNoeDarkhast() {
		return karfarmaNoeDarkhast;
	}
	public void setKarfarmaNoeDarkhast(String karfarmaNoeDarkhast) {
		this.karfarmaNoeDarkhast = karfarmaNoeDarkhast;
	}
	public String getKarfarmaTakhasosMorede() {
		return karfarmaTakhasosMorede;
	}
	public void setKarfarmaTakhasosMorede(String karfarmaTakhasosMorede) {
		this.karfarmaTakhasosMorede = karfarmaTakhasosMorede;
	}
	public String getKarfarmaDescription() {
		return karfarmaDescription;
	}
	public void setKarfarmaDescription(String karfarmaDescription) {
		this.karfarmaDescription = karfarmaDescription;
	}
	
	
	
	public byte[] getKarfarmaPic() {
		return karfarmaPic;
	}
	public void setKarfarmaPic(byte[] karfarmaPic) {
		this.karfarmaPic = karfarmaPic;
	}
	public boolean isTaeed() {
		return taeed;
	}
	public void setTaeed(boolean taeed) {
		this.taeed = taeed;
	}
	
	
	public String getKarfarmaJobCity() {
		return karfarmaJobCity;
	}
	public void setKarfarmaJobCity(String karfarmaJobCity) {
		this.karfarmaJobCity = karfarmaJobCity;
	}
	public String getKarfarmaJobTitle() {
		return karfarmaJobTitle;
	}
	public void setKarfarmaJobTitle(String karfarmaJobTitle) {
		this.karfarmaJobTitle = karfarmaJobTitle;
	}

	
	public String getMizanHogog() {
		return mizanHogog;
	}
	public void setMizanHogog(String mizanHogog) {
		this.mizanHogog = mizanHogog;
	}
	
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public MoblEntity getKarfarma() {
		return karfarma;
	}
	public void setKarfarma(MoblEntity karfarma) {
		this.karfarma = karfarma;
	}
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof JobKarfarmaEntity))
			return false;
		JobKarfarmaEntity karfarmaEntity=(JobKarfarmaEntity) obj;
		return (karfarmaEntity.karafarmaId==this.karafarmaId);
	}
}
