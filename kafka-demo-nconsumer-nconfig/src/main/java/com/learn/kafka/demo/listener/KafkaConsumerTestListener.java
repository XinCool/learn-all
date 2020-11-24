package com.learn.kafka.demo.listener;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;


@Component
public class KafkaConsumerTestListener {

/*@KafkaListener(topics = "${kafka.consumer.topic}")
    public String listen(ConsumerRecord<String,String> record){
        String message = "topic:"+record.topic()+"\nkey:"+record.key()+"\nvalue:"+record.value()+"\noffset:"+record.offset();
        System.err.println(message);
        return message;
    }*/


    //topicPartitions = {@TopicPartition(topic = "kafka-test",partitions = {"0","1"}),}
    @KafkaListener(topics = {"kafka-test"},containerFactory="kafkaListenerContainerFactory1",topicPartitions = {
            @TopicPartition(topic = "kafka-test",partitions = {"0","1"})})
    public String listen2(ConsumerRecord<String, String> record) {
        //String message = "topic:" + record.topic() + "\nkey:" + record.key() + "\nvalue:" + record.value() + "\noffset:" + record.offset()+"\npartition:"+record.partition();
        String message =  "(offset,partition),(" + record.offset()+","+record.partition()+")";
        message+="\ngroup:test";
        message+="\nKafkaConsumerTestListener";
        message+="\n---test(0,1)-------------------------------------------------------------------------------------";
        System.err.println(message);
        return message;
    }

    @KafkaListener(topics = {"kafka-test"},containerFactory="kafkaListenerContainerFactory1",topicPartitions = {
            @TopicPartition(topic = "kafka-test",partitions = {"2"})})
    public String listen3(ConsumerRecord<String, String> record) {
        //String message = "topic:" + record.topic() + "\nkey:" + record.key() + "\nvalue:" + record.value() + "\noffset:" + record.offset()+"\npartition:"+record.partition();
        String message =  "(offset,partition),(" + record.offset()+","+record.partition()+")";
        message+="\ngroup:test";
        message+="\nKafkaConsumerTestListener";
        message+="\n---test(2)-------------------------------------------------------------------------------------";
        System.err.println(message);
        return message;
    }
}
