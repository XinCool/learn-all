package com.example.ddd.infrastructure.entities;

import com.alibaba.fastjson.annotation.JSONField;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author
 * @create 2020-11-16
 */
@Entity
@Table(name = "device")
public class DeviceEntity_HI implements Serializable {
    private String id;
    private String additionalInfo;
    private String customerId;
    private String type;
    private String name;
    private String searchText;
    private String tenantId;
    private Long operatorUserId;
    private Long deviceTypeId;
    //  删除标识 0表示未删除 1表示删除了
    private Integer deleteFlag = 0;

    public void setId(String id) {
        this.id = id;
    }

    @Id
    @GenericGenerator(name = "idGenerator", strategy = "com.example.ddd.infrastructure.utils.id.CustomUUIDGenerator")
    @GeneratedValue(generator = "idGenerator")
    @Column(name = "id", nullable = false, length = 31)
    public String getId() {
        return id;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    @Column(name = "additional_info", nullable = true, length = 0)
    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    @Column(name = "customer_id", nullable = true, length = 31)
    public String getCustomerId() {
        return customerId;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Column(name = "type", nullable = true, length = 255)
    public String getType() {
        return type;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "`name`", nullable = true, length = 255)
    public String getName() {
        return name;
    }

    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }

    @Column(name = "search_text", nullable = true, length = 255)
    public String getSearchText() {
        return searchText;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    @Column(name = "tenant_id", nullable = true, length = 31)
    public String getTenantId() {
        return tenantId;
    }

    public void setOperatorUserId(Long operatorUserId) {
        this.operatorUserId = operatorUserId;
    }

    @Transient
    public Long getOperatorUserId() {
        return operatorUserId;
    }

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date creationDate; //创建日期
    private Long createdBy; //创建人
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date lastUpdateDate; //更新日期
    private Long lastUpdatedBy; //更新人
    private Long lastUpdateLogin; //最后登录ID
    private Integer versionNum; //版本号

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
    @Column(name = "version_num", nullable = false, length = 11)
    public Integer getVersionNum() {
        return versionNum;
    }

    @Column(name = "device_type_id", nullable = true, length = 20)
    public Long getDeviceTypeId() {
        return deviceTypeId;
    }

    public void setDeviceTypeId(Long deviceTypeId) {
        this.deviceTypeId = deviceTypeId;
    }


    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    @Column(name = "delete_flag", nullable = true, length = 11)
    public Integer getDeleteFlag() {
        return deleteFlag;
    }

}
