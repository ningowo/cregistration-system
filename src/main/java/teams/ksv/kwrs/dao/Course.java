package teams.ksv.kwrs.dao;

import lombok.ToString;

@ToString
public class Course {

  private long id;
  private String courseName;
  private long courseNumber;
  private String professor;
  private long creditHour;
  private String room;
  private String classTime;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getCourseName() {
    return courseName;
  }

  public void setCourseName(String courseName) {
    this.courseName = courseName;
  }


  public long getCourseNumber() {
    return courseNumber;
  }

  public void setCourseNumber(long courseNumber) {
    this.courseNumber = courseNumber;
  }


  public String getProfessor() {
    return professor;
  }

  public void setProfessor(String professor) {
    this.professor = professor;
  }


  public long getCreditHour() {
    return creditHour;
  }

  public void setCreditHour(long creditHour) {
    this.creditHour = creditHour;
  }


  public String getRoom() {
    return room;
  }

  public void setRoom(String room) {
    this.room = room;
  }


  public String getClassTime() {
    return classTime;
  }

  public void setClassTime(String classTime) {
    this.classTime = classTime;
  }

}
