package catch_db;

import java.util.List;

import javax.ejb.Local;

import entity.MachineEntity;

@Local
public interface CatchMachineLocal {

	List<MachineEntity> getMachineEntities();

}
