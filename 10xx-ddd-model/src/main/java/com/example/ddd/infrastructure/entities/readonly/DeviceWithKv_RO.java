package com.example.ddd.infrastructure.entities.readonly;

import com.sie.iot.platform.asset.model.entities.AttributeKvEntity_HI;
import com.sie.iot.platform.asset.model.utils.enums.DeviceType;

import java.io.Serializable;
import java.util.List;

public class DeviceWithKv_RO implements Serializable {
//    public static final String QUERY_SQL = " SELECT\n" +
//            "\ta.id id,\n" +
//            "\ta.additional_info additionalInfo,\n" +
//            "\ta.customer_id customerId,\n" +
//            "\ta.type type,\n" +
//            "\ta.`name` name,\n" +
//            "\ta.search_text searchText,\n" +
//            "\ta.tenant_id tenantId\n" +
//            "FROM\n" +
//            "\tdevice AS a\n" +
//            "WHERE\n" +
//            "\t1 = 1 and a.type = '"+ DeviceType.gateway +"'  /*and*/ \n" +
//            "ORDER BY\n" +
//            "\ta.creation_date DESC";

    public static final String QUERY_SQL = " SELECT\n" +
            "\ta.id id,\n" +
            "\ta.additional_info additionalInfo,\n" +
            "\ta.customer_id customerId,\n" +
            "\ta.type type,\n" +
            "\ta.`name` NAME,\n" +
            "\ta.search_text searchText,\n" +
            "\ts.`name` assetName,\n" +
            "\ta.tenant_id tenantId \n" +
            "FROM\n" +
            "\tdevice AS a\n" +
            "\tLEFT JOIN relation r ON r.from_id = a.id and r.delete_flag=0 \n" +
            "\tAND r.from_type = 'DEVICE' \n" +
            "\tAND r.to_type = 'ASSET' \n" +
            "\tAND r.relation_type_group = 'COMMON' \n" +
            "\tAND r.relation_type = 'CollectorToAsset'\n" +
            "\tLEFT JOIN asset s ON s.id = r.to_id \n" +
            "WHERE\n" +
            "\t1 = 1     and   a.delete_flag=0   and a.type = '" + DeviceType.gateway + "'  /*and*/ \n" +
            "ORDER BY\n" +
            "\ta.creation_date DESC ";
         public static final String QUERY_APP_SQL = " SELECT\n" +
            "\ta.id id,\n" +
            "\ta.additional_info additionalInfo,\n" +
            "\ta.customer_id customerId,\n" +
            "\ta.type type,\n" +
            "\ta.`name` NAME,\n" +
            "\ta.search_text searchText,\n" +
            "\ta.tenant_id tenantId \n" +
            "FROM\n" +
            "\tdevice AS a\n" +
            "WHERE\n" +
            "\t1 = 1     and   a.delete_flag=0    /*and*/ \n" +
            "ORDER BY\n" +
            "\ta.creation_date DESC ";


    public static final String QUERY_KV_SQL = " SELECT\n" +
            "\ta.id id,\n" +
            "\ta.additional_info additionalInfo,\n" +
            "\ta.customer_id customerId,\n" +
            "\ta.type type,\n" +
            "\ta.`name` NAME,\n" +
            "\ta.search_text searchText,\n" +
            "\ts.`name` assetName,\n" +
            "\ts.id  as  assetId,\n" +
            "\ta.tenant_id tenantId, \n" +
            "\t  if((select count(id) from alarms_history  h   where   h.state=1  and h.device_id=a.id)>0,2,0 )  as status , \n" +
            "\t kv.attribute_name as attributeName ,kv.description as  description,kv.str_v  as strV\n"+
            "FROM\n" +
            "\tdevice AS a\n" +
            "\tLEFT JOIN relation r ON r.from_id = a.id and r.delete_flag=0 \n" +
            "\tAND r.from_type = 'DEVICE' \n" +
            "\tAND r.to_type = 'ASSET' \n" +
            "\tAND r.relation_type_group = 'COMMON' \n" +
            "\tAND r.relation_type = 'CollectorToAsset'\n" +
            "\tLEFT JOIN asset s ON s.id = r.to_id \n" +
            "\t left join (select * from  attribute_kv where entity_type='DEVICE' and attribute_key='mapPoint' and delete_flag=0 )  kv  on kv.entity_id=a.id  \n"+
            "WHERE\n" +
            "\t1 = 1  and   a.delete_flag=0  and a.type = '" + DeviceType.gateway + "'  /*and*/ \n" +
            "ORDER BY\n" +
            "\ta.creation_date DESC ";


    public static final String QUERY_COUNT_SQL = " SELECT\n" +
            "\t count(1)\n" +

            "FROM\n" +
            "\tdevice AS a\n" +
            "\tLEFT JOIN relation r ON r.from_id = a.id and r.delete_flag=0 \n" +
            "\tAND r.from_type = 'DEVICE' \n" +
            "\tAND r.to_type = 'ASSET' \n" +
            "\tAND r.relation_type_group = 'COMMON' \n" +
            "\tAND r.relation_type = 'CollectorToAsset'\n" +
            "\tLEFT JOIN asset s ON s.id = r.to_id \n" +
            "\t left join (select * from  attribute_kv where entity_type='DEVICE' and attribute_key='mapPoint'   and delete_flag=0 )  kv  on kv.entity_id=a.id  \n"+
            "WHERE\n" +
            "\t1 = 1  and   a.delete_flag=0   and a.type = '" + DeviceType.gateway + "'  /*and*/ \n" +
            "ORDER BY\n" +
            "\ta.creation_date DESC ";


    private String id;
    private String additionalInfo;
    private String customerId;
    private String type;
    private String name;
    private String searchText;
    private String tenantId;
    private String assetId;
    private String assetName;
    private Integer status = 0;
    private String attributeName;
    private String  description;
    private String  strV;

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

    public String getStrV() {
        return strV;
    }

    public void setStrV(String strV) {
        this.strV = strV;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    private List<AttributeKvEntity_HI> kvs;

    //private String mapPoint;


    public String getAssetName() {
        return assetName;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }

    public List<AttributeKvEntity_HI> getKvs() {
        return kvs;
    }

    public void setKvs(List<AttributeKvEntity_HI> kvs) {
        this.kvs = kvs;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSearchText() {
        return searchText;
    }

    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getAssetId() {
        return assetId;
    }

    public void setAssetId(String assetId) {
        this.assetId = assetId;
    }


}
