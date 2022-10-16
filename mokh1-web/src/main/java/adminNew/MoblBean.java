package adminNew;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.primefaces.event.map.PointSelectEvent;
import org.primefaces.model.file.UploadedFile;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

import entity.BlogEntity;
import entity.MoblEntity;
import enums.UserRole;
import help.FileConvertor;
import help.TimeCovnertor;
import sevice.BlogServiceLocal;
import sevice.SellerServiceLocal;

@Named
@ViewScoped
public class MoblBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MoblBean() {
		// TODO Auto-generated constructor stub
	}
	
	private MoblEntity moblEntity;
	private FileConvertor fileConvertor;

	@Inject
	private SellerServiceLocal sellerServiceLocal; 
	@Inject
	private BlogServiceLocal blogServiceLocal;
	
	private List<BlogEntity> blogEntities = new ArrayList<>();
	
	@Size(max=100 , message="max size is 100")
	private String sellerName;
	@Size(max=30 , message="max size is 30")
	private String sellerStoreNamePer;
	@Size(max=30 , message="max size is 30")
	private String sellerStoreNameEng;
	@Size(max=7000 , message="max size is 7000")
	private String aboutUs;
	@Size(max=30 , message="max size is 30")
	private String instagram;
	@Size(max=30 , message="max size is 30")
	private String telegram;
	@Size(max=50 , message="max size is 50")
	private String phone;
	@Size(max=30 , message="max size is 30")
	private String website;
	@Size(max=30 , message="max size is 30")
	private String email;
	@Size(max=50 , message="max size is 50")
	private String fax;
	@Size(max=100 , message="max size is 100")	
	private String modirForoshName;
	@Size(max=50 , message="max size is 50")
	private String modirForoshPhone;
	@Size(max=10 , message="max size is 10")
	private String postCode;
	@Size(max=200 , message="max size is 200")	
	private String addres;
	@Size(max=200 , message="max size is 200")	
	private String vage;
	private String lat;
	private String lng;
	private UploadedFile sellerPic1;
	private UploadedFile sellerPic2;
	private UploadedFile sellerPic3;
	private UploadedFile sellerPic4;
	private UploadedFile sellerPic5;
	private String panel;
	private String noeFaaliat;
	private String faaliat;
	private List<String> faaliats=new ArrayList<String>();
	@Pattern(regexp="$|09\\d{9}" , message="شماره وارده اشتباه می باشد")
	private String mobile;
	@Size(max=10 , message="max size is 10")
	private String ssn;	
	private String tagdir;
	@Size(max=20 , message="max size is 20")	
	private String malekiat;
	@Size(max=20 , message="max size is 20")	
	private String sabteSefaresh;
	private String mostajer;
	private String mohlateEjare;
	@Size(max=100 , message="max size is 100")
	private String mostajerName;
	private String mostajerBirthday;
	@Size(max=11 , message="max size is 11")
	private String mostajerSsn;	
	@Size(max=11 , message="max size is 11")
	private String mostajerMobile;
	@Size(max=100 , message="max size is 100")
	private String shomareJavaz;
	private String tarikhEtebar;
	private String hasMobasher;
	@Size(max=100 , message="max size is 100")
	private String mobasherName;
	@Size(max=100 , message="max size is 100")
	private String rabetName;
	@Size(max=100 , message="max size is 100")
	private String sematRabet;	
	@Size(max=11 , message="max size is 11")
	private String rabetMobile;
	@Size(max=11 , message="max size is 11")
	private String shabakeMazajiMobile;
	@Size(max=100 , message="max size is 100")
	private String mojtame;
	private String birthDay;
	@Size(max=100 , message="max size is 200")
	private String metaDescription;
	@Size(max=100 , message="max size is 100")
	private String metaKeywords;
	
	///////////////////////////////EDIT///////////////////////////////////////
	@Size(max=100 , message="max size is 200")
	private String metaDescriptionEdit;
	@Size(max=100 , message="max size is 100")
	private String metaKeywordsEdit;
	@Size(max=100 , message="max size is 100")
	private String sellerNameEdit;
	@Size(max=30 , message="max size is 30")
	private String sellerStoreNamePerEdit;
	//////////////////////////////////////////unique
	@Size(max=30 , message="max size is 30")
	private String sellerStoreNameEngEdit;
	///////////////////////////////////////////
	@Size(max=7000 , message="max size is 7000")
	private String aboutUsEdit;
	@Size(max=30 , message="max size is 30")
	private String instagramEdit;
	@Size(max=30 , message="max size is 30")
	private String telegramEdit;
	@Size(max=50 , message="max size is 50")
	private String phoneEdit;
	@Size(max=30 , message="max size is 30")
	private String websiteEdit;
	@Size(max=30 , message="max size is 30")
	private String emailEdit;
	@Size(max=50 , message="max size is 50")
	private String faxEdit;
	@Size(max=100 , message="max size is 100")	
	private String modirForoshNameEdit;
	@Size(max=50 , message="max size is 50")
	private String modirForoshPhoneEdit;
	@Size(max=10 , message="max size is 10")
	private String postCodeEdit;
	@Size(max=200 , message="max size is 200")	
	private String addresEdit;
	@Size(max=200 , message="max size is 200")	
	private String vageEdit;
	///////////////
	private String latEdit;
	private String lngEdit;
	private UploadedFile sellerPic1Edit;
	private UploadedFile sellerPic2Edit;
	private UploadedFile sellerPic3Edit;
	private UploadedFile sellerPic4Edit;
	private UploadedFile sellerPic5Edit;
	private String panelEdit;
	private String noeFaaliatEdit;
	private String faaliatEdit;
	private List<String> faaliatsEdit=new ArrayList<String>();
	@Pattern(regexp="$|09\\d{9}" , message="فرمت شماره اشتباه است")
	private String mobileEdit;
    ////////////////
	@Pattern(regexp="^$|\\d{10}" + "" , message="فرمت شماره اشتباه است")
	private String ssnEdit;	
	private String tagdirEdit;
	@Size(max=20 , message="max size is 20")	
	private String malekiatEdit;
	@Size(max=20 , message="max size is 20")	
	private String sabteSefareshEdit;
	private String mostajerEdit;
	private String mohlateEjareEdit;
	@Size(max=100 , message="max size is 100")
	private String mostajerNameEdit;
	private String mostajerBirthdayEdit;
	@Size(max=11 , message="max size is 11")
	private String mostajerSsnEdit;	
	@Size(max=11 , message="max size is 11")
	private String mostajerMobileEdit;
	@Size(max=100 , message="max size is 100")
	private String shomareJavazEdit;
	private String tarikhEtebarEdit;
	private String hasMobasherEdit;
	@Size(max=100 , message="max size is 100")
	private String mobasherNameEdit;
	@Size(max=100 , message="max size is 100")
	private String rabetNameEdit;
	@Size(max=100 , message="max size is 100")
	private String sematRabetEdit;	
	@Size(max=11 , message="max size is 11")
	private String rabetMobileEdit;
	@Size(max=11 , message="max size is 11")
	private String shabakeMazajiMobileEdit;
	@Size(max=100 , message="max size is 100")
	///////////////////////////////
	private String mojtameEdit;
	//////////////////////////////
	private String birthDayEdit;
	
	private UIComponent sellerNameEngComponent;
	private UIComponent mobileComponent;
	private MapModel mapLoc;
	private UIComponent pic1EditComponent;
	private UIComponent pic2EditComponent;
	private UIComponent pic3EditComponent;
	private UIComponent pic4EditComponent;
	private UIComponent pic5EditComponent;
	private UIComponent pic1Component;
	private UIComponent pic2Component;
	private UIComponent pic3Component;
	private UIComponent pic4Component;
	private UIComponent pic5Component;
	private UIComponent mobileComponentAdd;
	private UIComponent sellerNameEngAddComponent;
	private UIComponent latComponent;

	public String getSellerName() {
		return sellerName;
	}
	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}
	public String getSellerStoreNamePer() {
		return sellerStoreNamePer;
	}
	public void setSellerStoreNamePer(String sellerStoreNamePer) {
		this.sellerStoreNamePer = sellerStoreNamePer;
	}
	public String getSellerStoreNameEng() {
		return sellerStoreNameEng;
	}
	public void setSellerStoreNameEng(String sellerStoreNameEng) {
		this.sellerStoreNameEng = sellerStoreNameEng;
	}
	public String getAboutUs() {
		return aboutUs;
	}
	public void setAboutUs(String aboutUs) {
		this.aboutUs = aboutUs;
	}
	public String getInstagram() {
		return instagram;
	}
	public void setInstagram(String instagram) {
		this.instagram = instagram;
	}
	public String getTelegram() {
		return telegram;
	}
	public void setTelegram(String telegram) {
		this.telegram = telegram;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getModirForoshName() {
		return modirForoshName;
	}
	public void setModirForoshName(String modirForoshName) {
		this.modirForoshName = modirForoshName;
	}
	public String getModirForoshPhone() {
		return modirForoshPhone;
	}
	public void setModirForoshPhone(String modirForoshPhone) {
		this.modirForoshPhone = modirForoshPhone;
	}
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	public String getAddres() {
		return addres;
	}
	public void setAddres(String addres) {
		this.addres = addres;
	}
	public String getVage() {
		return vage;
	}
	public void setVage(String vage) {
		this.vage = vage;
	}
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
	public UploadedFile getSellerPic1() {
		return sellerPic1;
	}
	public void setSellerPic1(UploadedFile sellerPic1) {
		this.sellerPic1 = sellerPic1;
	}
	public UploadedFile getSellerPic2() {
		return sellerPic2;
	}
	public void setSellerPic2(UploadedFile sellerPic2) {
		this.sellerPic2 = sellerPic2;
	}
	public UploadedFile getSellerPic3() {
		return sellerPic3;
	}
	public void setSellerPic3(UploadedFile sellerPic3) {
		this.sellerPic3 = sellerPic3;
	}
	public UploadedFile getSellerPic4() {
		return sellerPic4;
	}
	public void setSellerPic4(UploadedFile sellerPic4) {
		this.sellerPic4 = sellerPic4;
	}
	public UploadedFile getSellerPic5() {
		return sellerPic5;
	}
	public void setSellerPic5(UploadedFile sellerPic5) {
		this.sellerPic5 = sellerPic5;
	}
	public String getPanel() {
		return panel;
	}
	public void setPanel(String panel) {
		this.panel = panel;
	}
	public String getNoeFaaliat() {
		return noeFaaliat;
	}
	public void setNoeFaaliat(String noeFaaliat) {
		this.noeFaaliat = noeFaaliat;
	}
	public String getFaaliat() {
		return faaliat;
	}
	public void setFaaliat(String faaliat) {
		this.faaliat = faaliat;
	}
	public List<String> getFaaliats() {
		return faaliats;
	}
	public void setFaaliats(List<String> faaliats) {
		this.faaliats = faaliats;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public String getTagdir() {
		return tagdir;
	}
	public void setTagdir(String tagdir) {
		this.tagdir = tagdir;
	}
	public String getMalekiat() {
		return malekiat;
	}
	public void setMalekiat(String malekiat) {
		this.malekiat = malekiat;
	}
	public String getSabteSefaresh() {
		return sabteSefaresh;
	}
	public void setSabteSefaresh(String sabteSefaresh) {
		this.sabteSefaresh = sabteSefaresh;
	}
	public String getMostajer() {
		return mostajer;
	}
	public void setMostajer(String mostajer) {
		this.mostajer = mostajer;
	}
	public String getMohlateEjare() {
		return mohlateEjare;
	}
	public void setMohlateEjare(String mohlateEjare) {
		this.mohlateEjare = mohlateEjare;
	}
	public String getMostajerName() {
		return mostajerName;
	}
	public void setMostajerName(String mostajerName) {
		this.mostajerName = mostajerName;
	}
	public String getMostajerBirthday() {
		return mostajerBirthday;
	}
	public void setMostajerBirthday(String mostajerBirthday) {
		this.mostajerBirthday = mostajerBirthday;
	}
	public String getMostajerSsn() {
		return mostajerSsn;
	}
	public void setMostajerSsn(String mostajerSsn) {
		this.mostajerSsn = mostajerSsn;
	}
	public String getMostajerMobile() {
		return mostajerMobile;
	}
	public void setMostajerMobile(String mostajerMobile) {
		this.mostajerMobile = mostajerMobile;
	}
	public String getShomareJavaz() {
		return shomareJavaz;
	}
	public void setShomareJavaz(String shomareJavaz) {
		this.shomareJavaz = shomareJavaz;
	}
	public String getTarikhEtebar() {
		return tarikhEtebar;
	}
	public void setTarikhEtebar(String tarikhEtebar) {
		this.tarikhEtebar = tarikhEtebar;
	}
	public String getHasMobasher() {
		return hasMobasher;
	}
	public void setHasMobasher(String hasMobasher) {
		this.hasMobasher = hasMobasher;
	}
	public String getMobasherName() {
		return mobasherName;
	}
	public void setMobasherName(String mobasherName) {
		this.mobasherName = mobasherName;
	}
	public String getRabetName() {
		return rabetName;
	}
	public void setRabetName(String rabetName) {
		this.rabetName = rabetName;
	}
	public String getSematRabet() {
		return sematRabet;
	}
	public void setSematRabet(String sematRabet) {
		this.sematRabet = sematRabet;
	}
	public String getRabetMobile() {
		return rabetMobile;
	}
	public void setRabetMobile(String rabetMobile) {
		this.rabetMobile = rabetMobile;
	}
	public String getShabakeMazajiMobile() {
		return shabakeMazajiMobile;
	}
	public void setShabakeMazajiMobile(String shabakeMazajiMobile) {
		this.shabakeMazajiMobile = shabakeMazajiMobile;
	}
	public String getMojtame() {
		return mojtame;
	}
	public void setMojtame(String mojtame) {
		this.mojtame = mojtame;
	}
	public String getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}
	public String getSellerNameEdit() {
		return sellerNameEdit;
	}
	public void setSellerNameEdit(String sellerNameEdit) {
		this.sellerNameEdit = sellerNameEdit;
	}
	public String getSellerStoreNamePerEdit() {
		return sellerStoreNamePerEdit;
	}
	public void setSellerStoreNamePerEdit(String sellerStoreNamePerEdit) {
		this.sellerStoreNamePerEdit = sellerStoreNamePerEdit;
	}
	public String getSellerStoreNameEngEdit() {
		return sellerStoreNameEngEdit;
	}
	public void setSellerStoreNameEngEdit(String sellerStoreNameEngEdit) {
		this.sellerStoreNameEngEdit = sellerStoreNameEngEdit;
	}
	public String getAboutUsEdit() {
		return aboutUsEdit;
	}
	public void setAboutUsEdit(String aboutUsEdit) {
		this.aboutUsEdit = aboutUsEdit;
	}
	public String getInstagramEdit() {
		return instagramEdit;
	}
	public void setInstagramEdit(String instagramEdit) {
		this.instagramEdit = instagramEdit;
	}
	public String getTelegramEdit() {
		return telegramEdit;
	}
	public void setTelegramEdit(String telegramEdit) {
		this.telegramEdit = telegramEdit;
	}
	public String getPhoneEdit() {
		return phoneEdit;
	}
	public void setPhoneEdit(String phoneEdit) {
		this.phoneEdit = phoneEdit;
	}
	public String getWebsiteEdit() {
		return websiteEdit;
	}
	public void setWebsiteEdit(String websiteEdit) {
		this.websiteEdit = websiteEdit;
	}
	public String getEmailEdit() {
		return emailEdit;
	}
	public void setEmailEdit(String emailEdit) {
		this.emailEdit = emailEdit;
	}
	public String getFaxEdit() {
		return faxEdit;
	}
	public void setFaxEdit(String faxEdit) {
		this.faxEdit = faxEdit;
	}
	public String getModirForoshNameEdit() {
		return modirForoshNameEdit;
	}
	public void setModirForoshNameEdit(String modirForoshNameEdit) {
		this.modirForoshNameEdit = modirForoshNameEdit;
	}
	public String getModirForoshPhoneEdit() {
		return modirForoshPhoneEdit;
	}
	public void setModirForoshPhoneEdit(String modirForoshPhoneEdit) {
		this.modirForoshPhoneEdit = modirForoshPhoneEdit;
	}
	public String getPostCodeEdit() {
		return postCodeEdit;
	}
	public void setPostCodeEdit(String postCodeEdit) {
		this.postCodeEdit = postCodeEdit;
	}
	public String getAddresEdit() {
		return addresEdit;
	}
	public void setAddresEdit(String addresEdit) {
		this.addresEdit = addresEdit;
	}
	public String getVageEdit() {
		return vageEdit;
	}
	public void setVageEdit(String vageEdit) {
		this.vageEdit = vageEdit;
	}
	public String getLatEdit() {
		return latEdit;
	}
	public void setLatEdit(String latEdit) {
		this.latEdit = latEdit;
	}
	public String getLngEdit() {
		return lngEdit;
	}
	public void setLngEdit(String lngEdit) {
		this.lngEdit = lngEdit;
	}
	public UploadedFile getSellerPic1Edit() {
		return sellerPic1Edit;
	}
	public void setSellerPic1Edit(UploadedFile sellerPic1Edit) {
		this.sellerPic1Edit = sellerPic1Edit;
	}
	public UploadedFile getSellerPic2Edit() {
		return sellerPic2Edit;
	}
	public void setSellerPic2Edit(UploadedFile sellerPic2Edit) {
		this.sellerPic2Edit = sellerPic2Edit;
	}
	public UploadedFile getSellerPic3Edit() {
		return sellerPic3Edit;
	}
	public void setSellerPic3Edit(UploadedFile sellerPic3Edit) {
		this.sellerPic3Edit = sellerPic3Edit;
	}
	public UploadedFile getSellerPic4Edit() {
		return sellerPic4Edit;
	}
	public void setSellerPic4Edit(UploadedFile sellerPic4Edit) {
		this.sellerPic4Edit = sellerPic4Edit;
	}
	public UploadedFile getSellerPic5Edit() {
		return sellerPic5Edit;
	}
	public void setSellerPic5Edit(UploadedFile sellerPic5Edit) {
		this.sellerPic5Edit = sellerPic5Edit;
	}
	public String getPanelEdit() {
		return panelEdit;
	}
	public void setPanelEdit(String panelEdit) {
		this.panelEdit = panelEdit;
	}
	public String getNoeFaaliatEdit() {
		return noeFaaliatEdit;
	}
	public void setNoeFaaliatEdit(String noeFaaliatEdit) {
		this.noeFaaliatEdit = noeFaaliatEdit;
	}
	public String getFaaliatEdit() {
		return faaliatEdit;
	}
	public void setFaaliatEdit(String faaliatEdit) {
		this.faaliatEdit = faaliatEdit;
	}
	public List<String> getFaaliatsEdit() {
		return faaliatsEdit;
	}
	public void setFaaliatsEdit(List<String> faaliatsEdit) {
		this.faaliatsEdit = faaliatsEdit;
	}
	public String getMobileEdit() {
		return mobileEdit;
	}
	public void setMobileEdit(String mobileEdit) {
		this.mobileEdit = mobileEdit;
	}
	public String getSsnEdit() {
		return ssnEdit;
	}
	public void setSsnEdit(String ssnEdit) {
		this.ssnEdit = ssnEdit;
	}
	public String getTagdirEdit() {
		return tagdirEdit;
	}
	public void setTagdirEdit(String tagdirEdit) {
		this.tagdirEdit = tagdirEdit;
	}
	public String getMalekiatEdit() {
		return malekiatEdit;
	}
	public void setMalekiatEdit(String malekiatEdit) {
		this.malekiatEdit = malekiatEdit;
	}
	public String getSabteSefareshEdit() {
		return sabteSefareshEdit;
	}
	public void setSabteSefareshEdit(String sabteSefareshEdit) {
		this.sabteSefareshEdit = sabteSefareshEdit;
	}
	public String getMostajerEdit() {
		return mostajerEdit;
	}
	public void setMostajerEdit(String mostajerEdit) {
		this.mostajerEdit = mostajerEdit;
	}
	public String getMohlateEjareEdit() {
		return mohlateEjareEdit;
	}
	public void setMohlateEjareEdit(String mohlateEjareEdit) {
		this.mohlateEjareEdit = mohlateEjareEdit;
	}
	public String getMostajerNameEdit() {
		return mostajerNameEdit;
	}
	public void setMostajerNameEdit(String mostajerNameEdit) {
		this.mostajerNameEdit = mostajerNameEdit;
	}
	public String getMostajerBirthdayEdit() {
		return mostajerBirthdayEdit;
	}
	public void setMostajerBirthdayEdit(String mostajerBirthdayEdit) {
		this.mostajerBirthdayEdit = mostajerBirthdayEdit;
	}
	public String getMostajerSsnEdit() {
		return mostajerSsnEdit;
	}
	public void setMostajerSsnEdit(String mostajerSsnEdit) {
		this.mostajerSsnEdit = mostajerSsnEdit;
	}
	public String getMostajerMobileEdit() {
		return mostajerMobileEdit;
	}
	public void setMostajerMobileEdit(String mostajerMobileEdit) {
		this.mostajerMobileEdit = mostajerMobileEdit;
	}
	public String getShomareJavazEdit() {
		return shomareJavazEdit;
	}
	public void setShomareJavazEdit(String shomareJavazEdit) {
		this.shomareJavazEdit = shomareJavazEdit;
	}
	public String getTarikhEtebarEdit() {
		return tarikhEtebarEdit;
	}
	public void setTarikhEtebarEdit(String tarikhEtebarEdit) {
		this.tarikhEtebarEdit = tarikhEtebarEdit;
	}
	public String getHasMobasherEdit() {
		return hasMobasherEdit;
	}
	public void setHasMobasherEdit(String hasMobasherEdit) {
		this.hasMobasherEdit = hasMobasherEdit;
	}
	public String getMobasherNameEdit() {
		return mobasherNameEdit;
	}
	public void setMobasherNameEdit(String mobasherNameEdit) {
		this.mobasherNameEdit = mobasherNameEdit;
	}
	public String getRabetNameEdit() {
		return rabetNameEdit;
	}
	public void setRabetNameEdit(String rabetNameEdit) {
		this.rabetNameEdit = rabetNameEdit;
	}
	public String getSematRabetEdit() {
		return sematRabetEdit;
	}
	public void setSematRabetEdit(String sematRabetEdit) {
		this.sematRabetEdit = sematRabetEdit;
	}
	public String getRabetMobileEdit() {
		return rabetMobileEdit;
	}
	public void setRabetMobileEdit(String rabetMobileEdit) {
		this.rabetMobileEdit = rabetMobileEdit;
	}
	public String getShabakeMazajiMobileEdit() {
		return shabakeMazajiMobileEdit;
	}
	public void setShabakeMazajiMobileEdit(String shabakeMazajiMobileEdit) {
		this.shabakeMazajiMobileEdit = shabakeMazajiMobileEdit;
	}
	public String getMojtameEdit() {
		return mojtameEdit;
	}
	public void setMojtameEdit(String mojtameEdit) {
		this.mojtameEdit = mojtameEdit;
	}
	public String getBirthDayEdit() {
		return birthDayEdit;
	}
	public void setBirthDayEdit(String birthDayEdit) {
		this.birthDayEdit = birthDayEdit;
	}
	public MoblEntity getMoblEntity() {
		return moblEntity;
	}
	public void setMoblEntity(MoblEntity moblEntity) {
		this.moblEntity = moblEntity;
	}
	public UIComponent getSellerNameEngComponent() {
		return sellerNameEngComponent;
	}
	public void setSellerNameEngComponent(UIComponent sellerNameEngComponent) {
		this.sellerNameEngComponent = sellerNameEngComponent;
	}
	public List<MoblEntity> findAllMobl(){
		return sellerServiceLocal.findAllSeller();
	}
    public UIComponent getMobileComponent() {
		return mobileComponent;
	}
	public void setMobileComponent(UIComponent mobileComponent) {
		this.mobileComponent = mobileComponent;
	}
	
	public UIComponent getPic1EditComponent() {
		return pic1EditComponent;
	}
	public void setPic1EditComponent(UIComponent pic1EditComponent) {
		this.pic1EditComponent = pic1EditComponent;
	}
	public UIComponent getPic2EditComponent() {
		return pic2EditComponent;
	}
	public void setPic2EditComponent(UIComponent pic2EditComponent) {
		this.pic2EditComponent = pic2EditComponent;
	}
	public UIComponent getPic3EditComponent() {
		return pic3EditComponent;
	}
	public void setPic3EditComponent(UIComponent pic3EditComponent) {
		this.pic3EditComponent = pic3EditComponent;
	}
	public UIComponent getPic4EditComponent() {
		return pic4EditComponent;
	}
	public void setPic4EditComponent(UIComponent pic4EditComponent) {
		this.pic4EditComponent = pic4EditComponent;
	}
	public UIComponent getPic5EditComponent() {
		return pic5EditComponent;
	}
	public void setPic5EditComponent(UIComponent pic5EditComponent) {
		this.pic5EditComponent = pic5EditComponent;
	}
	
	public List<BlogEntity> getBlogEntities() {
		return blogEntities;
	}
	public void setBlogEntities(List<BlogEntity> blogEntities) {
		this.blogEntities = blogEntities;
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
	
	public UIComponent getMobileComponentAdd() {
		return mobileComponentAdd;
	}
	public void setMobileComponentAdd(UIComponent mobileComponentAdd) {
		this.mobileComponentAdd = mobileComponentAdd;
	}
	
	public UIComponent getSellerNameEngAddComponent() {
		return sellerNameEngAddComponent;
	}
	public void setSellerNameEngAddComponent(UIComponent sellerNameEngAddComponent) {
		this.sellerNameEngAddComponent = sellerNameEngAddComponent;
	}
	
	public UIComponent getLatComponent() {
		return latComponent;
	}
	public void setLatComponent(UIComponent latComponent) {
		this.latComponent = latComponent;
	}
	
	
	public String getMetaDescription() {
		return metaDescription;
	}
	public void setMetaDescription(String metaDescription) {
		this.metaDescription = metaDescription;
	}
	public String getMetaKeywords() {
		return metaKeywords;
	}
	public void setMetaKeywords(String metaKeywords) {
		this.metaKeywords = metaKeywords;
	}
	public String getMetaDescriptionEdit() {
		return metaDescriptionEdit;
	}
	public void setMetaDescriptionEdit(String metaDescriptionEdit) {
		this.metaDescriptionEdit = metaDescriptionEdit;
	}
	public String getMetaKeywordsEdit() {
		return metaKeywordsEdit;
	}
	public void setMetaKeywordsEdit(String metaKeywordsEdit) {
		this.metaKeywordsEdit = metaKeywordsEdit;
	}
	public String convertDateToPer(Date date) {
    	if(!date.equals(null) || !date.equals(""))
    	return TimeCovnertor.findPersianDate(date);
    	else
    	return "بدون تاریخ";
    }
    
    public Date conertPersianToDate(String persianDate) {
    	return TimeCovnertor.mohlateEjareChangeDate(persianDate);
    }
    
    public void deleteMobl() {
    	sellerServiceLocal.deleteSeller(moblEntity);
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("*****************************با موفقیت حذف گردید************************"));
    }
    
    public void onPointSelect(PointSelectEvent event) {
        LatLng latlng = event.getLatLng();
        this.latEdit=String.valueOf(latlng.getLat());
        this.lngEdit=String.valueOf(latlng.getLng());
    }
    
    public void onPointSelect2(PointSelectEvent event) {
        LatLng latlng = event.getLatLng();
        this.lat=String.valueOf(latlng.getLat());
        this.lng=String.valueOf(latlng.getLng());
    }
    
	private String faaliatHaEdit() {
		try {
		String item="";
		for (String string : this.faaliatsEdit) {
			item=item +string + "-";
		}
		return item;
		}catch (Exception e) {
			System.err.println();
			return "";
		}
		}
	
	public MoblEntity findSellerByNameEng(String nameEng) {
		try {
			return sellerServiceLocal.findSellerByNameEng(nameEng);
		} catch (Exception e) {
			return null;
		}
	}
	
	public MoblEntity findSellerByMobile(String mobile) {
		try {
			return sellerServiceLocal.findSellerByMobile(mobile);
		} catch (Exception e) {
			return null;
		}
	}
	
	public String convertTextFromFile(String text) {
		try {
			return FileConvertor.convertTextFileToText(text);
		} catch (Exception e) {
			return null;
		}
	}
	
	public String convertBoolean(boolean inBool) {
		if(inBool==true)
			return "دارد";
		else
			return "ندارد";
	}
	
	public String convertPanel(String panelType) {
		if(panelType.equals("A"))
			return "فیروزه ای";
		else if(panelType.equals("B"))
			return "طلایی";
		else if(panelType.equals("C"))
			return "نقره ای";
		else if(panelType.equals("D"))
			return "برنزی";
		else
			return "عادی";
	}
	
    public MapModel findLocation(double lat,double lng) {
        mapLoc = new DefaultMapModel();
        LatLng coord1 = new LatLng(lat, lng);
        mapLoc.addOverlay(new Marker(coord1, "Store"));
        return mapLoc;
    }
    
    public String convertToPersianDate(Date date) {
    	if(date!=null)
    	return TimeCovnertor.findPersianDate(date);
    	else
    	return "وارد نشده است";
    }
    
    public String convertPicture(UploadedFile uploadedFile) {
    	try {
			return FileConvertor.convertPicture(uploadedFile);
		} catch (Exception e) {
			return null;
		}
    }
    
	public List<BlogEntity> findAllPassage() {

        blogEntities.clear();
		for (BlogEntity blogEntity : blogServiceLocal.findAllBlog()) {
			if (blogEntity.getBlogType().equals("A")) {
				blogEntities.add(blogEntity);
				}
		}
		return blogEntities;
		}
	
	private String faaliatHa() {
		String item="";
		if(this.faaliats!=null) {
		for (String string : this.faaliats) {
			item=item +string + "-";
		}
		return item;
		}else {
		return "";
		}
	}
    
    public void updateSeller() {

		try {
			if(!metaDescriptionEdit.equals(""))
			this.moblEntity.setMetaDescription(metaDescriptionEdit);
			if(!metaKeywordsEdit.equals(""))
			this.moblEntity.setMetaKeywords(metaKeywordsEdit);
			if(!faaliatHaEdit().equals(""))
			this.moblEntity.setFaaliat(this.faaliatHaEdit());
			if(!aboutUsEdit.equals(""))
			this.moblEntity.setAboutUs(aboutUsEdit);
			if(!tagdirEdit.equals(""))
			this.moblEntity.setTagdirName(FileConvertor.convertTextFile(tagdirEdit));			
			if(!emailEdit.equals(""))
			this.moblEntity.setEmail(emailEdit);
			if(!faxEdit.equals(""))
			this.moblEntity.setFax(faxEdit);
			if(!instagramEdit.equals(""))
			this.moblEntity.setInstagram(instagramEdit);
			if(!modirForoshNameEdit.equals(""))
			this.moblEntity.setModirforoshName(modirForoshNameEdit);
			if(!modirForoshPhoneEdit.equals(""))
			this.moblEntity.setModirforoshPhone(modirForoshPhoneEdit);
			if(!phoneEdit.equals(""))
			this.moblEntity.setPhone(phoneEdit);
			if(!postCodeEdit.equals(""))
			this.moblEntity.setPostcode(postCodeEdit);
			if(!addresEdit.equals(""))
			this.moblEntity.setSellerAddres(addresEdit);
			if(!sellerNameEdit.equals(""))
			this.moblEntity.setSellerName(sellerNameEdit);
			if(!sellerStoreNameEngEdit.equals("")) {
				if(findSellerByNameEng(sellerStoreNameEngEdit)==null)
			        this.moblEntity.setSellerStoreEng(sellerStoreNameEngEdit);
				else
					throw new IOException();
			}
			if(!mobileEdit.equals("")) {
				if(findSellerByMobile(mobileEdit)==null)
			        this.moblEntity.setMobile(mobileEdit);
				else 
					throw new ClassCastException();
			}
			if(!sellerStoreNamePerEdit.equals(""))
			this.moblEntity.setSellerStorePer(sellerStoreNamePerEdit);
			if(!telegramEdit.equals(""))
			this.moblEntity.setTelegram(telegramEdit);
			if(!websiteEdit.equals(""))
			this.moblEntity.setWebsite(websiteEdit);
			if(!ssnEdit.equals(""))
			this.moblEntity.setSsn(ssnEdit);
			try {
			if((!malekiatEdit.equals(""))|(!malekiatEdit.equals(null))) {
				this.moblEntity.setMalekiat(malekiatEdit);
			}
			}catch (NullPointerException e) {
				System.err.println("malekiatEdit null point");
			}
			if(!vageEdit.equals(""))
			this.moblEntity.setVage(vageEdit);
			if(!mostajerNameEdit.equals("")) {
			this.moblEntity.setMostajerName(mostajerNameEdit);
			}
			if(!mostajerSsnEdit.equals("")) {
			this.moblEntity.setMostajerSsn(mostajerSsnEdit);
			}
			if(!mostajerMobileEdit.equals("")) {
			this.moblEntity.setMostajerMobile(mostajerMobileEdit);
			}
			if(!shomareJavazEdit.equals("")) {
			this.moblEntity.setShomareJavaz(shomareJavazEdit);
			}
			if(!mobasherNameEdit.equals("")) {
			this.moblEntity.setMobasherName(mobasherNameEdit);
			}
			if(!rabetNameEdit.equals("")) {
			this.moblEntity.setRabetName(rabetNameEdit);
			}
			if(!sematRabetEdit.equals("")) {
			this.moblEntity.setSematRabet(sematRabetEdit);
			}
			if(!rabetMobileEdit.equals("")) {
			this.moblEntity.setRabetMobile(rabetMobileEdit);
			}
			if(!shabakeMazajiMobileEdit.equals("")) {
			this.moblEntity.setShabakeMazajiMobile(shabakeMazajiMobileEdit);
			}
			try {
			if((!hasMobasherEdit.equals(null))|(!hasMobasherEdit.equals(""))) {
			this.moblEntity.setHasMobasher(Boolean.parseBoolean(hasMobasherEdit));
			}
			}catch (NullPointerException e) {
			System.err.println("hasMobasher null point");
			}
 			try {
 			if((!mostajerEdit.equals(""))|(!mostajerEdit.equals(null))) {
 			this.moblEntity.setMostajer(Boolean.parseBoolean(mostajerEdit));
 			}
 		    }catch (NullPointerException e) {
 			System.err.println("mostajer null point");
 		    }
			try {
			if((!sabteSefareshEdit.equals(""))|(!sabteSefareshEdit.equals(null))) {
				this.moblEntity.setSabteSefaresh(sabteSefareshEdit);
			}
			}catch (NullPointerException e) {
				System.err.println("sabteSefaresh null point");
			}
			try {
			if((!panelEdit.equals(null))|(!panelEdit.equals("")))
			this.moblEntity.setPanel(panelEdit);
			}catch (Exception e) {
				System.err.println("exe");
			}
			try {
			if((!mojtameEdit.equals(""))|(!mojtameEdit.equals(null))) {
			this.moblEntity.setMojtame(mojtameEdit);
			}
			}catch (NullPointerException e) {
			System.err.println("mojtame null point");
			}
			if(!latEdit.equals("")) {
			this.moblEntity.setLat(Double.parseDouble(latEdit));
			}
			if(!lngEdit.equals("")) {
			this.moblEntity.setLng(Double.parseDouble(lngEdit));
			}
			if(!mohlateEjareEdit.equals("")) {
			this.moblEntity.setMohlateEjare(TimeCovnertor.mohlateEjareChangeDate(mohlateEjareEdit));
			}
			if(!mostajerBirthdayEdit.equals("")) {
			this.moblEntity.setMostajerBirthday(TimeCovnertor.mohlateEjareChangeDate(mostajerBirthdayEdit));
			}
			if(!tarikhEtebarEdit.equals("")) {
			this.moblEntity.setTarikhEtebar(TimeCovnertor.mohlateEjareChangeDate(tarikhEtebarEdit));
			}
			if(!birthDayEdit.equals("")) {
			this.moblEntity.setBirthDate(TimeCovnertor.mohlateEjareChangeDate(birthDayEdit));
			}
			if (sellerPic1Edit != null) {
				if (sellerPic1Edit.getSize() > 150000) {
					throw new Exception("pic1Size");
				} else if (!sellerPic1Edit.getContentType().equals("image/jpeg")) {
					throw new Exception("pic1Type");
				} else {
					this.moblEntity.setPic1(convertPicture(sellerPic1Edit));
				}
			}
			if (sellerPic2Edit != null) {
				if (sellerPic2Edit.getSize() > 150000) {
					throw new Exception("pic2Size");
				} else if (!sellerPic2Edit.getContentType().equals("image/jpeg")) {
					throw new Exception("pic2Type");
				} else {
					this.moblEntity.setPic2(convertPicture(sellerPic2Edit));
				}
			}
			if (sellerPic3Edit != null) {
				if (sellerPic3Edit.getSize() > 150000) {
					throw new Exception("pic3Size");
				} else if (!sellerPic3Edit.getContentType().equals("image/jpeg")) {
					throw new Exception("pic3Type");
				} else {
					this.moblEntity.setPic3(convertPicture(sellerPic3Edit));
				}
			}
			if (sellerPic4Edit != null) {
				if (sellerPic4Edit.getSize() > 150000) {
					throw new Exception("pic4Size");
				} else if (!sellerPic4Edit.getContentType().equals("image/jpeg")) {
					throw new Exception("pic4Type");
				} else {
					this.moblEntity.setPic4(convertPicture(sellerPic4Edit));
				}
			}
			if (sellerPic5Edit != null) {
				if (sellerPic5Edit.getSize() > 150000) {
					throw new Exception("pic5Size");
				} else if (!sellerPic5Edit.getContentType().equals("image/jpeg")) {
					throw new Exception("pic5Type");
				} else {
					this.moblEntity.setPic5(convertPicture(sellerPic5Edit));
				}
			}
			sellerServiceLocal.updateSeller(this.moblEntity);
			this.aboutUsEdit="";
			this.emailEdit="";
			this.faxEdit="";
			this.instagramEdit="";
			this.latEdit="";
			this.lngEdit="";
			this.mobileEdit="";
			this.modirForoshNameEdit="";
			this.modirForoshPhoneEdit="";
			this.noeFaaliatEdit="";
			this.panelEdit="";
			this.phoneEdit="";
			this.postCodeEdit="";
			this.addresEdit="";
			this.sellerNameEdit="";
			this.sellerStoreNameEngEdit="";
			this.sellerStoreNamePerEdit="";
			this.ssnEdit="";
			this.telegramEdit="";
			this.websiteEdit="";
			this.vageEdit="";
			this.tagdirEdit="";
			this.mostajerNameEdit="";
			this.mostajerSsnEdit="";
			this.mostajerMobileEdit="";
			this.shomareJavazEdit="";
			this.mobasherNameEdit="";
			this.rabetNameEdit="";
			this.sematRabetEdit="";
			this.rabetMobileEdit="";
			this.shabakeMazajiMobileEdit="";
			this.latEdit="";
			this.lngEdit="";
			this.malekiatEdit="";
			this.mohlateEjareEdit="";
			this.mostajerBirthdayEdit="";
			this.tarikhEtebarEdit="";
			this.birthDayEdit="";
			this.metaDescriptionEdit="";
			this.metaKeywordsEdit="";
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("با موفقیت آپدیت گردید."));
			} catch (IOException e) {
				FacesContext.getCurrentInstance().addMessage(sellerNameEngComponent.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "این نام قبلا ثبت شده است", null));
			}catch (ClassCastException e) {
				FacesContext.getCurrentInstance().addMessage(mobileComponent.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "این شماره موبایل قبلا ثبت شده است", null));
			}
		    catch (Exception e) {
		    	if(e.getMessage().equals("pic1Size"))
		    		FacesContext.getCurrentInstance().addMessage(pic1EditComponent.getClientId(),
							new FacesMessage(FacesMessage.SEVERITY_ERROR, "size must minimum 150k", null));
		    	if(e.getMessage().equals("pic1Type"))
		    		FacesContext.getCurrentInstance().addMessage(pic1EditComponent.getClientId(),
							new FacesMessage(FacesMessage.SEVERITY_ERROR, "type must be jpg", null));
		    	if(e.getMessage().equals("pic2Size"))
		    		FacesContext.getCurrentInstance().addMessage(pic2EditComponent.getClientId(),
							new FacesMessage(FacesMessage.SEVERITY_ERROR, "size must minimum 150k", null));
		    	if(e.getMessage().equals("pic2Type"))
		    		FacesContext.getCurrentInstance().addMessage(pic2EditComponent.getClientId(),
							new FacesMessage(FacesMessage.SEVERITY_ERROR, "type must be jpg", null));
		    	if(e.getMessage().equals("pic3Size"))
		    		FacesContext.getCurrentInstance().addMessage(pic3EditComponent.getClientId(),
							new FacesMessage(FacesMessage.SEVERITY_ERROR, "size must minimum 150k", null));
		    	if(e.getMessage().equals("pic3Type"))
		    		FacesContext.getCurrentInstance().addMessage(pic3EditComponent.getClientId(),
							new FacesMessage(FacesMessage.SEVERITY_ERROR, "type must be jpg", null));
		    	if(e.getMessage().equals("pic4Size"))
		    		FacesContext.getCurrentInstance().addMessage(pic4EditComponent.getClientId(),
							new FacesMessage(FacesMessage.SEVERITY_ERROR, "size must minimum 150k", null));
		    	if(e.getMessage().equals("pic4Type"))
		    		FacesContext.getCurrentInstance().addMessage(pic4EditComponent.getClientId(),
							new FacesMessage(FacesMessage.SEVERITY_ERROR, "type must be jpg", null));
		    	if(e.getMessage().equals("pic5Size"))
		    		FacesContext.getCurrentInstance().addMessage(pic5EditComponent.getClientId(),
							new FacesMessage(FacesMessage.SEVERITY_ERROR, "size must minimum 150k", null));
		    	if(e.getMessage().equals("pic5Type"))
		    		FacesContext.getCurrentInstance().addMessage(pic5EditComponent.getClientId(),
							new FacesMessage(FacesMessage.SEVERITY_ERROR, "type must be jpg", null));
		    	if(e.getMessage()==null)
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "خطا در ارتباط با دیتابیس", null));
			}
    
	}
    public void insertSeller() {
		try {	
		MoblEntity moblEntity=new MoblEntity();
		moblEntity.setMetaDescription(metaDescription);
		moblEntity.setMetaKeywords(metaKeywords);
		moblEntity.setAboutUs(aboutUs);
		moblEntity.setEmail(email);
		moblEntity.setFax(fax);
		moblEntity.setInstagram(instagram);
		if(!lat.equals(""))
		moblEntity.setLat(Double.parseDouble(lat));
		else
		throw new Exception("nullLat");
		if(!lng.equals(""))
		moblEntity.setLng(Double.parseDouble(lng));
		else
		throw new Exception("nullLat");
		moblEntity.setModirforoshName(modirForoshName);
		moblEntity.setModirforoshPhone(modirForoshPhone);
		moblEntity.setPhone(phone);
		moblEntity.setPostcode(postCode);
		moblEntity.setSellerAddres(addres);
		moblEntity.setSellerName(sellerName);
		if(!sellerStoreNameEng.equals("")) {
		if(findSellerByNameEng(sellerStoreNameEng)==null)
		moblEntity.setSellerStoreEng(sellerStoreNameEng);
	    else
		throw new Exception("storeEng");
		}
		else
		{
		throw new Exception("storeEngNull");
		}
		moblEntity.setSellerStorePer(sellerStoreNamePer);
		moblEntity.setTelegram(telegram);
		moblEntity.setWebsite(website);
		moblEntity.setNoeFaaliat(noeFaaliat);
		moblEntity.setPanel(panel);
		moblEntity.setSsn(ssn);
		if(!mobile.equals("")) {
		if(findSellerByMobile(mobile)==null)
		moblEntity.setMobile(mobile);
		else 
		throw new Exception("mobileExist");
		}else {
		throw new Exception("mobileNull");
		}
		moblEntity.setVage(vage);
		moblEntity.setFaaliat(this.faaliatHa());
		moblEntity.setRole(UserRole.MERCHANT);
		moblEntity.setTagdirName(FileConvertor.convertTextFile(tagdir));
		/////////////////////////////////////////////////////
		moblEntity.setMalekiat(malekiat);
		moblEntity.setMojtame(mojtame);
		moblEntity.setSabteSefaresh(sabteSefaresh);
		if(mostajer!=null)
		moblEntity.setMostajer(Boolean.parseBoolean(mostajer));
		else
		moblEntity.setMostajer(false);	
		if(!mohlateEjare.equals(null)||!mohlateEjare.equals(""))
		moblEntity.setMohlateEjare(TimeCovnertor.mohlateEjareChangeDate(mohlateEjare));
		else
		moblEntity.setMohlateEjare(null);
		moblEntity.setMostajerName(mostajerName);
		if(!mostajerBirthday.equals(null)||!mostajerBirthday.equals(""))
		moblEntity.setMostajerBirthday(TimeCovnertor.mohlateEjareChangeDate(mostajerBirthday));
		else 
		moblEntity.setMostajerBirthday(null);
		moblEntity.setMostajerSsn(mostajerSsn);
		moblEntity.setMostajerMobile(mostajerMobile);
		moblEntity.setShomareJavaz(shomareJavaz);
		if(!tarikhEtebar.equals(null)||!tarikhEtebar.equals(""))
		moblEntity.setTarikhEtebar(TimeCovnertor.mohlateEjareChangeDate(tarikhEtebar));
		else
		moblEntity.setTarikhEtebar(null);
		if(hasMobasher!=null)
		moblEntity.setHasMobasher(Boolean.parseBoolean(hasMobasher));
		else
		moblEntity.setHasMobasher(false);
		moblEntity.setMobasherName(mobasherName);
		moblEntity.setRabetName(rabetName);
		moblEntity.setSematRabet(sematRabet);
		moblEntity.setRabetMobile(rabetMobile);
		moblEntity.setShabakeMazajiMobile(shabakeMazajiMobile);
		if(!birthDay.equals(null)||!birthDay.equals(""))
		moblEntity.setBirthDate(TimeCovnertor.mohlateEjareChangeDate(birthDay));
		else
		moblEntity.setBirthDate(null);
		if (sellerPic1 != null) {
			if (sellerPic1.getSize() > 150000) {
				throw new Exception("pic1Size");
			} else if (!sellerPic1.getContentType().equals("image/jpeg")) {
				throw new Exception("pic1Type");
			} else {
				moblEntity.setPic1(convertPicture(sellerPic1));
			}
		}
		if (sellerPic2 != null) {
			if (sellerPic2.getSize() > 150000) {
				throw new Exception("pic2Size");
			} else if (!sellerPic2.getContentType().equals("image/jpeg")) {
				throw new Exception("pic2Type");
			} else {
				moblEntity.setPic2(convertPicture(sellerPic2));
			}
		}
		if (sellerPic3 != null) {
			if (sellerPic3.getSize() > 150000) {
				throw new Exception("pic3Size");
			} else if (!sellerPic3.getContentType().equals("image/jpeg")) {
				throw new Exception("pic3Type");
			} else {
				moblEntity.setPic3(convertPicture(sellerPic3));
			}
		}
		if (sellerPic4 != null) {
			if (sellerPic4.getSize() > 150000) {
				throw new Exception("pic4Size");
			} else if (!sellerPic4.getContentType().equals("image/jpeg")) {
				throw new Exception("pic4Type");
			} else {
				moblEntity.setPic4(convertPicture(sellerPic4));
			}
		}
		if (sellerPic5 != null) {
			if (sellerPic5.getSize() > 150000) {
				throw new Exception("pic5Size");
			} else if (!sellerPic5.getContentType().equals("image/jpeg")) {
				throw new Exception("pic5Type");
			} else {
				moblEntity.setPic5(convertPicture(sellerPic5));
			}
		}
		sellerServiceLocal.insertSeller(moblEntity);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("*****************************با موفقیت وارد گردید************************"));
		this.aboutUs="";
		this.addres="";
		this.email="";
		this.fax="";
		this.instagram="";
		this.lat="";
		this.lng="";
		this.mobile="";
		this.modirForoshName="";
		this.modirForoshPhone="";
		this.noeFaaliat="";
		this.panel="";
		this.phone="";
		this.postCode="";
		this.sellerName="";
		this.ssn="";
		this.vage="";
		this.telegram="";
		this.website="";
		this.sellerStoreNamePer="";
		this.sellerStoreNameEng="";
		this.tagdir="";
		this.malekiat="";
		this.sabteSefaresh="";
		this.mohlateEjare="";
		this.mostajerName="";
		this.mostajerBirthday="";
		this.mostajerSsn="";
		this.mostajerMobile="";
		this.shomareJavaz="";
		this.tarikhEtebar="";
		this.mobasherName="";
		this.rabetName="";
		this.sematRabet="";
		this.rabetMobile="";
		this.shabakeMazajiMobile="";
		this.birthDay="";
		}
		catch(Exception e) {
			if(e.getMessage().equals("mobileExist"))
			FacesContext.getCurrentInstance().addMessage(mobileComponentAdd.getClientId(), new FacesMessage(FacesMessage.SEVERITY_ERROR, "این کاربر در سیستم وجود دارد", "این کاربر در سیستم وجود دارد"));
			if(e.getMessage().equals("mobileNull"))
			FacesContext.getCurrentInstance().addMessage(mobileComponentAdd.getClientId(), new FacesMessage(FacesMessage.SEVERITY_ERROR, "شماره موبایل نباید خالی باشد", "شماره موبایل نباید خالی باشد"));
			if(e.getMessage().equals("storeEng"))
			FacesContext.getCurrentInstance().addMessage(sellerNameEngAddComponent.getClientId(), new FacesMessage(FacesMessage.SEVERITY_ERROR, "این نام قبلا استفاده شده است", "این نام قبلا استفاده شده است"));
			if(e.getMessage().equals("storeEngNull"))
			FacesContext.getCurrentInstance().addMessage(sellerNameEngAddComponent.getClientId(), new FacesMessage(FacesMessage.SEVERITY_ERROR, "نام انگلیسی نباید خالی باشد", "نام انگلیسی نباید خالی باشد"));	
			if(e.getMessage().equals("nullLat"))
			FacesContext.getCurrentInstance().addMessage(latComponent.getClientId(), new FacesMessage(FacesMessage.SEVERITY_ERROR, "فیلد موقعیت نباید خالی باشد", "فیلد موقعیت نباید خالی باشد"));
			if(e.getMessage().equals("pic1Size"))
	    		FacesContext.getCurrentInstance().addMessage(pic1Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "size must minimum 150k", null));
	    	if(e.getMessage().equals("pic1Type"))
	    		FacesContext.getCurrentInstance().addMessage(pic1Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "type must be jpg", null));
	    	if(e.getMessage().equals("pic2Size"))
	    		FacesContext.getCurrentInstance().addMessage(pic2Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "size must minimum 150k", null));
	    	if(e.getMessage().equals("pic2Type"))
	    		FacesContext.getCurrentInstance().addMessage(pic2Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "type must be jpg", null));
	    	if(e.getMessage().equals("pic3Size"))
	    		FacesContext.getCurrentInstance().addMessage(pic3Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "size must minimum 150k", null));
	    	if(e.getMessage().equals("pic3Type"))
	    		FacesContext.getCurrentInstance().addMessage(pic3Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "type must be jpg", null));
	    	if(e.getMessage().equals("pic4Size"))
	    		FacesContext.getCurrentInstance().addMessage(pic4Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "size must minimum 150k", null));
	    	if(e.getMessage().equals("pic4Type"))
	    		FacesContext.getCurrentInstance().addMessage(pic4Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "type must be jpg", null));
	    	if(e.getMessage().equals("pic5Size"))
	    		FacesContext.getCurrentInstance().addMessage(pic5Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "size must minimum 150k", null));
	    	if(e.getMessage().equals("pic5Type"))
	    		FacesContext.getCurrentInstance().addMessage(pic5Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "type must be jpg", null));
			if(e.getMessage()==null)
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "خطا در ارتباط با دیتابیس", null));
		e.printStackTrace();
		}
		}
}


