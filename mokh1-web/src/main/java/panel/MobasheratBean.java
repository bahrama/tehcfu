package panel;

import java.util.Date;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import entity.MobasheratEntity;
import sevice.MobasheratServiceLocal;

@Named
@RequestScoped
public class MobasheratBean {

	public MobasheratBean() {
		// TODO Auto-generated constructor stub
	}
	@Inject
	private TempBean tempBean;
	@Inject
	private FacesContext facesContext;
	@Inject
	private MobasheratServiceLocal mobasheratServiceLocal; 
	@Size(max=50 , message="ماکزیمم ۵۰ کاراکتر")
	private String mobasherName;
	@Size(max=20 , message="ماکزیمم ۲۰ کاراکتر")
	private String namePedar;
	@Size(max=14 , message="ماکزیمم ۱۴ کاراکتر")
	private String shenasname;
	@Size(max=20 , message="ماکزیمم ۲۰ کاراکتر")
	private String sodor;
	@Size(max=50 , message="ماکزیمم ۵۰ کاراکتر")
	private String tarikhTavalod;
	@Size(max=50 , message="ماکزیمم ۵۰ کاراکتر")
	private String mahaleTavalod;
	@Size(max=14 , message="ماکزیمم ۱۴ کاراکتر")
	private String ssn;
	@Size(max=100 , message="ماکزیمم ۱۰۰ کاراکتر")
	private String pelakAbi;
	@Size(max=20 , message="ماکزیمم ۲۰ کاراکتر")
	private String mobile;
	@Size(max=20 , message="ماکزیمم ۲۰ کاراکتر")
	private String phone;
	@Size(max=100 , message="ماکزیمم ۱۰۰ کاراکتر")
	private String addres;
	public String getMobasherName() {
		return mobasherName;
	}
	public void setMobasherName(String mobasherName) {
		this.mobasherName = mobasherName;
	}

	public String getNamePedar() {
		return namePedar;
	}
	public void setNamePedar(String namePedar) {
		this.namePedar = namePedar;
	}
	public String getShenasname() {
		return shenasname;
	}
	public void setShenasname(String shenasname) {
		this.shenasname = shenasname;
	}
	public String getSodor() {
		return sodor;
	}
	public void setSodor(String sodor) {
		this.sodor = sodor;
	}
	public String getTarikhTavalod() {
		return tarikhTavalod;
	}
	public void setTarikhTavalod(String tarikhTavalod) {
		this.tarikhTavalod = tarikhTavalod;
	}
	public String getMahaleTavalod() {
		return mahaleTavalod;
	}
	public void setMahaleTavalod(String mahaleTavalod) {
		this.mahaleTavalod = mahaleTavalod;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public String getPelakAbi() {
		return pelakAbi;
	}
	public void setPelakAbi(String pelakAbi) {
		this.pelakAbi = pelakAbi;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddres() {
		return addres;
	}
	public void setAddres(String addres) {
		this.addres = addres;
	}
	
	public void insertToMobasherat() {
		MobasheratEntity mobasheratEntity=new MobasheratEntity();
		mobasheratEntity.setAddres(addres);
		mobasheratEntity.setDate(new Date());
		mobasheratEntity.setMahaleTavalod(mahaleTavalod);
		mobasheratEntity.setMobasherat(tempBean.getMoblEntity());
		mobasheratEntity.setMobasherName(mobasherName);
		mobasheratEntity.setMobile(mobile);
		mobasheratEntity.setNamePedar(namePedar);
		mobasheratEntity.setPelakAbi(pelakAbi);
		mobasheratEntity.setPhone(phone);
		mobasheratEntity.setShenasname(shenasname);
		mobasheratEntity.setSodor(sodor);
		mobasheratEntity.setSsn(ssn);
		mobasheratEntity.setTarikhTavalod(tarikhTavalod);
		mobasheratServiceLocal.insertToMobasherat(mobasheratEntity);
		facesContext.getPartialViewContext().getEvalScripts().add("swal({title: 'موفق!',type: 'success', text: 'درخواست شما با موفقیت ثبت گردید', confirmButtonColor: '#469408',})");
	}

}
