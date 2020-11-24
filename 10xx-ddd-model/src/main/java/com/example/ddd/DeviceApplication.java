package com.example.ddd;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource({"classpath*:com/example//config/spring.*.cfg.xml"})
//扫描范围 当前包和子包
@ComponentScan({"com.example.ddd.application","com.example.ddd.domain","com.example.ddd.interfaces","com.sie.iot.common.config","com.sie.iot.component.exception","com.example.ddd.infrastructure"})
//扫描范围当前类
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
public class DeviceApplication {

    public static void main(String[] args) {
        try{
            new SpringApplicationBuilder(DeviceApplication.class).run(args);
        }catch (Exception e){

        }
    }

}
