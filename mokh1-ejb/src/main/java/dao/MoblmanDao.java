package dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entity.AyeneVConsole;
import entity.Moblman;

/**
 * Session Bean implementation class MoblmanDao
 */
@Stateless
public class MoblmanDao implements MoblmanDaoLocal {

    /**
     * Default constructor. 
     */
    public MoblmanDao() {
        // TODO Auto-generated constructor stub
    }

    @PersistenceContext(unitName="aliUnit")
    private EntityManager entityManager;
    
    @Override
    public void insertToMoblman(Moblman moblman) throws Exception {
    	try {
    	entityManager.persist(moblman);
    	}catch (Exception e) {
			throw new Exception("roleback for repetetly data");
		}
    	}
}
