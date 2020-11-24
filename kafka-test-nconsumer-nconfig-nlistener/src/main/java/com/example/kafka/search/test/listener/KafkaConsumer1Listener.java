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
public class KafkaConsumer1Listener {

    @KafkaListener(topics = {"kafka-test"}, containerFactory="kafkaListenerContainerFactory1",topicPartitions = {
            @TopicPartition(topic = "kafka-test",partitions = {"0"})})
    public String listen2(ConsumerRecord<String, String> record) {
        //String message = "topic:" + record.topic() + "\nkey:" + record.key() + "\nvalue:" + record.value() + "\noffset:" + record.offset()+"\npartition:"+record.partition();
        String message =  "(offset,partition),(" + record.offset()+","+record.partition()+")";
        message+="\ngroup:singleTest2";
        message+="\nKafkaConsumer1Listener";
        message+="\n---2test(0)-------------------------------------------------------------------------------------";
        System.out.println(message);
        return message;
    }

    /*@KafkaListener(topics = {"kafka-test"}, containerFactory="kafkaListenerContainerFactory",topicPartitions = {
            @TopicPartition(topic = "kafka-test",partitions = {"2"})})
    public String listen3(ConsumerRecord<String, String> record) {
        //String message = "topic:" + record.topic() + "\nkey:" + record.key() + "\nvalue:" + record.value() + "\noffset:" + record.offset()+"\npartition:"+record.partition();
        String message =  "(offset,partition),(" + record.offset()+","+record.partition()+")";
        message+="\ngroup:singleTest2";
        message+="\nKafkaConsumer1Listener";
        message+="\n---2test(2)-------------------------------------------------------------------------------------";
        System.out.println(message);
        return message;
    }*/

    /*@KafkaListener(topics = {"kafka-test"}, containerFactory="kafkaListenerContainerFactory",topicPartitions = {
            @TopicPartition(topic = "kafka-test",partitions = {"1"})})
    public String listen1(ConsumerRecord<String, String> record) {
        //String message = "topic:" + record.topic() + "\nkey:" + record.key() + "\nvalue:" + record.value() + "\noffset:" + record.offset()+"\npartition:"+record.partition();
        String message =  "(offset,partition),(" + record.offset()+","+record.partition()+")";
        message+="\ngroup:singleTest2";
        message+="\nKafkaConsumer1Listener";
        message+="\n---2test(1)-------------------------------------------------------------------------------------";
        System.out.println(message);
        return message;
    }*/
}
