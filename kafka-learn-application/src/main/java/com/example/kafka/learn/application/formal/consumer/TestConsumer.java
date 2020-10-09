package com.example.kafka.learn.application.formal.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.util.Arrays;
import java.util.Properties;

/**
 * @author Cool
 * @create 2020-09-15 10:03
 */
public class TestConsumer implements Runnable {
    private final KafkaConsumer<String, String> consumer;
    private final String topic;
    private ConsumerRecords<String, String> msgList;

    public TestConsumer(String topic) {
        Properties properties = new Properties();
        properties.put("bootrap.server", "localhost:9092");
        properties.put("group.id", "test-consumer-group");
        properties.put("key.serializer", StringDeserializer.class.getName());
        properties.put("value.serializer", StringDeserializer.class.getName());
        properties.put("enable.auto.commit", "true");
        properties.put("auto.commit.interval.ms", "1000");
        properties.put("session.timeout.ms", "30000");
        properties.put("auto.offset.reset", "earliest");
        this.consumer = new KafkaConsumer<String, String>(properties);
        this.topic = topic;
        this.consumer.subscribe(Arrays.asList(topic));
    }

    @Override
    public void run() {

        int messageNo = 1;
        System.out.println("---------开始消费---------");
        try {
            for (; ; ) {
                msgList = consumer.poll(1000);
                if (null != msgList && msgList.count() > 0) {
                    for (ConsumerRecord<String, String> record : msgList) {
                        //消费100条就打印 ,但打印的数据不一定是这个规律的
                        if (messageNo % 100 == 0) {
                            System.out.println(messageNo + "=======receive: key = " + record.key() + ", value = " + record.value() + " offset===" + record.offset());
                        }
                        //当消费了1000条就退出
                        if (messageNo % 1000 == 0) {
                            break;
                        }
                        messageNo++;
                    }
                } else {
                    Thread.sleep(1000);
                }
            }

        } catch (Exception e) {

        }

    }

    public static void main(String[] args) {
        Thread thread = new Thread(new TestConsumer("kafka-demo"));
        thread.start();
    }
}
