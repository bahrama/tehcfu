package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entity.TaminProductEntity;

/**
 * Session Bean implementation class TaminProductDao
 */
@Stateless
public class TaminProductDao implements TaminProductDaoLocal {

    /**
     * Default constructor. 
     */
    public TaminProductDao() {
        // TODO Auto-generated constructor stub
    }
    
    @PersistenceContext(unitName = "aliUnit")
	private EntityManager entityManager;
	
	@Override
	public void insertTaminProduct(TaminProductEntity taminProductEntity) {
		entityManager.persist(taminProductEntity);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<TaminProductEntity> findAllTaminProduct() {
		return entityManager.createNamedQuery("TaminProductEntity.findAll").getResultList();
	}
	
	@Override
	public TaminProductEntity findTaminProductById(long id) throws Exception {
		try {
			return (TaminProductEntity) entityManager.createNamedQuery("TaminProductEntity.findById").setParameter("v_id", id)
					.getSingleResult();
		} catch (Exception exception) {
			throw new Exception();
		}
	}
	
	@Override
	public void updateTaminProduct(TaminProductEntity taminProductEntity) throws Exception {
		try {
			entityManager.merge(taminProductEntity);
		} catch (Exception e) {
			throw new Exception();
		}
	}

	@Override
	public void deleteTaminProduct(TaminProductEntity taminProductEntity) {
		TaminProductEntity taminProductEntity2 = new TaminProductEntity();
		taminProductEntity2 = entityManager.merge(taminProductEntity);
		entityManager.remove(taminProductEntity2);
	}

}
