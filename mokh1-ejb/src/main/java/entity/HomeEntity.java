package entity;

import java.io.Serializable;
import javax.persistence.*;

import org.eclipse.persistence.annotations.Cache;
import org.eclipse.persistence.annotations.CacheCoordinationType;
import org.eclipse.persistence.annotations.CacheType;


/**
 * The persistent class for the home_tbl database table.
 * 
 */
@Entity
@Table(name="home_tbl")
@NamedQueries({
	@NamedQuery(name="HomeTbl.findAll", query="SELECT h FROM HomeEntity h ORDER BY h.id DESC"),
	@NamedQuery(name = "HomeTbl.findById", query = "SELECT i FROM HomeEntity i WHERE i.id=:v_id"),
	@NamedQuery(name = "HomeTbl.findByName", query = "SELECT i FROM HomeEntity i WHERE i.name=:v_name ORDER BY i.id DESC")
})
@Cacheable(value = false)
public class HomeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	@Column(name="name" , length=2)
	private String name;

	@Column(name="pic_id")
	private String picId;

	public HomeEntity() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		switch (this.name) {
		case "A":
         return "اتحادیه صنف درودگران و مبلسازان تهران";
		case "B":
	         return "لوگو";
		case "C":
	         return "اسلاید";
		case "D":
	         return "نزدیکترین ها";
		case "F":
	         return "اعضای صنفی اتحادیه";
		case "G":
	         return "نیازمندی ها";
		case "H":
	         return "تبلیغ";
		case "I":
	         return "طرح های خلاقانه";
		case "E":
	         return "خبرنامه نمایشگاهی";
		case "J":
	         return "دانستنی ها";
		case "M":
	         return "قوانین حقوقی";
		case "N":
	         return "قوانین مالیاتی";
		case "P":
	         return "قوانین تامین اجتماعی";
		case "O":
	         return "درباره دکوراسیون";
		case "U":
	         return "آموزش";
		case "T":
	         return "قانون نظام صنفی";
		case "R":
	         return "شمسی";
		case "Z":
	         return "قمری";
		case "X":
	         return "میلادی";
		case "Q":
		     return "یافته های جهانی";

		default:
			return null;
		}
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPicId() {
		return this.picId;
	}

	public void setPicId(String picId) {
		this.picId = picId;
	}

}