package dao;

import javax.ejb.Local;

import entity.DarbChobi;

@Local
public interface DarbChobiDaoLocal {

	void insertToDarbChobi(DarbChobi darbChobi) throws Exception;

}
