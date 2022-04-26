package dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entity.AyeneVConsole;
import entity.ServiceKhab2;

/**
 * Session Bean implementation class ServiceKhab2Dao
 */
@Stateless
public class ServiceKhab2Dao implements ServiceKhab2DaoLocal {

    /**
     * Default constructor. 
     */
    public ServiceKhab2Dao() {
        // TODO Auto-generated constructor stub
    }
    @PersistenceContext(unitName="aliUnit")
    private EntityManager entityManager;
    
    @Override
    public void insertToServiceKhab2(ServiceKhab2 serviceKhab2) throws Exception {
    	try {
    	entityManager.persist(serviceKhab2);
    	}catch (Exception e) {
			throw new Exception("roleback for repetetly data");
		}
    	}
}
