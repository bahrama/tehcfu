package dao;

import javax.ejb.Local;

import entity.ServiceKhab1;

@Local
public interface ServiceKhab1DaoLocal {

	void insertToServiceKhab1(ServiceKhab1 serviceKhab1) throws Exception;

}
