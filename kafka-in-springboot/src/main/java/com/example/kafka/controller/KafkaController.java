package com.example.kafka.controller;


import com.example.kafka.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

/**
 * @author Cool
 * @create 2020-09-15 14:39
 */
@RestController
@RequestMapping("/kafka")
public class KafkaController {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @GetMapping("/send")
    @ResponseBody
    public String  sendMeg() throws ExecutionException, InterruptedException {
        Message<String> message = new Message<String>();
        message.setId("001");
        message.setContent("cxx");
        kafkaTemplate.send("kafka-demo", 0, "name", "cxx").get();
        return "ok";
    }


}
