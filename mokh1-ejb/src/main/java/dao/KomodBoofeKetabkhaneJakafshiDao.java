package dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entity.AyeneVConsole;
import entity.KomodBoofeKetabkhaneJakafshi;

/**
 * Session Bean implementation class KomodBoofeKetabkhaneJakafshiDao
 */
@Stateless
public class KomodBoofeKetabkhaneJakafshiDao implements KomodBoofeKetabkhaneJakafshiDaoLocal {

    /**
     * Default constructor. 
     */
    public KomodBoofeKetabkhaneJakafshiDao() {
        // TODO Auto-generated constructor stub
    }

    @PersistenceContext(unitName="aliUnit")
    private EntityManager entityManager;
    
    @Override
    public void insertToKomodBoofeKetabkhaneJakafshi(KomodBoofeKetabkhaneJakafshi komodBoofeKetabkhaneJakafshi) throws Exception {
    	try {
    	entityManager.persist(komodBoofeKetabkhaneJakafshi);
    	}catch (Exception e) {
			throw new Exception("roleback for repetetly data");
		}
    	}
}
