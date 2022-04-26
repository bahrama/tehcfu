package entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Table(name="Sefaresh_tbl")
@NamedQueries({
@NamedQuery(name="SefareshEntity.findAll", query="SELECT b FROM SefareshEntity b ORDER BY b.sefareshId DESC"),
@NamedQuery(name = "SefareshEntity.findById", query = "SELECT i FROM SefareshEntity i WHERE i.sefareshId=:v_sefareshId"),
@NamedQuery(name="findAllSefareshByUser" , query="SELECT pp FROM SefareshEntity pp WHERE (pp.sefareshUser=:v_sefareshUser) AND (pp.isDeleted=:v_isdel) AND (pp.acceptUserSefaresh=:v_acceptUserSefaresh)  ORDER BY pp.sefareshId DESC"),
@NamedQuery(name="findAllSefareshByMerchant" , query="SELECT pp FROM SefareshEntity pp WHERE (pp.sefareshMerchant=:v_sefareshMerchant) AND (pp.isDeleted=:v_isdel) AND (pp.acceptUserSefaresh=:v_acceptUserSefaresh)  ORDER BY pp.sefareshId DESC"),
@NamedQuery(name="findCountAllSefareshByMerchant" , query="SELECT pp FROM SefareshEntity pp WHERE (pp.sefareshMerchant=:v_sefareshMerchant) AND (pp.isDeleted=:v_isdel) AND (pp.acceptUserSefaresh=:v_acceptUserSefaresh) AND (pp.acceptSefaresh=:v_acceptSefaresh)  ORDER BY pp.sefareshId DESC"),
@NamedQuery(name="findAllSefareshByProduct" , query="SELECT pp FROM SefareshEntity pp WHERE (pp.sefareshProduct=:v_sefareshProduct) AND (pp.isDeleted=:v_isdel)  ORDER BY pp.sefareshId DESC")
})
@Cacheable(value = false)
public class SefareshEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name = "efaresh_seq", sequenceName = "efaresh_seq" , allocationSize = 100)
	private long sefareshId;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_sefaresh")
	private MoblEntity sefareshUser;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "merchant_sefaresh")
	private MoblEntity sefareshMerchant;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "sefaresh_product")
	private ProductEntity sefareshProduct;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="sDate",nullable=true)
	private Date submitDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="vDate",nullable=true)
	private Date viewDate;
	@Column(name="isDeleted")
	private boolean isDeleted;
	
	
	@Column(name="accept_sefaresh",nullable=true)
	private boolean acceptSefaresh;
	
	@Column(name="accept_user_sefaresh",nullable=true)
	private boolean acceptUserSefaresh;
	
	

	public long getSefareshId() {
		return sefareshId;
	}

	public void setSefareshId(long sefareshId) {
		this.sefareshId = sefareshId;
	}

	public MoblEntity getSefareshUser() {
		return sefareshUser;
	}

	public void setSefareshUser(MoblEntity sefareshUser) {
		this.sefareshUser = sefareshUser;
	}

	public ProductEntity getSefareshProduct() {
		return sefareshProduct;
	}

	public void setSefareshProduct(ProductEntity sefareshProduct) {
		this.sefareshProduct = sefareshProduct;
	}

	public Date getSubmitDate() {
		return submitDate;
	}

	public void setSubmitDate(Date submitDate) {
		this.submitDate = submitDate;
	}

	public Date getViewDate() {
		return viewDate;
	}

	public void setViewDate(Date viewDate) {
		this.viewDate = viewDate;
	}

	public boolean isAcceptSefaresh() {
		return acceptSefaresh;
	}

	public void setAcceptSefaresh(boolean acceptSefaresh) {
		this.acceptSefaresh = acceptSefaresh;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public MoblEntity getSefareshMerchant() {
		return sefareshMerchant;
	}

	public void setSefareshMerchant(MoblEntity sefareshMerchant) {
		this.sefareshMerchant = sefareshMerchant;
	}

	public boolean isAcceptUserSefaresh() {
		return acceptUserSefaresh;
	}

	public void setAcceptUserSefaresh(boolean acceptUserSefaresh) {
		this.acceptUserSefaresh = acceptUserSefaresh;
	}
	
	
}
