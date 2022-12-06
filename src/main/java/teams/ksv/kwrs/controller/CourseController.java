package teams.ksv.kwrs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import teams.ksv.kwrs.dao.Course;
import teams.ksv.kwrs.service.CourseService;
import teams.ksv.kwrs.vo.CommonResponse;
import teams.ksv.kwrs.vo.CourseQuery;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    CourseService courseService;

    @GetMapping("/id/{id}")
    public CommonResponse<Course> get(@PathVariable int id) {
        return CommonResponse.createSuccessResult(courseService.queryById(id));
    }

    @GetMapping("/list")
    public CommonResponse<List<Course>> list(List<Integer> ids) {
        return CommonResponse.createSuccessResult(courseService.queryList(ids));
    }

    @GetMapping("/all")
    public CommonResponse<List<Course>> all() {
        return CommonResponse.createSuccessResult(courseService.queryAll());
    }

    @GetMapping("/cond")
    public CommonResponse<List<Course>> list(CourseQuery query) throws SQLException {
        return CommonResponse.createSuccessResult(courseService.queryByCondition(query));
    }


}
