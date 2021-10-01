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

import entity.JobKarfarmaEntity;
import entity.JobKarjoEntity;
import sevice.JobKarfarmaServiceLocal;

/**
 * Session Bean implementation class CatchKarfarma
 */
@Singleton
@Startup
public class CatchKarfarma implements CatchKarfarmaLocal {

    /**
     * Default constructor. 
     */
//    public CatchKarfarma() {
//        // TODO Auto-generated constructor stub
//    }
//    @Inject
//    private JobKarfarmaServiceLocal jobKarfarmaServiceLocal;
//    
//    private List<JobKarfarmaEntity> karfarmas=new ArrayList<JobKarfarmaEntity>();
//    @Override
//	public List<JobKarfarmaEntity> getKarfarmas() {
//		return karfarmas;
//	}
//
//    
//	@PostConstruct
//    public void init() {
//    	for (JobKarfarmaEntity jobKarfarmaEntity:jobKarfarmaServiceLocal.findAllKarfarma()) {
//			if(jobKarfarmaEntity.isTaeed()==true)
//                this.karfarmas.add(jobKarfarmaEntity);
//    	}
//    	
//    }
//    
//    
//	@Schedule(hour = "*", minute = "*/1", persistent = false)
//	@AccessTimeout(value = 4, unit = TimeUnit.SECONDS)
//	public void ejra(){
//		this.karfarmas.clear();
//    	for (JobKarfarmaEntity jobKarfarmaEntity:jobKarfarmaServiceLocal.findAllKarfarma()) {
//			if(jobKarfarmaEntity.isTaeed()==true)
//                this.karfarmas.add(jobKarfarmaEntity);
//    	}
//	}
//    

}
