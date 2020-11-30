package com.example.ddd.infrastructure.entities.readonly;

import java.io.Serializable;

public class AssetPointEntity_HI_RO implements Serializable {
    public static final String QUERY_BY_DEVICE_SQL = " \n" +
            "select kk.*,pa.attribute_key  as pointKey from (\n" +
            "  SELECT\n" +
            "\tp.id id ,\n" +
            "\tp.point_name pointName ,\n" +
            "\tp.point_property pointProperty ,\n" +
            "\tp.asset_type assetType ,\n" +
            "\tp.tenant_id tenantId ,\n" +
            "\tt.type_name assetName ,\n" +
            "\tp.point_status pointStatus ,\n" +
            "\tr.from_id AS deviceId \n" +

            "FROM\n" +
            "\tasset_point AS p\n" +
            "LEFT JOIN asset_type t ON t.type_code = p.asset_type\n" +
            "AND t.delete_flag = 0\n" +
            "LEFT JOIN asset a ON a.type = t.type_name\n" +
            "LEFT JOIN relation r ON r.to_id = a.id\n" +
            "\t\tAND r.to_type = 'ASSET'\n" +
            "\t\tAND r.from_type = 'DEVICE'\n" +
            "\t\tAND r.relation_type_group = 'COMMON'\n" +
            "\t\tAND r.relation_type = 'CollectorToAsset'\n" +
            "\t\tAND r.delete_flag = 0 \n" +
            "WHERE\n" +
            "\t1 = 1\n" +
            "AND p.delete_flag = 0\n" +
            "and t.type_name=?  and  p.point_status=true  and a.id=?\n" +
            ") as kk \n" +
            "left JOIN iot_base_payload pa ON id = pa.asset_point_id\n" +
            "left  JOIN device_supplier_type dt ON pa.device_supplier_type_id = dt.id\n" +
            "WHERE\n" +
            "\tdt.id =(\n" +
            "\t\tSELECT\n" +
            "\t\t\tto_id\n" +
            "\t\tFROM\n" +
            "\t\t\trelation r\n" +
            "\t\tWHERE\n" +
            "\t\t\tr.to_type = 'DEVICE_SUPPLIER_TYPE'\n" +
            "\t\tAND r.from_type = 'DEVICE'\n" +
            "\t\tAND r.relation_type = 'DeviceToDeviceSupplierType'\n" +
            "\t\tAND r.relation_type_group = 'DEVICE_DEVICE_SUPPLIER_TYPE'\n" +
            "\t\tAND r.from_id = kk.deviceId  and r.delete_flag=0\n" +
            "\t)\n" +
            "     or pa.payload_id is null";



    public static final String QUERY_SINGLE_POINT_SQL = " \n" +
            "select kk.*,pa.attribute_key  as pointKey from (\n" +
            "  SELECT\n" +
            "\tp.id id ,\n" +
            "\tp.point_name pointName ,\n" +
            "\tp.point_property pointProperty ,\n" +
            "\tp.asset_type assetType ,\n" +
            "\tp.tenant_id tenantId ,\n" +
            "\tt.type_name assetName ,\n" +
            "\tp.point_status pointStatus ,\n" +
            "\tr.from_id AS deviceId \n" +

            "FROM\n" +
            "\tasset_point AS p\n" +
            "LEFT JOIN asset_type t ON t.type_code = p.asset_type\n" +
            "AND t.delete_flag = 0\n" +
            "LEFT JOIN asset a ON a.type = t.type_name\n" +
            "LEFT JOIN relation r ON r.to_id = a.id\n" +
            "\t\tAND r.to_type = 'ASSET'\n" +
            "\t\tAND r.from_type = 'DEVICE'\n" +
            "\t\tAND r.relation_type_group = 'COMMON'\n" +
            "\t\tAND r.relation_type = 'CollectorToAsset'\n" +
            "\t\tAND r.delete_flag = 0 \n" +
            "WHERE\n" +
            "\t1 = 1\n" +
            "AND p.delete_flag = 0\n" +
            "and t.type_name=?  and  p.point_status=true  and a.id=?\n" +
            ") as kk \n" +
            "left JOIN iot_base_payload pa ON id = pa.asset_point_id\n" +
            "left  JOIN device_supplier_type dt ON pa.device_supplier_type_id = dt.id\n" +
            "WHERE\n" +
            "\tdt.id =(\n" +
            "\t\tSELECT\n" +
            "\t\t\tto_id\n" +
            "\t\tFROM\n" +
            "\t\t\trelation r\n" +
            "\t\tWHERE\n" +
            "\t\t\tr.to_type = 'DEVICE_SUPPLIER_TYPE'\n" +
            "\t\tAND r.from_type = 'DEVICE'\n" +
            "\t\tAND r.relation_type = 'DeviceToDeviceSupplierType'\n" +
            "\t\tAND r.relation_type_group = 'DEVICE_DEVICE_SUPPLIER_TYPE'\n" +
            "\t\tAND r.from_id = kk.deviceId  and r.delete_flag=0\n" +
            "\t)\n";


    public static final String QUERY_SQL = " SELECT\n" +
            "p.id id,\n" +
            "p.point_name pointName,\n" +
            "p.point_key pointKey,\n" +
            "p.point_property pointProperty,\n" +
            "p.asset_type assetType,\n" +
            "p.tenant_id tenantId,\n" +
            "t.type_name assetName,\n" +
            "p.point_status pointStatus\n" +
            "FROM\n" +
            "asset_point AS p\n" +
            "left join asset_type t  on  t.type_code = p.asset_type   and t.delete_flag=0 \n" +
            "where 1 = 1  and p.delete_flag=0   \n  ";


    public static final String COUNT_SQL = "SELECT\n" +
            "\tcount(a.id) \n" +
            "  \n" +
            "FROM\n" +
            "\tasset_point a ,\n" +
            "\tiot_base_payload p\n" +
            "WHERE\n" +
            "\ta.id = p.asset_point_id\n" +

            "and a.delete_flag=0\n" +
            "and p.delete_flag=0\n";


    private Long id;
    private String pointName; //测点名称
    private String pointKey; //测点key
    private String pointProperty; //测点获取路径 比如：payload.person.age
    private String assetType; //所属资产类型
    private String tenantId; //租户id
    private Boolean pointStatus;
    private String assetName; //资产类型名称
    private String deviceId;

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPointName() {
        return pointName;
    }

    public void setPointName(String pointName) {
        this.pointName = pointName;
    }

    public String getPointKey() {
        return pointKey;
    }

    public void setPointKey(String pointKey) {
        this.pointKey = pointKey;
    }

    public String getPointProperty() {
        return pointProperty;
    }

    public void setPointProperty(String pointProperty) {
        this.pointProperty = pointProperty;
    }

    public String getAssetType() {
        return assetType;
    }

    public void setAssetType(String assetType) {
        this.assetType = assetType;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public Boolean getPointStatus() {
        return pointStatus;
    }

    public void setPointStatus(Boolean pointStatus) {
        this.pointStatus = pointStatus;
    }

    public String getAssetName() {
        return assetName;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }
}
