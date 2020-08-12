package ui;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.imageio.ImageIO;
import javax.inject.Inject;
import javax.inject.Named;

import catch_db.CatchCreativeLocal;
import entity.BlogEntity;
import entity.CreativeEntity;

@Named
@ViewScoped
public class CreativeDetalPage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CreativeDetalPage() {
		// TODO Auto-generated constructor stub
	}
	@Inject
	private CatchCreativeLocal catchCreativeLocal;

	
	private CreativeEntity creativeEntity=new CreativeEntity();
	
	public CreativeEntity findCreativeById(int id) {
		for (CreativeEntity creativeEntity : catchCreativeLocal.getCreativeEntities()) {
			if(creativeEntity.getId()==id)
				this.creativeEntity=creativeEntity;
		}
		return this.creativeEntity;
	}
	

	
	public byte[] findCreativePic1() {
		try {
		File imageFile1=new File("/home/wildfly/AX/" + this.creativeEntity.getPic1().toString() + ".jpg");
		BufferedImage image1=ImageIO.read(imageFile1);
		ByteArrayOutputStream baos1=new ByteArrayOutputStream();
		ImageIO.write(image1, "jpg", baos1);
		return baos1.toByteArray();
		}catch (Exception e) {
			return null;
		}
	}
	
	public byte[] findCreativePic2() {
		try {
		File imageFile1=new File("/home/wildfly/AX/" + this.creativeEntity.getPic2().toString() + ".jpg");
		BufferedImage image1=ImageIO.read(imageFile1);
		ByteArrayOutputStream baos1=new ByteArrayOutputStream();
		ImageIO.write(image1, "jpg", baos1);
		return baos1.toByteArray();
		}catch (Exception e) {
			return null;
		}
	}
	
	public byte[] findCreativePic3() {
		try {
		File imageFile1=new File("/home/wildfly/AX/" + this.creativeEntity.getPic3().toString() + ".jpg");
		BufferedImage image1=ImageIO.read(imageFile1);
		ByteArrayOutputStream baos1=new ByteArrayOutputStream();
		ImageIO.write(image1, "jpg", baos1);
		return baos1.toByteArray();
		}catch (Exception e) {
			return null;
		}
	}
	
	public byte[] findCreativePic4() {
		try {
		File imageFile1=new File("/home/wildfly/AX/" + this.creativeEntity.getPic4().toString() + ".jpg");
		BufferedImage image1=ImageIO.read(imageFile1);
		ByteArrayOutputStream baos1=new ByteArrayOutputStream();
		ImageIO.write(image1, "jpg", baos1);
		return baos1.toByteArray();
		}catch (Exception e) {
			return null;
		}
	}
	
	public byte[] findCreativePic5() {
		try {
		File imageFile1=new File("/home/wildfly/AX/" + this.creativeEntity.getPic5().toString() + ".jpg");
		BufferedImage image1=ImageIO.read(imageFile1);
		ByteArrayOutputStream baos1=new ByteArrayOutputStream();
		ImageIO.write(image1, "jpg", baos1);
		return baos1.toByteArray();
		}catch (Exception e) {
			return null;
		}
	}
	
	public byte[] findCreativePic6() {
		try {
		File imageFile1=new File("/home/wildfly/AX/" + this.creativeEntity.getPic6().toString() + ".jpg");
		BufferedImage image1=ImageIO.read(imageFile1);
		ByteArrayOutputStream baos1=new ByteArrayOutputStream();
		ImageIO.write(image1, "jpg", baos1);
		return baos1.toByteArray();
		}catch (Exception e) {
			return null;
		}
	}
	

	
}
