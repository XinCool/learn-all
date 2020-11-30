package com.example.ddd.infrastructure.entities.readonly;

import com.sie.iot.platform.asset.model.utils.enums.DeviceType;
import com.sie.iot.platform.asset.model.utils.enums.EntityType;
import com.sie.iot.platform.asset.model.utils.enums.RelationType;
import com.sie.iot.platform.asset.model.utils.enums.RelationTypeGroup;

import java.io.Serializable;

public class DeviceWithParentId_RO implements Serializable {
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
            "\tdevice AS a\n" +
            "\tLEFT JOIN relation AS r ON r.to_id = a.id   and r.delete_flag=0\n" +
            "\tAND r.from_type = '" + EntityType.DEVICE.name() + "' \n" +
            "\tAND r.to_type = '" + EntityType.DEVICE.name() + "' \n" +
            "\tAND r.relation_type_group = '" + RelationTypeGroup.COMMON.name() + "' \n" +
            "\tAND r.relation_type = '" + RelationType.Contains.name() + "' \n" +
            "WHERE\n" +
            "\t 1=1  and a.delete_flag=0   \n";


    public static final String QUERY_BYTENET_SQL = "SELECT\n" +
            " d.id  as id,d.name as deviceName,d.type as deviceType,a.name  AS assetName,a.id as assetId ,d.type as type ,a.type as assetType \n" +
            "FROM\n" +
            " device d\n" +

            "left join   (select * from  relation  r  where r.to_type = 'ASSET'  and r.delete_flag=0 AND r.relation_type_group = 'COMMON' AND r.relation_type = 'CollectorToAsset' )  r \n" +
            "on d.id =r.from_id\n" +
            "left join asset a on a.id=r.to_id\n" +
            "WHERE\n" +
            "   d.delete_flag=0  \n";

    public static final String QUERY_BYTENET_COUNT_SQL = "SELECT\n" +
            "  count(1)\n" +
            "FROM\n" +
            " device d\n" +

            "left join   (select * from  relation  r  where r.to_type = 'ASSET' and r.delete_flag=0 AND r.relation_type_group = 'COMMON' AND r.relation_type = 'CollectorToAsset' )  r \n" +
            "on d.id =r.from_id\n" +
            "left join asset a on a.id=r.to_id\n" +
            "WHERE\n" +
            "   d.delete_flag=0  \n";


    public static final String QUERY_BY_DEPT_SQL = "SELECT\n" +
            " d.id  as  id,d.name as deviceName,d.type as deviceType,a.name  AS assetName,a.id as assetId ,d.type as type ,a.type as assetType\n" +
            "FROM\n" +
            " device d\n" +
            "left join   (select * from  relation  r  where r.to_type = 'ASSET' and r.delete_flag=0 AND r.relation_type_group = 'COMMON' AND r.relation_type = 'CollectorToAsset' )  r \n" +
            "on d.id =r.from_id\n" +
            "left join asset a on a.id=r.to_id\n" +
            "WHERE\n" +
            "   d.delete_flag=0  \n";


    public static final String QUERY_BY_DEPT_COUNT_SQL = "SELECT\n" +
            "  count(1)\n" +
            "FROM\n" +
            " device d\n" +
            "left join   (select * from  relation  r  where r.to_type = 'ASSET'  and r.delete_flag=0 AND r.relation_type_group = 'COMMON' AND r.relation_type = 'CollectorToAsset' )  r \n" +
            "on d.id =r.from_id\n" +
            "left join asset a on a.id=r.to_id\n" +
            "WHERE\n" +
            "d.delete_flag=0 \n";


    public static final String QUERY_BY_CHILDREN_SQL = " SELECT\n" +
            "\td.id as id ,\n" +
            "\td. NAME AS deviceName ,\n" +
            "\td.type AS deviceType ,\n" +
            "\ta. NAME AS assetName ,\n" +
            "\ta.id AS assetId  ,d.type as type ,a.type as assetType\n" +

            "FROM\n" +
            "\tdevice d\n" +
            "LEFT JOIN(\n" +
            "\tSELECT\n" +
            "\t\t*\n" +
            "\tFROM\n" +
            "\t\trelation r\n" +
            "\tWHERE\n" +
            "\t\tr.to_type = 'ASSET'  and r.delete_flag=0\n" +
            "\tAND r.relation_type_group = 'COMMON'\n" +
            "\tAND r.relation_type = 'CollectorToAsset'\n" +
            ") r ON d.id = r.from_id\n" +
            "LEFT JOIN asset a ON a.id = r.to_id\n" +
            "WHERE   1=1  and   d.delete_flag=0 \n";


    public static final String COUNT_SQL = " SELECT\n" +
            " count(1)" +
            "FROM\n" +
            "\tdevice AS a\n" +

            "WHERE\n" +
            "\t 1=1   " +
            "  and   a.delete_flag=0 \n";


    public static final String COUNT_SQL_NOT_GATEWAY = " SELECT\n" +
            " count(1)" +
            "FROM\n" +
            "\tdevice AS a\n" +

            "WHERE\n" +
            "\t 1=1   " +
            "  and   a.delete_flag=0 \n";




    private String id;
    private String additionalInfo;
    private String customerId;
    private String type;
    private String assetType;
    private String deviceType;
    public static void main(String[] args) {
        System.out.println(COUNT_SQL);
    }
    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getAssetType() {
        return assetType;
    }

    public void setAssetType(String assetType) {
        this.assetType = assetType;
    }

    private String name;
    private String searchText;
    private String tenantId;
    private String parentId;

    private String assetName;
    private String assetId;
    private String deviceId;
    private String deviceName;


    public String getAssetName() {
        return assetName;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }

    public String getAssetId() {
        return assetId;
    }

    public void setAssetId(String assetId) {
        this.assetId = assetId;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
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
