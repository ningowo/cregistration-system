package teams.ksv.kwrs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import teams.ksv.kwrs.dao.*;
import teams.ksv.kwrs.mapper.*;
import teams.ksv.kwrs.vo.CourseQuery;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseMapper courseMapper;

    @Resource
    private DataSource dataSource;

    public Course queryById(int id) {
        return courseMapper.queryById(id);
    }

    public List<Course> queryList(List<Integer> ids) {
        List<Course> courses = courseMapper.queryList(ids);
        return courses;
    }

    public List<Course> queryAll() {
        return courseMapper.queryAll();
    }

    public List<Course> queryByCondition(CourseQuery query) throws SQLException {
        String cname = query.getCourseName();
        Integer cnum = query.getCourseNumber();

        Connection conn = dataSource.getConnection();

        // use prepareStatement to prevent sql injection
        String sql = "select * from course where true";
        // For grammer below, google Ternary operation
        sql += (cname != null) ? " and course_name=?" : "";
        sql += (cnum != null) ? " and course_number=?" : "";
        PreparedStatement pstmt = conn.prepareStatement(sql);

        int cnt = 1;
        if (cname != null) {
            pstmt.setString(cnt++, cname);
        }
        if (cnum != null) {
            pstmt.setInt(cnt, cnum);
        }

        ResultSet rs = pstmt.executeQuery();

        List<Course> courseList = new ArrayList<>();
        while(rs.next()){
            // repeat for all column needed
            Course course = new Course();
            course.setId(rs.getInt(1));
            course.setCourseName(rs.getString(2));
            // more cols...
            courseList.add(course);
        }

        return courseList;
    }

}
