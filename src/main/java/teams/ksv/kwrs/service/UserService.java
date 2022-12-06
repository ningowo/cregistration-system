package teams.ksv.kwrs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import teams.ksv.kwrs.mapper.UserMapper;

import java.io.ObjectInputStream;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public boolean login(int id, String pwd) {
        Object result = null;
        if (id <= 1000) {
            result = userMapper.login(id, pwd, "admin");
        } else if (id <= 100000) {
            result = userMapper.login(id, pwd, "advisor");
        } else {
            result = userMapper.login(id, pwd, "student");
        }

        return result != null;
    }

}
