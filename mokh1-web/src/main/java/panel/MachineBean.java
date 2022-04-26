//package panel;
//
//import java.io.Serializable;
//import java.util.Date;
//
//import javax.enterprise.context.RequestScoped;
//import javax.faces.context.FacesContext;
//import javax.faces.view.ViewScoped;
//import javax.inject.Inject;
//import javax.inject.Named;
//import javax.validation.constraints.Size;
//
//import entity.MachineEntity;
//import entity.RentEntity;
//import sevice.MachineServiceLocal;
//
//@Named
//@ViewScoped
//public class MachineBean implements Serializable {
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 1L;
//	@Inject
//	private TempBean tempBean;
//	@Inject
//	private FacesContext facesContext;
//	@Inject
//	private MachineServiceLocal machineServiceLocal; 
//	@Size(max = 200, min = 2, message = "حداقل ۲ و حداکثر ۲۰۰")
//	private String machineName;
//	@Size(max = 100, min = 2, message = "حداقل ۲ و حداکثر ۱۰۰")
//	private String contry;
//	@Size(max = 100, min = 2, message = "حداقل ۲ و حداکثر ۱۰۰")
//	private String brand;
//	@Size(max = 100, min = 2, message = "حداقل ۲ و حداکثر ۱۰۰")
//	private String saleTolid;
//	@Size(max = 20, min = 2, message = "حداقل ۲ و حداکثر ۲۰")
//	private String vaziat;
//	@Size(max = 1000, min = 2, message = "حداقل ۲ و حداکثر ۱۰۰۰")
//	private String moshakhasat;
//	@Size(max = 20, min = 2, message = "حداقل ۲ و حداکثر ۲۰")
//	private String mablag;
//	@Size(max = 100, min = 2, message = "حداقل ۲ و حداکثر ۱۰۰")
//	private String mahaleForosh;
//
//	public String getMachineName() {
//		return machineName;
//	}
//
//	public void setMachineName(String machineName) {
//		this.machineName = machineName;
//	}
//
//	public String getContry() {
//		return contry;
//	}
//
//	public void setContry(String contry) {
//		this.contry = contry;
//	}
//
//	public String getBrand() {
//		return brand;
//	}
//
//	public void setBrand(String brand) {
//		this.brand = brand;
//	}
//
//	public String getSaleTolid() {
//		return saleTolid;
//	}
//
//	public void setSaleTolid(String saleTolid) {
//		this.saleTolid = saleTolid;
//	}
//
//	public String getVaziat() {
//		return vaziat;
//	}
//
//	public void setVaziat(String vaziat) {
//		this.vaziat = vaziat;
//	}
//
//	public String getMoshakhasat() {
//		return moshakhasat;
//	}
//
//	public void setMoshakhasat(String moshakhasat) {
//		this.moshakhasat = moshakhasat;
//	}
//
//	public String getMablag() {
//		return mablag;
//	}
//
//	public void setMablag(String mablag) {
//		this.mablag = mablag;
//	}
//
//	public String getMahaleForosh() {
//		return mahaleForosh;
//	}
//
//	public void setMahaleForosh(String mahaleForosh) {
//		this.mahaleForosh = mahaleForosh;
//	}
//
//	public void insertToMachine() {
//		MachineEntity machineEntity = new MachineEntity();
//		machineEntity.setBrand(brand);
//		machineEntity.setContry(contry);
//		machineEntity.setMablag(mablag);
//		machineEntity.setMachine(tempBean.getMoblEntity());
//		machineEntity.setMachineName(machineName);
//		machineEntity.setMahaleForosh(mahaleForosh);
//		machineEntity.setMoshakhasat(moshakhasat);
//		machineEntity.setSaleTolid(saleTolid);
//		machineEntity.setVaziat(vaziat);
//		machineEntity.setDate(new Date());
//		machineServiceLocal.insertToMachine(machineEntity);
//		facesContext.getPartialViewContext().getEvalScripts().add(
//				"swal({title: 'موفق!',type: 'success', text: 'آگهی شما با موفقیت ثبت گردید پس از بررسی در سایت قرار داده می شود', confirmButtonColor: '#469408',})");
//	}
//}
