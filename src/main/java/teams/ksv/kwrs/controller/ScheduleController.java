package teams.ksv.kwrs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import teams.ksv.kwrs.model.Schedule;
import teams.ksv.kwrs.service.ScheduleService;
import teams.ksv.kwrs.vo.CommonResponse;

@RestController
@RequestMapping("/schd")
public class ScheduleController {

    @Autowired
    ScheduleService scheduleService;

    @GetMapping("/get/{sid}")
    public CommonResponse getSchedule(@PathVariable int sid) {
        return CommonResponse.createSuccessResult(scheduleService.getSchedule(sid));
    }

    @GetMapping("/adApprove/{sid}")
    public CommonResponse advisorApprove(@PathVariable int sid) {
        scheduleService.approve(sid);
        return CommonResponse.createSuccessResult();
    }

    @GetMapping("/adReject/{sid}")
    public CommonResponse advisorReject(@PathVariable int sid) {
        scheduleService.reject(sid);
        return CommonResponse.createSuccessResult();
    }

    @PostMapping("/submit")
    public CommonResponse updateSchedule(@RequestBody Schedule schedule) {
        try {
            scheduleService.submit(schedule);
            return CommonResponse.createSuccessResult();
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResponse.createFailResult();
        }
    }

}
