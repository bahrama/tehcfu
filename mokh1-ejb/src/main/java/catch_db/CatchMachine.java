package catch_db;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;
import javax.ejb.AccessTimeout;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.inject.Inject;

import entity.MachineEntity;
import entity.RentEntity;
import sevice.MachineServiceLocal;

/**
 * Session Bean implementation class CatchMachine
 */
@Singleton
public class CatchMachine implements CatchMachineLocal {

    /**
     * Default constructor. 
     */
    public CatchMachine() {
        // TODO Auto-generated constructor stub
    }
    @Inject
    private MachineServiceLocal machineServiceLocal;

    private List<MachineEntity> machineEntities=new ArrayList<MachineEntity>();

    @Override
	public List<MachineEntity> getMachineEntities() {
		return machineEntities;
	}
    
	@PostConstruct
    public void init() {
    	for (MachineEntity machineEntity:machineServiceLocal.findAllMachineEntity()) {
			if(machineEntity.isTaeed()==true)
                this.machineEntities.add(machineEntity);
    	}
    	
    }
    
    
	@Schedule(hour = "*", minute = "*/1", persistent = false)
	@AccessTimeout(value = 4, unit = TimeUnit.SECONDS)
	public void ejra(){
		this.machineEntities.clear();
    	for (MachineEntity machineEntity:machineServiceLocal.findAllMachineEntity()) {
			if(machineEntity.isTaeed()==true)
                this.machineEntities.add(machineEntity);
    	}
	}
    
    
    
    
    
    
}
