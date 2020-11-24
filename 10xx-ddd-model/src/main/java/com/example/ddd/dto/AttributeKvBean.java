package com.example.ddd.dto;

import com.sie.iot.common.bean.ReqeustCommonDataBean;

public class AttributeKvBean extends ReqeustCommonDataBean {
    private String id;
    private String entityType;
    private String entityId;
    private String attributeType;
    private String attributeName;
    private String attributeKey;
    private Boolean boolV;
    private String strV;
    private Long longV;
    private Double dblV;
    private Long operatorUserId;
    private String description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEntityType() {
        return entityType;
    }

    public void setEntityType(String entityType) {
        this.entityType = entityType;
    }

    public String getEntityId() {
        return entityId;
    }

    public void setEntityId(String entityId) {
        this.entityId = entityId;
    }

    public String getAttributeType() {
        return attributeType;
    }

    public void setAttributeType(String attributeType) {
        this.attributeType = attributeType;
    }

    public String getAttributeKey() {
        return attributeKey;
    }

    public void setAttributeKey(String attributeKey) {
        this.attributeKey = attributeKey;
    }

    public Boolean getBoolV() {
        return boolV;
    }

    public void setBoolV(Boolean boolV) {
        this.boolV = boolV;
    }

    public String getStrV() {
        return strV;
    }

    public void setStrV(String strV) {
        this.strV = strV;
    }

    public Long getLongV() {
        return longV;
    }

    public void setLongV(Long longV) {
        this.longV = longV;
    }

    public Double getDblV() {
        return dblV;
    }

    public void setDblV(Double dblV) {
        this.dblV = dblV;
    }

    public Long getOperatorUserId() {
        return operatorUserId;
    }

    public void setOperatorUserId(Long operatorUserId) {
        this.operatorUserId = operatorUserId;
    }


}
