package com.example.ddd.dto;
import com.sie.iot.common.bean.ReqeustCommonDataBean;

import java.util.List;

public class DeviceBean extends ReqeustCommonDataBean{
    private String id;
    private String additionalInfo;
    private String customerId;
    private String type;
    private String name;
    private String searchText;
    private String tenantId;
    private String keyword;
    //查询直属下级 设备列表
    private String fromId;
    private Integer deviceTypeId;

    private String attributeKey;
    private Object attributeValue;

    public String getAttributeKey() {
        return attributeKey;
    }

    public void setAttributeKey(String attributeKey) {
        this.attributeKey = attributeKey;
    }

    public Object getAttributeValue() {
        return attributeValue;
    }

    public void setAttributeValue(Object attributeValue) {
        this.attributeValue = attributeValue;
    }

    private Integer deviceSupplierTypeId;

    public Integer getDeviceSupplierTypeId() {
        return deviceSupplierTypeId;
    }

    public void setDeviceSupplierTypeId(Integer deviceSupplierTypeId) {
        this.deviceSupplierTypeId = deviceSupplierTypeId;
    }

    //关联资产
    private String assetId;


    public String getScopeDataSql() {
        return scopeDataSql;
    }

    public void setScopeDataSql(String scopeDataSql) {
        this.scopeDataSql = scopeDataSql;
    }

    public String getSaiNaProvince() {
        return saiNaProvince;
    }

    public void setSaiNaProvince(String saiNaProvince) {
        this.saiNaProvince = saiNaProvince;
    }

    public String getSaiNaCity() {
        return saiNaCity;
    }

    public void setSaiNaCity(String saiNaCity) {
        this.saiNaCity = saiNaCity;
    }

    public String getSaiNaDistrict() {
        return saiNaDistrict;
    }

    public void setSaiNaDistrict(String saiNaDistrict) {
        this.saiNaDistrict = saiNaDistrict;
    }

    public String getSaiNaHospital() {
        return saiNaHospital;
    }

    public void setSaiNaHospital(String saiNaHospital) {
        this.saiNaHospital = saiNaHospital;
    }

    //塞纳特有字段
    private String scopeDataSql;

    private String saiNaProvince;
    private String saiNaCity;
    private String saiNaDistrict;
    private String saiNaHospital;

    public String getBrokerId() {
        return brokerId;
    }

    public void setBrokerId(String brokerId) {
        this.brokerId = brokerId;
    }

    /**
     *
     关联br0ker
     */
    private String brokerId;
    private List<AttributeKvBean> attributes;
    private String fromIdAndOwn;


    public String getAssetId() {
        return assetId;
    }

    public void setAssetId(String assetId) {
        this.assetId = assetId;
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

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getFromId() {
        return fromId;
    }

    public void setFromId(String fromId) {
        this.fromId = fromId;
    }

    public List<AttributeKvBean> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<AttributeKvBean> attributes) {
        this.attributes = attributes;
    }

    public String getFromIdAndOwn() {
        return fromIdAndOwn;
    }

    public void setFromIdAndOwn(String fromIdAndOwn) {
        this.fromIdAndOwn = fromIdAndOwn;
    }

    public Integer getDeviceTypeId() {
        return deviceTypeId;
    }

    public void setDeviceTypeId(Integer deviceTypeId) {
        this.deviceTypeId = deviceTypeId;
    }
}
