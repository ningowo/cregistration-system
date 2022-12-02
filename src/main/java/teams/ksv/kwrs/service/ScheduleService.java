package teams.ksv.kwrs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import teams.ksv.kwrs.dao.StudentCourse;
import teams.ksv.kwrs.mapper.ScheduleMapper;
import teams.ksv.kwrs.model.Schedule;

import java.util.List;

@Service
public class ScheduleService {

    @Autowired
    ScheduleMapper scheduleMapper;

    public Schedule getSchedule(int sid) {
        List<StudentCourse> courseList = scheduleMapper.getSchedule(sid);
        int status = scheduleMapper.getStatus(sid);
        return new Schedule(status, courseList);
    }

    public void update(Schedule schedule, int sid) {
        scheduleMapper.deleteSchedule(sid);
        for (StudentCourse course : schedule.getCourseList()) {
            scheduleMapper.insert(course);
        }

        scheduleMapper.setStatus(schedule.getStatus(), sid);
    }
}
