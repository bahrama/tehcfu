package catch_db;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;
import javax.ejb.AccessTimeout;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

import entity.CreativeEntity;
import sevice.CreativeServiceLocal;

/**
 * Session Bean implementation class CatchCreative
 */
@Singleton
@Startup
public class CatchCreative implements CatchCreativeLocal {

    /**
     * Default constructor. 
     */
//    public CatchCreative() {
//        // TODO Auto-generated constructor stub
//    }
//    @Inject
//    private CreativeServiceLocal creativeServiceLocal;
//    
//    private List<CreativeEntity> creativeEntities=new ArrayList<>();
//
//    @Override
//	public List<CreativeEntity> getCreativeEntities() {
//		return creativeEntities;
//	}
//    @PostConstruct
//    public void init() {
//    	this.creativeEntities.addAll(creativeServiceLocal.findAllCreativeEntity());
//    	Collections.reverse(this.creativeEntities);
//    }
//    
//    
//	@Schedule(hour = "*", minute = "*/1", persistent = false)
//	@AccessTimeout(value = 4, unit = TimeUnit.SECONDS)
//	public void ejra() throws Exception {
//	    this.creativeEntities.clear();
//		this.creativeEntities.addAll(creativeServiceLocal.findAllCreativeEntity());
//		Collections.reverse(this.creativeEntities);
//	}
	
    
    
    

}
