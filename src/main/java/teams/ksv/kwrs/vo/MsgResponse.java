package teams.ksv.kwrs.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@ToString
public class MsgResponse implements Serializable {

    List<Msg> msgList;

    public static class Msg {

        int senderId;

        String senderName;

        String content;
    }

}
