package com.example.hibernatetemplate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value = "com.example.hibernatetemplate")
public class HibernatetemplateLearnApplication {

    public static void main(String[] args) {
        SpringApplication.run(HibernatetemplateLearnApplication.class, args);
    }

}
