package dao;

import java.util.List;

import javax.ejb.Local;

import entity.TaminProductEntity;

@Local
public interface TaminProductDaoLocal {

	void insertTaminProduct(TaminProductEntity taminProductEntity);

	List<TaminProductEntity> findAllTaminProduct();

	TaminProductEntity findTaminProductById(long id) throws Exception;

	void updateTaminProduct(TaminProductEntity taminProductEntity) throws Exception;

	void deleteTaminProduct(TaminProductEntity taminProductEntity);

}
