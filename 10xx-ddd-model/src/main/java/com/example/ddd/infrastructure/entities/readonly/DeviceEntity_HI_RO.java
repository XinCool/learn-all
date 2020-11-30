package com.example.ddd.infrastructure.entities.readonly;

import com.sie.iot.platform.asset.model.utils.enums.AttributeKeyType;
import com.sie.iot.platform.asset.model.utils.enums.DeviceType;
import com.sie.iot.platform.asset.model.utils.enums.EntityType;

import java.io.Serializable;

public class  DeviceEntity_HI_RO implements Serializable {
    public static final String QUERY_SQL = "  SELECT\n" +
            "a.id id,\n" +
            "a.additional_info additionalInfo,\n" +
            "a.customer_id customerId,\n" +
            "a.type type,\n" +
            "a.`name` `name`,\n" +
            "a.search_text searchText,\n" +
            "dc.credentials_id credentialsId,\n" +
            "dc.credentials_type credentialsType,\n" +
            "a.tenant_id tenantId,\n" +
            "(\n" +
            "\t\tSELECT\n" +
            "\t\t\tk.long_v\n" +
            "\t\tFROM\n" +
            "\t\t\tattribute_kv k\n" +
            "\t\tWHERE\n" +
            "\t\t\tk.entity_id = a.id   and  k.delete_flag=0\n" +
            "\t\tAND k.attribute_key = 'version'\n" +
            "\t\tAND k.attribute_type = 'SHARED_SCOPE'\n" +
            "\t\tAND k.entity_type = 'DEVICE'\n" +
            "\n" +
            "\t) AS version , \n " +
            "(\n" +
            "\t\tSELECT\n" +
            "\t\t\tcount(1) AS col_0_0_\n" +
            "\t\tFROM\n" +
            "\t\t\trelation r\n" +
            "\t\tWHERE\n" +
            "\t\t\tr.from_type = 'DEVICE'  and  r.delete_flag=0\n" +
            "\t\tAND r.from_id = a.id\n" +
            "\t\tAND r.to_type = 'BROKER'\n" +
            "\t\tAND r.relation_type_group = 'BROKER'\n" +
            "\t\tAND r.relation_type = 'DeviceToBroker'\n" +
            "\t) AS brokerStatus "+
            ",\n" +
            "\t(\n" +
            "\t\tSELECT\n" +
            "\t\t\tto_id\n" +
            "\t\tFROM\n" +
            "\t\t\trelation r\n" +
            "\t\tWHERE\n" +
            "\t\tr.from_type = 'DEVICE' and  r.delete_flag=0\n" +
            "\t\tAND r.from_id = a.id\n" +
            "\t\tAND r.to_type = 'DEVICE_SUPPLIER_TYPE'\n" +
            "\t\tAND r.relation_type_group = 'DEVICE_DEVICE_SUPPLIER_TYPE'\n" +
            "\t\tAND r.relation_type = 'DeviceToDeviceSupplierType'\n" +
            "\t) AS deviceSupplierTypeId \n" +
            "FROM\n" +
            "device AS a left join device_credentials dc on dc.device_id = a.id\n" +

            "where 1 = 1  and   a.delete_flag=0 \n";


    public static void main(String[] args) {
        System.out.println(QUERY_SQL);
    }

    public static final String QUERY_COUNT_SQL = "  SELECT\n" +
            "count(1)\n" +

            "FROM\n" +
            "device AS a left join device_credentials dc on dc.device_id = a.id\n" +
            "left join  attribute_kv k  on  k.entity_id=a.id and k.attribute_key='version' and   k.attribute_type='SHARED_SCOPE'  and k.entity_type='DEVICE'" +
            "where 1 = 1   and   a.delete_flag=0  ";

    public static final String QUERYToTag_SQL = "  SELECT\n" +
            "a.id id,\n" +
            "a.additional_info additionalInfo,\n" +
            "a.customer_id customerId,\n" +
            "a.type type,\n" +
            "a.`name` `name`,\n" +
            "a.search_text searchText,\n" +
            "dc.credentials_id credentialsId,\n" +
            "dc.credentials_type credentialsType,\n" +
            "a.tenant_id tenantId\n" +
            "FROM\n" +
            "device AS a left join device_credentials dc on dc.device_id = a.id\n" +
            " inner join  attribute_kv kv on kv.entity_id=a.id  and kv.entity_type='" + EntityType.DEVICE.name() + "' and kv.attribute_key='" + AttributeKeyType.TAG_IDS.name().toLowerCase() + "'" +
            "where 1 = 1  and   a.delete_flag=0 ";
    public static   final  String QUERYToASSET_SQL="SELECT\n" +
            "\td.id AS id ,\n" +
            "\td. NAME AS name ,\n" +
            "\td.type AS type\n" +
            "FROM\n" +
            "\tdevice d\n" +
            "LEFT JOIN relation r ON r.from_id = d.id\n" +
            "WHERE\n" +
            "\n" +
            " r.from_type = 'DEVICE'\n" +
            "AND r.to_type = 'ASSET'\n" +
            "AND r.relation_type_group = 'COMMON'\n" +
            "AND r.relation_type = 'CollectorToAsset' and  r.delete_flag=0";


    public static   final  String QUERY_TOASSET_TREE_SQL="SELECT   \n" +
            "        rr.from_id as parentId,\n" +
            "\td.id AS id ,\n" +
            "\td. NAME AS name ,\n" +
            "\td.type AS type\n" +
            "       \n" +
            "FROM\n" +
            "\tdevice d\n" +
            "LEFT JOIN relation r ON r.from_id = d.id\n" +
            "left join (select  * from  relation    where   from_type = 'DEVICE'\n" +
            "AND to_type = 'DEVICE'\n" +
            "AND relation_type_group = 'COMMON'\n" +
            "AND relation_type = 'Contains' and  delete_flag=0) rr  ON rr.to_id = r.from_id\n" +
            "\n" +
            "WHERE\n" +
            "\n" +
            " r.from_type = 'DEVICE'\n" +
            "AND r.to_type = 'ASSET'\n" +
            "AND r.relation_type_group = 'COMMON'\n" +
            "AND r.relation_type = 'CollectorToAsset' and   d.delete_flag=0 \n";

    private String id;
    private String parentId;
    private String additionalInfo;
    private String customerId;
    private String type;
    private String name;
    private String searchText;
    private String tenantId;
    private String typeName;

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public Integer getBrokerStatus() {
        return brokerStatus;
    }

    public void setBrokerStatus(Integer brokerStatus) {
        this.brokerStatus = brokerStatus;
    }

    private  Integer  brokerStatus;
    private String credentialsId;
    private String credentialsType;

    private Integer deviceSupplierTypeId;

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    private Integer version;

    public String getTypeName() {
        return DeviceType.gateway.name().equals(getType()) ? "网关" : "采集器";
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getCredentialsId() {
        return credentialsId;
    }

    public void setCredentialsId(String credentialsId) {
        this.credentialsId = credentialsId;
    }

    public String getCredentialsType() {
        return credentialsType;
    }

    public void setCredentialsType(String credentialsType) {
        this.credentialsType = credentialsType;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getDeviceSupplierTypeId() {
        return deviceSupplierTypeId;
    }

    public void setDeviceSupplierTypeId(Integer deviceSupplierTypeId) {
        this.deviceSupplierTypeId = deviceSupplierTypeId;
    }
}
