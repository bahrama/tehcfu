package dao;

import java.util.List;
import java.util.Map;

import javax.ejb.Local;

import entity.MoblEntity;
import entity.ProductEntity;

@Local
public interface ProductDaoLocal {

	void insertToProduct(ProductEntity productEntity) throws Exception;

	List<ProductEntity> findAllProductEntity();

	void deleteProductEntity(ProductEntity productEntity2);

	ProductEntity findProductEntityById(long productId);

	void updateProductEntity(ProductEntity productEntity);

	List<ProductEntity> findAllProductEntityBySeller(MoblEntity moblEntity);

	Map<ProductEntity, Object> findAllProductBySeller2(MoblEntity moblEntity);

	Object getProductDetail();

	ProductEntity findProductOnlyById(long productId);


}
