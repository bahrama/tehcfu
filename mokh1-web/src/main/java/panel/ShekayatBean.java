package panel;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.faces.view.ViewScoped;
import javax.imageio.ImageIO;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.ws.rs.PathParam;

import org.apache.commons.io.IOUtils;

import entity.Shekayat1;
import sevice.ShekayatServiceLocal;

@Named
@RequestScoped
public class ShekayatBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ShekayatBean() {
		// TODO Auto-generated constructor stub
	}

	@Inject
	private ShekayatServiceLocal shekayatServiceLocal;
	@Inject
	private TempBean tempBean;
	@Inject
	private FacesContext facesContext;

	HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
	@NotNull(message = "فیلد نباید خالی باشد")
	@NotEmpty(message = "فیلد نباید خالی باشد")
	@Size(max = 100, min = 2, message = "حداقل ۲ و حداکثر ۱۰۰")
	private String vahedeSenfiName;
	@NotNull(message = "فیلد نباید خالی باشد")
	@NotEmpty(message = "فیلد نباید خالی باشد")
	@Size(max = 100, min = 2, message = "حداقل ۲ و حداکثر ۱۰۰")
	private String motesadiName;
	@NotNull(message = "فیلد نباید خالی باشد")
	@NotEmpty(message = "فیلد نباید خالی باشد")
	@Size(max = 100, min = 2, message = "حداقل ۲ و حداکثر ۱۰۰")
	private String vahedeSenfiPhone;
	@NotNull(message = "فیلد نباید خالی باشد")
	@NotEmpty(message = "فیلد نباید خالی باشد")
	@Size(max = 100, min = 2, message = "حداقل ۲ و حداکثر ۱۰۰")
	private String vahedeSenfiMobile;
	@Size(max = 100, message = " حداکثر ۱۰۰")
	private String vahedeShenaseSenfi;
	@Size(max = 100, message = "حداکثر ۱۰۰")
	private String vahedeSenfiPostCode;
	@Size(max = 500, min = 2, message = "حداقل ۲ و حداکثر ۵۰۰")
	private String vahedeShenaseAddres;
	@NotNull(message = "فیلد نباید خالی باشد")
	@NotEmpty(message = "فیلد نباید خالی باشد")
	@Size(max = 500, min = 2, message = "حداقل ۲ و حداکثر ۱۰۰")
	private String shekayatTitle;
	@Size(max = 5000, min = 2, message = "حداقل ۲ و حداکثر ۵۰۰۰")
	private String sharh;
	@NotNull(message = "عکس فاکتور")
	private Part shakiFactor;
	@NotNull(message = "عکس کارت ملی")
	private Part shakiSsnPic;
	@NotNull(message = "عکس کالا")
	private Part shakiKalaPic;
	// after shekayat
	private String vaziat;
	private String karshenasName;
	private String karshenasi;
	private String tarikh;
	private long shomare;
	private boolean check;
	private byte[] loadPic;
	private String maraje;
	private List<String> marajes=new ArrayList<>();
	private boolean showButton = false;

	// admin
	private String shekayatAdmin;
	private String shekayatPass;

	private List<String> titleList = new ArrayList<>();

	private String shaikiDateHozor;
	private String shakiTimeHozor;
	private String shekayatShavandeMobile;
	private String shekayatShavandeDateHozor;
	private String shekayatShavandeTimeHozor;
	public byte[] getLoadPic() {
		return loadPic;
	}

	public void setLoadPic(byte[] loadPic) {
		this.loadPic = loadPic;
	}

	public String getVahedeSenfiName() {
		return vahedeSenfiName;
	}

	public void setVahedeSenfiName(String vahedeSenfiName) {
		this.vahedeSenfiName = vahedeSenfiName;
	}

	public String getMotesadiName() {
		return motesadiName;
	}

	public void setMotesadiName(String motesadiName) {
		this.motesadiName = motesadiName;
	}

	public String getVahedeSenfiMobile() {
		return vahedeSenfiMobile;
	}

	public void setVahedeSenfiMobile(String vahedeSenfiMobile) {
		this.vahedeSenfiMobile = vahedeSenfiMobile;
	}

	public String getVahedeShenaseSenfi() {
		return vahedeShenaseSenfi;
	}

	public void setVahedeShenaseSenfi(String vahedeShenaseSenfi) {
		this.vahedeShenaseSenfi = vahedeShenaseSenfi;
	}

	public String getVahedeShenaseAddres() {
		return vahedeShenaseAddres;
	}

	public void setVahedeShenaseAddres(String vahedeShenaseAddres) {
		this.vahedeShenaseAddres = vahedeShenaseAddres;
	}

	public String getShekayatTitle() {
		return shekayatTitle;
	}

	public void setShekayatTitle(String shekayatTitle) {
		this.shekayatTitle = shekayatTitle;
	}

	public String getSharh() {
		return sharh;
	}

	public void setSharh(String sharh) {
		this.sharh = sharh;
	}

	public Part getShakiFactor() {
		return shakiFactor;
	}

	public void setShakiFactor(Part shakiFactor) {
		this.shakiFactor = shakiFactor;
	}

	public String getVaziat() {
		return vaziat;
	}

	public void setVaziat(String vaziat) {
		this.vaziat = vaziat;
	}

	public String getShekayatAdmin() {
		return shekayatAdmin;
	}

	public void setShekayatAdmin(String shekayatAdmin) {
		this.shekayatAdmin = shekayatAdmin;
	}

	public String getShekayatPass() {
		return shekayatPass;
	}

	public void setShekayatPass(String shekayatPass) {
		this.shekayatPass = shekayatPass;
	}

	public ShekayatServiceLocal getShekayatServiceLocal() {
		return shekayatServiceLocal;
	}

	public void setShekayatServiceLocal(ShekayatServiceLocal shekayatServiceLocal) {
		this.shekayatServiceLocal = shekayatServiceLocal;
	}

	public String getVahedeSenfiPhone() {
		return vahedeSenfiPhone;
	}

	public void setVahedeSenfiPhone(String vahedeSenfiPhone) {
		this.vahedeSenfiPhone = vahedeSenfiPhone;
	}

	public String getVahedeSenfiPostCode() {
		return vahedeSenfiPostCode;
	}

	public void setVahedeSenfiPostCode(String vahedeSenfiPostCode) {
		this.vahedeSenfiPostCode = vahedeSenfiPostCode;
	}

	public boolean isShowButton() {
		return showButton;
	}

	public void setShowButton(boolean showButton) {
		this.showButton = showButton;
	}

	public List<String> getTitleList() {
		return titleList;
	}

	public void setTitleList(List<String> titleList) {
		this.titleList = titleList;
	}

	public String getTarikh() {
		return tarikh;
	}

	public void setTarikh(String tarikh) {
		this.tarikh = tarikh;
	}

	public long getShomare() {
		return shomare;
	}

	public void setShomare(long shomare) {
		this.shomare = shomare;
	}

	public boolean isCheck() {
		return check;
	}

	public void setCheck(boolean check) {
		this.check = check;
	}

	public String getKarshenasName() {
		return karshenasName;
	}

	public void setKarshenasName(String karshenasName) {
		this.karshenasName = karshenasName;
	}

	public String getKarshenasi() {
		return karshenasi;
	}

	public void setKarshenasi(String karshenasi) {
		this.karshenasi = karshenasi;
	}

	public Part getShakiSsnPic() {
		return shakiSsnPic;
	}

	public void setShakiSsnPic(Part shakiSsnPic) {
		this.shakiSsnPic = shakiSsnPic;
	}

	public Part getShakiKalaPic() {
		return shakiKalaPic;
	}

	public void setShakiKalaPic(Part shakiKalaPic) {
		this.shakiKalaPic = shakiKalaPic;
	}

	public String getShaikiDateHozor() {
		return shaikiDateHozor;
	}

	public void setShaikiDateHozor(String shaikiDateHozor) {
		this.shaikiDateHozor = shaikiDateHozor;
	}

	public String getShakiTimeHozor() {
		return shakiTimeHozor;
	}

	public void setShakiTimeHozor(String shakiTimeHozor) {
		this.shakiTimeHozor = shakiTimeHozor;
	}
	
	

	public List<String> getMarajes() {
		return marajes;
	}

	public void setMarajes(List<String> marajes) {
		this.marajes = marajes;
	}

	public String getMaraje() {
		return maraje;
	}

	public void setMaraje(String maraje) {
		this.maraje = maraje;
	}

	public String getShekayatShavandeMobile() {
		return shekayatShavandeMobile;
	}

	public void setShekayatShavandeMobile(String shekayatShavandeMobile) {
		this.shekayatShavandeMobile = shekayatShavandeMobile;
	}

	public String getShekayatShavandeDateHozor() {
		return shekayatShavandeDateHozor;
	}

	public void setShekayatShavandeDateHozor(String shekayatShavandeDateHozor) {
		this.shekayatShavandeDateHozor = shekayatShavandeDateHozor;
	}

	public String getShekayatShavandeTimeHozor() {
		return shekayatShavandeTimeHozor;
	}

	public void setShekayatShavandeTimeHozor(String shekayatShavandeTimeHozor) {
		this.shekayatShavandeTimeHozor = shekayatShavandeTimeHozor;
	}

	@PostConstruct
	public void init() {
		titleList.add("گرانفروشی");
		titleList.add("تقلب");
		titleList.add("عدم درج قیمت و نصب نرخنامه");
		titleList.add("عدم صدور صورت حساب");
		titleList.add("نداشتن پروانه کسب");
		titleList.add("عدم انجام خدمات پس از فروش در دوره ضمانت");
	}

	public void goToPageHome() throws IOException {
		FacesContext.getCurrentInstance().getExternalContext().redirect("home.xhtml");
	}
	

	public void sendSmsHozorShaki(long shakiID) {
			FacesContext context = FacesContext.getCurrentInstance();
		try {
				Shekayat1 shekayat1 = new Shekayat1();
				shekayat1 = shekayatServiceLocal.findShekayatById(shakiID);
			String mobile=shekayat1.getShaki().getMobile();
			shekayat1.setShakiDateHozor(this.shaikiDateHozor);
			shekayat1.setShakiTimeHozor(shakiTimeHozor);
			shekayatServiceLocal.shekayatUpdate(shekayat1);
			URL url2 = new URL(
			"https://www.saharsms.com/api/gONhkiXUT8sBU1yUJUAQPAqOYlcIOho4/json/SendVerify?receptor=" + mobile +"&template=successSHH-16147&token=" + this.shaikiDateHozor + "&token2="+this.shakiTimeHozor);
	HttpURLConnection httpURLConnection2 = (HttpURLConnection) url2.openConnection();
	System.out.println(httpURLConnection2.getResponseMessage());
	httpURLConnection2.disconnect();
	context.addMessage(null, new FacesMessage("با موفقیت پیامک ارسال شد."));
	}catch (Exception e) {
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "خطا", "Error login"));
	}
	}
	

	public void sendSmsHozorShekayatShavande() {
			FacesContext context = FacesContext.getCurrentInstance();
		try {

			URL url2 = new URL(
			"https://www.saharsms.com/api/gONhkiXUT8sBU1yUJUAQPAqOYlcIOho4/json/SendVerify?receptor=" + this.shekayatShavandeMobile +"&template=successSHHH-16147&token=" + this.shekayatShavandeDateHozor + "&token2="+this.shekayatShavandeTimeHozor);
	HttpURLConnection httpURLConnection2 = (HttpURLConnection) url2.openConnection();
	System.out.println(httpURLConnection2.getResponseMessage());
	httpURLConnection2.disconnect();
	context.addMessage(null, new FacesMessage("با موفقیت پیامک ارسال شد."));
	}catch (Exception e) {
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "خطا", "Error login"));
	}
	}
	
	private String faaliatHa() {
		String item="";
		for (String string : this.marajes) {
			item=item +string + "-";
		}
		return item;
	}

	public void inserToShekayat() {
		try {
			Random random = new Random();
			int code = random.nextInt(999999999);
			Shekayat1 shekayat1 = new Shekayat1();
			shekayat1.setMotesadiName(motesadiName);
			shekayat1.setSharh(sharh);
			shekayat1.setDate(new Date());
			shekayat1.setShekayatTitle(shekayatTitle);
			shekayat1.setVahedeSenfiMobile(vahedeSenfiMobile);
			shekayat1.setVahedeSenfiName(vahedeSenfiName);
			shekayat1.setVahedeSenfiPhone(vahedeSenfiPhone);
			shekayat1.setVahedeSenfiPostCode(vahedeSenfiPostCode);
			shekayat1.setVahedeShenaseAddres(vahedeShenaseAddres);
			shekayat1.setVahedeShenaseSenfi(vahedeShenaseSenfi);
			shekayat1.setShomare(code);
			shekayat1.setMaraje(faaliatHa());
			shekayat1.setPicPath(picture());
			shekayat1.setShakiSsnPic(picture2());
			shekayat1.setShakiKalaPic(picture3());
			shekayat1.setShaki(tempBean.getMoblEntity());
			shekayatServiceLocal.inserToShekayat(shekayat1);
			this.showButton = true;
			this.motesadiName = "";
			this.sharh = "";
			this.shekayatAdmin = "";
			this.shekayatPass = "";
			this.shekayatTitle = "";
			this.vahedeSenfiMobile = "";
			this.vahedeSenfiName = "";
			this.vahedeSenfiPhone = "";
			this.vahedeSenfiPostCode = "";
			this.vahedeShenaseAddres = "";
			this.vahedeShenaseSenfi = "";
			this.vaziat = "";
			URL url2 = new URL("https://www.saharsms.com/api/gONhkiXUT8sBU1yUJUAQPAqOYlcIOho4/json/SendVerify?receptor="
					+ tempBean.getMoblEntity().getMobile() + "&template=successSH-16147&token=" + code);
			HttpURLConnection httpURLConnection2 = (HttpURLConnection) url2.openConnection();
			System.out.println(httpURLConnection2.getResponseMessage());
			httpURLConnection2.disconnect();
			facesContext.getPartialViewContext().getEvalScripts().add(
					"swal({title: 'موفق!',type: 'success', text: 'در اسرع وقت به شکایت شما رسیدگی میشود', confirmButtonColor: '#469408',})");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void listenTest() {
		facesContext.getPartialViewContext().getEvalScripts().add(
				"swal({title: 'موفق!',type: 'success', text: 'در اسرع وقت به شکایت شما رسیدگی میشود', confirmButtonColor: '#469408',})");
	}

	public String picture() throws Exception {
		try {
			UUID uuid = UUID.randomUUID();
			byte[] image1Byte = IOUtils.toByteArray(shakiFactor.getInputStream());
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
			UUID uuid = UUID.randomUUID();
			byte[] image1Byte = IOUtils.toByteArray(shakiSsnPic.getInputStream());
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
			UUID uuid = UUID.randomUUID();
			byte[] image1Byte = IOUtils.toByteArray(shakiKalaPic.getInputStream());
			File out3 = new File("/home/wildfly/AX/" + uuid + ".jpg");
			InputStream in = new ByteArrayInputStream(image1Byte);
			BufferedImage img3 = ImageIO.read(in);
			ImageIO.write(img3, "jpg", out3);
			return uuid.toString();
		} catch (IOException e) {

			throw new Exception("error image entering 1");
		}

	}

	public List<Shekayat1> findAllShekayat() {

		// return singletonServiceLocal.getShekayat1s();
		return shekayatServiceLocal.findAllShekayat();
	}

	public List<Shekayat1> findAllShekayatOrder() {
		// return singletonServiceLocal.getShekayat1s2();
		return shekayatServiceLocal.findAllShekayatOrder();
	}

	public Shekayat1 findShekayatById(long shakiId) throws IOException {
		Shekayat1 shekayat1;
		try {
			shekayat1 = shekayatServiceLocal.findShekayatById(shakiId);
			File imageFile = new File(shekayat1.getPicPath());
			BufferedImage image = ImageIO.read(imageFile);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ImageIO.write(image, "jpg", baos);
			this.loadPic = baos.toByteArray();
			return shekayat1;
		} catch (Exception e) {
			return null;
		}

	}

	public Shekayat1 findShekayatById2(long shakiId) {
		try {
			return shekayatServiceLocal.findShekayatById(shakiId);
		} catch (Exception e) {
			return null;
		}
	}

	public void shekayatUpdate(long shakiId) {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			Shekayat1 shekayat1 = new Shekayat1();
			shekayat1 = shekayatServiceLocal.findShekayatById(shakiId);
			shekayat1.setVaziat(vaziat);
			shekayat1.setCheckO(true);
			shekayat1.setShomare(shomare);
			shekayat1.setTarikh(tarikh);
			shekayatServiceLocal.shekayatUpdate(shekayat1);
			context.addMessage(null, new FacesMessage("با موفقیت ثبت گردید."));
			this.showButton = true;
		} catch (Exception e) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "خطا", "Error login"));
		}
	}

	public void shekayatBaresi(long shakiId) {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			Shekayat1 shekayat1 = new Shekayat1();
			shekayat1 = shekayatServiceLocal.findShekayatById(shakiId);
			// shekayat1.setVaziat(vaziat);
			// shekayat1.setCheckO(true);
			shekayat1.setKarshenasDate(new Date());
			shekayat1.setKarshenasi(karshenasi);
			shekayat1.setKarshenasName(karshenasName);
			shekayatServiceLocal.shekayatUpdate(shekayat1);
			context.addMessage(null, new FacesMessage("با موفقیت ثبت گردید."));
		} catch (Exception e) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "خطا", "Error login"));
		}
	}

	public void enterAdmin() {
		FacesContext contex = FacesContext.getCurrentInstance();
		if (this.shekayatAdmin.equals("user1") && (this.shekayatPass.equals("1234"))) {
			session.setAttribute("user1", this.shekayatAdmin);
			session.setAttribute("pass", this.shekayatPass);
			contex.getApplication().getNavigationHandler().handleNavigation(contex, null, "/shekayatview.xhtml");
		} else {
			contex.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "خطا", "Error login"));
		}
	}

	public void exitAdmin() {
		FacesContext contex = FacesContext.getCurrentInstance();
		session.setAttribute("user1", null);
		session.setAttribute("pass", null);
		contex.getApplication().getNavigationHandler().handleNavigation(contex, null, "/shekayatlogin.xhtml");
	}

	public void isUser(ComponentSystemEvent event) {
		FacesContext contex = FacesContext.getCurrentInstance();
		try {
			String shekayatAdmin = (String) session.getAttribute("user1");
			String shekayatPass = (String) session.getAttribute("pass");
			if ((shekayatAdmin.equals("user1")) && (shekayatPass.equals("1234")))
				System.out.println("******************ok******************");

			else if (shekayatAdmin.equals(null))
				contex.getApplication().getNavigationHandler().handleNavigation(contex, null, "/shekayatlogin.xhtml");
		} catch (Exception e) {
			contex.getApplication().getNavigationHandler().handleNavigation(contex, null, "/shekayatlogin.xhtml");
		}
	}

	public void sendSmsOk(String mobile, String token1, String token2) {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			URL url = new URL("https://www.saharsms.com/api/gONhkiXUT8sBU1yUJUAQPAqOYlcIOho4/json/SendVerify?receptor="
					+ mobile + "&template=16147-submit&token=" + token1 + "&token2=" + token2 + "&token3=8-14");
			HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
			System.out.println(httpURLConnection.getResponseMessage());
			httpURLConnection.disconnect();
			context.addMessage(null, new FacesMessage("پیامک حضور شخص با موفقیت ارسال شد"));
		} catch (IOException e) {
			context.addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "خطای ارسال پیامک", "خطای ارسال پیامک"));
		}

	}

	public void sendSmsNok(String mobile) {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			URL url = new URL("https://www.saharsms.com/api/gONhkiXUT8sBU1yUJUAQPAqOYlcIOho4/json/SendVerify?receptor="
					+ mobile + "&template=16147-subject&token=end");
			System.err.println("https://www.saharsms.com/api/gONhkiXUT8sBU1yUJUAQPAqOYlcIOho4/json/SendVerify?receptor="
					+ mobile + "&template=16147-subject&token=end");
			HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
			System.out.println(httpURLConnection.getResponseMessage());
			httpURLConnection.disconnect();
			context.addMessage(null, new FacesMessage("پیامک عدم ارتباط با اتحادیه با موفقیت ارسال شد"));
		} catch (IOException e) {
			context.addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "خطای ارسال پیامک", "خطای ارسال پیامک"));
		}

	}

	public void deleteShekayatEntity(long shakiId) throws IOException {
		FacesContext contex = FacesContext.getCurrentInstance();
		Shekayat1 shekayat1 = new Shekayat1();
		shekayat1 = this.findShekayatById2(shakiId);
		shekayatServiceLocal.deleteShekayatEntity(shekayat1);
		contex.getExternalContext().redirect("shekayatview.xhtml");
	}

	public void updateVahedeSenfiMobile(long shakiId) throws IOException {
		FacesContext contex = FacesContext.getCurrentInstance();
		Shekayat1 shekayat1 = new Shekayat1();
		shekayat1 = this.findShekayatById2(shakiId);
		shekayat1.setVahedeSenfiMobile(vahedeSenfiMobile);
		shekayatServiceLocal.shekayatUpdate(shekayat1);
		contex.getExternalContext().redirect("shekayatedit.xhtml?shakiId=" + shakiId);
	}

	public void updateVahedeSenfiName(long shakiId) throws IOException {
		FacesContext contex = FacesContext.getCurrentInstance();
		Shekayat1 shekayat1 = new Shekayat1();
		shekayat1 = this.findShekayatById2(shakiId);
		shekayat1.setVahedeSenfiName(vahedeSenfiName);
		shekayatServiceLocal.shekayatUpdate(shekayat1);
		contex.getExternalContext().redirect("shekayatedit.xhtml?shakiId=" + shakiId);
	}

	public void updateMotesadiName(long shakiId) throws IOException {
		FacesContext contex = FacesContext.getCurrentInstance();
		Shekayat1 shekayat1 = new Shekayat1();
		shekayat1 = this.findShekayatById2(shakiId);
		shekayat1.setMotesadiName(motesadiName);
		shekayatServiceLocal.shekayatUpdate(shekayat1);
		contex.getExternalContext().redirect("shekayatedit.xhtml?shakiId=" + shakiId);
	}

	public void updateVahedeSenfiPhone(long shakiId) throws IOException {
		FacesContext contex = FacesContext.getCurrentInstance();
		Shekayat1 shekayat1 = new Shekayat1();
		shekayat1 = this.findShekayatById2(shakiId);
		shekayat1.setVahedeSenfiPhone(vahedeSenfiPhone);
		shekayatServiceLocal.shekayatUpdate(shekayat1);
		contex.getExternalContext().redirect("shekayatedit.xhtml?shakiId=" + shakiId);
	}

	public void updateShenaseSenfi(long shakiId) throws IOException {
		FacesContext contex = FacesContext.getCurrentInstance();
		Shekayat1 shekayat1 = new Shekayat1();
		shekayat1 = this.findShekayatById2(shakiId);
		shekayat1.setVahedeShenaseSenfi(vahedeShenaseSenfi);
		shekayatServiceLocal.shekayatUpdate(shekayat1);
		contex.getExternalContext().redirect("shekayatedit.xhtml?shakiId=" + shakiId);
	}

	public void updateVahedeSenfiPostCode(long shakiId) throws IOException {
		FacesContext contex = FacesContext.getCurrentInstance();
		Shekayat1 shekayat1 = new Shekayat1();
		shekayat1 = this.findShekayatById2(shakiId);
		shekayat1.setVahedeSenfiPostCode(vahedeSenfiPostCode);
		shekayatServiceLocal.shekayatUpdate(shekayat1);
		contex.getExternalContext().redirect("shekayatedit.xhtml?shakiId=" + shakiId);
	}

	public void updateVahedeSenfiAddres(long shakiId) throws IOException {
		FacesContext contex = FacesContext.getCurrentInstance();
		Shekayat1 shekayat1 = new Shekayat1();
		shekayat1 = this.findShekayatById2(shakiId);
		shekayat1.setVahedeShenaseAddres(vahedeShenaseAddres);
		shekayatServiceLocal.shekayatUpdate(shekayat1);
		contex.getExternalContext().redirect("shekayatedit.xhtml?shakiId=" + shakiId);
	}

	public void updateVahedeSenfiSharh(long shakiId) throws IOException {
		FacesContext contex = FacesContext.getCurrentInstance();
		Shekayat1 shekayat1 = new Shekayat1();
		shekayat1 = this.findShekayatById2(shakiId);
		shekayat1.setSharh(sharh);
		shekayatServiceLocal.shekayatUpdate(shekayat1);
		contex.getExternalContext().redirect("shekayatedit.xhtml?shakiId=" + shakiId);
	}

	public void test() {
		System.err.println("OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");
		System.err.println(tempBean.getMoblEntity().getMobile());
		System.err.println("OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");
	}

	public void testJS() {
		facesContext.getPartialViewContext().getEvalScripts().add(
				"swal({title: 'good job!',type: 'success', text: 'Lorem ipsum dolor sit amet', confirmButtonColor: '#469408',})");
	}

	public String convertToJalali(long shakiId) {
		try {
			Shekayat1 shekayat1 = new Shekayat1();
			shekayat1 = this.findShekayatById(shakiId);
			String dateEng = shekayat1.getDate().toString();
			char[] mnth = new char[3];
			dateEng.getChars(4, 7, mnth, 0);
			String month = "";
			for (char c : mnth) {
				month += c;
			}
			System.err.println(month);
			int month1 = 0;
			if (month.equals("Jan"))
				month1 = 1;
			else if (month.equals("Feb"))
				month1 = 2;
			else if (month.equals("Mar"))
				month1 = 3;
			else if (month.equals("Apr"))
				month1 = 4;
			else if (month.equals("May"))
				month1 = 5;
			else if (month.equals("Jun"))
				month1 = 6;
			else if (month.equals("Jul"))
				month1 = 7;
			else if (month.equals("Aug"))
				month1 = 8;
			else if (month.equals("Sep"))
				month1 = 9;
			else if (month.equals("Oct"))
				month1 = 10;
			else if (month.equals("Nov"))
				month1 = 11;
			else if (month.equals("Dec"))
				month1 = 12;

			char[] dy = new char[2];
			dateEng.getChars(8, 10, dy, 0);
			String day = "";
			for (char c : dy) {
				day += c;
			}

			int day1 = Integer.parseInt(day);

			char[] yer = new char[4];
			dateEng.getChars(25, 29, yer, 0);
			String year = "";
			for (char c : yer) {
				year += c;
			}
			int year1 = Integer.parseInt(year);
			return gregorian_to_jalali(year1, month1, day1);
		} catch (Exception e) {
			return null;
		}

	}

	public byte[] findPic(long id) throws IOException {

		System.err.println("UUUUIIIIIIIIIUUUUUUUUIIIIIIIIIII" + this.findShekayatById2(id).getPicPath());
		File imageFile1 = new File("/home/wildfly/AX/" + this.findShekayatById2(id).getPicPath() + ".jpg");
		BufferedImage image1 = ImageIO.read(imageFile1);
		ByteArrayOutputStream baos1 = new ByteArrayOutputStream();
		ImageIO.write(image1, "jpg", baos1);
		return baos1.toByteArray();

	}

	public byte[] findPic2(long id) throws IOException {

		System.err.println("UUUUIIIIIIIIIUUUUUUUUIIIIIIIIIII" + this.findShekayatById2(id).getShakiSsnPic());
		File imageFile1 = new File("/home/wildfly/AX/" + this.findShekayatById2(id).getShakiSsnPic() + ".jpg");
		BufferedImage image1 = ImageIO.read(imageFile1);
		ByteArrayOutputStream baos1 = new ByteArrayOutputStream();
		ImageIO.write(image1, "jpg", baos1);
		return baos1.toByteArray();

	}

	public byte[] findPic3(long id) throws IOException {

		System.err.println("UUUUIIIIIIIIIUUUUUUUUIIIIIIIIIII" + this.findShekayatById2(id).getShakiKalaPic());
		File imageFile1 = new File("/home/wildfly/AX/" + this.findShekayatById2(id).getShakiKalaPic() + ".jpg");
		BufferedImage image1 = ImageIO.read(imageFile1);
		ByteArrayOutputStream baos1 = new ByteArrayOutputStream();
		ImageIO.write(image1, "jpg", baos1);
		return baos1.toByteArray();

	}

	private String gregorian_to_jalali(int gy, int gm, int gd) {
		String text2 = "";
		int[] g_d_m = { 0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334 };
		int jy;
		if (gy > 1600) {
			jy = 979;
			gy -= 1600;
		} else {
			jy = 0;
			gy -= 621;
		}
		int gy2 = (gm > 2) ? (gy + 1) : gy;
		int days = (365 * gy) + ((int) ((gy2 + 3) / 4)) - ((int) ((gy2 + 99) / 100)) + ((int) ((gy2 + 399) / 400)) - 80
				+ gd + g_d_m[gm - 1];
		jy += 33 * ((int) (days / 12053));
		days %= 12053;
		jy += 4 * ((int) (days / 1461));
		days %= 1461;
		if (days > 365) {
			jy += (int) ((days - 1) / 365);
			days = (days - 1) % 365;
		}
		int jm = (days < 186) ? 1 + (int) (days / 31) : 7 + (int) ((days - 186) / 30);
		int jd = 1 + ((days < 186) ? (days % 31) : ((days - 186) % 30));
		int[] out = { jy, jm, jd };
		// return out;
		// return null;
		// return jy + "-" + jm + "-" + jd;

		String month1 = "";
		if (jm == 1)
			month1 = "فروردین";
		else if (jm == 2)
			month1 = "اردیبهشت";
		else if (jm == 3)
			month1 = "خرداد";
		else if (jm == 4)
			month1 = "تیر";
		else if (jm == 5)
			month1 = "مرداد";
		else if (jm == 6)
			month1 = "شهریور";
		else if (jm == 7)
			month1 = "مهر";
		else if (jm == 8)
			month1 = "آبان";
		else if (jm == 9)
			month1 = "آذر";
		else if (jm == 10)
			month1 = "دی";
		else if (jm == 11)
			month1 = "بهمن";
		else if (jm == 12)
			month1 = "اسفند";
		text2 = jd + " / " + jm + " / " + jy;
		return text2;
	}

	public String findPersianDate(Date date) {
		try {
			String dateEng = date.toString();
			char[] mnth = new char[3];
			dateEng.getChars(4, 7, mnth, 0);
			String month = "";
			for (char c : mnth) {
				month += c;
			}
			System.err.println(month);
			int month1 = 0;
			if (month.equals("Jan"))
				month1 = 1;
			else if (month.equals("Feb"))
				month1 = 2;
			else if (month.equals("Mar"))
				month1 = 3;
			else if (month.equals("Apr"))
				month1 = 4;
			else if (month.equals("May"))
				month1 = 5;
			else if (month.equals("Jun"))
				month1 = 6;
			else if (month.equals("Jul"))
				month1 = 7;
			else if (month.equals("Aug"))
				month1 = 8;
			else if (month.equals("Sep"))
				month1 = 9;
			else if (month.equals("Oct"))
				month1 = 10;
			else if (month.equals("Nov"))
				month1 = 11;
			else if (month.equals("Dec"))
				month1 = 12;

			char[] dy = new char[2];
			dateEng.getChars(8, 10, dy, 0);
			String day = "";
			for (char c : dy) {
				day += c;
			}

			int day1 = Integer.parseInt(day);

			char[] yer = new char[4];
			dateEng.getChars(25, 29, yer, 0);
			String year = "";
			for (char c : yer) {
				year += c;
			}
			int year1 = Integer.parseInt(year);
			return gregorian_to_jalali(year1, month1, day1);
		} catch (Exception e) {
			return null;
		}

	}
}
