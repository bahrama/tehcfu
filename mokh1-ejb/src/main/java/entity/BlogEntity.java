package entity;

import java.io.Serializable;
import javax.persistence.*;

import org.eclipse.persistence.annotations.Cache;
import org.eclipse.persistence.annotations.CacheCoordinationType;
import org.eclipse.persistence.annotations.CacheType;

import java.util.Date;
import java.util.UUID;


/**
 * The persistent class for the blog_tbl database table.
 * 
 */
@Entity
@Table(name="blog_tbl")
@Cache(type = CacheType.SOFT, coordinationType = CacheCoordinationType.INVALIDATE_CHANGED_OBJECTS, size = 1000000)
@NamedQueries({
@NamedQuery(name="BlogEntity.findAll", query="SELECT b FROM BlogEntity b ORDER BY b.id DESC"),
@NamedQuery(name = "BlogEntity.findById", query = "SELECT i FROM BlogEntity i WHERE i.id=:v_id"),
})
public class BlogEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Temporal(TemporalType.DATE)
	@Column(name="blog_date")
	private Date blogDate;

	@Column(name="blog_head" , length=100)
	private String blogHead;

	@Column(name="blog_main" , length=100)
	private String blogMain;

	@Column(name="blog_name" , length=200)
	private String blogName;

	@Column(name="blog_type" , length=2)
	private String blogType;

	private Boolean important;
	@Column(name="pic1" , length=100)
	private String pic1;

	public BlogEntity() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getBlogDate() {
		return this.blogDate;
	}

	public void setBlogDate(Date blogDate) {
		this.blogDate = blogDate;
	}

	public String getBlogHead() {
		return this.blogHead;
	}

	public void setBlogHead(String blogHead) {
		this.blogHead = blogHead;
	}

	public String getBlogMain() {
		return this.blogMain;
	}

	public void setBlogMain(String blogMain) {
		this.blogMain = blogMain;
	}

	public String getBlogName() {
		return this.blogName;
	}

	public void setBlogName(String blogName) {
		this.blogName = blogName;
	}

	public String getBlogType() {
		//return this.blogType;
		switch (this.blogType) {
		case "A":
			return "مجتمع تجاری";
        case "B":
        	return "خبر";
        case "C":
        	return "مناسبت شمسی";
        case "D":
        	return "مناسبت قمری";
        case "F":
        	return "قوانین حقوقی";
        case "G":
        	return "قوانین مالیاتی";
        case "H":
        	return "قوانین تامین اجتماعی";
        case "I":
        	return "درباره دکوراسیون";
        case "J":
        	return "آموزش";
        case "E":
        	return "مناسبت میلادی";
		default:
			return null;
		}
	}

	public void setBlogType(String blogType) {
		this.blogType = blogType;
	}

	public Boolean getImportant() {
		return this.important;
	}

	public void setImportant(Boolean important) {
		this.important = important;
	}

	public String getPic1() {
		return pic1;
	}

	public void setPic1(String pic1) {
		this.pic1 = pic1;
	}

//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((blogDate == null) ? 0 : blogDate.hashCode());
//		result = prime * result + ((blogHead == null) ? 0 : blogHead.hashCode());
//		result = prime * result + ((blogMain == null) ? 0 : blogMain.hashCode());
//		result = prime * result + ((blogName == null) ? 0 : blogName.hashCode());
//		result = prime * result + ((blogType == null) ? 0 : blogType.hashCode());
//		result = prime * result + ((id == null) ? 0 : id.hashCode());
//		result = prime * result + ((important == null) ? 0 : important.hashCode());
//		result = prime * result + ((pic1 == null) ? 0 : pic1.hashCode());
//		return result;
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (!(obj instanceof BlogEntity))
//			return false;
//		BlogEntity blogEntity=(BlogEntity) obj;
//		return ((blogEntity.id==this.id));
//	}
//	
	

}