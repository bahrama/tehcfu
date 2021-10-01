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

import entity.HomeEntity;
import sevice.HomeServiceLocal;

/**
 * Session Bean implementation class CatchHome
 */
@Singleton
@Startup
public class CatchHome implements CatchHomeLocal {

//    /**
//     * Default constructor. 
//     */
//    public CatchHome() {
//        // TODO Auto-generated constructor stub
//    }
//    @Inject
//    private HomeServiceLocal homeServiceLocal;
//    
//    private List<HomeEntity> homeEntities=new ArrayList<>();
//
//
//    @Override
//    public List<HomeEntity> getHomeEntities() {
//		return homeEntities;
//	}
//
//
//
//	@PostConstruct
//    public void init() {
//    	this.homeEntities.addAll(homeServiceLocal.findAllHomeEntity());
//    }
//    
//    
//	@Schedule(hour = "*", minute = "*/1", persistent = false)
//	@AccessTimeout(value = 4, unit = TimeUnit.SECONDS)
//	public void ejra() throws Exception {
//		this.homeEntities.clear();
//		this.homeEntities.addAll(homeServiceLocal.findAllHomeEntity());
//	}
//    
//    
    

}
