package com.example.ddd.infrastructure.entities;

import com.alibaba.fastjson.annotation.JSONField;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * AssetPointEntity_HI Entity Object
 * Wed Jun 10 16:58:03 CST 2020  Auto Generate
 */
@Entity
@Table(name="asset_point")
public class AssetPointEntity_HI implements Serializable{
    private Long id;
    private String pointName; //测点名称
    private String pointKey; //测点key
    private String pointProperty; //测点获取路径 比如：payload.person.age
    private String assetType; //所属资产类型
    private String tenantId; //租户id  \
	private String remark;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date creationDate; //创建日期
    private Long createdBy; //创建人
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date lastUpdateDate; //更新日期
    private Long lastUpdatedBy; //更新人
    private Long lastUpdateLogin; //最后登录ID
    private Integer versionNum; //版本号
    private Long operatorUserId;
    private Boolean pointStatus;
	private Integer deleteFlag = 0; //删除标识 0表示未删除 1表示删除了

	public void setId(Long id) {
		this.id = id;
	}

	@Id
	@GenericGenerator(name = "idGenerator", strategy = "com.example.ddd.infrastructure.utils.id.CustomUUIDGenerator")
	@GeneratedValue(generator = "redisGenerationId")
	@Column(name="id", nullable=false, length=20)	
	public Long getId() {
		return id;
	}

	public void setPointName(String pointName) {
		this.pointName = pointName;
	}

	@Column(name="point_name", nullable=true, length=50)	
	public String getPointName() {
		return pointName;
	}

	public void setPointKey(String pointKey) {
		this.pointKey = pointKey;
	}

	@Column(name="point_key", nullable=true, length=50)	
	public String getPointKey() {
		return pointKey;
	}

	public String getRemark() {
		return remark;
	}

	@Column(name="remark", nullable=true, length=0)
	public void setRemark(String remark) {
		this.remark = remark;
	}

	public void setPointProperty(String pointProperty) {
		this.pointProperty = pointProperty;
	}

	@Column(name="point_property", nullable=true, length=255)	
	public String getPointProperty() {
		return pointProperty;
	}

	public void setAssetType(String assetType) {
		this.assetType = assetType;
	}

	@Column(name="asset_type", nullable=true, length=255)	
	public String getAssetType() {
		return assetType;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	@Column(name="tenant_id", nullable=true, length=31)	
	public String getTenantId() {
		return tenantId;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	@Column(name="creation_date", nullable=true, length=0)	
	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	@Column(name="created_by", nullable=true, length=20)	
	public Long getCreatedBy() {
		return createdBy;
	}

	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	@Column(name="last_update_date", nullable=true, length=0)	
	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdatedBy(Long lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	@Column(name="last_updated_by", nullable=true, length=20)	
	public Long getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdateLogin(Long lastUpdateLogin) {
		this.lastUpdateLogin = lastUpdateLogin;
	}

	@Column(name="last_update_login", nullable=true, length=20)	
	public Long getLastUpdateLogin() {
		return lastUpdateLogin;
	}

	public void setDeleteFlag(Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	@Column(name="delete_flag", nullable=true, length=11)
	public Integer getDeleteFlag() {
		return deleteFlag;
	}

	public void setVersionNum(Integer versionNum) {
		this.versionNum = versionNum;
	}


	@Column(name="point_status", nullable=true, length=1)
	public Boolean getPointStatus() {
		return pointStatus;
	}

	public void setPointStatus(Boolean pointStatus) {
		this.pointStatus = pointStatus;
	}

	@Version
	@Column(name="version_num", nullable=true, length=11)	
	public Integer getVersionNum() {
		return versionNum;
	}

	public void setOperatorUserId(Long operatorUserId) {
		this.operatorUserId = operatorUserId;
	}

	@Transient	
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
