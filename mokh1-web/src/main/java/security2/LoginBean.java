package security2;

import java.io.IOException;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.security.enterprise.AuthenticationStatus;
import javax.security.enterprise.SecurityContext;
import javax.security.enterprise.authentication.mechanism.http.AuthenticationParameters;
import javax.security.enterprise.authentication.mechanism.http.AutoApplySession;
import javax.security.enterprise.authentication.mechanism.http.RememberMe;
import javax.security.enterprise.credential.RememberMeCredential;
import javax.security.enterprise.credential.UsernamePasswordCredential;
import javax.security.enterprise.identitystore.IdentityStoreHandler;
import javax.security.enterprise.identitystore.Pbkdf2PasswordHash;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Pattern;

import org.mindrot.jbcrypt.BCrypt;

import catch_db.CatchSellerLocal;
import entity.MoblEntity;
import enums.UserRole;
import sevice.OnlineUsersLocal;
import sevice.SellerServiceLocal;

@Named("login")
@SessionScoped
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 1L;

	public LoginBean() {
		// TODO Auto-generated constructor stub
	}
    @Pattern(regexp="09\\d{9}" , message="شماره وارده اشتباه می باشد")
	private String mobile="";
    @Pattern(regexp="\\d{6}" , message="شماره وارده اشتباه می باشد")
    private String authCode="";
	private MoblEntity moblEntity;
	private String userType;

	@Inject
	private SecurityContext securityContext;

	@Inject
	private ExternalContext externalContext;

	@Inject
	private FacesContext facesContext;
	@Inject
	private HttpSession session;
	@Inject
	private SellerServiceLocal sellerServiceLocal;
//    @Inject
//	private CatchSellerLocal catchSellerLocal;

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

	public void submit() throws Exception {
		if (continueAuthentication().equals(AuthenticationStatus.SEND_CONTINUE)) {
			facesContext.responseComplete();
		} else if (continueAuthentication().equals(AuthenticationStatus.SEND_FAILURE)) {
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login failed", null));
		} else if (continueAuthentication().equals(AuthenticationStatus.SUCCESS)) {

			// HttpServletResponse response=(HttpServletResponse)
			// facesContext.getExternalContext().getResponse();
			// UUID uuid=UUID.randomUUID();
			// String token=uuid.toString();
			// System.err.println("___________________uuid____________"+uuid);
			// moblEntity=sellerServiceLocal.findSellerByMobile(mobile);
			// System.err.println(moblEntity.getAuthCode());
			// System.err.println(moblEntity.getMobile());
			// moblEntity.setToken(token);
			// sellerServiceLocal.updateSeller(moblEntity);
			// session.setMaxInactiveInterval(1000);
			// Cookie cookie2 = new Cookie("tehcfu", token);
			// //cookie2.setHttpOnly(true);
			// response.addCookie(cookie2);
			// onlineUsersLocal.getMoblEntities().add(moblEntity);
			// System.err.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%onlineUsersLocal.getMoblEntities().add(moblEntity);%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Login succeed", null));

			// if(moblEntity.getRole().equals(UserRole.ADMIN))
			// externalContext.redirect(externalContext.getRequestContextPath() +
			// "/pages/admin/edit-blog.xhtml");
			// else
			externalContext.redirect(externalContext.getRequestContextPath() + "/pages/panel_seller/profile.xhtml");

			/*
			 * externalContext.redirect(externalContext.getRequestContextPath() +
			 * "/pages/login/divide-login.xhtml");
			 */
		}

	}

	private AuthenticationStatus continueAuthentication() {
		return securityContext.authenticate((HttpServletRequest) externalContext.getRequest(),
				(HttpServletResponse) externalContext.getResponse(),
				AuthenticationParameters.withParams().credential(new UsernamePasswordCredential(mobile, authCode)));
	}



	public MoblEntity findSellerByMobile() throws Exception {
		return sellerServiceLocal.findSellerByMobile(mobile);
	}

	public void insertSelerMobileAuthCode(){
		MoblEntity moblEntity = new MoblEntity();
		moblEntity.setMobile(mobile);
		Random random = new Random();
		int code = random.nextInt(999999);
		if (code < 100000)
			code = code + 100000;
		moblEntity.setAuthCode(code);
		moblEntity.setRole(UserRole.USER);
		sellerServiceLocal.insertSeller(moblEntity);
		//catchSellerLocal.getOnlineUsers().add(moblEntity);
		try {
			URL url2 = new URL(
					"https://www.saharsms.com/api/gONhkiXUT8sBU1yUJUAQPAqOYlcIOho4/json/SendVerify?receptor=" + mobile +"&template=tehcfusms-16147&token=" + code);
			HttpURLConnection httpURLConnection2 = (HttpURLConnection) url2.openConnection();
			System.out.println(httpURLConnection2.getResponseMessage());
			httpURLConnection2.disconnect();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void updateSellerAuthCode() throws Exception {
		moblEntity = findSellerByMobile();
		Random random = new Random();
		int code = random.nextInt(999999);
		if (code < 100000)
			code = code + 100000;
		moblEntity.setAuthCode(code);
		sellerServiceLocal.updateSeller(moblEntity);
		//catchSellerLocal.getOnlineUsers().add(moblEntity);
		URL url2 = new URL(
				"https://www.saharsms.com/api/gONhkiXUT8sBU1yUJUAQPAqOYlcIOho4/json/SendVerify?receptor=" + moblEntity.getMobile() +"&template=tehcfusms-16147&token=" + code);
		HttpURLConnection httpURLConnection2 = (HttpURLConnection) url2.openConnection();
		System.err.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		System.err.println(httpURLConnection2.getResponseMessage());
		httpURLConnection2.disconnect();
	}

	public String sendAuthCode() {
		try {
			updateSellerAuthCode();
			System.out.println("___________*****************code updated***************________________");
			return "/pages/login/signin-authcode.xhtml?faces-redirect=true";
		} catch (Exception e) {
			insertSelerMobileAuthCode();
			System.out.println("___________*****************code inserted***************________________");
			return "/pages/login/signin-authcode.xhtml?faces-redirect=true";
		}
	}

	/*
	 * private String hashPassword(String password) { return BCrypt.hashpw(password,
	 * BCrypt.gensalt()); }
	 * 
	 * private boolean verifyPassword(String password, String hashedPassword) {
	 * return BCrypt.checkpw(password, hashedPassword); }
	 */

	public void findUserByToken() {
		try {
			FacesContext contex = FacesContext.getCurrentInstance();
			HttpServletRequest request = (HttpServletRequest) contex.getExternalContext().getRequest();
        	
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
			session.setAttribute("mobile", moblEntity.getMobile());
			//catchSellerLocal.getOnlineUsers().add(moblEntity);
			switch (continueAuthenticationAfterCookie(moblEntity.getMobile(),
					String.valueOf(moblEntity.getAuthCode()))) {
			case SEND_CONTINUE:
				facesContext.responseComplete();
				break;
			case SEND_FAILURE:
				facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login failed", null));
				break;
			case SUCCESS: {
				facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Login succeed", null));
				externalContext.redirect(externalContext.getRequestContextPath() + "/pages/panel_seller/profile.xhtml");
				break;
			}
			case NOT_DONE:
			}
		} catch (Exception e) {
			System.err.println("cookie not find");
		}
	}

	private AuthenticationStatus continueAuthenticationAfterCookie(String mobile, String authCode) {
		return securityContext.authenticate((HttpServletRequest) externalContext.getRequest(),
				(HttpServletResponse) externalContext.getResponse(),
				AuthenticationParameters.withParams().credential(new UsernamePasswordCredential(mobile, authCode)));
	}

	@PreDestroy
	public void destroySession() {
		System.err.println("destroy user");
		//catchSellerLocal.getOnlineUsers().remove(moblEntity);
		//onlineUsersLocal.getMobls().remove(moblEntity);
	}

	public void divideLogin() {
		try {
			///if (!moblEntity.getRole().equals(null)) {
				if (moblEntity.getRole().equals(UserRole.ADMIN))
					externalContext.redirect(externalContext.getRequestContextPath() + "/pages/admin/edit-blog.xhtml");
				else {
					System.err.println("HICHI");
				}
			//}
		} catch (Exception e) {
			System.err.println("divide faild");
		}
	}
	
	public void checkRequestToLogin() {
		try {
			if (mobile.equals("")) 
					externalContext.redirect(externalContext.getRequestContextPath() + "/pages/login/signin-phone.xhtml");
				else {
					System.err.println("HICHI");
				}
		} catch (Exception e) {
			System.err.println("divide faild");
		}
	}
	
	public String logout() {
		HttpServletResponse response=(HttpServletResponse) facesContext.getExternalContext().getResponse();
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		Cookie cookie2 = new Cookie("tehcfu", "");
		cookie2.setPath("/");
		response.addCookie(cookie2);
		//catchSellerLocal.getOnlineUsers().remove(moblEntity);
		return "/pages/main/home.xhtml?faces-redirect=true";
	}

}
