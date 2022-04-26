package dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entity.AyeneVConsole;
import entity.Monabat;

/**
 * Session Bean implementation class MonabatDao
 */
@Stateless
public class MonabatDao implements MonabatDaoLocal {

    /**
     * Default constructor. 
     */
    public MonabatDao() {
        // TODO Auto-generated constructor stub
    }
    @PersistenceContext(unitName="aliUnit")
    private EntityManager entityManager;
    
    @Override
    public void insertToMonabat(Monabat monabat) throws Exception {
    	try {
    	entityManager.persist(monabat);
    	}catch (Exception e) {
			throw new Exception("roleback for repetetly data");
		}
    	}
}
