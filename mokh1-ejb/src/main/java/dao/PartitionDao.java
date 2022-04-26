package dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entity.AyeneVConsole;
import entity.Partition;

/**
 * Session Bean implementation class PartitionDao
 */
@Stateless
public class PartitionDao implements PartitionDaoLocal {

    /**
     * Default constructor. 
     */
    public PartitionDao() {
        // TODO Auto-generated constructor stub
    }
    @PersistenceContext(unitName="aliUnit")
    private EntityManager entityManager;
    
    @Override
    public void insertToPartition(Partition partition) throws Exception {
    	try {
    	entityManager.persist(partition);
    	}catch (Exception e) {
			throw new Exception("roleback for repetetly data");
		}
    	}
}
