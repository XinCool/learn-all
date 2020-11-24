package com.example.kafka.search.test.listener;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;

/**
 * @author Cool
 * @create 2020-09-16 10:51
 */
@Component
public class KafkaConsumer2Listener {

   @KafkaListener(topics = {"kafka-test1"}, containerFactory="kafkaListenerContainerFactory1",topicPartitions = {
            @TopicPartition(topic = "kafka-test1",partitions = {"2"}),})
    public String listen3(ConsumerRecord<String, String> record) {
        //String message = "topic:" + record.topic() + "\nkey:" + record.key() + "\nvalue:" + record.value() + "\noffset:" + record.offset()+"\npartition:"+record.partition();
        String message =  "(offset,partition),(" + record.offset()+","+record.partition()+")";
        message+="\ngroup:singleTest2";
        message+="\nKafkaConsumer2Listener";
        message+="\n---2test1(2)-------------------------------------------------------------------------------------";
        System.out.println(message);
        return message;
    }

    /*@KafkaListener(topics = {"kafka-test1"}, containerFactory="kafkaListenerContainerFactory1",topicPartitions = {
            @TopicPartition(topic = "kafka-test1",partitions = {"0"}),})
    public String listen0(ConsumerRecord<String, String> record) {
        //String message = "topic:" + record.topic() + "\nkey:" + record.key() + "\nvalue:" + record.value() + "\noffset:" + record.offset()+"\npartition:"+record.partition();
        String message =  "(offset,partition),(" + record.offset()+","+record.partition()+")";
        message+="\ngroup:singleTest2";
        message+="\nKafkaConsumer2Listener";
        message+="\n---2test1(0)-------------------------------------------------------------------------------------";
        System.out.println(message);
        return message;
    }

    @KafkaListener(topics = {"kafka-test1"}, containerFactory="kafkaListenerContainerFactory1",topicPartitions = {
            @TopicPartition(topic = "kafka-test1",partitions = {"1"}),})
    public String listen1(ConsumerRecord<String, String> record) {
        //String message = "topic:" + record.topic() + "\nkey:" + record.key() + "\nvalue:" + record.value() + "\noffset:" + record.offset()+"\npartition:"+record.partition();
        String message =  "(offset,partition),(" + record.offset()+","+record.partition()+")";
        message+="\ngroup:singleTest2";
        message+="\nKafkaConsumer2Listener";
        message+="\n---2test1(1)-------------------------------------------------------------------------------------";
        System.out.println(message);
        return message;
    }*/
}
