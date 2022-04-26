package dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entity.AyeneVConsole;
import entity.ServiceKhab1;

/**
 * Session Bean implementation class ServiceKhab1Dao
 */
@Stateless
public class ServiceKhab1Dao implements ServiceKhab1DaoLocal {

    /**
     * Default constructor. 
     */
    public ServiceKhab1Dao() {
        // TODO Auto-generated constructor stub
    }
    @PersistenceContext(unitName="aliUnit")
    private EntityManager entityManager;
    
    @Override
    public void insertToServiceKhab1(ServiceKhab1 serviceKhab1) throws Exception {
    	try {
    	entityManager.persist(serviceKhab1);
    	}catch (Exception e) {
			throw new Exception("roleback for repetetly data");
		}
    	}
}
