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

import entity.NamayeshgahEntity;
import sevice.NamayeshgahServiceLocal;

/**
 * Session Bean implementation class CatchNamayeshgah
 */
@Singleton
@Startup
public class CatchNamayeshgah implements CatchNamayeshgahLocal {

    /**
     * Default constructor. 
     */
//    public CatchNamayeshgah() {
//        // TODO Auto-generated constructor stub
//    }
//    @Inject
//    private NamayeshgahServiceLocal namayeshgahServiceLocal;
//
//    private List<NamayeshgahEntity> namayeshgahEntities=new ArrayList<>();
//    @Override
//	public List<NamayeshgahEntity> getNamayeshgahEntities() {
//		return namayeshgahEntities;
//	}
//
//    @PostConstruct
//    public void init() {
//    	this.namayeshgahEntities.addAll(namayeshgahServiceLocal.findAllNamayeshgahEntity());
//    }
//    
//    
//	@Schedule(hour = "*", minute = "*/1", persistent = false)
//	@AccessTimeout(value = 4, unit = TimeUnit.SECONDS)
//	public void ejra() throws Exception {
//	    this.namayeshgahEntities.clear();
//		this.namayeshgahEntities.addAll(namayeshgahServiceLocal.findAllNamayeshgahEntity());
//	}
//	
//    
    
    
}
