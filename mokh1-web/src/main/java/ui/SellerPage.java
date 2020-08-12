package ui;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.imageio.ImageIO;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.Size;

import catch_db.CatchSellerLocal;
import entity.MessageEntity;
import entity.MoblEntity;
import entity.ProductEntity;
import entity.RentEntity;
import sevice.MessageServiceLocal;
import sevice.ProductserviceLocal;
import sevice.SellerServiceLocal;

@Named
@SessionScoped
public class SellerPage implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SellerPage() {
		// TODO Auto-generated constructor stub
	}
	@Inject
	private FacesContext facesContext;
	@Inject
	private CatchSellerLocal catchSellerLocal;
	@Inject
	private SellerServiceLocal sellerServiceLocal;
	@Inject
	private ProductserviceLocal productserviceLocal; 
	@Inject
	private HttpSession session;
	@Inject
	private MessageServiceLocal messageServiceLocal;
	
	private MoblEntity sellerx=new MoblEntity();
	
	ProductEntity productEntityX=new ProductEntity();

	private List<ProductEntity> products=new ArrayList<ProductEntity>();
	
	@Size(max=5000)
	private String messagePage;
	
	public MoblEntity getSellerx() {
		return sellerx;
	}

	public void setSellerx(MoblEntity sellerx) {
		this.sellerx = sellerx;
	}

	public List<ProductEntity> getProducts() {
		return products;
	}

	public void setProducts(List<ProductEntity> products) {
		this.products = products;
	}

	public ProductEntity getProductEntityX() {
		return productEntityX;
	}

	public void setProductEntityX(ProductEntity productEntityX) {
		this.productEntityX = productEntityX;
	}
	
	

	public String getMessagePage() {
		return messagePage;
	}

	public void setMessagePage(String messagePage) {
		this.messagePage = messagePage;
	}

	public MoblEntity findSeller(String sellerStoreEng) throws Exception{
		this.sellerx=sellerServiceLocal.findSellerByNameEng(sellerStoreEng);
		this.products.clear();
		this.products.addAll(productserviceLocal.findAllProductEntityBySeller(sellerx));
		if(this.sellerx.getPanel().equals("A")||this.sellerx.getPanel().equals("B")||this.sellerx.getPanel().equals("C")||this.sellerx.getPanel().equals("D"))
		return this.sellerx;
		else
			return null;
	}
	
	public byte[] findPic1() throws IOException {
		try {
		File imageFile1=new File("/home/wildfly/AX/" + this.sellerx.getPic1().toString() + ".jpg");
		BufferedImage image1=ImageIO.read(imageFile1);
		ByteArrayOutputStream baos1=new ByteArrayOutputStream();
		ImageIO.write(image1, "jpg", baos1);
		return baos1.toByteArray();
		}catch (Exception e) {
			return null;
		}
	}
	public byte[] findPic2() throws IOException {
		try {
		File imageFile1=new File("/home/wildfly/AX/" + this.sellerx.getPic2().toString() + ".jpg");
		BufferedImage image1=ImageIO.read(imageFile1);
		ByteArrayOutputStream baos1=new ByteArrayOutputStream();
		ImageIO.write(image1, "jpg", baos1);
		return baos1.toByteArray();
		}catch (Exception e) {
			return null;
		}
	}
	public byte[] findPic3() throws IOException {
		try {
		File imageFile1=new File("/home/wildfly/AX/" + this.sellerx.getPic3().toString() + ".jpg");
		BufferedImage image1=ImageIO.read(imageFile1);
		ByteArrayOutputStream baos1=new ByteArrayOutputStream();
		ImageIO.write(image1, "jpg", baos1);
		return baos1.toByteArray();
		}catch (Exception e) {
			return null;
		}
	}
	public byte[] findPic4() throws IOException {
		try {
		File imageFile1=new File("/home/wildfly/AX/" + this.sellerx.getPic4().toString() + ".jpg");
		BufferedImage image1=ImageIO.read(imageFile1);
		ByteArrayOutputStream baos1=new ByteArrayOutputStream();
		ImageIO.write(image1, "jpg", baos1);
		return baos1.toByteArray();
		}catch (Exception e) {
			return null;
		}
	}
	
	public byte[] findPic1Product(long productId) throws IOException {
		
		for (ProductEntity productEntity : products) {
			if(productEntity.getProductId()==productId)
				productEntityX=productEntity;
		}
		
		try {
		File imageFile1=new File("/home/wildfly/AX/" + productEntityX.getPic1().toString() + ".jpg");
		BufferedImage image1=ImageIO.read(imageFile1);
		ByteArrayOutputStream baos1=new ByteArrayOutputStream();
		ImageIO.write(image1, "jpg", baos1);
		return baos1.toByteArray();
		}catch (Exception e) {
			return null;
		}
	}
	
	
	public int listSize() {
		if(this.products.size()<8)
			return products.size();
		else 
			return 8;
	}
	
	public void act() {
        MessageEntity messageEntity=new MessageEntity();
        try {
        messageEntity.setPageMessage(this.messagePage);
        messageEntity.setDate(new Date());
        messageEntity.setMessageTo(sellerx);
	    messageEntity.setMessageFrom(sellerServiceLocal.findSellerByMobile(session.getAttribute("mobile").toString()));
	    messageServiceLocal.insertToMessage(messageEntity);
	    facesContext.getPartialViewContext().getEvalScripts().add("swal({title: 'موفق!',type: 'success', text: 'پیام شما با موفقیت ثبت گردید.', confirmButtonColor: '#469408',})");
		} catch (Exception e) {
			 facesContext.getPartialViewContext().getEvalScripts().add("swal({title: 'ناموفق!',type: 'error', text: 'برای ثبت پیام اول وارد سایت شوید', confirmButtonColor: '#469408',})");
		}
		

	}
	
	public String convertTagdir() throws Exception{
        try {
		File file = new File("/home/wildfly/BLOG/" + this.sellerx.getTagdirName().toString() + ".txt");
		byte[] bytesArray = new byte[(int) file.length()];
		FileInputStream fis = new FileInputStream(file);
		fis.read(bytesArray);
		fis.close();
		String string=new String(bytesArray);
		return string;
        }catch (Exception e) {
			throw new Exception("file not find");
		}
}

}