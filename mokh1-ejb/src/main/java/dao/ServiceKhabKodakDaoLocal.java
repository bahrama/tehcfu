package dao;

import javax.ejb.Local;

import entity.ServiceKhabKodak;

@Local
public interface ServiceKhabKodakDaoLocal {

	void insertToServiceKhabKodak(ServiceKhabKodak serviceKhabKodak) throws Exception;

}
