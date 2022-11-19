package teams.ksv.kwrs.dao;


public class Message {

  private long id;
  private long senderId;
  private long recipientId;
  private java.sql.Timestamp sendTime;
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


  public java.sql.Timestamp getSendTime() {
    return sendTime;
  }

  public void setSendTime(java.sql.Timestamp sendTime) {
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
