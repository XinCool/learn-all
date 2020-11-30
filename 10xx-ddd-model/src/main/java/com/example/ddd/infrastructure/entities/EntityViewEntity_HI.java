package com.example.ddd.infrastructure.entities;

import com.alibaba.fastjson.annotation.JSONField;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * EntityViewEntity_HI Entity Object
 * Fri Mar 27 15:41:17 CST 2020  Auto Generate
 */
@Entity
@Table(name="entity_view")
public class EntityViewEntity_HI implements Serializable{
    private String id;
    private String entityId;
    private String entityType;
    private String tenantId;
    private String customerId;
    private String type;
    private String name;
    private String keys;
    private Long startTs;
    private Long endTs;
    private String searchText;
    private String additionalInfo;
    private Long operatorUserId;

	public void setId(String id) {
		this.id = id;
	}

	@Id
	@GenericGenerator(name = "idGenerator", strategy = "com.example.ddd.infrastructure.utils.id.CustomUUIDGenerator")
	@GeneratedValue(generator = "idGenerator")
	@Column(name="id", nullable=false, length=31)
	public String getId() {
		return id;
	}

	public void setEntityId(String entityId) {
		this.entityId = entityId;
	}

	@Column(name="entity_id", nullable=true, length=31)	
	public String getEntityId() {
		return entityId;
	}

	public void setEntityType(String entityType) {
		this.entityType = entityType;
	}

	@Column(name="entity_type", nullable=true, length=255)	
	public String getEntityType() {
		return entityType;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	@Column(name="tenant_id", nullable=true, length=31)	
	public String getTenantId() {
		return tenantId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	@Column(name="customer_id", nullable=true, length=31)	
	public String getCustomerId() {
		return customerId;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name="type", nullable=true, length=255)	
	public String getType() {
		return type;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name="name", nullable=true, length=255)	
	public String getName() {
		return name;
	}

	public void setKeys(String keys) {
		this.keys = keys;
	}

	@Column(name="keys", nullable=true, length=0)	
	public String getKeys() {
		return keys;
	}

	public void setStartTs(Long startTs) {
		this.startTs = startTs;
	}

	@Column(name="start_ts", nullable=true, length=20)	
	public Long getStartTs() {
		return startTs;
	}

	public void setEndTs(Long endTs) {
		this.endTs = endTs;
	}

	@Column(name="end_ts", nullable=true, length=20)	
	public Long getEndTs() {
		return endTs;
	}

	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}

	@Column(name="search_text", nullable=true, length=255)	
	public String getSearchText() {
		return searchText;
	}

	public void setAdditionalInfo(String additionalInfo) {
		this.additionalInfo = additionalInfo;
	}

	@Column(name="additional_info", nullable=true, length=0)	
	public String getAdditionalInfo() {
		return additionalInfo;
	}

	public void setOperatorUserId(Long operatorUserId) {
		this.operatorUserId = operatorUserId;
	}

	@Transient	
	public Long getOperatorUserId() {
		return operatorUserId;
	}
	@JSONField(format="yyyy-MM-dd HH:mm:ss")
	private Date creationDate; //创建日期
	private Long createdBy; //创建人
	@JSONField(format="yyyy-MM-dd HH:mm:ss")
	private Date lastUpdateDate; //更新日期
	private Long lastUpdatedBy; //更新人
	private Long lastUpdateLogin; //最后登录ID
	private Integer versionNum; //版本号

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


	public void setVersionNum(Integer versionNum) {
		this.versionNum = versionNum;
	}

	@Version
	@Column(name="version_num", nullable=false, length=11)
	public Integer getVersionNum() {
		return versionNum;
	}
}
