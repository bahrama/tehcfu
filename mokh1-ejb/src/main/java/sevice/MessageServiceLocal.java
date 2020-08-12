package sevice;

import java.util.List;

import javax.ejb.Local;

import entity.MessageEntity;
import entity.MoblEntity;

@Local
public interface MessageServiceLocal {

	void insertToMessage(MessageEntity messageEntity);

	List<MessageEntity> findAllMessageBySeller(MoblEntity moblEntity);

}
