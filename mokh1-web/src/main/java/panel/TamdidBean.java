package panel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.Column;
import javax.validation.constraints.Size;

import entity.TamdidEntity;
import sevice.TamdidServiceLocal;

@Named
@RequestScoped
public class TamdidBean {

	public TamdidBean() {
		// TODO Auto-generated constructor stub
	}
	
	@Inject
	private TempBean tempBean;
	@Inject
	private FacesContext facesContext;
	@Inject
	private TamdidServiceLocal tamdidServiceLocal; 
	
	@Size(max=20 , message="ماکزیمم ۲۰ کاراکتر")
	private String noeMelk;
	@Size(max=20, message="ماکزیمم ۲۰ کاراکتر")
	private String masahat;
	@Size(max=20, message="ماکزیمم ۲۰ کاراکتر")
	private String nameMalek;
	@Size(max=20, message="ماکزیمم ۲۰ کاراکتر")
	private String shomarePelakSabti;
	@Size(max=50, message="ماکزیمم ۵۰ کاراکتر")
	private String hozeKalantari;
	@Size(max=50, message="ماکزیمم ۵۰ کاراکتر")
	private String hozeShahrdari;
	@Size(max=100, message="ماکزیمم ۱۰۰ کاراکتر")
	private String serialGabzAb;
	@Size(max=100, message="ماکزیمم ۱۰۰ کاراکتر")
	private String serialGabzBarg;
	@Size(max=100, message="ماکزیمم ۱۰۰ کاراکتر")
	private String serialGabzGaz;
	@Size(max=5)
	private String hasParvaneh;
	@Size(max=100, message="ماکزیمم ۱۰۰ کاراکتر")
	private String shomareAbi;
	@Size(max=100, message="ماکزیمم ۱۰۰ کاراکتر")
	private String sharikShoraka;
	@Size(max=100, message="ماکزیمم ۱۰۰ کاراکتر")
	private String dasteShogli;
	@Size(max=100, message="ماکزیمم ۱۰۰ کاراکتر")
	private String emkanat;
	
	private List<String> emkanats=new ArrayList<String>();
	private List<String> dasteShoglis=new ArrayList<>();
	public String getNoeMelk() {
		return noeMelk;
	}
	public void setNoeMelk(String noeMelk) {
		this.noeMelk = noeMelk;
	}
	public String getMasahat() {
		return masahat;
	}
	public void setMasahat(String masahat) {
		this.masahat = masahat;
	}
	public String getNameMalek() {
		return nameMalek;
	}
	public void setNameMalek(String nameMalek) {
		this.nameMalek = nameMalek;
	}
	public String getShomarePelakSabti() {
		return shomarePelakSabti;
	}
	public void setShomarePelakSabti(String shomarePelakSabti) {
		this.shomarePelakSabti = shomarePelakSabti;
	}
	public String getHozeKalantari() {
		return hozeKalantari;
	}
	public void setHozeKalantari(String hozeKalantari) {
		this.hozeKalantari = hozeKalantari;
	}
	public String getHozeShahrdari() {
		return hozeShahrdari;
	}
	public void setHozeShahrdari(String hozeShahrdari) {
		this.hozeShahrdari = hozeShahrdari;
	}
	public String getSerialGabzAb() {
		return serialGabzAb;
	}
	public void setSerialGabzAb(String serialGabzAb) {
		this.serialGabzAb = serialGabzAb;
	}
	public String getSerialGabzBarg() {
		return serialGabzBarg;
	}
	public void setSerialGabzBarg(String serialGabzBarg) {
		this.serialGabzBarg = serialGabzBarg;
	}
	public String getSerialGabzGaz() {
		return serialGabzGaz;
	}
	public void setSerialGabzGaz(String serialGabzGaz) {
		this.serialGabzGaz = serialGabzGaz;
	}
	public String getHasParvaneh() {
		return hasParvaneh;
	}
	public void setHasParvaneh(String hasParvaneh) {
		this.hasParvaneh = hasParvaneh;
	}
	public String getShomareAbi() {
		return shomareAbi;
	}
	public void setShomareAbi(String shomareAbi) {
		this.shomareAbi = shomareAbi;
	}
	public String getSharikShoraka() {
		return sharikShoraka;
	}
	public void setSharikShoraka(String sharikShoraka) {
		this.sharikShoraka = sharikShoraka;
	}
	public String getDasteShogli() {
		return dasteShogli;
	}
	public void setDasteShogli(String dasteShogli) {
		this.dasteShogli = dasteShogli;
	}
	public String getEmkanat() {
		return emkanat;
	}
	public void setEmkanat(String emkanat) {
		this.emkanat = emkanat;
	}
	
	

	public List<String> getEmkanats() {
		return emkanats;
	}
	public void setEmkanats(List<String> emkanats) {
		this.emkanats = emkanats;
	}

	public List<String> getDasteShoglis() {
		return dasteShoglis;
	}
	public void setDasteShoglis(List<String> dasteShoglis) {
		this.dasteShoglis = dasteShoglis;
	}
	public void insertToTamdid() {
		TamdidEntity tamdidEntity=new TamdidEntity();
		tamdidEntity.setDasteShogli(dasteShogli);
		tamdidEntity.setEmkanat(emkanat);
		tamdidEntity.setHasParvaneh(hasParvaneh);
		tamdidEntity.setHozeKalantari(hozeKalantari);
		tamdidEntity.setHozeShahrdari(hozeShahrdari);
		tamdidEntity.setMasahat(masahat);
		tamdidEntity.setNameMalek(nameMalek);
		tamdidEntity.setNoeMelk(noeMelk);
		tamdidEntity.setSerialGabzAb(serialGabzAb);
		tamdidEntity.setSerialGabzBarg(serialGabzBarg);
		tamdidEntity.setSerialGabzGaz(serialGabzGaz);
		tamdidEntity.setSharikShoraka(sharikShoraka);
		tamdidEntity.setShomareAbi(shomareAbi);
		tamdidEntity.setShomarePelakSabti(shomarePelakSabti);
		tamdidEntity.setDate(new Date());
		tamdidEntity.setTamdid(tempBean.getMoblEntity());
		tamdidServiceLocal.insertToTamdid(tamdidEntity);
		facesContext.getPartialViewContext().getEvalScripts().add("swal({title: 'موفق!',type: 'success', text: 'درخواست شما با موفقیت ثبت گردید', confirmButtonColor: '#469408',})");
	}
}
