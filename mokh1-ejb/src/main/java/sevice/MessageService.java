package sevice;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import org.eclipse.persistence.annotations.PrimaryKey;

import dao.MessageDaoLocal;
import entity.MessageEntity;
import entity.MoblEntity;

/**
 * Session Bean implementation class MessageService
 */
@Stateless
public class MessageService implements MessageServiceLocal {

    /**
     * Default constructor. 
     */
    public MessageService() {
        // TODO Auto-generated constructor stub
    }
    @Inject
    private MessageDaoLocal messageDaoLocal;
    
    
    @Override
    public void insertToMessage(MessageEntity messageEntity) {
    	messageDaoLocal.insertToMessage(messageEntity);
    }
    
	@Override
    public List<MessageEntity> findAllMessageBySeller(MoblEntity moblEntity) {
	    return messageDaoLocal.findAllMessageBySeller(moblEntity);
	}
	
}
