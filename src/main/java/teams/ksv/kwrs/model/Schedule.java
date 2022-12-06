package teams.ksv.kwrs.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;


@Getter
@Setter
public class Schedule implements Serializable {

    int sid;

    // 0 - not submitted, 1- submitted, 2 - approved, 3 - rejected.
    int status;

    List<Integer> courseIdList;

    public Schedule(int status, List<Integer> courseIdList) {
        this.status = status;
        this.courseIdList = courseIdList;
    }

}
