package com.example.ddd.infrastructure.entities.readonly;

import java.io.Serializable;

public class AssetEntity_HI_RO implements Serializable {
    public static final String QUERY_SQL = " SELECT\n" +
            "a.id id,\n" +
            "a.additional_info additionalInfo,\n" +
            "a.customer_id customerId,\n" +
            "a.`name` `name`,\n" +
            "a.search_text searchText,\n" +
            "a.tenant_id tenantId,\n" +
            "a.type type\n" +
            "FROM\n" +
            "asset AS a where 1 = 1  and a.delete_flag=0  \n  ";

    public static void main(String[] args) {
        System.out.println(QUERY_SQL);
    }
    private String id;
    private String additionalInfo;
    private String customerId;
    private String name;
    private String searchText;
    private String tenantId;
    private String type;

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
}
