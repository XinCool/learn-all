package com.example.ddd.infrastructure.entities;

import com.alibaba.fastjson.annotation.JSONField;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * BrokerEntity_HI Entity Object
 * Tue Apr 28 11:45:21 CST 2020  Auto Generate
 */
@Entity
@Table(name = "broker")
public class BrokerEntity_HI implements Serializable {
    private Long id; //主键
    private String brokerType; //类型 1.应用对接信息、2.设备对接信息
    private String domainName;
    private String ipAddress; //ip地址
    private Long brokerPort; //端口
    private String agreementType; //协议类型
    private String brokerStatus; //状态 1.运行中、2.维护中
    private String description; //描述
    private String tenantId; //租户id
    private Integer deleteFlag = 0; //删除标识 0表示未删除 1表示删除了

    @Version
    @Column(name = "version_num", nullable = false, length = 11)
    public Integer getVersionNum() {
        return versionNum;
    }

    public void setVersionNum(Integer versionNum) {
        this.versionNum = versionNum;
    }

    private Integer versionNum; //版本号
    /**
     * broker名称
     */
    private String brokerName;

    @Column(name = "broker_name", nullable = true, length = 50)
    public String getBrokerName() {
        return brokerName;
    }

    public void setBrokerName(String brokerName) {
        this.brokerName = brokerName;
    }

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date creationDate; //创建时间
    private Long createdBy;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date lastUpdateDate; //更新日期
    private Long lastUpdatedBy; //更新人
    private Long lastUpdateLogin; //最后登录id
    private Long operatorUserId;

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @GenericGenerator(name = "idGenerator", strategy = "com.example.ddd.infrastructure.utils.id.CustomUUIDGenerator")
	@GeneratedValue(generator = "redisGenerationId")
    @Column(name = "id", nullable = false, length = 11)
    public Long getId() {
        return id;
    }

    public void setBrokerType(String brokerType) {
        this.brokerType = brokerType;
    }

    @Column(name = "broker_type", nullable = true, length = 55)
    public String getBrokerType() {
        return brokerType;
    }

    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }

    @Column(name = "domain_name", nullable = true, length = 50)
    public String getDomainName() {
        return domainName;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    @Column(name = "ip_address", nullable = true, length = 55)
    public String getIpAddress() {
        return ipAddress;
    }
    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    @Column(name="delete_flag", nullable=true, length=11)
    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setBrokerPort(Long brokerPort) {
        this.brokerPort = brokerPort;
    }

    @Column(name = "broker_port", nullable = true, length = 11)
    public Long getBrokerPort() {
        return brokerPort;
    }

    public void setAgreementType(String agreementType) {
        this.agreementType = agreementType;
    }

    @Column(name = "agreement_type", nullable = true, length = 50)
    public String getAgreementType() {
        return agreementType;
    }

    public void setBrokerStatus(String brokerStatus) {
        this.brokerStatus = brokerStatus;
    }

    @Column(name = "broker_status", nullable = true, length = 255)
    public String getBrokerStatus() {
        return brokerStatus;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "description", nullable = true, length = 1000)
    public String getDescription() {
        return description;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    @Column(name = "tenant_id", nullable = true, length = 31)
    public String getTenantId() {
        return tenantId;
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

    @Column(name = "created_by", nullable = true, length = 11)
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

    @Column(name = "last_updated_by", nullable = true, length = 11)
    public Long getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdateLogin(Long lastUpdateLogin) {
        this.lastUpdateLogin = lastUpdateLogin;
    }

    @Column(name = "last_update_login", nullable = true, length = 11)
    public Long getLastUpdateLogin() {
        return lastUpdateLogin;
    }

    public void setOperatorUserId(Long operatorUserId) {
        this.operatorUserId = operatorUserId;
    }

    @Transient
    public Long getOperatorUserId() {
        return operatorUserId;
    }
}
