package dao;

import javax.ejb.Local;

import entity.MizNaharKhori;

@Local
public interface MizNaharKhoriDaoLocal {

	void insertToMizNaharKhori(MizNaharKhori mizNaharKhori) throws Exception;

}
