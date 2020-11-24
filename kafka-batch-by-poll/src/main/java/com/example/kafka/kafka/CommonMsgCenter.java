package com.example.kafka.kafka;

import com.alibaba.fastjson.JSONObject;
import com.example.kafka.config.KafkaSettings;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Collections;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 消息处理中心
 */
@Component
public class CommonMsgCenter {

    private static final Logger log = LoggerFactory.getLogger(CommonMsgCenter.class);

    @Value("${kafka.poll_interval}")
    private int pollDuration;
    @Value("${kafka.auto_commit_interval}")
    private int autoCommitInterval;
    @Value("${kafka.poll_records_pack_size}")
    private int pollRecordsPackSize;

    @Resource
    private KafkaSettings kafkaSettings;
    // 获取actor
    /*@Resource
    private ActorSystemContext actorContext;

    @Resource
    private CacheComponent cacheComponent;*/



    private Consumer<String, String> consumer;

    private ExecutorService mainConsumerExecutor = Executors.newSingleThreadExecutor();

    private volatile boolean stopped = false;

    @PostConstruct
    public void init() {
        String groupId = "common-message-center";
        Properties props = kafkaSettings.toProps();
        props.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, true);
        props.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, autoCommitInterval);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
        props.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, pollRecordsPackSize);
        this.consumer = new KafkaConsumer<>(props);
        this.consumer.subscribe(Collections.singletonList("common-message-center"));
    }

    @EventListener(ApplicationReadyEvent.class)
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        mainConsumerExecutor.execute(() -> {
            while (!stopped) {
                try {
                    ConsumerRecords<String, String> records = consumer.poll(pollDuration);
                    records.forEach(record -> {
                        try {
                            JSONObject msg = JSONObject.parseObject(record.value());
                            String mtCode = msg.getString("mtCode");
                            if (mtCode!=null){
                                //获取渠道记录和消息模板记录
                                /*MessageChannel messageChannel = cacheComponent.getMessageChanel(mtCode);
                                // 不同的通道 进入不同的actor
                                if (messageChannel.getChannel()==null&&messageChannel.getTemplate()!=null){
                                    actorContext.getWebPushActor().tell(msg, ActorRef.noSender());
                                }else{
                                    String channelType = messageChannel.getChannel().getChannelType();
                                    if (StrUtil.equals(channelType, ChannelTypeEnum.APP.getType(),true)){
                                        actorContext.getAppPushActor().tell(msg, ActorRef.noSender());
                                    }else if(StrUtil.equals(channelType, ChannelTypeEnum.SMS.getType(),true)){
                                        actorContext.getSmsActor().tell(msg, ActorRef.noSender());
                                    }else if(StrUtil.equals(channelType, ChannelTypeEnum.MAIL.getType(),true)){
                                        actorContext.getMailActor().tell(msg, ActorRef.noSender());
                                    }
                                }*/


                            }
                        } catch (Throwable e) {
                            log.warn("Failed to process the notification.", e);
                        }
                    });
                } catch (Exception e) {
                    log.warn("Failed to obtain messages from queue.", e);
                    try {
                        Thread.sleep(pollDuration);
                    } catch (InterruptedException e2) {
                        log.trace("Failed to wait until the server has capacity to handle new requests", e2);
                    }
                }
            }
        });

    }





}
