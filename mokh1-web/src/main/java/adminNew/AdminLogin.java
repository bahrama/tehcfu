package adminNew;

import java.io.IOException;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;
import java.util.UUID;

import javax.annotation.Resource;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.inject.Inject;
import javax.inject.Named;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.security.enterprise.SecurityContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.mindrot.jbcrypt.BCrypt;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import entity.MoblEntity;
import enums.UserRole;
import sevice.SellerServiceLocal;
import ui.HomeBean;

@Named
@SessionScoped
public class AdminLogin implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AdminLogin() {
		// TODO Auto-generated constructor stub
	}
	@Resource(name = "java:jboss/mail/Default")
    private Session sessionSend;
	@Inject
	private SellerServiceLocal sellerServiceLocal;
	HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
	HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
	private MoblEntity moblEntity = new MoblEntity();
	@Pattern(regexp = "09\\d{9}", message = "شماره وارده اشتباه می باشد")
	private String mobile = "";
	@Pattern(regexp = "\\d{6}", message = "شماره وارده اشتباه می باشد")
	private String authCode;
	@Size(max=30 , message="max size is 500")
	private String password;
	private String checkInMobile = "";
	private boolean forgetPassParam = false;
	
	private int countOfLogin=0;
	
	private String urlPath;
	@Inject
	private HomeBean homeBean;
	
	private boolean niaz;
	
	private boolean adminFlag=false;
	@Inject
	private AdminProfile adminProfile;
	

	public String getUrlPath() {
		return urlPath;
	}

	public void setUrlPath(String urlPath) {
		this.urlPath = urlPath;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


	public String getAuthCode() {
		return authCode;
	}

	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public MoblEntity getMoblEntity() {
		return moblEntity;
	}

	public void setMoblEntity(MoblEntity moblEntity) {
		this.moblEntity = moblEntity;
	}

	public String getCheckInMobile() {
		return checkInMobile;
	}

	public void setCheckInMobile(String checkInMobile) {
		this.checkInMobile = checkInMobile;
	}

	private String hashPassword(String password) {
		return BCrypt.hashpw(password, BCrypt.gensalt());
	}

	private boolean verifyPassword(String password, String hashedPassword) {
		return BCrypt.checkpw(password, hashedPassword);
	}

	public boolean isAdminFlag() {
		return adminFlag;
	}

	public void setAdminFlag(boolean adminFlag) {
		this.adminFlag = adminFlag;
	}

	public MoblEntity findUserByToken() {
		try {

			HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
			Cookie[] userCookies = request.getCookies();
			String tehcfuCookie = "";
			if (userCookies != null && userCookies.length > 0) {
				for (int i = 0; i < userCookies.length; i++) {
					if (userCookies[i].getName().equals("tehcfu")) {
						// System.err.println(userCookies[i]);
						tehcfuCookie = userCookies[i].getValue();
						break;
					}
				}
			}
			System.err.println(tehcfuCookie);
			moblEntity = sellerServiceLocal.findSellerByToken(tehcfuCookie);
			if (moblEntity == null)
				return null;
			else
				return moblEntity;
		} catch (Exception e) {
			System.err.println("cookie not find");
			return null;
		}
	}

	public MoblEntity findMoblEntityByMobile() {
		try {
			//sendEmail(mobile);
			moblEntity = sellerServiceLocal.findSellerByMobile(mobile);
			if (moblEntity == null)
				return null;
			else
				return moblEntity;
		} catch (Exception e) {
			return null;
		}
	}
	
	public void adminGoMerchantProfile(long sellerId) {
		adminFlag = true;
		try {
			moblEntity = sellerServiceLocal.findSellerById(sellerId);
			adminProfile.setMoblEntity(moblEntity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			login();
	}

	public void login() {
		if(!adminFlag) {
		if (findUserByToken() != null) {
			System.err.println("tttttttttttttttttttttt");
			session.setAttribute("mobile", moblEntity.getMobile());
			try {
				FacesContext.getCurrentInstance().getExternalContext().redirect("/admin/admin-profile.xhtml");
				//sendEmail(this.moblEntity.getMobile());
			} catch (IOException e) {
				this.checkInMobile = "first";
				try {
					FacesContext.getCurrentInstance().getExternalContext().redirect("/admin/admin-login.xhtml");
				} catch (IOException e1) {}
			}
		} else {
			this.checkInMobile = "first";
			try {
				FacesContext.getCurrentInstance().getExternalContext().redirect("/admin/admin-login.xhtml");
			} catch (IOException e1) {}
		}
		}else {
			session.setAttribute("mobile", moblEntity.getMobile());
			System.err.println(moblEntity.getMobile());
			System.err.println(moblEntity.getSellerStorePer());
			System.err.println("GGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGG");
			try {
				FacesContext.getCurrentInstance().getExternalContext().redirect("/admin/admin-profile.xhtml");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void loginNiaz() {
		niaz =true;
		if (findUserByToken() != null) {
			System.err.println("tttttttttttttttttttttt");
			session.setAttribute("mobile", moblEntity.getMobile());
			try {
				FacesContext.getCurrentInstance().getExternalContext().redirect("/admin/admin-profile.xhtml");
			} catch (IOException e) {
				this.checkInMobile = "first";
				try {
					FacesContext.getCurrentInstance().getExternalContext().redirect("/admin/admin-login.xhtml");
				} catch (IOException e1) {}
			}
		} else {
			this.checkInMobile = "first";
			try {
				FacesContext.getCurrentInstance().getExternalContext().redirect("/admin/admin-login.xhtml");
			} catch (IOException e1) {}
		}
	}


//	if(this.moblEntity.getAuthCode()==this.authCode) {
//	moblEntity.setMobile(this.moblEntity.getMobile());
//	moblEntity.setAuthCode(this.moblEntity.getAuthCode());
//	moblEntity.setPassword(this.hashPassword(password));
//	sellerServiceLocal.insertSeller(moblEntity);
//	FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("*****************************با موفقیت وارد گردید************************"));
//    }
//	else {
//	FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "کد وارد شده صحیح نمی باشد", null));
//	}
	
/*	public void sendEmail(String mobile) {
		try {
			OkHttpClient client = new OkHttpClient();
					MediaType mediaType = MediaType.parse("application/json");
					RequestBody body = RequestBody.create(mediaType, "{\n   \"receiver\":\"okksDPXOEkksrm9A9hVyWg==\",\n   \"min_api_version\":1,\n   \"sender\":{\n      \"name\":\"tehcfu\",\n      \"avatar\":\"http://tehcfu.com\"\n   },\n "
							+ "  \"tracking_data\":\"tracking data\",\n   \"type\":\"text\",\n   "
							+ "\"text\":\"" + mobile +"\"\n}");
					Request request = new Request.Builder()
					  .url("https://chatapi.viber.com/pa/send_message")
					  .method("POST", body)
					  .addHeader("X-Viber-Auth-Token", "4f9a10848ca7e1fe-ee0f26e17934ede3-16a455b2383d908e")
					  .addHeader("Content-Type", "application/json")
					  .build();
					Response response = client.newCall(request).execute();
					System.err.println(response.toString());
	    System.err.println("SSSSSSSSSSSSSSEEEEEEEEEEEEEEENNNNNNNNDDDDDDDDEEEEEEEEEDDDDDDDDd");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	public void loginFirst() {
		if (findMoblEntityByMobile() != null) {
			System.err.println("******************1**************");
			if (moblEntity.getAuthCode() != 0) {
				this.checkInMobile = "secound";
				System.err.println("******************secound**************");
			} else {
				System.err.println("******************else**************");
				this.checkInMobile = "third";
				Random random = new Random();
				int code = random.nextInt(999999);
				if (code < 100000)
					code = code + 100000;
				this.moblEntity.setAuthCode(code);
				URL url2;
				System.err.println("%%%%%%%%%%%%%%%%%%%%%%" +this.moblEntity.getAuthCode());
				try {
				url2 = new URL(
				"https://www.saharsms.com/api/gONhkiXUT8sBU1yUJUAQPAqOYlcIOho4/json/SendVerify?receptor=" 
				+ this.moblEntity.getMobile() +"&template=tehcfusms-16147&token=" + code);
				HttpURLConnection httpURLConnection2 = (HttpURLConnection) url2.openConnection();
				System.err.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
				System.err.println(httpURLConnection2.getResponseMessage());
				httpURLConnection2.disconnect();
				FacesContext.getCurrentInstance().getExternalContext().redirect("/admin/admin-login.xhtml");
				} catch (IOException e) {
				e.printStackTrace();
				}
			}
		} else {
			System.err.println("******************else2**************");
			this.checkInMobile = "third";
			this.moblEntity=new MoblEntity();
			Random random = new Random();
			int code = random.nextInt(999999);
			if (code < 100000)
				code = code + 100000;
			this.moblEntity.setMobile(mobile);
			this.moblEntity.setAuthCode(code);
			URL url2;
			try {
			System.err.println("-------------------" + mobile);
			System.err.println("-------------------" + code);
			url2 = new URL(
			"https://www.saharsms.com/api/gONhkiXUT8sBU1yUJUAQPAqOYlcIOho4/json/SendVerify?receptor=" 
			+ mobile +"&template=tehcfusms-16147&token=" + code);
			HttpURLConnection httpURLConnection2 = (HttpURLConnection) url2.openConnection();
			System.err.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
			System.err.println(httpURLConnection2.getResponseMessage());
			httpURLConnection2.disconnect();
			FacesContext.getCurrentInstance().getExternalContext().redirect("/admin/admin-login.xhtml");
			} catch (IOException e) {}
		}
	}
	
	public void loginThird() {
		System.err.println("################444444444444444444################");
		HttpServletResponse response=(HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
		if(this.moblEntity.getAuthCode()==Integer.parseInt(this.authCode) && (countOfLogin <4)) {	
			System.err.println("################5555555555555################");
			this.moblEntity.setPassword(this.hashPassword(password));
			UUID uuid=UUID.randomUUID();
        	String token=uuid.toString();
        	System.err.println("___________________uuid____________"+uuid);
        	this.moblEntity.setToken(token);
        	Cookie cookie2 = new Cookie("tehcfu", token);
        	cookie2.setHttpOnly(true);
        	//cookie2.setHttpOnly(true);
        	cookie2.setPath("/");
        	cookie2.setMaxAge(2592000);
        	System.err.println("********************************************888*************8");
        	if((forgetPassParam==false) && (this.moblEntity.getRole()!=null))
        	{
        		System.err.println("****************************************");
        		System.err.println(this.moblEntity.getRole().equals("MERCHANT"));
        		System.err.println(forgetPassParam);
			try {
				sellerServiceLocal.insertSeller(moblEntity);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
        	    try {
					sellerServiceLocal.updateSeller(this.moblEntity);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
        	}
			else {
        		try {
        			System.err.println("7777777777777777777777777777777777777777");
					sellerServiceLocal.updateSeller(moblEntity);
					this.forgetPassParam = false;
				} catch (Exception e) {
					System.err.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
					e.printStackTrace();
				}
        	}
        	response.addCookie(cookie2);
			try {
				session.setAttribute("mobile", moblEntity.getMobile());
				homeBean.setMoblEntity(moblEntity);
				if(!niaz)
				FacesContext.getCurrentInstance().getExternalContext().redirect(urlPath);
				else 
				FacesContext.getCurrentInstance().getExternalContext().redirect("/admin/admin-advertice.xhtml");
			} catch (IOException e) {}
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("*****************************با موفقیت وارد گردید************************"));
		    }
			else {
			this.countOfLogin ++ ;
			if(countOfLogin<4)
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "کد وارد شده صحیح نمی باشد", null));
			else
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, " ورود شما مسدود گردید سیستم تا ۱ ساعت قفل می باشد", null));	
			}
	}
	
	public void loginSecound() {
		HttpServletResponse response=(HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
		if(this.verifyPassword(password, this.moblEntity.getPassword())) {
			UUID uuid=UUID.randomUUID();
        	String token=uuid.toString();
        	System.err.println("___________________uuid____________"+uuid);
        	this.moblEntity.setToken(token);
        	Cookie cookie2 = new Cookie("tehcfu", token);
        	cookie2.setHttpOnly(true);
        	//cookie2.setHttpOnly(true);
        	cookie2.setPath("/");
        	cookie2.setMaxAge(2592000);
        	this.moblEntity.setToken(token);
        	try {
        	    sellerServiceLocal.updateSeller(this.moblEntity);
        	    response.addCookie(cookie2);
        	    session.setAttribute("mobile", moblEntity.getMobile());
        	    homeBean.setMoblEntity(moblEntity);
				if(!niaz) {
				FacesContext.getCurrentInstance().getExternalContext().redirect(urlPath);
				}
				else 
				FacesContext.getCurrentInstance().getExternalContext().redirect("/admin/admin-advertice.xhtml");
			} catch (Exception e) {}
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("*****************************با موفقیت وارد گردید************************"));
		    }
			else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "رمز عبور صحیح نمی باشد", null));
			}
	}
	
	public void forgetPass() {
		this.checkInMobile = "third";
		Random random = new Random();
		int code = random.nextInt(999999);
		if (code < 100000)
			code = code + 100000;
		this.moblEntity.setAuthCode(code);
		URL url2;
		try {
		url2 = new URL(
		"https://www.saharsms.com/api/gONhkiXUT8sBU1yUJUAQPAqOYlcIOho4/json/SendVerify?receptor=" 
		+ this.moblEntity.getMobile() +"&template=tehcfusms-16147&token=" + code);
		HttpURLConnection httpURLConnection2 = (HttpURLConnection) url2.openConnection();
		System.err.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		System.err.println(httpURLConnection2.getResponseMessage());
		httpURLConnection2.disconnect();
		this.forgetPassParam = true;
		FacesContext.getCurrentInstance().getExternalContext().redirect("/admin/admin-login.xhtml");
		
		} catch (IOException e) {
		e.printStackTrace();
		}
	}

	public void loginDirectCheck(ComponentSystemEvent event) {
		if (checkInMobile.equals("")) {
			try {
				FacesContext.getCurrentInstance().getExternalContext().redirect("/");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {

		}
	}
	
	public void niaz() {
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("/admin/admin-advertice.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
