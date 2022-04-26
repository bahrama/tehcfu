package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entity.MoblEntity;
import entity.OfferEntity;
import entity.ProductEntity;
import entity.SefareshEntity;

/**
 * Session Bean implementation class OfferDao
 */
@Stateless
public class OfferDao implements OfferDaoLocal {

    /**
     * Default constructor. 
     */
    public OfferDao() {
        // TODO Auto-generated constructor stub
    }

    @PersistenceContext(unitName="aliUnit")
    private EntityManager entityManager;
    
    @Override
    public void insertToOffer(OfferEntity offerEntity) throws Exception {
    	try {
    	entityManager.persist(offerEntity);
    	}catch (Exception e) {
			throw new Exception("roleback for repetetly data");
		}
    }
    
 	@Override
     public OfferEntity findUserByToken(String token) throws Exception {
 		try {
       return (OfferEntity) entityManager.createNamedQuery("OfferEntity.findByToken").setParameter("v_userTokeLoguot", token).getSingleResult();
 		}catch (Exception e){
 		throw new Exception();
		}
 	}
    
 	@Override
     public int findAllCountByMerchant(MoblEntity moblEntity) {
       return entityManager.createNamedQuery("OfferEntity.findAllByMerchant").setParameter("v_offerMerchantPage", moblEntity)
    		   .getResultList().size();
     }
    
 	@SuppressWarnings("unchecked")
	@Override
     public List<OfferEntity> findAllByByProduct(ProductEntity productEntity) {
       return entityManager.createNamedQuery("OfferEntity.findAllByToken").setParameter("v_offerProduct", productEntity)
    		   .getResultList();
     }
 	
 	@SuppressWarnings("unchecked")
	@Override
    public List<OfferEntity> findAllByMerchant(MoblEntity moblEntity) {
      return entityManager.createNamedQuery("OfferEntity.findAllByMerchant").setParameter("v_offerMerchantPage", moblEntity)
   		   .getResultList();
    }
}
