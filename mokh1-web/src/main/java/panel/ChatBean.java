package panel;

import java.io.Serializable;
import java.util.Set;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import entity.MoblEntity;
import sevice.OnlineUsersLocal;

@Named
@SessionScoped
public class ChatBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ChatBean() {
		// TODO Auto-generated constructor stub
	}
	@Inject
	private OnlineUsersLocal onlineUsersLocal;
	


	public Set<MoblEntity> moblEntities(){
    	return onlineUsersLocal.getMobls();
    }
    

    

}
