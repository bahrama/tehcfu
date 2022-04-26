package adminNew;

import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.Column;
import javax.servlet.http.Part;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.primefaces.model.file.UploadedFile;

import dao.AdvertiseDaoLocal;
import entity.AdvertiseEntity;
import entity.AyeneVConsole;
import entity.JobKarfarmaEntity;
import entity.JobKarjoEntity;
import entity.MachineEntity;
import entity.RentEntity;
import help.FileConvertor;
import help.TimeCovnertor;
import panel.TempBean;
import sevice.JobKarfarmaServiceLocal;
import sevice.JobKarjoServiceLocal;
import sevice.MachineServiceLocal;
import sevice.RentServiceLocal;

@Named
@ViewScoped
public class AdvertiseBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AdvertiseBean() {
		// TODO Auto-generated constructor stub
	}
	@Inject
	private AdminProfile adminProfile;
	@Inject
	private AdvertiseDaoLocal advertiseDaoLocal;
	//////////////////////////////advertise
	private UploadedFile pic1;
	private UIComponent pic1Component;
	private UploadedFile pic2;
	private UIComponent pic2Component;
	private UploadedFile pic3;
	private UIComponent pic3Component;
	private UploadedFile pic4;
	private UIComponent pic4Component;
	@Size(max=100 , message="ماکزیمم ۱۰۰ کاراکتر")
    private String title;
	@Size(max=500 , message="ماکزیمم ۵۰۰ کاراکتر")
	private String description;
	@Size(max=200 , message="ماکزیمم 200 کاراکتر")
	private String phone;
	@Size(max=500 , message="ماکزیمم 500 کاراکتر")
	private String address;

	//////////////////////////////////karfarma/////////////////////

	@Size(max=150 , message="ماکزیمم 150 کاراکتر")
	private String karfarmaSenf;
	@Size(max=200 , message="ماکزیمم 200 کاراکتر")
	private String karfarmaCompanyName;
	@Size(max=150 , message="ماکزیمم 150 کاراکتر")
	private String karfarmaPasokhName;
	@Size(max=100 , message="ماکزیمم 100 کاراکتر")
	private String karfarmaPasokhSemat;
	@Size(max=100 , message="ماکزیمم 100 کاراکتر")
	private String karfarmaNiroMorede;
	@Size(max=100 , message="ماکزیمم 100 کاراکتر")
	private String karfarmaNoeDarkhast;
	@Size(max=500 , message="ماکزیمم 500 کاراکتر")
	private String karfarmaTakhasosMorede;
	private Long mizanHogog=(long) 1000;

	
	////////////////////////////////karjo

	@Size(max=100 , message="ماکزیمم 100 کاراکتر")
	private String karjoField;
	@Size(max=100 , message="ماکزیمم 100 کاراکتر")
	private String karjoMadrak;
	@Size(max=100 , message="ماکزیمم 100 کاراکتر")
	private String karjoMaharat;
	@Size(max=100 , message="ماکزیمم 100 کاراکتر")
	private String karjoNoeFaal;
	@Size(max=100 , message="ماکزیمم 100 کاراکتر")
	private String karjoNoeHamkari;
	
	////////////////////////////rent////////////////////
	
	@Size(max=20 , message="ماکزیمم 20 کاراکتر")
	private String rentType;

	@Size(max=20 , message="ماکزیمم 20 کاراکتر")
	private String homeType;



	@Size(max=20 , message="ماکزیمم 20 کاراکتر")
	private String vage;

	@Size(max=20 , message="ماکزیمم 20 کاراکتر")
	private String mogeiat;
	private Integer tedadTabage = 1;
	private Integer tedadVahed = 1;
	private Long vadieeMoney=(long) 1000;
	private Long ejareMony=(long) 1000;
	private Long mablageForosh=(long) 1000;


	@Size(max=200 , message="ماکزیمم 200 کاراکتر")
	private String emkanat;

	@Size(max=20 , message="ماکزیمم 20 کاراکتر")
	private String vaziatSanad;
	private Integer senBana = 1;
	private Integer masahat = 1;

	@Size(max=100 , message="ماکزیمم 100 کاراکتر")
	private String vaziatMelk;

	@Size(max=5 , message="ماکزیمم 5 کاراکتر")
	private String parvane;

	@Size(max=200 , message="ماکزیمم 200 کاراکتر")
	private String etehadieName;


	////////////////////////machin/////////////
	
	@Size(max=200 , message="ماکزیمم 200 کاراکتر")
	private String machineName;
	@Size(max=100 , message="ماکزیمم 100 کاراکتر")
	private String contry;
	@Size(max=100 , message="ماکزیمم 100 کاراکتر")
	private String brand;
	@Size(max=100 , message="ماکزیمم 100 کاراکتر")
	private String saleTolid;
	@Size(max=20 , message="ماکزیمم 20 کاراکتر")
	private String vaziat;
	@Size(max=1000 , message="ماکزیمم 1000 کاراکتر")
	private String moshakhasat;
	private Long mablag=(long) 1000;
	@Size(max=100 , message="ماکزیمم 100 کاراکتر")
	private String mahaleForosh;
/////////////////////////////////////////
	private AdvertiseEntity advertiseEntity;
	private boolean enableAdvertise;
	private Object advertiseDetail;
	
	
	public AdvertiseEntity getAdvertiseEntity() {
		return advertiseEntity;
	}
	public void setAdvertiseEntity(AdvertiseEntity advertiseEntity) {
		this.advertiseEntity = advertiseEntity;
	}
	public boolean isEnableAdvertise() {
		return enableAdvertise;
	}
	public void setEnableAdvertise(boolean enableAdvertise) {
		this.enableAdvertise = enableAdvertise;
	}
	public Object getAdvertiseDetail() {
		return advertiseDetail;
	}
	public void setAdvertiseDetail(Object advertiseDetail) {
		this.advertiseDetail = advertiseDetail;
	}
	public String getKarfarmaNiroMorede() {
		return karfarmaNiroMorede;
	}
	public void setKarfarmaNiroMorede(String karfarmaNiroMorede) {
		this.karfarmaNiroMorede = karfarmaNiroMorede;
	}
	public String getKarfarmaNoeDarkhast() {
		return karfarmaNoeDarkhast;
	}
	public void setKarfarmaNoeDarkhast(String karfarmaNoeDarkhast) {
		this.karfarmaNoeDarkhast = karfarmaNoeDarkhast;
	}
	public String getKarfarmaTakhasosMorede() {
		return karfarmaTakhasosMorede;
	}
	public void setKarfarmaTakhasosMorede(String karfarmaTakhasosMorede) {
		this.karfarmaTakhasosMorede = karfarmaTakhasosMorede;
	}
	
	public String getKarjoField() {
		return karjoField;
	}
	public void setKarjoField(String karjoField) {
		this.karjoField = karjoField;
	}
	public String getKarjoMadrak() {
		return karjoMadrak;
	}
	public void setKarjoMadrak(String karjoMadrak) {
		this.karjoMadrak = karjoMadrak;
	}
	public String getKarjoMaharat() {
		return karjoMaharat;
	}
	public void setKarjoMaharat(String karjoMaharat) {
		this.karjoMaharat = karjoMaharat;
	}
	public String getKarjoNoeFaal() {
		return karjoNoeFaal;
	}
	public void setKarjoNoeFaal(String karjoNoeFaal) {
		this.karjoNoeFaal = karjoNoeFaal;
	}
	
	public String getKarjoNoeHamkari() {
		return karjoNoeHamkari;
	}
	public void setKarjoNoeHamkari(String karjoNoeHamkari) {
		this.karjoNoeHamkari = karjoNoeHamkari;
	}
	
	public String getRentType() {
		return rentType;
	}
	public void setRentType(String rentType) {
		this.rentType = rentType;
	}
	public String getHomeType() {
		return homeType;
	}
	public void setHomeType(String homeType) {
		this.homeType = homeType;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getVage() {
		return vage;
	}
	public void setVage(String vage) {
		this.vage = vage;
	}
	public String getMogeiat() {
		return mogeiat;
	}
	public void setMogeiat(String mogeiat) {
		this.mogeiat = mogeiat;
	}
	
	public String getEmkanat() {
		return emkanat;
	}
	public void setEmkanat(String emkanat) {
		this.emkanat = emkanat;
	}
	public String getVaziatSanad() {
		return vaziatSanad;
	}
	public void setVaziatSanad(String vaziatSanad) {
		this.vaziatSanad = vaziatSanad;
	}
	
	public String getVaziatMelk() {
		return vaziatMelk;
	}
	public void setVaziatMelk(String vaziatMelk) {
		this.vaziatMelk = vaziatMelk;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getParvane() {
		return parvane;
	}
	public void setParvane(String parvane) {
		this.parvane = parvane;
	}
	public String getEtehadieName() {
		return etehadieName;
	}
	public void setEtehadieName(String etehadieName) {
		this.etehadieName = etehadieName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getMachineName() {
		return machineName;
	}
	public void setMachineName(String machineName) {
		this.machineName = machineName;
	}
	public String getContry() {
		return contry;
	}
	public void setContry(String contry) {
		this.contry = contry;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getSaleTolid() {
		return saleTolid;
	}
	public void setSaleTolid(String saleTolid) {
		this.saleTolid = saleTolid;
	}
	public String getVaziat() {
		return vaziat;
	}
	public void setVaziat(String vaziat) {
		this.vaziat = vaziat;
	}
	public String getMoshakhasat() {
		return moshakhasat;
	}
	public void setMoshakhasat(String moshakhasat) {
		this.moshakhasat = moshakhasat;
	}

	public String getMahaleForosh() {
		return mahaleForosh;
	}
	public void setMahaleForosh(String mahaleForosh) {
		this.mahaleForosh = mahaleForosh;
	}
	public AdminProfile getAdminProfile() {
		return adminProfile;
	}
	public void setAdminProfile(AdminProfile adminProfile) {
		this.adminProfile = adminProfile;
	}
	public AdvertiseDaoLocal getAdvertiseDaoLocal() {
		return advertiseDaoLocal;
	}
	public void setAdvertiseDaoLocal(AdvertiseDaoLocal advertiseDaoLocal) {
		this.advertiseDaoLocal = advertiseDaoLocal;
	}
	public UploadedFile getPic1() {
		return pic1;
	}
	public void setPic1(UploadedFile pic1) {
		this.pic1 = pic1;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getKarfarmaSenf() {
		return karfarmaSenf;
	}
	public void setKarfarmaSenf(String karfarmaSenf) {
		this.karfarmaSenf = karfarmaSenf;
	}
	public String getKarfarmaCompanyName() {
		return karfarmaCompanyName;
	}
	public void setKarfarmaCompanyName(String karfarmaCompanyName) {
		this.karfarmaCompanyName = karfarmaCompanyName;
	}
	public String getKarfarmaPasokhName() {
		return karfarmaPasokhName;
	}
	public void setKarfarmaPasokhName(String karfarmaPasokhName) {
		this.karfarmaPasokhName = karfarmaPasokhName;
	}
	public String getKarfarmaPasokhSemat() {
		return karfarmaPasokhSemat;
	}
	public void setKarfarmaPasokhSemat(String karfarmaPasokhSemat) {
		this.karfarmaPasokhSemat = karfarmaPasokhSemat;
	}
	public Long getMizanHogog() {
		return mizanHogog;
	}
	public void setMizanHogog(Long mizanHogog) {
		this.mizanHogog = mizanHogog;
	}
	public Integer getTedadTabage() {
		return tedadTabage;
	}
	public void setTedadTabage(Integer tedadTabage) {
		this.tedadTabage = tedadTabage;
	}
	public Integer getTedadVahed() {
		return tedadVahed;
	}
	public void setTedadVahed(Integer tedadVahed) {
		this.tedadVahed = tedadVahed;
	}
	public Long getVadieeMoney() {
		return vadieeMoney;
	}
	public void setVadieeMoney(Long vadieeMoney) {
		this.vadieeMoney = vadieeMoney;
	}
	public Long getEjareMony() {
		return ejareMony;
	}
	public void setEjareMony(Long ejareMony) {
		this.ejareMony = ejareMony;
	}
	public Long getMablageForosh() {
		return mablageForosh;
	}
	public void setMablageForosh(Long mablageForosh) {
		this.mablageForosh = mablageForosh;
	}
	public Integer getSenBana() {
		return senBana;
	}
	public void setSenBana(Integer senBana) {
		this.senBana = senBana;
	}
	public Integer getMasahat() {
		return masahat;
	}
	public void setMasahat(Integer masahat) {
		this.masahat = masahat;
	}
	public Long getMablag() {
		return mablag;
	}
	public void setMablag(Long mablag) {
		this.mablag = mablag;
	}
	
	/////////////////////////////////////////////////
	
	public UIComponent getPic1Component() {
		return pic1Component;
	}
	public void setPic1Component(UIComponent pic1Component) {
		this.pic1Component = pic1Component;
	}
	public UploadedFile getPic2() {
		return pic2;
	}
	public void setPic2(UploadedFile pic2) {
		this.pic2 = pic2;
	}
	public UIComponent getPic2Component() {
		return pic2Component;
	}
	public void setPic2Component(UIComponent pic2Component) {
		this.pic2Component = pic2Component;
	}
	public UploadedFile getPic3() {
		return pic3;
	}
	public void setPic3(UploadedFile pic3) {
		this.pic3 = pic3;
	}
	public UIComponent getPic3Component() {
		return pic3Component;
	}
	public void setPic3Component(UIComponent pic3Component) {
		this.pic3Component = pic3Component;
	}
	public UploadedFile getPic4() {
		return pic4;
	}
	public void setPic4(UploadedFile pic4) {
		this.pic4 = pic4;
	}
	public UIComponent getPic4Component() {
		return pic4Component;
	}
	public void setPic4Component(UIComponent pic4Component) {
		this.pic4Component = pic4Component;
	}
	public String convertPicture(UploadedFile uploadedFile) {
    	try {
			return FileConvertor.convertPicture(uploadedFile);
		} catch (Exception e) {
			return null;
		}
    }
	
	
	public void insertToKarjo() {
		JobKarjoEntity advertise =new JobKarjoEntity();
		try {
		advertise.setDate(new Date());
		advertise.setDescription(description);
		advertise.setKarjoField(karjoField);
		advertise.setKarjoMadrak(karjoMadrak);
		advertise.setKarjoNoeFaal(karjoNoeFaal);
		advertise.setKarjoNoeHamkari(karjoNoeHamkari);
		advertise.setKarjoMaharat(karjoMaharat);
		advertise.setTitle(title);
		advertise.setAddres(address);
		advertise.setPhone(phone);
		advertise.setUserAdv(adminProfile.getMoblEntity());
		if (pic1 != null) {
			if (pic1.getSize() > 50000) {
				throw new Exception("pic1Size");
			} else if (!pic1.getContentType().equals("image/jpeg")) {
				throw new Exception("pic1Type");
			} else {
				advertise.setPic1(convertPicture(pic1));
			}
		}
			advertiseDaoLocal.insertToKarjo(advertise);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("*****************************با موفقیت وارد گردید************************"));
		} catch (Exception e) {
			if(e.getMessage().equals("pic1Size"))
	    		FacesContext.getCurrentInstance().addMessage(pic1Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "size must minimum 50k", null));
	    	if(e.getMessage().equals("pic1Type"))
	    		FacesContext.getCurrentInstance().addMessage(pic1Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "type must be jpg", null));
	    	if(e.getMessage()==null)
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "خطا در ارتباط با دیتابیس", null));

		}
	}
	
	
	public void insertToKarfarma() {
		JobKarfarmaEntity advertise =new JobKarfarmaEntity();
		try {
		advertise.setDate(new Date());
		advertise.setDescription(description);
		advertise.setKarfarmaCompanyName(karfarmaCompanyName);
		advertise.setKarfarmaNiroMorede(karfarmaNiroMorede);
		advertise.setKarfarmaNoeDarkhast(karfarmaNoeDarkhast);
		advertise.setKarfarmaPasokhName(karfarmaPasokhName);
		advertise.setKarfarmaPasokhName(karfarmaPasokhName);
		advertise.setKarfarmaPasokhSemat(karfarmaPasokhSemat);
		advertise.setKarfarmaSenf(karfarmaSenf);
		advertise.setKarfarmaTakhasosMorede(karfarmaTakhasosMorede);
		advertise.setMizanHogog(mizanHogog);
		advertise.setTitle(title);
		advertise.setAddres(address);
		advertise.setPhone(phone);
		advertise.setUserAdv(adminProfile.getMoblEntity());
		if (pic2 != null) {
			if (pic2.getSize() > 50000) {
				throw new Exception("pic2Size");
			} else if (!pic2.getContentType().equals("image/jpeg")) {
				throw new Exception("pic2Type");
			} else {
				advertise.setPic1(convertPicture(pic2));
			}
		}
			advertiseDaoLocal.insertToKarfarma(advertise);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("*****************************با موفقیت وارد گردید************************"));
		} catch (Exception e) {
			if(e.getMessage().equals("pic2Size"))
	    		FacesContext.getCurrentInstance().addMessage(pic2Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "size must minimum 50k", null));
	    	if(e.getMessage().equals("pic2Type"))
	    		FacesContext.getCurrentInstance().addMessage(pic2Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "type must be jpg", null));
	    	if(e.getMessage()==null)
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "خطا در ارتباط با دیتابیس", null));

		}
	}
	
	public void insertToRent() {
		RentEntity advertise =new RentEntity();
		try {
		advertise.setDate(new Date());
		advertise.setDescription(description);
		advertise.setEjareMony(ejareMony);
		advertise.setEmkanat(emkanat);
		advertise.setEtehadieName(etehadieName);
		advertise.setHomeType(homeType);
		advertise.setMablageForosh(mablageForosh);
		advertise.setMasahat(masahat);
		advertise.setMogeiat(mogeiat);
		advertise.setParvane(parvane);
		advertise.setRentType(rentType);
		advertise.setSenBana(senBana);
		advertise.setTedadTabage(tedadTabage);
		advertise.setTedadVahed(tedadVahed);
		advertise.setVadieeMoney(vadieeMoney);
		advertise.setVage(vage);
		advertise.setVaziatMelk(vaziatMelk);
		advertise.setVaziatSanad(vaziatSanad);
		advertise.setAddres(address);
		advertise.setPhone(phone);
		advertise.setTitle(title);
		advertise.setUserAdv(adminProfile.getMoblEntity());
		if (pic3 != null) {
			if (pic3.getSize() > 50000) {
				throw new Exception("pic3Size");
			} else if (!pic3.getContentType().equals("image/jpeg")) {
				throw new Exception("pic3Type");
			} else {
				advertise.setPic1(convertPicture(pic3));
			}
		}
			advertiseDaoLocal.insertToRent(advertise);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("*****************************با موفقیت وارد گردید************************"));
		} catch (Exception e) {
			if(e.getMessage().equals("pic3Size"))
	    		FacesContext.getCurrentInstance().addMessage(pic1Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "size must minimum 50k", null));
	    	if(e.getMessage().equals("pic3Type"))
	    		FacesContext.getCurrentInstance().addMessage(pic1Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "type must be jpg", null));
	    	if(e.getMessage()==null)
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "خطا در ارتباط با دیتابیس", null));

		}
	}
	
	public void insertToMachin() {
		MachineEntity advertise =new MachineEntity();
		try {
		advertise.setDate(new Date());
		advertise.setDescription(description);
		advertise.setBrand(brand);
		advertise.setContry(contry);
		advertise.setMablag(mablag);
		advertise.setMachineName(machineName);
		advertise.setMahaleForosh(mahaleForosh);
		advertise.setMoshakhasat(moshakhasat);
		advertise.setSaleTolid(saleTolid);
		advertise.setVaziat(vaziat);
		advertise.setAddres(address);
		advertise.setPhone(phone);
		advertise.setTitle(title);
		advertise.setUserAdv(adminProfile.getMoblEntity());
		if (pic4 != null) {
			if (pic4.getSize() > 50000) {
				throw new Exception("pic4Size");
			} else if (!pic4.getContentType().equals("image/jpeg")) {
				throw new Exception("pic4Type");
			} else {
				advertise.setPic1(convertPicture(pic4));
			}
		}
			advertiseDaoLocal.insertToMachine(advertise);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("*****************************با موفقیت وارد گردید************************"));
		} catch (Exception e) {
			if(e.getMessage().equals("pic4Size"))
	    		FacesContext.getCurrentInstance().addMessage(pic1Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "size must minimum 50k", null));
	    	if(e.getMessage().equals("pic4Type"))
	    		FacesContext.getCurrentInstance().addMessage(pic1Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "type must be jpg", null));
	    	if(e.getMessage()==null)
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "خطا در ارتباط با دیتابیس", null));

		}
	}
	
	public List<AdvertiseEntity> findAllAdvertise(){
		return advertiseDaoLocal.findAllAdvertise();
	}
	
	public Object findAdvertiseDetailById(long advertiseId , String advertiseType) {
		this.advertiseDetail = advertiseDaoLocal.findAdvertiseDetailById(advertiseId, advertiseType);
		return advertiseDetail;
	}
    public String convertToPersianDate(Date date) {
    	if(date!=null)
    	return TimeCovnertor.findPersianDate(date);
    	else
    	return "وارد نشده است";
    }
    
	public void updateAdvertise() {
		this.advertiseEntity.setShow(enableAdvertise);
		advertiseDaoLocal.updateAdvertise(advertiseEntity);
	}
}
