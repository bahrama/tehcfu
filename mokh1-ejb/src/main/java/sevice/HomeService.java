package sevice;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import dao.HomeDaoLocal;
import entity.HomeEntity;

/**
 * Session Bean implementation class HomeService
 */
@Stateless
public class HomeService implements HomeServiceLocal {

    /**
     * Default constructor. 
     */
    public HomeService() {
        // TODO Auto-generated constructor stub
    }
    @Inject
    private HomeDaoLocal homeDaoLocal;
    
    @Override
    public void insertHomeEntity(HomeEntity homeEntity){
    	homeDaoLocal.insertHomeEntity(homeEntity);
    }
    
    
    
    
    @Override
    @SuppressWarnings("unchecked")
	public List<HomeEntity> findAllHomeEntity(){
    	return homeDaoLocal.findAllHomeEntity();
    }
    
    
    @Override
    public HomeEntity findHomeEntityById(long id) throws Exception{
    	return homeDaoLocal.findHomeEntityById(id);
    }
    
    
    @Override
    public void updateHomeEntity(HomeEntity homeEntity) throws Exception{
    	homeDaoLocal.updateHomeEntity(homeEntity);
    }
    
    @Override
    public void deleteSeller(HomeEntity homeEntity){
    	homeDaoLocal.deleteSeller(homeEntity);
    }
    

}
