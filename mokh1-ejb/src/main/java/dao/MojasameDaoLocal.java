package dao;

import javax.ejb.Local;

import entity.Mojasame;

@Local
public interface MojasameDaoLocal {

	void insertToMojasame(Mojasame mojasame) throws Exception;

}
