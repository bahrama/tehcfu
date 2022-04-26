package dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entity.AyeneVConsole;
import entity.MizTv;

/**
 * Session Bean implementation class MizTvDao
 */
@Stateless
public class MizTvDao implements MizTvDaoLocal {

    /**
     * Default constructor. 
     */
    public MizTvDao() {
        // TODO Auto-generated constructor stub
    }
    @PersistenceContext(unitName="aliUnit")
    private EntityManager entityManager;
    
    @Override
    public void insertToMizTv(MizTv mizTv) throws Exception {
    	try {
    	entityManager.persist(mizTv);
    	}catch (Exception e) {
			throw new Exception("roleback for repetetly data");
		}
    	}
}
