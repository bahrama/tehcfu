package ui;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.PostActivate;
import javax.enterprise.context.SessionScoped;
import javax.faces.view.ViewScoped;
import javax.imageio.ImageIO;
import javax.inject.Inject;
import javax.inject.Named;

import entity.MoblEntity;
import sevice.SellerServiceLocal;

@Named
@ViewScoped
public class PanelBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PanelBean() {
		// TODO Auto-generated constructor stub
	}
	@Inject
	private SellerServiceLocal sellerServiceLocal;
	
	private List<MoblEntity> firoze =new ArrayList<MoblEntity>();
	private List<MoblEntity> tala =new ArrayList<MoblEntity>();
	private List<MoblEntity> bronze =new ArrayList<MoblEntity>();
	private List<MoblEntity> nogre =new ArrayList<MoblEntity>();
	private List<MoblEntity> adi =new ArrayList<MoblEntity>();
	
	public List<MoblEntity> getFiroze() {
		return firoze;
	}

	public void setFiroze(List<MoblEntity> firoze) {
		this.firoze = firoze;
	}

	public List<MoblEntity> getTala() {
		return tala;
	}

	public void setTala(List<MoblEntity> tala) {
		this.tala = tala;
	}

	public List<MoblEntity> getBronze() {
		return bronze;
	}

	public void setBronze(List<MoblEntity> bronze) {
		this.bronze = bronze;
	}

	public List<MoblEntity> getNogre() {
		return nogre;
	}

	public void setNogre(List<MoblEntity> nogre) {
		this.nogre = nogre;
	}

	public List<MoblEntity> getAdi() {
		return adi;
	}

	public void setAdi(List<MoblEntity> adi) {
		this.adi = adi;
	}

	@PostConstruct
	public void init() {
		this.firoze.clear();
		this.tala.clear();
		this.nogre.clear();
		this.bronze.clear();
		this.adi.clear();
		try {
			this.firoze.addAll(sellerServiceLocal.findSellersByPanel("A"));
			this.tala.addAll(sellerServiceLocal.findSellersByPanel("B"));
			this.nogre.addAll(sellerServiceLocal.findSellersByPanel("C"));
			this.bronze.addAll(sellerServiceLocal.findSellersByPanel("D"));
			this.adi.addAll(sellerServiceLocal.findSellersByPanel("E"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	List<MoblEntity> moblEntities = new ArrayList<MoblEntity>();
	
	public List<MoblEntity> findByPanel(String panel){
         if(panel.equals("A"))
        	 return this.firoze;
         else if(panel.equals("B"))
        		 return this.tala;
         else if(panel.equals("C"))
        			 return this.nogre;
         else if(panel.equals("D"))
        				 return this.bronze;
         else  
        	 return this.adi;
	}
	
	public byte[] findPic4(MoblEntity moblEntity) throws IOException {
		try {
		File imageFile1=new File("/home/wildfly/AX/" + moblEntity.getPic4().toString() + ".jpg");
		BufferedImage image1=ImageIO.read(imageFile1);
		ByteArrayOutputStream baos1=new ByteArrayOutputStream();
		ImageIO.write(image1, "jpg", baos1);
		return baos1.toByteArray();
		}catch (Exception e) {
			return null;
		}
	}
}
