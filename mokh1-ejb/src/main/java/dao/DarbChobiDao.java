package dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entity.AyeneVConsole;
import entity.DarbChobi;

/**
 * Session Bean implementation class DarbChobiDao
 */
@Stateless
public class DarbChobiDao implements DarbChobiDaoLocal {

    /**
     * Default constructor. 
     */
    public DarbChobiDao() {
        // TODO Auto-generated constructor stub
    }

    @PersistenceContext(unitName="aliUnit")
    private EntityManager entityManager;
    
    @Override
    public void insertToDarbChobi(DarbChobi darbChobi) throws Exception {
    	try {
    	entityManager.persist(darbChobi);
    	}catch (Exception e) {
			throw new Exception("roleback for repetetly data");
		}
    	}
}
