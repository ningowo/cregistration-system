package teams.ksv.kwrs.dao;


import java.sql.Timestamp;
import java.util.Date;

public class Message {

  private long id;
  private long senderId;
  private long recipientId;
  private Date sendTime;
  private String content;
  private long readMark;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getSenderId() {
    return senderId;
  }

  public void setSenderId(long senderId) {
    this.senderId = senderId;
  }


  public long getRecipientId() {
    return recipientId;
  }

  public void setRecipientId(long recipientId) {
    this.recipientId = recipientId;
  }


  public Date getSendTime() {
    return sendTime;
  }

  public void setSendTime(Timestamp sendTime) {
    this.sendTime = sendTime;
  }


  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }


  public long getReadMark() {
    return readMark;
  }

  public void setReadMark(long readMark) {
    this.readMark = readMark;
  }

}
