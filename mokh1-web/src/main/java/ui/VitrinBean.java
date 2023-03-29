package ui;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.enterprise.context.SessionScoped;
import javax.imageio.ImageIO;
import javax.inject.Inject;
import javax.inject.Named;

import catch_db.CatchSellerLocal;
import entity.MoblEntity;
import sevice.SellerServiceLocal;

@Named
@SessionScoped
public class VitrinBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public VitrinBean() {
		// TODO Auto-generated constructor stub
	}
	

	@Inject
	private CatchSellerLocal catchSellerLocal;
	
	public Set<MoblEntity> findAllSeller(String type){
		if(type.equals("مبلمان خانگی"))
			return catchSellerLocal.getVitrinMoblKhanegi();
		else if(type.equals("مبلمان اداری"))
			return catchSellerLocal.getVitrinMoblEdari();
		else if(type.equals("سیسمونی"))
			return catchSellerLocal.getVitrinMoblSismoni();
		else if(type.equals("کابینت آشپزخانه"))
			return catchSellerLocal.getVitrinMoblKabinet();
		else if(type.equals("مصنوعات چوبی"))
			return catchSellerLocal.getVitrinMoblMasnoat();
		else if(type.equals("تعمیرات"))
			return catchSellerLocal.getVitrinMoblTamirat();
		else if(type.equals("دکوراسیون"))
			return catchSellerLocal.getVitrinMoblDecor();
		else if(type.equals("متفرقه"))
			return catchSellerLocal.getVitrinMoblMotefarege();
		else 
			return null;
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
	
	public List<MoblEntity> findAllAdi(){
		return catchSellerLocal.getAdiList();
	}

}
