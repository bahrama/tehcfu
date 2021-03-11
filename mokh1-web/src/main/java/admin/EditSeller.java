package admin;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.UUID;

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
	
	private String aboutUs="";
	private String tagdirName="";
	private String email="";
	private String fax="";
	private String instagram="";
	private String modirforoshName="";
	private String modirforoshPhone="";
	private String phone="";
	private String postcode="";
	private String sellerAddres="";
	private String vage="";
	private String sellerName="";
	private String sellerStoreEng="";
	private String sellerStorePer="";
	private String telegram="";
	private String website="";
	private double lat;
	private double lng;
	private String panel="";
	private String noeFaaliat="";
	private Part pic1;
	private Part pic2;
	private Part pic3;
	private Part pic4;
	private Part pic5;
	private String mobile="";
	private String ssn="";
	private List<String> faaliats=new ArrayList<String>();
	
	///////////////////////////////////
	
	private String sabteSefaresh="";
	private String mostajer="";
	private String mohlateEjare="";
	private String mostajerName="";
	private String mostajerBirthday="";
	private String mostajerSsn="";	
	private String mostajerMobile="";
	private String shomareJavaz="";
	private String tarikhEtebar="";
	private String hasMobasher="";
	private String mobasherName="";
	private String rabetName="";
	private String sematRabet="";	
	private String rabetMobile="";
	private String shabakeMazajiMobile="";
	private String mojtame="";
	private String birthDay="";
	
	
	
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
	
	public String getSabteSefaresh() {
		return sabteSefaresh;
	}
	public void setSabteSefaresh(String sabteSefaresh) {
		this.sabteSefaresh = sabteSefaresh;
	}
	public String getMostajer() {
		return mostajer;
	}
	public void setMostajer(String mostajer) {
		this.mostajer = mostajer;
	}
	public String getMohlateEjare() {
		return mohlateEjare;
	}
	public void setMohlateEjare(String mohlateEjare) {
		this.mohlateEjare = mohlateEjare;
	}
	public String getMostajerName() {
		return mostajerName;
	}
	public void setMostajerName(String mostajerName) {
		this.mostajerName = mostajerName;
	}
	public String getMostajerBirthday() {
		return mostajerBirthday;
	}
	public void setMostajerBirthday(String mostajerBirthday) {
		this.mostajerBirthday = mostajerBirthday;
	}
	public String getMostajerSsn() {
		return mostajerSsn;
	}
	public void setMostajerSsn(String mostajerSsn) {
		this.mostajerSsn = mostajerSsn;
	}
	public String getMostajerMobile() {
		return mostajerMobile;
	}
	public void setMostajerMobile(String mostajerMobile) {
		this.mostajerMobile = mostajerMobile;
	}
	public String getShomareJavaz() {
		return shomareJavaz;
	}
	public void setShomareJavaz(String shomareJavaz) {
		this.shomareJavaz = shomareJavaz;
	}
	public String getTarikhEtebar() {
		return tarikhEtebar;
	}
	public void setTarikhEtebar(String tarikhEtebar) {
		this.tarikhEtebar = tarikhEtebar;
	}
	public String getHasMobasher() {
		return hasMobasher;
	}
	public void setHasMobasher(String hasMobasher) {
		this.hasMobasher = hasMobasher;
	}
	public String getMobasherName() {
		return mobasherName;
	}
	public void setMobasherName(String mobasherName) {
		this.mobasherName = mobasherName;
	}
	public String getRabetName() {
		return rabetName;
	}
	public void setRabetName(String rabetName) {
		this.rabetName = rabetName;
	}
	public String getSematRabet() {
		return sematRabet;
	}
	public void setSematRabet(String sematRabet) {
		this.sematRabet = sematRabet;
	}
	public String getRabetMobile() {
		return rabetMobile;
	}
	public void setRabetMobile(String rabetMobile) {
		this.rabetMobile = rabetMobile;
	}
	public String getShabakeMazajiMobile() {
		return shabakeMazajiMobile;
	}
	public void setShabakeMazajiMobile(String shabakeMazajiMobile) {
		this.shabakeMazajiMobile = shabakeMazajiMobile;
	}
	public String getMojtame() {
		return mojtame;
	}
	public void setMojtame(String mojtame) {
		this.mojtame = mojtame;
	}
	public String getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}
	
	public Part getPic5() {
		return pic5;
	}
	public void setPic5(Part pic5) {
		this.pic5 = pic5;
	}
	
	
	
	public String getTagdirName() {
		return tagdirName;
	}
	public void setTagdirName(String tagdirName) {
		this.tagdirName = tagdirName;
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
	
	public byte[] findPic5() throws IOException {
		try {
		File imageFile1=new File("/home/wildfly/AX/" + this.moblEntity.getPic5() + ".jpg");
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
	
	public String convertPicture5() throws Exception {
		try {
			UUID uuid=UUID.randomUUID();
			byte[] image1Byte = IOUtils.toByteArray(pic5.getInputStream());
			File out3 = new File("/home/wildfly/AX/" + uuid + ".jpg");
			InputStream in = new ByteArrayInputStream(image1Byte);
			BufferedImage img3 = ImageIO.read(in);
			ImageIO.write(img3, "jpg", out3);
			return uuid.toString();
		} catch (IOException e) {

			throw new Exception("error image entering 5");
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
	
	public Date jalali_to_gregorian(int jy, int jm, int jd) {
		int gy;
		if (jy > 979) {
			gy = 1600;
			jy -= 979;
		} else {
			gy = 621;
		}
		int days = (365 * jy) + (((int) (jy / 33)) * 8) + ((int) (((jy % 33) + 3) / 4)) + 78 + jd
				+ ((jm < 7) ? (jm - 1) * 31 : ((jm - 7) * 30) + 186);
		gy += 400 * ((int) (days / 146097));
		days %= 146097;
		if (days > 36524) {
			gy += 100 * ((int) (--days / 36524));
			days %= 36524;
			if (days >= 365)
				days++;
		}
		gy += 4 * ((int) (days / 1461));
		days %= 1461;
		if (days > 365) {
			gy += (int) ((days - 1) / 365);
			days = (days - 1) % 365;
		}
		int gd = days + 1;
		int[] sal_a = { 0, 31, ((gy % 4 == 0 && gy % 100 != 0) || (gy % 400 == 0)) ? 29 : 28, 31, 30, 31, 30, 31, 31,
				30, 31, 30, 31 };
		int gm;
		for (gm = 0; gm < 13; gm++) {
			int v = sal_a[gm];
			if (gd <= v)
				break;
			gd -= v;
		}
		int[] out = { gy, gm, gd };
		System.err.println("year:" + gy);
		System.err.println("month:" + gm);
		System.err.println("day:" + gd);
		// Date date=new Date(gy,gm,gd);
		Calendar calendar = new GregorianCalendar(gy, gm - 1, gd);
		Date date = new Date();
		date = calendar.getTime();
		return date;
	}

	public Date mohlateEjareChangeDate(String inp) {
		String test = inp;
		String arr[] = test.split("/");
		String ans = "";

		for (String t : arr) {
			ans += t;
		}
		System.err.println(ans);
		char[] daychar = new char[2];
		char[] monthchar = new char[2];
		char[] yearchar = new char[4];
		ans.getChars(0, 4, yearchar, 0);
		String yearstr = "";
		String monthstr = "";
		String daystr = "";
		for (char c : yearchar) {
			yearstr += c;
		}
		System.err.println(yearstr);

		ans.getChars(4, 6, monthchar, 0);
		for (char cc : monthchar) {
			monthstr += cc;
		}
		System.err.println(monthstr);

		ans.getChars(6, 8, daychar, 0);
		for (char ccc : daychar) {
			daystr += ccc;
		}
		System.err.println(daystr);

		return jalali_to_gregorian(Integer.parseInt(yearstr), Integer.parseInt(monthstr), Integer.parseInt(daystr));

	}
	
	public String convertTagdir(){
		try {
		UUID uuid=UUID.randomUUID();
		byte[] blog = this.tagdirName.getBytes(StandardCharsets.UTF_8);
		File out1 = new File("/home/wildfly/BLOG/" + uuid+ ".txt");
		InputStream in1 = new ByteArrayInputStream(blog);
		OutputStream outputStream = new FileOutputStream(out1);
		outputStream.write(blog);
		outputStream.flush();
		return uuid.toString();
		}catch (Exception e) {
			//e.printStackTrace();
			//throw new Exception("error blog main entering 1");
			return null;
		}
	}
	
	public void updateSeller() {
		System.err.println("faaliatHa():"+faaliatHa());
		System.err.println("aboutUs:"+aboutUs);
		System.err.println("email:"+email);
		System.err.println("fax:"+fax);
		System.err.println("instagram:"+instagram);
		System.err.println("modirforoshName:"+modirforoshName);
		System.err.println("modirforoshPhone:"+modirforoshPhone);
		System.err.println("phone:"+phone);
		System.err.println("postcode:"+postcode);
		System.err.println("sellerAddres:"+sellerAddres);
		System.err.println("sellerName:"+sellerName);
		System.err.println("sellerStoreEng:"+sellerStoreEng);
		System.err.println("sellerStorePer:"+sellerStorePer);
		System.err.println("telegram:"+telegram);
		System.err.println("website:"+website);
		System.err.println("ssn:"+ssn);
		System.err.println("mobile:"+mobile);
		System.err.println("vage:"+vage);
		System.err.println("panel:"+panel);
		System.err.println("sabteSefaresh:"+sabteSefaresh);
		System.err.println("mostajer:"+mostajer);
		System.err.println("mohlateEjare:"+mohlateEjare);
		System.err.println("mostajerName:"+mostajerName);
		System.err.println("mostajerBirthday:"+mostajerBirthday);
		System.err.println("mostajerSsn:"+mostajerSsn);
		System.err.println("mostajerMobile:"+mostajerMobile);
		System.err.println("shomareJavaz:"+shomareJavaz);
		System.err.println("tarikhEtebar:"+tarikhEtebar);
		System.err.println("hasMobasher:"+hasMobasher);
		System.err.println("mobasherName:"+mobasherName);
		System.err.println("rabetName:"+rabetName);
		System.err.println("sematRabet:"+sematRabet);
		System.err.println("rabetMobile:"+rabetMobile);
		System.err.println("shabakeMazajiMobile:"+shabakeMazajiMobile);
		System.err.println("mojtame:"+mojtame);
		System.err.println("birthDay:"+birthDay);
		try {
			FacesContext context = FacesContext.getCurrentInstance();
			if(!faaliatHa().equals(""))
			this.moblEntity.setFaaliat(this.faaliatHa());
			if(!aboutUs.equals(""))
			this.moblEntity.setAboutUs(aboutUs);
			if(!tagdirName.equals(""))
			this.moblEntity.setTagdirName(this.convertTagdir());			
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
				System.err.println("pic error1");
			}
			try {
			if(!pic2.equals(null))
			this.convertPicture2();
			}catch (Exception e) {
				System.err.println("pic error2");
			}
			try {
			if(!pic3.equals(null))
			this.convertPicture3();
			}catch (Exception e) {
				System.err.println("pic error3");
			}
			try {
            if(!pic4.equals(null))
			this.convertPicture4();
			}catch (Exception e) {
				System.err.println("pic error4");
			}
			try {
	            if(!pic5.equals(null))
	            this.moblEntity.setPic5(this.convertPicture5());
				}catch (Exception e) {
					System.err.println("pic error5");
				}
			//////////////////////////
			System.err.println("1e");
			try {
			if((!sabteSefaresh.equals(""))|(!sabteSefaresh.equals(null))) {
				this.moblEntity.setSabteSefaresh(sabteSefaresh);
			System.err.println("1");
			}
			}catch (NullPointerException e) {
				System.err.println("sabteSefaresh null point");
			}
			System.err.println("2e");
			try {
				if((!mostajer.equals(""))|(!mostajer.equals(null))) {
				this.moblEntity.setMostajer(Boolean.parseBoolean(mostajer));
				System.err.println("2");
				}
			}catch (NullPointerException e) {
				System.err.println("mostajer null point");
			}
				System.err.println("3e");
				if(!mohlateEjare.equals("")) {
				this.moblEntity.setMohlateEjare(this.mohlateEjareChangeDate(mohlateEjare));
				System.err.println("3");
				}
				System.err.println("4e");
				if(!mostajerName.equals("")) {
				this.moblEntity.setMostajerName(mostajerName);
				System.err.println("4");
				}
				System.err.println("5e");
				if(!mostajerBirthday.equals("")) {
				this.moblEntity.setMostajerBirthday(this.mohlateEjareChangeDate(mostajerBirthday));
				System.err.println("5");
				}
				System.err.println("6e");
				if(!mostajerSsn.equals("")) {
				this.moblEntity.setMostajerSsn(mostajerSsn);
				System.err.println("6");
				}
				System.err.println("7e");
				if(!mostajerMobile.equals("")) {
				this.moblEntity.setMostajerMobile(mostajerMobile);
				System.err.println("7");
				}
				System.err.println("8e");
				if(!shomareJavaz.equals("")) {
				this.moblEntity.setShomareJavaz(shomareJavaz);
				System.err.println("8");
				}
				System.err.println("9e");
				if(!tarikhEtebar.equals("")) {
				this.moblEntity.setTarikhEtebar(this.mohlateEjareChangeDate(tarikhEtebar));
				System.err.println("9");
				}
				System.err.println("10e");
				try {
				if((!hasMobasher.equals(null))|(!hasMobasher.equals(null))) {
				this.moblEntity.setHasMobasher(Boolean.parseBoolean(hasMobasher));
				System.err.println("10");
				}
				}catch (NullPointerException e) {
				System.err.println("hasMobasher null point");
				}
				System.err.println("11e");
				if(!mobasherName.equals("")) {
				this.moblEntity.setMobasherName(mobasherName);
				System.err.println("11");
				}
				System.err.println("12e");
				if(!rabetName.equals("")) {
				this.moblEntity.setRabetName(rabetName);
				System.err.println("12");
				}
				System.err.println("13e");
				if(!sematRabet.equals("")) {
				this.moblEntity.setSematRabet(sematRabet);
				System.err.println("13");
				}
				System.err.println("14e");
				if(!rabetMobile.equals("")) {
				this.moblEntity.setRabetMobile(rabetMobile);
				System.err.println("14");
				}
				System.err.println("15e");
				if(!shabakeMazajiMobile.equals("")) {
				this.moblEntity.setShabakeMazajiMobile(shabakeMazajiMobile);
				System.err.println("15");
				}
				System.err.println("16e");
				try {
				if((!mojtame.equals(""))|(!mojtame.equals(null))) {
				this.moblEntity.setMojtame(mojtame);
				System.err.println("16");
				}
				}catch (NullPointerException e) {
				System.err.println("mojtame null point");
				}
				System.err.println("17e");
				if(!birthDay.equals("")) {
				this.moblEntity.setBirthDate(this.mohlateEjareChangeDate(birthDay));
				System.err.println("17");
				}
				System.err.println("18e");
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
			this.tagdirName="";
			context.addMessage(null, new FacesMessage("با موفقیت آپدیت گردید."));
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	
	
	

}
