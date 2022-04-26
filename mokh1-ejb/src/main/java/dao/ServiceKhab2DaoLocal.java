package dao;

import javax.ejb.Local;

import entity.ServiceKhab2;

@Local
public interface ServiceKhab2DaoLocal {

	void insertToServiceKhab2(ServiceKhab2 serviceKhab2) throws Exception;

}
