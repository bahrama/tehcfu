package entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.eclipse.persistence.annotations.Cache;
import org.eclipse.persistence.annotations.CacheCoordinationType;
import org.eclipse.persistence.annotations.CacheType;

@Entity
@Table(name="bazdid_tbl")
@Cache(type = CacheType.SOFT, coordinationType = CacheCoordinationType.INVALIDATE_CHANGED_OBJECTS, size = 1000000)
@NamedQueries({
	@NamedQuery(name="findAllBazdid" , query="SELECT a FROM BazdidEntity a"),
	@NamedQuery(name="findByBazdidId" , query="SELECT u FROM BazdidEntity u WHERE u.bazdidId=:v_bazdidId"),
})
public class BazdidEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bazdid_id")
	private long bazdidId;
	
	private long bazdidNumber;

	public long getBazdidNumber() {
		return bazdidNumber;
	}

	public void setBazdidNumber(long bazdidNumber) {
		this.bazdidNumber = bazdidNumber;
	}
	
	

}
