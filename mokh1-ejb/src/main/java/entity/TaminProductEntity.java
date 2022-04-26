package entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Table(name="TaminProduct")
@NamedQueries({
@NamedQuery(name="TaminProductEntity.findAll", query="SELECT m FROM TaminProductEntity m ORDER BY m.id DESC"),
@NamedQuery(name = "TaminProductEntity.findById", query = "SELECT i FROM TaminProductEntity i WHERE i.id=:v_id"),
@NamedQuery(name = "TaminProductEntity.findByRaste", query = "SELECT i FROM TaminProductEntity i WHERE i.name1=:v_name1"),
})
@Cacheable(value = false)
public class TaminProductEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name = "raste", length = 500 , nullable = true)
	private String raste;
	@Column(name = "name1", length = 500 , nullable = true)
	private String name1;
	@Column(name = "name2", length = 500 , nullable = true)
	private String name2;
	@Column(name = "name3", length = 500 , nullable = true)
	private String name3;
	@Column(name = "name4", length = 500 , nullable = true)
	private String name4;
	@Column(name = "specification", length = 100 , nullable = true)
	private String specification;
	@Column(name = "description", length = 100 , nullable = true)
	private String description;
	@Column(name = "price" , nullable = true)
	private long price;
	@Temporal(TemporalType.DATE)
	@Column(name="date",nullable=true)
	private Date date;
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
	@Column(name="check1",nullable=true)
	private boolean check1;
	@Column(name="check2",nullable=true)
	private boolean check2;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRaste() {
		return raste;
	}
	public void setRaste(String raste) {
		this.raste = raste;
	}
	public String getName1() {
		return name1;
	}
	public void setName1(String name1) {
		this.name1 = name1;
	}
	public String getName2() {
		return name2;
	}
	public void setName2(String name2) {
		this.name2 = name2;
	}
	public String getName3() {
		return name3;
	}
	public void setName3(String name3) {
		this.name3 = name3;
	}
	public String getName4() {
		return name4;
	}
	public void setName4(String name4) {
		this.name4 = name4;
	}
	public String getSpecification() {
		return specification;
	}
	public void setSpecification(String specification) {
		this.specification = specification;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
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
	public boolean isCheck1() {
		return check1;
	}
	public void setCheck1(boolean check1) {
		this.check1 = check1;
	}
	public boolean isCheck2() {
		return check2;
	}
	public void setCheck2(boolean check2) {
		this.check2 = check2;
	}
	
	
	

}
