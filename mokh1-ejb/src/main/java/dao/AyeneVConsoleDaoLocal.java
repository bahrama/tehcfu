package dao;

import javax.ejb.Local;

import entity.AyeneVConsole;

@Local
public interface AyeneVConsoleDaoLocal {

	void insertToAyeneVConsole(AyeneVConsole ayeneVConsole) throws Exception;

}
