package dao;

import java.util.List;

import javax.ejb.Local;

import entity.MobasheratEntity;

@Local
public interface MobasheratDaoLocal {

	void insertToMobasherat(MobasheratEntity mobasheratEntity);

	List<MobasheratEntity> findAllMobasherat();

	void deleteMobasherat(MobasheratEntity mobasheratEntity2);

	MobasheratEntity findMobasheratById(long id);

	void updateMobasherat(MobasheratEntity mobasheratEntity);

}
