package com.example.ddd.infrastructure.entities;

import com.alibaba.fastjson.annotation.JSONField;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * AlarmsHistoryEntity_HI Entity Object
 * Wed May 27 15:42:23 CST 2020  Auto Generate
 */
@Entity
@Table(name = "alarms_history")
public class AlarmsHistoryEntity_HI implements Serializable {
    private Long id; //主键
    private Long alarmsId; //规则id
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date creationDate; //创建时间
    private Long createdBy;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date lastUpdateDate; //更新日期
    private Long lastUpdatedBy;
    private Long lastUpdateLogin; //最后登录id
    private Integer versionNum; //版本号
    private Integer state; //状态
    private String description; //描述
    private Long operatorUserId;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date dataTime; //数据数据

    private String assetId;

    @Column(name = "device_id", nullable = false, length = 31)
    public String getDeviceId() {
        return deviceId;
    }
    public void setDataTime(Date dataTime) {
        this.dataTime = dataTime;
    }

    @Column(name="data_time", nullable=true, length=0)
    public Date getDataTime() {
        return dataTime;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    private String tenantId; //租户id

    @Column(name = "tenant_id",nullable = true,length = 31)
    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    /**
     * 设备id
     */
    private String deviceId;

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

    public void setAlarmsId(Long alarmsId) {
        this.alarmsId = alarmsId;
    }

    @Column(name = "alarms_id", nullable = true, length = 50)
    public Long getAlarmsId() {
        return alarmsId;
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

    public void setVersionNum(Integer versionNum) {
        this.versionNum = versionNum;
    }

    @Version
    @Column(name = "version_num", nullable = true, length = 11)
    public Integer getVersionNum() {
        return versionNum;
    }

    public void setState(Integer state) {
        this.state = state;
    }
    @Column(name = "asset_id", nullable = true, length = 35)
    public String getAssetId() {
        return assetId;
    }

    public void setAssetId(String assetId) {
        this.assetId = assetId;
    }
    @Column(name = "state", nullable = true, length = 11)
    public Integer getState() {
        return state;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "description", nullable = true, length = 255)
    public String getDescription() {
        return description;
    }

    public void setOperatorUserId(Long operatorUserId) {
        this.operatorUserId = operatorUserId;
    }

    @Transient
    public Long getOperatorUserId() {
        return operatorUserId;
    }
}
