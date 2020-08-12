package dao;


import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entity.Shekayat1;



/**
 * Session Bean implementation class ShekayatDao
 */
@Stateless
public class ShekayatDao implements ShekayatDaoLocal {

    /**
     * Default constructor. 
     */
    public ShekayatDao() {
        // TODO Auto-generated constructor stub
    }
    
    @PersistenceContext(unitName="aliUnit")
    private EntityManager entityManager;
    
    @Override
    public void inserToShekayat(Shekayat1 shekayat1){
    	entityManager.persist(shekayat1);
    }
    
    @SuppressWarnings("unchecked")
    @Override
	public List<Shekayat1> findAllShekayat(){
    	return entityManager.createNamedQuery("findAllShekayat").getResultList();
    }
    @Override
    public Shekayat1 findShekayatById(long shakiId) throws Exception {
    	try {
    	return (Shekayat1) entityManager.createNamedQuery("findById").setParameter("v_shekayatId", shakiId).getSingleResult();
    	}catch (Exception e) {
    		throw new Exception();
		//return null;
		}
    	}
    @Override
    public void shekayatUpdate(Shekayat1 shekayat1) {
    	entityManager.merge(shekayat1);
    }
    
    
    @SuppressWarnings("unchecked")
    @Override
	public List<Shekayat1> findAllShekayatOrder(){
    	return entityManager.createNamedQuery("findAllById2").getResultList();
    }
    
    @Override
    public void deleteShekayatEntity(Shekayat1 shekayat1){
    	Shekayat1 shekayat12=new Shekayat1();
    	shekayat12=entityManager.merge(shekayat1);
    	entityManager.remove(shekayat12);
    }

}
