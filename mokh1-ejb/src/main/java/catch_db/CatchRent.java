package catch_db;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;
import javax.ejb.AccessTimeout;
import javax.ejb.Schedule;
import javax.ejb.Startup;
import javax.ejb.Stateless;
import javax.inject.Inject;

import entity.JobKarfarmaEntity;
import entity.RentEntity;
import sevice.RentServiceLocal;

/**
 * Session Bean implementation class CatchRent
 */
@Stateless
@Startup
public class CatchRent implements CatchRentLocal {

    /**
     * Default constructor. 
     */
    public CatchRent() {
        // TODO Auto-generated constructor stub
    }
    @Inject
    private RentServiceLocal rentServiceLocal;
    
    private List<RentEntity> rents=new ArrayList<RentEntity>();
    
    
    @Override
    public List<RentEntity> getRents() {
		return rents;
	}


	@PostConstruct
    public void init() {
    	for (RentEntity rentEntity:rentServiceLocal.findAllRent()) {
			if(rentEntity.isShow()==true)
                this.rents.add(rentEntity);
    	}
    	
    }
    
    
	@Schedule(hour = "*", minute = "*/1", persistent = false)
	@AccessTimeout(value = 4, unit = TimeUnit.SECONDS)
	public void ejra(){
		this.rents.clear();
    	for (RentEntity rentEntity:rentServiceLocal.findAllRent()) {
			if(rentEntity.isShow()==true)
                this.rents.add(rentEntity);
    	}
	}
    
    
    

}
