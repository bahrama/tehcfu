package dao;

import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entity.AdvertiseEntity;
import entity.MoblEntity;
import entity.ProductEntity;
import entity.SefareshEntity;

/**
 * Session Bean implementation class SefareshDao
 */
@Stateful
public class SefareshDao implements SefareshDaoLocal {

    /**
     * Default constructor. 
     */
    public SefareshDao() {
        // TODO Auto-generated constructor stub
    }
    
    @PersistenceContext(unitName="aliUnit")
    private EntityManager entityManager;
    
    @Override
    public void insertToSefaresh(SefareshEntity sefareshEntity) throws Exception {
    	try {
    	entityManager.persist(sefareshEntity);
    	}catch (Exception e) {
			throw new Exception("roleback for repetetly data");
		}
    }
    
    @SuppressWarnings("unchecked")
	@Override
    public List<SefareshEntity> findAllSefareshByUser(MoblEntity moblEntity) {
      return entityManager.createNamedQuery("findAllSefareshByUser").setParameter("v_sefareshUser", moblEntity)
    		  .setParameter("v_isdel", false).setParameter("v_acceptUserSefaresh", false).getResultList();
    }
    
    @SuppressWarnings("unchecked")
	@Override
    public int findCountAllSefareshByUser(MoblEntity moblEntity) {
      return entityManager.createNamedQuery("findAllSefareshByUser").setParameter("v_sefareshUser", moblEntity)
    		  .setParameter("v_isdel", false).setParameter("v_acceptUserSefaresh", false).getResultList().size();
    }
    
    @SuppressWarnings("unchecked")
	@Override
    public List<SefareshEntity> findAllSefareshByUser(ProductEntity product) {
      return entityManager.createNamedQuery("findAllSefareshByProduct").setParameter("v_sefareshProduct", product)
    		  .setParameter("v_isdel", false).getResultList();
    }
    
    @SuppressWarnings("unchecked")
 	@Override
     public List<SefareshEntity> findAllSefareshByMerchant(MoblEntity moblEntity) {
       return entityManager.createNamedQuery("findAllSefareshByMerchant").setParameter("v_sefareshMerchant", moblEntity)
     		  .setParameter("v_isdel", false).setParameter("v_acceptUserSefaresh", true).getResultList();
     }
    
    @SuppressWarnings("unchecked")
 	@Override
     public int findAllCountSefareshByMerchant(MoblEntity moblEntity) {
       return entityManager.createNamedQuery("findCountAllSefareshByMerchant").setParameter("v_sefareshMerchant", moblEntity)
     		  .setParameter("v_isdel", false).setParameter("v_acceptUserSefaresh", true).setParameter("v_acceptSefaresh", false).getResultList().size();
     }
    
	@Override
	public void deleteSefaresh(SefareshEntity sefareshEntity) {
		SefareshEntity sefareshEntity2 =new SefareshEntity();
		sefareshEntity2 = entityManager.merge(sefareshEntity);
		entityManager.remove(sefareshEntity2);
	}

	
	@Override
	public SefareshEntity findSefareshById(long sefareshId){
			return (SefareshEntity) entityManager.createNamedQuery("SefareshEntity.findById").setParameter("v_sefareshId", sefareshId)
					.getSingleResult();
	}
	
	@Override
	public void updateSefaresh(SefareshEntity sefareshEntity) throws Exception {
		try {
			entityManager.merge(sefareshEntity);
		} catch (Exception e) {
			throw new Exception();
		}
	}
	
	
}
