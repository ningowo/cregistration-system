package teams.ksv.kwrs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import teams.ksv.kwrs.dao.Course;
import teams.ksv.kwrs.service.AdminService;
import teams.ksv.kwrs.vo.CommonResponse;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    AdminService adminService;

    // crud to courses
    @PostMapping("/create")
    public CommonResponse createCourse(Course course) {
        return adminService.createCourse(course) ? CommonResponse.createSuccessResult(): CommonResponse.createFailResult();
    }

    @GetMapping("/del/{id}")
    public CommonResponse delCourse(@PathVariable Integer id) {
        return adminService.deleteCourse(id) ? CommonResponse.createSuccessResult(): CommonResponse.createFailResult();
    }

    // some statistics
    @GetMapping("/regisStat")
    public CommonResponse regisStat() {
        return CommonResponse.createSuccessResult(adminService.regisStat());
    }
}
