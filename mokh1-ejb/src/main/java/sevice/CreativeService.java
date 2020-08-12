package sevice;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import dao.CreativeDaoLocal;
import entity.CreativeEntity;

/**
 * Session Bean implementation class CreativeService
 */
@Stateless
public class CreativeService implements CreativeServiceLocal {

    /**
     * Default constructor. 
     */
    public CreativeService() {
        // TODO Auto-generated constructor stub
    }
    @Inject
    private CreativeDaoLocal creativeDaoLocal; 
    
    @Override
    public void insertCreativeEntity(CreativeEntity creativeEntity){
    	creativeDaoLocal.insertCreativeEntity(creativeEntity);
    }
    
    
    
    
    @Override
    @SuppressWarnings("unchecked")
	public List<CreativeEntity> findAllCreativeEntity(){
    	return creativeDaoLocal.findAllCreativeEntity();
    }
    
    
    @Override
    public CreativeEntity findCreativeEntityById(long id) throws Exception{
    	try {
    	return creativeDaoLocal.findCreativeEntityById(id);
    }catch(Exception exception) {
    	throw new Exception();
    }
    }
    
    
    @Override
    public void updateCreativeEntity(CreativeEntity creativeEntity) throws Exception{
    	try {
    		creativeDaoLocal.updateCreativeEntity(creativeEntity);
    	}catch (Exception e) {
			throw new Exception();
		}
    }
    
    @Override
    public void deleteCreativeEntity(CreativeEntity creativeEntity){
    	creativeDaoLocal.deleteCreativeEntity(creativeEntity);
    }
    
    
}
