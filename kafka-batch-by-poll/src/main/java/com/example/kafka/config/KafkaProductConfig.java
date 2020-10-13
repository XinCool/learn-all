package com.example.kafka.config;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Cool
 * @create 2020-09-16 9:45
 */
@Configuration
@EnableKafka
public class KafkaProductConfig {
    @Value("${kafka.producer.server}")
    private String server;
    /*@Value("${kafka.producer.topic}")
    private String topic;*/
    @Value("${kafka.producer.retries}")
    private int retries;
    @Value("${kafka.producer.batch.size}")
    private String batchSize;
    @Value("${kafka.producer.linger}")
    private String linger;
    @Value("${kafka.producer.buffer.memory}")
    private String bufferMemory;

    public Map<String,Object> productConfigs() {
        Map<String,Object> properties = new HashMap<>();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,server);
        properties.put(ProducerConfig.BATCH_SIZE_CONFIG,batchSize);
        properties.put(ProducerConfig.BUFFER_MEMORY_CONFIG,bufferMemory);
        properties.put(ProducerConfig.LINGER_MS_CONFIG,linger);
        properties.put(ProducerConfig.RETRIES_CONFIG,retries);
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,StringSerializer.class.getName());
        return properties;

    }


    public ProducerFactory<String, String> producerFactory(){
        return new DefaultKafkaProducerFactory<String,String>(productConfigs());
    }

    @Bean
    public KafkaTemplate<String,String> kafkaTemplate(){
        return new KafkaTemplate<String, String>(producerFactory());
    }

}
