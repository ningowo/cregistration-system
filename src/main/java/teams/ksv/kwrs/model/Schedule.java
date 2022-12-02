package teams.ksv.kwrs.model;

import lombok.Getter;
import lombok.Setter;
import teams.ksv.kwrs.dao.StudentCourse;

import java.io.Serializable;
import java.util.List;


@Getter
@Setter
public class Schedule implements Serializable {

    // 0 - not submitted, 1- submitted, 2 - approved, 3 - rejected.
    int status;

    List<StudentCourse> courseList;

    public Schedule(int status, List<StudentCourse> courseList) {
        this.status = status;
        this.courseList = courseList;
    }

}
