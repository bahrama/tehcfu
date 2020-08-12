package panel;


import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.Column;
import javax.servlet.http.Part;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.commons.io.IOUtils;

import entity.RentEntity;
import sevice.RentServiceLocal;



@Named
@ViewScoped
public class RentBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6812319423856259667L;
	@Inject
	private TempBean tempBean;
	@Inject
	private FacesContext facesContext;
	@Inject
	private RentServiceLocal rentService;
	@NotNull
	@NotEmpty
	@Size(max=20 , message="ماکزیمم ۲۰ کاراکتر")
	private String rentType;
	@NotNull
	@NotEmpty
	@Size(max=20 , message="ماکزیمم ۲۰ کاراکتر")
	private String homeType;
	@NotNull
	@NotEmpty
	@Size(max=100 , message="ماکزیمم ۱۰۰ کاراکتر")
	private String address;
	@NotNull
	@NotEmpty
	@Size(max=20 , message="ماکزیمم ۲۰ کاراکتر")
	private String vage;
	@NotNull
	@NotEmpty
	@Size(max=20 , message="ماکزیمم ۲۰ کاراکتر")
	private String mogeiat;
	@NotNull
	@NotEmpty
	@Size(max=10 , message="ماکزیمم ۱۰ کاراکتر")
	private String tedadTabage;
	@NotNull
	@NotEmpty
	@Size(max=10 , message="ماکزیمم ۱۰ کاراکتر")
	private String tedadVahed;
	@NotNull
	@NotEmpty
	@Size(max=30 , message="ماکزیمم ۳۰ کاراکتر")
	private String vadieeMoney;
	@NotNull
	@NotEmpty
	@Size(max=30 , message="ماکزیمم ۳۰ کاراکتر")
	private String ejareMony;	
	@NotNull
	@NotEmpty
	@Size(max=30 , message="ماکزیمم ۳۰ کاراکتر")
	private String mablageForosh;
	@Size(max=20 , message="ماکزیمم ۲۰ کاراکتر")
	private String emkanat;
	@NotNull
	@NotEmpty
	@Size(max=20 , message="ماکزیمم ۲۰ کاراکتر")
	private String vaziatSanad;
	@NotNull
	@NotEmpty
	@Size(max=30 , message="ماکزیمم ۳۰ کاراکتر")
	private String senBana;
	@NotNull
	@NotEmpty
	@Size(max=30 , message="ماکزیمم ۳۰ کاراکتر")
	private String masahat;
	@Size(max=20 , message="ماکزیمم ۲۰ کاراکتر")
	private String vaziatMelk;
	@NotNull
	@NotEmpty
	@Size(max=500 , message="ماکزیمم ۵۰۰ کاراکتر")
	private String description;
	@NotNull
	@NotEmpty
	@Size(max=5 , message="ماکزیمم ۵ کاراکتر")
	private String parvane;
	@Size(max=20 , message="ماکزیمم ۲۰ کاراکتر")
	private String etehadieName;
	@NotNull
	@NotEmpty
	@Size(max=30 , message="ماکزیمم ۳۰ کاراکتر")
	private String phone;
	@Size(max=20 , message="ماکزیمم ۲۰ کاراکتر")
	private String pic1;
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
	public String getTedadTabage() {
		return tedadTabage;
	}
	public void setTedadTabage(String tedadTabage) {
		this.tedadTabage = tedadTabage;
	}
	public String getTedadVahed() {
		return tedadVahed;
	}
	public void setTedadVahed(String tedadVahed) {
		this.tedadVahed = tedadVahed;
	}
	public String getVadieeMoney() {
		return vadieeMoney;
	}
	public void setVadieeMoney(String vadieeMoney) {
		this.vadieeMoney = vadieeMoney;
	}
	public String getEjareMony() {
		return ejareMony;
	}
	public void setEjareMony(String ejareMony) {
		this.ejareMony = ejareMony;
	}
	public String getMablageForosh() {
		return mablageForosh;
	}
	public void setMablageForosh(String mablageForosh) {
		this.mablageForosh = mablageForosh;
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
	public String getSenBana() {
		return senBana;
	}
	public void setSenBana(String senBana) {
		this.senBana = senBana;
	}
	public String getMasahat() {
		return masahat;
	}
	public void setMasahat(String masahat) {
		this.masahat = masahat;
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
	public String getPic1() {
		return pic1;
	}
	public void setPic1(String pic1) {
		this.pic1 = pic1;
	}
	
	public void insertToRent() {
		RentEntity rentEntity=new RentEntity();
		rentEntity.setAddress(address);
		rentEntity.setDate(new Date());
		rentEntity.setDescription(description);
		rentEntity.setEjareMony(ejareMony);
		rentEntity.setHomeType(homeType);
		rentEntity.setMablageForosh(mablageForosh);
		rentEntity.setMasahat(masahat);
		rentEntity.setMasahat(masahat);
		rentEntity.setMogeiat(mogeiat);
		rentEntity.setParvane(parvane);
		rentEntity.setPhone(phone);
		rentEntity.setRenter(tempBean.getMoblEntity());
		rentEntity.setRentType(rentType);
		rentEntity.setSenBana(senBana);
		rentEntity.setTedadTabage(tedadTabage);
		rentEntity.setTedadVahed(tedadVahed);
		rentEntity.setVadieeMoney(vadieeMoney);
		rentEntity.setVage(vage);
		rentEntity.setVaziatSanad(vaziatSanad);
		rentService.insertToRent(rentEntity);
		facesContext.getPartialViewContext().getEvalScripts().add("swal({title: 'موفق!',type: 'success', text: 'آگهی شما با موفقیت ثبت گردید پس از بررسی در سایت قرار داده می شود', confirmButtonColor: '#469408',})");

	}

}
