package dao;


import java.util.List;

import javax.ejb.Local;

import entity.Shekayat1;


@Local
public interface ShekayatDaoLocal {

	void inserToShekayat(Shekayat1 shekayat1);

	List<Shekayat1> findAllShekayat();

	Shekayat1 findShekayatById(long shakiId) throws Exception;

	void shekayatUpdate(Shekayat1 shekayat1);

	List<Shekayat1> findAllShekayatOrder();

	void deleteShekayatEntity(Shekayat1 shekayat1);

}
