package com.learn.kafka.demo.listener;

import org.springframework.stereotype.Component;

/**
 * @author Cool
 * @create 2020-09-16 10:51
 */
@Component
public class KafkaConsumerListener {

    //partitionOffsets = @PartitionOffset(partition = "1", initialOffset = "4")
    /*@KafkaListener(containerFactory="kafkaListenerContainerFactory",topics = {"kafka-test1","kafka-test"})
    public String listen(ConsumerRecord<String,String> record){
        //String message = "topic:" + record.topic() + "\nkey:" + record.key() + "\nvalue:" + record.value() + "\noffset:" + record.offset()+"\npartition:"+record.partition();
        String message =  "(offset,partition),(" + record.offset()+","+record.partition()+")";
        message+="\ngroup:demo";
        message+="\n---demo(5)-------------------------------------------------------------------------------------";
        System.err.println(message);
        return message;
    }*/



    /*@KafkaListener(topics = {"kafka-test"}, containerFactory="kafkaListenerContainerFactory11",topicPartitions = {
            @TopicPartition(topic = "kafka-test",partitions = {"0"}),})
    public String listen11(ConsumerRecord<String, String> record) {
        //String message = "topic:" + record.topic() + "\nkey:" + record.key() + "\nvalue:" + record.value() + "\noffset:" + record.offset()+"\npartition:"+record.partition();
        String message =  "(offset,partition),(" + record.offset()+","+record.partition()+")";
        message+="\ngroup:test";
        message+="\nKafkaConsumerListener";
        message+="\n---test(0)-------------------------------------------------------------------------------------";
        System.out.println(message);
        return message;
    }

    @KafkaListener(topics = {"kafka-test"}, containerFactory="kafkaListenerContainerFactory11",topicPartitions = {
            @TopicPartition(topic = "kafka-test",partitions = {"1"}),})
    public String listen12(ConsumerRecord<String, String> record) {
        //String message = "topic:" + record.topic() + "\nkey:" + record.key() + "\nvalue:" + record.value() + "\noffset:" + record.offset()+"\npartition:"+record.partition();
        String message =  "(offset,partition),(" + record.offset()+","+record.partition()+")";
        message+="\ngroup:test";
        message+="\nKafkaConsumerListener";
        message+="\n---test(1)-------------------------------------------------------------------------------------";
        System.out.println(message);
        return message;
    }*/

    /*@KafkaListener(topics = {"kafka-test"}, containerFactory="kafkaListenerContainerFactory11",topicPartitions = {
            @TopicPartition(topic = "kafka-test",partitions = {"2"}),})
    public String listen13(ConsumerRecord<String, String> record) {
        //String message = "topic:" + record.topic() + "\nkey:" + record.key() + "\nvalue:" + record.value() + "\noffset:" + record.offset()+"\npartition:"+record.partition();
        String message =  "(offset,partition),(" + record.offset()+","+record.partition()+")";
        message+="\ngroup:test";
        message+="\nKafkaConsumerListener";
        message+="\n---test(2)-------------------------------------------------------------------------------------";
        System.out.println(message);
        return message;
    }*/

    /*
   @KafkaListener(topics = {"kafka-test1"},containerFactory="kafkaListenerContainerFactory11",topicPartitions = {
            @TopicPartition(topic = "kafka-test1",partitions = {"2"}),})
    public String listen21(ConsumerRecord<String, String> record) {
        //String message = "topic:" + record.topic() + "\nkey:" + record.key() + "\nvalue:" + record.value() + "\noffset:" + record.offset()+"\npartition:"+record.partition();
        String message =  "(offset,partition),(" + record.offset()+","+record.partition()+")";
        message+="\ngroup:test";
        message+="\nKafkaConsumerListener";
        message+="\n---test1(2)-------------------------------------------------------------------------------------";
        System.out.println(message);
        return message;
    }

    @KafkaListener(topics = {"kafka-test1"},containerFactory="kafkaListenerContainerFactory11",topicPartitions = {
            @TopicPartition(topic = "kafka-test1",partitions = {"0"}),})
    public String listen22(ConsumerRecord<String, String> record) {
        //String message = "topic:" + record.topic() + "\nkey:" + record.key() + "\nvalue:" + record.value() + "\noffset:" + record.offset()+"\npartition:"+record.partition();
        String message =  "(offset,partition),(" + record.offset()+","+record.partition()+")";
        message+="\ngroup:test";
        message+="\nKafkaConsumerListener";
        message+="\n---test1(0)-------------------------------------------------------------------------------------";
        System.out.println(message);
        return message;
    }*/

   /* @KafkaListener(topics = {"kafka-test1"},containerFactory="kafkaListenerContainerFactory11",topicPartitions = {
            @TopicPartition(topic = "kafka-test1",partitions = {"1"}),})
    public String listen23(ConsumerRecord<String, String> record) {
        String message =  "(offset,partition),(" + record.offset()+","+record.partition()+")";
        message+="\ngroup:test";
        message+="\n---test1(1)-------------------------------------------------------------------------------------";
        System.out.println(message);
        return message;
    }*/

    /*@KafkaListener(topics = {"kafka-test1"},containerFactory="kafkaListenerContainerFactory11",topicPartitions = {
            @TopicPartition(topic = "kafka-test1",partitions = {"1"}),})
    public String listen23(List<ConsumerRecord<String, String>> records) {
        String message = "";

        for (ConsumerRecord<?, ?> record : records) {
            Optional<?> kafkaMessage = Optional.ofNullable(record.value());
            if (kafkaMessage.isPresent()) {
                Object msg = record.value();
                String topic = record.topic();
                message =  "(offset,partition),(" + record.offset()+","+record.partition()+")";
                message+="\ngroup:test";
                message+="\n---test1(1)-------------------------------------------------------------------------------------";
                System.out.println(message);
                System.out.println(msg);
            }
        }
        return message;
    }*/

    /*@KafkaListener(groupId = "test", topicPartitions = {@TopicPartition(topic = "kafka-test", partitions = {"0"})})
    public void listenPartition0(ConsumerRecord<String, String> record) {
        Optional<String> kafkaMessage = Optional.ofNullable(record.value());
        System.err.println("Received: " + record);
        if (kafkaMessage.isPresent()) {
            String message = "(offset,partition),(" + record.offset() + "," + record.partition() + ")";
            message += "\ngroup:test";
            message += "\n---test1(1)-------------------------------------------------------------------------------------";
            System.out.println(message);
        }
    }
*/

}
