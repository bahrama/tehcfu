package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entity.HomeEntity;

/**
 * Session Bean implementation class HomeDao
 */
@Stateless
public class HomeDao implements HomeDaoLocal {

    /**
     * Default constructor. 
     */
    public HomeDao() {
        // TODO Auto-generated constructor stub
    }

    @PersistenceContext(unitName="aliUnit")
    private EntityManager entityManager;
    
    
    @Override
    public void insertHomeEntity(HomeEntity homeEntity){
    	entityManager.persist(homeEntity);
    }
    
    
    
    
    @Override
    @SuppressWarnings("unchecked")
	public List<HomeEntity> findAllHomeEntity(){
    	return entityManager.createNamedQuery("HomeTbl.findAll").getResultList();
    }
    
    
    @Override
    public HomeEntity findHomeEntityById(long id) throws Exception{
    	try {
    	return (HomeEntity) entityManager.createNamedQuery("HomeTbl.findById").setParameter("v_id", id).getSingleResult();
    }catch(Exception exception) {
    	throw new Exception();
    }
    }
    
    @Override
    public HomeEntity findHomeEntityByName(String name) throws Exception{
    	try {
    	return (HomeEntity) entityManager.createNamedQuery("HomeTbl.findByName").setParameter("v_name", name).getSingleResult();
    }catch(Exception exception) {
    	throw new Exception();
    }
    }
    
    @SuppressWarnings("unchecked")
	@Override
    public List<HomeEntity> findHomeEntityByNameList(String name) throws Exception{
    	try {
    	return entityManager.createNamedQuery("HomeTbl.findByName").setParameter("v_name", name).getResultList();
    }catch(Exception exception) {
    	throw new Exception();
    }
    }
    
    @Override
    public void updateHomeEntity(HomeEntity homeEntity) throws Exception{
    	try {
    	entityManager.merge(homeEntity);
    	}catch (Exception e) {
			throw new Exception();
		}
    }
    
    @Override
    public void deleteSeller(HomeEntity homeEntity){
    	HomeEntity homeEntity2=new HomeEntity();
    	homeEntity2=entityManager.merge(homeEntity);
    	entityManager.remove(homeEntity2);
    }
    
}
