package dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entity.AyeneVConsole;
import entity.MizJeloMobli;

/**
 * Session Bean implementation class MizJeloMobliDao
 */
@Stateless
public class MizJeloMobliDao implements MizJeloMobliDaoLocal {

    /**
     * Default constructor. 
     */
    public MizJeloMobliDao() {
        // TODO Auto-generated constructor stub
    }
    @PersistenceContext(unitName="aliUnit")
    private EntityManager entityManager;
    
    @Override
    public void insertToMizJeloMobli(MizJeloMobli mizJeloMobli) throws Exception {
    	try {
    	entityManager.persist(mizJeloMobli);
    	}catch (Exception e) {
			throw new Exception("roleback for repetetly data");
		}
    	}
}
