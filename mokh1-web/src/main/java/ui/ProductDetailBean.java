package ui;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.imageio.ImageIO;
import javax.inject.Inject;
import javax.inject.Named;

import entity.ProductEntity;
import sevice.ProductserviceLocal;

@Named
@ViewScoped
public class ProductDetailBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ProductDetailBean() {
		// TODO Auto-generated constructor stub
	}
	@Inject
	private ProductserviceLocal productserviceLocal;

	//private ProductEntity productEntity=new ProductEntity();
	
	
//	
//	public ProductEntity getProductEntity() {
//		return productEntity;
//	}
//
//
//
//	public void setProductEntity(ProductEntity productEntity) {
//		this.productEntity = productEntity;
//	}
//
//
//
//	public ProductEntity findProductById(long productId) {
//		this.productEntity=productserviceLocal.findProductEntityById(productId);
//		return this.productEntity;
//	}
//
//	public byte[] findPic1Product() throws IOException {
//		
//		try {
//		File imageFile1=new File("/home/wildfly/AX/" + productEntity.getPic1().toString() + ".jpg");
//		BufferedImage image1=ImageIO.read(imageFile1);
//		ByteArrayOutputStream baos1=new ByteArrayOutputStream();
//		ImageIO.write(image1, "jpg", baos1);
//		return baos1.toByteArray();
//		}catch (Exception e) {
//			return null;
//		}
//	}
	
}
