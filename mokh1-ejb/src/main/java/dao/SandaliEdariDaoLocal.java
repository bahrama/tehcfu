package dao;

import javax.ejb.Local;

import entity.SandaliEdari;

@Local
public interface SandaliEdariDaoLocal {

	void insertToSandaliEdari(SandaliEdari sandaliEdari) throws Exception;

}
