package sevice;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import dao.MobasheratDaoLocal;
import entity.MobasheratEntity;

/**
 * Session Bean implementation class MobasheratService
 */
@Stateless
public class MobasheratService implements MobasheratServiceLocal {

    /**
     * Default constructor. 
     */
    public MobasheratService() {
        // TODO Auto-generated constructor stub
    }
    @Inject
    private MobasheratDaoLocal mobasheratDaoLocal;

    @Override
    public void insertToMobasherat(MobasheratEntity mobasheratEntity) {
    	mobasheratDaoLocal.insertToMobasherat(mobasheratEntity);
    }
    
    @SuppressWarnings("unchecked")
    @Override
	public List<MobasheratEntity> findAllMobasherat(){
    	return mobasheratDaoLocal.findAllMobasherat();
    }
    
    
    @Override
    public void deleteMobasherat(MobasheratEntity mobasheratEntity2){
    	mobasheratDaoLocal.deleteMobasherat(mobasheratEntity2);
    }
    @Override
    public MobasheratEntity findMobasheratById(long id) {
    	return mobasheratDaoLocal.findMobasheratById(id);
    }
    @Override
    public void updateMobasherat(MobasheratEntity mobasheratEntity) {
    	mobasheratDaoLocal.updateMobasherat(mobasheratEntity);
    }

    
    
}
