package dao;

import javax.ejb.Local;

import entity.Monabat;

@Local
public interface MonabatDaoLocal {

	void insertToMonabat(Monabat monabat) throws Exception;

}
