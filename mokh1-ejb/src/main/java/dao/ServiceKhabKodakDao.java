package dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entity.AyeneVConsole;
import entity.ServiceKhabKodak;

/**
 * Session Bean implementation class ServiceKhabKodakDao
 */
@Stateless
public class ServiceKhabKodakDao implements ServiceKhabKodakDaoLocal {

    /**
     * Default constructor. 
     */
    public ServiceKhabKodakDao() {
        // TODO Auto-generated constructor stub
    }
    @PersistenceContext(unitName="aliUnit")
    private EntityManager entityManager;
    
    @Override
    public void insertToServiceKhabKodak(ServiceKhabKodak serviceKhabKodak) throws Exception {
    	try {
    	entityManager.persist(serviceKhabKodak);
    	}catch (Exception e) {
			throw new Exception("roleback for repetetly data");
		}
    	}
}
