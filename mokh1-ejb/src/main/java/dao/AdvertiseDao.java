package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entity.AdvertiseEntity;
import entity.AyeneVConsole;
import entity.JobKarfarmaEntity;
import entity.JobKarjoEntity;
import entity.MachineEntity;
import entity.MoblEntity;
import entity.ProductEntity;
import entity.RentEntity;

/**
 * Session Bean implementation class AdvertiseDao
 */
@Stateless
public class AdvertiseDao implements AdvertiseDaoLocal {

    /**
     * Default constructor. 
     */
    public AdvertiseDao() {
        // TODO Auto-generated constructor stub
    }
    
    @PersistenceContext(unitName="aliUnit")
    private EntityManager entityManager;
    
    @Override
    public void insertToAdvertise(AdvertiseEntity advertise) throws Exception {
    	try {
    	entityManager.persist(advertise);
    	}catch (Exception e) {
			throw new Exception("roleback for repetetly data");
		}
    	}
    
    @Override
    public void insertToKarjo(JobKarjoEntity jobKarjoEntity) throws Exception {
    	try {
    	entityManager.persist(jobKarjoEntity);
    	}catch (Exception e) {
			throw new Exception("roleback for repetetly data");
		}
    	}
    
    @Override
    public void insertToKarfarma(JobKarfarmaEntity jobKarfarmaEntity) throws Exception {
    	try {
    	entityManager.persist(jobKarfarmaEntity);
    	}catch (Exception e) {
			throw new Exception("roleback for repetetly data");
		}
    	}
    
    @Override
    public void insertToRent(RentEntity rentEntity) throws Exception {
    	try {
    	entityManager.persist(rentEntity);
    	}catch (Exception e) {
			throw new Exception("roleback for repetetly data");
		}
    	}
    
    @Override
    public void insertToMachine(MachineEntity machineEntity) throws Exception {
    	try {
    	entityManager.persist(machineEntity);
    	}catch (Exception e) {
			throw new Exception("roleback for repetetly data");
		}
    	}
    @SuppressWarnings("unchecked")
    @Override
 	public List<AdvertiseEntity> findAllAdvertise(){
     	return entityManager.createNamedQuery("findAllAdvertiseEntityEntity").getResultList();
     }
    
    @SuppressWarnings("unchecked")
	public List<AdvertiseEntity> findAllAdvertiseByType(String advertisType){
    	return  entityManager.createNamedQuery("findByadvertiseTypeEntityId").setParameter("v_advertiseType", advertisType).getResultList();
    }
    
    public JobKarfarmaEntity findJobKarfarmaById(long advertiseId) {
    	return (JobKarfarmaEntity) entityManager.createNamedQuery("findKarfarmaById").setParameter("v_adveriseId", advertiseId).getSingleResult();
    }
    
    public JobKarjoEntity findJobKarjoById(long advertiseId) {
    	return (JobKarjoEntity) entityManager.createNamedQuery("findKarjoById").setParameter("v_adveriseId", advertiseId).getSingleResult();
    }
    
    public MachineEntity findMachineById(long advertiseId) {
    	return (MachineEntity) entityManager.createNamedQuery("findMachineById").setParameter("v_adveriseId", advertiseId).getSingleResult();
    }
    
    public RentEntity findfindRentById(long advertiseId) {
    	return (RentEntity) entityManager.createNamedQuery("findRentById").setParameter("v_adveriseId", advertiseId).getSingleResult();
    }
    
    @SuppressWarnings("unchecked")
	public List<JobKarfarmaEntity> findAllJobKarfarmaEntity(){
    	return entityManager.createNamedQuery("findAllKarfarma").getResultList();
    }
    
    @SuppressWarnings("unchecked")
	public List<JobKarjoEntity> findAllJobKarjoEntity(){
    	return entityManager.createNamedQuery("findAllkarjo").getResultList();
    }
    
    @SuppressWarnings("unchecked")
	public List<MachineEntity> findAllMachineEntity(){
    	return entityManager.createNamedQuery("findAllMachine").getResultList();
    }
    
    @SuppressWarnings("unchecked")
	public List<RentEntity> findAllRentEntity(){
    	return entityManager.createNamedQuery("findAllRent").getResultList();
    }
    
    
    @Override
    public Map<AdvertiseEntity, Object> findAllAdvertiseByTypeMap(String advertiseType){
    	Map<AdvertiseEntity, Object> map = new HashMap<AdvertiseEntity, Object>();
    	for (AdvertiseEntity advertiseEntity : findAllAdvertiseByType(advertiseType)) {
        	if(advertiseType.equals("karfarma"))
        		map.put(advertiseEntity, findJobKarfarmaById(advertiseEntity.getAdveriseId()));
        	if(advertiseType.equals("karjo"))
        		map.put(advertiseEntity, findJobKarjoById(advertiseEntity.getAdveriseId()));
        	if(advertiseType.equals("machin"))
        		map.put(advertiseEntity, findMachineById(advertiseEntity.getAdveriseId()));
        	if(advertiseType.equals("rent"))
        		map.put(advertiseEntity, findfindRentById(advertiseEntity.getAdveriseId()));
		}    	

    	return map;
    }
    @Override
    public AdvertiseEntity findAdvertiseById(long advertiseId) {
    	return  (AdvertiseEntity) entityManager.createNamedQuery("findByAdvertiseEntityId").setParameter("v_adveriseId", advertiseId).getResultList();
    }
     @Override
     public Object findAdvertiseDetailById(long advertiseId, String advertiseType)
     {
     	if(advertiseType.equals("karfarma"))
    		return findJobKarfarmaById(advertiseId);
     	else if(advertiseType.equals("karjo"))
    		return findJobKarjoById(advertiseId);
     	else if(advertiseType.equals("machin"))
    		return findMachineById(advertiseId);
     	else if(advertiseType.equals("rent"))
    		return findfindRentById(advertiseId);
     	else 
     		return null;
		
     }
     
     @Override
     public void updateAdvertise(AdvertiseEntity advertiseEntity) {
     	entityManager.merge(advertiseEntity);
     }
}
