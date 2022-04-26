package dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entity.AyeneVConsole;
import entity.MizAsali;

/**
 * Session Bean implementation class MizAsaliDao
 */
@Stateless
public class MizAsaliDao implements MizAsaliDaoLocal {

    /**
     * Default constructor. 
     */
    public MizAsaliDao() {
        // TODO Auto-generated constructor stub
    }
    @PersistenceContext(unitName="aliUnit")
    private EntityManager entityManager;
    
    @Override
    public void insertToMizAsali(MizAsali mizAsali) throws Exception {
    	try {
    	entityManager.persist(mizAsali);
    	}catch (Exception e) {
			throw new Exception("roleback for repetetly data");
		}
    	}
}
