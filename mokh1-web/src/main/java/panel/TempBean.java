 package panel;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import entity.MoblEntity;
import enums.UserRole;
import sevice.OnlineUsersLocal;
import sevice.SellerServiceLocal;

@Named
@SessionScoped
public class TempBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TempBean() {
		// TODO Auto-generated constructor stub
	}
    @Inject
    private HttpSession session;
    @Inject
	private SellerServiceLocal sellerServiceLocal;
	@Inject
	private ExternalContext externalContext;
	@Inject
	private OnlineUsersLocal local;
	
    private MoblEntity moblEntity;
    
    
    
    public MoblEntity getMoblEntity() {
		return moblEntity;
	}


	public void setMoblEntity(MoblEntity moblEntity) {
		this.moblEntity = moblEntity;
	}


	@PostConstruct
    public void start() {
    try {
		moblEntity=sellerServiceLocal.findSellerByMobile(session.getAttribute("mobile").toString());
		local.getMobls().add(moblEntity);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
    }
    
    
    public void checkAuth(ComponentSystemEvent event) {
    	System.err.println("111111111111111111111111111111");
		try {
			if (moblEntity.getRole().equals(UserRole.ADMIN)) 
			{
				FacesContext.getCurrentInstance().getExternalContext().redirect(externalContext.getRequestContextPath() + "/pages/admin/add-seller-page.xhtml");
			}else{
				System.err.println("congraduation");
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
//    

   
    
    
    
    
	

}
