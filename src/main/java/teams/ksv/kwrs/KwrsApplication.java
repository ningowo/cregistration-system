package teams.ksv.kwrs;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;

@MapperScan
@SpringBootApplication()
public class KwrsApplication {

    public static void main(String[] args) throws SQLException {

        SpringApplication.run(KwrsApplication.class, args);
    }

}
