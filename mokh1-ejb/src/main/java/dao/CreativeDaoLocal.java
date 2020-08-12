package dao;

import java.util.List;

import javax.ejb.Local;

import entity.CreativeEntity;

@Local
public interface CreativeDaoLocal {

	void insertCreativeEntity(CreativeEntity creativeEntity);

	List<CreativeEntity> findAllCreativeEntity();

	CreativeEntity findCreativeEntityById(long id) throws Exception;

	void updateCreativeEntity(CreativeEntity creativeEntity) throws Exception;

	void deleteCreativeEntity(CreativeEntity creativeEntity);

}
