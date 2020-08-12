package admin;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.enterprise.inject.Alternative;
import javax.faces.view.ViewScoped;
import javax.imageio.ImageIO;
import javax.inject.Inject;
import javax.inject.Named;

import entity.HomeEntity;
import sevice.HomeServiceLocal;


@Named
@ViewScoped
public class EditHome implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EditHome() {
		// TODO Auto-generated constructor stub
	}
	@Inject
	private HomeServiceLocal homeServiceLocal;
	
	public List<HomeEntity> findAllHome(){
		return homeServiceLocal.findAllHomeEntity();
	}
	
	
	public void deleteHome(int id) {
		try {
			homeServiceLocal.deleteSeller(homeServiceLocal.findHomeEntityById(id));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public byte[] findPic(int id) throws IOException {
		try {
		File imageFile1=new File("/home/wildfly/AX/" + homeServiceLocal.findHomeEntityById(id).getPicId() + ".jpg");
		BufferedImage image1=ImageIO.read(imageFile1);
		ByteArrayOutputStream baos1=new ByteArrayOutputStream();
		ImageIO.write(image1, "jpg", baos1);
		return baos1.toByteArray();
		}catch (Exception e) {
			return null;
		}
	}

}
