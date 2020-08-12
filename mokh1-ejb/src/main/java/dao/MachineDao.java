package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entity.MachineEntity;
import entity.RentEntity;

/**
 * Session Bean implementation class MachineDao
 */
@Stateless
public class MachineDao implements MachineDaoLocal {

    /**
     * Default constructor. 
     */
    public MachineDao() {
        // TODO Auto-generated constructor stub
    }
    
    @PersistenceContext(unitName="aliUnit")
    private EntityManager entityManager;
    @Override
    public void insertToMachine(MachineEntity machineEntity) {
    	entityManager.persist(machineEntity);
    }
    
    @SuppressWarnings("unchecked")
    @Override
	public List<MachineEntity> findAllMachineEntity(){
    	return entityManager.createNamedQuery("findAllMachine").getResultList();
    }
    
    
    @Override
    public void deleteMachineEntity(MachineEntity machineEntity2){
    	MachineEntity machineEntity=new MachineEntity();
    	machineEntity=entityManager.merge(machineEntity2);
    	entityManager.remove(machineEntity);
    }
    @Override
    public RentEntity findMachineById(long machineId) {
    	return (RentEntity) entityManager.createNamedQuery("findMachineById").setParameter("v_machineId", machineId).getSingleResult();
    }
    @Override
    public void updateMachineEntity(MachineEntity machineEntity) {
    	entityManager.merge(machineEntity);
    }


}
