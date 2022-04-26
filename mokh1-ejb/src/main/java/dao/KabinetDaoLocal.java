package dao;

import javax.ejb.Local;

import entity.Kabinet;

@Local
public interface KabinetDaoLocal {

	void insertToKabinet(Kabinet kabinet) throws Exception;

}
