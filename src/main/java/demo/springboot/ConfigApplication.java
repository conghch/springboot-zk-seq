package demo.springboot;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Spring Boot 应用启动类
 *
 */
@SpringBootApplication
public class ConfigApplication {

    public static ConfigurableApplicationContext applicationContext;
    public static void main(String[] args) {

        applicationContext = SpringApplication.run(ConfigApplication.class, args);
    }
}
