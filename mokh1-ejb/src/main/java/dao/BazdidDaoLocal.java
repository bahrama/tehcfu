package dao;

import javax.ejb.Local;

import entity.BazdidEntity;

@Local
public interface BazdidDaoLocal {

	void insertToBazdid(BazdidEntity bazdidEntity);

	BazdidEntity findBazdidEntityById(long bazdidId) throws Exception;

	void updateBazdidEntity(BazdidEntity bazdidEntity);

}
