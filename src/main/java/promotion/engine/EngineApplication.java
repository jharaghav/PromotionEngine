package promotion.engine;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
@Slf4j
public class EngineApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(EngineApplication.class, args);
    }

}
