package catch_db;

import java.util.List;

import javax.ejb.Local;

import entity.RentEntity;

@Local
public interface CatchRentLocal {

	List<RentEntity> getRents();

}
