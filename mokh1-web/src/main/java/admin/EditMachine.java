package admin;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import entity.MachineEntity;
import sevice.MachineServiceLocal;

@Named
@ViewScoped
public class EditMachine implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EditMachine() {
		// TODO Auto-generated constructor stub
	}
	@Inject
	private MachineServiceLocal machineServiceLocal;
	
	private MachineEntity machineEntity=new MachineEntity();
	
	private boolean taeed;

	public MachineEntity getMachineEntity() {
		return machineEntity;
	}

	public void setMachineEntity(MachineEntity machineEntity) {
		this.machineEntity = machineEntity;
	}

	public boolean isTaeed() {
		return taeed;
	}

	public void setTaeed(boolean taeed) {
		this.taeed = taeed;
	}
	
	public List<MachineEntity> findAllMachine(){
		return machineServiceLocal.findAllMachineEntity();
	}
	
	public void updateMachine() {
		MachineEntity machineEntity=this.machineEntity;
		machineEntity.setTaeed(taeed);
		machineServiceLocal.updateMachineEntity(machineEntity);
	}
	

}
