package ui;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
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
import javax.sound.midi.SysexMessage;
import javax.validation.constraints.Size;

import adminNew.AdminProfile;
import catch_db.CatchSellerLocal;
import dao.OfferDaoLocal;
import dao.ProductDaoLocal;
import entity.AyeneVConsole;
import entity.DarbChobi;
import entity.DarbZedSergat;
import entity.GhabAx;
import entity.Kabinet;
import entity.KomodBoofeKetabkhaneJakafshi;
import entity.Mdf;
import entity.MessageEntity;
import entity.MizAsali;
import entity.MizEdari;
import entity.MizJeloMobli;
import entity.MizNaharKhori;
import entity.MizTv;
import entity.MoblEntity;
import entity.Moblman;
import entity.Mojasame;
import entity.Monabat;
import entity.OfferEntity;
import entity.Panjare;
import entity.Partition;
import entity.ProductEntity;
import entity.RentEntity;
import entity.SandaliEdari;
import entity.ServiceKhab1;
import entity.ServiceKhab2;
import entity.ServiceKhabKodak;
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
//	@Inject
//	private CatchSellerLocal catchSellerLocal;
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
	@Inject
	private HomeBean homeBean;
	@Inject
	private AdminProfile adminProfile;
	@Inject
	private ProductDaoLocal productDaoLocal;
	
	private ProductEntity product;
	private Object productDetail;
	
	private Map<ProductEntity, Object> sellerxProducts = new HashMap<ProductEntity, Object>();
	
	
	private MoblEntity sellerx=new MoblEntity();
	
	//ProductEntity productEntityX=new ProductEntity();

	private List<ProductEntity> products=new ArrayList<ProductEntity>();
	@Inject
	private OfferDaoLocal offerDaoLocal;
	
	
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

//	public ProductEntity getProductEntityX() {
//		return productEntityX;
//	}
//
//	public void setProductEntityX(ProductEntity productEntityX) {
//		this.productEntityX = productEntityX;
//	}
	
	

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



	public ProductEntity getProduct() {
		return product;
	}

	public void setProduct(ProductEntity product) {
		this.product = product;
	}

	public Object getProductDetail() {
		return productDetail;
	}

	public void setProductDetail(Object productDetail) {
		this.productDetail = productDetail;
	}

	public Map<ProductEntity, Object> getSellerxProducts() {
		return sellerxProducts;
	}

	public void setSellerxProducts(Map<ProductEntity, Object> sellerxProducts) {
		this.sellerxProducts = sellerxProducts;
	}
	
	public void insertToOffer(MoblEntity moblEntity , ProductEntity product) {
		OfferEntity offerEntity = new OfferEntity();
		offerEntity.setOfferMerchantPage(moblEntity);
		offerEntity.setOfferProduct(product);
		offerEntity.setOfferUser(homeBean.getMoblEntity());
		offerEntity.setUserTokeLoguot(homeBean.getUserProductCookie());
		offerEntity.setViewDate(new Date());
		try {
			offerDaoLocal.insertToOffer(offerEntity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.err.println("insert offer error");
		}
	}

	public MoblEntity findSeller(String sellerStoreEng) throws Exception{
		this.sellerx=sellerServiceLocal.findSellerByNameEng(sellerStoreEng);
		insertToOffer(sellerx,null);
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
	
	public List<ProductEntity> findUserProduct(){
		products.clear();
		try {
		System.err.println(sellerx.getId());
		this.products.addAll(productDaoLocal.findProductByUser(sellerx));
		return this.products;
		}catch (Exception e) {
			return null;
		}
		}
	

	public int listSize() {
		int size = this.products.size();
		if(size<6)
			return size;
		else 
			return 6;
	}
	
	public void act() {
        MessageEntity messageEntity=new MessageEntity();
        try {
        if(!this.messageSender.equals("")&&!this.messagePage.equals("")) {
        messageEntity.setPageMessage("فرستنده : " + this.messageSender + "--" + "متن پیام : " + this.messagePage);
        messageEntity.setDate(new Date());
        messageEntity.setMessageTo(sellerx);
        if(homeBean.getMoblEntity()!=null) {
        messageEntity.setMessageFrom(homeBean.getMoblEntity());
        System.err.println("11111111111111111111111111111");
        System.err.println(homeBean.getMoblEntity().getMobile());
        }
        else {
        messageEntity.setMessageFrom(adminProfile.getMoblEntity());
        System.err.println("22222222222222222222222222222222222");
        System.err.println(adminProfile.getMoblEntity().getMobile());
        }
        // messageEntity.setMessageFrom(sellerServiceLocal.findSellerByMobile(session.getAttribute("mobile").toString()));
	    messageServiceLocal.insertToMessage(messageEntity);
	    facesContext.getPartialViewContext().getEvalScripts().add("swal({title: 'موفق!',type: 'success', text: 'پیام شما با موفقیت ثبت گردید.', confirmButtonColor: '#469408',})");
	    this.messageSender="";
	    this.messagePage="";
		}else 
	    {
			 facesContext.getPartialViewContext().getEvalScripts().add("swal({title: 'ناموفق!',type: 'error', text: 'فیلد ها را پر کنید', confirmButtonColor: '#469408',})");
		}
        }catch (Exception e) {
        	facesContext.getPartialViewContext().getEvalScripts().add("swal({title: 'ناموفق!',type: 'error', text: 'لطفا ابتدا وارد شوید', confirmButtonColor: '#469408',})");
		}

	}
	
	public void niaz() {
        try {
			 facesContext.getPartialViewContext().getEvalScripts().add("swal({title: 'ناموفق!',type: 'error', text: 'لطفا ابتدا وارد شوید', confirmButtonColor: '#469408',})");
		}
        catch (Exception e) {
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
	    this.messageSender="";
	    this.messagePage="";
		} catch (Exception e) {
			//e.printStackTrace();
			 facesContext.getPartialViewContext().getEvalScripts().add("swal({title: 'ناموفق!',type: 'error', text: 'برای ثبت پیام اول وارد سایت شوید', confirmButtonColor: '#469408',})");
		}
	}
	
	
	
	
	public String convertTagdir() throws Exception{
        try {
		File file = new File("/home/wildfly/wildfly-18.0.1.Final/fimg/" + this.sellerx.getTagdirName().toString() + ".txt");
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
	
	public void redirectToProductDetail(long productId, String productName , String sellerEng) {
		this.product=product;
		this.productDetail = productDetail;
		System.err.println("***********************************");
		System.err.println("***********************************");
		System.err.println("***********************************");
		System.err.println(this.product.getNameCode());
		System.err.println(productDetail.toString());
		System.err.println("***********************************");
		System.err.println("***********************************");
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("/pages/product/product-detail.xhtml?sellerNamePer=" + sellerEng + "&productName=" + this.product.getNameCode());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
//	public ProductEntity findProductEntityDetail(long productId) {
//		for(ProductEntity key : sellerxProducts.keySet()) {
//		    if(key.getProductId()==productId) {
//
//		    	this.product = key;
//		    	this.productDetail = sellerxProducts.get(key);
//		    }
//		}
//		return this.product;
//	}
	
	/*
	 * public ProductEntity findProductEntityDetail(long productId) { this.product =
	 * productDaoLocal.findProductEntityById(productId);
	 * insertToOffer(product.getProduct() , product);
	 * if(this.product.getProductType().equals("AyeneVConsole")) this.productDetail
	 * = (AyeneVConsole)productDaoLocal.getProductDetail();
	 * if(this.product.getProductType().equals("DarbChobi")) this.productDetail =
	 * (DarbChobi)productDaoLocal.getProductDetail();
	 * if(this.product.getProductType().equals("DarbZedSergat")) this.productDetail
	 * = (DarbZedSergat)productDaoLocal.getProductDetail();
	 * if(this.product.getProductType().equals("GhabAx")) this.productDetail =
	 * (GhabAx)productDaoLocal.getProductDetail();
	 * if(this.product.getProductType().equals("Kabinet")) this.productDetail =
	 * (Kabinet)productDaoLocal.getProductDetail();
	 * if(this.product.getProductType().equals("KomodBoofeKetabkhaneJakafshi"))
	 * this.productDetail =
	 * (KomodBoofeKetabkhaneJakafshi)productDaoLocal.getProductDetail();
	 * if(this.product.getProductType().equals("Mdf")) this.productDetail =
	 * (Mdf)productDaoLocal.getProductDetail();
	 * if(this.product.getProductType().equals("MizAsali")) this.productDetail =
	 * (MizAsali)productDaoLocal.getProductDetail();
	 * if(this.product.getProductType().equals("MizEdari")) this.productDetail =
	 * (MizEdari)productDaoLocal.getProductDetail();
	 * if(this.product.getProductType().equals("MizJeloMobli")) this.productDetail =
	 * (MizJeloMobli)productDaoLocal.getProductDetail();
	 * if(this.product.getProductType().equals("MizNaharKhori")) this.productDetail
	 * = (MizNaharKhori)productDaoLocal.getProductDetail();
	 * if(this.product.getProductType().equals("MizTv")) this.productDetail =
	 * (MizTv)productDaoLocal.getProductDetail();
	 * if(this.product.getProductType().equals("Moblman")) this.productDetail =
	 * (Moblman)productDaoLocal.getProductDetail();
	 * if(this.product.getProductType().equals("Mojasame")) this.productDetail =
	 * (Mojasame)productDaoLocal.getProductDetail();
	 * if(this.product.getProductType().equals("Monabat")) this.productDetail =
	 * (Monabat)productDaoLocal.getProductDetail();
	 * if(this.product.getProductType().equals("Panjare")) this.productDetail =
	 * (Panjare)productDaoLocal.getProductDetail();
	 * if(this.product.getProductType().equals("Partition")) this.productDetail =
	 * (Partition)productDaoLocal.getProductDetail();
	 * if(this.product.getProductType().equals("SandaliEdari")) this.productDetail =
	 * (SandaliEdari)productDaoLocal.getProductDetail();
	 * if(this.product.getProductType().equals("ServiceKhab1")) this.productDetail =
	 * (ServiceKhab1)productDaoLocal.getProductDetail();
	 * if(this.product.getProductType().equals("ServiceKhab2")) this.productDetail =
	 * (ServiceKhab2)productDaoLocal.getProductDetail();
	 * if(this.product.getProductType().equals("ServiceKhabKodak"))
	 * this.productDetail = (ServiceKhabKodak)productDaoLocal.getProductDetail();
	 * return this.product; }
	 * 
	 * public String convertType(String type) {
	 * if(this.product.getProductType().equals("AyeneVConsole")) return
	 * "آینه و کنسول"; else if(this.product.getProductType().equals("DarbChobi"))
	 * return "درب چوبی"; else
	 * if(this.product.getProductType().equals("DarbZedSergat")) return
	 * "درب ضد سرقت"; else if(this.product.getProductType().equals("GhabAx")) return
	 * "قاب عکس"; else if(this.product.getProductType().equals("Kabinet")) return
	 * "کابینت"; else
	 * if(this.product.getProductType().equals("KomodBoofeKetabkhaneJakafshi"))
	 * return "کمد , بوفه , جاکفشی و کتابخانه"; else
	 * if(this.product.getProductType().equals("Mdf")) return "ام دی اف"; else
	 * if(this.product.getProductType().equals("MizAsali")) return "میز عسلی"; else
	 * if(this.product.getProductType().equals("MizEdari")) return "میز اداری"; else
	 * if(this.product.getProductType().equals("MizJeloMobli")) return
	 * "میز جلو مبلی"; else
	 * if(this.product.getProductType().equals("MizNaharKhori")) return
	 * "میز نهار خوری"; else if(this.product.getProductType().equals("MizTv"))
	 * return "میز تلویزیون"; else
	 * if(this.product.getProductType().equals("Moblman")) return "مبلمان"; else
	 * if(this.product.getProductType().equals("Mojasame")) return "مجسمه"; else
	 * if(this.product.getProductType().equals("Monabat")) return "منبت"; else
	 * if(this.product.getProductType().equals("Panjare")) return "بنجره"; else
	 * if(this.product.getProductType().equals("Partition")) return "بارتیشن"; else
	 * if(this.product.getProductType().equals("SandaliEdari")) return
	 * "صندلی اداری"; else if(this.product.getProductType().equals("ServiceKhab1"))
	 * return "سرویس خواب تک نفره"; else
	 * if(this.product.getProductType().equals("ServiceKhab2")) return
	 * "سرویس خواب دو نفره"; else
	 * if(this.product.getProductType().equals("ServiceKhabKodak")) return
	 * "سرویس خواب کودک"; else return ""; }
	 */
	
	public String daradNadarad(boolean item) {
		if(item==true)
			return "دارد";
		else 
			return "ندارد";
	}
	
	public String hastNist(boolean item) {
		if(item==true)
			return "هست";
		else 
			return "نیست";
	}
	
	
	public void haveProduct(ComponentSystemEvent event){
		FacesContext contex=FacesContext.getCurrentInstance();
		try{
		if(findUserProduct().size()>0)
			System.out.println("******************ok******************");
		else
			FacesContext.getCurrentInstance().getExternalContext().redirect("/pages/main/home.xhtml");
		}catch (Exception e) {
			try {
				FacesContext.getCurrentInstance().getExternalContext().redirect("/pages/main/home.xhtml");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	public ProductEntity findProductEntityDetail(long productId) {
		System.err.println("IIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII");
		System.err.println(productDaoLocal.countAllProduct());
		this.product = productDaoLocal.findProductOnlyById(productId);
		return this.product;
	}
	
}
