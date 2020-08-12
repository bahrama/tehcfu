package admin;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.imageio.ImageIO;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.Column;
import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;

import entity.MoblEntity;
import sevice.SellerServiceLocal;

@Named
@ViewScoped
public class EditSeller implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EditSeller() {
		// TODO Auto-generated constructor stub
	}
	@Inject
	private SellerServiceLocal sellerServiceLocal;
	
	private MoblEntity moblEntity=new MoblEntity();
	
	private String aboutUs;
	private String email;
	private String fax;
	private String instagram;
	private String modirforoshName;
	private String modirforoshPhone;
	private String phone;
	private String postcode;
	private String sellerAddres;
	private String vage;
	private String sellerName;
	private String sellerStoreEng;
	private String sellerStorePer;
	private String telegram;
	private String website;
	private double lat;
	private double lng;
	private String panel;
	private String noeFaaliat;
	private Part pic1;
	private Part pic2;
	private Part pic3;
	private Part pic4;
	private String mobile;
	private String ssn;
	private List<String> faaliats=new ArrayList<String>();
	public MoblEntity getMoblEntity() {
		return moblEntity;
	}
	public void setMoblEntity(MoblEntity moblEntity) {
		this.moblEntity = moblEntity;
	}
	public String getAboutUs() {
		return aboutUs;
	}
	public void setAboutUs(String aboutUs) {
		this.aboutUs = aboutUs;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getInstagram() {
		return instagram;
	}
	public void setInstagram(String instagram) {
		this.instagram = instagram;
	}
	public String getModirforoshName() {
		return modirforoshName;
	}
	public void setModirforoshName(String modirforoshName) {
		this.modirforoshName = modirforoshName;
	}
	public String getModirforoshPhone() {
		return modirforoshPhone;
	}
	public void setModirforoshPhone(String modirforoshPhone) {
		this.modirforoshPhone = modirforoshPhone;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public String getSellerAddres() {
		return sellerAddres;
	}
	public void setSellerAddres(String sellerAddres) {
		this.sellerAddres = sellerAddres;
	}
	public String getSellerName() {
		return sellerName;
	}
	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}
	public String getSellerStoreEng() {
		return sellerStoreEng;
	}
	public void setSellerStoreEng(String sellerStoreEng) {
		this.sellerStoreEng = sellerStoreEng;
	}
	public String getSellerStorePer() {
		return sellerStorePer;
	}
	public void setSellerStorePer(String sellerStorePer) {
		this.sellerStorePer = sellerStorePer;
	}
	public String getTelegram() {
		return telegram;
	}
	public void setTelegram(String telegram) {
		this.telegram = telegram;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public double getLng() {
		return lng;
	}
	public void setLng(double lng) {
		this.lng = lng;
	}
	public String getPanel() {
		return panel;
	}
	public void setPanel(String panel) {
		this.panel = panel;
	}
	public String getNoeFaaliat() {
		return noeFaaliat;
	}
	public void setNoeFaaliat(String noeFaaliat) {
		this.noeFaaliat = noeFaaliat;
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
	
	
	
	
	public List<String> getFaaliats() {
		return faaliats;
	}
	public void setFaaliats(List<String> faaliats) {
		this.faaliats = faaliats;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public List<MoblEntity> findAllSeller(){
		return sellerServiceLocal.findAllSeller();
	}
	
	public String getVage() {
		return vage;
	}
	public void setVage(String vage) {
		this.vage = vage;
	}
	public void deleteSeller(int id) {
		try {
			sellerServiceLocal.deleteSeller(sellerServiceLocal.findSellerById(id));
			 FacesContext.getCurrentInstance().getExternalContext().redirect("/pages/admin/edit-seller.xhtml");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public byte[] findPic1() throws IOException {
		try {
		File imageFile1=new File("/home/wildfly/AX/" + this.moblEntity.getPic1() + ".jpg");
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
		File imageFile1=new File("/home/wildfly/AX/" + this.moblEntity.getPic2() + ".jpg");
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
		File imageFile1=new File("/home/wildfly/AX/" + this.moblEntity.getPic3() + ".jpg");
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
		File imageFile1=new File("/home/wildfly/AX/" + this.moblEntity.getPic4() + ".jpg");
		BufferedImage image1=ImageIO.read(imageFile1);
		ByteArrayOutputStream baos1=new ByteArrayOutputStream();
		ImageIO.write(image1, "jpg", baos1);
		return baos1.toByteArray();
		}catch (Exception e) {
			return null;
		}
	}
	
	
	public void convertPicture1() throws Exception {
		try {
			byte[] image1Byte = IOUtils.toByteArray(pic1.getInputStream());
			File out3 = new File("/home/wildfly/AX/" + this.moblEntity.getPic1() + ".jpg");
			InputStream in = new ByteArrayInputStream(image1Byte);
			BufferedImage img3 = ImageIO.read(in);
			ImageIO.write(img3, "jpg", out3);
		} catch (IOException e) {

			throw new Exception("error image entering 1");
		}
		
	}
	public void convertPicture2() throws Exception {
		try {
			byte[] image1Byte = IOUtils.toByteArray(pic2.getInputStream());
			File out3 = new File("/home/wildfly/AX/" + this.moblEntity.getPic2() + ".jpg");
			InputStream in = new ByteArrayInputStream(image1Byte);
			BufferedImage img3 = ImageIO.read(in);
			ImageIO.write(img3, "jpg", out3);
		} catch (IOException e) {

			throw new Exception("error image entering 1");
		}
		
	}
	
	public void convertPicture3() throws Exception {
		try {
			byte[] image1Byte = IOUtils.toByteArray(pic3.getInputStream());
			File out3 = new File("/home/wildfly/AX/" + this.moblEntity.getPic3() + ".jpg");
			InputStream in = new ByteArrayInputStream(image1Byte);
			BufferedImage img3 = ImageIO.read(in);
			ImageIO.write(img3, "jpg", out3);
		} catch (IOException e) {

			throw new Exception("error image entering 1");
		}
		
	}
	
	public void convertPicture4() throws Exception {
		try {
			byte[] image1Byte = IOUtils.toByteArray(pic4.getInputStream());
			File out3 = new File("/home/wildfly/AX/" + this.moblEntity.getPic4() + ".jpg");
			InputStream in = new ByteArrayInputStream(image1Byte);
			BufferedImage img3 = ImageIO.read(in);
			ImageIO.write(img3, "jpg", out3);
		} catch (IOException e) {

			throw new Exception("error image entering 1");
		}
		
	}
	
	private String faaliatHa() {
		try {
		System.err.println("KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK");
		String item="";
		for (String string : this.faaliats) {
			item=item +string + "-";
		}
		System.err.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%" + item);
		return item;
		}catch (Exception e) {
			System.err.println();
			return "";
		}
		}
	
	
	public void updateSeller() {
		try {
			FacesContext context = FacesContext.getCurrentInstance();
			if(!faaliatHa().equals(""))
			this.moblEntity.setFaaliat(this.faaliatHa());
			if(!aboutUs.equals(""))
			this.moblEntity.setAboutUs(aboutUs);
			if(!email.equals(""))
			this.moblEntity.setEmail(email);
			if(!fax.equals(""))
			this.moblEntity.setFax(fax);
			if(!instagram.equals(""))
			this.moblEntity.setInstagram(instagram);
			if(!modirforoshName.equals(""))
			this.moblEntity.setModirforoshName(modirforoshName);
			if(!modirforoshPhone.equals(""))
			this.moblEntity.setModirforoshPhone(modirforoshPhone);
			if(!phone.equals(""))
			this.moblEntity.setPhone(phone);
			if(!postcode.equals(""))
			this.moblEntity.setPostcode(postcode);
			if(!sellerAddres.equals(""))
			this.moblEntity.setSellerAddres(sellerAddres);
			if(!sellerName.equals(""))
			this.moblEntity.setSellerName(sellerName);
			if(!sellerStoreEng.equals(""))
			this.moblEntity.setSellerStoreEng(sellerStoreEng);
			if(!sellerStorePer.equals(""))
			this.moblEntity.setSellerStorePer(sellerStorePer);
			if(!telegram.equals(""))
			this.moblEntity.setTelegram(telegram);
			if(!website.equals(""))
			this.moblEntity.setWebsite(website);
			if(!ssn.equals(""))
			this.moblEntity.setSsn(ssn);
			if(!mobile.equals(""))
			this.moblEntity.setMobile(mobile);
			if(!vage.equals(""))
			this.moblEntity.setVage(vage);
			try {
			if((!panel.equals(null))|(!panel.equals("")))
			this.moblEntity.setPanel(panel);
			}catch (Exception e) {
				System.err.println("18");
			}
			try {
			if(!pic1.equals(null))
			this.convertPicture1();
			}catch (Exception e) {
				System.err.println("pic error");
			}
			try {
			if(!pic2.equals(null))
			this.convertPicture2();
			}catch (Exception e) {
				System.err.println("pic error");
			}
			try {
			if(!pic3.equals(null))
			this.convertPicture3();
			}catch (Exception e) {
				System.err.println("pic error");
			}
			try {
            if(!pic4.equals(null))
			this.convertPicture4();
			}catch (Exception e) {
				System.err.println("pic error");
			}
			sellerServiceLocal.updateSeller(this.moblEntity);
			this.aboutUs="";
			this.email="";
			this.fax="";
			this.instagram="";
			this.lat=0;
			this.lng=0;
			this.mobile="";
			this.modirforoshName="";
			this.modirforoshPhone="";
			this.noeFaaliat="";
			this.panel="";
			this.phone="";
			this.postcode="";
			this.sellerAddres="";
			this.sellerName="";
			this.sellerStoreEng="";
			this.sellerStorePer="";
			this.ssn="";
			this.telegram="";
			this.website="";
			this.vage="";
			context.addMessage(null, new FacesMessage("با موفقیت آپدیت گردید."));
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	
	
	

}
