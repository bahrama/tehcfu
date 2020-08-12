package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entity.MobasheratEntity;
import entity.TamdidEntity;

/**
 * Session Bean implementation class MobasheratDao
 */
@Stateless
public class MobasheratDao implements MobasheratDaoLocal {

    /**
     * Default constructor. 
     */
    public MobasheratDao() {
        // TODO Auto-generated constructor stub
    }
    
    
    @PersistenceContext(unitName="aliUnit")
    private EntityManager entityManager;
    @Override
    public void insertToMobasherat(MobasheratEntity mobasheratEntity) {
    	entityManager.persist(mobasheratEntity);
    }
    
    @SuppressWarnings("unchecked")
    @Override
	public List<MobasheratEntity> findAllMobasherat(){
    	return entityManager.createNamedQuery("findAllMobasherat").getResultList();
    }
    
    
    @Override
    public void deleteMobasherat(MobasheratEntity mobasheratEntity2){
    	MobasheratEntity mobasheratEntity=new MobasheratEntity();
    	mobasheratEntity=entityManager.merge(mobasheratEntity2);
    	entityManager.remove(mobasheratEntity);
    }
    @Override
    public MobasheratEntity findMobasheratById(long id) {
    	return (MobasheratEntity) entityManager.createNamedQuery("findMobasheratById").setParameter("v_mobasherId", id).getSingleResult();
    }
    @Override
    public void updateMobasherat(MobasheratEntity mobasheratEntity) {
    	entityManager.merge(mobasheratEntity);
    }

}
