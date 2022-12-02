package teams.ksv.kwrs.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import teams.ksv.kwrs.vo.CommonResponse;

@RestController
@RequestMapping("/admin")
public class AdminController {

    // some statistics
    @GetMapping("/")
    public CommonResponse get() {
        return null;
    }

    // some statistics
    @GetMapping("/1")
    public CommonResponse get1() {
        return null;
    }
}
