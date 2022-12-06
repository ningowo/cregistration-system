package teams.ksv.kwrs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import teams.ksv.kwrs.service.UserService;
import teams.ksv.kwrs.vo.CommonResponse;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/login")
    CommonResponse login(int id, String pwd) {
        return userService.login(id, pwd) ?
                CommonResponse.createSuccessResult(): new CommonResponse(-1, "Invalid info, please try again.");
    }

    @PostMapping("/signup")
    boolean signup() {
        return false;
    }

}
