package dao;

import javax.ejb.Local;

import entity.Panjare;

@Local
public interface PanjareDaoLocal {

	void insertToPanjare(Panjare panjare) throws Exception;

}
