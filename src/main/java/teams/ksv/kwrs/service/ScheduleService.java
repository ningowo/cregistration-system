package teams.ksv.kwrs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import teams.ksv.kwrs.dao.Course;
import teams.ksv.kwrs.mapper.ScheduleMapper;
import teams.ksv.kwrs.model.Schedule;
import teams.ksv.kwrs.vo.ScheduleVO;

import java.util.List;

@Service
public class ScheduleService {

    @Autowired
    ScheduleMapper scheduleMapper;

    @Autowired
    CourseService courseService;

    public ScheduleVO getSchedule(int sid) {
        List<Integer> courseIdList = scheduleMapper.getSchedule(sid);
        int status = scheduleMapper.getStatus(sid);
        List<Course> courseList = courseService.queryList(courseIdList);
        return new ScheduleVO(sid, status, courseList);
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
