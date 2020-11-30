package com.example.ddd.infrastructure.entities.readonly;


import java.io.Serializable;

/**
 * IotBasePayloadEntity_HI_RO Entity Object
 * Tue Jun 16 10:31:30 CST 2020  Auto Generate
 */

public class IotBasePayloadEntity_HI_RO implements Serializable {

    public static final String QUERY_SQL = "SELECT\n" +
            "\tpayload_id,attribute_name,attribute_key,target_key,return_type," +
            "level,encode_rule_id,parent_id,mapping,o.point_key as pointKey ," +
            "o.id as pointId , o.point_name as  pointName,p.is_analyzable as isAnalyzable  , " +
            "p.resolvable  as  resolvable      ,  p.entry_algorithm as  entryAlgorithm , t.type_code as assetTypeCode   \n" +
            "FROM\n" +
            "\tiot_base_payload p\n" +
            "LEFT JOIN device_supplier_type d ON p.device_supplier_type_id = d.id  " +
            "left join asset_point  o on  o.id=p.asset_point_id \n" +
            "left join asset_type t  on t.type_code=o.asset_type \n" +
            "where 1=1 and p.delete_flag=0 \n";


    public static final String QUERY_ASSET_SQL = "SELECT\n" +
            "\tpayload_id,attribute_name,attribute_key,target_key,return_type,level,encode_rule_id,mapping,r.from_id as deviceId,o.point_key as pointKey ,o.id as pointId , o.point_name as  pointName\n" +
            "FROM\n" +
            "\tiot_base_payload p\n" +
            "LEFT JOIN device_supplier_type d ON p.device_supplier_type_id = d.id\n" +
            "LEFT JOIN relation r ON r.to_id = d.id\n" +
            "left join asset_point  o on  o.id=p.asset_point_id\n" +
            "AND r.to_type = 'DEVICE_SUPPLIER_TYPE'\n" +
            "AND r.from_type = 'DEVICE'\n" +
            "AND r.relation_type = 'DeviceToDeviceSupplierType'\n" +
            "AND r.relation_type_group = 'DEVICE_DEVICE_SUPPLIER_TYPE'  and r.delete_flag=0   where  1=1  and p.delete_flag=0 \n";


    private Long payloadId;
    private String pointKey;
    private String pointName;
    private Long pointId;
    private String attributeName;
    private String attributeKey;
    private String targetKey;
    private String deviceId;
    private String returnType;
    private Integer parentId;
    private String level;
    private String encodeRuleId;
    private String assetTypeCode;
    private Long operatorUserId;

    public Boolean getIsAnalyzable() {
        return isAnalyzable;
    }

    public void setIsAnalyzable(Boolean IsAnalyzable) {
        isAnalyzable = IsAnalyzable;
    }

    private Boolean isAnalyzable;
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




    private String mapping;


    public Long getPayloadId() {
        return payloadId;
    }

    public void setPayloadId(Long payloadId) {
        this.payloadId = payloadId;
    }



    public Boolean getEntryAlgorithm() {
        return entryAlgorithm;
    }

    public void setEntryAlgorithm(Boolean entryAlgorithm) {
        this.entryAlgorithm = entryAlgorithm;
    }



    public Boolean getResolvable() {
        return resolvable;
    }

    public void setResolvable(Boolean resolvable) {
        this.resolvable = resolvable;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }


    public String getAttributeName() {
        return attributeName;
    }

    public void setAttributeKey(String attributeKey) {
        this.attributeKey = attributeKey;
    }


    public String getAttributeKey() {
        return attributeKey;
    }

    public void setTargetKey(String targetKey) {
        this.targetKey = targetKey;
    }


    public String getTargetKey() {
        return targetKey;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }


    public String getDeviceId() {
        return deviceId;
    }

    public void setReturnType(String returnType) {
        this.returnType = returnType;
    }


    public String getReturnType() {
        return returnType;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }


    public Integer getParentId() {
        return parentId;
    }

    public void setLevel(String level) {
        this.level = level;
    }


    public String getLevel() {
        return level;
    }

    public void setEncodeRuleId(String encodeRuleId) {
        this.encodeRuleId = encodeRuleId;
    }


    public String getEncodeRuleId() {
        return encodeRuleId;
    }

    public void setOperatorUserId(Long operatorUserId) {
        this.operatorUserId = operatorUserId;
    }


    public Long getOperatorUserId() {
        return operatorUserId;
    }

    public String getMapping() {
        return mapping;
    }

    public void setMapping(String mapping) {
        this.mapping = mapping;
    }


    public String getPointKey() {
        return pointKey;
    }

    public void setPointKey(String pointKey) {
        this.pointKey = pointKey;
    }

    public String getPointName() {
        return pointName;
    }

    public void setPointName(String pointName) {
        this.pointName = pointName;
    }

    public Long getPointId() {
        return pointId;
    }

    public void setPointId(Long pointId) {
        this.pointId = pointId;
    }

    public String getAssetTypeCode() {
        return assetTypeCode;
    }

    public void setAssetTypeCode(String assetTypeCode) {
        this.assetTypeCode = assetTypeCode;
    }
}
