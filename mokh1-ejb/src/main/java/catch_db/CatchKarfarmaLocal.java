package catch_db;

import java.util.List;

import javax.ejb.Local;

import entity.JobKarfarmaEntity;

@Local
public interface CatchKarfarmaLocal {

	List<JobKarfarmaEntity> getKarfarmas();

}
