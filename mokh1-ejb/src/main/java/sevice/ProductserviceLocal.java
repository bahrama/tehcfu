package sevice;

import java.util.List;

import javax.ejb.Local;

import entity.MoblEntity;
import entity.ProductEntity;

@Local
public interface ProductserviceLocal {

	void insertToProduct(ProductEntity productEntity) throws Exception;

	List<ProductEntity> findAllProductEntity();

	void deleteProductEntity(ProductEntity productEntity2);

	ProductEntity findProductEntityById(long productId);

	void updateProductEntity(ProductEntity productEntity);

	List<ProductEntity> findAllProductEntityBySeller(MoblEntity moblEntity);

}
