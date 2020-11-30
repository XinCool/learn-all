package com.example.ddd.infrastructure.entities.readonly;

import com.sie.iot.platform.asset.model.utils.enums.EntityType;
import com.sie.iot.platform.asset.model.utils.enums.RelationType;
import com.sie.iot.platform.asset.model.utils.enums.RelationTypeGroup;

import java.io.Serializable;

public class AssetWithParentIdForSaiNa_RO implements Serializable {
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
            "\tLEFT JOIN relation AS r ON r.to_id = a.id  and  r.delete_flag=0\n" +
            "\tAND r.from_type = '"+EntityType.ASSET.name() +"' \n" +
            "\tAND r.to_type = '"+EntityType.ASSET.name()+"' \n" +
            "\tAND r.relation_type_group = '"+RelationTypeGroup.COMMON.name() +"' \n" +
            "\tAND r.relation_type = '"+RelationType.Contains.name() +"' \n" +
            "WHERE\n" +
            "\t 1=1  and a.delete_flag=0 \n";


    private String id;
    private String additionalInfo;
    private String customerId;
    private String name;
    private String searchText;
    private String tenantId;
    private String type;
    private String parentId;

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
