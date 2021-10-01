package dao;


import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entity.Amade;
import enums.AmadeType;



/**
 * Session Bean implementation class AmadeDao
 */
@Stateless
public class AmadeDao implements AmadeDaoLocal {

    /**
     * Default constructor. 
     */
    public AmadeDao() {
        // TODO Auto-generated constructor stub
    }
    
    @PersistenceContext(unitName="aliUnit")
    private EntityManager entityManager;
    
    @Override
    public void insertToAmade(Amade amade){
    	entityManager.persist(amade);
    }
    @Override
    public Amade findAmadeById(long amadeId) {
    	return (Amade) entityManager.createNamedQuery("findByAmadeId").setParameter("v_amadeId", amadeId).getSingleResult();
    }
    
    @SuppressWarnings("unchecked")
	@Override
    public List<Amade> findAmadeByType(AmadeType type) {
    	return entityManager.createNamedQuery("findByAmadeType").setParameter("v_type", type).getResultList();
    }
    
    @Override
    @SuppressWarnings("unchecked")
	public List<Amade> findAllAmade(){
    	return entityManager.createNamedQuery("findAllAmade").getResultList();
    }
    
    @Override
    public void deleteAmade(Amade amade) {
    	Amade amade2=new Amade();
    	amade2=entityManager.merge(amade);
    	entityManager.remove(amade2);
    }
}
