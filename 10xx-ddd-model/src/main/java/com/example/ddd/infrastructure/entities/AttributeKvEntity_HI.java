package com.example.ddd.infrastructure.entities;

import com.alibaba.fastjson.annotation.JSONField;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * AttributeKvEntity_HI Entity Object
 * Fri Mar 27 15:41:06 CST 2020  Auto Generate
 *
 * @author
 */
@Entity
@Table(name = "attribute_kv")
public class AttributeKvEntity_HI implements Serializable {
    private String entityType;
    private String entityId;
    private String attributeType;
    private String attributeKey;
    private String attributeName;
    private Boolean boolV;
    private String strV;
    private Long longV;
    private Double dblV;
    private Long lastUpdateTs;
    private Long operatorUserId;
    private String id;
    private String description;
    // 删除标识 0表示未删除 1表示删除了
    private Integer deleteFlag = 0;

    @Id
    @Column(name = "id", nullable = false, length = 31)
    @GenericGenerator(name = "idGenerator", strategy = "com.example.ddd.infrastructure.utils.id.CustomUUIDGenerator")
    @GeneratedValue(generator = "idGenerator")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setEntityType(String entityType) {
        this.entityType = entityType;
    }


    @Column(name = "entity_type", nullable = true, length = 255)
    public String getEntityType() {
        return entityType;
    }

    public void setEntityId(String entityId) {
        this.entityId = entityId;
    }

    //	@GenericGenerator(name = "idGenerator", strategy = "com.sie.iot.platform.asset.model.utils.id.CustomUUIDGenerator")
//	@GeneratedValue(generator = "idGenerator")
    @Column(name = "entity_id", nullable = true, length = 31)
    public String getEntityId() {
        return entityId;
    }

    public void setAttributeType(String attributeType) {
        this.attributeType = attributeType;
    }

    @Column(name = "attribute_type", nullable = true, length = 255)
    public String getAttributeType() {
        return attributeType;
    }

    public void setAttributeKey(String attributeKey) {
        this.attributeKey = attributeKey;
    }

    @Column(name = "attribute_key", nullable = true, length = 255)
    public String getAttributeKey() {
        return attributeKey;
    }

    public void setBoolV(Boolean boolV) {
        this.boolV = boolV;
    }

    @Column(name = "bool_v", nullable = true, length = 1)
    public Boolean getBoolV() {
        return boolV;
    }

    public void setStrV(String strV) {
        this.strV = strV;
    }

    @Column(name = "str_v", nullable = true, length = 0)
    public String getStrV() {
        return strV;
    }

    public void setLongV(Long longV) {
        this.longV = longV;
    }

    @Column(name = "long_v", nullable = true, length = 20)
    public Long getLongV() {
        return longV;
    }

    public void setDblV(Double dblV) {
        this.dblV = dblV;
    }

    @Column(name = "dbl_v", nullable = true, length = 0)
    public Double getDblV() {
        return dblV;
    }

    public void setLastUpdateTs(Long lastUpdateTs) {
        this.lastUpdateTs = lastUpdateTs;
    }

    @Column(name = "last_update_ts", nullable = true, length = 20)
    public Long getLastUpdateTs() {
        return lastUpdateTs;
    }

    public void setOperatorUserId(Long operatorUserId) {
        this.operatorUserId = operatorUserId;
    }

    @Transient
    public Long getOperatorUserId() {
        return operatorUserId;
    }

    @Column(name = "attribute_name", nullable = true, length = 50)
    public String getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    @Column(name = "delete_flag", nullable = true, length = 11)
    public Integer getDeleteFlag() {
        return deleteFlag;
    }
}
