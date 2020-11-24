/*
package com.learn.kafka.demo.controller;

import com.learn.kafka.demo.config.KafkaConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.Map;

*/
/**
 * @author Cool
 * @create 2020-09-29 11:02
 *//*

@Component
public class ConsumerTest {
    private KafkaConsumer<String, String> kafkaConsumer;
    @Autowired
    private KafkaConsumerConfig kafkaConsumerConfig;

    @PostConstruct
    public void init() {

        Map<String, Object> props = kafkaConsumerConfig.consumerConfigs();
        props.put("compression.type", "gzip");
        props.put("linger.ms", "50");
        props.put("acks", "all");
        props.put("retries ", 30);
        props.put("reconnect.backoff.ms ", 20000);
        props.put("retry.backoff.ms", 20000);
        this.kafkaConsumer = new KafkaConsumer<>(props);
        this.kafkaConsumer.subscribe(Collections.singletonList("kafka-test"));
    }

    @EventListener(ApplicationReadyEvent.class)
    public void recieveMsg(ApplicationReadyEvent applicationReadyEvent) {
        ConsumerRecords<String, String> records = kafkaConsumer.poll(1000);
        for (ConsumerRecord<String, String> record : records) {
            String message = "topic:" + record.topic() + "\nkey:" + record.key() + "\nvalue:" + record.value() + "\noffset:" + record.offset() + "\npartition:" + record.partition();
            System.out.println(records);
        }
    }

}
*/
