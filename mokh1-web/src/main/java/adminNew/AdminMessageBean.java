package adminNew;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.Size;

import dao.MessageDaoLocal;
import entity.MessageEntity;
import entity.MoblEntity;
import help.TimeCovnertor;
import panel.TempBean;
import sevice.MessageServiceLocal;

@Named
@ViewScoped
public class AdminMessageBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AdminMessageBean() {
		// TODO Auto-generated constructor stub
	}
	
	@Inject
	private AdminProfile profile;
	@Inject
	private MessageServiceLocal messageServiceLocal;
	@Inject
	private MessageDaoLocal messageDaoLocal;
	
	@Size(max=5000)
	private String messagePage;
	
	public List<MessageEntity> findAllUserMessage(){
		List<MessageEntity> lst = new ArrayList<MessageEntity>();
		lst = messageServiceLocal.findAllMessageBySeller(profile.getMoblEntity());
		for (MessageEntity message : lst) {
			if(message.isReaded()==false) {
			message.setReaded(true);
			messageDaoLocal.updateMessage(message);
			}
			}
		return lst;
	}
	
    public String convertToPersianDate(Date date) {
    	if(date!=null)
    	return TimeCovnertor.findPersianDate(date);
    	else
    	return "وارد نشده است";
    }
    
    
    public int findAllUnreadedMessageBySeller() {
    	return messageDaoLocal.findAllUnreadedMessageBySeller(profile.getMoblEntity());
    }

}
