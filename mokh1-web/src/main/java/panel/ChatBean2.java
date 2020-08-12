package panel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.push.Push;
import javax.faces.push.PushContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import catch_db.CatchSellerLocal;
import entity.MessageEntity;
import entity.MoblEntity;
import sevice.MessageServiceLocal;
import sevice.OnlineUsersLocal;
import sevice.SellerServiceLocal;

@Named
@SessionScoped
public class ChatBean2 implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9053992713791127919L;

	public ChatBean2() {
	}
	@Inject
	private MessageServiceLocal messageServiceLocal;
	@Inject
	private CatchSellerLocal catchSellerLocal;

	@Inject
	@Push(channel = "help")
	private PushContext pushContext;

	private MoblEntity user;

	private String message;

	private MoblEntity moblEntity=new MoblEntity();
	
	private MessageEntity messageEntity;

	@Inject
	private SellerServiceLocal sellerServiceLocal;

	public MoblEntity getMoblEntity() {
		return moblEntity;
	}

	public void setMoblEntity(MoblEntity moblEntity) {
		this.moblEntity = moblEntity;
	}

	@PostConstruct
	public void start() {
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
			catchSellerLocal.getOnlineUsers().add(moblEntity);
		} catch (Exception e) {
			System.err.println("cookie not find chat");
		}
	}

	public MoblEntity getUser() {
		return user;
	}

	public void setUser(MoblEntity user) {
		this.user = user;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void sendMessage(String senderm,long sender, String message, String user) {
		//messageEntity=new MessageEntity();
		pushContext.send(
				"<span style='line-height: 3;background-color:lavender;padding: 10px;border-radius: 5px;border: 1px solid darkkhaki;'>"
						+ " کاربر " + sender + " : " + message + "</span>",
				senderm);
		pushContext.send(
				"<span style='line-height: 3;background-color:palegreen;padding: 10px;border-radius: 5px;border: 1px solid darkkhaki;'>"
						+ " کاربر " + sender + " : " + message + "</span>",
				user);
//		messageEntity.setMessageFrom(moblEntity);
//		messageEntity.setMessageTo(this.user);
//		messageEntity.setDate(new Date());
//		messageEntity.setChatMessage(message);
//		messageServiceLocal.insertToMessage(messageEntity);
	}

	// public List<MoblEntity> findOnlineUsers(){
	// List<MoblEntity> entities=new ArrayList<MoblEntity>();
	// for (MoblEntity moblEntity : local.getMobls()) {
	// entities.add(moblEntity);
	// }
	// return entities;
	// }
	public Set<MoblEntity> findOnlineUsers() {
		return catchSellerLocal.getOnlineUsers();
	}
	


}
