package com.example.kafka.learn.application.formal.product;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

/**
 * @author Cool
 * @create 2020-09-15 10:03
 */
public class TestProducer implements Runnable{
    private final KafkaProducer<String,String> producer;
    private final String topic;

    public TestProducer(String topic) {
        Properties properties = new Properties();
        properties.put("bootstrap.servers", "localhost:9092");
        properties.put("key.serializer", StringSerializer.class.getName());
        properties.put("value.serializer",StringSerializer.class.getName());
        this.producer = new KafkaProducer<String, String>(properties);
        this.topic = topic;
    }

    @Override
    public void run() {
        int count=0;
        for (;;){
            count++;
            if (count%2==1){
                System.out.println("Message："+"这是第"+count+"条数据！");
                producer.send(new ProducerRecord<String,String>(topic,"message","您好，这是第"+count+"条数据"));
            }
            if (count%4==0){
                System.out.println("成功发送"+count+"条！");
                break;
            }
        }
    }

    public static void main(String[] args) {
        TestProducer producer = new TestProducer("kafka-demo");
        Thread thread = new Thread(producer);
        thread.start();
    }
}
