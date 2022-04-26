package entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.eclipse.persistence.annotations.Cache;
import org.eclipse.persistence.annotations.CacheCoordinationType;
import org.eclipse.persistence.annotations.CacheType;
@Entity
@Table(name = "message_tbl")
@NamedQueries({ 
@NamedQuery(name = "findAllMessageEntity", query = "SELECT a FROM MessageEntity a ORDER BY a.messageId DESC"),
@NamedQuery(name = "findMessageEntityById", query = "SELECT i FROM MessageEntity i WHERE i.messageId=:v_machineId"),
@NamedQuery(name = "findMessageEntityBySeller", query = "SELECT i FROM MessageEntity i WHERE i.messageTo=:v_messageTo ORDER BY i.messageId DESC"),
@NamedQuery(name = "findAllunreadedMessageEntityBySeller", query = "SELECT i FROM MessageEntity i WHERE (i.messageTo=:v_messageTo) and (i.readed=:v_readed) ORDER BY i.messageId DESC")
})
@Cacheable(value = false)
public class MessageEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "message_id")
	private long messageId;
	@Column(name = "message_chat", nullable = true, length = 200)
	private String chatMessage;
	@Column(name = "message_page", nullable = true, length = 5000)
	private String pageMessage;
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	@Column(name = "raded")
	private boolean readed;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_message_from")
	private MoblEntity messageFrom;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_massage_to")
	private MoblEntity messageTo;

	public long getMessageId() {
		return messageId;
	}

	public void setMessageId(long messageId) {
		this.messageId = messageId;
	}

	public String getChatMessage() {
		return chatMessage;
	}

	public void setChatMessage(String chatMessage) {
		this.chatMessage = chatMessage;
	}

	public String getPageMessage() {
		return pageMessage;
	}

	public void setPageMessage(String pageMessage) {
		this.pageMessage = pageMessage;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public MoblEntity getMessageFrom() {
		return messageFrom;
	}

	public void setMessageFrom(MoblEntity messageFrom) {
		this.messageFrom = messageFrom;
	}

	public MoblEntity getMessageTo() {
		return messageTo;
	}

	public void setMessageTo(MoblEntity messageTo) {
		this.messageTo = messageTo;
	}

	public boolean isReaded() {
		return readed;
	}

	public void setReaded(boolean readed) {
		this.readed = readed;
	}

	
}
