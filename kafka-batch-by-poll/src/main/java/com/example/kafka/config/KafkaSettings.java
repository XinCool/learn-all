package com.example.kafka.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Properties;

@Component
public class KafkaSettings {

    private static final Logger log = LoggerFactory.getLogger(KafkaSettings.class);

    @Value("${kafka.bootstrap.servers}")
    private String servers;
    @Value("${kafka.acks}")
    private String acks;
    @Value("${kafka.retries}")
    private int retries;
    @Value("${kafka.batch.size}")
    private int batchSize;
    @Value("${kafka.linger.ms}")
    private long lingerMs;
    @Value("${kafka.buffer.memory}")
    private long bufferMemory;

    public KafkaSettings() {
    }

    public Properties toProps() {
        Properties props = new Properties();
        props.put("bootstrap.servers", this.servers);
        props.put("acks", this.acks);
        props.put("retries", this.retries);
        props.put("batch.size", this.batchSize);
        props.put("linger.ms", this.lingerMs);
        props.put("buffer.memory", this.bufferMemory);

        return props;
    }
}
