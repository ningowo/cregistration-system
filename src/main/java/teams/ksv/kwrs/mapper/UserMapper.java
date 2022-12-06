package teams.ksv.kwrs.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.io.ObjectInputStream;

@Mapper
public interface UserMapper {

    @Select("select * from ${tableName} where id=#{id} and pwd=#{pwd};")
    Object login(int id, String pwd, String tableName);

}
