package com.example.aliyunserver.entity;

import java.util.Date;

/**
 * AssetPointEntity_HI Entity Object
 * Wed Jun 10 16:58:03 CST 2020  Auto Generate
 */

public class AssetPointEntity_HI{
    private Long id;
    private String pointName; //测点名称
    private String pointKey; //测点key
    private String pointProperty; //测点获取路径 比如：payload.person.age
    private String assetType; //所属资产类型
    private String tenantId; //租户id  \
	private String remark;
    private Date creationDate; //创建日期
    private Long createdBy; //创建人
    private Date lastUpdateDate; //更新日期
    private Long lastUpdatedBy; //更新人
    private Long lastUpdateLogin; //最后登录ID
    private Integer versionNum; //版本号
    private Long operatorUserId;
    private Boolean pointStatus;
	private Integer deleteFlag = 0; //删除标识 0表示未删除 1表示删除了

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

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public Long getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(Long lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public Long getLastUpdateLogin() {
		return lastUpdateLogin;
	}

	public void setLastUpdateLogin(Long lastUpdateLogin) {
		this.lastUpdateLogin = lastUpdateLogin;
	}

	public Integer getVersionNum() {
		return versionNum;
	}

	public void setVersionNum(Integer versionNum) {
		this.versionNum = versionNum;
	}

	public void setOperatorUserId(Long operatorUserId) {
		this.operatorUserId = operatorUserId;
	}

	public Boolean getPointStatus() {
		return pointStatus;
	}

	public void setPointStatus(Boolean pointStatus) {
		this.pointStatus = pointStatus;
	}

	public Integer getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public Long getOperatorUserId() {
		return operatorUserId;
	}

	@Override
	public String toString() {
		return "AssetPointEntity_HI{" +
				"id=" + id +
				", pointName='" + pointName + '\'' +
				", pointKey='" + pointKey + '\'' +
				", pointProperty='" + pointProperty + '\'' +
				", assetType='" + assetType + '\'' +
				", tenantId='" + tenantId + '\'' +
				", remark='" + remark + '\'' +
				", creationDate=" + creationDate +
				", createdBy=" + createdBy +
				", lastUpdateDate=" + lastUpdateDate +
				", lastUpdatedBy=" + lastUpdatedBy +
				", lastUpdateLogin=" + lastUpdateLogin +
				", versionNum=" + versionNum +
				", operatorUserId=" + operatorUserId +
				", pointStatus=" + pointStatus +
				", deleteFlag=" + deleteFlag +
				'}';
	}
}
