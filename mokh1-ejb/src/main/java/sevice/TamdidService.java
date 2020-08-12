package sevice;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import dao.TamdidDaoLocal;
import entity.TamdidEntity;

/**
 * Session Bean implementation class TamdidService
 */
@Stateless
public class TamdidService implements TamdidServiceLocal {

    /**
     * Default constructor. 
     */
    public TamdidService() {
        // TODO Auto-generated constructor stub
    }
    @Inject
    private TamdidDaoLocal tamdidDaoLocal;
    
    @Override
    public void insertToTamdid(TamdidEntity tamdidEntity) {
    	tamdidDaoLocal.insertToTamdid(tamdidEntity);
    }
    
    @SuppressWarnings("unchecked")
    @Override
	public List<TamdidEntity> findAllTamdid(){
    	return tamdidDaoLocal.findAllTamdid();
    }
    
    
    @Override
    public void deleteTamdid(TamdidEntity tamdidEntity2){
    	tamdidDaoLocal.deleteTamdid(tamdidEntity2);
    }
    @Override
    public TamdidEntity findTamdidById(long id) {
    	return tamdidDaoLocal.findTamdidById(id);
    }
    @Override
    public void updateTamdid(TamdidEntity tamdidEntity) {
    	tamdidDaoLocal.updateTamdid(tamdidEntity);
    }


}
