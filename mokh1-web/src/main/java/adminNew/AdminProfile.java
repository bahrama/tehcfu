package adminNew;

import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.Size;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import dao.OfferDaoLocal;
import entity.MoblEntity;
import entity.OfferEntity;
import help.TimeCovnertor;
import sevice.SellerServiceLocal;

@Named
@SessionScoped
public class AdminProfile implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AdminProfile() {
		// TODO Auto-generated constructor stub
	}
	
	private MoblEntity moblEntity;
	
	@Inject
	private SellerServiceLocal sellerServiceLocal;
	HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
	HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
	HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
	@Size(max=100 , message="max size is 100")
	private String sellerName = "";
	@Size(max=10 , message="max size is 10")
	private String postCode = "";
	@Size(max=200 , message="max size is 200")	
	private String addres = "";
	@Inject
	private OfferDaoLocal offerDaoLocal;
	
	public MoblEntity getMoblEntity() {
		return moblEntity;
	}

	public void setMoblEntity(MoblEntity moblEntity) {
		this.moblEntity = moblEntity;
	}

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
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

	@PostConstruct
	public void init() {
		findUserByToken();
		//findUserByMobile();
	}
	
	public MoblEntity findUserByMobile() {
		String mobile = session.getAttribute("mobile").toString();
		try {
			this.moblEntity = sellerServiceLocal.findSellerByMobile(mobile);
			return this.moblEntity;
		} catch (Exception e) {
			return null;
		}
	}
	
	
	public void sendEmail(String mobile) {
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
	}
	
	public MoblEntity findUserByToken() {
		try {
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
		this.moblEntity=sellerServiceLocal.findSellerByToken(tehcfuCookie);
		session.setAttribute("mobile" ,moblEntity.getMobile());
		//catchSellerLocal.getOnlineUsers().add(moblEntity);
		sendEmail(moblEntity.getMobile());
		return moblEntity;
		}catch (Exception e) {
		System.err.println("token not find");
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("/admin/admin-login.xhtml");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return null;
		}
	}
	
	
	public void updateUser() {
		if(!addres.equals(""))
		this.moblEntity.setSellerAddres(addres);
		if(!sellerName.equals(""))
		this.moblEntity.setSellerName(sellerName);
		if(!postCode.equals(""))
		this.moblEntity.setPostcode(postCode);
		try {
			sellerServiceLocal.updateSeller(moblEntity);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("با موفقیت آپدیت گردید."));
			this.addres="";
			this.postCode = "";
			this.sellerName="";
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "خطا در ویرایش", null));
		}
	}
	
	public void logout() {
		session.setAttribute("mobile", "");
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		Cookie cookie2 = new Cookie("tehcfu", "");
		cookie2.setPath("/");
		response.addCookie(cookie2);
		//catchSellerLocal.getOnlineUsers().remove(moblEntity);
		
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("/pages/main/home.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int findViewedUser() {
		return offerDaoLocal.findAllCountByMerchant(moblEntity);
	}
	

	public List<OfferEntity> findAllOfferByMerchant(){
		
		return offerDaoLocal.findAllByMerchant(moblEntity);
	}
	
    public String convertToPersianDate(Date date) {
    	if(date!=null)
    	return TimeCovnertor.findPersianDate(date);
    	else
    	return "وارد نشده است";
    }
}
