package com.example.ddd.infrastructure.entities;

import com.alibaba.fastjson.annotation.JSONField;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * TopicBakEntity_HI Entity Object
 * Fri Jul 10 10:03:54 CST 2020  Auto Generate
 */
@Entity
@Table(name = "topic")
public class TopicEntity_HI implements Serializable {
    private Long id;
    private String name; //名称
    private String topicName; //topicName
    private String tenantId; //所属租户ID
    private String messageType; //MQTT消息类型
    private String topicType; //Topic种类
    private String deviceType; //设备种类
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date creationDate; //创建时间
    private Long createdBy; //创建者
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date lastUpdateDate; //更新日期
    private Long lastUpdatedBy; //更新人
    private Long lastUpdateLogin; //最后登录id
    private Integer versionNum; //版本号
    private Long operatorUserId;
    private String topicTypeName;
    private Integer deleteFlag = 0; //删除标识 0表示未删除 1表示删除了

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @GenericGenerator(name = "redisGenerationId", strategy = "com.sie.iot.common.idgenerate.RedisGenerationId")
	@GeneratedValue(generator = "redisGenerationId")
    @Column(name = "id", nullable = false, length = 20)
    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "name", nullable = true, length = 500)
    public String getName() {
        return name;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    @Column(name = "topic_name", nullable = true, length = 500)
    public String getTopicName() {
        return topicName;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    @Column(name = "tenant_id", nullable = true, length = 20)
    public String getTenantId() {
        return tenantId;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    @Column(name = "message_type", nullable = true, length = 255)
    public String getMessageType() {
        return messageType;
    }

    public void setTopicType(String topicType) {
        this.topicType = topicType;
    }

    @Column(name = "topic_type", nullable = true, length = 255)
    public String getTopicType() {
        return topicType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    @Column(name = "topic_type_name", nullable = true, length = 255)
    public String getTopicTypeName() {
        return topicTypeName;
    }

    public void setTopicTypeName(String topicTypeName) {
        this.topicTypeName = topicTypeName;
    }

    @Column(name = "device_type", nullable = true, length = 255)
    public String getDeviceType() {
        return deviceType;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @Column(name = "creation_date", nullable = true, length = 0)
    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    @Column(name = "created_by", nullable = true, length = 20)
    public Long getCreatedBy() {
        return createdBy;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    @Column(name = "last_update_date", nullable = true, length = 0)
    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdatedBy(Long lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    @Column(name = "last_updated_by", nullable = true, length = 20)
    public Long getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdateLogin(Long lastUpdateLogin) {
        this.lastUpdateLogin = lastUpdateLogin;
    }

    @Column(name = "last_update_login", nullable = true, length = 20)
    public Long getLastUpdateLogin() {
        return lastUpdateLogin;
    }

    public void setVersionNum(Integer versionNum) {
        this.versionNum = versionNum;
    }

    @Version
    @Column(name = "version_num", nullable = true, length = 11)
    public Integer getVersionNum() {
        return versionNum;
    }

    public void setOperatorUserId(Long operatorUserId) {
        this.operatorUserId = operatorUserId;
    }

    @Transient
    public Long getOperatorUserId() {
        return operatorUserId;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    @Column(name = "delete_flag", nullable = true, length = 11)
    public Integer getDeleteFlag() {
        return deleteFlag;
    }
}
