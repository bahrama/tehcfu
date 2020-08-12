package panel;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.Part;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import entity.MoblEntity;
import enums.UserRole;
import sevice.SellerServiceLocal;

@Named
@RequestScoped
public class Profile {

	public Profile() {
		// TODO Auto-generated constructor stub
	}
	@Inject
	private TempBean tempBean;
	@Inject
	private FacesContext facesContext;
	@Inject
	private SellerServiceLocal sellerServiceLocal;
	@NotNull(message="فیلد نباید خالی باشد")
	@Size(max=30,message="حداکثر ۳۰")
	private String email;
	@NotNull(message="فیلد نباید خالی باشد")
	@NotEmpty(message="فیلد نباید خالی باشد")
	@Size(max=30,min=8,message="حداقل ۸ و حداکثر ۳۰")
	private String phone;
	@NotNull(message="فیلد نباید خالی باشد")
	@NotEmpty(message="فیلد نباید خالی باشد")
	@Size(max=200,min=3,message="حداقل ۳ و حداکثر ۲۰۰")
	private String userAddres;
	@NotNull(message="فیلد نباید خالی باشد")
	@NotEmpty(message="فیلد نباید خالی باشد")
	@Size(max=100,min=3,message="حداقل ۳ و حداکثر ۱۰۰")
	private String userName;
	@NotNull(message="فیلد نباید خالی باشد")
	@NotEmpty(message="فیلد نباید خالی باشد")
	private Part pic1;
	@Size(max=10 , message="max size is 10")
	@NotNull
	@NotEmpty
	private String ssn;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getUserAddres() {
		return userAddres;
	}
	public void setUserAddres(String userAddres) {
		this.userAddres = userAddres;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Part getPic1() {
		return pic1;
	}
	public void setPic1(Part pic1) {
		this.pic1 = pic1;
	}
	
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public void updateUser() {
		MoblEntity moblEntity=tempBean.getMoblEntity();
		moblEntity.setSellerName(userName);
		moblEntity.setSellerAddres(userAddres);
		moblEntity.setPhone(phone);
		moblEntity.setEmail(email);
		moblEntity.setSsn(ssn);
		moblEntity.setRole(UserRole.USER);
		try {
			sellerServiceLocal.updateSeller(moblEntity);
			//facesContext.getPartialViewContext().getEvalScripts().add("swal({title: 'موفق!',type: 'success', text: 'پروفایل آپدیت شد', confirmButtonColor: '#469408',})");
		   // Thread.sleep(8000);	
		    FacesContext.getCurrentInstance().getExternalContext().redirect("/pages/panel_seller/profile.xhtml");
		} catch (Exception e) {
			System.err.println("update error");
		}
	}
	


}
