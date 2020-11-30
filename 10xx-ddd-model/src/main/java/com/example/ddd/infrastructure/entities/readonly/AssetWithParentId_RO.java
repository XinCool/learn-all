package com.example.ddd.infrastructure.entities.readonly;

import com.example.ddd.infrastructure.utils.enums.EntityType;
import com.example.ddd.infrastructure.utils.enums.RelationType;
import com.example.ddd.infrastructure.utils.enums.RelationTypeGroup;

import java.io.Serializable;

public class AssetWithParentId_RO implements Serializable {
    public static final String QUERY_SQL = " SELECT\n" +
            "\tr.from_id AS parentId,\n" +
            "\ta.id id,\n" +
            "\ta.additional_info additionalInfo,\n" +
            "\ta.customer_id customerId,\n" +
            "\ta.`name` `name`,\n" +
            "\ta.search_text searchText,\n" +
            "\ta.tenant_id tenantId,\n" +
            "\ta.type type \n" +
            "FROM\n" +
            "\tasset AS a\n" +
            "\tLEFT JOIN relation AS r ON r.to_id = a.id  and r.delete_flag=0\n" +
            "\tAND r.from_type = '" + EntityType.ASSET.name() + "' \n" +
            "\tAND r.to_type = '" + EntityType.ASSET.name() + "' \n" +
            "\tAND r.relation_type_group = '" + RelationTypeGroup.COMMON.name() + "' \n" +
            "\tAND r.relation_type = '" + RelationType.Contains.name() + "' \n" +
            "WHERE\n" +
            "\t 1=1   and a.delete_flag=0  ";


    public static final String QUERY_TENANT_SQL = "SELECT\n" +
            "\ta.id id ,\n" +
            "\ta.`name` `name` ,\n" +
            "\ta.type type\n" +
//            ",d.id  as deviceId,d.name as deviceName,d.type as deviceType\n" +
            "FROM\n" +
            "\tasset AS a\n" +
//            "left join   (select * from  relation  r  where r.to_type = 'ASSET' AND r.relation_type_group = 'COMMON' AND r.relation_type = 'CollectorToAsset' )  r \n" +
//            "on  a.id=r.to_Id\n" +
//            "left join device d on d.id=r.from_id \n" +
            "where    a.delete_flag=0 \n";
    public static final String QUERY_TENANT_COUNT_SQL = "SELECT\n" +
            "\tcount(1)\n" +
            "FROM\n" +
            "\tasset AS a\n" +
//            "left join   (select * from  relation  r  where r.to_type = 'ASSET' AND r.relation_type_group = 'COMMON' AND r.relation_type = 'CollectorToAsset' )  r \n" +
//            "on  a.id=r.to_Id\n" +
//            "left join device d on d.id=r.from_id \n" +
            "where    a.delete_flag=0 \n";
    public static final String QUERY_DEPT_SQL = "SELECT\n" +
            "\ta.id id ,\n" +
            "\ta.`name` `name` ,\n" +
            "\ta.type type\n" +
//            ",d.id  as deviceId,d.name as deviceName,d.type as deviceType\n" +
            "FROM\n" +
            "\tasset AS a\n" +
//            "left join   (select * from  relation  r  where r.to_type = 'ASSET' AND r.relation_type_group = 'COMMON' AND r.relation_type = 'CollectorToAsset' )  r \n" +
//            "on  a.id=r.to_Id\n" +
//            "left join device d on d.id=r.from_id\n " +
            "where    a.delete_flag=0 \n";
    public static final String QUERY_DEPT_COUNT_SQL = "SELECT\n" +
            "\tcount(1) \n" +

            "FROM\n" +
            "\tasset AS a\n"  +
//            "\nleft join   (select * from  relation  r  where r.to_type = 'ASSET' AND r.relation_type_group = 'COMMON' AND r.relation_type = 'CollectorToAsset' )  r \n" +
//            "on  a.id=r.to_Id\n" +
//            "left join device d on d.id=r.from_id\n" +
            " where   " +
            " a.delete_flag=0";

    public static final String QUERY_BY_CHILDREN_SQL = "SELECT\n" +
            "\td.id AS id ,\n" +
            "\td. NAME  as name  ,\n" +
            "\td.type  as type \n" +
            "\t\n" +
            "\n" +
            "FROM\n" +
            "\tasset d\n" +
            "WHERE\n" +
            " d.id IN(\n" +
            "\t(\n" +
            "\t\tSELECT\n" +
            "\t\t\tto_id\n" +
            "\t\tFROM\n" +
            "\t\t\trelation r\n" +
            "\t\tWHERE\n" +
            "\t\t\tr.from_type = 'ASSET' and  r.delete_flag=0\n" +
            "\t\tAND r.to_type = 'ASSET'\n" +
            "\t\tAND r.relation_type_group = 'COMMON'\n" +
            "\t\tAND r.relation_type = 'Contains'\n" +
            "\t\tAND r.from_id = ?\n" +
            "\t)\n" +
            ") and d.delete_flag=0\n" +
            "ORDER BY\n" +
            "\td.creation_date DESC";

    public static String QUERY_BY_ASSETBYDEVICE_SQL = " select r.from_id as deviceId,d.name,d.type as deviceType" +
            " from relation r \n" +
            " left join device d on r.from_id=d.id \n" +
            " where r.relation_type = '"+RelationType.CollectorToAsset.name()+"' and r.to_id =:toId ";


    private String id;
    private String additionalInfo;
    private String customerId;
    private String name;
    private String searchText;
    private String tenantId;
    private String type;
    private String parentId;
    private String deviceName;
    private String deviceId;
    private String deviceType;

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
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

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }
}
