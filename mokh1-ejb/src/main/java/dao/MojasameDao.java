package dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entity.AyeneVConsole;
import entity.Mojasame;

/**
 * Session Bean implementation class Mojasame
 */
@Stateless
public class MojasameDao implements MojasameDaoLocal {

    /**
     * Default constructor. 
     */
    public MojasameDao() {
        // TODO Auto-generated constructor stub
    }
    @PersistenceContext(unitName="aliUnit")
    private EntityManager entityManager;
    
    @Override
    public void insertToMojasame(Mojasame mojasame) throws Exception {
    	try {
    	entityManager.persist(mojasame);
    	}catch (Exception e) {
			throw new Exception("roleback for repetetly data");
		}
    	}
}
