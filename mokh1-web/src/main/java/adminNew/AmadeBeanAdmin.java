package adminNew;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import entity.Amade;
import enums.AmadeType;
import sevice.AmadeServiceLocal;

@Named
@ViewScoped
public class AmadeBeanAdmin implements Serializable {

	/** 
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AmadeBeanAdmin() {
		// TODO Auto-generated constructor stub
	}
	
	private String senfName;
	private String shomarePano;
	private String raste;
	private String modir;
	private String addres;
	private String mobasher;
	private String packag;
	private AmadeType type;
	private String damane;
	private String mobile;
	private String father;
	private Amade amadeEntity;
	@Inject
	private AmadeServiceLocal amadeServiceLocal;

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

	public AmadeType getType() {
		return type;
	}

	public void setType(AmadeType type) {
		this.type = type;
	}

	public String getDamane() {
		return damane;
	}

	public void setDamane(String damane) {
		this.damane = damane;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getFather() {
		return father;
	}

	public void setFather(String father) {
		this.father = father;
	}
	
	public Amade getAmadeEntity() {
		return amadeEntity;
	}

	public void setAmadeEntity(Amade amadeEntity) {
		this.amadeEntity = amadeEntity;
	}

	public List<Amade> findAllAmade() {
		return amadeServiceLocal.findAllAmade();
	}
	
	public void deleteAmade() {

		amadeServiceLocal.deleteAmade(amadeEntity);
	}
	
	
	public void insertToAmade() {
		Amade amade = new Amade();
		amade.setAddres(addres);
		amade.setMobasher(mobasher);
		amade.setRaste(raste);
		amade.setModir(modir);
		amade.setPackag(packag);
		amade.setSenfName(senfName);
		amade.setShomarePano(shomarePano);
		amade.setType(type);
		amade.setDamane(damane);
		amade.setMobile(mobile);
		amade.setFather(father);
		amadeServiceLocal.insertToAmade(amade);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Successful"));
	}

}
