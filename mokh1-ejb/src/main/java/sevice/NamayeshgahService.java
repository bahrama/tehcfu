package sevice;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import dao.NamayeshgahDaoLocal;
import entity.NamayeshgahEntity;

/**
 * Session Bean implementation class NamayeshgahService
 */
@Stateless
public class NamayeshgahService implements NamayeshgahServiceLocal {

    /**
     * Default constructor. 
     */
    public NamayeshgahService() {
        // TODO Auto-generated constructor stub
    }
    @Inject
    private NamayeshgahDaoLocal namayeshgahDaoLocal;

    @Override
    public void insertNamayeshgahEntity(NamayeshgahEntity namayeshgahEntity){
    	namayeshgahDaoLocal.insertNamayeshgahEntity(namayeshgahEntity);
    }
    
    
    
    
    @Override
    @SuppressWarnings("unchecked")
	public List<NamayeshgahEntity> findAllNamayeshgahEntity(){
    	return namayeshgahDaoLocal.findAllNamayeshgahEntity();
    }
    
    
    @Override
    public NamayeshgahEntity findNamayeshgahEntityById(long id) throws Exception{
    	try {
    	return namayeshgahDaoLocal.findNamayeshgahEntityById(id);
    }catch(Exception exception) {
    	throw new Exception();
    }
    }
    
    
    @Override
    public void updateNamayeshgahEntity(NamayeshgahEntity namayeshgahEntity) throws Exception{
    	try {
    		namayeshgahDaoLocal.updateNamayeshgahEntity(namayeshgahEntity);
    	}catch (Exception e) {
			throw new Exception();
		}
    }
    
    @Override
    public void deleteNamayeshgahEntity(NamayeshgahEntity namayeshgahEntity){
    	namayeshgahDaoLocal.deleteNamayeshgahEntity(namayeshgahEntity);
    }
    
    
    
    
    
}
