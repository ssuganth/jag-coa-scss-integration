package ca.bc.gov.open.Scss;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class ScssApplication {

    public static void main(String[] args) {

        SpringApplication.run(ScssApplication.class, args);
        log.error("I am up");
    }
}
