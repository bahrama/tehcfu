package dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entity.AyeneVConsole;
import entity.ProductEntity;

/**
 * Session Bean implementation class AyeneVConsoleDao
 */
@Stateless
public class AyeneVConsoleDao implements AyeneVConsoleDaoLocal {

    /**
     * Default constructor. 
     */
    public AyeneVConsoleDao() {
        // TODO Auto-generated constructor stub
    }

    
    @PersistenceContext(unitName="aliUnit")
    private EntityManager entityManager;
    
    @Override
    public void insertToAyeneVConsole(AyeneVConsole ayeneVConsole) throws Exception {
    	try {
    	entityManager.persist(ayeneVConsole);
    	}catch (Exception e) {
			throw new Exception("roleback for repetetly data");
		}
    	}
}
