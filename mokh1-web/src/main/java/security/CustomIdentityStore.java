package security;

import java.util.Arrays;
import java.util.HashSet;
import java.util.UUID;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.security.enterprise.credential.Credential;
import javax.security.enterprise.credential.UsernamePasswordCredential;
import javax.security.enterprise.identitystore.CredentialValidationResult;
import javax.security.enterprise.identitystore.IdentityStore;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.MoblEntity;
import sevice.OnlineUsersLocal;
import sevice.SellerServiceLocal;
import java.io.Serializable;

@SessionScoped
public class CustomIdentityStore implements Serializable, IdentityStore{




	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public CustomIdentityStore() {
		// TODO Auto-generated constructor stub
	}
    @Inject
	private SellerServiceLocal sellerServiceLocal;

    @Inject
    private FacesContext facesContext;
    
    @Inject
    private OnlineUsersLocal onlineUsersLocal;
    
    @Inject
    private HttpSession session;

//    @Override
//    public CredentialValidationResult validate(Credential credential) {
//
//        UsernamePasswordCredential login = (UsernamePasswordCredential) credential;
//
//        if (login.getCaller().equals("admin") 
//                       && login.getPasswordAsString().equals("admin1234")) {
//            return new CredentialValidationResult("admin", new HashSet<>(Arrays.asList("ADMIN")));
////        } else if (login.getCaller().equals("user@mail.com") 
////                       && login.getPasswordAsString().equals("USER1234")) {
////            return new CredentialValidationResult("user", new HashSet<>(Arrays.asList("USER")));
//        } else {
//            return CredentialValidationResult.NOT_VALIDATED_RESULT;
//        }
//    }
	
	   public CredentialValidationResult validate(Credential credential) {
	        UsernamePasswordCredential login = (UsernamePasswordCredential) credential;
	        try {
	       System.err.println("_______________****login.getCaller()*******" +login.getCaller()+"****************______________________");
		    System.err.println("_______________****login.getPasswordAsString()*******" +login.getPasswordAsString()+"****************______________________");
	        System.err.println("_______________****sellerServiceLocal.findSellerByMobile(login.getCaller())*******" +sellerServiceLocal.findSellerByMobile(login.getCaller())+"****************______________________");
	        MoblEntity moblEntity=sellerServiceLocal.findSellerByMobile(login.getCaller());
	        if(login.getPasswordAsString().equals(String.valueOf(moblEntity.getAuthCode()))) {
				HttpServletResponse response=(HttpServletResponse) facesContext.getExternalContext().getResponse();
				HttpServletRequest request = (HttpServletRequest) facesContext.getExternalContext().getRequest();
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
				if(tehcfuCookie.equals("")) {
				UUID uuid=UUID.randomUUID();
	        	String token=uuid.toString();
	        	System.err.println("___________________uuid____________"+uuid);
	        	moblEntity.setToken(token);
	        	sellerServiceLocal.updateSeller(moblEntity);
	        	Cookie cookie2 = new Cookie("tehcfu", token);
	        	//cookie2.setHttpOnly(true);
	        	//cookie2.setHttpOnly(true);
	        	cookie2.setPath("/");
	        	cookie2.setMaxAge(2592000);
	        	response.addCookie(cookie2);
				}
				session.setAttribute("mobile",moblEntity.getMobile());
            	onlineUsersLocal.getMobls().add(moblEntity);
	        	System.err.println("*********************\"merchant\", new HashSet<>(Arrays.asList(\"MERCHANT\"))*************");
	        	return new CredentialValidationResult("merchant", new HashSet<>(Arrays.asList("MERCHANT")));
	        }
	        else {
	        	System.err.println("__________**************code is invalid***************________________");
	        	return CredentialValidationResult.NOT_VALIDATED_RESULT; 
	        }
	        }catch (Exception e) {
	        	System.err.println("____________*************user not find*************__________________");
	        	return CredentialValidationResult.NOT_VALIDATED_RESULT;
			}
	    }


}
