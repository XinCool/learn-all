package com.example.ddd.infrastructure.entities.readonly;

import com.sie.iot.platform.asset.model.utils.enums.EntityType;
import com.sie.iot.platform.asset.model.utils.id.UUIDConverter;

import java.io.Serializable;

public class RedisTopicDeviceType_RO implements Serializable {

    private static final long serialVersionUID = -2839613238248388672L;

    public static final String QUERY_SQL = "SELECT r.from_id as device_type_id,t.name,t.topic_name,t.message_type,t.topic_type,t.device_type FROM topic t\n"
                                            +"\tINNER JOIN relation r ON r.to_id = t.id  and r.delete_flag=0\n"
                                            +"\tWHERE r.to_type = '" + EntityType.TOPIC.name() +"' AND r.from_type ='" + EntityType.DEVICE_SUPPLIER_TYPE.name() + "' and t.delete_flag=0   \n";

    private String deviceTypeId;

    private String name;

    private String topicName;

    private String messageType;

    private String topicType;

    private String deviceType;

    public String getDeviceTypeId() {
        return deviceTypeId;
    }

    public void setDeviceTypeId(String deviceTypeId) {
        this.deviceTypeId = deviceTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public String getTopicType() {
        return topicType;
    }

    public void setTopicType(String topicType) {
        this.topicType = topicType;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }
}
