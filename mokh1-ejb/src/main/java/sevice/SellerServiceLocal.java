package sevice;

import java.util.List;

import javax.ejb.Local;

import entity.MoblEntity;

@Local
public interface SellerServiceLocal {

	void insertSeller(MoblEntity moblEntity) throws Exception;

	List<MoblEntity> findAllSeller();

	MoblEntity findSellerById(long id) throws Exception;

	void updateSeller(MoblEntity moblEntity) throws Exception;

	void deleteSeller(MoblEntity moblEntity);

	MoblEntity findSellerByMobile(String mobile) throws Exception;

	MoblEntity findSellerByToken(String token) throws Exception;

	MoblEntity findSellerByNameEng(String nameEng) throws Exception;

	List<MoblEntity> findSellersByPanel(String panel) throws Exception;

	List<MoblEntity> findSellerByNamePerLike(String nameper) throws Exception;

	List<MoblEntity> findSellerByFilter(String text, String filter) throws Exception;

	List<MoblEntity> findSellersByMojtame(String mojtame) throws Exception;

	List<MoblEntity> findSellerByFilterE(String text, String filter) throws Exception;

}
