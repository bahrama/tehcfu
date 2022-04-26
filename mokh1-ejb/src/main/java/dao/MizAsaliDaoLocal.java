package dao;

import javax.ejb.Local;

import entity.MizAsali;

@Local
public interface MizAsaliDaoLocal {

	void insertToMizAsali(MizAsali mizAsali) throws Exception;

}
