package dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entity.AyeneVConsole;
import entity.MizEdari;

/**
 * Session Bean implementation class MizEdariDao
 */
@Stateless
public class MizEdariDao implements MizEdariDaoLocal {

    /**
     * Default constructor. 
     */
    public MizEdariDao() {
        // TODO Auto-generated constructor stub
    }
    @PersistenceContext(unitName="aliUnit")
    private EntityManager entityManager;
    
    @Override
    public void insertToMizEdari(MizEdari mizEdari) throws Exception {
    	try {
    	entityManager.persist(mizEdari);
    	}catch (Exception e) {
			throw new Exception("roleback for repetetly data");
		}
    	}
}
