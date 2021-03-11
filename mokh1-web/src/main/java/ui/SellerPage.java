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

import javax.annotation.Resource;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.imageio.ImageIO;
import javax.inject.Inject;
import javax.inject.Named;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
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
	@Resource(name = "java:jboss/mail/Default")
    private Session sessionSend;
	
	
	private MoblEntity sellerx=new MoblEntity();
	
	ProductEntity productEntityX=new ProductEntity();

	private List<ProductEntity> products=new ArrayList<ProductEntity>();
	
	@Size(max=5000)
	private String messagePage;
	@Size(max=100)
	private String messageSender;
	
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
	
	

	public String getMessageSender() {
		return messageSender;
	}

	public void setMessageSender(String messageSender) {
		this.messageSender = messageSender;
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
	public byte[] findPic5() throws IOException {
		try {
		File imageFile1=new File("/home/wildfly/AX/" + this.sellerx.getPic5().toString() + ".jpg");
		BufferedImage image1=ImageIO.read(imageFile1);
		ByteArrayOutputStream baos1=new ByteArrayOutputStream();
		ImageIO.write(image1, "jpg", baos1);
		return baos1.toByteArray();
		}catch (Exception e) {
		e.printStackTrace();
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
       // try {
        if(!this.messageSender.equals("")&&!this.messagePage.equals("")) {
        messageEntity.setPageMessage("فرستنده : " + this.messageSender + "--" + "متن پیام : " + this.messagePage);
        messageEntity.setDate(new Date());
        messageEntity.setMessageTo(sellerx);
	   // messageEntity.setMessageFrom(sellerServiceLocal.findSellerByMobile(session.getAttribute("mobile").toString()));
	    messageServiceLocal.insertToMessage(messageEntity);
	    facesContext.getPartialViewContext().getEvalScripts().add("swal({title: 'موفق!',type: 'success', text: 'پیام شما با موفقیت ثبت گردید.', confirmButtonColor: '#469408',})");
		}else 
	    {
			 facesContext.getPartialViewContext().getEvalScripts().add("swal({title: 'ناموفق!',type: 'error', text: 'فیلد ها را پر کنید', confirmButtonColor: '#469408',})");
		}
		

	}
	
	public void actBoss() {
        try {
        Message message = new MimeMessage(sessionSend);
	    message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("abasi.tehcfu@gmail.com"));
          //  message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("ali_alikhahasl@yahoo.com"));
	    message.setSubject("پیام از سایت");
	    String msgk=new String();
		msgk+="<html>";
		msgk+="<title>";
		msgk+="<meta Content-Type:'text/html' charset='utf-8'/>";
		msgk+="</title>";
		msgk+="<body>";
		msgk+="<p style=\"text-align:right; margin:30px;\"> فرستنده : " +"<b style=\"font-size:18px;\">" + this.messageSender + "</b>" +"</p>";
		/*msgk+="<p style=\"text-align:right; margin:30px;\"> شماره موبایل :"+"<b style=\"font-size:18px;\">" + session.getAttribute("mobile").toString() +"</b>" +"</p>";*/
		msgk+="<p style=\"text-align:right; margin:30px;\"> پیام:"+"<b style=\"font-size:18px;\">" + this.messagePage +"</b>" + "</p>";
		msgk+="</body>";
		msgk+="</html>";
	    message.setContent(msgk,"text/html; charset=UTF-8");
	    Transport.send(message);
	    facesContext.getPartialViewContext().getEvalScripts().add("swal({title: 'موفق!',type: 'success', text: 'پیام شما با موفقیت ثبت گردید.', confirmButtonColor: '#469408',})");
		} catch (Exception e) {
			//e.printStackTrace();
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
