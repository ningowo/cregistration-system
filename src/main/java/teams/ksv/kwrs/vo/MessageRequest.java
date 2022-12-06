package teams.ksv.kwrs.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageRequest {
    int sender;

    int receiver;

    String content;
}
