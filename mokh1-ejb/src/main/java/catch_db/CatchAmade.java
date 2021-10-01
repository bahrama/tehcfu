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
import enums.AmadeType;
import sevice.AmadeServiceLocal;

/**
 * Session Bean implementation class CatchAmade
 */
@Singleton
@Startup
public class CatchAmade implements CatchAmadeLocal {

    /**
     * Default constructor. 
     */
//    public CatchAmade() {
//        // TODO Auto-generated constructor stub
//    }
//    @Inject
//    private AmadeServiceLocal amadeServiceLocal;
//    
//    private List<Amade> amadePano=new ArrayList<Amade>();
//    private List<Amade> amadeUnion=new ArrayList<Amade>();
//    private List<Amade> amadeMobasherat=new ArrayList<Amade>();
//    @Override
//	public List<Amade> getAmadePano() {
//		return amadePano;
//	}
//    @Override
//	public List<Amade> getAmadeUnion() {
//		return amadeUnion;
//	}
//    
//    
//    @Override
//    public List<Amade> getAmadeMobasherat() {
//		return amadeMobasherat;
//	}
//
//	@PostConstruct
//    public void init() {
//    	for (Amade amade : amadeServiceLocal.findAllAmade()) {
//			if(amade.getType().equals(AmadeType.PANO))
//				this.getAmadePano().add(amade);
//			else if(amade.getType().equals(AmadeType.UNION))
//				this.getAmadeUnion().add(amade);
//			else 
//				this.getAmadeMobasherat().add(amade);
//    	}
//    	
//    }
//    
//    
//	@Schedule(hour = "*", minute = "*/1", persistent = false)
//	@AccessTimeout(value = 4, unit = TimeUnit.SECONDS)
//	public void ejra() throws Exception {
//		this.amadePano.clear();
//		this.amadeUnion.clear();
//		this.amadeMobasherat.clear();
//    	for (Amade amade : amadeServiceLocal.findAllAmade()) {
//			if(amade.getType().equals(AmadeType.PANO))
//				this.getAmadePano().add(amade);
//			else if(amade.getType().equals(AmadeType.UNION))
//				this.getAmadeUnion().add(amade);
//			else 
//				this.getAmadeMobasherat().add(amade);
//    	}
//    	
//	}
//	

}
