package teams.ksv.kwrs.vo;

import lombok.Getter;
import lombok.Setter;
import teams.ksv.kwrs.dao.Course;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class ScheduleVO implements Serializable {

    int sid;

    // 0 - not submitted, 1- submitted, 2 - approved, 3 - rejected.
    int status;

    List<Course> courseIdList;

    public ScheduleVO(int sid, int status, List<Course> courseIdList) {
        this.sid = sid;
        this.status = status;
        this.courseIdList = courseIdList;
    }

}
