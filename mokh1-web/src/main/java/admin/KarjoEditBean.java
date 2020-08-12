package admin;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import entity.JobKarjoEntity;
import sevice.JobKarjoServiceLocal;

@Named
@SessionScoped
public class KarjoEditBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public KarjoEditBean() {
		// TODO Auto-generated constructor stub
	}
	@Inject
	private JobKarjoServiceLocal jobKarjoServiceLocal;
	
	private JobKarjoEntity jobKarjoEntity;
	
	private boolean checkKarjo;
	
	
	public JobKarjoEntity getJobKarjoEntity() {
		return jobKarjoEntity;
	}




	public void setJobKarjoEntity(JobKarjoEntity jobKarjoEntity) {
		this.jobKarjoEntity = jobKarjoEntity;
	}




	public boolean isCheckKarjo() {
		return checkKarjo;
	}




	public void setCheckKarjo(boolean checkKarjo) {
		this.checkKarjo = checkKarjo;
	}




	public List<JobKarjoEntity> findAllKarjo(){
		return jobKarjoServiceLocal.findAllKarjo();
	}
	
	public void karjoUpdate() {
		System.err.println("OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");
		JobKarjoEntity karjoEntity=jobKarjoEntity;
	    System.err.println(karjoEntity.getKarjoDescription());
		karjoEntity.setShow(checkKarjo);
	    jobKarjoServiceLocal.updateKarjo(karjoEntity);
	}

}
