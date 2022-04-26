package admin;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.UUID;

import javax.faces.view.ViewScoped;
import javax.imageio.ImageIO;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.Column;
import javax.servlet.http.Part;
import javax.validation.constraints.Size;

import org.apache.commons.io.IOUtils;

import entity.CreativeEntity;
import sevice.CreativeServiceLocal;

@Named
@ViewScoped
public class AddCreative implements Serializable {

	/**
	 *  
	 */
	private static final long serialVersionUID = 1L;

	public AddCreative() {
		// TODO Auto-generated constructor stub
	}
	@Inject
	private CreativeServiceLocal creativeServiceLocal;
	@Size(max=100 , message="max is 100")
	private String name;
	@Size(max=1000 , message="max is 1000")
	private String description;
	private Part pic1;
	private Part pic2;
	private Part pic3;
	private Part pic4;
	private Part pic5;
	private Part pic6;

	
	

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Part getPic1() {
		return pic1;
	}
	public void setPic1(Part pic1) {
		this.pic1 = pic1;
	}
	public Part getPic2() {
		return pic2;
	}
	public void setPic2(Part pic2) {
		this.pic2 = pic2;
	}
	public Part getPic3() {
		return pic3;
	}
	public void setPic3(Part pic3) {
		this.pic3 = pic3;
	}
	public Part getPic4() {
		return pic4;
	}
	public void setPic4(Part pic4) {
		this.pic4 = pic4;
	}
	public Part getPic5() {
		return pic5;
	}
	public void setPic5(Part pic5) {
		this.pic5 = pic5;
	}
	public Part getPic6() {
		return pic6;
	}
	public void setPic6(Part pic6) {
		this.pic6 = pic6;
	}

	
	public void insertToCreative() {
		try {
		CreativeEntity creativeEntity=new CreativeEntity();
		creativeEntity.setName(name);
		creativeEntity.setDescription(description);
		creativeEntity.setPic1(picture1());
		creativeEntity.setPic2(picture2());
		creativeEntity.setPic3(picture3());
		creativeEntity.setPic4(picture4());
		creativeEntity.setPic5(picture5());
		creativeEntity.setPic6(picture6());
		creativeServiceLocal.insertCreativeEntity(creativeEntity);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String picture1() throws Exception {
		try {
			UUID uuid=UUID.randomUUID();
			byte[] image1Byte = IOUtils.toByteArray(pic1.getInputStream());
			File out3 = new File("/home/wildfly/wildfly-18.0.1.Final/fimg/" + uuid + ".jpg");
			InputStream in = new ByteArrayInputStream(image1Byte);
			BufferedImage img3 = ImageIO.read(in);
			ImageIO.write(img3, "jpg", out3);
			return uuid.toString();
		} catch (IOException e) {

			throw new Exception("error image entering 1");
		}
		
	}
	
	public String picture2() throws Exception {
		try {
			UUID uuid=UUID.randomUUID();
			byte[] image1Byte = IOUtils.toByteArray(pic2.getInputStream());
			File out3 = new File("/home/wildfly/wildfly-18.0.1.Final/fimg/" + uuid + ".jpg");
			InputStream in = new ByteArrayInputStream(image1Byte);
			BufferedImage img3 = ImageIO.read(in);
			ImageIO.write(img3, "jpg", out3);
			return uuid.toString();
		} catch (IOException e) {

			throw new Exception("error image entering 1");
		}
		
	}
	
	public String picture3() throws Exception {
		try {
			UUID uuid=UUID.randomUUID();
			byte[] image1Byte = IOUtils.toByteArray(pic3.getInputStream());
			File out3 = new File("/home/wildfly/wildfly-18.0.1.Final/fimg/" + uuid + ".jpg");
			InputStream in = new ByteArrayInputStream(image1Byte);
			BufferedImage img3 = ImageIO.read(in);
			ImageIO.write(img3, "jpg", out3);
			return uuid.toString();
		} catch (IOException e) {

			throw new Exception("error image entering 1");
		}
		
	}
	
	public String picture4() throws Exception {
		try {
			UUID uuid=UUID.randomUUID();
			byte[] image1Byte = IOUtils.toByteArray(pic4.getInputStream());
			File out3 = new File("/home/wildfly/wildfly-18.0.1.Final/fimg/" + uuid + ".jpg");
			InputStream in = new ByteArrayInputStream(image1Byte);
			BufferedImage img3 = ImageIO.read(in);
			ImageIO.write(img3, "jpg", out3);
			return uuid.toString();
		} catch (IOException e) {

			throw new Exception("error image entering 1");
		}
		
	}
	
	public String picture5() throws Exception {
		try {
			UUID uuid=UUID.randomUUID();
			byte[] image1Byte = IOUtils.toByteArray(pic5.getInputStream());
			File out3 = new File("/home/wildfly/wildfly-18.0.1.Final/fimg/" + uuid + ".jpg");
			InputStream in = new ByteArrayInputStream(image1Byte);
			BufferedImage img3 = ImageIO.read(in);
			ImageIO.write(img3, "jpg", out3);
			return uuid.toString();
		} catch (IOException e) {

			throw new Exception("error image entering 1");
		}
		
	}
	
	public String picture6() throws Exception {
		try {
			UUID uuid=UUID.randomUUID();
			byte[] image1Byte = IOUtils.toByteArray(pic6.getInputStream());
			File out3 = new File("/home/wildfly/wildfly-18.0.1.Final/fimg/" + uuid + ".jpg");
			InputStream in = new ByteArrayInputStream(image1Byte);
			BufferedImage img3 = ImageIO.read(in);
			ImageIO.write(img3, "jpg", out3);
			return uuid.toString();
		} catch (IOException e) {

			throw new Exception("error image entering 1");
		}
		
	}
	


}
