package com.learn.eaxample.mqtt.mqtt;

import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * mqtt接收类
 * @author Cool
 * @create 2020-10-13 11:41
 */

@Component
public class MQTTSubsribe {

    @Value("${spring.mqtt.password}")
    private String password;

    @Value("${spring.mqtt.username}")
    private String username;

    @Value("${spring.mqtt.url}")
    private String url;
    //配置中的topic
    @Value("${spring.mqtt.default.topic}")
    private String defaultTopic;

    // 连接超时时间
    @Value("${spring.mqtt.completionTimeout}")
    private int completionTimeout;

    private String[] topics;

    private MqttClient client;

    private MqttConnectOptions mqttConnectOptions;

    @Autowired
    private PushCallback pushCallback;

    private ScheduledExecutorService scheduled;

    public void startReconnect() {
        this.scheduled = Executors.newSingleThreadScheduledExecutor();
        //    定时任务——重新连接mqtt服务器
        this.scheduled.scheduleAtFixedRate(new Runnable() {
            public void run() {
                if (!MQTTSubsribe.this.client.isConnected()) {
                    try {
                        MQTTSubsribe.this.client.connect(MQTTSubsribe.this.mqttConnectOptions);
                        System.out.println("---mqtt已经重新连接上---");
                        int[] Qos = new int[]{1};
                        MQTTSubsribe.this.client.subscribe(MQTTSubsribe.this.topics, Qos);
                    } catch (MqttSecurityException var2) {
                        var2.printStackTrace();
                    } catch (MqttException var3) {
                        var3.printStackTrace();
                    }
                }

            }
        }, 5000L, 10000L, TimeUnit.MILLISECONDS);
    }


    //	对mqttConnectOptions对象的常规设置
    public MqttConnectOptions getMqttConnectOptions() {
        this.mqttConnectOptions = new MqttConnectOptions();
        this.mqttConnectOptions.setCleanSession(true);
        this.mqttConnectOptions.setUserName(username);
        this.mqttConnectOptions.setPassword(password.toCharArray());
        this.mqttConnectOptions.setServerURIs(new String[]{url});
        this.mqttConnectOptions.setConnectionTimeout(completionTimeout);
        this.mqttConnectOptions.setKeepAliveInterval(2000);

        return mqttConnectOptions;
    }

    //	连接mqtt服务器订阅信息方法
    //	topic也可作为参数传入
    public void start(String topic) {

        try {
            this.client = new MqttClient(url, getClientId(), new MemoryPersistence());
            this.getMqttConnectOptions();
            this.client.setCallback(this.pushCallback);
            // MqttTopic topicMq = client.getTopic(defaultTopic);
            this.client.connect(this.mqttConnectOptions);
            //topics = defaultTopic.split(",");
            //订阅消息
            int[] Qos = {1};
            //可将订阅的一个或多个topic都存入数组中，同时订阅
            //String[] topic1 = {defaultTopic};
            topics = new String[]{defaultTopic};
            this.client.subscribe(topics, Qos);

            boolean connected = this.client.isConnected();
            String flag = connected ? "成功" : "失败";
            System.out.println("连接状态为：" + flag);
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

    //	随机生成唯一client.id方法
    public String getClientId() {
        String nums = "";
        String[] codeChars = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
                "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z",
                "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        for (int i = 0; i < 23; i++) {
            int charNum = (int) Math.floor(Math.random() * codeChars.length);
            nums = nums + codeChars[charNum];
        }
        return nums;
    }
}
