package dao;

import java.util.List;
import java.util.Map;

import javax.ejb.Local;

import entity.AdvertiseEntity;
import entity.JobKarfarmaEntity;
import entity.JobKarjoEntity;
import entity.MachineEntity;
import entity.RentEntity;

@Local
public interface AdvertiseDaoLocal {

	void insertToAdvertise(AdvertiseEntity advertise) throws Exception;

	void insertToKarjo(JobKarjoEntity jobKarjoEntity) throws Exception;

	void insertToKarfarma(JobKarfarmaEntity jobKarfarmaEntity) throws Exception;

	void insertToRent(RentEntity rentEntity) throws Exception;

	void insertToMachine(MachineEntity machineEntity) throws Exception;

	Map<AdvertiseEntity, Object> findAllAdvertiseByTypeMap(String advertiseType);

	List<AdvertiseEntity> findAllAdvertise();

	AdvertiseEntity findAdvertiseById(long advertiseId);

	Object findAdvertiseDetailById(long advertiseId, String advertiseType);

	void updateAdvertise(AdvertiseEntity advertiseEntity);

}
