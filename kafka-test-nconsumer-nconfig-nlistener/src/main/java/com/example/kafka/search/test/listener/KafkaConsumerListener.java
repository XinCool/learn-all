package com.example.kafka.search.test.listener;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author Cool
 * @create 2020-09-16 10:51
 */
@Component
public class KafkaConsumerListener {


    @KafkaListener(containerFactory="kafkaListenerContainerFactory",topics = {"kafka-test1","kafka-test"})
    public String listen5(ConsumerRecord<String,String> record){
        //String message = "topic:" + record.topic() + "\nkey:" + record.key() + "\nvalue:" + record.value() + "\noffset:" + record.offset()+"\npartition:"+record.partition();
        String message =  "(offset,partition),(" + record.offset()+","+record.partition()+")";
        message+="\ngroup:singleTest";
        message+="\n---demo()-------------------------------------------------------------------------------------";
        System.err.println(message);
        return message;
    }


    /*@KafkaListener(topics = {"kafka-test"}, containerFactory="kafkaListenerContainerFactory",topicPartitions = {
            @TopicPartition(topic = "kafka-test",partitions = {"0"}),})
    public String listen2(ConsumerRecord<String, String> record) {
        //String message = "topic:" + record.topic() + "\nkey:" + record.key() + "\nvalue:" + record.value() + "\noffset:" + record.offset()+"\npartition:"+record.partition();
        String message =  "(offset,partition),(" + record.offset()+","+record.partition()+")";
        message+="\ngroup:test";
        message+="\nKafkaConsumerListener";
        message+="\n---test(0)-------------------------------------------------------------------------------------";
        System.out.println(message);
        return message;
    }

    @KafkaListener(topics = {"kafka-test"}, containerFactory="kafkaListenerContainerFactory",topicPartitions = {
            @TopicPartition(topic = "kafka-test",partitions = {"2"}),})
    public String listen3(ConsumerRecord<String, String> record) {
        //String message = "topic:" + record.topic() + "\nkey:" + record.key() + "\nvalue:" + record.value() + "\noffset:" + record.offset()+"\npartition:"+record.partition();
        String message =  "(offset,partition),(" + record.offset()+","+record.partition()+")";
        message+="\ngroup:test";
        message+="\nKafkaConsumerListener";
        message+="\n---test(2)-------------------------------------------------------------------------------------";
        System.out.println(message);
        return message;
    }*/

}
