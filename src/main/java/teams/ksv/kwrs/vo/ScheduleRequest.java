package teams.ksv.kwrs.vo;

import lombok.Getter;
import lombok.Setter;
import teams.ksv.kwrs.model.Schedule;

@Getter
@Setter
public class ScheduleRequest {

    int sid;

    Schedule schedule;
}
