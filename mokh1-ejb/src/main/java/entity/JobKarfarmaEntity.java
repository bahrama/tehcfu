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
@NamedQueries({
	@NamedQuery(name="findAllKarfarma" , query="SELECT a FROM JobKarfarmaEntity a ORDER BY a.adveriseId DESC"),
	@NamedQuery(name="findKarfarmaById" , query="SELECT i FROM JobKarfarmaEntity i WHERE i.adveriseId=:v_adveriseId"),
})
@Cacheable(value = false)
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorValue(value = "karfarma")
public class JobKarfarmaEntity extends AdvertiseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name = "adveriseId")
	private long adveriseId;
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
	@Column(name = "hogog", nullable = true)
	private long mizanHogog;

	

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


	public long getMizanHogog() {
		return mizanHogog;
	}
	public void setMizanHogog(long mizanHogog) {
		this.mizanHogog = mizanHogog;
	}
	public long getAdveriseId() {
		return adveriseId;
	}
	public void setAdveriseId(long adveriseId) {
		this.adveriseId = adveriseId;
	}
	

}
