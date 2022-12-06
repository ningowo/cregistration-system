package teams.ksv.kwrs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import teams.ksv.kwrs.dao.Message;
import teams.ksv.kwrs.mapper.MessageMapper;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MessageService {

    @Autowired
    MessageMapper messageMapper;

    public boolean send(int sender, int receiver, String content) {
        try {
            messageMapper.send(sender, receiver, new Date(System.currentTimeMillis()), content);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Message> fetch(int receiver) {
        List<Message> msgList = messageMapper.fetch(receiver);
        for (Message message : msgList) {
            messageMapper.markAsRead(message.getSenderId(), message.getRecipientId());
        }
        return msgList;
    }

}
