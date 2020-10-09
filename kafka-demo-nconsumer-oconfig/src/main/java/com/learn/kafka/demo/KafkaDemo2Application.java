package com.learn.kafka.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class KafkaDemo2Application {

    public static void main(String[] args) {
        SpringApplication.run(KafkaDemo2Application.class, args);
    }

}
