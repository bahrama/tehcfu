package panel;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.Size;

import entity.MessageEntity;
import entity.MoblEntity;
import sevice.MessageServiceLocal;

@Named
@SessionScoped
public class MessagePageBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MessagePageBean() {
		// TODO Auto-generated constructor stub
	}
	@Inject
	private TempBean tempBean;
	@Inject
	private MessageServiceLocal messageServiceLocal;
	@Inject
	private FacesContext facesContext;
	@Size(max=5000)
	private String messagePage;
	
	
	
	public String getMessagePage() {
		return messagePage;
	}

	public void setMessagePage(String messagePage) {
		this.messagePage = messagePage;
	}

	public List<MessageEntity> findAllMessageBySeller() {
	return messageServiceLocal.findAllMessageBySeller(tempBean.getMoblEntity());
	}
	
	public void act(MoblEntity moblEntity1) {
        MessageEntity messageEntity=new MessageEntity();
        try {
        messageEntity.setPageMessage(this.messagePage);
        messageEntity.setDate(new Date());
        messageEntity.setMessageTo(moblEntity1);
	    messageEntity.setMessageFrom(tempBean.getMoblEntity());
	    messageServiceLocal.insertToMessage(messageEntity);
	    facesContext.getPartialViewContext().getEvalScripts().add("swal({title: 'موفق!',type: 'success', text: 'پیام شما با موفقیت ثبت گردید.', confirmButtonColor: '#469408',})");
		} catch (Exception e) {
			 facesContext.getPartialViewContext().getEvalScripts().add("swal({title: 'ناموفق!',type: 'error', text: 'برای ثبت پیام اول وارد سایت شوید', confirmButtonColor: '#469408',})");
		}
		

	}

}
