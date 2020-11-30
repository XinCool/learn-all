package com.example.ddd.infrastructure.entities;

import com.alibaba.fastjson.annotation.JSONField;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * AssetTypeEntity_HI Entity Object
 * Wed Jun 10 16:58:02 CST 2020  Auto Generate
 */
@Entity
@Table(name="asset_type")
public class AssetTypeEntity_HI implements Serializable{
    private Long id;
    private String typeName; //类型名称
    private String typeCode; //类型编码 (名称全拼+租户id)
    private String tenantId; //租户ID 
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date creationDate; //创建日期
    private Long createdBy; //创建人
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date lastUpdateDate; //更新日期
    private Long lastUpdatedBy; //更新人
    private Long lastUpdateLogin; //最后登录ID
    private Integer versionNum; //版本号
    private Long operatorUserId;
	private Integer deleteFlag = 0; //删除标识 0表示未删除 1表示删除了
	/**
	 * 描述
	 */
	private String description;



	private Boolean typeStatus;


	public void setId(Long id) {
		this.id = id;
	}

	@Id
	@GenericGenerator(name = "redisGenerationId", strategy = "com.sie.iot.common.idgenerate.RedisGenerationId")
	@GeneratedValue(generator = "redisGenerationId")
	@Column(name="id", nullable=false, length=20)	
	public Long getId() {
		return id;
	}
	@Column(name = "description",nullable = true,length = 255)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	@Column(name="type_name", nullable=true, length=50)	
	public String getTypeName() {
		return typeName;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}

	@Column(name="type_code", nullable=true, length=255)	
	public String getTypeCode() {
		return typeCode;
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


	@Column(name="type_status", nullable=true, length=1)
	public Boolean getTypeStatus() {
		return typeStatus;
	}

	public void setTypeStatus(Boolean typeStatus) {
		this.typeStatus = typeStatus;
	}

	public void setVersionNum(Integer versionNum) {
		this.versionNum = versionNum;
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
	public void setDeleteFlag(Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	@Column(name="delete_flag", nullable=true, length=11)
	public Integer getDeleteFlag() {
		return deleteFlag;
	}
}
