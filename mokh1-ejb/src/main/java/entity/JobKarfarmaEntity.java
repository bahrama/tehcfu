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
	@Column(name = "karafarma_company", length = 200, nullable = true)
	private String karfarmaCompanyName;
	@Column(name = "karafarma_niromorede", length = 100, nullable = true)
	private String karfarmaNiroMorede;
	@Column(name = "karafarma_takhasos", length = 500, nullable = true)
	private String karfarmaTakhasosMorede;
	@Column(name = "hogog", nullable = true)
	private long mizanHogog;
	@Column(name = "minSabege", nullable = true)
	private long minSabege;
	@Column(name = "magtaTahsisli", length = 200, nullable = true)
	private String magtaTahsisli;
	@Column(name = "reshte", length = 200, nullable = true)
	private String reshte;
	@Column(name = "sen", nullable = true)
	private long sen;
	@Column(name = "takhasos", length = 200, nullable = true)
	private String takhasos;
	@Column(name = "jensiat", length = 200, nullable = true)
	private String jensiat;
	@Column(name = "noeHamkari", length = 200, nullable = true)
	private String noeHamkari;
	@Column(name = "noeHogog", length = 200, nullable = true)
	private String noeHogog;
	@Column(name = "saatKari", length = 200, nullable = true)
	private String saatKari;
	@Column(name = "bime", length = 200, nullable = true)
	private String bime;
	@Column(name = "bimeTakmili", length = 200, nullable = true)
	private String bimeTakmili;
	@Column(name = "ezafekar", length = 200, nullable = true)
	private String ezafekar;
	@Column(name = "morekhasi", length = 200, nullable = true)
	private String morekhasi;
	
	
	

	public String getKarfarmaCompanyName() {
		return karfarmaCompanyName;
	}
	public void setKarfarmaCompanyName(String karfarmaCompanyName) {
		this.karfarmaCompanyName = karfarmaCompanyName;
	}


	public String getKarfarmaNiroMorede() {
		return karfarmaNiroMorede;
	}
	public void setKarfarmaNiroMorede(String karfarmaNiroMorede) {
		this.karfarmaNiroMorede = karfarmaNiroMorede;
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
	public long getMinSabege() {
		return minSabege;
	}
	public void setMinSabege(long minSabege) {
		this.minSabege = minSabege;
	}
	public String getMagtaTahsisli() {
		return magtaTahsisli;
	}
	public void setMagtaTahsisli(String magtaTahsisli) {
		this.magtaTahsisli = magtaTahsisli;
	}
	public String getReshte() {
		return reshte;
	}
	public void setReshte(String reshte) {
		this.reshte = reshte;
	}
	public long getSen() {
		return sen;
	}
	public void setSen(long sen) {
		this.sen = sen;
	}
	public String getTakhasos() {
		return takhasos;
	}
	public void setTakhasos(String takhasos) {
		this.takhasos = takhasos;
	}
	public String getJensiat() {
		return jensiat;
	}
	public void setJensiat(String jensiat) {
		this.jensiat = jensiat;
	}
	public String getNoeHamkari() {
		return noeHamkari;
	}
	public void setNoeHamkari(String noeHamkari) {
		this.noeHamkari = noeHamkari;
	}
	public String getNoeHogog() {
		return noeHogog;
	}
	public void setNoeHogog(String noeHogog) {
		this.noeHogog = noeHogog;
	}
	public String getSaatKari() {
		return saatKari;
	}
	public void setSaatKari(String saatKari) {
		this.saatKari = saatKari;
	}
	public String getBime() {
		return bime;
	}
	public void setBime(String bime) {
		this.bime = bime;
	}
	public String getBimeTakmili() {
		return bimeTakmili;
	}
	public void setBimeTakmili(String bimeTakmili) {
		this.bimeTakmili = bimeTakmili;
	}
	public String getEzafekar() {
		return ezafekar;
	}
	public void setEzafekar(String ezafekar) {
		this.ezafekar = ezafekar;
	}
	public String getMorekhasi() {
		return morekhasi;
	}
	public void setMorekhasi(String morekhasi) {
		this.morekhasi = morekhasi;
	}
	

}
