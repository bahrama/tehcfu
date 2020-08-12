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

import entity.JobKarfarmaEntity;
import sevice.JobKarfarmaServiceLocal;



@Named
@RequestScoped
public class JobKarfarmaBean {

	public JobKarfarmaBean() {
		// TODO Auto-generated constructor stub
	}
	@Inject
	private JobKarfarmaServiceLocal jobKarfarmaServiceLocal;
	@Inject
	private TempBean tempBean;
	@Inject
	private FacesContext facesContext;
	@NotNull
	@NotEmpty
	@Size(max=100 , message="ماکزیمم ۱۰۰ کاراکتر")
	private String karfarmaNiroMorede;
	private String karfarmaNoeDarkhast;

	private String karfarmaTakhasosMorede;
	@NotNull
	@NotEmpty
	@Size(max=500 , message="ماکزیمم ۵۰۰ کاراکتر")
	private String karfarmaDescription;
	private boolean taeed;
	@NotNull
	@NotEmpty
	@Size(max=30 , message="ماکزیمم ۳۰ کاراکتر")
	private String mizanHogog;
	@NotNull
	@NotEmpty
	@Size(max=200 , message="ماکزیمم ۲۰۰ کاراکتر")
	private String karfarmaJobTitle;
	
	
	
	public String getKarfarmaNiroMorede() {
		return karfarmaNiroMorede;
	}
	public void setKarfarmaNiroMorede(String karfarmaNiroMorede) {
		this.karfarmaNiroMorede = karfarmaNiroMorede;
	}
	public String getKarfarmaNoeDarkhast() {
		return karfarmaNoeDarkhast;
	}
	public void setKarfarmaNoeDarkhast(String karfarmaNoeDarkhast) {
		this.karfarmaNoeDarkhast = karfarmaNoeDarkhast;
	}
	public String getKarfarmaTakhasosMorede() {
		return karfarmaTakhasosMorede;
	}
	public void setKarfarmaTakhasosMorede(String karfarmaTakhasosMorede) {
		this.karfarmaTakhasosMorede = karfarmaTakhasosMorede;
	}
	public String getKarfarmaDescription() {
		return karfarmaDescription;
	}
	public void setKarfarmaDescription(String karfarmaDescription) {
		this.karfarmaDescription = karfarmaDescription;
	}
	public boolean isTaeed() {
		return taeed;
	}
	public void setTaeed(boolean taeed) {
		this.taeed = taeed;
	}

	

	public String getKarfarmaJobTitle() {
		return karfarmaJobTitle;
	}
	public void setKarfarmaJobTitle(String karfarmaJobTitle) {
		this.karfarmaJobTitle = karfarmaJobTitle;
	}
	public String getMizanHogog() {
		return mizanHogog;
	}
	public void setMizanHogog(String mizanHogog) {
		this.mizanHogog = mizanHogog;
	}
	public void insertToKarfarma() throws IOException {
		JobKarfarmaEntity jobKarfarmaEntity=new JobKarfarmaEntity();
		jobKarfarmaEntity.setKarfarmaDescription(karfarmaDescription);
		jobKarfarmaEntity.setKarfarmaNiroMorede(karfarmaNiroMorede);
		jobKarfarmaEntity.setKarfarmaNoeDarkhast(karfarmaNoeDarkhast);
		jobKarfarmaEntity.setTaeed(false);
		jobKarfarmaEntity.setMizanHogog(mizanHogog);
		jobKarfarmaEntity.setDate(new Date());
		jobKarfarmaEntity.setKarfarmaJobTitle(karfarmaJobTitle);
		jobKarfarmaEntity.setKarfarma(tempBean.getMoblEntity());
		jobKarfarmaServiceLocal.insertToKarfarmaEntity(jobKarfarmaEntity);
		facesContext.getPartialViewContext().getEvalScripts().add("swal({title: 'موفق!',type: 'success', text: 'آگهی شما با موفقیت ثبت گردید پس از بررسی در سایت قرار داده می شود', confirmButtonColor: '#469408',})");
//		this.setKarafarmaAddress("");
//		this.setKarfarmaDescription("");
//		this.setKarfarmaJobCity("");
//		this.setKarfarmaJobTitle("");
//		this.setKarfarmaNiroMorede("");
//		this.setKarfarmaNoeDarkhast("");
//		this.setKarfarmaPasokhName("");
//		this.setKarfarmaTakhasosMorede("");
//		this.setKarfarmaPasokhSemat("");
//		this.setMizanHogog("");
	}
	
    
	public List<JobKarfarmaEntity> findAllKarfarma(){
		return jobKarfarmaServiceLocal.findAllKarfarma();
	}
	
	public JobKarfarmaEntity findKarfarmaById(long jobId) {
		return jobKarfarmaServiceLocal.findKarfarmaById(jobId);
	}
	
    public void updateKarfarma(long jobId) throws IOException {
    	FacesContext context = FacesContext.getCurrentInstance();
    	JobKarfarmaEntity jobKarfarmaEntity=new JobKarfarmaEntity();
    	jobKarfarmaEntity=jobKarfarmaServiceLocal.findKarfarmaById(jobId);
    	jobKarfarmaEntity.setTaeed(taeed);
    	jobKarfarmaServiceLocal.updateKarfarma(jobKarfarmaEntity);
		FacesContext.getCurrentInstance().getExternalContext()
		.redirect("karfarmaedit.xhtml" + "?karfarma=" + jobId);
    }
    
  
    public void deleteKarfarma(long karafarmaId) throws IOException{
    	JobKarfarmaEntity jobKarfarmaEntity=new JobKarfarmaEntity();
    	jobKarfarmaEntity=jobKarfarmaServiceLocal.findKarfarmaById(karafarmaId);
    	jobKarfarmaServiceLocal.deleteKarfarma(jobKarfarmaEntity);
    	FacesContext.getCurrentInstance().getExternalContext().redirect("karfarmaview.xhtml");
    }
	
}
