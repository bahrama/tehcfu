package adminNew;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.Size;

import org.primefaces.model.file.UploadedFile;

import entity.HomeEntity;
import help.FileConvertor;
import sevice.HomeServiceLocal;

@Named
@ViewScoped
public class HomeBeanAdmin implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public HomeBeanAdmin() {
		// TODO Auto-generated constructor stub
	}
	
	@Inject
	private HomeServiceLocal homeServiceLocal;

	@Size(max=2 , message="max size is 2")
	private String name;
	private UploadedFile pic1;
	private UIComponent pic1Component;
	private HomeEntity homeEntity;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public UploadedFile getPic1() {
		return pic1;
	}
	public void setPic1(UploadedFile pic1) {
		this.pic1 = pic1;
	}
	public UIComponent getPic1Component() {
		return pic1Component;
	}
	public void setPic1Component(UIComponent pic1Component) {
		this.pic1Component = pic1Component;
	}
	
	public HomeEntity getHomeEntity() {
		return homeEntity;
	}
	public void setHomeEntity(HomeEntity homeEntity) {
		this.homeEntity = homeEntity;
	}
	public void insertToHome() {
		try {
		HomeEntity homeEntity=new HomeEntity();
		homeEntity.setName(name);
		if (pic1 != null) {
			if (pic1.getSize() > 50000) {
				throw new Exception("pic1Size");
			} else if (!pic1.getContentType().equals("image/jpeg")) {
				throw new Exception("pic1Type");
			} else {
				homeEntity.setPicId(FileConvertor.convertPicture(pic1));
			}
		}
		
		homeServiceLocal.insertHomeEntity(homeEntity);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("*****************************با موفقیت وارد گردید************************"));
		}catch (Exception e) {
			if(e.getMessage().equals("pic1Size"))
	    		FacesContext.getCurrentInstance().addMessage(pic1Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "size must minimum 50k", null));
	    	if(e.getMessage().equals("pic1Type"))
	    		FacesContext.getCurrentInstance().addMessage(pic1Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "type must be jpg", null));
			
			if(e.getMessage()==null)
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "خطا در ارتباط با دیتابیس", null));
			e.printStackTrace();
		}
	}
	
	public void deleteHome() {
		try {
			homeServiceLocal.deleteSeller(homeEntity);
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("*****************************با موفقیت حذف گردید************************"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<HomeEntity> findAllHome(){
		return homeServiceLocal.findAllHomeEntity();
	}
}
