package adminNew;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.Part;
import javax.validation.constraints.Size;

import org.primefaces.model.file.UploadedFile;

import entity.NamayeshgahEntity;
import help.FileConvertor;
import help.TimeCovnertor;
import sevice.NamayeshgahServiceLocal;

@Named
@ViewScoped
public class AdminNamayeshgahBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AdminNamayeshgahBean() {
		// TODO Auto-generated constructor stub
	}
	 
	@Inject
	private NamayeshgahServiceLocal namayeshgahServiceLocal;
	
	private NamayeshgahEntity namayeshgahEntity;
	
	@Size(max=100 , message="max size is 100")
	private String name;
	@Size(max=100 , message="max size is 100")
	private String city;
	@Size(max=100 , message="max size is 100")
	private String country;
	@Size(max=100 , message="max size is 100")
	private String tarikh;
	@Size(max=300 , message="max size is 300")
	private String makan;
	@Size(max=100 , message="max size is 100")
	private String nameBargozarK;
	@Size(max=100 , message="max size is 100")
	private String phoneModirNazer;
	@Size(max=100 , message="max size is 100")
	private String nameModirNazer;
	@Size(max=100 , message="max size is 100")
	private String fax;
	@Size(max=100 , message="max size is 100")
	private String phone;
	@Size(max=100 , message="max size is 100")
	private String email;
	@Size(max=100 , message="max size is 100")
	private String site;
	@Size(max=100 , message="max size is 2")
	private String type;
	
	private UploadedFile pic;
	private UIComponent picComponent;
	
	/////////////////////////////////////////edit
	@Size(max=100 , message="max size is 100")
	private String nameEdit;
	@Size(max=100 , message="max size is 100")
	private String cityEdit;
	@Size(max=100 , message="max size is 100")
	private String countryEdit;
	@Size(max=100 , message="max size is 100")
	private String tarikhEdit;
	@Size(max=300 , message="max size is 300")
	private String makanEdit;
	@Size(max=100 , message="max size is 100")
	private String nameBargozarKEdit;
	@Size(max=100 , message="max size is 100")
	private String phoneModirNazerEdit;
	@Size(max=100 , message="max size is 100")
	private String nameModirNazerEdit;
	@Size(max=100 , message="max size is 100")
	private String faxEdit;
	@Size(max=100 , message="max size is 100")
	private String phoneEdit;
	@Size(max=100 , message="max size is 100")
	private String emailEdit;
	@Size(max=100 , message="max size is 100")
	private String siteEdit;
	@Size(max=100 , message="max size is 2")
	private String typeEdit;
	
	private UploadedFile pic1Edit;
	private UIComponent picEditComponent;

	public NamayeshgahServiceLocal getNamayeshgahServiceLocal() {
		return namayeshgahServiceLocal;
	}
	public void setNamayeshgahServiceLocal(NamayeshgahServiceLocal namayeshgahServiceLocal) {
		this.namayeshgahServiceLocal = namayeshgahServiceLocal;
	}
	public NamayeshgahEntity getNamayeshgahEntity() {
		return namayeshgahEntity;
	}
	public void setNamayeshgahEntity(NamayeshgahEntity namayeshgahEntity) {
		this.namayeshgahEntity = namayeshgahEntity;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getTarikh() {
		return tarikh;
	}
	public void setTarikh(String tarikh) {
		this.tarikh = tarikh;
	}
	public String getMakan() {
		return makan;
	}
	public void setMakan(String makan) {
		this.makan = makan;
	}
	public String getNameBargozarK() {
		return nameBargozarK;
	}
	public void setNameBargozarK(String nameBargozarK) {
		this.nameBargozarK = nameBargozarK;
	}
	public String getPhoneModirNazer() {
		return phoneModirNazer;
	}
	public void setPhoneModirNazer(String phoneModirNazer) {
		this.phoneModirNazer = phoneModirNazer;
	}
	public String getNameModirNazer() {
		return nameModirNazer;
	}
	public void setNameModirNazer(String nameModirNazer) {
		this.nameModirNazer = nameModirNazer;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public UploadedFile getPic() {
		return pic;
	}
	public void setPic(UploadedFile pic) {
		this.pic = pic;
	}
	public UploadedFile getPic1Edit() {
		return pic1Edit;
	}
	public void setPic1Edit(UploadedFile pic1Edit) {
		this.pic1Edit = pic1Edit;
	}
	public UIComponent getPicComponent() {
		return picComponent;
	}
	public void setPicComponent(UIComponent picComponent) {
		this.picComponent = picComponent;
	}
	public UIComponent getPicEditComponent() {
		return picEditComponent;
	}
	public void setPicEditComponent(UIComponent picEditComponent) {
		this.picEditComponent = picEditComponent;
	}
	
    public String convertPicture(UploadedFile uploadedFile) {
    	try {
			return FileConvertor.convertPicture(uploadedFile);
		} catch (Exception e) {
			return null;
		}
    }
    
    public List<NamayeshgahEntity> findAllNamayeshgah(){
    	return namayeshgahServiceLocal.findAllNamayeshgahEntity();
    }
	
	public String getNameEdit() {
		return nameEdit;
	}
	public void setNameEdit(String nameEdit) {
		this.nameEdit = nameEdit;
	}
	public String getCityEdit() {
		return cityEdit;
	}
	public void setCityEdit(String cityEdit) {
		this.cityEdit = cityEdit;
	}
	public String getCountryEdit() {
		return countryEdit;
	}
	public void setCountryEdit(String countryEdit) {
		this.countryEdit = countryEdit;
	}
	public String getTarikhEdit() {
		return tarikhEdit;
	}
	public void setTarikhEdit(String tarikhEdit) {
		this.tarikhEdit = tarikhEdit;
	}
	public String getMakanEdit() {
		return makanEdit;
	}
	public void setMakanEdit(String makanEdit) {
		this.makanEdit = makanEdit;
	}
	public String getNameBargozarKEdit() {
		return nameBargozarKEdit;
	}
	public void setNameBargozarKEdit(String nameBargozarKEdit) {
		this.nameBargozarKEdit = nameBargozarKEdit;
	}
	public String getPhoneModirNazerEdit() {
		return phoneModirNazerEdit;
	}
	public void setPhoneModirNazerEdit(String phoneModirNazerEdit) {
		this.phoneModirNazerEdit = phoneModirNazerEdit;
	}
	public String getNameModirNazerEdit() {
		return nameModirNazerEdit;
	}
	public void setNameModirNazerEdit(String nameModirNazerEdit) {
		this.nameModirNazerEdit = nameModirNazerEdit;
	}
	public String getFaxEdit() {
		return faxEdit;
	}
	public void setFaxEdit(String faxEdit) {
		this.faxEdit = faxEdit;
	}
	public String getPhoneEdit() {
		return phoneEdit;
	}
	public void setPhoneEdit(String phoneEdit) {
		this.phoneEdit = phoneEdit;
	}
	public String getEmailEdit() {
		return emailEdit;
	}
	public void setEmailEdit(String emailEdit) {
		this.emailEdit = emailEdit;
	}
	public String getSiteEdit() {
		return siteEdit;
	}
	public void setSiteEdit(String siteEdit) {
		this.siteEdit = siteEdit;
	}
	public String getTypeEdit() {
		return typeEdit;
	}
	public void setTypeEdit(String typeEdit) {
		this.typeEdit = typeEdit;
	}
	public void insertToNamayeshgah() {
		try {
		NamayeshgahEntity namayeshgahEntity=new NamayeshgahEntity();
		namayeshgahEntity.setCity(city);
		namayeshgahEntity.setCountry(country);
		namayeshgahEntity.setEmail(email);
		namayeshgahEntity.setFax(fax);
		namayeshgahEntity.setMakan(makan);
		namayeshgahEntity.setName(name);
		namayeshgahEntity.setNameBargozarK(nameBargozarK);
		namayeshgahEntity.setNameModirNazer(nameModirNazer);
		namayeshgahEntity.setPhone(phone);
		namayeshgahEntity.setPhoneModirNazer(phoneModirNazer);
		namayeshgahEntity.setSite(site);
		namayeshgahEntity.setTarikh(tarikh);
		namayeshgahEntity.setType(type);
		if (pic != null) {
			if (pic.getSize() > 50000) {
				throw new Exception("pic1Size");
			} else if (!pic.getContentType().equals("image/jpeg")) {
				throw new Exception("pic1Type");
			} else {
				namayeshgahEntity.setPic(convertPicture(pic));
			}
		}
		
		namayeshgahServiceLocal.insertNamayeshgahEntity(namayeshgahEntity);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("با موفقیت وارد گردید."));
		}catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(picComponent.getClientId(),
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "size must minimum 50k", null));
			if (e.getMessage().equals("pic1Type"))
				FacesContext.getCurrentInstance().addMessage(picComponent.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "type must be jpg", null));
			if (e.getMessage() == null)
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "خطا در ارتباط با دیتابیس", null));
			e.printStackTrace();
		}
		}
	
	public void deleteNamayeshgah() {
		namayeshgahServiceLocal.deleteNamayeshgahEntity(namayeshgahEntity);
	}
	
	
	public void updateBlog() {
		try {
			if (!nameEdit.equals(""))
				this.namayeshgahEntity.setName(this.nameEdit);
			if (!cityEdit.equals(""))
				this.namayeshgahEntity.setCity(cityEdit);
			if (!countryEdit.equals(""))
				this.namayeshgahEntity.setCountry(countryEdit);
			if (!emailEdit.equals(""))
				this.namayeshgahEntity.setEmail(emailEdit);
			if (!faxEdit.equals(""))
				this.namayeshgahEntity.setFax(faxEdit);
			if (!makanEdit.equals(""))
				this.namayeshgahEntity.setMakan(makanEdit);
			if (!nameBargozarKEdit.equals(""))
				this.namayeshgahEntity.setNameBargozarK(nameBargozarKEdit);
			if (!nameModirNazerEdit.equals(""))
				this.namayeshgahEntity.setNameModirNazer(nameModirNazer);
			if (!phoneEdit.equals(""))
				this.namayeshgahEntity.setPhone(phoneEdit);
			if (!phoneModirNazer.equals(""))
				this.namayeshgahEntity.setPhoneModirNazer(phoneModirNazerEdit);
			if (!siteEdit.equals(""))
				this.namayeshgahEntity.setSite(siteEdit);
			if (!tarikhEdit.equals(""))
				this.namayeshgahEntity.setTarikh(tarikhEdit);
			if (pic1Edit != null) {
				if (pic1Edit.getSize() > 50000) {
					throw new Exception("pic1Size");
				} else if (!pic1Edit.getContentType().equals("image/jpeg")) {
					throw new Exception("pic1Type");
				} else {
					this.namayeshgahEntity.setPic(convertPicture(pic1Edit));
				}
			}
			try {
				if ((!typeEdit.equals("")) | (!typeEdit.equals(null)))
					this.namayeshgahEntity.setType(typeEdit);
			} catch (Exception e) {
				System.err.println("type null");
			}
			namayeshgahServiceLocal.updateNamayeshgahEntity(namayeshgahEntity);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("با موفقیت آپدیت گردید."));

		} catch (Exception e) {
			if (e.getMessage().equals("pic1Size"))
				FacesContext.getCurrentInstance().addMessage(picEditComponent.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "size must minimum 50k", null));
			if (e.getMessage().equals("pic1Type"))
				FacesContext.getCurrentInstance().addMessage(picEditComponent.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "type must be jpg", null));
			if (e.getMessage() == null)
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "خطا در ارتباط با دیتابیس", null));
		}
	}


}
