package sevice;

import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.inject.Inject;

import dao.ProductDaoLocal;
import entity.MoblEntity;
import entity.ProductEntity;

/**
 * Session Bean implementation class Productservice
 */
@Stateless
public class Productservice implements ProductserviceLocal {

    /**
     * Default constructor. 
     */
    public Productservice() {
        // TODO Auto-generated constructor stub
    }
    @Inject
    private ProductDaoLocal productDaoLocal; 

    @Override
    public void insertToProduct(ProductEntity productEntity) throws Exception {
    	productDaoLocal.insertToProduct(productEntity);
    }
    
    @SuppressWarnings("unchecked")
    @Override
	public List<ProductEntity> findAllProductEntity(){
    	return productDaoLocal.findAllProductEntity();
    }
    
    
    @Override
    public void deleteProductEntity(ProductEntity productEntity2){
    	productDaoLocal.deleteProductEntity(productEntity2);
    }
    @Override
    public ProductEntity findProductEntityById(long productId) {
    	//return productDaoLocal.findProductEntityById(productId);
    	return null;
    }
    @Override
    public void updateProductEntity(ProductEntity productEntity) {
    	productDaoLocal.updateProductEntity(productEntity);
    }
    
	@Override
    public List<ProductEntity> findAllProductEntityBySeller(MoblEntity moblEntity) {
    	return  productDaoLocal.findAllProductEntityBySeller(moblEntity);
    }
	
    @Override
    public Map<ProductEntity, Object> findAllProductBySeller2(MoblEntity moblEntity){
    	//return productDaoLocal.findAllProductBySeller2(moblEntity);
    	return null;
    }
}
