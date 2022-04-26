package dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entity.AyeneVConsole;
import entity.MizNaharKhori;

/**
 * Session Bean implementation class MizNaharKhoriDao
 */
@Stateless
public class MizNaharKhoriDao implements MizNaharKhoriDaoLocal {

    /**
     * Default constructor. 
     */
    public MizNaharKhoriDao() {
        // TODO Auto-generated constructor stub
    }
    @PersistenceContext(unitName="aliUnit")
    private EntityManager entityManager;
    
    @Override
    public void insertToMizNaharKhori(MizNaharKhori mizNaharKhori) throws Exception {
    	try {
    	entityManager.persist(mizNaharKhori);
    	}catch (Exception e) {
			throw new Exception("roleback for repetetly data");
		}
    	}
}
