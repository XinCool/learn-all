package com.learn.kafka.demo.listener;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;

/**
 * @author Cool
 * @create 2020-09-16 10:51
 */
@Component
public class KafkaConsumerListener {

    /*@KafkaListener(topics = "${kafka.consumer.topic}")
    public String listen(ConsumerRecord<String,String> record){
        String message = "topic:"+record.topic()+"\nkey:"+record.key()+"\nvalue:"+record.value()+"\noffset:"+record.offset();
        System.err.println(message);
        return message;
    }*/

    @KafkaListener(containerFactory="kafkaListenerContainerFactory",topicPartitions = {
            @TopicPartition(topic = "kafka-test",partitions = {"0","2"}),})
    public String listen(ConsumerRecord<String,String> record){
        //String message = "topic:" + record.topic() + "\nkey:" + record.key() + "\nvalue:" + record.value() + "\noffset:" + record.offset()+"\npartition:"+record.partition();
        String message =  "(offset,partition),(" + record.offset()+","+record.partition()+")";
        message+="\ngroup:demo";
        message+="\nKafkaConsumerListener";
        message+="\n---demo(0,2)-------------------------------------------------------------------------------------";
        System.out.println(message);
        return message;
    }


   /* @KafkaListener(topics = {"kafka-test"}, containerFactory="kafkaListenerContainerFactory1")
    public String listen2(ConsumerRecord<String, String> record) {
        String message = "topic:" + record.topic() + "\nkey:" + record.key() + "\nvalue:" + record.value() + "\noffset:" + record.offset();
        System.err.println("-------------------------------------------------------------------------------------");
        System.err.println("group:test");
        System.err.println(message);
        return message;
    }*/


}
