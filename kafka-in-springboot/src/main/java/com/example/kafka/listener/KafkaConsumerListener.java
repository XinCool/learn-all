package com.example.kafka.listener;


import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author Cool
 * @create 2020-09-15 14:43
 */
@Slf4j
@Component
public class KafkaConsumerListener {

    /*@KafkaListener(topics = "kafka-demo")
    public void onMessage(String message){
        // 消费消息
        // 这里为插入数据库代码
        //insertIntoDb(buffer);
        log.info("接收到消息：" + message);
    }*/

    @KafkaListener(topics = "kafka-demo",groupId = "test-consumer-group")
    //定义此消费者接收topic为“test_topic”的消息
    //监听服务器上的kafka是否有相关的消息发过来
    //record变量代表消息本身，可以通过ConsumerRecord<?,?>类型的record变量来打印接收的消息的各种信息
    public void listener (ConsumerRecord<?, ?> record) throws Exception {
        System.out.printf("topic = %s, offset = %d, value = %s \n", record.topic(), record.offset(), record.value());
    }

}
