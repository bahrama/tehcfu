package dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entity.AyeneVConsole;
import entity.Kabinet;

/**
 * Session Bean implementation class KabinetDao
 */
@Stateless
public class KabinetDao implements KabinetDaoLocal {

    /**
     * Default constructor. 
     */
    public KabinetDao() {
        // TODO Auto-generated constructor stub
    }
    @PersistenceContext(unitName="aliUnit")
    private EntityManager entityManager;
    
    @Override
    public void insertToKabinet(Kabinet kabinet) throws Exception {
    	try {
    	entityManager.persist(kabinet);
    	}catch (Exception e) {
			throw new Exception("roleback for repetetly data");
		}
    	}
}
