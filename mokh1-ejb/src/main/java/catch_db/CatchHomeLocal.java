package catch_db;

import java.util.List;

import javax.ejb.Local;

import entity.HomeEntity;
import sevice.HomeServiceLocal;

@Local
public interface CatchHomeLocal {


	List<HomeEntity> getHomeEntities();

}
