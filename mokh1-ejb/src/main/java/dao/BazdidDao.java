package dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entity.Amade;
import entity.BazdidEntity;
import entity.BlogEntity;

/**
 * Session Bean implementation class BazdidDao
 */
@Stateless
public class BazdidDao implements BazdidDaoLocal {

    /**
     * Default constructor. 
     */
    public BazdidDao() {
        // TODO Auto-generated constructor stub
    }
    
    @PersistenceContext(unitName="aliUnit")
    private EntityManager entityManager;
    
    @Override
    public void insertToBazdid(BazdidEntity bazdidEntity){
    	entityManager.persist(bazdidEntity);
    }
    @Override
    public BazdidEntity findBazdidEntityById(long bazdidId) throws Exception {
    	try {
    	return (BazdidEntity) entityManager.createNamedQuery("findByBazdidId").setParameter("v_bazdidId", bazdidId).getSingleResult();
    	}catch(Exception e) {
    		throw new Exception();
    	}
    	}
    
    
    @Override
    public void updateBazdidEntity(BazdidEntity bazdidEntity){
    	entityManager.merge(bazdidEntity);
    }
}
