package admin;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import entity.MoblEntity;
import sevice.SellerServiceLocal;
@Named
@RequestScoped
public class EditMap {

	public EditMap() {
		// TODO Auto-generated constructor stub
	}
	@Inject
	private SellerServiceLocal sellerServiceLocal;
	
	private String lat;
	private String lng;

	
	




	public String getLat() {
		return lat;
	}







	public void setLat(String lat) {
		this.lat = lat;
	}







	public String getLng() {
		return lng;
	}







	public void setLng(String lng) {
		this.lng = lng;
	}







	public void changePosition(long id) {
		FacesContext context = FacesContext.getCurrentInstance();
		MoblEntity moblEntity=new MoblEntity();
		try {
			moblEntity=sellerServiceLocal.findSellerById(id);
			moblEntity.setLat(Double.valueOf(lat));
			moblEntity.setLng(Double.valueOf(lng));
			sellerServiceLocal.updateSeller(moblEntity);
			context.addMessage(null, new FacesMessage("با موفقیت آپدیت گردید."));
		} catch (Exception e) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "error", "error"));
			e.printStackTrace();
		}

	}
	
	
}
