package teams.ksv.kwrs.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@RestController("")
public class TestController {

    @Resource
    DataSource dataSource;

    @GetMapping("/test")
    public void test() throws SQLException {
        System.out.println("data source >>>>>>" + dataSource.getClass());
        Connection connection = dataSource.getConnection();
        System.out.println("connection >>>>>>>>>" + connection);
        System.out.println("connect addr >>>>>" + connection.getMetaData().getURL());
        connection.close();
    }

}
