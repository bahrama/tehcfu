package entity;

import java.io.Serializable;

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
import javax.persistence.UniqueConstraint;

import org.eclipse.persistence.annotations.Cache;
import org.eclipse.persistence.annotations.CacheCoordinationType;
import org.eclipse.persistence.annotations.CacheType;
@Entity
@Table(name="product_tbl", uniqueConstraints= {
		@UniqueConstraint(columnNames= {"user_product" , "name" , "old_new"}),
})
@Cache(type = CacheType.SOFT, coordinationType = CacheCoordinationType.INVALIDATE_CHANGED_OBJECTS, size = 1000000)
@NamedQueries({
	@NamedQuery(name="findAllProductEntity" , query="SELECT a FROM ProductEntity a ORDER BY a.productId DESC"),
	@NamedQuery(name="findByProductEntityId" , query="SELECT u FROM ProductEntity u WHERE u.productId=:v_productId"),
	@NamedQuery(name="findAllProductEntityById2" , query="SELECT pp FROM ProductEntity pp ORDER BY pp.productId DESC"),
	@NamedQuery(name="findAllProductEntityBySeller" , query="SELECT pp FROM ProductEntity pp WHERE pp.product=:v_product ORDER BY pp.productId DESC"),
})
public class ProductEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private long productId;
	@Column(name = "name", length = 100, nullable = true)
	private String name;
	@Column(name = "contry", length = 100, nullable = true)
	private String contry;
	@Column(name = "raste", length = 100, nullable = true)
	private String raste;
	@Column(name = "vahedeSenfiName", length = 3000, nullable = true)
	private String description;
	@Column(name = "pic1", length = 100 , nullable = true)
	private String pic1;
	@Column(name = "pic2", length = 100 , nullable = true)
	private String pic2;
	@Column(name = "pic3", length = 100 , nullable = true)
	private String pic3;
	@Column(name = "pic4", length = 100 , nullable = true)
	private String pic4;
	@Column(name = "pic5", length = 100 , nullable = true)
	private String pic5;
	
	private long price;
	
	private long price2;
	@Column(name = "old_new", length = 10)
	private String oldNew;
	
	@Column(name = "checkO", nullable = true)
	private boolean checkO;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_product")
	private MoblEntity product;

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContry() {
		return contry;
	}

	public void setContry(String contry) {
		this.contry = contry;
	}

	public String getRaste() {
		return raste;
	}

	public void setRaste(String raste) {
		this.raste = raste;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPic1() {
		return pic1;
	}

	public void setPic1(String pic1) {
		this.pic1 = pic1;
	}

	public String getPic2() {
		return pic2;
	}

	public void setPic2(String pic2) {
		this.pic2 = pic2;
	}

	public String getPic3() {
		return pic3;
	}

	public void setPic3(String pic3) {
		this.pic3 = pic3;
	}

	public String getPic4() {
		return pic4;
	}

	public void setPic4(String pic4) {
		this.pic4 = pic4;
	}

	public String getPic5() {
		return pic5;
	}

	public void setPic5(String pic5) {
		this.pic5 = pic5;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public boolean isCheckO() {
		return checkO;
	}

	public void setCheckO(boolean checkO) {
		this.checkO = checkO;
	}

	public long getPrice2() {
		return price2;
	}

	public void setPrice2(long price2) {
		this.price2 = price2;
	}



	public String getOldNew() {
		return oldNew;
	}

	public void setOldNew(String oldNew) {
		this.oldNew = oldNew;
	}

	public MoblEntity getProduct() {
		return product;
	}

	public void setProduct(MoblEntity product) {
		this.product = product;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof ProductEntity))
			return false;
		ProductEntity productEntity = (ProductEntity) obj;
		return ((productEntity.productId == this.productId) 
				|| (productEntity.product.equals(this.product)));
	}


}
