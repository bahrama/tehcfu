package ui;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.imageio.ImageIO;
import javax.inject.Inject;
import javax.inject.Named;

import catch_db.CatchCreativeLocal;
import entity.BlogEntity;
import entity.CreativeEntity;
import sevice.CreativeServiceLocal;

@Named
@ViewScoped
public class CreativesPage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CreativesPage() {
		// TODO Auto-generated constructor stub
	}
//	@Inject
//	private CatchCreativeLocal catchCreativeLocal;
	@Inject
	private CreativeServiceLocal creativeServiceLocal;
	
	public List<CreativeEntity> findAllCreative(){
		//return catchCreativeLocal.getCreativeEntities();
		return creativeServiceLocal.findAllCreativeEntity();
	}

	public byte[] findCreativePic1ById(int id) {
//		CreativeEntity creativeEntity = new CreativeEntity();
//		for (CreativeEntity creativeEntity2 : catchCreativeLocal.getCreativeEntities()) {
//			if (creativeEntity2.getId() == id)
//				creativeEntity = creativeEntity2;
//		}
		
		try {
			return this.findPic1(creativeServiceLocal.findCreativeEntityById(id));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	private byte[] findPic1(CreativeEntity creativeEntity) {
		try {
			File imageFile1 = new File("/home/wildfly/AX/" + creativeEntity.getPic1().toString() + ".jpg");
			BufferedImage image1 = ImageIO.read(imageFile1);
			ByteArrayOutputStream baos1 = new ByteArrayOutputStream();
			ImageIO.write(image1, "jpg", baos1);
			return baos1.toByteArray();
		} catch (Exception e) {
			return null;
		}
	}
	
	
	
}
