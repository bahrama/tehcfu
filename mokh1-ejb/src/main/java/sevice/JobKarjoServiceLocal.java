package sevice;

import java.util.List;

import javax.ejb.Local;

import entity.JobKarjoEntity;


@Local
public interface JobKarjoServiceLocal {

	void insertToKarjoEntity(JobKarjoEntity jobKarjoEntity);

	List<JobKarjoEntity> findAllKarjo();

	void deleteKarjo(JobKarjoEntity karjoEntity);

	JobKarjoEntity findKarjoById(long karjoId);

	void updateKarjo(JobKarjoEntity jobKarjoEntity);

}
