package dao;

import javax.ejb.Local;

import entity.MizTv;

@Local
public interface MizTvDaoLocal {

	void insertToMizTv(MizTv mizTv) throws Exception;

}
