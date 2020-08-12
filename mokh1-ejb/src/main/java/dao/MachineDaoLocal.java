package dao;

import java.util.List;

import javax.ejb.Local;

import entity.MachineEntity;
import entity.RentEntity;

@Local
public interface MachineDaoLocal {

	void insertToMachine(MachineEntity machineEntity);

	List<MachineEntity> findAllMachineEntity();

	void deleteMachineEntity(MachineEntity machineEntity2);

	RentEntity findMachineById(long machineId);

	void updateMachineEntity(MachineEntity machineEntity);

}
