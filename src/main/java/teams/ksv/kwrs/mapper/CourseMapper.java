package teams.ksv.kwrs.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import teams.ksv.kwrs.dao.Course;
import teams.ksv.kwrs.model.DeptRegisStat;

import java.util.List;

@Mapper
public interface CourseMapper {

    @Select("select * from course where id = #{id}")
    Course queryById(int id);

    @Select("select * from course")
    List<Course> queryAll();

    @Select("<script>"
            + "select * from course where id in "
            + "<foreach item = 'num' index = 'index' collection = 'ids' open='(' separator=',' close=')'>"
            + "#{num}"
            + "</foreach>"
            + "</script>")
    List<Course> queryList(List<Integer> ids);

    @Select("select * from course " +
            "where course_name=#{courseName} or course_number=*")
    List<Course> queryByCondition(String courseName, int courseNumber);

    @Insert("insert into course (course_name, course_number, professor, credit_hour, room, class_time) values " +
            "(#{courseName}, #{courseNumber}, #{professor}, #{creditHour}, #{room}, #{classTime})")
    void create(Course course);

    @Delete("delete from course where id = #{id}")
    void del(int id);

    @Select("WITH st AS (\n" +
            "    SELECT dept_id, schedule_status, COUNT(*) cnt\n" +
            "    FROM student s\n" +
            "    GROUP BY dept_id, schedule_status\n" +
            "    HAVING COUNT(*) > 0\n" +
            "    ORDER BY dept_id DESC\n" +
            ")\n" +
            "SELECT d.dept_name, st.schedule_status, st.cnt\n" +
            "FROM st\n" +
            "         LEFT JOIN department d\n" +
            "                   ON st.dept_id = d.id\n" +
            "ORDER BY d.dept_name DESC, st.cnt DESC;")
    List<DeptRegisStat> stat();
}