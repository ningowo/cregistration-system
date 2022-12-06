package teams.ksv.kwrs.mapper;

import org.apache.ibatis.annotations.*;
import teams.ksv.kwrs.dao.StudentCourse;

import java.util.List;

@Mapper
public interface ScheduleMapper {

    @Select("select course_id from student_course where student_id = #{sid}")
    List<Integer> getSchedule(int sid);

    @Select("select request_status from student where id = #{sid}")
    int getStatus(int sid);

    @Update("update student set request_status=#{status} where id = #{sid}")
    void setStatus(int sid, int status);

    @Insert("insert into student_course (student_id, course_id) values (#{sid}, #{courseId})")
    void insert(int sid, int courseId);

    @Delete("delete from student_course where student_id=#{sid}")
    void deleteSchedule(int sid);

}
