package sevice;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import dao.MachineDaoLocal;
import entity.MachineEntity;
import entity.RentEntity;

/**
 * Session Bean implementation class MachineService
 */
@Stateless
public class MachineService implements MachineServiceLocal {

    /**
     * Default constructor. 
     */
    public MachineService() {
        // TODO Auto-generated constructor stub
    }
    @Inject
    private MachineDaoLocal machineDaoLocal; 
    
    @Override
    public void insertToMachine(MachineEntity machineEntity) {
    	machineDaoLocal.insertToMachine(machineEntity);
    }
    
    @SuppressWarnings("unchecked")
    @Override
	public List<MachineEntity> findAllMachineEntity(){
    	return machineDaoLocal.findAllMachineEntity();
    }
    
    
    @Override
    public void deleteMachineEntity(MachineEntity machineEntity2){
    	machineDaoLocal.deleteMachineEntity(machineEntity2);
    }
    @Override
    public RentEntity findMachineById(long machineId) {
    	return machineDaoLocal.findMachineById(machineId);
    }
    @Override
    public void updateMachineEntity(MachineEntity machineEntity) {
    	machineDaoLocal.updateMachineEntity(machineEntity);
    }

}
