package com.example.kafka.learn.application;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.util.concurrent.ListenableFuture;

@SpringBootTest
class KafkaLearnApplicationTests {

    public static KafkaTemplate<String,String> kafkaTemplate;

    @Value("$kafka.producer.topic")
    public static String topic;

    @Test
    void contextLoads() {
        ListenableFuture test_data = kafkaTemplate.send(topic, "test data");
    }

    public static void main(String[] args) {
        ListenableFuture test_data = kafkaTemplate.send(topic, "test data");
    }
}
