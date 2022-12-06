package teams.ksv.kwrs.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import teams.ksv.kwrs.dao.Message;

import java.util.Date;
import java.util.List;

@Mapper
public interface MessageMapper {

    @Insert("insert into message (sender_id, recipient_id, send_time, content, read_mark) values " +
            "(#{sender}, #{receiver}, #{date}, #{content}, 0);")
    void send(int sender, int receiver, Date date, String content);

    @Select("select * from message where recipient_id=#{receiver}")
    List<Message> fetch(int receiver);

    @Update("update message set read_mark=1 " +
            "where sender_id=#{sender} and recipient_id=#{receiver}")
    void markAsRead(long sender, long receiver);

}
