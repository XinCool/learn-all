package com.learn.kafka.demo.listener;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author Cool
 * @create 2020-09-16 10:51
 */
@Component
public class KafkaConsumerListener {

    @KafkaListener(topics = "${kafka.consumer.topic}")
    public String listen(ConsumerRecord<String,String> record){
        String message = "topic:"+record.topic()+"\nkey:"+record.key()+"\nvalue:"+record.value()+"\noffset:"+record.offset();
        System.err.println(message);
        return message;
    }

}
