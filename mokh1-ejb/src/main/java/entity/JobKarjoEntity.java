package entity;


import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.eclipse.persistence.annotations.Cache;
import org.eclipse.persistence.annotations.CacheCoordinationType;
import org.eclipse.persistence.annotations.CacheType;

@Entity
@Table(name="karjo_tbl")
@Cache(type = CacheType.SOFT, coordinationType = CacheCoordinationType.INVALIDATE_CHANGED_OBJECTS, size = 1000000)
@NamedQueries({
	@NamedQuery(name="findAllkarjo" , query="SELECT a FROM JobKarjoEntity a ORDER BY a.karjoId DESC"),
	@NamedQuery(name="findKarjoById" , query="SELECT i FROM JobKarjoEntity i WHERE i.karjoId=:v_karjoId"),
})
public class JobKarjoEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "karjo_id")
	private long karjoId;
	@Column(name = "karjo_title", length = 100, nullable = true)
    private String karjoTitle;
	@Column(name = "karjo_field", length = 100, nullable = true)
	private String karjoField;
	@Column(name = "karjo_madrak", length = 100, nullable = true)
	private String karjoMadrak;
	@Column(name = "karjo_maharat", length = 100, nullable = true)	
	private String karjoMaharat;
	@Column(name = "karjo_noefaal", length = 200, nullable = true)
	private String karjoNoeFaal;
	@Column(name = "karjo_description", length = 500, nullable = true)
	private String karjoDescription;
	@Column(name = "karjo_noehamkari", length = 20, nullable = true)
	private String karjoNoeHamkari;
	@Lob
	@Column(name="karjo_resume" , nullable=true)
	private byte[] karjoResume;
	@Column(name = "show")
	private boolean show;
	@Temporal(TemporalType.DATE)
	private Date date;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_karjo")
	private MoblEntity karjo;
	
	
	public long getKarjoId() {
		return karjoId;
	}
	public void setKarjoId(long karjoId) {
		this.karjoId = karjoId;
	}

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
	public String getKarjoDescription() {
		return karjoDescription;
	}
	public void setKarjoDescription(String karjoDescription) {
		this.karjoDescription = karjoDescription;
	}
	public String getKarjoNoeHamkari() {
		return karjoNoeHamkari;
	}
	public void setKarjoNoeHamkari(String karjoNoeHamkari) {
		this.karjoNoeHamkari = karjoNoeHamkari;
	}
	

	public byte[] getKarjoResume() {
		return karjoResume;
	}
	public void setKarjoResume(byte[] karjoResume) {
		this.karjoResume = karjoResume;
	}

	
	public boolean isShow() {
		return show;
	}
	public void setShow(boolean show) {
		this.show = show;
	}
	
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public MoblEntity getKarjo() {
		return karjo;
	}
	public void setKarjo(MoblEntity karjo) {
		this.karjo = karjo;
	}

	public String getKarjoTitle() {
		return karjoTitle;
	}
	public void setKarjoTitle(String karjoTitle) {
		this.karjoTitle = karjoTitle;
	}
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof JobKarjoEntity))
			return false;
		JobKarjoEntity jobKarjoEntity=(JobKarjoEntity) obj;
		return (jobKarjoEntity.karjoId==this.karjoId);
	}

}
