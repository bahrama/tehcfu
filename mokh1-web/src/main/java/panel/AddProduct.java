package panel;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.imageio.ImageIO;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.Part;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.commons.io.IOUtils;

import entity.ProductEntity;
import sevice.ProductserviceLocal;

@Named("product")
@ViewScoped
public class AddProduct implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public AddProduct() {
		// TODO Auto-generated constructor stub
	}
	
	@Inject
	private TempBean tempBean;
	@Inject
	private FacesContext facesContext;
	@Inject
	private ProductserviceLocal productserviceLocal; 
	
	@NotNull(message="فیلد نباید خالی باشد")
	@NotEmpty(message="فیلد نباید خالی باشد")
	@Size(max=100,message="حداکثر ۱۰۰ کاراکتر")
	private String name;
	@NotNull(message="فیلد نباید خالی باشد")
	@NotEmpty(message="فیلد نباید خالی باشد")
	@Size(max=100,message="حداکثر ۱۰۰ کاراکتر")
	private String contry;
	@NotNull(message="فیلد نباید خالی باشد")
	@NotEmpty(message="فیلد نباید خالی باشد")
	@Size(max=100,message="حداکثر ۱۰۰ کاراکتر")
	private String raste;
	@NotNull(message="فیلد نباید خالی باشد")
	@NotEmpty(message="فیلد نباید خالی باشد")
	@Size(max=3000,message="حداکثر ۳۰۰۰ کاراکتر")
	private String description;
	@Digits(fraction = 0, integer = 1000000000)
	private String price;
	@Digits(fraction = 0, integer = 1000000000)
	private String price2;
	@NotNull(message="فیلد نباید خالی باشد")
	@NotEmpty(message="فیلد نباید خالی باشد")
	@Size(max=3000,message="حداکثر ۱۰ کاراکتر")
	private String oldNew;
	
	private Part pic1;
	private Part pic2;
	private Part pic3;
	private Part pic4;
	private Part pic5;
	
	private ProductEntity productEntity;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContry() {
		return contry;
	}
	public void setContry(String contry) {
		this.contry = contry;
	}
	public String getRaste() {
		return raste;
	}
	public void setRaste(String raste) {
		this.raste = raste;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
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
	
	public String getPrice2() {
		return price2;
	}
	public void setPrice2(String price2) {
		this.price2 = price2;
	}

	
	
	
	public ProductEntity getProductEntity() {
		return productEntity;
	}
	public void setProductEntity(ProductEntity productEntity) {
		this.productEntity = productEntity;
	}
	public String getOldNew() {
		return oldNew;
	}
	public void setOldNew(String oldNew) {
		this.oldNew = oldNew;
	}
	public void insertToProduct() {
		ProductEntity productEntity=new ProductEntity();
		productEntity.setContry(contry);
		productEntity.setDescription(description);
		productEntity.setName(name);
		productEntity.setOldNew(oldNew);
		productEntity.setPrice(Long.parseLong(price));
		productEntity.setPrice2(Long.parseLong(price2));
		productEntity.setRaste(raste);
		productEntity.setProduct(tempBean.getMoblEntity());
		try {
		productEntity.setPic1(this.picture());
		productEntity.setPic2(this.picture2());
		productEntity.setPic3(this.picture3());
		productEntity.setPic4(this.picture4());
		productEntity.setPic5(this.picture5());
		}
		catch(Exception ee) {
			productEntity.setPic1(null);
			productEntity.setPic2(null);
			productEntity.setPic3(null);
			productEntity.setPic4(null);
			productEntity.setPic5(null);
		}
		try {
			productserviceLocal.insertToProduct(productEntity);
			facesContext.getPartialViewContext().getEvalScripts().add("swal({title: 'موفق!',type: 'success', text: 'محصول با موفقیت وارد گردید', confirmButtonColor: '#469408',})");
		} catch (Exception e) {
			System.err.println("product repetetly error");
			facesContext.getPartialViewContext().getEvalScripts().add("swal({title: 'ناموفق!',type: 'error', text: 'این محصول را قبلا وارد کرده اید', confirmButtonColor: '#469408',})");
		}
		

	}
	
	public String picture() throws Exception {
		try {
			UUID uuid=UUID.randomUUID();
			byte[] image1Byte = IOUtils.toByteArray(pic1.getInputStream());
			File out3 = new File("/home/wildfly/AX/" + uuid + ".jpg");
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
			File out3 = new File("/home/wildfly/AX/" + uuid + ".jpg");
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
			File out3 = new File("/home/wildfly/AX/" + uuid + ".jpg");
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
			File out3 = new File("/home/wildfly/AX/" + uuid + ".jpg");
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
			File out3 = new File("/home/wildfly/AX/" + uuid + ".jpg");
			InputStream in = new ByteArrayInputStream(image1Byte);
			BufferedImage img3 = ImageIO.read(in);
			ImageIO.write(img3, "jpg", out3);
			return uuid.toString();
		} catch (IOException e) {

			throw new Exception("error image entering 1");
		}
		
	}
	
	
	public List<ProductEntity> findAllProductSeller(){
		return productserviceLocal.findAllProductEntityBySeller(tempBean.getMoblEntity());
	}
	
	
	public void deleteProduct(long productId) {
		productserviceLocal.deleteProductEntity(productserviceLocal.findProductEntityById(productId));
	}

}
