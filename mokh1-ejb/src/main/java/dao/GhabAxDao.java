package dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entity.AyeneVConsole;
import entity.GhabAx;

/**
 * Session Bean implementation class GhabAxDao
 */
@Stateless
public class GhabAxDao implements GhabAxDaoLocal {

    /**
     * Default constructor. 
     */
    public GhabAxDao() {
        // TODO Auto-generated constructor stub
    }

    @PersistenceContext(unitName="aliUnit")
    private EntityManager entityManager;
    
    @Override
    public void insertToGhabAx(GhabAx ghabAx) throws Exception {
    	try {
    	entityManager.persist(ghabAx);
    	}catch (Exception e) {
			throw new Exception("roleback for repetetly data");
		}
    	}
}
