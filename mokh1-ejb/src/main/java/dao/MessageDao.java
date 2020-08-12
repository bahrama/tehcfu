package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
    

    @SuppressWarnings("unchecked")
	@Override
    public List<MessageEntity> findAllMessageBySeller(MoblEntity moblEntity) {
    	return entityManager.createNamedQuery("findMessageEntityBySeller").setParameter("v_messageTo", moblEntity).getResultList();
    }
}
