package ui;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.imageio.ImageIO;
import javax.inject.Inject;
import javax.inject.Named;

import entity.MoblEntity;
import sevice.SellerServiceLocal;

@Named
@SessionScoped
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
	
	public List<MoblEntity> findByPanel(String panel){
		try {
			return sellerServiceLocal.findSellersByPanel(panel);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return null;
		}
	}
	
	public byte[] findPic4(MoblEntity moblEntity) throws IOException {
		System.err.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		System.err.println(moblEntity.getPic4().toString());
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
