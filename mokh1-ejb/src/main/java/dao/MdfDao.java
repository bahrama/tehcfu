package dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entity.AyeneVConsole;
import entity.Mdf;

/**
 * Session Bean implementation class MdfDao
 */
@Stateless
public class MdfDao implements MdfDaoLocal {

    /**
     * Default constructor. 
     */
    public MdfDao() {
        // TODO Auto-generated constructor stub
    }
    @PersistenceContext(unitName="aliUnit")
    private EntityManager entityManager;
    
    @Override
    public void insertToMdf(Mdf mdf) throws Exception {
    	try {
    	entityManager.persist(mdf);
    	}catch (Exception e) {
			throw new Exception("roleback for repetetly data");
		}
    	}
}
