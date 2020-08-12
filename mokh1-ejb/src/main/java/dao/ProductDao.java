package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entity.MoblEntity;
import entity.ProductEntity;
import entity.RentEntity;

/**
 * Session Bean implementation class ProductDao
 */
@Stateless
public class ProductDao implements ProductDaoLocal {

    /**
     * Default constructor. 
     */
    public ProductDao() {
        // TODO Auto-generated constructor stub
    }
    
    @PersistenceContext(unitName="aliUnit")
    private EntityManager entityManager;
    @Override
    public void insertToProduct(ProductEntity productEntity) throws Exception {
    	try {
    	entityManager.persist(productEntity);
    	}catch (Exception e) {
			throw new Exception("roleback for repetetly data");
		}
    	}
    
    @SuppressWarnings("unchecked")
    @Override
	public List<ProductEntity> findAllProductEntity(){
    	return entityManager.createNamedQuery("findAllProductEntity").getResultList();
    }
    
    
    @Override
    public void deleteProductEntity(ProductEntity productEntity2){
    	ProductEntity productEntity=new ProductEntity();
    	productEntity=entityManager.merge(productEntity2);
    	entityManager.remove(productEntity);
    }
    @Override
    public ProductEntity findProductEntityById(long productId) {
    	return (ProductEntity) entityManager.createNamedQuery("findByProductEntityId").setParameter("v_productId", productId).getSingleResult();
    }
    @Override
    public void updateProductEntity(ProductEntity productEntity) {
    	entityManager.merge(productEntity);
    }
    
    @SuppressWarnings("unchecked")
	@Override
    public List<ProductEntity> findAllProductEntityBySeller(MoblEntity moblEntity) {
    	return  entityManager.createNamedQuery("findAllProductEntityBySeller").setParameter("v_product", moblEntity).getResultList();
    }

}
