package dao;

import javax.ejb.Local;

import entity.KomodBoofeKetabkhaneJakafshi;

@Local
public interface KomodBoofeKetabkhaneJakafshiDaoLocal {

	void insertToKomodBoofeKetabkhaneJakafshi(KomodBoofeKetabkhaneJakafshi komodBoofeKetabkhaneJakafshi)
			throws Exception;

}
