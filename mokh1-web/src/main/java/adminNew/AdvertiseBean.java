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
	@Size(max=200 , message="ماکزیمم 200 کاراکتر")
	private String email;
	@Size(max=200 , message="ماکزیمم 200 کاراکتر")
	private String site;
	//////////////////////////////////karfarma/////////////////////


	@Size(max=200 , message="ماکزیمم 200 کاراکتر")
	private String karfarmaCompanyName;
	@Size(max=100 , message="ماکزیمم 100 کاراکتر")
	private String karfarmaNiroMorede;
	@Size(max=500 , message="ماکزیمم 500 کاراکتر")
	private String karfarmaTakhasosMorede;
	private Long mizanHogog=(long) 1000;
	private Long minSabege=(long) 1;
	@Size(max=200 , message="ماکزیمم 200 کاراکتر")
	private String magtaTahsisli;
	@Size(max=200 , message="ماکزیمم 200 کاراکتر")
	private String reshte;
	private Long sen=(long) 1;
	@Size(max=200 , message="ماکزیمم 200 کاراکتر")
	private String takhasos;
	@Size(max=200 , message="ماکزیمم 200 کاراکتر")
	private String jensiat;
	@Size(max=200 , message="ماکزیمم 200 کاراکتر")
	private String noeHamkari;
	@Size(max=200 , message="ماکزیمم 200 کاراکتر")
	private String noeHogog;
	@Size(max=200 , message="ماکزیمم 200 کاراکتر")
	private String saatKari;
	@Size(max=200 , message="ماکزیمم 200 کاراکتر")
	private String bime;
	@Size(max=200 , message="ماکزیمم 200 کاراکتر")
	private String bimeTakmili;
	@Size(max=200 , message="ماکزیمم 200 کاراکتر")
	private String ezafekar;
	@Size(max=200 , message="ماکزیمم 200 کاراکتر")
	private String morekhasi;
	
	////////////////////////////////karjo

	@Size(max=100 , message="ماکزیمم 100 کاراکتر")
	private String karjoField;
	@Size(max=100 , message="ماکزیمم 100 کاراکتر")
	private String karjoMadrak;

	@Size(max=20 , message="ماکزیمم 100 کاراکتر")
	private String karjoNoeHamkari;
	@Size(max=100 , message="ماکزیمم 100 کاراکتر")
	private String birthDay;
	@Size(max=100 , message="ماکزیمم 100 کاراکتر")
	private String mahaleTavalod;
	@Size(max=100 , message="ماکزیمم 100 کاراکتر")
	private String vaziatTahol;
	@Size(max=100 , message="ماکزیمم 100 کاراکتر")
	private String khedmat;
	private Long sabege=(long) 1;
	private Long bimeSabege=(long) 1;
	@Size(max=100 , message="ماکزیمم 100 کاراکتر")
	private String vaziatEshtegal;
	@Size(max=200 , message="ماکزیمم 200 کاراکتر")
	private String elateTarkeKar;
	@Size(max=200 , message="ماکزیمم 200 کاراکتر")
	private String shogleDarkhast;
	@Size(max=200 , message="ماکزیمم 200 کاراکتر")
	private String takhasosKarjo;
	@Size(max=200 , message="ماکزیمم 200 کاراکتر")
	private String dorehaVmadarek;
	@Column(name = "hogogKarjo", nullable = true)
	private Long hogogKarjo=(long) 1000;
	
	////////////////////////////rent////////////////////
	@Size(max=100 , message="ماکزیمم 100 کاراکتر")
	private String rentType;
	@Size(max=100 , message="ماکزیمم 100 کاراکتر")
	private String homeType;
	@Size(max=100 , message="ماکزیمم 100 کاراکتر")
	private String karbariSanad;
	@Size(max=100 , message="ماکزیمم 100 کاراکتر")
	private String noeSanad;
	private Long metraj=(long) 1;
	private Long priceMetr=(long) 1;
	private Long phoneLine=(long) 1;
	@Size(max=200 , message="ماکزیمم 200 کاراکتر")
	private String saleSakht;
	
	@Size(max=20 , message="ماکزیمم 20 کاراکتر")
	private String jahateMelk;
	
	@Size(max=20 , message="ماکزیمم 20 کاراکتر")
	private String mahaleSakhteman;

	@Size(max=200 , message="ماکزیمم 200 کاراکتر")
	private String namayeMelk;
	
	@Size(max=200 , message="ماکزیمم 200 کاراکتر")
	private String kaf;
	
	@Size(max=200 , message="ماکزیمم 200 کاراکتر")
	private String posheshDivar;
	
	@Size(max=200 , message="ماکزیمم 200 کاراکتر")
	private String vaziatRoshanayi;
	
	@Size(max=50 , message="ماکزیمم 50 کاراکتر")
	private String vaziatsystemGarmayesh;
	
	@Size(max=50 , message="ماکزیمم 50 کاراکتر")
	private String abGarm;
	
	
	@Size(max=50 , message="ماکزیمم 50 کاراکتر")
	private String moshaat;
	
	@Size(max=50 , message="ماکزیمم 50 کاراکتر")
	private String moshaatAbi;
	
	@Size(max=50 , message="ماکزیمم 50 کاراکتر")
	private String chahAbi;
	
	
	@Size(max=50 , message="ماکزیمم 50 کاراکتر")
	private String fazayeSabz;
	
	
	@Size(max=50 , message="ماکزیمم 50 کاراکتر")
	private String view;
	
	@Size(max=50 , message="ماکزیمم 50 کاراکتر")
	private String anbari;
	
	@Size(max=50 , message="ماکزیمم 50 کاراکتر")
	private String parking;
	
	@Size(max=50 , message="ماکزیمم 50 کاراکتر")
	private String telephone;
	
	
	@Size(max=50 , message="ماکزیمم 50 کاراکتر")
	private String tabloKhor;
	
	
	@Size(max=50 , message="ماکزیمم 50 کاراکتر")
	private String serviceBehdashti;
	
	@Size(max=500 , message="ماکزیمم 500 کاراکتر")
	private String digarEmkanat;
	
	@Size(max=100 , message="ماکزیمم 100 کاراکتر")
	private String saateBazdid;


	////////////////////////machin/////////////
	
	@Size(max=200 , message="ماکزیمم 200 کاراکتر")
	private String machineName;
	@Size(max=100 , message="ماکزیمم 100 کاراکتر")
	private String contry;
	@Size(max=100 , message="ماکزیمم 100 کاراکتر")
	private String brand;
	@Size(max=100 , message="ماکزیمم 100 کاراکتر")
	private String saleTolid;
	@Size(max=100 , message="ماکزیمم 20 کاراکتر")
	private String vaziat;
	@Size(max=1000 , message="ماکزیمم 1000 کاراکتر")
	private String moshakhasat;
	private Long mablag=(long) 1;
	@Size(max=100 , message="ماکزیمم 100 کاراکتر")
	private String mahaleForosh;
	@Size(max=200 , message="ماکزیمم 200 کاراکتر")
	private String lavazemJanebi;
	@Size(max=200 , message="ماکزیمم 200 کاراکتر")
	private String seriOrCode;
	@Size(max=200 , message="ماکزیمم 200 کاراکتر")
	private String karbord;
	@Size(max=200 , message="ماکزیمم 200 کاراکتر")
	private String zemanat;
	private Long modateZemanat=(long) 1;
	@Size(max=200 , message="ماکزیمم 200 کاراکتر")
	private String saateBazdidMachine;
/////////////////////////////////////////
	private AdvertiseEntity advertiseEntity;
	private boolean enableAdvertise;
	private Object advertiseDetail;
	
	

	public Long getPhoneLine() {
		return phoneLine;
	}


	public void setPhoneLine(Long phoneLine) {
		this.phoneLine = phoneLine;
	}


	public String getRentType() {
		return rentType;
	}


	public void setRentType(String rentType) {
		this.rentType = rentType;
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


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
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


	public String getKarfarmaCompanyName() {
		return karfarmaCompanyName;
	}


	public void setKarfarmaCompanyName(String karfarmaCompanyName) {
		this.karfarmaCompanyName = karfarmaCompanyName;
	}


	public String getKarfarmaNiroMorede() {
		return karfarmaNiroMorede;
	}


	public void setKarfarmaNiroMorede(String karfarmaNiroMorede) {
		this.karfarmaNiroMorede = karfarmaNiroMorede;
	}


	public String getKarfarmaTakhasosMorede() {
		return karfarmaTakhasosMorede;
	}


	public void setKarfarmaTakhasosMorede(String karfarmaTakhasosMorede) {
		this.karfarmaTakhasosMorede = karfarmaTakhasosMorede;
	}


	public Long getMizanHogog() {
		return mizanHogog;
	}


	public void setMizanHogog(Long mizanHogog) {
		this.mizanHogog = mizanHogog;
	}


	public Long getMinSabege() {
		return minSabege;
	}


	public void setMinSabege(Long minSabege) {
		this.minSabege = minSabege;
	}


	public String getMagtaTahsisli() {
		return magtaTahsisli;
	}


	public void setMagtaTahsisli(String magtaTahsisli) {
		this.magtaTahsisli = magtaTahsisli;
	}


	public String getReshte() {
		return reshte;
	}


	public void setReshte(String reshte) {
		this.reshte = reshte;
	}


	public Long getSen() {
		return sen;
	}


	public void setSen(Long sen) {
		this.sen = sen;
	}


	public String getTakhasos() {
		return takhasos;
	}


	public void setTakhasos(String takhasos) {
		this.takhasos = takhasos;
	}


	public String getJensiat() {
		return jensiat;
	}


	public void setJensiat(String jensiat) {
		this.jensiat = jensiat;
	}


	public String getNoeHamkari() {
		return noeHamkari;
	}


	public void setNoeHamkari(String noeHamkari) {
		this.noeHamkari = noeHamkari;
	}


	public String getNoeHogog() {
		return noeHogog;
	}


	public void setNoeHogog(String noeHogog) {
		this.noeHogog = noeHogog;
	}


	public String getSaatKari() {
		return saatKari;
	}


	public void setSaatKari(String saatKari) {
		this.saatKari = saatKari;
	}


	public String getBime() {
		return bime;
	}


	public void setBime(String bime) {
		this.bime = bime;
	}


	public String getBimeTakmili() {
		return bimeTakmili;
	}


	public void setBimeTakmili(String bimeTakmili) {
		this.bimeTakmili = bimeTakmili;
	}


	public String getEzafekar() {
		return ezafekar;
	}


	public void setEzafekar(String ezafekar) {
		this.ezafekar = ezafekar;
	}


	public String getMorekhasi() {
		return morekhasi;
	}


	public void setMorekhasi(String morekhasi) {
		this.morekhasi = morekhasi;
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


	public String getKarjoNoeHamkari() {
		return karjoNoeHamkari;
	}


	public void setKarjoNoeHamkari(String karjoNoeHamkari) {
		this.karjoNoeHamkari = karjoNoeHamkari;
	}


	public String getBirthDay() {
		return birthDay;
	}


	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}


	public String getMahaleTavalod() {
		return mahaleTavalod;
	}


	public void setMahaleTavalod(String mahaleTavalod) {
		this.mahaleTavalod = mahaleTavalod;
	}


	public String getVaziatTahol() {
		return vaziatTahol;
	}


	public void setVaziatTahol(String vaziatTahol) {
		this.vaziatTahol = vaziatTahol;
	}


	public String getKhedmat() {
		return khedmat;
	}


	public void setKhedmat(String khedmat) {
		this.khedmat = khedmat;
	}


	public Long getSabege() {
		return sabege;
	}


	public void setSabege(Long sabege) {
		this.sabege = sabege;
	}


	public Long getBimeSabege() {
		return bimeSabege;
	}


	public void setBimeSabege(Long bimeSabege) {
		this.bimeSabege = bimeSabege;
	}


	public String getVaziatEshtegal() {
		return vaziatEshtegal;
	}


	public void setVaziatEshtegal(String vaziatEshtegal) {
		this.vaziatEshtegal = vaziatEshtegal;
	}


	public String getElateTarkeKar() {
		return elateTarkeKar;
	}


	public void setElateTarkeKar(String elateTarkeKar) {
		this.elateTarkeKar = elateTarkeKar;
	}


	public String getShogleDarkhast() {
		return shogleDarkhast;
	}


	public void setShogleDarkhast(String shogleDarkhast) {
		this.shogleDarkhast = shogleDarkhast;
	}


	public String getTakhasosKarjo() {
		return takhasosKarjo;
	}


	public void setTakhasosKarjo(String takhasosKarjo) {
		this.takhasosKarjo = takhasosKarjo;
	}


	public String getDorehaVmadarek() {
		return dorehaVmadarek;
	}


	public void setDorehaVmadarek(String dorehaVmadarek) {
		this.dorehaVmadarek = dorehaVmadarek;
	}


	public Long getHogogKarjo() {
		return hogogKarjo;
	}


	public void setHogogKarjo(Long hogogKarjo) {
		this.hogogKarjo = hogogKarjo;
	}


	public String getHomeType() {
		return homeType;
	}


	public void setHomeType(String homeType) {
		this.homeType = homeType;
	}


	public String getKarbariSanad() {
		return karbariSanad;
	}


	public void setKarbariSanad(String karbariSanad) {
		this.karbariSanad = karbariSanad;
	}


	public String getNoeSanad() {
		return noeSanad;
	}


	public void setNoeSanad(String noeSanad) {
		this.noeSanad = noeSanad;
	}


	public Long getMetraj() {
		return metraj;
	}


	public void setMetraj(Long metraj) {
		this.metraj = metraj;
	}


	public Long getPriceMetr() {
		return priceMetr;
	}


	public void setPriceMetr(Long priceMetr) {
		this.priceMetr = priceMetr;
	}


	public String getSaleSakht() {
		return saleSakht;
	}


	public void setSaleSakht(String saleSakht) {
		this.saleSakht = saleSakht;
	}


	public String getJahateMelk() {
		return jahateMelk;
	}


	public void setJahateMelk(String jahateMelk) {
		this.jahateMelk = jahateMelk;
	}


	public String getMahaleSakhteman() {
		return mahaleSakhteman;
	}


	public void setMahaleSakhteman(String mahaleSakhteman) {
		this.mahaleSakhteman = mahaleSakhteman;
	}


	public String getNamayeMelk() {
		return namayeMelk;
	}


	public void setNamayeMelk(String namayeMelk) {
		this.namayeMelk = namayeMelk;
	}


	public String getKaf() {
		return kaf;
	}


	public void setKaf(String kaf) {
		this.kaf = kaf;
	}


	public String getPosheshDivar() {
		return posheshDivar;
	}


	public void setPosheshDivar(String posheshDivar) {
		this.posheshDivar = posheshDivar;
	}


	public String getVaziatRoshanayi() {
		return vaziatRoshanayi;
	}


	public void setVaziatRoshanayi(String vaziatRoshanayi) {
		this.vaziatRoshanayi = vaziatRoshanayi;
	}


	public String getVaziatsystemGarmayesh() {
		return vaziatsystemGarmayesh;
	}


	public void setVaziatsystemGarmayesh(String vaziatsystemGarmayesh) {
		this.vaziatsystemGarmayesh = vaziatsystemGarmayesh;
	}


	public String getAbGarm() {
		return abGarm;
	}


	public void setAbGarm(String abGarm) {
		this.abGarm = abGarm;
	}


	public String getMoshaat() {
		return moshaat;
	}


	public void setMoshaat(String moshaat) {
		this.moshaat = moshaat;
	}


	public String getMoshaatAbi() {
		return moshaatAbi;
	}


	public void setMoshaatAbi(String moshaatAbi) {
		this.moshaatAbi = moshaatAbi;
	}


	public String getChahAbi() {
		return chahAbi;
	}


	public void setChahAbi(String chahAbi) {
		this.chahAbi = chahAbi;
	}


	public String getFazayeSabz() {
		return fazayeSabz;
	}


	public void setFazayeSabz(String fazayeSabz) {
		this.fazayeSabz = fazayeSabz;
	}


	public String getView() {
		return view;
	}


	public void setView(String view) {
		this.view = view;
	}


	public String getAnbari() {
		return anbari;
	}


	public void setAnbari(String anbari) {
		this.anbari = anbari;
	}


	public String getParking() {
		return parking;
	}


	public void setParking(String parking) {
		this.parking = parking;
	}


	public String getTelephone() {
		return telephone;
	}


	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}


	public String getTabloKhor() {
		return tabloKhor;
	}


	public void setTabloKhor(String tabloKhor) {
		this.tabloKhor = tabloKhor;
	}


	public String getServiceBehdashti() {
		return serviceBehdashti;
	}


	public void setServiceBehdashti(String serviceBehdashti) {
		this.serviceBehdashti = serviceBehdashti;
	}


	public String getDigarEmkanat() {
		return digarEmkanat;
	}


	public void setDigarEmkanat(String digarEmkanat) {
		this.digarEmkanat = digarEmkanat;
	}


	public String getSaateBazdid() {
		return saateBazdid;
	}


	public void setSaateBazdid(String saateBazdid) {
		this.saateBazdid = saateBazdid;
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


	public Long getMablag() {
		return mablag;
	}


	public void setMablag(Long mablag) {
		this.mablag = mablag;
	}


	public String getMahaleForosh() {
		return mahaleForosh;
	}


	public void setMahaleForosh(String mahaleForosh) {
		this.mahaleForosh = mahaleForosh;
	}


	public String getLavazemJanebi() {
		return lavazemJanebi;
	}


	public void setLavazemJanebi(String lavazemJanebi) {
		this.lavazemJanebi = lavazemJanebi;
	}


	public String getSeriOrCode() {
		return seriOrCode;
	}


	public void setSeriOrCode(String seriOrCode) {
		this.seriOrCode = seriOrCode;
	}


	public String getKarbord() {
		return karbord;
	}


	public void setKarbord(String karbord) {
		this.karbord = karbord;
	}


	public String getZemanat() {
		return zemanat;
	}


	public void setZemanat(String zemanat) {
		this.zemanat = zemanat;
	}


	public Long getModateZemanat() {
		return modateZemanat;
	}


	public void setModateZemanat(Long modateZemanat) {
		this.modateZemanat = modateZemanat;
	}


	public String getSaateBazdidMachine() {
		return saateBazdidMachine;
	}


	public void setSaateBazdidMachine(String saateBazdidMachine) {
		this.saateBazdidMachine = saateBazdidMachine;
	}


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
			advertise.setAddres(address);
			advertise.setBimeSabege(bimeSabege);
			advertise.setBirthDay(birthDay);
			advertise.setDate(new Date());
			advertise.setDescription(description);
			advertise.setDorehaVmadarek(dorehaVmadarek);
			advertise.setElateTarkeKar(elateTarkeKar);
			advertise.setHogogKarjo(hogogKarjo);
			advertise.setKarjoField(karjoField);
			advertise.setKarjoMadrak(karjoMadrak);
			advertise.setKarjoNoeHamkari(karjoNoeHamkari);
			advertise.setKhedmat(khedmat);
			advertise.setMahaleTavalod(mahaleTavalod);
			advertise.setPhone(phone);
			advertise.setPhone(phone);
			advertise.setSabege(sabege);
			advertise.setShogleDarkhast(shogleDarkhast);
			advertise.setShow(false);
			advertise.setTakhasosKarjo(takhasosKarjo);
			advertise.setTitle(title);
			advertise.setUserAdv(adminProfile.getMoblEntity());
			advertise.setVaziatEshtegal(vaziatEshtegal);
			advertise.setVaziatTahol(vaziatTahol);
			advertise.setEmail(email);
			advertise.setSite(site);
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
		advertise.setAddres(address);
		advertise.setBime(bime);
		advertise.setBimeTakmili(bimeTakmili);
		advertise.setDate(new Date());
		advertise.setDescription(description);
		advertise.setEmail(email);
		advertise.setEzafekar(ezafekar);
		advertise.setJensiat(jensiat);
		advertise.setKarfarmaCompanyName(karfarmaCompanyName);
		advertise.setKarfarmaNiroMorede(karfarmaNiroMorede);
		advertise.setKarfarmaTakhasosMorede(karfarmaTakhasosMorede);
		advertise.setMagtaTahsisli(magtaTahsisli);
		advertise.setMinSabege(minSabege);
		advertise.setMizanHogog(mizanHogog);
		advertise.setMorekhasi(morekhasi);
		advertise.setNoeHamkari(karjoNoeHamkari);
		advertise.setNoeHogog(noeHogog);
		advertise.setPhone(phone);
		advertise.setReshte(reshte);
		advertise.setSaatKari(saatKari);
		advertise.setSen(sen);
		advertise.setShow(false);
		advertise.setSite(site);
		advertise.setTakhasos(takhasos);
		advertise.setTitle(title);
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
			advertise.setRentType(rentType);
			advertise.setPhoneLine(phoneLine);
		advertise.setAbGarm(abGarm);
		advertise.setAddres(address);
		advertise.setAnbari(anbari);
		advertise.setChahAbi(chahAbi);
		advertise.setDate(new Date());
		advertise.setDescription(description);
		advertise.setDigarEmkanat(digarEmkanat);
		advertise.setEmail(email);
		advertise.setFazayeSabz(fazayeSabz);
		advertise.setHomeType(homeType);
		advertise.setJahateMelk(jahateMelk);
		advertise.setKaf(kaf);
		advertise.setKarbariSanad(karbariSanad);
		advertise.setMahaleSakhteman(mahaleSakhteman);
		advertise.setMetraj(metraj);
		advertise.setMoshaat(moshaat);
		advertise.setMoshaatAbi(moshaatAbi);
		advertise.setNamayeMelk(namayeMelk);
		advertise.setNoeSanad(noeSanad);
		advertise.setParking(parking);
		advertise.setPhone(phone);
		advertise.setPosheshDivar(posheshDivar);
		advertise.setPriceMetr(priceMetr);
		advertise.setSaateBazdid(saateBazdid);
		advertise.setSaleSakht(saleSakht);
		advertise.setServiceBehdashti(serviceBehdashti);
		advertise.setShow(false);
		advertise.setSite(site);
		advertise.setTabloKhor(tabloKhor);
		advertise.setTelephone(telephone);
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
			advertise.setAddres(address);
			advertise.setBrand(brand);
			advertise.setContry(contry);
			advertise.setDate(new Date());
			advertise.setDescription(description);
			advertise.setEmail(email);
			advertise.setKarbord(karbord);
			advertise.setLavazemJanebi(lavazemJanebi);
			advertise.setMablag(serialVersionUID);
			advertise.setMachineName(machineName);
			advertise.setMahaleForosh(mahaleForosh);
			advertise.setModateZemanat(modateZemanat);
			advertise.setMoshakhasat(moshakhasat);
			advertise.setPhone(phone);
			advertise.setSaateBazdidMachine(saateBazdidMachine);
			advertise.setSaleTolid(saleTolid);
			advertise.setSeriOrCode(seriOrCode);
			advertise.setShow(false);
			advertise.setSite(site);
			advertise.setTitle(title);
			advertise.setVaziat(vaziat);
			advertise.setZemanat(zemanat);
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
