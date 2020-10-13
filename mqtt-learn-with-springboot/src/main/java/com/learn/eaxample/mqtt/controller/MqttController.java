package com.learn.eaxample.mqtt.controller;

import com.learn.eaxample.mqtt.mqtt.MQTTSubsribe;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Cool
 * @create 2020-10-13 11:48
 */
@RequestMapping("/mqtt")
@RestController
public class MqttController {
    @Autowired
    private MQTTSubsribe mqtt;

    @RequestMapping(value = "/insertByMq",method = RequestMethod.GET)
    @ApiOperation(value = "订阅mqtt---测试")
    public String insertByMq(){
        mqtt.start("demo");
        return "success";
    }

}
