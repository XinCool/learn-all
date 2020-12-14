package com.example.ddd;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SuppressWarnings("SpringBootApplicationSetup")
@SpringBootApplication
@ImportResource({"classpath*:config/spring.*.cfg.xml"})
//扫描范围 当前包和子包
@ComponentScan({"com.sie.iot.common.model", "com.sie.iot.common.config", "com.example.ddd.infrastructure", "com.example.ddd.application.service", "com.example.ddd.domain", "com.example.ddd.interfaces.controller", "com.sie.iot.component.exception", "cn.hutool.extra.spring"})
//扫描范围当前类
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
public class DddApplication {

    public static void main(String[] args) {
        try {
            new SpringApplicationBuilder(DddApplication.class).run(args);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
