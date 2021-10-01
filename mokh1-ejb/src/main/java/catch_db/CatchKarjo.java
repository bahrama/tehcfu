package catch_db;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;
import javax.ejb.AccessTimeout;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

import entity.Amade;
import entity.JobKarjoEntity;
import enums.AmadeType;
import sevice.JobKarjoServiceLocal;

/**
 * Session Bean implementation class CatchKarjo
 */
@Singleton
@Startup
public class CatchKarjo implements CatchKarjoLocal {

    /**
     * Default constructor. 
     */
//    public CatchKarjo() {
//        // TODO Auto-generated constructor stub
//    }
//    @Inject
//    private JobKarjoServiceLocal jobKarjoServiceLocal;
//    
//    private List<JobKarjoEntity> karjos=new ArrayList<JobKarjoEntity>();
//
//    @Override
//	public List<JobKarjoEntity> getKarjos() {
//		return karjos;
//	}
//
//	@PostConstruct
//    public void init() {
//    	for (JobKarjoEntity jobKarjoEntity:jobKarjoServiceLocal.findAllKarjo()) {
//			if(jobKarjoEntity.isShow()==true)
//                this.karjos.add(jobKarjoEntity);
//    	}
//    	
//    }
//    
//    
//	@Schedule(hour = "*", minute = "*/1", persistent = false)
//	@AccessTimeout(value = 4, unit = TimeUnit.SECONDS)
//	public void ejra(){
//		this.karjos.clear();
//    	for (JobKarjoEntity jobKarjoEntity:jobKarjoServiceLocal.findAllKarjo()) {
//			if(jobKarjoEntity.isShow()==true)
//                this.karjos.add(jobKarjoEntity);
//    	}
//	}
    

}
