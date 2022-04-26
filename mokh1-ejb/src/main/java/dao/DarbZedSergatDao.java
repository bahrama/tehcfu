package dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entity.AyeneVConsole;
import entity.DarbZedSergat;

/**
 * Session Bean implementation class DarbZedSergatDao
 */
@Stateless
public class DarbZedSergatDao implements DarbZedSergatDaoLocal {

    /**
     * Default constructor. 
     */
    public DarbZedSergatDao() {
        // TODO Auto-generated constructor stub
    }

    @PersistenceContext(unitName="aliUnit")
    private EntityManager entityManager;
    
    @Override
    public void insertToDarbZedSergat(DarbZedSergat darbZedSergat) throws Exception {
    	try {
    	entityManager.persist(darbZedSergat);
    	}catch (Exception e) {
			throw new Exception("roleback for repetetly data");
		}
    	}
}
