package ui;

import java.io.Serializable;
import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import dao.AdvertiseDaoLocal;
import entity.AdvertiseEntity;
import entity.JobKarfarmaEntity;
import entity.JobKarjoEntity;
import entity.MachineEntity;
import entity.RentEntity;

@ViewScoped
@Named
public class AdvertiseUiBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AdvertiseUiBean() {
		// TODO Auto-generated constructor stub
	}
	
	private JobKarfarmaEntity jobKarfarmaEntity;
	private JobKarjoEntity jobKarjoEntity;
	private MachineEntity machineEntity;
	private RentEntity rentEntity;
	private AdvertiseEntity advertiseEntity;
	
	

	public JobKarfarmaEntity getJobKarfarmaEntity() {
		return jobKarfarmaEntity;
	}

	public void setJobKarfarmaEntity(JobKarfarmaEntity jobKarfarmaEntity) {
		this.jobKarfarmaEntity = jobKarfarmaEntity;
	}

	public JobKarjoEntity getJobKarjoEntity() {
		return jobKarjoEntity;
	}

	public void setJobKarjoEntity(JobKarjoEntity jobKarjoEntity) {
		this.jobKarjoEntity = jobKarjoEntity;
	}

	public MachineEntity getMachineEntity() {
		return machineEntity;
	}

	public void setMachineEntity(MachineEntity machineEntity) {
		this.machineEntity = machineEntity;
	}

	public RentEntity getRentEntity() {
		return rentEntity;
	}

	public void setRentEntity(RentEntity rentEntity) {
		this.rentEntity = rentEntity;
	}

	public AdvertiseEntity getAdvertiseEntity() {
		return advertiseEntity;
	}

	public void setAdvertiseEntity(AdvertiseEntity advertiseEntity) {
		this.advertiseEntity = advertiseEntity;
	}

	@Inject
	private AdvertiseDaoLocal advertiseDaoLocal;

	 public Map<AdvertiseEntity, Object> findAllAdvertiseByTypeMap(String advertiseType){
		 return advertiseDaoLocal.findAllAdvertiseByTypeMap(advertiseType);
	 }
	 
	 public Object findAdvertiseDetailById(long advertiseId, String advertiseType) {
		 Object object = advertiseDaoLocal.findAdvertiseDetailById(advertiseId, advertiseType);
		 if(advertiseType.equals("karfarma"))
		 {
			this.jobKarfarmaEntity = (JobKarfarmaEntity) object;
			return jobKarfarmaEntity;
		 }
		 else if (advertiseType.equals("karjo")) {
				this.jobKarjoEntity = (JobKarjoEntity) object;
				return jobKarjoEntity;
		}
		 else if (advertiseType.equals("machin")) {
				this.machineEntity = (MachineEntity) object;
				return machineEntity;
		}
		 else if (advertiseType.equals("rent")) {
				this.rentEntity = (RentEntity) object;
				return rentEntity;
		}
		 else
			 return null;
	 }
	 
	 public AdvertiseEntity findAdvertiseById(long advertiseId) {
		 this.advertiseEntity = advertiseDaoLocal.findAdvertiseById(advertiseId);
		 return advertiseEntity;
	 }
	
}
