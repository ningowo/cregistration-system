package teams.ksv.kwrs.dao;


public class Student {

  private long id;
  private String username;
  private String pwd;
  private long deptId;
  private long advisorId;
  private long requestStatus;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }


  public String getPwd() {
    return pwd;
  }

  public void setPwd(String pwd) {
    this.pwd = pwd;
  }


  public long getDeptId() {
    return deptId;
  }

  public void setDeptId(long deptId) {
    this.deptId = deptId;
  }


  public long getAdvisorId() {
    return advisorId;
  }

  public void setAdvisorId(long advisorId) {
    this.advisorId = advisorId;
  }


  public long getRequestStatus() {
    return requestStatus;
  }

  public void setRequestStatus(long requestStatus) {
    this.requestStatus = requestStatus;
  }

}
