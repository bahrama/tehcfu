package dao;

import java.util.List;

import javax.ejb.Local;

import entity.MoblEntity;
import entity.ProductEntity;
import entity.SefareshEntity;

@Local
public interface SefareshDaoLocal {

	void insertToSefaresh(SefareshEntity sefareshEntity) throws Exception;

	List<SefareshEntity> findAllSefareshByUser(MoblEntity moblEntity);

	void deleteSefaresh(SefareshEntity sefareshEntity);

	SefareshEntity findSefareshById(long sefareshId);

	void updateSefaresh(SefareshEntity sefareshEntity) throws Exception;

	List<SefareshEntity> findAllSefareshByUser(ProductEntity product);

	List<SefareshEntity> findAllSefareshByMerchant(MoblEntity moblEntity);

	int findAllCountSefareshByMerchant(MoblEntity moblEntity);

	int findCountAllSefareshByUser(MoblEntity moblEntity);

}
