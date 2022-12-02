package teams.ksv.kwrs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import teams.ksv.kwrs.service.ScheduleService;
import teams.ksv.kwrs.vo.CommonResponse;
import teams.ksv.kwrs.vo.ScheduleRequest;

@RestController
@RequestMapping("/schd")
public class ScheduleController {

    @Autowired
    ScheduleService scheduleService;

    @GetMapping("/get/{sid}")
    public CommonResponse getSchedule(@PathVariable int sid) {
        return CommonResponse.createSuccessResult(scheduleService.getSchedule(sid));
    }

    @PostMapping("/update")
    public CommonResponse updateSchedule(@RequestBody ScheduleRequest request) {
        try {
            scheduleService.update(request.getSchedule(), request.getSid());
            return CommonResponse.createSuccessResult();
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResponse.createFailResult();
        }
    }

}