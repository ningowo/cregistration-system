package teams.ksv.kwrs.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import teams.ksv.kwrs.model.Schedule;
import teams.ksv.kwrs.vo.CommonResponse;

@RestController
@RequestMapping("/schd")
public class ScheduleController {

    @GetMapping("/get")
    public CommonResponse getSchedule(int sid) {
        return null;
    }

    @GetMapping("/update")
    public CommonResponse updateSchedule(Schedule schedule) {
        return null;
    }

}
