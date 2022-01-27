package sevice;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import dao.SellerTblDaoLocal;
import entity.MoblEntity;

/**
 * Session Bean implementation class SellerService
 */
@Stateless
public class SellerService implements SellerServiceLocal {

    /**
     * Default constructor. 
     */
    public SellerService() {
        // TODO Auto-generated constructor stub
    }
    
    @Inject
    private SellerTblDaoLocal sellerTblDaoLocal;
    
    @Override
    public void insertSeller(MoblEntity moblEntity){
    	sellerTblDaoLocal.insertSeller(moblEntity);
    }
    
    
    
    
    @Override
    @SuppressWarnings("unchecked")
	public List<MoblEntity> findAllSeller(){
    	return sellerTblDaoLocal.findAllSeller();
    }
    
    
    @Override
    public MoblEntity findSellerById(long id) throws Exception{
          return sellerTblDaoLocal.findSellerById(id);
    }
    
    
    @Override
    public void updateSeller(MoblEntity moblEntity) throws Exception{
    	sellerTblDaoLocal.updateSeller(moblEntity);
    }
    
    @Override
    public void deleteSeller(MoblEntity moblEntity){
    	sellerTblDaoLocal.deleteSeller(moblEntity);
    }
    
    
    @Override
    public MoblEntity findSellerByMobile(String mobile) throws Exception{
    	return sellerTblDaoLocal.findSellerByMobile(mobile);
    }
    
    @Override
    public MoblEntity findSellerByToken(String token) throws Exception{
    	return sellerTblDaoLocal.findSellerByToken(token);
    }
    @Override
    public MoblEntity findSellerByNameEng(String nameEng) throws Exception{
    	return sellerTblDaoLocal.findSellerByNameEng(nameEng);
    }

	@Override
    public List<MoblEntity> findSellersByPanel(String panel) throws Exception{
	return sellerTblDaoLocal.findSellersByPanel(panel);
	}
	
    @Override
    public List<MoblEntity> findSellerByNamePerLike(String nameper) throws Exception{
    	return sellerTblDaoLocal.findSellerByNamePerLike(nameper);
    }
    @Override
    public List<MoblEntity> findSellerByFilter(String text,String filter) throws Exception {
    	return sellerTblDaoLocal.findSellerByFilter(text, filter);
    }
    
	@Override
	public List<MoblEntity> findSellerByFilterE(String text,String filter) throws Exception {
		return sellerTblDaoLocal.findSellerByFilterE(text, filter);
	}
    
	@Override
	public List<MoblEntity> findSellersByMojtame(String mojtame) throws Exception {
	    return sellerTblDaoLocal.findSellersByMojtame(mojtame);
	}
	

}

