//package admin;
//
//import java.io.Serializable;
//import java.util.List;
//
//import javax.enterprise.context.SessionScoped;
//import javax.inject.Inject;
//import javax.inject.Named;
//
//import entity.JobKarfarmaEntity;
//import sevice.JobKarfarmaServiceLocal;
//
//@Named
//@SessionScoped
//public class EditKarfarmaBean implements Serializable {
//
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 1L;
//
//	public EditKarfarmaBean() {
//		// TODO Auto-generated constructor stub
//	}
//	@Inject
//	private JobKarfarmaServiceLocal jobKarfarmaServiceLocal;
//	
//	private JobKarfarmaEntity jobKarfarmaEntity;
//	
//	private boolean checkKarfarma;
//
//	public JobKarfarmaEntity getJobKarfarmaEntity() {
//		return jobKarfarmaEntity;
//	}
//
//	public void setJobKarfarmaEntity(JobKarfarmaEntity jobKarfarmaEntity) {
//		this.jobKarfarmaEntity = jobKarfarmaEntity;
//	}
//
//	public boolean isCheckKarfarma() {
//		return checkKarfarma;
//	}
//
//	public void setCheckKarfarma(boolean checkKarfarma) {
//		this.checkKarfarma = checkKarfarma;
//	}
//	
//	public List<JobKarfarmaEntity> findAllKarfarma(){
//		return jobKarfarmaServiceLocal.findAllKarfarma();
//	}
//	
//	public void updateKarfarma() {
//		JobKarfarmaEntity jobKarfarmaEntity=this.jobKarfarmaEntity;
//		jobKarfarmaEntity.setTaeed(checkKarfarma);
//		jobKarfarmaServiceLocal.updateKarfarma(jobKarfarmaEntity);
//	}
//	
//
//}
