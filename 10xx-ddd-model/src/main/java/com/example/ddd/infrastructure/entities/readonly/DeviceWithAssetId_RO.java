package com.example.ddd.infrastructure.entities.readonly;

import com.example.ddd.infrastructure.utils.enums.EntityType;
import com.example.ddd.infrastructure.utils.enums.RelationType;
import com.example.ddd.infrastructure.utils.enums.RelationTypeGroup;

import java.io.Serializable;

public class DeviceWithAssetId_RO implements Serializable {
    public static final String QUERY_SQL = " SELECT\n" +
            "\td.id id,\n" +
            "\td.additional_info additionalInfo,\n" +
            "\td.customer_id customerId,\n" +
            "\td.type type,\n" +
            "\td.`name` `name`,\n" +
            "\td.search_text searchText,\n" +
            "\td.tenant_id tenantId,\n" +
            "\td.creation_date,\n" +
            "\td.created_by,\n" +
            "\td.last_update_date,\n" +
            "\td.last_updated_by,\n" +
            "\td.last_update_login,\n" +
            "\td.version_num,\n" +
            "\tr.to_id AS assetId \n" +
            "FROM\n" +
            "\tdevice AS d\n" +
            "\tLEFT JOIN relation AS r ON r.from_id = d.id  and r.delete_flag=0\n" +
            "\tAND r.from_type = '"+EntityType.DEVICE.name()+"' \n" +
            "\tAND r.to_type = '"+EntityType.ASSET.name() +"' \n" +
            "\tAND r.relation_type_group = '"+RelationTypeGroup.COMMON.name() +"' \n" +
            "\tAND r.relation_type = '"+RelationType.CollectorToAsset.name() +"' \n" +
            "WHERE\n" + "  1=1   and   d.delete_flag=0 ";
            //"\t d.type = '"+DeviceType.collector.name() +"' \n";
//            "\tAND r.to_id IS NOT NULL ";
    private String id;
    private String additionalInfo;
    private String customerId;
    private String type;
    private String name;
    private String searchText;
    private String tenantId;
    private String assetId;

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
