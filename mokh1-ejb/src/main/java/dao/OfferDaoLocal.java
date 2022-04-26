package dao;

import java.util.List;

import javax.ejb.Local;

import entity.MoblEntity;
import entity.OfferEntity;
import entity.ProductEntity;

@Local
public interface OfferDaoLocal {

	void insertToOffer(OfferEntity offerEntity) throws Exception;

	OfferEntity findUserByToken(String token) throws Exception;

	List<OfferEntity> findAllByByProduct(ProductEntity productEntity);

	int findAllCountByMerchant(MoblEntity moblEntity);

	List<OfferEntity> findAllByMerchant(MoblEntity moblEntity);

}
