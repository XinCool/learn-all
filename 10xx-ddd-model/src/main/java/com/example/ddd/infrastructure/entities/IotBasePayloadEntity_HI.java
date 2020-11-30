package com.example.ddd.infrastructure.entities;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;


/**
 * @author yinzan
 */
@Entity
@Table(name = "iot_base_payload")
public class IotBasePayloadEntity_HI implements Serializable {
    private Long payloadId;
    private String attributeName;
    private String attributeKey;
    private String targetKey;
    private String deviceId;
    private String returnType;
    private Long parentId;
    private Integer level;
    private String encodeRuleId;
    private Long operatorUserId;
    private String mapping;
    private Long deviceSupplierId; //网关型号 暂时使用
    private Integer deleteFlag = 0; //删除标识 0表示未删除 1表示删除了



    private Integer assetPointId;



    /**
     * 是否可分析
     */
    private Boolean isAnalyzable;

    @Column(name = "mapping", nullable = true, length = 255)
    public String getMapping() {
        return mapping;
    }

    public void setMapping(String mapping) {
        this.mapping = mapping;
    }

    /**
     * 是否可解析
     *
     * @param payloadId
     */
    private Boolean resolvable;
    /**
     * 是否进入算法
     */
    private Boolean entryAlgorithm;

    @Column(name = "resolvable", length = 1)
    public Boolean getResolvable() {
        return resolvable;
    }

    public void setResolvable(Boolean resolvable) {
        this.resolvable = resolvable;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    @Column(name="delete_flag", nullable=true, length=11)
    public Integer getDeleteFlag() {
        return deleteFlag;
    }


    public void setPayloadId(Long payloadId) {
        this.payloadId = payloadId;
    }

    @Id
    @GenericGenerator(name = "redisGenerationId", strategy = "com.sie.iot.common.idgenerate.RedisGenerationId")
	@GeneratedValue(generator = "redisGenerationId")
    @Column(name = "payload_id", nullable = false, length = 20)
    public Long getPayloadId() {
        return payloadId;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }

    @Column(name = "attribute_name", nullable = true, length = 255)
    public String getAttributeName() {
        return attributeName;
    }

    public void setAttributeKey(String attributeKey) {
        this.attributeKey = attributeKey;
    }

    @Column(name = "attribute_key", nullable = true, length = 255)
    public String getAttributeKey() {
        return attributeKey;
    }

    @Column(name = "is_analyzable", nullable = true, length = 1)
    public Boolean getIsAnalyzable() {
        return isAnalyzable;
    }

    @Column(name = "entry_algorithm", nullable = true, length = 1)
    public Boolean getEntryAlgorithm() {
        return entryAlgorithm;
    }

    public void setEntryAlgorithm(Boolean entryAlgorithm) {
        this.entryAlgorithm = entryAlgorithm;
    }

    public void setIsAnalyzable(Boolean isAnalyzable) {
        this.isAnalyzable = isAnalyzable;
    }

    @Column(name = "device_supplier_type_id", nullable = true, length = 20)
    public Long getDeviceSupplierId() {
        return deviceSupplierId;
    }

    public void setDeviceSupplierId(Long deviceSupplierId) {
        this.deviceSupplierId = deviceSupplierId;
    }
    @Column(name = "asset_point_id", nullable = true, length = 11)
    public Integer getAssetPointId() {
        return assetPointId;
    }

    public void setAssetPointId(Integer assetPointId) {
        this.assetPointId = assetPointId;
    }
    public void setTargetKey(String targetKey) {
        this.targetKey = targetKey;
    }

    @Column(name = "target_key", nullable = true, length = 255)
    public String getTargetKey() {
        return targetKey;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    @Column(name = "device_id", nullable = true, length = 64)
    public String getDeviceId() {
        return deviceId;
    }

    public void setReturnType(String returnType) {
        this.returnType = returnType;
    }

    @Column(name = "return_type", nullable = true, length = 255)
    public String getReturnType() {
        return returnType;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    @Column(name = "parent_id", nullable = true, length = 11)
    public Long getParentId() {
        return parentId;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    @Column(name = "level", nullable = true, length = 11)
    public Integer getLevel() {
        return level;
    }

    public void setEncodeRuleId(String encodeRuleId) {
        this.encodeRuleId = encodeRuleId;
    }

    @Column(name = "encode_rule_id", nullable = true, length = 255)
    public String getEncodeRuleId() {
        return encodeRuleId;
    }

    public void setOperatorUserId(Long operatorUserId) {
        this.operatorUserId = operatorUserId;
    }

    @Transient
    public Long getOperatorUserId() {
        return operatorUserId;
    }
}
