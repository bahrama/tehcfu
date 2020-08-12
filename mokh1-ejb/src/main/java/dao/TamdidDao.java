package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entity.TamdidEntity;

/**
 * Session Bean implementation class TamdidDao
 */
@Stateless
public class TamdidDao implements TamdidDaoLocal {

    /**
     * Default constructor. 
     */
    public TamdidDao() {
        // TODO Auto-generated constructor stub
    }
    
    @PersistenceContext(unitName="aliUnit")
    private EntityManager entityManager;
    @Override
    public void insertToTamdid(TamdidEntity tamdidEntity) {
    	entityManager.persist(tamdidEntity);
    }
    
    @SuppressWarnings("unchecked")
    @Override
	public List<TamdidEntity> findAllTamdid(){
    	return entityManager.createNamedQuery("findAllTamdid").getResultList();
    }
    
    
    @Override
    public void deleteTamdid(TamdidEntity tamdidEntity2){
    	TamdidEntity tamdidEntity=new TamdidEntity();
    	tamdidEntity=entityManager.merge(tamdidEntity2);
    	entityManager.remove(tamdidEntity);
    }
    @Override
    public TamdidEntity findTamdidById(long id) {
    	return (TamdidEntity) entityManager.createNamedQuery("findTamdidById").setParameter("v_tamdidId", id).getSingleResult();
    }
    @Override
    public void updateTamdid(TamdidEntity tamdidEntity) {
    	entityManager.merge(tamdidEntity);
    }


}
