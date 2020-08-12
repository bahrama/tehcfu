package sevice;

import javax.ejb.Stateless;
import javax.inject.Inject;

import dao.BazdidDaoLocal;
import entity.BazdidEntity;

/**
 * Session Bean implementation class BazdidService
 */
@Stateless
public class BazdidService implements BazdidServiceLocal {

    /**
     * Default constructor. 
     */
    public BazdidService() {
        // TODO Auto-generated constructor stub
    }
    @Inject
    private BazdidDaoLocal bazdidDaoLocal;

    
    @Override
    public void insertToBazdid(BazdidEntity bazdidEntity){
    	bazdidDaoLocal.insertToBazdid(bazdidEntity);
    }
    @Override
    public BazdidEntity findBazdidEntityById(long bazdidId) throws Exception {
    	return bazdidDaoLocal.findBazdidEntityById(bazdidId);
    			}
    
    
    @Override
    public void updateBazdidEntity(BazdidEntity bazdidEntity){
    	bazdidDaoLocal.updateBazdidEntity(bazdidEntity);
    }
}
