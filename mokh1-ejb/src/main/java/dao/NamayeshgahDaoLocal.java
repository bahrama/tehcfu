package dao;

import java.util.List;

import javax.ejb.Local;

import entity.NamayeshgahEntity;

@Local
public interface NamayeshgahDaoLocal {

	void insertNamayeshgahEntity(NamayeshgahEntity namayeshgahEntity);

	List<NamayeshgahEntity> findAllNamayeshgahEntity();

	NamayeshgahEntity findNamayeshgahEntityById(long id) throws Exception;

	void updateNamayeshgahEntity(NamayeshgahEntity namayeshgahEntity) throws Exception;

	void deleteNamayeshgahEntity(NamayeshgahEntity namayeshgahEntity);

}
