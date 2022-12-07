package teams.ksv.kwrs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import teams.ksv.kwrs.mapper.ScheduleMapper;
import teams.ksv.kwrs.model.Schedule;

import java.util.List;

@Service
public class ScheduleService {

    @Autowired
    ScheduleMapper scheduleMapper;

    public Schedule getSchedule(int sid) {
        List<Integer> courseList = scheduleMapper.getSchedule(sid);
        int status = scheduleMapper.getStatus(sid);
        return new Schedule(sid, status, courseList);
    }

    public void approve(int sid) {
        scheduleMapper.setStatus(sid, 2);
    }

    public void reject(int sid) {
        scheduleMapper.setStatus(sid, 3);
    }

    public void submit(Schedule schedule) {
        update(schedule, 1);
    }

    private void update(Schedule schedule, int newStatus) {
        int sid = schedule.getSid();
        List<Integer> courseIdList = schedule.getCourseIdList();

        // update course
        scheduleMapper.deleteSchedule(sid);
        for (Integer courseId : courseIdList) {
            scheduleMapper.insert(sid, courseId);
        }

        // update status
        scheduleMapper.setStatus(sid, newStatus);
    }

}
