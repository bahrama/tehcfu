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

import entity.CreativeEntity;
import help.FileConvertor;
import sevice.CreativeServiceLocal;

@Named
@ViewScoped
public class CreativeBean implements Serializable {

	/**
	 *  
	 */
	private static final long serialVersionUID = 1L;

	public CreativeBean() {
		// TODO Auto-generated constructor stub
	}
	
	@Inject
	private CreativeServiceLocal creativeServiceLocal;
	@Size(max=100 , message="max is 100")
	private String name;
	@Size(max=1000 , message="max is 1000")
	private String description;
	private UploadedFile pic1;
	private UploadedFile pic2;
	private UploadedFile pic3;
	private UploadedFile pic4;
	private UploadedFile pic5;
	private UploadedFile pic6;
	private UIComponent pic1Component;
	private UIComponent pic2Component;
	private UIComponent pic3Component;
	private UIComponent pic4Component;
	private UIComponent pic5Component;
	private UIComponent pic6Component;
	private CreativeEntity creativeEntity;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public UploadedFile getPic1() {
		return pic1;
	}
	public void setPic1(UploadedFile pic1) {
		this.pic1 = pic1;
	}
	public UploadedFile getPic2() {
		return pic2;
	}
	public void setPic2(UploadedFile pic2) {
		this.pic2 = pic2;
	}
	public UploadedFile getPic3() {
		return pic3;
	}
	public void setPic3(UploadedFile pic3) {
		this.pic3 = pic3;
	}
	public UploadedFile getPic4() {
		return pic4;
	}
	public void setPic4(UploadedFile pic4) {
		this.pic4 = pic4;
	}
	public UploadedFile getPic5() {
		return pic5;
	}
	public void setPic5(UploadedFile pic5) {
		this.pic5 = pic5;
	}
	public UploadedFile getPic6() {
		return pic6;
	}
	public void setPic6(UploadedFile pic6) {
		this.pic6 = pic6;
	}
	public UIComponent getPic1Component() {
		return pic1Component;
	}
	public void setPic1Component(UIComponent pic1Component) {
		this.pic1Component = pic1Component;
	}
	public UIComponent getPic2Component() {
		return pic2Component;
	}
	public void setPic2Component(UIComponent pic2Component) {
		this.pic2Component = pic2Component;
	}
	public UIComponent getPic3Component() {
		return pic3Component;
	}
	public void setPic3Component(UIComponent pic3Component) {
		this.pic3Component = pic3Component;
	}
	public UIComponent getPic4Component() {
		return pic4Component;
	}
	public void setPic4Component(UIComponent pic4Component) {
		this.pic4Component = pic4Component;
	}
	public UIComponent getPic5Component() {
		return pic5Component;
	}
	public void setPic5Component(UIComponent pic5Component) {
		this.pic5Component = pic5Component;
	}
	public UIComponent getPic6Component() {
		return pic6Component;
	}
	public void setPic6Component(UIComponent pic6Component) {
		this.pic6Component = pic6Component;
	}
	public CreativeEntity getCreativeEntity() {
		return creativeEntity;
	}
	public void setCreativeEntity(CreativeEntity creativeEntity) {
		this.creativeEntity = creativeEntity;
	}
	public void insertToCreative() {
		try {
		CreativeEntity creativeEntity=new CreativeEntity();
		creativeEntity.setName(name);
		creativeEntity.setDescription(description);
		if (pic1 != null) {
			if (pic1.getSize() > 50000) {
				throw new Exception("pic1Size");
			} else if (!pic1.getContentType().equals("image/jpeg")) {
				throw new Exception("pic1Type");
			} else {
				creativeEntity.setPic1(FileConvertor.convertPicture(pic1));
			}
		}
		if (pic2 != null) {
			if (pic2.getSize() > 50000) {
				throw new Exception("pic2Size");
			} else if (!pic2.getContentType().equals("image/jpeg")) {
				throw new Exception("pic2Type");
			} else {
				creativeEntity.setPic2(FileConvertor.convertPicture(pic2));
			}
		}
		if (pic3 != null) {
			if (pic3.getSize() > 50000) {
				throw new Exception("pic3Size");
			} else if (!pic3.getContentType().equals("image/jpeg")) {
				throw new Exception("pic3Type");
			} else {
				creativeEntity.setPic3(FileConvertor.convertPicture(pic3));
			}
		}
		if (pic4 != null) {
			if (pic4.getSize() > 50000) {
				throw new Exception("pic4Size");
			} else if (!pic4.getContentType().equals("image/jpeg")) {
				throw new Exception("pic4Type");
			} else {
				creativeEntity.setPic4(FileConvertor.convertPicture(pic4));
			}
		}
		if (pic5 != null) {
			if (pic5.getSize() > 50000) {
				throw new Exception("pic5Size");
			} else if (!pic5.getContentType().equals("image/jpeg")) {
				throw new Exception("pic5Type");
			} else {
				creativeEntity.setPic5(FileConvertor.convertPicture(pic5));
			}
		}
		if (pic6 != null) {
			if (pic6.getSize() > 50000) {
				throw new Exception("pic6Size");
			} else if (!pic6.getContentType().equals("image/jpeg")) {
				throw new Exception("pic6Type");
			} else {
				creativeEntity.setPic6(FileConvertor.convertPicture(pic6));
			}
		}
		
		creativeServiceLocal.insertCreativeEntity(creativeEntity);
		}catch (Exception e) {
			if(e.getMessage().equals("pic1Size"))
	    		FacesContext.getCurrentInstance().addMessage(pic1Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "size must minimum 50k", null));
	    	if(e.getMessage().equals("pic1Type"))
	    		FacesContext.getCurrentInstance().addMessage(pic1Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "type must be jpg", null));
			if(e.getMessage().equals("pic2Size"))
	    		FacesContext.getCurrentInstance().addMessage(pic2Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "size must minimum 50k", null));
	    	if(e.getMessage().equals("pic2Type"))
	    		FacesContext.getCurrentInstance().addMessage(pic2Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "type must be jpg", null));
			if(e.getMessage().equals("pic3Size"))
	    		FacesContext.getCurrentInstance().addMessage(pic3Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "size must minimum 50k", null));
	    	if(e.getMessage().equals("pic3Type"))
	    		FacesContext.getCurrentInstance().addMessage(pic3Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "type must be jpg", null));
			if(e.getMessage().equals("pic4Size"))
	    		FacesContext.getCurrentInstance().addMessage(pic4Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "size must minimum 50k", null));
	    	if(e.getMessage().equals("pic4Type"))
	    		FacesContext.getCurrentInstance().addMessage(pic4Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "type must be jpg", null));
			if(e.getMessage().equals("pic5Size"))
	    		FacesContext.getCurrentInstance().addMessage(pic5Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "size must minimum 50k", null));
	    	if(e.getMessage().equals("pic5Type"))
	    		FacesContext.getCurrentInstance().addMessage(pic5Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "type must be jpg", null));
			if(e.getMessage()==null)
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "خطا در ارتباط با دیتابیس", null));
			e.printStackTrace();
		}
	}
	
	public List<CreativeEntity> findAllCreative(){
		return creativeServiceLocal.findAllCreativeEntity();
	}
	
	public void deleteCreative() {
		try {
			creativeServiceLocal.deleteCreativeEntity(creativeEntity);
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("*****************************با موفقیت حذف گردید************************"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
