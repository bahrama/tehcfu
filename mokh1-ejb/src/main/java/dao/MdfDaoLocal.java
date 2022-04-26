package dao;

import javax.ejb.Local;

import entity.Mdf;

@Local
public interface MdfDaoLocal {

	void insertToMdf(Mdf mdf) throws Exception;

}
