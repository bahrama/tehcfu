package dao;

import java.util.List;

import javax.ejb.Local;

import entity.HomeEntity;

@Local
public interface HomeDaoLocal {

	void insertHomeEntity(HomeEntity homeEntity);

	List<HomeEntity> findAllHomeEntity();

	HomeEntity findHomeEntityById(long id) throws Exception;

	void updateHomeEntity(HomeEntity homeEntity) throws Exception;

	void deleteSeller(HomeEntity homeEntity);

	HomeEntity findHomeEntityByName(String name) throws Exception;

	List<HomeEntity> findHomeEntityByNameList(String name) throws Exception;

}
