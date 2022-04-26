package dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entity.AyeneVConsole;
import entity.SandaliEdari;

/**
 * Session Bean implementation class SandaliEdariDao
 */
@Stateless
public class SandaliEdariDao implements SandaliEdariDaoLocal {

    /**
     * Default constructor. 
     */
    public SandaliEdariDao() {
        // TODO Auto-generated constructor stub
    }
    @PersistenceContext(unitName="aliUnit")
    private EntityManager entityManager;
    
    @Override
    public void insertToSandaliEdari(SandaliEdari sandaliEdari) throws Exception {
    	try {
    	entityManager.persist(sandaliEdari);
    	}catch (Exception e) {
			throw new Exception("roleback for repetetly data");
		}
    	}
}
