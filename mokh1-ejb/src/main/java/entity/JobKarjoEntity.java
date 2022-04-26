package entity;


import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.eclipse.persistence.annotations.Cache;
import org.eclipse.persistence.annotations.CacheCoordinationType;
import org.eclipse.persistence.annotations.CacheType;

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
	@Column(name = "karjo_maharat", length = 100, nullable = true)	
	private String karjoMaharat;
	@Column(name = "karjo_noefaal", length = 200, nullable = true)
	private String karjoNoeFaal;
	@Column(name = "karjo_noehamkari", length = 20, nullable = true)
	private String karjoNoeHamkari;


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
	public String getKarjoMaharat() {
		return karjoMaharat;
	}
	public void setKarjoMaharat(String karjoMaharat) {
		this.karjoMaharat = karjoMaharat;
	}
	public String getKarjoNoeFaal() {
		return karjoNoeFaal;
	}
	public void setKarjoNoeFaal(String karjoNoeFaal) {
		this.karjoNoeFaal = karjoNoeFaal;
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



}
