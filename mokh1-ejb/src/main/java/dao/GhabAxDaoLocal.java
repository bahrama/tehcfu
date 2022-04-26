package dao;

import javax.ejb.Local;

import entity.GhabAx;

@Local
public interface GhabAxDaoLocal {

	void insertToGhabAx(GhabAx ghabAx) throws Exception;

}
