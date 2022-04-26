package dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entity.AyeneVConsole;
import entity.Panjare;

/**
 * Session Bean implementation class PanjareDao
 */
@Stateless
public class PanjareDao implements PanjareDaoLocal {

    /**
     * Default constructor. 
     */
    public PanjareDao() {
        // TODO Auto-generated constructor stub
    }
    @PersistenceContext(unitName="aliUnit")
    private EntityManager entityManager;
    
    @Override
    public void insertToPanjare(Panjare panjare) throws Exception {
    	try {
    	entityManager.persist(panjare);
    	}catch (Exception e) {
			throw new Exception("roleback for repetetly data");
		}
    	}
}
