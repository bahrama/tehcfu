//package admin;
//
//import java.io.Serializable;
//import java.util.List;
//
//import javax.enterprise.context.SessionScoped;
//import javax.inject.Inject;
//import javax.inject.Named;
//
//import entity.RentEntity;
//import sevice.RentServiceLocal;
//
//@Named
//@SessionScoped
//public class EditRent implements Serializable {
//
//	public EditRent() {
//		// TODO Auto-generated constructor stub
//	}
//	@Inject
//	private RentServiceLocal rentServiceLocal;
//	
//	private RentEntity rentEntity;
//	
//	private boolean checkRent;
//
//	public RentEntity getRentEntity() {
//		return rentEntity;
//	}
//
//	public void setRentEntity(RentEntity rentEntity) {
//		this.rentEntity = rentEntity;
//	}
//
//	public boolean isCheckRent() {
//		return checkRent;
//	}
//
//	public void setCheckRent(boolean checkRent) {
//		this.checkRent = checkRent;
//	}
//	
//	public List<RentEntity> findAllRent(){
//		return rentServiceLocal.findAllRent();
//	}
//	
//	public void updateRent() {
//		RentEntity rentEntity=this.rentEntity;
//		rentEntity.setShow(checkRent);
//		rentServiceLocal.updateRent(rentEntity);
//	}
//	
//
//}
