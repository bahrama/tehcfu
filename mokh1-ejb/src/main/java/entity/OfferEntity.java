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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Table(name="offer_tbl")
@NamedQueries({
@NamedQuery(name="OfferEntity.findAll", query="SELECT m FROM OfferEntity m ORDER BY m.id ASC"),
@NamedQuery(name = "OfferEntity.findByToken", query = "SELECT DISTINCT i.userTokeLoguot FROM OfferEntity i WHERE i.userTokeLoguot=:v_userTokeLoguot"),
@NamedQuery(name = "OfferEntity.findAllByToken", query = "SELECT i FROM OfferEntity i WHERE (i.userTokeLoguot=:v_userTokeLoguot) and (i.offerProduct=:v_offerProduct)"),
@NamedQuery(name = "OfferEntity.findAllByProduct", query = "SELECT i FROM OfferEntity i WHERE i.offerProduct=:v_offerProduct"),
@NamedQuery(name = "OfferEntity.findAllByMerchant", query = "SELECT i FROM OfferEntity i WHERE i.offerMerchantPage=:v_offerMerchantPage ORDER BY i.id DESC"),
})
@Cacheable(value = false)
public class OfferEntity  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="view_Date",nullable=true)
	private Date viewDate;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "merchant_offer")
	private MoblEntity offerMerchantPage;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "product_offer")
	private ProductEntity offerProduct;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_offer")
	private MoblEntity offerUser;
	
	
	@Column(name="userToke_Loguot",nullable=true , length = 100)
	private String userTokeLoguot;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Date getViewDate() {
		return viewDate;
	}


	public void setViewDate(Date viewDate) {
		this.viewDate = viewDate;
	}


	public MoblEntity getOfferMerchantPage() {
		return offerMerchantPage;
	}


	public void setOfferMerchantPage(MoblEntity offerMerchantPage) {
		this.offerMerchantPage = offerMerchantPage;
	}


	public ProductEntity getOfferProduct() {
		return offerProduct;
	}


	public void setOfferProduct(ProductEntity offerProduct) {
		this.offerProduct = offerProduct;
	}


	public String getUserTokeLoguot() {
		return userTokeLoguot;
	}


	public void setUserTokeLoguot(String userTokeLoguot) {
		this.userTokeLoguot = userTokeLoguot;
	}


	public MoblEntity getOfferUser() {
		return offerUser;
	}


	public void setOfferUser(MoblEntity offerUser) {
		this.offerUser = offerUser;
	}
	
	
	
	
	

}
