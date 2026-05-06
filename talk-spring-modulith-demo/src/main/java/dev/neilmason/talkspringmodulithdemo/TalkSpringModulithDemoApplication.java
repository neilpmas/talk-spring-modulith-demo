package dev.neilmason.talkspringmodulithdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class TalkSpringModulithDemoApplication {

    static void main(String[] args) {
        SpringApplication.run(TalkSpringModulithDemoApplication.class, args);
    }

}
