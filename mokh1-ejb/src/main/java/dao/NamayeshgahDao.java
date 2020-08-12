package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entity.BlogEntity;
import entity.NamayeshgahEntity;

/**
 * Session Bean implementation class NamayeshgahDao
 */
@Stateless
public class NamayeshgahDao implements NamayeshgahDaoLocal {

    /**
     * Default constructor. 
     */
    public NamayeshgahDao() {
        // TODO Auto-generated constructor stub
    }
    
    @PersistenceContext(unitName="aliUnit")
    private EntityManager entityManager;
    
    
    @Override
    public void insertNamayeshgahEntity(NamayeshgahEntity namayeshgahEntity){
    	entityManager.persist(namayeshgahEntity);
    }
    
    
    
    
    @Override
    @SuppressWarnings("unchecked")
	public List<NamayeshgahEntity> findAllNamayeshgahEntity(){
    	return entityManager.createNamedQuery("NamayeshgahEntity.findAll").getResultList();
    }
    
    
    @Override
    public NamayeshgahEntity findNamayeshgahEntityById(long id) throws Exception{
    	try {
    	return (NamayeshgahEntity) entityManager.createNamedQuery("NamayeshgahEntity.findById").setParameter("v_id", id).getSingleResult();
    }catch(Exception exception) {
    	throw new Exception();
    }
    }
    
    
    @Override
    public void updateNamayeshgahEntity(NamayeshgahEntity namayeshgahEntity) throws Exception{
    	try {
    	entityManager.merge(namayeshgahEntity);
    	}catch (Exception e) {
			throw new Exception();
		}
    }
    
    @Override
    public void deleteNamayeshgahEntity(NamayeshgahEntity namayeshgahEntity){
    	NamayeshgahEntity namayeshgahEntity2=new NamayeshgahEntity();
    	namayeshgahEntity2=entityManager.merge(namayeshgahEntity);
    	entityManager.remove(namayeshgahEntity2);
    }
    

}
