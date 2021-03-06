package sevice;

import java.util.List;

import javax.ejb.Local;

import entity.JobKarfarmaEntity;



@Local
public interface JobKarfarmaServiceLocal {

	void insertToKarfarmaEntity(JobKarfarmaEntity jobKarfarmaEntity);

	List<JobKarfarmaEntity> findAllKarfarma();

	JobKarfarmaEntity findKarfarmaById(long karfarmaId);

	void updateKarfarma(JobKarfarmaEntity jobKarfarmaEntity);

	void deleteKarfarma(JobKarfarmaEntity jobKarfarmaEntity);


}
