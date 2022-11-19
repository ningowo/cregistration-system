package teams.ksv.kwrs.dao;


public class Department {

  private long id;
  private String deptName;
  private long schoolId;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getDeptName() {
    return deptName;
  }

  public void setDeptName(String deptName) {
    this.deptName = deptName;
  }


  public long getSchoolId() {
    return schoolId;
  }

  public void setSchoolId(long schoolId) {
    this.schoolId = schoolId;
  }

}
