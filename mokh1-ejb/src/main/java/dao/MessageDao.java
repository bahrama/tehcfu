package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entity.BazdidEntity;
import entity.MessageEntity;
import entity.MoblEntity;
import entity.RentEntity;

/**
 * Session Bean implementation class MessageDao
 */
@Stateless
public class MessageDao implements MessageDaoLocal {

    /**
     * Default constructor. 
     */
    public MessageDao() {
        // TODO Auto-generated constructor stub
    }
    
    @PersistenceContext(unitName="aliUnit")
    private EntityManager entityManager;
    @Override
    public void insertToMessage(MessageEntity messageEntity) {
    	entityManager.persist(messageEntity);
    }
    
    
    @Override
    public void updateMessage(MessageEntity messageEntity){
    	entityManager.merge(messageEntity);
    }
    

    @SuppressWarnings("unchecked")
	@Override
    public List<MessageEntity> findAllMessageBySeller(MoblEntity moblEntity) {
    	return entityManager.createNamedQuery("findMessageEntityBySeller").setParameter("v_messageTo", moblEntity).getResultList();
    }
    
    @SuppressWarnings("unchecked")
	@Override
    public int findAllUnreadedMessageBySeller(MoblEntity moblEntity) {
    	return entityManager.createNamedQuery("findAllunreadedMessageEntityBySeller").setParameter("v_messageTo", moblEntity).setParameter("v_readed", false).getResultList().size();
    }
}
