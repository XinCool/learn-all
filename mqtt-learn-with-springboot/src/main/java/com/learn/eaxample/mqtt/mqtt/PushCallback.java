package com.learn.eaxample.mqtt.mqtt;

import com.alibaba.fastjson.JSONObject;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * mqtt回调类
 * @author Cool
 * @create 2020-10-13 11:43
 */

@Configuration
public class PushCallback implements MqttCallback {

    @Autowired
    private MQTTSubsribe mqttSubsribe;

   /* @Autowired
    private RedisTemplate redisTemplate;*/

    //    定时任务——定时缓存查询的数据
    private ScheduledExecutorService scheduled;

    @Override
    public void connectionLost(Throwable throwable) {
        // 连接丢失后，一般在这里面进行重连
        System.out.println("连接断开，可以做重连");
        this.mqttSubsribe.startReconnect();
    }

    @Override
    public void messageArrived(String topic, MqttMessage message) throws Exception {
        // subscribe后得到的消息会执行到这里面
        System.out.println("接收消息主题 : " + topic);
        System.out.println("接收消息Qos : " + message.getQos());
        System.out.println("接收消息内容 : " + new String(message.getPayload()));
        String[] topics = topic.split("/");
        this.scheduled = Executors.newSingleThreadScheduledExecutor();
        //周期定时方法，可以在里面进行定时数据存储操作，我测试时是先将数据存储到了redis中，可做实时数据来用
        this.scheduled.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                String key = topics[0] + topics[1];
                String value = new String(message.getPayload());
                /*if (redisTemplate.hasKey(key)){
                    redisTemplate.delete(key);
                }
                redisTemplate.opsForValue().set(key,value);*/
                System.out.println("redis缓存数据"+value);
                //下面是我对数据的一些处理，仅供参考
                JSONObject jsonObject = JSONObject.parseObject(value);
                Map map = jsonObject;
                List<Map<String,Object>> list = (List<Map<String, Object>>) ((Map) map.get("lines")).get("data");
                System.out.println("-----------------------------"+list);
            }
            //此处 120为每120秒执行一次
        },0,120, TimeUnit.SECONDS);
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken token) {
        System.out.println("deliveryComplete---------" + token.isComplete());
    }
}
