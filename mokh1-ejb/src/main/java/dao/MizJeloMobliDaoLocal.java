package dao;

import javax.ejb.Local;

import entity.MizJeloMobli;

@Local
public interface MizJeloMobliDaoLocal {

	void insertToMizJeloMobli(MizJeloMobli mizJeloMobli) throws Exception;

}
