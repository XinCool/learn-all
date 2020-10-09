package com.learn.kafka.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.*;

/**
 * @author Cool
 * @create 2020-09-16 9:44
 */
@RestController
@RequestMapping("/pro")
public class KafkaProducerController {
    @Autowired
    private KafkaTemplate kafkaTemplate;
    @Value("${kafka.producer.topic}")
    private String topic;

    @GetMapping("/send/{value}")
    @ResponseBody
    public String send(@PathVariable("value") String value){
        ListenableFuture send = kafkaTemplate.send(topic, value);
        return send.toString();
    }

    @GetMapping("/send/{tp}/{value}")
    @ResponseBody
    public String sendTest(@PathVariable("tp") String tp,@PathVariable("value") String value){
        ListenableFuture send = kafkaTemplate.send(tp, value);
        return send.toString();
    }

    @GetMapping("/send/{tp}/{partition}/{key}/{value}")
    @ResponseBody
    public String sendTestPar(@PathVariable("tp") String tp,@PathVariable("partition") Integer partition,@PathVariable("key") String key,@PathVariable("value") String value){
        //ListenableFuture send = kafkaTemplate.send(tp, value);
        ListenableFuture send = kafkaTemplate.send(tp, partition, key, value);
        return send.toString();
    }


}
