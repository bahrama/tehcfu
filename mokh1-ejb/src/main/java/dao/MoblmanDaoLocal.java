package dao;

import javax.ejb.Local;

import entity.Moblman;

@Local
public interface MoblmanDaoLocal {

	void insertToMoblman(Moblman moblman) throws Exception;

}
