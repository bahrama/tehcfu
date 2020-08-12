package panel;


import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.Part;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import entity.JobKarjoEntity;
import sevice.JobKarjoServiceLocal;



@Named
@RequestScoped
public class JobKarjoBean {

	public JobKarjoBean() {
		// TODO Auto-generated constructor stub
	}

	@Inject
	private JobKarjoServiceLocal jobKarjoServiceLocal;
	@Inject
	private TempBean tempBean;
	@Inject
	private FacesContext facesContext;
	@NotNull
	@NotEmpty
	@Size(max=100 , message="ماکزیمم ۱۰۰ کاراکتر")
	private String karjoField;
	@NotNull
	@NotEmpty
	@Size(max=100 , message="ماکزیمم ۱۰۰ کاراکتر")
	private String karjoMadrak;
	@NotNull
	@NotEmpty
	@Size(max=100 , message="ماکزیمم ۱۰۰ کاراکتر")
	private String karjoMaharat;
	private String karjoNoeFaal;
	@NotNull
	@NotEmpty
	@Size(max=500 , message="ماکزیمم ۵۰۰ کاراکتر")
	private String karjoDescription;
	private String karjoNoeHamkari;
	private Part karjoResume;
	private boolean show;
	@Size(max=100 , message="ماکزیمم ۱۰۰ کاراکتر")
	private String karjoTitle;

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

	public Part getKarjoResume() {
		return karjoResume;
	}

	public void setKarjoResume(Part karjoResume) {
		this.karjoResume = karjoResume;
	}

	public boolean isShow() {
		return show;
	}

	public void setShow(boolean show) {
		this.show = show;
	}

	public String getKarjoTitle() {
		return karjoTitle;
	}

	public void setKarjoTitle(String karjoTitle) {
		this.karjoTitle = karjoTitle;
	}

	public void insertToKarjoEntity(){
		JobKarjoEntity karjoEntity = new JobKarjoEntity();
		karjoEntity.setKarjoDescription(karjoDescription);
		karjoEntity.setKarjoField(karjoField);
		karjoEntity.setKarjoMadrak(karjoMadrak);
		karjoEntity.setKarjoMaharat(karjoMaharat);
		karjoEntity.setKarjoNoeFaal(karjoNoeFaal);
		karjoEntity.setKarjoNoeHamkari(karjoNoeHamkari);
		karjoEntity.setKarjoTitle(karjoTitle);
		karjoEntity.setDate(new Date());
		karjoEntity.setKarjo(tempBean.getMoblEntity());
		jobKarjoServiceLocal.insertToKarjoEntity(karjoEntity);
		facesContext.getPartialViewContext().getEvalScripts().add("swal({title: 'موفق!',type: 'success', text: 'آگهی شما با موفقیت ثبت گردید پس از بررسی در سایت قرار داده می شود', confirmButtonColor: '#469408',})");
	}

	public List<JobKarjoEntity> findAllKarjo() {
		return jobKarjoServiceLocal.findAllKarjo();
	}

	public JobKarjoEntity findKarjoById(long karjoId) {
		return jobKarjoServiceLocal.findKarjoById(karjoId);
	}

	public void deleteKarjo(long karjoId) throws IOException {
		JobKarjoEntity jobKarjoEntity = new JobKarjoEntity();
		jobKarjoEntity = jobKarjoServiceLocal.findKarjoById(karjoId);
		jobKarjoServiceLocal.deleteKarjo(jobKarjoEntity);
		FacesContext.getCurrentInstance().getExternalContext().redirect("karjoview.xhtml");
	}
	
	
	public void updateKarjo(long karjoId) throws IOException {
		JobKarjoEntity karjoEntity=new JobKarjoEntity();
		karjoEntity=jobKarjoServiceLocal.findKarjoById(karjoId);
		karjoEntity.setShow(show);
		jobKarjoServiceLocal.updateKarjo(karjoEntity);
		FacesContext.getCurrentInstance().getExternalContext()
		.redirect("karjoedit.xhtml" + "?karjoId=" + karjoId);
	}

}
