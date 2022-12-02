package teams.ksv.kwrs.controller;

import org.springframework.web.bind.annotation.*;
import teams.ksv.kwrs.vo.CommonResponse;

@RestController
@RequestMapping("/admin")
public class AdminController {

    // crud to courses
    @PostMapping("/")
    public CommonResponse addCourse() {
        return null;
    }

    @DeleteMapping("/")
    public CommonResponse delCourse() {
        return null;
    }

    // some statistics
    @GetMapping("/1")
    public CommonResponse regisStat() {
        return null;
    }
}
