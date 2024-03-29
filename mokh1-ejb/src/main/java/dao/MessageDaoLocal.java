package dao;

import java.util.List;

import javax.ejb.Local;

import entity.MessageEntity;
import entity.MoblEntity;

@Local
public interface MessageDaoLocal {

	void insertToMessage(MessageEntity messageEntity);

	List<MessageEntity> findAllMessageBySeller(MoblEntity moblEntity);

	void updateMessage(MessageEntity messageEntity);

	int findAllUnreadedMessageBySeller(MoblEntity moblEntity);


}
