package ui;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import catch_db.CatchAmadeLocal;
import entity.Amade;
import enums.AmadeType;
import sevice.AmadeServiceLocal;


@Named
@ViewScoped
public class AmadeBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AmadeBean() {
		// TODO Auto-generated constructor stub
	}

	private String senfName;
	private String shomarePano;
	private String raste;
	private String modir;
	private String addres;
	private String mobasher;
	private String packag;
	private String type;
	private String damane;
	
	@Inject
	private AmadeServiceLocal amadeServiceLocal;
//	@Inject
//	private CatchAmadeLocal catchAmadeLocal;

	public String getSenfName() {
		return senfName;
	}

	public void setSenfName(String senfName) {
		this.senfName = senfName;
	}

	public String getShomarePano() {
		return shomarePano;
	}

	public void setShomarePano(String shomarePano) {
		this.shomarePano = shomarePano;
	}

	public String getRaste() {
		return raste;
	}

	public void setRaste(String raste) {
		this.raste = raste;
	}

	public String getModir() {
		return modir;
	}

	public void setModir(String modir) {
		this.modir = modir;
	}

	public String getAddres() {
		return addres;
	}

	public void setAddres(String addres) {
		this.addres = addres;
	}

	public String getMobasher() {
		return mobasher;
	}

	public void setMobasher(String mobasher) {
		this.mobasher = mobasher;
	}

	public String getPackag() {
		return packag;
	}

	public void setPackag(String packag) {
		this.packag = packag;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	

	public String getDamane() {
		return damane;
	}

	public void setDamane(String damane) {
		this.damane = damane;
	}

//	public void insertToAmade() {
//		Amade amade = new Amade();
//		amade.setAddres(addres);
//		amade.setMobasher(mobasher);
//		amade.setRaste(raste);
//		amade.setModir(modir);
//		amade.setPackag(packag);
//		amade.setSenfName(senfName);
//		amade.setShomarePano(shomarePano);
//		amade.setType(type);
//		amade.setDamane(damane);
//		amadeServiceLocal.insertToAmade(amade);
//		FacesContext context = FacesContext.getCurrentInstance();
//		context.addMessage(null, new FacesMessage("Successful"));
//	}

//	public List<Amade> findAllAmadeType(String type) {
//		List<Amade> amade = new ArrayList<>();
//		if (type.equals("parvane")) {
//			amade.addAll(singletonServiceLocal.getAmadeParvane());
//			return amade;
//		} else if (type.equals("govah")) {
//			amade.addAll(singletonServiceLocal.getAmadeGovahiname());
//			return amade;
//		} else if (type.equals("kart")) {
//			amade.addAll(singletonServiceLocal.getAmadeKart());
//			return amade;
//		} else
//			return null;
//	}
	
	
	public List<Amade> findAllAmadePano(){
		//return catchAmadeLocal.getAmadePano();
		return amadeServiceLocal.findAmadeByType(AmadeType.PANO);
	}
	
	public List<Amade> findAllAmadeUnion(){
		//return catchAmadeLocal.getAmadeUnion();
		return amadeServiceLocal.findAmadeByType(AmadeType.UNION);
	}
	
	public List<Amade> findAllAmadeMobasherat(){
		//return catchAmadeLocal.getAmadeMobasherat();
		return amadeServiceLocal.findAmadeByType(AmadeType.MOBASHERAT);
	}
	



}
