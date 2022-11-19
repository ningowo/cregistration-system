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

    /**
     * Two way to to execute sql
     *
     * 1. Mybatis mapper(use CourseMapper)
     * 1.1. use Annotation like @Insert to run simple sql
     * 1.2.(Real world solution!) use xml file to denote more complex sql(search online)
     *
     * 2. Directly connect(Data Source)
     * Can directly get configured data source(defined in /resources/application.properties), and just run sql string,
     * But need to deal with a lot of format stuff
     *
      */

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

    /**
     * Maybe you can find better way to do this
     * @param query
     * @return
     * @throws SQLException
     */
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
