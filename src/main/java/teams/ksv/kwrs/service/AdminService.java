package teams.ksv.kwrs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import teams.ksv.kwrs.dao.Course;
import teams.ksv.kwrs.mapper.CourseMapper;
import teams.ksv.kwrs.model.DeptRegisStat;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    CourseMapper courseMapper;

    public boolean createCourse(Course course) {
        try {
            courseMapper.create(course);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteCourse(int id) {
        try {
            courseMapper.del(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<DeptRegisStat> regisStat() {
        return courseMapper.stat();
    }
}
