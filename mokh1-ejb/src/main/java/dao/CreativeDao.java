package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entity.CreativeEntity;
import entity.NamayeshgahEntity;

/**
 * Session Bean implementation class CreativeDao
 */
@Stateless
public class CreativeDao implements CreativeDaoLocal {

    /**
     * Default constructor. 
     */
    public CreativeDao() {
        // TODO Auto-generated constructor stub
    }
    
    @PersistenceContext(unitName="aliUnit")
    private EntityManager entityManager;
    
    
    @Override
    public void insertCreativeEntity(CreativeEntity creativeEntity){
    	entityManager.persist(creativeEntity);
    }
    
    
    
    
    @Override
    @SuppressWarnings("unchecked")
	public List<CreativeEntity> findAllCreativeEntity(){
    	return entityManager.createNamedQuery("CreativeEntity.findAll").getResultList();
    }
    
    
    @Override
    public CreativeEntity findCreativeEntityById(long id) throws Exception{
    	try {
    	return (CreativeEntity) entityManager.createNamedQuery("CreativeEntity.findById").setParameter("v_id", id).getSingleResult();
    }catch(Exception exception) {
    	throw new Exception();
    }
    }
    
    
    @Override
    public void updateCreativeEntity(CreativeEntity creativeEntity) throws Exception{
    	try {
    	entityManager.merge(creativeEntity);
    	}catch (Exception e) {
			throw new Exception();
		}
    }
    
    @Override
    public void deleteCreativeEntity(CreativeEntity creativeEntity){
    	CreativeEntity creativeEntity2=new CreativeEntity();
    	creativeEntity2=entityManager.merge(creativeEntity);
    	entityManager.remove(creativeEntity2);
    }
    

}
