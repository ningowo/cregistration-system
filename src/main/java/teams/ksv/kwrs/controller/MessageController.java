package teams.ksv.kwrs.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import teams.ksv.kwrs.vo.CommonResponse;
import teams.ksv.kwrs.vo.MsgResponse;

@RestController
@RequestMapping("/msg")
public class MessageController {

    @PostMapping("/send")
    public CommonResponse send(int sender, int receiver, String content) {
        // add a line in message table
        return null;
    }

    // create special response as needed, like MsgResponse
    @GetMapping("/fetch")
    public CommonResponse<MsgResponse> fetch(int receiver) {
        // query a line and mark read

        return null;
    }

}
