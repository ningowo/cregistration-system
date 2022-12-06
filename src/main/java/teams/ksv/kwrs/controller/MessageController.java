package teams.ksv.kwrs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import teams.ksv.kwrs.dao.Message;
import teams.ksv.kwrs.service.MessageService;
import teams.ksv.kwrs.vo.CommonResponse;
import teams.ksv.kwrs.vo.MessageRequest;

import java.util.List;

@RestController
@RequestMapping("/msg")
public class MessageController {

    @Autowired
    MessageService messageService;


    @PostMapping("/send")
    public CommonResponse send(@RequestBody MessageRequest request) {
        return messageService.send(request.getSender(), request.getReceiver(), request.getContent()) ?
                CommonResponse.createSuccessResult() : CommonResponse.createFailResult();
    }

    @GetMapping("/fetch/{receiver}")
    public CommonResponse<List<Message>> fetch(@PathVariable int receiver) {
        return CommonResponse.createSuccessResult(messageService.fetch(receiver));
    }

}
