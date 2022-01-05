package ru.charov.mcthree;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication(exclude = {JacksonAutoConfiguration.class})
public class McthreeApplication {

    public static void main(String[] args) {
        SpringApplication.run(McthreeApplication.class, args);
    }

}
