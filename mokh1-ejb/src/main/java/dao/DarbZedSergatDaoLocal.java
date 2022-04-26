package dao;

import javax.ejb.Local;

import entity.DarbZedSergat;

@Local
public interface DarbZedSergatDaoLocal {

	void insertToDarbZedSergat(DarbZedSergat darbZedSergat) throws Exception;

}
