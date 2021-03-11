package admin;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.UUID;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.imageio.ImageIO;
import javax.inject.Inject;
import javax.inject.Named;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.servlet.http.Part;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.apache.commons.io.IOUtils;

import catch_db.CatchBlogLocal;
import entity.BlogEntity;
import entity.MoblEntity;
import enums.UserRole;
import sevice.SellerServiceLocal;

@Named
@RequestScoped
public class AddSeller {

	public AddSeller() {
		// TODO Auto-generated constructor stub
	}
	@Inject
	private SellerServiceLocal sellerServiceLocal;  
	private List<BlogEntity> blogEntities = new ArrayList<>();
	
	@Size(max=100 , message="max size is 100")
	@NotNull
	@NotEmpty
	private String sellerName;
	@Size(max=30 , message="max size is 30")
	@NotNull
	@NotEmpty
	private String sellerStoreNamePer;
	@Size(max=30 , message="max size is 30")
	@NotNull
	@NotEmpty
	private String sellerStoreNameEng;
	@Size(max=7000 , message="max size is 7000")
	private String aboutUs;
	@Size(max=30 , message="max size is 30")
	private String instagram;
	@Size(max=30 , message="max size is 30")
	private String telegram;
	@Size(max=50 , message="max size is 50")
	private String phone;
	@Size(max=30 , message="max size is 30")
	private String website;
	@Size(max=30 , message="max size is 30")
	private String email;
	@Size(max=50 , message="max size is 50")
	private String fax;
	@Size(max=100 , message="max size is 100")	
	private String modirForoshName;
	@Size(max=50 , message="max size is 50")
	private String modirForoshPhone;
	@Size(max=10 , message="max size is 10")
	private String postCode;
	@Size(max=200 , message="max size is 200")	
	private String addres;
	@Size(max=200 , message="max size is 200")	
	private String vage;
	private String lat;
	private String lng;
	private Part sellerPic1;
	private Part sellerPic2;
	private Part sellerPic3;
	private Part sellerPic4;
	private Part sellerPic5;
	private String panel;
	private String noeFaaliat;
	private String faaliat;
	private List<String> faaliats=new ArrayList<String>();
	@Pattern(regexp="09\\d{9}" , message="شماره وارده اشتباه می باشد")
	@NotNull
	@NotEmpty
	private String mobile;
	@Size(max=10 , message="max size is 10")
	@NotNull
	@NotEmpty
	private String ssn;
	
	private String tagdir;
///////////////////////////////////////////////
private String malekiat;
@Inject
private CatchBlogLocal catchBlogLocal;
	private String sabteSefaresh;
	private String mostajer;
	private String mohlateEjare;
	private String mostajerName;
	private String mostajerBirthday;
	private String mostajerSsn;	
	private String mostajerMobile;
	private String shomareJavaz;
	private String tarikhEtebar;
	private String hasMobasher;
	private String mobasherName;
	private String rabetName;
	private String sematRabet;	
	private String rabetMobile;
	private String shabakeMazajiMobile;
	private String mojtame;
	private String birthDay;
	
	
	
	
	public List<BlogEntity> getBlogEntities() {
		return blogEntities;
	}
	public void setBlogEntities(List<BlogEntity> blogEntities) {
		this.blogEntities = blogEntities;
	}
	public String getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}
	public String getSellerName() {
		return sellerName;
	}
	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public String getAboutUs() {
		return aboutUs;
	}
	public void setAboutUs(String aboutUs) {
		this.aboutUs = aboutUs;
	}
	public String getInstagram() {
		return instagram;
	}
	public void setInstagram(String instagram) {
		this.instagram = instagram;
	}
	public String getTelegram() {
		return telegram;
	}
	public void setTelegram(String telegram) {
		this.telegram = telegram;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
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
	public String getModirForoshName() {
		return modirForoshName;
	}
	public void setModirForoshName(String modirForoshName) {
		this.modirForoshName = modirForoshName;
	}
	public String getModirForoshPhone() {
		return modirForoshPhone;
	}
	public void setModirForoshPhone(String modirForoshPhone) {
		this.modirForoshPhone = modirForoshPhone;
	}
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	public String getAddres() {
		return addres;
	}
	public void setAddres(String addres) {
		this.addres = addres;
	}

	
	
	public String getMohlateEjare() {
		return mohlateEjare;
	}
	public void setMohlateEjare(String mohlateEjare) {
		this.mohlateEjare = mohlateEjare;
	}
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getLng() {
		return lng;
	}
	public void setLng(String lng) {
		this.lng = lng;
	}
	public Part getSellerPic1() {
		return sellerPic1;
	}
	public void setSellerPic1(Part sellerPic1) {
		this.sellerPic1 = sellerPic1;
	}
	public Part getSellerPic2() {
		return sellerPic2;
	}
	public void setSellerPic2(Part sellerPic2) {
		this.sellerPic2 = sellerPic2;
	}
	public Part getSellerPic3() {
		return sellerPic3;
	}
	public void setSellerPic3(Part sellerPic3) {
		this.sellerPic3 = sellerPic3;
	}
	public String getSellerStoreNamePer() {
		return sellerStoreNamePer;
	}
	public void setSellerStoreNamePer(String sellerStoreNamePer) {
		this.sellerStoreNamePer = sellerStoreNamePer;
	}
	public String getSellerStoreNameEng() {
		return sellerStoreNameEng;
	}
	public void setSellerStoreNameEng(String sellerStoreNameEng) {
		this.sellerStoreNameEng = sellerStoreNameEng;
	}

	public Part getSellerPic4() {
		return sellerPic4;
	}
	public void setSellerPic4(Part sellerPic4) {
		this.sellerPic4 = sellerPic4;
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
	
	
	
	
	public String getFaaliat() {
		return faaliat;
	}
	public void setFaaliat(String faaliat) {
		this.faaliat = faaliat;
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
	
	public String getTagdir() {
		return tagdir;
	}
	public void setTagdir(String tagdir) {
		this.tagdir = tagdir;
	}
	
	private String faaliatHa() {
		String item="";
		for (String string : this.faaliats) {
			item=item +string + "-";
		}
		return item;
	}
	
	
	public String getVage() {
		return vage;
	}
	public void setVage(String vage) {
		this.vage = vage;
	}

	public SellerServiceLocal getSellerServiceLocal() {
		return sellerServiceLocal;
	}
	public void setSellerServiceLocal(SellerServiceLocal sellerServiceLocal) {
		this.sellerServiceLocal = sellerServiceLocal;
	}
	public String getMalekiat() {
		return malekiat;
	}
	public void setMalekiat(String malekiat) {
		this.malekiat = malekiat;
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
	
	public Part getSellerPic5() {
		return sellerPic5;
	}
	public void setSellerPic5(Part sellerPic5) {
		this.sellerPic5 = sellerPic5;
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
	
	
	
	
	
	
	
	
	
	public void insertSeller() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {	
		MoblEntity moblEntity=new MoblEntity();
		moblEntity.setAboutUs(aboutUs);
		moblEntity.setEmail(email);
		moblEntity.setFax(fax);
		moblEntity.setInstagram(instagram);
		moblEntity.setLat(Double.parseDouble(lat));
		moblEntity.setLng(Double.parseDouble(lng));
		moblEntity.setModirforoshName(modirForoshName);
		moblEntity.setModirforoshPhone(modirForoshPhone);
		moblEntity.setPhone(phone);
		moblEntity.setPostcode(postCode);
		moblEntity.setSellerAddres(addres);
		moblEntity.setSellerName(sellerName);
		moblEntity.setSellerStoreEng(sellerStoreNameEng);
		moblEntity.setSellerStorePer(sellerStoreNamePer);
		moblEntity.setTelegram(telegram);
		moblEntity.setWebsite(website);
		moblEntity.setNoeFaaliat(noeFaaliat);
		moblEntity.setPanel(panel);
		moblEntity.setSsn(ssn);
		moblEntity.setMobile(mobile);
		moblEntity.setVage(vage);
		moblEntity.setFaaliat(this.faaliatHa());
		moblEntity.setRole(UserRole.MERCHANT);
		moblEntity.setPic1(this.picture1());
		moblEntity.setPic2(this.picture2());
		moblEntity.setPic3(this.picture3());
		moblEntity.setPic4(this.picture4());
		moblEntity.setPic5(this.picture5());
		moblEntity.setTagdirName(this.convertTagdir());
		/////////////////////////////////////////////////////
		moblEntity.setMalekiat(malekiat);
		moblEntity.setSabteSefaresh(sabteSefaresh);
		moblEntity.setMostajer(Boolean.parseBoolean(mostajer));
		moblEntity.setMohlateEjare(this.mohlateEjareChangeDate(mohlateEjare));
		moblEntity.setMostajerName(mostajerName);
		moblEntity.setMostajerBirthday(this.mohlateEjareChangeDate(mostajerBirthday));
		moblEntity.setMostajerSsn(mostajerSsn);
		moblEntity.setMostajerMobile(mostajerMobile);
		moblEntity.setShomareJavaz(shomareJavaz);
		moblEntity.setTarikhEtebar(this.mohlateEjareChangeDate(tarikhEtebar));
		moblEntity.setHasMobasher(Boolean.parseBoolean(hasMobasher));
		moblEntity.setMobasherName(mobasherName);
		moblEntity.setRabetName(rabetName);
		moblEntity.setSematRabet(sematRabet);
		moblEntity.setRabetMobile(rabetMobile);
		moblEntity.setShabakeMazajiMobile(shabakeMazajiMobile);
		moblEntity.setBirthDate(this.mohlateEjareChangeDate(birthDay));
		sellerServiceLocal.insertSeller(moblEntity);
		context.addMessage(null, new FacesMessage("*****************************با موفقیت وارد گردید************************"));
		this.aboutUs="";
		this.addres="";
		this.email="";
		this.fax="";
		this.instagram="";
		this.lat="";
		this.lng="";
		this.mobile="";
		this.modirForoshName="";
		this.modirForoshPhone="";
		this.noeFaaliat="";
		this.panel="";
		this.phone="";
		this.postCode="";
		this.sellerName="";
		this.ssn="";
		this.vage="";
		this.telegram="";
		this.website="";
		this.sellerStoreNamePer="";
		this.sellerStoreNameEng="";
		}
		catch(Exception e) {
			e.printStackTrace();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "این کاربر در سیستم وجود دارد", "این کاربر در سیستم وجود دارد"));
		}
		}
	
	public String picture1() throws Exception {
		try {
			UUID uuid=UUID.randomUUID();
			byte[] image1Byte = IOUtils.toByteArray(sellerPic1.getInputStream());
			File out3 = new File("/home/wildfly/AX/" + uuid + ".jpg");
			InputStream in = new ByteArrayInputStream(image1Byte);
			BufferedImage img3 = ImageIO.read(in);
			ImageIO.write(img3, "jpg", out3);
			return uuid.toString();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			throw new Exception("error image entering 1");
		}
		
	}
	
	public String picture2() throws Exception {
		try {
			UUID uuid=UUID.randomUUID();
			byte[] image1Byte = IOUtils.toByteArray(sellerPic2.getInputStream());
			File out3 = new File("/home/wildfly/AX/" + uuid + ".jpg");
			InputStream in = new ByteArrayInputStream(image1Byte);
			BufferedImage img3 = ImageIO.read(in);
			ImageIO.write(img3, "jpg", out3);
			return uuid.toString();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			throw new Exception("error image entering 2");
		}
	}
	
	public String picture3() throws Exception {
		try {
			UUID uuid=UUID.randomUUID();
			byte[] image1Byte = IOUtils.toByteArray(sellerPic3.getInputStream());
			File out3 = new File("/home/wildfly/AX/" + uuid + ".jpg");
			InputStream in = new ByteArrayInputStream(image1Byte);
			BufferedImage img3 = ImageIO.read(in);
			ImageIO.write(img3, "jpg", out3);
			return uuid.toString();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			throw new Exception("error image entering 3");
		}
	}
	
	public String picture4() throws Exception {
		try {
			UUID uuid=UUID.randomUUID();
			byte[] image1Byte = IOUtils.toByteArray(sellerPic4.getInputStream());
			File out3 = new File("/home/wildfly/AX/" + uuid + ".jpg");
			InputStream in = new ByteArrayInputStream(image1Byte);
			BufferedImage img3 = ImageIO.read(in);
			ImageIO.write(img3, "jpg", out3);
			return uuid.toString();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			throw new Exception("error image entering 3");
		}
	}
	public String picture5() throws Exception {
		try {
			UUID uuid=UUID.randomUUID();
			byte[] image1Byte = IOUtils.toByteArray(sellerPic5.getInputStream());
			File out3 = new File("/home/wildfly/AX/" + uuid + ".jpg");
			InputStream in = new ByteArrayInputStream(image1Byte);
			BufferedImage img3 = ImageIO.read(in);
			ImageIO.write(img3, "jpg", out3);
			return uuid.toString();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			throw new Exception("error image entering 3");
		}
	}
	
	public String convertTagdir(){
		try {
		UUID uuid=UUID.randomUUID();
		byte[] blog = this.tagdir.getBytes(StandardCharsets.UTF_8);
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
	
	public List<BlogEntity> findAllPassage() {

        blogEntities.clear();
		for (BlogEntity blogEntity : catchBlogLocal.getBlogEntities()) {
			if (blogEntity.getBlogType().equals("مجتمع تجاری")) {
				blogEntities.add(blogEntity);
				}
		}
		return blogEntities;
		}
	

}
