package sevice;

import java.util.List;

import javax.ejb.Local;

import entity.TamdidEntity;

@Local
public interface TamdidServiceLocal {

	void insertToTamdid(TamdidEntity tamdidEntity);

	List<TamdidEntity> findAllTamdid();

	void deleteTamdid(TamdidEntity tamdidEntity2);

	TamdidEntity findTamdidById(long id);

	void updateTamdid(TamdidEntity tamdidEntity);

}
