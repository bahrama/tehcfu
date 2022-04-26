package adminNew;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.map.PointSelectEvent;
import org.primefaces.model.map.LatLng;

import entity.MoblEntity;
import sevice.SellerServiceLocal;

@Named
@ViewScoped
public class AdminMapBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AdminMapBean() {
		// TODO Auto-generated constructor stub
	}
	@Inject
	private SellerServiceLocal sellerServiceLocal;
	@Inject
	private AdminProfile adminProfile;

	private String lat;
	private String lng;
	private UIComponent latComponent;

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
	public AdminProfile getAdminProfile() {
		return adminProfile;
	}
	public void setAdminProfile(AdminProfile adminProfile) {
		this.adminProfile = adminProfile;
	}
	
    public UIComponent getLatComponent() {
		return latComponent;
	}
	public void setLatComponent(UIComponent latComponent) {
		this.latComponent = latComponent;
	}
	public void onPointSelect2(PointSelectEvent event) {
        LatLng latlng = event.getLatLng();
        this.lat=String.valueOf(latlng.getLat());
        this.lng=String.valueOf(latlng.getLng());
    }
    
	public void updateMap() {
		try {
		if(lat.equals(""))
		throw new Exception("nullLat");
		this.adminProfile.getMoblEntity().setLat(Double.parseDouble(lat));
		this.adminProfile.getMoblEntity().setLng(Double.parseDouble(lng));
		
			sellerServiceLocal.updateSeller(this.adminProfile.getMoblEntity());
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("*****************************با موفقیت وارد گردید************************"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			if(e.getMessage().equals("nullLat"))
			FacesContext.getCurrentInstance().addMessage(latComponent.getClientId(), new FacesMessage(FacesMessage.SEVERITY_ERROR, "فیلد موقعیت نباید خالی باشد", "فیلد موقعیت نباید خالی باشد"));
			e.printStackTrace();
		}
	}
}
