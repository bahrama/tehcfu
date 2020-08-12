package sevice;

import java.util.List;

import javax.ejb.Local;

import entity.RentEntity;


@Local
public interface RentServiceLocal {

	void insertToRent(RentEntity rentEntity);

	List<RentEntity> findAllRent();

	void deleteRent(RentEntity rentEntity2);

	RentEntity findRentById(long rentId);

	void updateRent(RentEntity rentEntity);

}
