package dao;

import javax.ejb.Local;

import entity.MizEdari;

@Local
public interface MizEdariDaoLocal {

	void insertToMizEdari(MizEdari mizEdari) throws Exception;

}
