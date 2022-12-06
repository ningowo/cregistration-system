package teams.ksv.kwrs.dao;

import lombok.ToString;
import org.springframework.data.annotation.Id;

@ToString
public class Course {

  @Id
  private int id;
  private String courseName;
  private int courseNumber;
  private String professor;
  private int creditHour;
  private String room;
  private String classTime;


  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }


  public String getCourseName() {
    return courseName;
  }

  public void setCourseName(String courseName) {
    this.courseName = courseName;
  }


  public int getCourseNumber() {
    return courseNumber;
  }

  public void setCourseNumber(int courseNumber) {
    this.courseNumber = courseNumber;
  }


  public String getProfessor() {
    return professor;
  }

  public void setProfessor(String professor) {
    this.professor = professor;
  }


  public int getCreditHour() {
    return creditHour;
  }

  public void setCreditHour(int creditHour) {
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
