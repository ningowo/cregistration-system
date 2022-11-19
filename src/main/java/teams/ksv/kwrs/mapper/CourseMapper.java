package teams.ksv.kwrs.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import teams.ksv.kwrs.dao.Course;

import java.util.List;

@Mapper
public interface CourseMapper {

    @Select("select * from course where id = #{id}")
    Course queryById(int id);

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

}
//    and class_time=#{classTime}#{courseNumber}